/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class LocalProveedorIInventario extends javax.swing.JFrame {

    /**
     * Creates new form Local_proveedor_insumo
     */
    public LocalProveedorIInventario() {

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

        int num_gastos = conexion.Contar_tablas(conectar, "Proveedor");

        System.out.println(num_gastos);
        try {

            String matris[][] = new String[num_gastos][6];

            Statement s = conectar.createStatement();
            ResultSet rs = s.executeQuery("select prov_id, prov_nombre,ins_id, ins_nombre, ins_existencia from inventarioproveedor join proveedor on (Proveedor_prov_id = prov_ID) join Insumo on (Insumo_ins_id = ins_id);");

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
                        "ID", "Nombre del Proveedor", "ID insumo", "Nombre Insumo", "Cantidad",}));

        } catch (SQLException sqle) {
            System.out.println("Imposible realizar consulta ... FAIL");
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
        Buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        Cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comprar_busqueda1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Ingreso_insumo = new javax.swing.JTextField();
        A_proveedor = new javax.swing.JTextField();
        Comprar1 = new javax.swing.JButton();
        Ingreso_insumo1 = new javax.swing.JTextField();
        comprar_busqueda = new javax.swing.JComboBox<>();
        A_proveedor1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Agregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 590, 360));

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 120, 30));

        jLabel1.setText("Inventario  Proveedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));
        getContentPane().add(id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 230, 32));

        jLabel2.setText("Id :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 30, -1));

        jLabel7.setText("Precio Unitario : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 90, -1));

        Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioActionPerformed(evt);
            }
        });
        getContentPane().add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 130, 30));

        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });
        getContentPane().add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 130, 30));

        jLabel3.setText("ID Proveedor : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 80, -1));

        jLabel4.setText("Cantidad : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 63, -1));

        jLabel5.setText("Agregar o eliminar insumo al proveedor");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, -1, -1));

        comprar_busqueda1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID insumo", "Nombre insumo" }));
        comprar_busqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprar_busqueda1ActionPerformed(evt);
            }
        });
        getContentPane().add(comprar_busqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 90, 30));

        jLabel6.setText("Realizar compra");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));

        Ingreso_insumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingreso_insumoActionPerformed(evt);
            }
        });
        getContentPane().add(Ingreso_insumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 130, 30));

        A_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_proveedorActionPerformed(evt);
            }
        });
        getContentPane().add(A_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 130, 30));

        Comprar1.setText("Comprar");
        Comprar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Comprar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Comprar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 660, 200, 40));

        Ingreso_insumo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ingreso_insumo1ActionPerformed(evt);
            }
        });
        getContentPane().add(Ingreso_insumo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 170, 30));

        comprar_busqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID insumo", "Nombre insumo" }));
        comprar_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprar_busquedaActionPerformed(evt);
            }
        });
        getContentPane().add(comprar_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 30));

        A_proveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_proveedor1ActionPerformed(evt);
            }
        });
        getContentPane().add(A_proveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 170, 30));

        jLabel8.setText("ID Proveedor : ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 80, -1));

        Agregar.setText("Agregar Insumo al inventario del proveedor");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        getContentPane().add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 250, 40));

        jButton2.setText("Atras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String apellido = "Baquero";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        String S_ID = id_txt.getText();

        try {

            if (("".equals(S_ID))) {

                JOptionPane.showMessageDialog(this, "La informacion esta incompleta vuelva a intentar");

            } else {

                int id = Integer.parseInt(S_ID);

                int num_gastos = conexion.Contar_tablas(conectar, "proveedor");

                System.out.println(num_gastos);
                try {

                    String matris[][] = new String[num_gastos][6];

                    Statement s = conectar.createStatement();
                    ResultSet rs = s.executeQuery("select prov_id, prov_nombre,ins_id, ins_nombre, ins_existencia from inventarioproveedor join proveedor on (Proveedor_prov_id = prov_ID) join Insumo on (Insumo_ins_id = ins_id) where prov_id = " + S_ID + ";");

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
                                "ID", "Nombre del Proveedor", "ID insumo", "Nombre Insumo", "Cantidad",}));

                } catch (SQLException sqle) {
                    System.out.println("Imposible realizar consulta ... FAIL");
                    sqle.printStackTrace();
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadActionPerformed

    private void Ingreso_insumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingreso_insumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingreso_insumoActionPerformed

    private void comprar_busqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprar_busqueda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprar_busqueda1ActionPerformed

    private void A_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A_proveedorActionPerformed

    private void Comprar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Comprar1ActionPerformed

        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        String buscar = (String) comprar_busqueda.getSelectedItem();

        String S_buscar_insumo = Ingreso_insumo.getText();

        String S_id_prov = A_proveedor.getText();

        String S_cantidad = Cantidad.getText();

        String S_precio = Precio.getText();

        try {

            if (("".equals(S_cantidad)) || ("".equals(S_precio)) || ("".equals(S_id_prov)) || ("".equals(S_buscar_insumo))) {

                JOptionPane.showMessageDialog(this, "La informacion esta incompleta vuelva a intentar");

            } else {

                int id_prov = Integer.parseInt(S_id_prov);

                int cantidad = Integer.parseInt(S_cantidad);

                int precio = Integer.parseInt(S_precio);

                if ("ID insumo".equals(buscar)) {

                    int i = JOptionPane.showConfirmDialog(this, "¿Estas seguro de realizar la compra del insumo :" + S_buscar_insumo + "?\ncon el id del proveedor :" + S_id_prov + "\nCantidad :" + cantidad + "\nPrecio unitario :" + S_precio);

                    if (i == 0) {

                        try {

                            int buscar_insumo = Integer.parseInt(S_buscar_insumo);

                            String Consulta = "{call Insertar_comprainsumo_id (?,?, ?, ?)}";

                            CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);

                            procedimiento.setInt(1, buscar_insumo);
                            procedimiento.setInt(2, id_prov);
                            procedimiento.setInt(3, cantidad);
                            procedimiento.setInt(4, precio);

                            procedimiento.execute();

                            JOptionPane.showMessageDialog(this, "La informacion se ha actualizado con exito");

                        } catch (SQLException ex) {

                            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "La conexion fallo, vuelva a intentar", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                        }

                    } else if (i == 2) {

                        dispose();
                    }

                } else {

                    int i = JOptionPane.showConfirmDialog(this, "¿Estas seguro de realizar la compra del insumo :" + S_buscar_insumo + "?\ncon el id del proveedor :" + S_id_prov + "\nCantidad :" + cantidad + "\nPrecio unitario :" + S_precio);

                    if (i == 0) {

                        try {

                            String Consulta = "{call Insertar_comprainsumo_nombre (?, ?, ?,?)}";

                            CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);

                            procedimiento.setString(1, S_buscar_insumo);
                            procedimiento.setInt(2, id_prov);
                            procedimiento.setInt(3, cantidad);
                            procedimiento.setInt(4, precio);

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
            }
        } catch (Exception ex) {
            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_Comprar1ActionPerformed

    private void Ingreso_insumo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ingreso_insumo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ingreso_insumo1ActionPerformed

    private void comprar_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprar_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comprar_busquedaActionPerformed

    private void A_proveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_proveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A_proveedor1ActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        
        MysqlConexion conexion = new MysqlConexion();

        String usuario = "Venus";
        String contrasena = "gerente";

        conexion.setPassword(contrasena);
        conexion.setUser(usuario);

        Connection conectar = conexion.iniciarConexion();

        String buscar = (String) comprar_busqueda1.getSelectedItem();

        String S_buscar_insumo = Ingreso_insumo1.getText();

        String S_id_prov = A_proveedor1.getText();


        try {

            if (("".equals(S_id_prov)) || ("".equals(S_buscar_insumo))) {

                JOptionPane.showMessageDialog(this, "La informacion esta incompleta vuelva a intentar");

            } else {

                int id_prov = Integer.parseInt(S_id_prov);


                if ("ID insumo".equals(buscar)) {

                    int i = JOptionPane.showConfirmDialog(this, "¿Estas seguro de ingresar al proveedor :" + S_buscar_insumo + "?\nel producto :" + S_id_prov);

                    if (i == 0) {

                        try {

                            int buscar_insumo = Integer.parseInt(S_buscar_insumo);

                            String Consulta = "{call Insertar_insumo_proveedor(?,?)}";

                            CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);

                            procedimiento.setInt(1, buscar_insumo);
                            procedimiento.setInt(2, id_prov);


                            procedimiento.execute();

                            JOptionPane.showMessageDialog(this, "La informacion se ha actualizado con exito");

                        } catch (SQLException ex) {

                            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(this, "La conexion fallo, vuelva a intentar", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                        }

                    } else if (i == 2) {

                        dispose();
                    }

                } else {

                    int i = JOptionPane.showConfirmDialog(this, "¿Estas seguro de ingresar al proveedor :" + S_buscar_insumo + "?\nel producto :" + S_id_prov);

                    if (i == 0) {

                        try {

                            String Consulta = "{call Insertar_insumo_proveedor_nombre (?, ?)}";

                            CallableStatement procedimiento = (CallableStatement) conectar.prepareCall(Consulta);

                            procedimiento.setString(1, S_buscar_insumo);
                            procedimiento.setInt(2, id_prov);

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
            }
        } catch (Exception ex) {
            Logger.getLogger(LocalGastoInsertar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ingrese nuevamente los datos", "Datos incorrectos", JOptionPane.WARNING_MESSAGE);

        }
        
        llenarDatos();
        
    }//GEN-LAST:event_AgregarActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        
        System.out.println("identificado");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        
        llenarDatos();
    }//GEN-LAST:event_formFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new LocalProveedorInsumo().setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LocalProveedorIInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorIInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorIInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalProveedorIInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalProveedorIInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A_proveedor;
    private javax.swing.JTextField A_proveedor1;
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JButton Comprar1;
    private javax.swing.JTextField Ingreso_insumo;
    private javax.swing.JTextField Ingreso_insumo1;
    private javax.swing.JTextField Precio;
    private javax.swing.JComboBox<String> comprar_busqueda;
    private javax.swing.JComboBox<String> comprar_busqueda1;
    private javax.swing.JTextField id_txt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
