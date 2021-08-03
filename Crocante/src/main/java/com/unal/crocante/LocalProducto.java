/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel Martinez
 */
public class LocalProducto extends javax.swing.JFrame {

    /**
     * Creates new form Local_Producto
     */
    public LocalProducto() {
        initComponents();
        llenarDatos();
    }
    
        private void llenarDatos() {
        
        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String apellido = "Baquero";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        int num_gastos = conexion.Contar_tablas(conectar, "producto");

        System.out.println(num_gastos);
        try {

            String matris[][] = new String[num_gastos][6];

            Statement s = conectar.createStatement();
            ResultSet rs = s.executeQuery("select pro_id, pro_nombre, pro_precio, tip_tipo from producto join Tipo on (Tipo_tip_id = tip_id) where pro_estado = 1 order by pro_Id desc;");

// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            int i = 0;

            while (rs.next()) {

                matris[i][0] = rs.getString(1);
                matris[i][1] = rs.getString(2);
                matris[i][2] = rs.getString(3);
                matris[i][3] = rs.getString(4);

                i++;

            }

            System.out.println(matris);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
                    new String[]{
                        "ID", "Nombre del Producto", "Precio", "Tipo"
                    }));

        } catch (SQLException sqle) {
            System.out.println("Imposible realizar consulta ... FAIL");
            sqle.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Costo_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tipo_txt = new javax.swing.JComboBox<>();
        Recargar_datos_gastos = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Producto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Minimo Costo ");

        Costo_txt.setText("0");
        Costo_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Costo_txtActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo  ");

        tipo_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todo", "Hamburguesa", "Perro Caliente", "Carnes", "Varios", "Mazorcada", "Salchipapa", "Bebidas", "Adiciones" }));
        tipo_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_txtActionPerformed(evt);
            }
        });

        Recargar_datos_gastos.setText("Recargar Datos");
        Recargar_datos_gastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recargar_datos_gastosActionPerformed(evt);
            }
        });

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Recargar_datos_gastos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(Costo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tipo_txt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Costo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tipo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Recargar_datos_gastos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new LocalProductoAgregar().setVisible(true);        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tipo_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_txtActionPerformed

    private void Recargar_datos_gastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recargar_datos_gastosActionPerformed

        int costo = 0;

        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String apellido = "Baquero";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        int num_gastos = conexion.Contar_tablas(conectar, "Producto");

        System.out.println(num_gastos);
        String S_Costo = Costo_txt.getText();
        String S_Tipo = (String) tipo_txt.getSelectedItem();

        try {

            if ("Todo".equals(S_Tipo)) {

                try {

                    if ("".equals(S_Costo)) {

                        costo = 0;

                    } else {

                        costo = Integer.parseInt(S_Costo);

                    }

                    String matris[][] = new String[num_gastos][6];

                    Statement s = conectar.createStatement();
                    ResultSet rs = s.executeQuery("select pro_id, pro_nombre, pro_precio, tip_tipo from Producto join Tipo on (Tipo_tip_id = tip_id) where pro_precio > "+costo+" and pro_estado = 1 order by pro_Id desc");

                    // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                    int i = 0;

                    while (rs.next()) {

                matris[i][0] = rs.getString(1);
                matris[i][1] = rs.getString(2);
                matris[i][2] = rs.getString(3);
                matris[i][3] = rs.getString(4);

                i++;

            }

            System.out.println(matris);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
                    new String[]{
                        "ID", "Nombre del Producto", "Precio", "Tipo"
                    }));

                    } catch (SQLException sqle) {
                        System.out.println("Imposible realizar consulta ... FAIL");
                        sqle.printStackTrace();
                    }

                } else {

                    try {

                        if ("".equals(S_Costo)) {

                            costo = 0;

                        } else {

                            costo = Integer.parseInt(S_Costo);

                        }

                        String matris[][] = new String[num_gastos][6];

                        Statement s = conectar.createStatement();
                        ResultSet rs = s.executeQuery("select pro_id, pro_nombre, pro_precio, tip_tipo from Producto join Tipo on (Tipo_tip_id = tip_id) where pro_precio > "+costo+" and tip_tipo = '"+S_Tipo+"' and pro_estado = 1 order by pro_Id desc;");

                        // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                        int i = 0;

                        while (rs.next()) {

                matris[i][0] = rs.getString(1);
                matris[i][1] = rs.getString(2);
                matris[i][2] = rs.getString(3);
                matris[i][3] = rs.getString(4);

                i++;

            }

            System.out.println(matris);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
                    new String[]{
                        "ID", "Nombre del Producto", "Precio", "Tipo"
                    }));

                        } catch (SQLException sqle) {
                            System.out.println("Imposible realizar consulta ... FAIL");
                            sqle.printStackTrace();
                        }

                    }
                } catch (Exception ex) {
                    Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

                }

    }//GEN-LAST:event_Recargar_datos_gastosActionPerformed

    private void Costo_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Costo_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Costo_txtActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       
        System.out.println("identificado");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        llenarDatos();
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        new LocalProductoEliminar().setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new LocalProductoEditar().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     LocalMenu local = new LocalMenu();
     local.setVisible(true);
     dispose();            // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(LocalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Costo_txt;
    private javax.swing.JButton Recargar_datos_gastos;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> tipo_txt;
    // End of variables declaration//GEN-END:variables
}
