/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import JDBC.CategoriaJDBC;
import POJO.CategoriaPOJO;
import javax.swing.JOptionPane;


/**
 *
 * @author Personalizados
 */
public class PrincipalCategoria extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalCategoria
     */
    public PrincipalCategoria() {
        initComponents();
        cargarTabla();
    }
    private void cargarTabla(){
        tbCategoria.setModel(CategoriaJDBC.cargarTabla());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogoAltaCategoria = new javax.swing.JDialog();
        lbNombreAl = new javax.swing.JLabel();
        lbDescripcionAl = new javax.swing.JLabel();
        tfNombreAl = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescripcionAl = new javax.swing.JTextArea();
        lbAltaCategoria = new javax.swing.JLabel();
        btnGuardarAl = new javax.swing.JButton();
        btnCancelarAl = new javax.swing.JButton();
        dialogoActualizarCategoria = new javax.swing.JDialog();
        lbActualizarCategorias = new javax.swing.JLabel();
        lbIdAc = new javax.swing.JLabel();
        lbNombreAc = new javax.swing.JLabel();
        lbDescripcionAc = new javax.swing.JLabel();
        tfIdAc = new javax.swing.JTextField();
        tfNombreAc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDescripcionAc = new javax.swing.JTextArea();
        btnGuardarAc = new javax.swing.JButton();
        btnCancelarAc = new javax.swing.JButton();
        lbtitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAlta = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        lbNombreAl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNombreAl.setText("Nombre: ");

        lbDescripcionAl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDescripcionAl.setText("Descripción:");

        taDescripcionAl.setColumns(20);
        taDescripcionAl.setRows(5);
        jScrollPane2.setViewportView(taDescripcionAl);

        lbAltaCategoria.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbAltaCategoria.setText("Alta de Categorias");

        btnGuardarAl.setText("Guardar");
        btnGuardarAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlActionPerformed(evt);
            }
        });

        btnCancelarAl.setText("Cancelar");
        btnCancelarAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoAltaCategoriaLayout = new javax.swing.GroupLayout(dialogoAltaCategoria.getContentPane());
        dialogoAltaCategoria.getContentPane().setLayout(dialogoAltaCategoriaLayout);
        dialogoAltaCategoriaLayout.setHorizontalGroup(
            dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoAltaCategoriaLayout.createSequentialGroup()
                .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoAltaCategoriaLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(lbAltaCategoria))
                    .addGroup(dialogoAltaCategoriaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDescripcionAl)
                            .addComponent(lbNombreAl))
                        .addGap(18, 18, 18)
                        .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dialogoAltaCategoriaLayout.createSequentialGroup()
                                .addComponent(btnGuardarAl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarAl))
                            .addComponent(tfNombreAl)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        dialogoAltaCategoriaLayout.setVerticalGroup(
            dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoAltaCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAltaCategoria)
                .addGap(42, 42, 42)
                .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreAl)
                    .addComponent(tfNombreAl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescripcionAl)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogoAltaCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarAl)
                    .addComponent(btnCancelarAl))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lbActualizarCategorias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbActualizarCategorias.setText("Actualizar Categorias");

        lbIdAc.setText("ID:");

        lbNombreAc.setText("Nombre:");

        lbDescripcionAc.setText("Descripción:");

        tfIdAc.setEditable(false);

        taDescripcionAc.setColumns(20);
        taDescripcionAc.setRows(5);
        jScrollPane3.setViewportView(taDescripcionAc);

        btnGuardarAc.setText("Guardar");
        btnGuardarAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAcActionPerformed(evt);
            }
        });

        btnCancelarAc.setText("Cancelar");
        btnCancelarAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoActualizarCategoriaLayout = new javax.swing.GroupLayout(dialogoActualizarCategoria.getContentPane());
        dialogoActualizarCategoria.getContentPane().setLayout(dialogoActualizarCategoriaLayout);
        dialogoActualizarCategoriaLayout.setHorizontalGroup(
            dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoActualizarCategoriaLayout.createSequentialGroup()
                .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoActualizarCategoriaLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lbActualizarCategorias))
                    .addGroup(dialogoActualizarCategoriaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescripcionAc)
                            .addComponent(lbNombreAc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbIdAc, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dialogoActualizarCategoriaLayout.createSequentialGroup()
                                .addComponent(btnGuardarAc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarAc))
                            .addComponent(tfIdAc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombreAc)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        dialogoActualizarCategoriaLayout.setVerticalGroup(
            dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoActualizarCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbActualizarCategorias)
                .addGap(36, 36, 36)
                .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdAc)
                    .addComponent(tfIdAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreAc)
                    .addComponent(tfNombreAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescripcionAc)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogoActualizarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarAc)
                    .addComponent(btnCancelarAc))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtitulo.setText("Control de Categorias");

        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbCategoria);

        btnAlta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnBaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBaja.setText("Baja");

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRefresh.setText("Refresh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnAlta)
                .addGap(33, 33, 33)
                .addComponent(btnBaja)
                .addGap(34, 34, 34)
                .addComponent(btnActualizar)
                .addGap(40, 40, 40)
                .addComponent(btnRefresh)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(lbtitulo)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbtitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed

        dialogoAltaCategoria.setLocationRelativeTo(this);
        dialogoAltaCategoria.setSize(599, 374);
        dialogoAltaCategoria.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

         int filaSeleccionada = tbCategoria.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Primero selcciona una fila");

        } else {
            String idCategoria = tbCategoria.getValueAt(filaSeleccionada, 0).toString();
            String nombre_categoria = tbCategoria.getValueAt(filaSeleccionada, 1).toString();
            String descripcion_categoria = tbCategoria.getValueAt(filaSeleccionada, 2).toString();

            tfIdAc.setText(idCategoria);
            tfNombreAc.setText(nombre_categoria);
            taDescripcionAc.setText(descripcion_categoria);

           dialogoActualizarCategoria.setLocationRelativeTo(this);
           dialogoActualizarCategoria.setSize(599, 374);
           dialogoActualizarCategoria.setVisible(true);
        }
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.setVisible(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCancelarAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlActionPerformed
        
        tfNombreAl.setText(null);
        taDescripcionAl.setText(null);
        dialogoAltaCategoria.setVisible(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAlActionPerformed

    private void btnCancelarAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAcActionPerformed

        tfNombreAc.setText(null);
        taDescripcionAc.setText(null);
        dialogoActualizarCategoria.setVisible(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarAcActionPerformed

    private void btnGuardarAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlActionPerformed

        String nombre_categoria = tfNombreAl.getText();
        String descripcion_categoria = taDescripcionAl.getText();
        
        CategoriaPOJO pojo = new CategoriaPOJO();
        pojo.setNombre_categoria(nombre_categoria);
        pojo.setDescripcion_categoria(descripcion_categoria);
       
        boolean x = CategoriaJDBC.insertar(pojo);

        if (x == true) {
            JOptionPane.showMessageDialog(null, "Exito");
            cargarTabla();
            //limpiaDialogoAlta();
            dialogoAltaCategoria.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarAlActionPerformed

    private void btnGuardarAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAcActionPerformed

        String idCategoria = tfIdAc.getText();
        String nombre_categoria = tfNombreAc.getText();
        String descripcion_categoria = taDescripcionAc.getText();

        CategoriaPOJO pojo = new CategoriaPOJO();
        pojo.setIdCategoria(Integer.parseInt(idCategoria));
        pojo.setNombre_categoria(nombre_categoria);
        pojo.setDescripcion_categoria(descripcion_categoria);

        boolean x = CategoriaJDBC.actualizar(pojo);

        if (x == true) {
            JOptionPane.showMessageDialog(null, "Exito al actualizar");
            cargarTabla();

            //Hay que hacer limpia dialogo 2 y llamarlo aqui
            dialogoActualizarCategoria.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar");
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarAcActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelarAc;
    private javax.swing.JButton btnCancelarAl;
    private javax.swing.JButton btnGuardarAc;
    private javax.swing.JButton btnGuardarAl;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JDialog dialogoActualizarCategoria;
    private javax.swing.JDialog dialogoAltaCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbActualizarCategorias;
    private javax.swing.JLabel lbAltaCategoria;
    private javax.swing.JLabel lbDescripcionAc;
    private javax.swing.JLabel lbDescripcionAl;
    private javax.swing.JLabel lbIdAc;
    private javax.swing.JLabel lbNombreAc;
    private javax.swing.JLabel lbNombreAl;
    private javax.swing.JLabel lbtitulo;
    private javax.swing.JTextArea taDescripcionAc;
    private javax.swing.JTextArea taDescripcionAl;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTextField tfIdAc;
    private javax.swing.JTextField tfNombreAc;
    private javax.swing.JTextField tfNombreAl;
    // End of variables declaration//GEN-END:variables
}
