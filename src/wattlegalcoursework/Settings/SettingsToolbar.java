/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wattlegalcoursework.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import wattlegalcoursework.SettingsBackground;
import wattlegalcoursework.WattLegalCoursework;

/**
 *
 * @author Reuben
 */
public class SettingsToolbar extends javax.swing.JPanel {

    /**
     * Creates new form SettingsToolbar
     */
    public SettingsToolbar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPersonal = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        btnPersonal.setText("Personal details");
        btnPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPersonalMouseReleased(evt);
            }
        });

        jButton2.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(475, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseReleased
        WattLegalCoursework.addToFrontPanel(SettingsBackground.SettingsBackgroundPanel, new wattlegalcoursework.Settings.PersonelDetailSettings(), true);
        try {
            String host = "jdbc:derby://localhost:1527/Lawyers";
            String uName = "spyfire14";
            String uPass = "spyfire14";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM LAWYERLISTS WHERE ID = " + wattlegalcoursework.AccessMenu.ID;
            ResultSet rs = stmt.executeQuery(sql);
            try {
                while (rs.next()) {
                    String dbFirst = rs.getString("First_Name");
                    String dbLast = rs.getString("Last_Name");
                    String dbSex = rs.getString("Sex");
                    String dbJobTitle = rs.getString("Job_Title");
                    String dbEmail = rs.getString("Email");
                    String dbLawFirm = rs.getString("LawFirm");

                    PersonelDetailSettings.txtFirstSettings.setText(dbFirst);
                    PersonelDetailSettings.txtLastSettings.setText(dbLast);
                    PersonelDetailSettings.txtSexSettings.setText(dbSex);
                    PersonelDetailSettings.txtJobTitleSettings.setText(dbJobTitle);
                    PersonelDetailSettings.txtLawFirmSettings.setText(dbLawFirm);
                    PersonelDetailSettings.txtEmailSettings.setText(dbEmail);
                }

            } catch (SQLException ex) {
                Logger.getLogger(SettingsToolbar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SettingsToolbar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPersonalMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}