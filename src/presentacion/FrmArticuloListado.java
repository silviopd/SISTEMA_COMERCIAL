package presentacion;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import negocio.Categoria;
import util.Funciones;


public class FrmArticuloListado extends javax.swing.JInternalFrame {

    private ResultSet resultado;
    
    public FrmArticuloListado() {
        initComponents();
        llenarComboBusqueda();
        cargarDatosConsulta();
        filtrar();
        
        cboBusqueda.setSelectedIndex(1);
        
    }
    
    private void llenarComboBusqueda(){
        String campos[] = new Categoria().obtenerCamposBusqueda();
        this.cboBusqueda.removeAllItems();
        for (int i = 0; i < campos.length; i++) {
            String campo = campos[i];
            cboBusqueda.addItem(campo);
        }
    }
    
    private void cargarDatosConsulta(){
        try {
            this.resultado = new Categoria().listar();
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void filtrar(){
        try {
            int anchoColumnas[] = {140,300,220};
            String alineacionColumnas[] = {"C","I","I"};
            Funciones.llenarTablaBusqueda
                (
                    tblListado, 
                    resultado, 
                    anchoColumnas, 
                    alineacionColumnas, 
                    cboBusqueda.getSelectedItem().toString(), 
                    txtValorBusqueda.getText()
                );
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbOpciones = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        cboBusqueda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtValorBusqueda = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int columna){
                /*if (columna == 0){
                    return true;
                }*/
                return false;
            }
        };

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Categorías");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        tbOpciones.setRollover(true);

        jLabel1.setText("Buscar por:");
        tbOpciones.add(jLabel1);

        cboBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tbOpciones.add(cboBusqueda);

        jLabel2.setText(" Valor: ");
        tbOpciones.add(jLabel2);

        txtValorBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorBusquedaKeyTyped(evt);
            }
        });
        tbOpciones.add(txtValorBusqueda);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnAgregar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnEliminar);

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.setFocusable(false);
        btnRefrescar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRefrescar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        tbOpciones.add(btnRefrescar);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir2.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        tbOpciones.add(btnSalir);

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        this.cboBusqueda.setPreferredSize( new Dimension(140, 30) );
        this.txtValorBusqueda.setPreferredSize( new Dimension(180, 30) );
        
        this.tbOpciones.add(this.cboBusqueda, 1);
        this.tbOpciones.add(this.txtValorBusqueda, 3);
        
        txtValorBusqueda.requestFocus();
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtValorBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorBusquedaKeyTyped
        filtrar();
    }//GEN-LAST:event_txtValorBusquedaKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmCategoriaAgregarEditar objFrm = new FrmCategoriaAgregarEditar(null, true);
        objFrm.setTitle("Agregar nueva categoría");
        objFrm.operacion = "agregar";
        objFrm.setVisible(true);
        
        //Funciones.mensajeInformacion("mensaje de prueba", "");
        
        if (objFrm.valorRetorno == 1){ //Significa que se ha agregado un nuevo registro
            this.cargarDatosConsulta();
            this.filtrar();
        }
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        FrmCategoriaAgregarEditar objFrm = new FrmCategoriaAgregarEditar(null, true);
        objFrm.setTitle("Editar nueva categoría");
        objFrm.operacion = "editar";
        
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0 ) {
            Funciones.mensajeError("No ha seleccionado un registro", Funciones.NOMBRE_SOFTWARE);
            return; //detiene el programa
        }
        
        int codigoCategoria = Integer.parseInt
            ( 
                this.tblListado.getValueAt(fila, 0).toString() 
            );
        
        //Funciones.mensajeInformacion(String.valueOf(codigoCategoria), "CODIGO CAT.");
        
        objFrm.leerDatosCategoria(codigoCategoria);
        objFrm.setVisible(true);
        ////////////////////////////////////////////
        
        if (objFrm.valorRetorno == 1){
            this.cargarDatosConsulta();
            this.filtrar();
        }
        
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        if (evt.getClickCount() == 2 ){
            btnEditar.doClick();
        }
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListado.getSelectedRow();
        if (fila < 0 ) {
            Funciones.mensajeError("No ha seleccionado un registro", Funciones.NOMBRE_SOFTWARE);
            return; //detiene el programa
        }
        
        int codigoCategoria = Integer.parseInt
            ( 
                this.tblListado.getValueAt(fila, 0).toString() 
            );
        
        int r = Funciones.mensajeConfirmacion("Esta seguro de eliminar el registro seleccionado", "Confirme");
        
        if ( r != 0){
            return; //detiene el programa
        }
        
        try {
            boolean resultado;
            Categoria objCat = new Categoria();
            objCat.setCodigoCategoria(codigoCategoria);
            resultado = objCat.eliminar();
            
            if (resultado){
                cargarDatosConsulta();
                filtrar();
            }
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), Funciones.NOMBRE_SOFTWARE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarDatosConsulta();
        filtrar();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar tbOpciones;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField txtValorBusqueda;
    // End of variables declaration//GEN-END:variables
}
