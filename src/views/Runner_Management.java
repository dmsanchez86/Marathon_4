package views;

import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import models.Conection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * @author Mauro
 */
public class Runner_Management extends javax.swing.JFrame {

    DefaultTableModel table;
    Conection c;
    
    String[] idsStatus; 
    String[] idsRaceEvents; 
    
    String idStatus;
    String idRaceEvent;
    
    public Runner_Management() {
        initComponents();
        
        jmiEdit.setText("Edit Runner");
        
        c = new Conection();
        c.conect();
        
        table = new DefaultTableModel();
        
        table.addColumn("First Name");
        table.addColumn("Last Name");
        table.addColumn("Email");
        table.addColumn("Status");
        
        ResultSet dataRunners = c.getDataRunnersMarathon(5);
        
        try {
            while(dataRunners.next()){
                Object[] row = new Object[4];
                
                row[0] = dataRunners.getString("FirstName");
                row[1] = dataRunners.getString("LastName");
                row[2] = dataRunners.getString("Email");
                row[3] = dataRunners.getString("RegistrationStatus");
                
                table.addRow(row);
            }
            
            jtaResults.setModel(table);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        combo.addElement("Select Status");
        
        int numberStatus = c.getCountStatus();
        ResultSet dataStatus = c.getStatus();
        idsStatus = new String[numberStatus];
        
        int countStatus = 0;
        
        try {
            while(dataStatus.next()){
                idsStatus[countStatus] = dataStatus.getString("RegistrationStatusId"); 
                combo.addElement(dataStatus.getString("RegistrationStatus"));
                countStatus++;
            }
            
            jcbStatus.setModel(combo);
        } catch (Exception e) {}
        
        DefaultComboBoxModel comboRace = new DefaultComboBoxModel();
        
        comboRace.addElement("Select Race Event");
        
        int numberRaceEvents = c.getCountEventTypes();
        ResultSet dataRaceEvents = c.getEventTypes();
        idsRaceEvents = new String[numberRaceEvents];
        
        int countRaceEvent = 0;
        
        try {
            while(dataRaceEvents.next()){
                idsRaceEvents[countRaceEvent] = dataRaceEvents.getString("EventTypeId");
                comboRace.addElement(dataRaceEvents.getString("EventTypeName"));
                countRaceEvent++;
            }
            
            jcbRaceEvent.setModel(comboRace);
        } catch (Exception e) {}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmiEdit = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox();
        jcbRaceEvent = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        btnExports = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResults = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();

        jmiEdit.setText("jMenuItem1");
        jmiEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmiEdit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marathon Skills 2016 - Runner Management");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MARATHON SKILLS 2016");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(130, 130, 130));
        jLabel4.setText("Runner Management");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(130, 130, 130));
        jLabel1.setText("Sort and Filter");

        jLabel2.setText("Status");

        jLabel5.setText("Race Event");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbStatusItemStateChanged(evt);
            }
        });

        jcbRaceEvent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbRaceEvent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbRaceEventItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(130, 130, 130));
        jLabel6.setText("Export");

        btnExports.setText("Runner Details ( PDF )");
        btnExports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportsActionPerformed(evt);
            }
        });

        jtaResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtaResults.setComponentPopupMenu(jPopupMenu1);
        jtaResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtaResultsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtaResults);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch)
                            .addComponent(jcbStatus, 0, 152, Short.MAX_VALUE)
                            .addComponent(jcbRaceEvent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExports)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6)
                        .addGap(51, 51, 51)))
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExports))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbRaceEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiEditActionPerformed

    private void jtaResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaResultsMouseClicked
        // TODO add your handling code here:
        jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        jPopupMenu1.setVisible(true);
    }//GEN-LAST:event_jtaResultsMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(jcbStatus.getSelectedIndex() == 0 && jcbRaceEvent.getSelectedIndex() == 0){  
            JOptionPane.showMessageDialog(this, "Select first one status or Race Event");
        }else{
            int a = jtaResults.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                table.removeRow(i);
            }
            
            ResultSet dataRunners = c.getDataRunnersMarathonFilter(idStatus, idRaceEvent);

            try {
                while(dataRunners.next()){
                    Object[] row = new Object[4];

                    row[0] = dataRunners.getString("FirstName");
                    row[1] = dataRunners.getString("LastName");
                    row[2] = dataRunners.getString("Email");
                    row[3] = dataRunners.getString("RegistrationStatus");

                    table.addRow(row);
                }

                jtaResults.setModel(table);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jcbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbStatusItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(jcbStatus.getSelectedIndex() != 0){  
                idStatus = idsStatus[jcbStatus.getSelectedIndex() - 1];
            }else{
                idStatus = null;
            }
        }
    }//GEN-LAST:event_jcbStatusItemStateChanged

    private void jcbRaceEventItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbRaceEventItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(jcbRaceEvent.getSelectedIndex() != 0){  
                idRaceEvent = idsRaceEvents[jcbRaceEvent.getSelectedIndex() - 1];
            }else{
                idRaceEvent = null;
            }
        }
    }//GEN-LAST:event_jcbRaceEventItemStateChanged

    private void btnExportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportsActionPerformed
        // TODO add your handling code here:
        JasperViewer jv;
        
        String path = "/reports/reportRunnersMarathon.jasper";
        JasperReport jr;
        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, c.getConection());
            jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Report");
            jv.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnExportsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Runner_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Runner_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Runner_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Runner_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Runner_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExports;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbRaceEvent;
    private javax.swing.JComboBox jcbStatus;
    private javax.swing.JMenuItem jmiEdit;
    private javax.swing.JTable jtaResults;
    // End of variables declaration//GEN-END:variables

    private void formatTable(JTable jtaResults) {
        
    }
}
