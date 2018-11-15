/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.Controller;
import logic.Member;

/**
 *
 * @author caspe
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    Controller logic = new Controller();
    
    public GUI() {
        initComponents();
        //
        setTitle("Svømmeklubben Delfinen");
        ImageIcon img = new ImageIcon("dolphin.png");
        this.setIconImage(img.getImage());
        memberTable.removeColumn(memberTable.getColumnModel().getColumn(0));
        
        //updateLabels();
        removeLabels();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        mainTabs = new javax.swing.JTabbedPane();
        adminPane = new javax.swing.JPanel();
        addMemberBTN = new javax.swing.JButton();
        editMemberBTN = new javax.swing.JButton();
        deleteMemberBTN = new javax.swing.JButton();
        memberTableScroll = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        getMembersBTN = new javax.swing.JButton();
        emailSearchBTN = new javax.swing.JButton();
        emailTXT = new javax.swing.JTextField();
        numberOfMembersLBL = new javax.swing.JLabel();
        numberOfActiveMembersLBL = new javax.swing.JLabel();
        numberOfNotActiveMembersLBL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        numberFactLBL = new javax.swing.JLabel();
        accountingPane = new javax.swing.JPanel();
        coachPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addMemberBTN.setText("Opret nyt medlem");
        addMemberBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberBTNActionPerformed(evt);
            }
        });

        editMemberBTN.setText("Rediger medlem");
        editMemberBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMemberBTNActionPerformed(evt);
            }
        });

        deleteMemberBTN.setText("Slet medlem");
        deleteMemberBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberBTNActionPerformed(evt);
            }
        });

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Navn", "Email", "Fødselsdag"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        memberTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        memberTableScroll.setViewportView(memberTable);

        getMembersBTN.setText("Se alle medlemmer");
        getMembersBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMembersBTNActionPerformed(evt);
            }
        });

        emailSearchBTN.setText("Søg mail:");
        emailSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailSearchBTNActionPerformed(evt);
            }
        });

        numberOfMembersLBL.setText("numberOfMembersLBL");

        numberOfActiveMembersLBL.setText("numberOfActiveMembersLBL");

        numberOfNotActiveMembersLBL.setText("numberOfNotActiveMembersLBL");

        numberFactLBL.setText("numberFactLBL");

        javax.swing.GroupLayout adminPaneLayout = new javax.swing.GroupLayout(adminPane);
        adminPane.setLayout(adminPaneLayout);
        adminPaneLayout.setHorizontalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(adminPaneLayout.createSequentialGroup()
                        .addComponent(getMembersBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailSearchBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTXT))
                    .addComponent(memberTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfNotActiveMembersLBL)
                    .addComponent(numberOfMembersLBL)
                    .addComponent(numberFactLBL)
                    .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deleteMemberBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editMemberBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addMemberBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numberOfActiveMembersLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        adminPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addMemberBTN, deleteMemberBTN, editMemberBTN});

        adminPaneLayout.setVerticalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPaneLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getMembersBTN)
                    .addComponent(emailSearchBTN)
                    .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(adminPaneLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(addMemberBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editMemberBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteMemberBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numberOfActiveMembersLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberOfNotActiveMembersLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(numberOfMembersLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numberFactLBL)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mainTabs.addTab("Formand", adminPane);

        javax.swing.GroupLayout accountingPaneLayout = new javax.swing.GroupLayout(accountingPane);
        accountingPane.setLayout(accountingPaneLayout);
        accountingPaneLayout.setHorizontalGroup(
            accountingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        accountingPaneLayout.setVerticalGroup(
            accountingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        mainTabs.addTab("Kasserer", accountingPane);

        javax.swing.GroupLayout coachPaneLayout = new javax.swing.GroupLayout(coachPane);
        coachPane.setLayout(coachPaneLayout);
        coachPaneLayout.setHorizontalGroup(
            coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        coachPaneLayout.setVerticalGroup(
            coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        mainTabs.addTab("Træner", coachPane);

        javax.swing.GroupLayout bgPanelLayout = new javax.swing.GroupLayout(bgPanel);
        bgPanel.setLayout(bgPanelLayout);
        bgPanelLayout.setHorizontalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabs)
        );
        bgPanelLayout.setVerticalGroup(
            bgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabs)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
    private void clearTable(DefaultTableModel model){
        model.setRowCount(0);
    }
    
    private void showNumberOfMembers() {
        try {
            numberOfMembersLBL.setText("Medlemmer i DB: " + logic.getTotalNumberOfMembers());
        } catch (Exception ex) {
            // TODO
        }
    }
    
    private void showNumberOfActiveMembers() {
        try {
            numberOfActiveMembersLBL.setText("Aktive medlemmer: " + logic.getTotalNumberOfActiveMembers());
        } catch (Exception ex) {
            // TODO
        }
    }
    
    private void showNumberOfNotActiveMembers() {
        try {
            numberOfNotActiveMembersLBL.setText("Inaktive medlemmer: " + logic.getTotalNumberOfNotActiveMembers());
        } catch (Exception ex) {
            // TODO
        }
    }
    
    private void showNumberFact() {
        try {
            int number = logic.getTotalNumberOfMembers();
            System.out.println(logic.getNumberFact(number));
            numberFactLBL.setText(logic.getNumberFact(number));
        } catch (Exception ex) {
            // TODO
        }
    }
    
    private void updateLabels() {
        
        showNumberOfActiveMembers();
        showNumberOfNotActiveMembers();
        showNumberOfMembers();
        showNumberFact();
    }
    
    private void removeLabels() {
        adminPane.remove(numberOfActiveMembersLBL);
        adminPane.remove(numberOfNotActiveMembersLBL);
        adminPane.remove(numberOfMembersLBL);
        adminPane.remove(numberFactLBL);
        adminPane.remove(jSeparator1);
    }
    
    private void getMembersBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMembersBTNActionPerformed
        try{
        logic.updateMemberList();
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        clearTable(model);
        for(Member member:logic.memberList){
            model.addRow(new Object[]{member.getID(), member.getName(), member.getEmail(),member.getBirthday()});
        }
        } catch(Exception e){
            showMessage("Kunne ikke indlæse medlemmer..");
        }
    }//GEN-LAST:event_getMembersBTNActionPerformed

    private void emailSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailSearchBTNActionPerformed
       try{
        logic.updateMemberList(emailTXT.getText());
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        clearTable(model);
        for(Member member:logic.memberList){
            model.addRow(new Object[]{member.getID(), member.getName(), member.getEmail(),member.getBirthday()});
        }
        } catch(Exception e){
            showMessage("Kunne ikke indlæse medlemmer..");
        }
    }//GEN-LAST:event_emailSearchBTNActionPerformed

    private void addMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberBTNActionPerformed
        membersDialog mdia = new membersDialog(this,true);
        mdia.setTitle("Opret nyt medlem");
        mdia.setVisible(true);
    }//GEN-LAST:event_addMemberBTNActionPerformed

    private void editMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMemberBTNActionPerformed
        if(memberTable.getSelectionModel().isSelectionEmpty()){
           showMessage("Vælg et medlem på listen før du redigerer.");
           return;
        }
        membersDialog mdia = new membersDialog(this,true);
        mdia.setTitle("Rediger medlem");
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        mdia.readyEdit(logic.memberList.get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow())));
        mdia.setVisible(true);
        clearTable(model);
    }//GEN-LAST:event_editMemberBTNActionPerformed

    private void deleteMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        int reply = JOptionPane.showConfirmDialog(null, 
                "Er du sikker på at du vil slette "+model.getValueAt(memberTable.getSelectedRow(), 1)+"?", 
                "Slet medlem?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {        
        try {
            logic.deleteMember((int)model.getValueAt(memberTable.getSelectedRow(), 0));
            clearTable(model);
        }
        catch(Exception e) {
            showMessage("Kunne ikke slette medlem");
        }
        }
    }//GEN-LAST:event_deleteMemberBTNActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountingPane;
    private javax.swing.JButton addMemberBTN;
    private javax.swing.JPanel adminPane;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JPanel coachPane;
    private javax.swing.JButton deleteMemberBTN;
    private javax.swing.JButton editMemberBTN;
    private javax.swing.JButton emailSearchBTN;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JButton getMembersBTN;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane mainTabs;
    private javax.swing.JTable memberTable;
    private javax.swing.JScrollPane memberTableScroll;
    private javax.swing.JLabel numberFactLBL;
    private javax.swing.JLabel numberOfActiveMembersLBL;
    private javax.swing.JLabel numberOfMembersLBL;
    private javax.swing.JLabel numberOfNotActiveMembersLBL;
    // End of variables declaration//GEN-END:variables
}
