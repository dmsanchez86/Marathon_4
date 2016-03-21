package views;

import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Conection;

/*
 * @author Mauro
 */
public class My_Sponsorship extends javax.swing.JFrame {

    Conection c;
    DefaultComboBoxModel combo;
    String[] idsRunners;
    
    String idRunner;
    
    public My_Sponsorship() {
        initComponents();
        
        c = new Conection();
        c.conect();
        
        combo = new DefaultComboBoxModel();
        combo.addElement("Select Runner");
        
        int numberRunners = c.getCountRunners();
        ResultSet dataRunners = c.getRunners();
        
        idsRunners = new String[numberRunners];
        
        int countRunner = 0;
        
        try {
            while(dataRunners.next()){
                idsRunners[countRunner] = dataRunners.getString("RunnerId");
                combo.addElement(dataRunners.getString("FirstName")+" "+dataRunners.getString("LastName")+" ("+dataRunners.getString("CountryCode")+")");
                countRunner++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        jcb_Runner.setModel(combo);
        
        panelCharityData.setVisible(false);
        panelSponsorships.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcb_Runner = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        panelCharityData = new javax.swing.JPanel();
        lbl_nameCharity = new javax.swing.JLabel();
        lbl_imageCharity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_descriptionCharity = new javax.swing.JTextArea();
        panelSponsorships = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaAmount = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marathon Skills 2016 - My Sponsorships");
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
                .addGap(166, 166, 166)
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
        jLabel4.setText("My Sponsorship");

        jLabel1.setText("Runner");

        jcb_Runner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_Runner.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_RunnerItemStateChanged(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("This shows all the sponsorship you have received for Marathon skills 2016");

        lbl_nameCharity.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_nameCharity.setForeground(new java.awt.Color(130, 130, 130));
        lbl_nameCharity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nameCharity.setText("Name Charity");

        lbl_imageCharity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_imageCharity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arise-logo.png"))); // NOI18N

        jta_descriptionCharity.setEditable(false);
        jta_descriptionCharity.setBackground(new java.awt.Color(204, 204, 204));
        jta_descriptionCharity.setColumns(20);
        jta_descriptionCharity.setLineWrap(true);
        jta_descriptionCharity.setRows(5);
        jta_descriptionCharity.setWrapStyleWord(true);
        jta_descriptionCharity.setBorder(null);
        jScrollPane1.setViewportView(jta_descriptionCharity);

        javax.swing.GroupLayout panelCharityDataLayout = new javax.swing.GroupLayout(panelCharityData);
        panelCharityData.setLayout(panelCharityDataLayout);
        panelCharityDataLayout.setHorizontalGroup(
            panelCharityDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCharityDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCharityDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_nameCharity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(lbl_imageCharity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCharityDataLayout.setVerticalGroup(
            panelCharityDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCharityDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nameCharity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_imageCharity, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaAmount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtaAmount);

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(130, 130, 130));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total $0");

        javax.swing.GroupLayout panelSponsorshipsLayout = new javax.swing.GroupLayout(panelSponsorships);
        panelSponsorships.setLayout(panelSponsorshipsLayout);
        panelSponsorshipsLayout.setHorizontalGroup(
            panelSponsorshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSponsorshipsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSponsorshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSponsorshipsLayout.setVerticalGroup(
            panelSponsorshipsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSponsorshipsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jcb_Runner, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(panelCharityData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelSponsorships, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(240, 240, 240))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcb_Runner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSponsorships, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCharityData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_RunnerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_RunnerItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(jcb_Runner.getSelectedIndex() != 0){
                idRunner = idsRunners[jcb_Runner.getSelectedIndex() - 1];
                panelCharityData.setVisible(true);
                panelSponsorships.setVisible(true);
                
                String[] dataCharity = c.getDataCharityByRunner(idRunner);
                
                try{
                    lbl_nameCharity.setText(dataCharity[0]);
                    lbl_imageCharity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/"+dataCharity[1])));
                    jta_descriptionCharity.setText(dataCharity[2]);
                    
                    
                    DefaultTableModel table = new DefaultTableModel();

                    table.addColumn("Sponsor");
                    table.addColumn("Amount");

                    Object[] objSponsors = c.getSponsorships(idRunner);

                    ResultSet dataSponsors = (ResultSet) objSponsors[0];

                    try {
                        while(dataSponsors.next()){
                            Object[] row = new Object[2];
                            row[0] = dataSponsors.getString("SponsorName");
                            row[1] = "$"+dataSponsors.getString("Amount");
                            table.addRow(row);
                        }

                        jtaAmount.setModel(table);

                        lblTotal.setText("Total: $"+objSponsors[1].toString());
                    } catch (Exception e) {
                        lblTotal.setText("Total: $0");
                        JOptionPane.showMessageDialog(this, "The runner have not Sponsorships", "Marathon Skills 2016", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception e){
                    panelCharityData.setVisible(false);
                    panelSponsorships.setVisible(false);
                    JOptionPane.showMessageDialog(this, "The runner have not charity", "Marathon Skills 2016", JOptionPane.WARNING_MESSAGE);
                }                
            }else{
                panelCharityData.setVisible(false);
                panelSponsorships.setVisible(false);
            }
            
        }
    }//GEN-LAST:event_jcb_RunnerItemStateChanged

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
            java.util.logging.Logger.getLogger(My_Sponsorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(My_Sponsorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(My_Sponsorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(My_Sponsorship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new My_Sponsorship().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcb_Runner;
    private javax.swing.JTable jtaAmount;
    private javax.swing.JTextArea jta_descriptionCharity;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbl_imageCharity;
    private javax.swing.JLabel lbl_nameCharity;
    private javax.swing.JPanel panelCharityData;
    private javax.swing.JPanel panelSponsorships;
    // End of variables declaration//GEN-END:variables
}