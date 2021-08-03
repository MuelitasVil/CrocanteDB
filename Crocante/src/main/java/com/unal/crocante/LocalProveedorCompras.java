/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import java.sql.CallableStatement;
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
public class LocalProveedorCompras extends javax.swing.JFrame {

    /**
     * Creates new form LocalProveedorCompras
     */
    public LocalProveedorCompras() {
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

        int num_gastos = conexion.ContarTablas(conectar, "proveedor");

        System.out.println(num_gastos);
        try {

            String matris[][] = new String[num_gastos][6];

            Statement s = conectar.createStatement();
            ResultSet rs = s.executeQuery("select CompraAlProveedor_Gastos_gast_id, prov_nombre,ins_nombre,dci_cantidad, dci_precioUnitario from detallecomprainsumo join insumo on (Insumo_ins_id = ins_id) join Proveedor on (CompraAlProveedor_Proveedor_prov_id = prov_id) order by CompraAlProveedor_Gastos_gast_id desc;");

// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            int i = 0;

            while (rs.next()) {

                matris[i][0] = rs.getString(1);
                matris[i][1] = rs.getString(2);
                matris[i][2] = rs.getString(3);
                matris[i][3] = rs.getString(4);
                matris[i][4] = rs.getString(5);

                i++;

            }

            System.out.println(matris);

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    matris,
                    new String[]{
                        "ID", "Nombre del Proveedor", "Nombre del insumo", "Cantidad", "Precio unitario"
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ID_gasto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        Precio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Editar_Compra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ID_gasto1 = new javax.swing.JTextField();
        Agregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Compras Realizadas");

        jLabel6.setText("Editar Compras");

        ID_gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_gastoActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Gasto : ");

        jLabel4.setText("Cantidad : ");

        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });

        Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioActionPerformed(evt);
            }
        });

        jLabel7.setText("Precio Unitario : ");

        Editar_Compra.setText("Eliminar");
        Editar_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_CompraActionPerformed(evt);
            }
        });

        jLabel5.setText("Eliminar Compras");

        ID_gasto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_gasto1ActionPerformed(evt);
            }
        });

        Agregar.setText("Editar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jLabel9.setText("ID Gasto : ");

        Atras.setText("Atras");
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID_gasto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID_gasto1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(110, 110, 110))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Editar_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_gasto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ID_gasto1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        System.out.println("identificado");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        llenarDatos();

    }//GEN-LAST:event_formWindowGainedFocus

    private void ID_gastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_gastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_gastoActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadActionPerformed

    private void PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioActionPerformed

    private void Editar_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_CompraActionPerformed

        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        String S_id_gasto = ID_gasto1.getText();

        try {

            if (("".equals(S_id_gasto))) {

                JOptionPane.showMessageDialog(this, "La informacion esta incompleta vuelva a intentar");

            } else {

                int id_gasto = Integer.parseInt(S_id_gasto);

                int i = JOptionPane.showConfirmDialog(this, "¿Estas seguro de eliminar la compra con el Id " + S_id_gasto);

                if (i == 0) {

                    try {

                        String Consulta = "{call Eliminar_compra_insumo(?)}";
                        CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);
                        procedimiento.setInt(1, id_gasto);

                        procedimiento.execute();

                        JOptionPane.showMessageDialog(this, "La informacion se ha actualizado con exito");

                    } catch (SQLException ex) {

                        Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "La conexion fallo, vuelva a intentar", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (i == 2) {

                    dispose();
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_Editar_CompraActionPerformed

    private void ID_gasto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_gasto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_gasto1ActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed

        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        String S_id_gasto = ID_gasto.getText();

        String S_cantidad = Cantidad.getText();

        String S_precio = Precio.getText();

        try {

            if (("".equals(S_cantidad)) || ("".equals(S_precio)) || ("".equals(S_id_gasto))) {

                JOptionPane.showMessageDialog(this, "La informacion esta incompleta vuelva a intentar");

            } else {

                int id_gasto = Integer.parseInt(S_id_gasto);

                int cantidad = Integer.parseInt(S_cantidad);

                int precio = Integer.parseInt(S_precio);

                int i = JOptionPane.showConfirmDialog(this, S_precio + "¿Estas seguro de actualizar la compra con el Id " + S_id_gasto + " Con los siguientes datos : \nCantidad :" + S_cantidad + "?\nPrecio Unitario :");

                if (i == 0) {

                    try {

                        String Consulta = "{call Actualizar_Detalle_compra_insumo(?,?,?)}";

                        CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);

                        procedimiento.setInt(1, precio);
                        procedimiento.setInt(2, id_gasto);
                        procedimiento.setInt(3, cantidad);

                        procedimiento.execute();

                        JOptionPane.showMessageDialog(this, "La informacion se ha actualizado con exito");

                    } catch (SQLException ex) {

                        Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(this, "La conexion fallo, vuelva a intentar", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (i == 2) {

                    dispose();
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        dispose();
    }//GEN-LAST:event_AtrasActionPerformed

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
            java.util.logging.Logger.getLogger(LocalProveedorCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalProveedorCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Atras;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JButton Editar_Compra;
    private javax.swing.JTextField ID_gasto;
    private javax.swing.JTextField ID_gasto1;
    private javax.swing.JTextField Precio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
