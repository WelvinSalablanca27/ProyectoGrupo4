/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Entidades.Proveedor;
import Controlador.ProveedorControlador;
import Controlador.CompraControlador;
import Entidades.Compra;
import Controlador.DetalleCompraControlador;
import Entidades.DetalleCompra;
import Controlador.ProductoControlador;
import Entidades.DetalleCompra;
import Entidades.Producto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * @author Welvin
 */
public class VistaCompra extends javax.swing.JPanel {

    private final CompraControlador compraControlador;
    private final DetalleCompraControlador detalleCompraControlador;
    private final ProductoControlador productoControlador;
    private final ProveedorControlador proveedorControlador;

    private Integer idProveedorSeleccionado = null;
    private Integer idProductoSeleccionado = null;

    private Timer timer; // Variable de instancia para el Timer
    private boolean horabd = false;

    public VistaCompra() {
        initComponents();
        this.compraControlador = new CompraControlador();
        this.detalleCompraControlador = new DetalleCompraControlador();
        this.productoControlador = new ProductoControlador();
        this.proveedorControlador = new ProveedorControlador();

        eventoComboProductos();

        selectorfechaContratacion.setDate(new Date());
        ((JTextField) selectorfechaContratacion.getDateEditor().getUiComponent()).setEditable(false);

        jDateChooser1.setDate(new Date());
        ((JTextField) selectorfechaContratacion.getDateEditor().getUiComponent()).setEditable(false);

        jDateChooser2.setDate(new Date());
        ((JTextField) selectorfechaContratacion.getDateEditor().getUiComponent()).setEditable(false);

        // Limpiar las filas vacías de tablaDetalles
        DefaultTableModel modelDetalles = (DefaultTableModel) tablaDetalles.getModel();
        modelDetalles.setRowCount(0);

        cargarDatosTablaCompras();
        cargarProveedor();
        cargarProductos();
        actualizarHora();
    }

    private void limpiar() {
        textBuscar.setText("");
        idProveedorSeleccionado = null;
        selectorfechaContratacion.setDate(new Date());
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());

        // Limpiar la tabla de detalles
        tablaDetalles.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"ID Producto ", "Producto", "FechaCompra", "FechaIngreso",
            "FechaCaducidad", "Precio ", "Cantidad", "Subtotal"}));

        cargarDatosTablaCompras();
        cargarProveedor();
        cargarProductos();

        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);

        horabd = false; // Restablece para mostrar hora actual
        actualizarHora(); // Vuelve a iniciar el timer
    }

    private void actualizarHora() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Managua"));

        // Detener el timer anterior si existe
        if (timer != null) {
            timer.stop();
        }

        if (horabd) {
            return; // No actualiza la hora si está cargada desde la base de datos
        }

        timer = new Timer(1000, e -> {
            Date now = new Date();
            jLabel6.setText(sdf.format(now));
        });
        timer.start();
    }

    private void cargarDatosTablaCompras() {
        List<Compra> compras = compraControlador.obtenerTodasCompras();

        if (compras != null) {

            DefaultTableModel model = (DefaultTableModel) tablaCompras.getModel();
            model.setRowCount(0);

            for (Compra c : compras) {

                Proveedor proveedor = proveedorControlador.obtenerClientePorId(c.getId_Proveedor());
                String Nombre_Proveedor = proveedor.getTelefono()+ " " + proveedor.getTipo_distribuidor();

                Object[] row = {
                    c.getId_compra(),
                    c.getFe_compra(),
                    Nombre_Proveedor,
                    c.getTotalCompra()
                };
                model.addRow(row);
            }
        }
    }
    
  private void cargarProveedor() {
        try {
            // Obtener las categorías desde el controlador
            List<Proveedor> proveedor = proveedorControlador.obtenerTodosProveedores();

            // Limpiar el combo box por si tiene datos
            ComboProveedor.removeAllItems();

            // Agregar cada categoría al combo box
            for (Proveedor p : proveedor) {
                ComboProveedor.addItem(p.getNombre_Proveedor()+ " " + p.getTelefono()); // Mostrar el nombre
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los empleados: " + e.getMessage());
        }
    }

   

    private void cargarProductos() {
        try {
            // Obtener las categorías desde el controlador
            List<Producto> productos = productoControlador.obtenerTodosProductos();

            // Limpiar el combo box por si tiene datos
            comboProductos.removeAllItems();

            // Agregar cada categoría al combo box
            for (Producto p : productos) {
                comboProductos.addItem(p.getNombre_prod()); // Mostrar el nombre
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los productos: " + e.getMessage());
        }
    }

    private void eventoComboProductos() {
        comboProductos.addActionListener(e -> {
            // Obtener el índice seleccionado
            int indiceSeleccionado = comboProductos.getSelectedIndex();

            if (indiceSeleccionado >= 0) { // Verificar que se haya seleccionado algo
                try {
                    // Obtener la lista de categorías desde el controlador o memoria
                    List<Producto> productos = productoControlador.obtenerTodosProductos();

                    // Obtener el objeto de categoría correspondiente al índice seleccionado
                    Producto productoSeleccionado = productos.get(indiceSeleccionado);

                    // Actualizar la variable global con el ID de la categoría seleccionada
                    idProductoSeleccionado = productoSeleccionado.getId_producto();

                    // Actualizar el campo textPrecio con el precio unitario del producto
                    textPrecio.setText(String.valueOf(productoSeleccionado.getPrecio_Costo()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al seleccionar categoría: " + ex.getMessage());
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectorfechaContratacion = new com.toedter.calendar.JDateChooser();
        ComboProveedor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText(" Proveedor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fecha ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        selectorfechaContratacion.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(selectorfechaContratacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 30, 147, 31));

        ComboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        jPanel1.add(ComboProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel1.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 95, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("00:00:00");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 30, 99, 31));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Producto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        jPanel1.add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 30, 79, 31));

        jButton1.setText("Agregar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 120, 31));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 140, 30));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fecha Ingreso");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Fecha caducidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Fecha compra", "Producto", "Precio", "Fecha Ingreso", "Fecha Caducidad", "Catidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDetallesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDetalles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 750, 110));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Buscar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        textBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campotextBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(textBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 315, 31));

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaCompras);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 740, 80));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonEliminar(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 125, 32));

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonActualizar(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 125, 32));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonGuardar(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 125, 30));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonLimpiar(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 125, 31));

        jButton2.setText("Quitar detalle");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/291474364_116090381133197_1246855093686710006_n (1)-Photoroom (1).jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -110, 1020, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void accionBotonActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonActualizar

    }//GEN-LAST:event_accionBotonActualizar

    private void accionBotonEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonEliminar

    }//GEN-LAST:event_accionBotonEliminar

    private void accionBotonGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonGuardar

    }//GEN-LAST:event_accionBotonGuardar

    private void tablaDetallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDetallesMouseClicked

    }//GEN-LAST:event_tablaDetallesMouseClicked

    private void campotextBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campotextBuscarKeyTyped

    }//GEN-LAST:event_campotextBuscarKeyTyped

    private void accionBotonLimpiar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonLimpiar

    }//GEN-LAST:event_accionBotonLimpiar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad;
    private javax.swing.JComboBox<String> ComboProveedor;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser selectorfechaContratacion;
    private javax.swing.JTable tablaCompras;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
