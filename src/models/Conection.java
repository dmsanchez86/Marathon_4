package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * @author Mauro
 */
public class Conection {
    protected Connection conection;
    protected ResultSet data;
    protected PreparedStatement query;
    
    public boolean conect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost/marathon","root","");
            System.out.println("Conected to database!");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public ResultSet getMarathons(){
        try {
            query = conection.prepareStatement("SELECT * FROM marathon");
            data = query.executeQuery();
            
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int getCountMarathons(){
        int numbers = 0;
        
        try {
            query = conection.prepareStatement("SELECT Count(*) FROM marathon");
            data = query.executeQuery();
            
            while(data.next()){
                numbers = data.getInt(1);
            }
            
            return numbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public ResultSet getRaceEvents(int idMarathon) {
        try {
            query = conection.prepareStatement("SELECT * FROM event WHERE MarathonId = ?");
            query.setInt(1, idMarathon);
            data = query.executeQuery();
            
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int getCountRaceEvents(int idMarathon){
        int numbers = 0;
        
        try {
            query = conection.prepareStatement("SELECT COUNT(*) FROM event WHERE MarathonId = ?");
            query.setInt(1, idMarathon);
            
            data = query.executeQuery();
            
            while(data.next()){
                numbers = data.getInt(1);
            }
            
            return numbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public ResultSet getGenders() {
        try {
            query = conection.prepareStatement("SELECT * FROM gender");
            data = query.executeQuery();
            
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResultSet getPreviusResultRaceRunner(int idMarathon, String idRaceEvent, String gender) {
        try {
            
            if("Any".equals(gender)){
                query = conection.prepareStatement(""
                    +   "SELECT * \n" +
                        "FROM registration r\n" +
                        "INNER JOIN runner ru ON r.RunnerId = ru.RunnerId\n" +
                        "INNER JOIN country cou ON ru.CountryCode = cou.CountryCode\n" +
                        "INNER JOIN user u ON ru.Email = u.Email\n" +
                        "INNER JOIN gender g ON ru.Gender = g.Gender\n" +
                        "INNER JOIN registrationevent re ON r.RegistrationId = re.RegistrationId\n" +
                        "INNER JOIN event e ON re.EventId = e.EventId\n" +
                        "INNER JOIN marathon m ON e.MarathonId = m.MarathonId\n" +
                        "WHERE m.MarathonId = ? AND e.EventId = ? AND re.RaceTime != 0 ORDER BY re.RaceTime ASC"
                    + "");
            }else{
                query = conection.prepareStatement(""
                    +   "SELECT * \n" +
                        "FROM registration r\n" +
                        "INNER JOIN runner ru ON r.RunnerId = ru.RunnerId\n" +
                        "INNER JOIN country cou ON ru.CountryCode = cou.CountryCode\n" +
                        "INNER JOIN user u ON ru.Email = u.Email\n" +
                        "INNER JOIN gender g ON ru.Gender = g.Gender\n" +
                        "INNER JOIN registrationevent re ON r.RegistrationId = re.RegistrationId\n" +
                        "INNER JOIN event e ON re.EventId = e.EventId\n" +
                        "INNER JOIN marathon m ON e.MarathonId = m.MarathonId\n" +
                        "WHERE m.MarathonId = ? AND e.EventId = ? AND g.Gender = ? AND re.RaceTime != 0 ORDER BY re.RaceTime ASC"
                    + "");
                query.setString(3, gender);
            }
            
            query.setInt(1, idMarathon);
            query.setString(2, idRaceEvent);
            
            data = query.executeQuery();
            
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
