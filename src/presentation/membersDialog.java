/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataAccessorFile;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import logic.Member;

/**
 *
 * @author Vics
 */
public class membersDialog extends javax.swing.JDialog {

    /**
     * Creates new form membersDialog
     */
    private boolean isEdit = false;
    private int currentID;
    DataAccessorFile data = new DataAccessorFile();
    
    public membersDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        initComponents();
        errorTXT.setText("");
    }

    public void readyEdit(Member member){
        isEdit = true;
        currentID = member.getID();
        nameTXT.setText(member.getName());
        emailTXT.setText(member.getEmail());
        birthdayTXT.setText(""+member.getBirthday());
        activeCHECK.setSelected(member.isActive());
        eliteCHECK.setSelected(member.isElite());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        activeCHECK = new javax.swing.JCheckBox();
        eliteCHECK = new javax.swing.JCheckBox();
        nameTXT = new javax.swing.JTextField();
        emailTXT = new javax.swing.JTextField();
        birthdayTXT = new javax.swing.JTextField();
        saveBTN = new javax.swing.JButton();
        errorTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Navn:");

        jLabel2.setText("Email:");

        jLabel3.setText("Fødselsdag:");

        activeCHECK.setSelected(true);
        activeCHECK.setText("Aktiv");

        eliteCHECK.setText("Konkurrencesvømmer");

        saveBTN.setText("Gem");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        errorTXT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        errorTXT.setText("errorTxt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeCHECK)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(birthdayTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eliteCHECK)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(errorTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBTN)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {birthdayTXT, emailTXT, nameTXT});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(birthdayTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeCHECK)
                    .addComponent(eliteCHECK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBTN)
                    .addComponent(errorTXT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {birthdayTXT, emailTXT, nameTXT});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
        if(isEdit){
            try{
            LocalDate date = LocalDate.parse(birthdayTXT.getText());
            data.editMember(new Member(
            currentID,
            nameTXT.getText(),
            emailTXT.getText(),
            date,
            activeCHECK.isSelected(),
            eliteCHECK.isSelected()
            ));
            dispose();
            } catch(DateTimeParseException e){
                errorTXT.setText("Fejl i fødselsdag..");
            } catch(Exception e){
                errorTXT.setText("Der skete en fejl..");
            }
        } else {
            try{
            LocalDate date = LocalDate.parse(birthdayTXT.getText());
            data.createMember(new Member(
            nameTXT.getText(),
            emailTXT.getText(),
            date,
            activeCHECK.isSelected(),
            eliteCHECK.isSelected()
            ));
            dispose();
            } catch(DateTimeParseException e){
                errorTXT.setText("Fejl i fødselsdag..");
            } catch(Exception e){
                errorTXT.setText("Der skete en fejl..");
            }
        }
    }//GEN-LAST:event_saveBTNActionPerformed

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
            java.util.logging.Logger.getLogger(membersDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(membersDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(membersDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(membersDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                membersDialog dialog = new membersDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox activeCHECK;
    private javax.swing.JTextField birthdayTXT;
    private javax.swing.JCheckBox eliteCHECK;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JLabel errorTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JButton saveBTN;
    // End of variables declaration//GEN-END:variables
}
