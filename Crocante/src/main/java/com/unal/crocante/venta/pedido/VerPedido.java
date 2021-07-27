/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unal.crocante.venta.pedido;

import com.unal.crocante.MysqlConexion;
import com.unal.crocante.venta.VentaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VenusBaquero
 */
public class VerPedido extends javax.swing.JFrame {

    private int idVenta;
    private int total;
    private Connection conexion;

    /**
     * Creates new form AgregarPedido
     */
    public VerPedido() {
        initComponents();
    }

    public VerPedido(int idVenta) {
        this();
        this.idVenta = idVenta;
        MysqlConexion conector = new MysqlConexion("Venus", "gerente");
        conexion = conector.iniciarConexion();
        llenarInfoPedido();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pedido = new javax.swing.JTable();
        dltBtn = new javax.swing.JButton();
        pedidoLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        precioLabel = new javax.swing.JLabel();
        precioFormattedTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "producto", "tipo", "precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pedido.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(pedido);

        dltBtn.setText("Eliminar");
        dltBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltBtnActionPerformed(evt);
            }
        });

        pedidoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pedidoLabel.setText("Detalles Pedido");

        addButton.setText("Crear");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dltBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(pedidoLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dltBtn)
                        .addGap(53, 53, 53)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pedidoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dltBtn)
                    .addComponent(addButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        precioLabel.setLabelFor(precioFormattedTextField);
        precioLabel.setText("Total:");

        precioFormattedTextField.setEditable(false);
        precioFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(volverBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(precioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioLabel)
                    .addComponent(precioFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(volverBtn))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        System.out.println("identificado");
        recargarLista();
    }//GEN-LAST:event_formWindowGainedFocus

    private void recargarLista() {
        DefaultTableModel model = (DefaultTableModel) pedido.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        total = 0;
        llenarInfoPedido();
        precioFormattedTextField.setValue(total);
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AgregarPedido add = new AgregarPedido(idVenta);
        add.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void dltBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltBtnActionPerformed
        int row = pedido.getSelectedRow();
        if (row >= 0) {
            int producto = (int) pedido.getModel().getValueAt(row, 0);
            String queryDltPedido = "delete from pedido where Producto_pro_id = " + producto + " AND Venta_ven_id = " + idVenta + ";";
            PreparedStatement s;
            try {
                s = conexion.prepareStatement(queryDltPedido);
                int result = s.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(VentaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            recargarLista();
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ningun producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dltBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton dltBtn;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pedido;
    private javax.swing.JLabel pedidoLabel;
    private javax.swing.JFormattedTextField precioFormattedTextField;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarInfoPedido() {

        String consulta = "select pro_id, pro_nombre, tip_tipo, pro_precio "
                + "from pedido join producto on (Producto_pro_id = pro_id) "
                + "join tipo on (tip_id= Tipo_tip_id) "
                + "where Venta_ven_id = " + idVenta + ";";
        PreparedStatement s;
        try {
            s = conexion.prepareStatement(consulta);
            ResultSet resultado = s.executeQuery();
            while (resultado.next()) {
                int idpro = resultado.getInt(1);
                String producto = resultado.getString(2);
                String tipo = resultado.getString(3);
                int precio = resultado.getInt(4);
                System.out.println(String.format("%s %s %s %s", Integer.toString(idpro), producto, tipo, Integer.toString(precio)));
                DefaultTableModel model = (DefaultTableModel) pedido.getModel();
                model.addRow(new Object[]{idpro, producto, tipo, precio});
                total += precio;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
