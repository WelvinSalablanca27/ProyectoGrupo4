/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ProductoControlador;
import Entidades.Producto;
import DAO.DAOProducto;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author D23
 */
public class VistaProducto extends javax.swing.JPanel {

    private int id_productoSeleccionada;

    private final ProductoControlador controladorProducto;

    /**
     * Creates new form VistaProducto
     */
    public VistaProducto() {
        initComponents();
        this.controladorProducto = new ProductoControlador();
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        // Obtener todas las categorías del controlador
        List<Producto> productos = controladorProducto.obtenerTodosProductos();
        if (productos != null) {
            // Obtener el modelo existente de la tabla con un casting adecuado
            DefaultTableModel model = (DefaultTableModel) tablaProducto.getModel();

            // Limpiar las filas existentes
            model.setRowCount(0);

            // Llenar las filas con los datos de los productos
            for (Producto pro : productos) {
                Object[] row = {
                    pro.getId_producto(),
                    pro.getNombre_prod(),
                    pro.getTipo_produ(),
                    pro.getExistencia_Prod(),
                    pro.getPrecio_Costo(),
                    pro.getPrecio_Venta(),
                    pro.getFecha_caducidad()
                };
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNombreProducto = new javax.swing.JTextField();
        textTipo_Produ = new javax.swing.JTextField();
        textcantidad_Existente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textPrecio_Costo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textfecha_caducidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textPrecio_Venta = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Existencia", "Precio", "Precio Venta", "Fecha_Caducidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tipo ");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Existencia");

        textNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreProductoActionPerformed(evt);
            }
        });

        textTipo_Produ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTipo_ProduActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Precio ");

        textPrecio_Costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecio_CostoActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Caducidad");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Datos Productos");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
                accionBotonGuardar(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonEliminar(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBontoActualizar(evt);
            }
        });

        textBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textBuscarKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Precio Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(textNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addGap(42, 42, 42)
                .addComponent(textPrecio_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTipo_Produ, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textcantidad_Existente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(textfecha_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(80, 80, 80)
                .addComponent(textPrecio_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addComponent(textNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(textPrecio_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textTipo_Produ, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(textcantidad_Existente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(textfecha_caducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(textPrecio_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void textPrecio_CostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecio_CostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPrecio_CostoActionPerformed

    private void accionBotonGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonGuardar
        // TODO add your handling code here:

        // Retrieve input values
        String Nombre_prod = textNombreProducto.getText();
        String tipo_produ = textTipo_Produ.getText();
        double Existencia_Prod;
        double precio_costo;
        double precio_venta;
        Date fecha_caducidad;

        try {
            Existencia_Prod = Double.parseDouble(textcantidad_Existente.getText());
            precio_costo = Double.parseDouble(textPrecio_Costo.getText());
            precio_venta = Double.parseDouble(textPrecio_Venta.getText());
            fecha_caducidad = java.sql.Date.valueOf(textfecha_caducidad.getText());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!Nombre_prod.isEmpty() && !tipo_produ.isEmpty()) {
            controladorProducto.crearProducto(Nombre_prod, tipo_produ, Existencia_Prod,
                    precio_costo, precio_venta, fecha_caducidad);
            cargarDatosTabla();

            textNombreProducto.setText("");
            textTipo_Produ.setText("");
            textcantidad_Existente.setText("");
            textPrecio_Costo.setText("");
            textPrecio_Venta.setText("");
            textfecha_caducidad.setText("");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_accionBotonGuardar

    private void accionBotonEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonEliminar

        int filaSeleccionada = tablaProducto.getSelectedRow();

        if (filaSeleccionada != -1) {
            try {
                // Assuming the ID is stored in column index 0
                Object idObject = tablaProducto.getValueAt(filaSeleccionada, 0);
                int id_producto = Integer.parseInt(idObject.toString()); // Safe conversion

                // Delete the product
                controladorProducto.eliminarProducto(id_producto);
                cargarDatosTabla();
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al obtener el ID del producto.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_accionBotonEliminar

    private void accionBontoActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBontoActualizar
        // TODO add your handling code here:                                             
        String Nombre_prod = textNombreProducto.getText();
        String tipo_produ = textTipo_Produ.getText();

        try {
            double Existencia_Prod = Double.parseDouble(textcantidad_Existente.getText());
            double precio_Costo = Double.parseDouble(textPrecio_Costo.getText());
            double precio_Venta = Double.parseDouble(textPrecio_Venta.getText());

            // Validar el campo de fecha antes de convertir
            java.sql.Date fechaCaducidadSql = null;
            if (!textPrecio_Venta.getText().isEmpty()) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaCaducidadUtil = formatoFecha.parse(textfecha_caducidad.getText());
                fechaCaducidadSql = new java.sql.Date(fechaCaducidadUtil.getTime());
            } else {
                JOptionPane.showMessageDialog(this, "El campo de fecha está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir de la ejecución si la fecha no es válida
            }

            // Validar que los valores numéricos sean positivos
            if (Existencia_Prod < 0 || precio_Costo < 0 || precio_Venta < 0) {
                JOptionPane.showMessageDialog(this, "Los valores de cantidad, precio costo y precio venta deben ser positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar que el ID del producto es válido antes de actualizar
            if (id_productoSeleccionada > 0 && !Nombre_prod.isEmpty() && !tipo_produ.isEmpty()) {
                System.out.println("Actualizando producto con ID: " + id_productoSeleccionada);

                controladorProducto.actualizarProducto(id_productoSeleccionada, Nombre_prod, tipo_produ,
                        Existencia_Prod, precio_Costo, precio_Venta, fechaCaducidadSql);
                cargarDatosTabla();

                limpiarCampos();

                btnEliminar.setEnabled(true);
                btnGuardar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en la conversión de números. Asegúrate de ingresar valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Usa yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

// Método para limpiar los campos después de actualizar
    private void limpiarCampos() {
        textNombreProducto.setText("");
        textTipo_Produ.setText("");
        textcantidad_Existente.setText("");
        textPrecio_Costo.setText("");
        textPrecio_Venta.setText("");
        textfecha_caducidad.setText("");
        id_productoSeleccionada = 0; // Re
    }//GEN-LAST:event_accionBontoActualizar

    private void tablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductoMouseClicked
        // TODO add your handling code here:                                       
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tablaProducto.getSelectedRow();
            if (filaSeleccionada != -1) {
                try {
                    Object idObj = tablaProducto.getValueAt(filaSeleccionada, 0);
                    id_productoSeleccionada = Integer.parseInt(idObj.toString());

                    String Nombre_prod = (String) tablaProducto.getValueAt(filaSeleccionada, 1);
                    String tipo_produ = (String) tablaProducto.getValueAt(filaSeleccionada, 2);
                    String existencia = String.valueOf(tablaProducto.getValueAt(filaSeleccionada, 3));
                    String precioCosto = String.valueOf(tablaProducto.getValueAt(filaSeleccionada, 4));
                    String precioVenta = String.valueOf(tablaProducto.getValueAt(filaSeleccionada, 5));
                    Object fechaObj = tablaProducto.getValueAt(filaSeleccionada, 6);
                    String fechaCaducidad = fechaObj != null ? fechaObj.toString() : "";

                    textNombreProducto.setText(Nombre_prod);
                    textTipo_Produ.setText(tipo_produ);
                    textcantidad_Existente.setText(existencia);
                    textPrecio_Costo.setText(precioCosto);
                    textPrecio_Venta.setText(precioVenta);
                    textfecha_caducidad.setText(fechaCaducidad);

                    // Enable buttons appropriately
                    btnGuardar.setEnabled(false);
                    btnActualizar.setEnabled(true);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error al obtener los datos de la tabla.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_tablaProductoMouseClicked

    private void textBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarKeyPressed
        String textoBusqueda = textBuscar.getText().trim().toLowerCase();

        // Obtener la lista de productos
        List<Producto> productos = controladorProducto.obtenerTodosProductos();
        DefaultTableModel modelo = (DefaultTableModel) tablaProducto.getModel();
        modelo.setRowCount(0);

        if (productos != null) {
            for (Producto pro : productos) {
                // Convertir fecha_caducidad a String para comparación
                String fechaCaducidadStr = "";
                if (pro.getFecha_caducidad() != null) {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    fechaCaducidadStr = formatoFecha.format(pro.getFecha_caducidad());
                }

                // Verificar si el producto coincide con el filtro de búsqueda
                if (textoBusqueda.isEmpty()
                        || pro.getNombre_prod().toLowerCase().contains(textoBusqueda)
                        || pro.getTipo_produ().toLowerCase().contains(textoBusqueda)
                        || String.valueOf(pro.getExistencia_Prod()).contains(textoBusqueda)
                        || String.valueOf(pro.getPrecio_Costo()).contains(textoBusqueda)
                        || String.valueOf(pro.getPrecio_Venta()).contains(textoBusqueda)
                        || fechaCaducidadStr.contains(textoBusqueda)) {

                    // Agregar producto a la tabla si coincide
                    Object[] fila = {
                        pro.getId_producto(),
                        pro.getNombre_prod(),
                        pro.getTipo_produ(),
                        pro.getExistencia_Prod(),
                        pro.getPrecio_Costo(),
                        pro.getPrecio_Venta(),
                        fechaCaducidadStr
                    };

                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_textBuscarKeyPressed

    private void textTipo_ProduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTipo_ProduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTipo_ProduActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField textBuscar;
    private javax.swing.JTextField textNombreProducto;
    private javax.swing.JTextField textPrecio_Costo;
    private javax.swing.JTextField textPrecio_Venta;
    private javax.swing.JTextField textTipo_Produ;
    private javax.swing.JTextField textcantidad_Existente;
    private javax.swing.JTextField textfecha_caducidad;
    // End of variables declaration//GEN-END:variables
}
