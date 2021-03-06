/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Domo
 */
public class Interface extends javax.swing.JFrame {

    public Connection conn;
    public PreparedStatement pst = null;
    public ResultSet rs = null;
    
    

    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        table();
    }

    public void table(){
        int x;
         try{
        Class.forName("com.mysql.jdbc.Driver");
        String DBurl="jdbc:mysql://localhost:3306/mydb";
        conn = DriverManager.getConnection(DBurl,"root","");
        Statement stmt = conn.createStatement();
        String requete = "Select * from article"; 
        
        pst = conn.prepareStatement(requete);
        rs = pst.executeQuery();
        ResultSetMetaData res = rs.getMetaData();
        x = res.getColumnCount();
        
        DefaultTableModel DT = (DefaultTableModel)jTable2.getModel();
        DT.setRowCount(0);
        while(rs.next()){
           //Vector v2 = new Vector();
            //Vector v3 = new Vector();
            Vector v4 = new Vector();
            Vector v5 = new Vector();
            
            
            
            
            for(int a=1;a<=x;a++){
               v4.add(rs.getString("N°Article"));
                v4.add(rs.getString("Libelle"));
                v4.add(rs.getString("PrixUnit"));
                v4.add(rs.getString("TVA"));
            }
            DT.addRow(v4);
        }
        
        
        }catch (HeadlessException |ClassNotFoundException| SQLException e){
        JOptionPane.showMessageDialog(null, e);
        e.printStackTrace();
    }   
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Modify = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel1.setText("GESTION OF ARTICLES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajout d'article", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel3.setText("Libelle");

        jLabel4.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel4.setText("PrixUnit");

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel5.setText("TVA");

        Add.setText("Add");
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Modify.setText("Modify");
        Modify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Modify)
                        .addGap(124, 124, 124)
                        .addComponent(jButton5)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                    .addComponent(txt2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Modify)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Article", "Libelle", "PrixUnit", "TVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel1)
                .addContainerGap(367, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Article's information");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//GEN-FIRST:event_AjouterActionPerformed
    public void AddActionPerformed(java.awt.event.ActionEvent evt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String DBurl="jdbc:mysql://localhost:3306/mydb";
            conn = DriverManager.getConnection(DBurl,"root","");
            Statement stmt = conn.createStatement();
            String requete = "INSERT into article(Libelle,PrixUnit,TVA)values('" + txt2.getText() + "','" +txt3.getText() +"','" + txt4.getText()+"');";
            
            pst.executeUpdate(requete);
            JOptionPane.showMessageDialog(null, "Success");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt2.requestFocus();
            table();
           
        }catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
//GEN-LAST:event_AjouterActionPerformed

    public void ModifyActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel DT = (DefaultTableModel)jTable2.getModel();
        int select = jTable2.getSelectedRow();
        
        try{
            
            int id = Integer.parseInt(DT.getValueAt(select, 0).toString());
            String lib = txt2.getText();
            String prix = txt3.getText();
            String tva = txt4.getText();
            Class.forName("com.mysql.jdbc.Driver");
            String DBurl="jdbc:mysql://localhost:3306/mydb";
            conn = DriverManager.getConnection(DBurl,"root","");
            Statement stmt = conn.createStatement();
            pst = conn.prepareStatement("update article set Libelle= ?,PrixUnit= ?, TVA= ? where N°Article= ?");
            pst.setString(1, lib);
            pst.setString(2, prix);
            pst.setString(3, tva);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Article modified");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt2.requestFocus();
            table();
           
        }catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        
    }

    public void jTable2MouseClicked(java.awt.event.MouseEvent evt){
        DefaultTableModel DT = (DefaultTableModel)jTable2.getModel();
        int select = jTable2.getSelectedRow();
        
        txt2.setText(DT.getValueAt(select, 1).toString());
        txt3.setText(DT.getValueAt(select, 2).toString());
        txt4.setText(DT.getValueAt(select, 3).toString());
        
    }
    
    public void DeleteActionPerformed(java.awt.event.ActionEvent evt){
        DefaultTableModel DT = (DefaultTableModel)jTable2.getModel();
        int select = jTable2.getSelectedRow();
        
         try{
            int id = Integer.parseInt(DT.getValueAt(select, 0).toString());
            int message = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this article","Warning",JOptionPane.YES_NO_OPTION);
            
            if(message == JOptionPane.YES_OPTION){
                
            
            
            Class.forName("com.mysql.jdbc.Driver");
            String DBurl="jdbc:mysql://localhost:3306/mydb";
            conn = DriverManager.getConnection(DBurl,"root","");
            Statement stmt = conn.createStatement();
            pst = conn.prepareStatement("delete from article  where N°Article= ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Article deleted");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt2.requestFocus();
            table();
            }
        }catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        
    }
    /*
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel DT = (DefaultTableModel)jTable2.getModel();
        int select = jTable2.getSelectedRow();
        
        txt2.setText(DT.getValueAt(select, 1).toString());
        txt3.setText(DT.getValueAt(select, 2).toString());
        txt4.setText(DT.getValueAt(select, 3).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifyActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed
*/

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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JButton Modify;
    public javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    // End of variables declaration//GEN-END:variables
}
