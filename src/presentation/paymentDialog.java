package presentation;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logic.Controller;
import logic.Member;
import logic.Payment;

/**
 *
 * @author caspe
 */
public class paymentDialog extends javax.swing.JDialog {

    Controller logic = new Controller();

    public paymentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        fillYearComboBox();
        
    }
    
    private void fillYearComboBox(){
        int currentYear = LocalDate.now().getYear();
        for(int i = currentYear -10;i<currentYear+6;i++){
            yearCB.addItem(String.valueOf(i));
        }
        yearCB.setSelectedItem(String.valueOf(currentYear));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yearLBL = new javax.swing.JLabel();
        createPaymentBTN = new javax.swing.JButton();
        amountLBL = new javax.swing.JLabel();
        amountTXT = new javax.swing.JTextField();
        searchBTN = new javax.swing.JButton();
        emailTXT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        yearCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        yearLBL.setText("År");

        createPaymentBTN.setText("Opret betaling");
        createPaymentBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPaymentBTNActionPerformed(evt);
            }
        });

        amountLBL.setText("Beløb");

        searchBTN.setText("Søg email for medlem:");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Navn", "Email", "Fødselsdag"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        memberTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                memberTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(memberTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amountLBL)
                                    .addComponent(yearLBL))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(yearCB, 0, 154, Short.MAX_VALUE)
                                    .addComponent(amountTXT)))
                            .addComponent(createPaymentBTN))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBTN)
                    .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLBL)
                    .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(amountLBL)
                    .addComponent(amountTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createPaymentBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createPaymentBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPaymentBTNActionPerformed
        if(memberTable.getSelectionModel().isSelectionEmpty()){
            return;
        }
        
        try {
            int id = 0;
            int memberID = logic.memberList.get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow())).getID();
            String paymentYear = yearCB.getSelectedItem().toString();
            double amount = Double.parseDouble(amountTXT.getText());
            String date = LocalDate.now().toString();
            
            Payment payment = new Payment(id, memberID, paymentYear, amount, date);
            logic.createPayment(payment);
            
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(paymentDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createPaymentBTNActionPerformed

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        // TODO add your handling code here:
        try {
            logic.updateMemberList(emailTXT.getText());
            DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
            model.setRowCount(0);
            for (Member member : logic.memberList) {
                model.addRow(new Object[]{member.getName(), member.getEmail(), member.getBirthday()});
            }
        } catch (Exception e) {
            //"Kunne ikke indlæse medlemmer.."
        }
    }//GEN-LAST:event_searchBTNActionPerformed

    private void memberTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberTableMouseClicked
        // TODO add your handling code here:
        //
        if(!memberTable.getSelectionModel().isSelectionEmpty()){
            double amount = logic.getAmountToPay(logic.memberList.get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow())));
            amountTXT.setText(String.valueOf(amount));
        }
    }//GEN-LAST:event_memberTableMouseClicked

    
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
            java.util.logging.Logger.getLogger(paymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                paymentDialog dialog = new paymentDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLBL;
    private javax.swing.JTextField amountTXT;
    private javax.swing.JButton createPaymentBTN;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberTable;
    private javax.swing.JButton searchBTN;
    private javax.swing.JComboBox<String> yearCB;
    private javax.swing.JLabel yearLBL;
    // End of variables declaration//GEN-END:variables
}
