package presentation;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.Controller;
import logic.Discipline;
import logic.Member;
import logic.Result;

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

        loadContent();
        //removeLabels();
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
        jToggleButton1 = new javax.swing.JToggleButton();
        accountingPane = new javax.swing.JPanel();
        coachPane = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        testPane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList<>();
        resultsMemberIdTXT = new javax.swing.JTextField();
        getResultsBTN = new javax.swing.JButton();
        testResetBTN = new javax.swing.JButton();

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

        jToggleButton1.setText("jToggleButton1");

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
                .addGroup(adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPaneLayout.createSequentialGroup()
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
                                .addComponent(numberOfActiveMembersLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(adminPaneLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jToggleButton1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        adminPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addMemberBTN, deleteMemberBTN, editMemberBTN});

        adminPaneLayout.setVerticalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPaneLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        mainTabs.addTab("Formand", adminPane);

        javax.swing.GroupLayout accountingPaneLayout = new javax.swing.GroupLayout(accountingPane);
        accountingPane.setLayout(accountingPaneLayout);
        accountingPaneLayout.setHorizontalGroup(
            accountingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        accountingPaneLayout.setVerticalGroup(
            accountingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        mainTabs.addTab("Kasserer", accountingPane);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Navn", "Disciplin", "Tid", "comp", "place"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(resultTable);

        categoryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        categoryList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(categoryList);

        getResultsBTN.setText("Søg id Member");
        getResultsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getResultsBTNActionPerformed(evt);
            }
        });

        testResetBTN.setText("Nulstil");
        testResetBTN.setEnabled(false);
        testResetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testResetBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testPaneLayout = new javax.swing.GroupLayout(testPane);
        testPane.setLayout(testPaneLayout);
        testPaneLayout.setHorizontalGroup(
            testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testPaneLayout.createSequentialGroup()
                .addGroup(testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(testResetBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                    .addGroup(testPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultsMemberIdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(getResultsBTN)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        testPaneLayout.setVerticalGroup(
            testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultsMemberIdTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getResultsBTN))
                .addGap(18, 18, 18)
                .addGroup(testPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(testResetBTN))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Resultater", testPane);

        javax.swing.GroupLayout coachPaneLayout = new javax.swing.GroupLayout(coachPane);
        coachPane.setLayout(coachPaneLayout);
        coachPaneLayout.setHorizontalGroup(
            coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );
        coachPaneLayout.setVerticalGroup(
            coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
            .addGroup(coachPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
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

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    private void clearTable(DefaultTableModel model) {
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
            showMessage("Kunne ikke hente number fact.. Er du forbundet til nettet?");
            adminPane.remove(numberFactLBL);
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

    private void loadContent() {
        try {
            logic.updateMemberList();
            updateLabels();
            fillResultTable();
            fillCategoryList();

        } catch (Exception ex) {
            showMessage("Kunne ikke loade content");
        }
    }
    
    private void fillResultTable() {
        try {
            logic.updateResultList();
            DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
            clearTable(model);
            for (Result result : logic.resultList) {
                model.addRow(new Object[]{result.getId(), result.getMemberName(), result.getDisciplineName(), result.getTime(), result.getComp(), result.getPlace()});
            }
        } catch (Exception ex) {
            showMessage("Kunne ikke indlæse resultater..");
        }
    }

    private void fillCategoryList() {
        try {
            logic.updateCategoryList();
            DefaultListModel model = new DefaultListModel();

            for (Discipline discipline : logic.categoryList) {
                model.addElement(discipline.getName());
            }

            categoryList.setModel(model);

        } catch (Exception ex) {
            // TODO
        }
    }

    private void getMembersBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMembersBTNActionPerformed
        try {
            logic.updateMemberList();
            DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
            clearTable(model);
            for (Member member : logic.memberList) {
                model.addRow(new Object[]{member.getID(), member.getName(), member.getEmail(), member.getBirthday()});
            }
        } catch (Exception e) {
            showMessage("Kunne ikke indlæse medlemmer..");
        }
    }//GEN-LAST:event_getMembersBTNActionPerformed

    private void emailSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailSearchBTNActionPerformed
        try {
            logic.updateMemberList(emailTXT.getText());
            DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
            clearTable(model);
            for (Member member : logic.memberList) {
                model.addRow(new Object[]{member.getID(), member.getName(), member.getEmail(), member.getBirthday()});
            }
        } catch (Exception e) {
            showMessage("Kunne ikke indlæse medlemmer..");
        }
    }//GEN-LAST:event_emailSearchBTNActionPerformed

    private void addMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberBTNActionPerformed
        membersDialog mdia = new membersDialog(this, true);
        mdia.setTitle("Opret nyt medlem");
        mdia.setVisible(true);
    }//GEN-LAST:event_addMemberBTNActionPerformed

    private void editMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMemberBTNActionPerformed
        if (memberTable.getSelectionModel().isSelectionEmpty()) {
            showMessage("Vælg et medlem på listen før du redigerer.");
            return;
        }
        membersDialog mdia = new membersDialog(this, true);
        mdia.setTitle("Rediger medlem");
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        mdia.readyEdit(logic.memberList.get(memberTable.convertRowIndexToModel(memberTable.getSelectedRow())));
        mdia.setVisible(true);
        clearTable(model);
    }//GEN-LAST:event_editMemberBTNActionPerformed

    private void deleteMemberBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) memberTable.getModel();
        int reply = JOptionPane.showConfirmDialog(null,
                "Er du sikker på at du vil slette " + model.getValueAt(memberTable.getSelectedRow(), 1) + "?",
                "Slet medlem?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                //int idTest = Integer.parseInt(model.getValueAt(memberTable.getSelectedRow(), 0));
                //System.out.println(model.getValueAt(memberTable.getSelectedRow(), 0));
               
                logic.deleteMember(10);
                //logic.deleteMember((int) model.getValueAt(memberTable.getSelectedRow(), 0));
                clearTable(model);
            } catch (Exception e) {
                showMessage("Kunne ikke slette medlem");
                //System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_deleteMemberBTNActionPerformed

    private void categoryListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryListMouseClicked
         // TODO add your handling code here:
        //String memberID = sdgsgdfs.getText();
        int categoryID = categoryList.getSelectedIndex() + 1;

        try {
            logic.getResultsInCategory(categoryID);
            DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
            clearTable(model);
            for (Result result : logic.resultList) {
                model.addRow(new Object[]{result.getId(), result.getMemberName(), result.getDisciplineName(), result.getTime(), result.getComp(), result.getPlace()});
            }
        } catch (Exception ex) {
            showMessage("Kunne ikke indlæse resultater..");
        }
        testResetBTN.setEnabled(true);
    }//GEN-LAST:event_categoryListMouseClicked

    private void getResultsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getResultsBTNActionPerformed
        // TODO add your handling code here:
         try {
                 // TODO add your handling code here:
        String memberID = resultsMemberIdTXT.getText();
            logic.getResultsForMember(memberID);
            DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
            clearTable(model);
            for (Result result : logic.resultList) {
                model.addRow(new Object[]{result.getId(), result.getMemberName(), result.getDisciplineName(), result.getTime(), result.getComp(), result.getPlace()});
            }
        } catch (Exception ex) {
            showMessage("Kunne ikke indlæse resultater..");
        }
    }//GEN-LAST:event_getResultsBTNActionPerformed

    private void testResetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testResetBTNActionPerformed
        // TODO add your handling code here:
                try {
            fillResultTable();
        } catch (Exception ex) {
            //TODO
        }

        //SwingUtilities.updateComponentTreeUI(testPane);
        categoryList.clearSelection();
        testResetBTN.setEnabled(false);
    }//GEN-LAST:event_testResetBTNActionPerformed

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
    private javax.swing.JList<String> categoryList;
    private javax.swing.JPanel coachPane;
    private javax.swing.JButton deleteMemberBTN;
    private javax.swing.JButton editMemberBTN;
    private javax.swing.JButton emailSearchBTN;
    private javax.swing.JTextField emailTXT;
    private javax.swing.JButton getMembersBTN;
    private javax.swing.JButton getResultsBTN;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTabbedPane mainTabs;
    private javax.swing.JTable memberTable;
    private javax.swing.JScrollPane memberTableScroll;
    private javax.swing.JLabel numberFactLBL;
    private javax.swing.JLabel numberOfActiveMembersLBL;
    private javax.swing.JLabel numberOfMembersLBL;
    private javax.swing.JLabel numberOfNotActiveMembersLBL;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField resultsMemberIdTXT;
    private javax.swing.JPanel testPane;
    private javax.swing.JButton testResetBTN;
    // End of variables declaration//GEN-END:variables
}
