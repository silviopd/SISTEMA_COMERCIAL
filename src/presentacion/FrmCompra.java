
package presentacion;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import negocio.CompraDetalle;
import negocio.Configuracion;
import negocio.TipoComprobante;
import util.Funciones;


public class FrmCompra extends javax.swing.JDialog {

    public int accion=0;
  
    public FrmCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Centrar el formulario
        this.setLocationRelativeTo(null);
        
        //Para que se muestre los TC cuando cargue el formulario
        llenarComboTC();
        
        
        /*Llamar aqui al método para configurar las columnas del jtable tblCompraDetalle*/
        configurarTablaDetalleCompra();
        
        
        
        
        //Asignar el modo de selección y el alto a cada fila del jtable tblCompraDetalle
        tblCompraDetalle.setCellSelectionEnabled(true);
        tblCompraDetalle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCompraDetalle.setRowHeight(25);
        //Asignar el modo de selección y el alto a cada fila del jtable tblCompraDetalle
        
        

        //LLamar aqui al método para obtener la tasa de IGV
        obtenerPorcentajeIGV();
        
        
    
        
    }
    
    
    private void configurarTablaDetalleCompra(){
        try {
            ResultSet resultado = new CompraDetalle().configurarTablaDetalleCompra();
            int anchoCol[] = {70,400,70,70,90,100};
            String alineacionCol[] = {"C","I","D","D","D","D"};
            Funciones.llenarTabla(tblCompraDetalle, resultado, anchoCol, alineacionCol);
            
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }
    
    private void llenarComboTC(){
        try {
            new TipoComprobante().llenarComboTC(cboTC);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), 
                    Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    private void obtenerPorcentajeIGV(){
        try {
            String valor = new Configuracion().obtenerValorConfiguracion(1);
            this.txtPorIGV.setText(valor);
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), 
                    Funciones.NOMBRE_SOFTWARE);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNroCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTC = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtNroSerie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        /*parte 1*/
        final JTextField field = new JTextField("0");
        final DefaultCellEditor edit = new DefaultCellEditor(field);
        field.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
        field.setForeground(Color.blue);
        /*parte 1*/
        tblCompraDetalle = new javax.swing.JTable(){
            /*parte 2*/
            public boolean isCellEditable(int fila, int columna){
                if (columna == 2 || columna == 3 || columna == 4){
                    return true; //Puede editar
                }
                return false;
            }

            public TableCellEditor getCellEditor(int row, int col) {
                if (col == 2){
                    field.setDocument(new util.ValidaNumeros());
                }else{
                    field.setDocument(new util.ValidaNumeros(util.ValidaNumeros.ACEPTA_DECIMAL));
                }
                edit.setClickCountToStart(2);
                field.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        field.select(0,0);
                    }
                });
                return edit;
            }
            /*parte 2*/

        };
        btnGrabar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPorIGV = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        lblNeto = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nº Compra");

        txtNroCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNroCompra.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo Comprobante");

        cboTC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboTC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nº Serie");

        txtNroSerie.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Nº Documento");

        txtNroDoc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Compra");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("RUC:");

        txtRuc.setEditable(false);
        txtRuc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Razón Social:");

        lblRazonSocial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblRazonSocial.setText(" ");
        lblRazonSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblRazonSocial.setPreferredSize(new java.awt.Dimension(7, 22));

        btnBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargos.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Dirección:");

        lblDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDireccion.setText(" ");
        lblDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblDireccion.setPreferredSize(new java.awt.Dimension(7, 22));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Teléfono:");

        lblTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblTelefono.setText(" ");
        lblTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTelefono.setPreferredSize(new java.awt.Dimension(7, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRuc)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnAgregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add2.png"))); // NOI18N
        btnAgregar.setText("Agregar artículo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnQuitar.setText("Quitar artículo");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tblCompraDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCompraDetalle.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tblCompraDetalleMouseWheelMoved(evt);
            }
        });
        tblCompraDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblCompraDetallePropertyChange(evt);
            }
        });
        tblCompraDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCompraDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompraDetalle);
        /*parte 3*/
        tblCompraDetalle.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                field.setText("");
                field.requestFocus();
            }
        });

        field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==10){
                    if (field.getText().isEmpty()){
                        evt.consume();
                    }
                }
            }
        });
        /*parte 3*/

        btnGrabar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGrabar.setText("Grabar la compra");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Artículos registrados en la compra");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("IGV (%)");

        txtPorIGV.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPorIGV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPorIGVFocusLost(evt);
            }
        });
        txtPorIGV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorIGVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorIGVKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Sub. Total:");

        lblSubTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(153, 0, 0));
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("0.00");
        lblSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSubTotal.setPreferredSize(new java.awt.Dimension(72, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("IGV:");

        lblIGV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblIGV.setForeground(new java.awt.Color(153, 0, 0));
        lblIGV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIGV.setText("0.00");
        lblIGV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblIGV.setPreferredSize(new java.awt.Dimension(72, 20));

        lblNeto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNeto.setForeground(new java.awt.Color(153, 0, 0));
        lblNeto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNeto.setText("0.00");
        lblNeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNeto.setPreferredSize(new java.awt.Dimension(72, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Neto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addComponent(lblNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuitar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtPorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNroCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPorIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(btnQuitar))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir)
                    .addComponent(btnGrabar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        
    }//GEN-LAST:event_txtRucKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        FrmProveedorBuscar objFrm 
                = new FrmProveedorBuscar(null, true);
        objFrm.setVisible(true);
        
        if (objFrm.valorRetorno == 1){ //hizo clic en el boton aceptar
            //Colocar aqui las instrucciones para capturar los datos retornados
            int filaSeleccionada = objFrm.tblResultado.getSelectedRow();
            String ruc = objFrm.tblResultado.getValueAt(filaSeleccionada, 0).toString();
            String rasonSocial = objFrm.tblResultado.getValueAt(filaSeleccionada, 1).toString();
            String direccion = objFrm.tblResultado.getValueAt(filaSeleccionada, 2).toString();
            String telefono = objFrm.tblResultado.getValueAt(filaSeleccionada, 3).toString();
            
            this.txtRuc.setText(ruc);
            this.lblRazonSocial.setText(rasonSocial);
            this.lblDireccion.setText(direccion);
            this.lblTelefono.setText(telefono);
            
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPorIGVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorIGVKeyTyped
        
        
        
    }//GEN-LAST:event_txtPorIGVKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmArticuloBuscar objFrm 
                = new FrmArticuloBuscar(null, true);
        objFrm.setVisible(true);
        
        if (objFrm.accion == 1) { //Hizo clic en el boton Aceptar
            //Capturar los datos que retorna la venta de busqueda de artículos
            int filaSel = objFrm.tblResultado.getSelectedRow();
            
            int codigoArticulo = Integer.parseInt
                    (
                        objFrm.tblResultado.getValueAt(filaSel, 0).toString()
                    );
            
            String nombreArticulo = objFrm.tblResultado.getValueAt(filaSel, 1).toString();
            int cantidad = 0;
            double precio = 0;
            double descuento = 0;
            double importe = 0;
            
            //DefaultTableModel modelo = new DefaultTableModel();
            DefaultTableModel modelo = (DefaultTableModel)this.tblCompraDetalle.getModel();
            Object filaDatos[] = new Object[6];
            filaDatos[0] = codigoArticulo;
            filaDatos[1] = nombreArticulo;
            filaDatos[2] = cantidad;
            filaDatos[3] = precio;
            filaDatos[4] = descuento;
            filaDatos[5] = importe;
            
            modelo.addRow(filaDatos);;
            
            this.tblCompraDetalle.setModel(modelo);
            
        }
        
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblCompraDetalleMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tblCompraDetalleMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCompraDetalleMouseWheelMoved

    private void tblCompraDetallePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblCompraDetallePropertyChange
       
    }//GEN-LAST:event_tblCompraDetallePropertyChange

    private void txtPorIGVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorIGVKeyPressed
        
    }//GEN-LAST:event_txtPorIGVKeyPressed

    private void txtPorIGVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPorIGVFocusLost
        
    }//GEN-LAST:event_txtPorIGVFocusLost

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        int respuesta = Funciones.mensajeConfirmacion("Desea grabar la compra", "Confirme");
        if (respuesta == 1){
            return;
        }
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.accion = 0;
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        DefaultTableModel tablaDetalle 
                = (DefaultTableModel)this.tblCompraDetalle.getModel();
        
        int fila = this.tblCompraDetalle.getSelectedRow();
        
        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar una fila", "Verifique");
            return;
        }
        
        String articulo = tblCompraDetalle.getValueAt(fila, 1).toString();
        int respuesta = Funciones.mensajeConfirmacion
            (
                "Esta seguro de quitar el artículo: " + articulo, 
                "Confirme"
            );
        
        if (respuesta != 0){
            return;
        }
        
        tablaDetalle.removeRow( fila );
        this.tblCompraDetalle.setModel(tablaDetalle);
        
        
        
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void tblCompraDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCompraDetalleKeyPressed

        switch(evt.getKeyCode()){
            case KeyEvent.VK_DELETE:
                btnQuitar.doClick();
                break;
                
            case KeyEvent.VK_INSERT:
                btnAgregar.doClick();
                break;
        }
            
    }//GEN-LAST:event_tblCompraDetalleKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cboTC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccion;
    public javax.swing.JLabel lblIGV;
    public javax.swing.JLabel lblNeto;
    private javax.swing.JLabel lblRazonSocial;
    public javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTelefono;
    public javax.swing.JTable tblCompraDetalle;
    public com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNroCompra;
    public javax.swing.JTextField txtNroDoc;
    public javax.swing.JTextField txtNroSerie;
    public javax.swing.JTextField txtPorIGV;
    public javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
