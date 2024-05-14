/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto_Quimica.InterfazGrafica;

import Proyecto_Quimica.BBDD.Conexion;
import Proyecto_Quimica.Codigo_Principal.Controlador.LocalizacionController;
import Proyecto_Quimica.InterfazGrafica.ListaSalas;
import Proyecto_Quimica.Modelos.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mdpan
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private boolean esProfesor;

    public VistaPrincipal(boolean esProfesor) {
        setSize(500, 500); //establece el tamaño de la ventana principal
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //Hace que el programa se 
        // cierre al cerrar la ventana
        initComponents();
        setTitle("Gestor de Química"); //Título para la ventana del JFrame
        setLocationRelativeTo(null);  //nos centra la ventana de JFrame en el centro de la pantalla

        // Ocultar botones si el usuario no es profesor
        if (!esProfesor) {
            jLabel4.setVisible(false);
            bInsertarReactivo.setVisible(false);
            bInsertarMaterial.setVisible(false);
            bInsertarProductoAuxiliar.setVisible(false);
            miCargarDatos.setVisible(false);
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
        TablaProductos = new javax.swing.JTable();
        escritorio = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bInsertarProductoAuxiliar = new javax.swing.JButton();
        busquedaPorNombre = new javax.swing.JTextField();
        iBuscarFormato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bVolverInicio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        bInsertarReactivo = new javax.swing.JButton();
        bInsertarMaterial = new javax.swing.JButton();
        iBuscarTipoProducto = new javax.swing.JTextField();
        botonBusqueda = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mExportar = new javax.swing.JMenu();
        miExportarUsuarios = new javax.swing.JMenuItem();
        miExportarCategorias = new javax.swing.JMenuItem();
        miExportarSalas = new javax.swing.JMenuItem();
        miExportarQuimicos = new javax.swing.JMenuItem();
        miCargarDatos = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();
        mSalas = new javax.swing.JMenu();
        miListaSalas = new javax.swing.JMenuItem();
        miNuevoSala = new javax.swing.JMenuItem();
        mUbicaciones = new javax.swing.JMenu();
        miListaCategorias = new javax.swing.JMenuItem();
        miNuevoCategoria = new javax.swing.JMenuItem();
        mQuimicos = new javax.swing.JMenu();
        miListaQuimicos = new javax.swing.JMenuItem();
        miNuevoQuimico = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        miSobreMi = new javax.swing.JMenuItem();

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaProductos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Insertar");

        jLabel2.setText("Por tipo de producto");

        jLabel3.setText("Por formato");

        bInsertarProductoAuxiliar.setText("Producto auxiliar");

        busquedaPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaPorNombreActionPerformed(evt);
            }
        });

        iBuscarFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBuscarFormatoActionPerformed(evt);
            }
        });

        jLabel1.setText("Por nombre");

        bVolverInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bVolverInicio.setText("Volver");
        bVolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverInicioActionPerformed(evt);
            }
        });

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Tipo", "Ubicación", "Localización"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPrincipal);

        bInsertarReactivo.setText("Reactivo");
        bInsertarReactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarReactivoActionPerformed(evt);
            }
        });

        bInsertarMaterial.setText("Material");
        bInsertarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarMaterialActionPerformed(evt);
            }
        });

        iBuscarTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBuscarTipoProductoActionPerformed(evt);
            }
        });

        botonBusqueda.setText("Buscar");
        botonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBusquedaActionPerformed(evt);
            }
        });

        escritorio.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(bInsertarProductoAuxiliar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(busquedaPorNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(iBuscarFormato, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(bVolverInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(bInsertarReactivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(bInsertarMaterial, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(iBuscarTipoProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(botonBusqueda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(iBuscarTipoProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addComponent(iBuscarFormato, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonBusqueda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addComponent(busquedaPorNombre, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bVolverInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bInsertarReactivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bInsertarMaterial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bInsertarProductoAuxiliar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(botonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iBuscarTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iBuscarFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bInsertarReactivo)
                .addGap(18, 18, 18)
                .addComponent(bInsertarMaterial)
                .addGap(18, 18, 18)
                .addComponent(bInsertarProductoAuxiliar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(bVolverInicio)
                .addGap(24, 24, 24))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        mArchivo.setText("Archivo");

        mExportar.setText("Exportar");

        miExportarUsuarios.setText("Usuarios");
        miExportarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExportarUsuariosActionPerformed(evt);
            }
        });
        mExportar.add(miExportarUsuarios);

        miExportarCategorias.setText("Categorías");
        mExportar.add(miExportarCategorias);

        miExportarSalas.setText("Salas");
        mExportar.add(miExportarSalas);

        miExportarQuimicos.setText("Productos Químicos");
        mExportar.add(miExportarQuimicos);

        mArchivo.add(mExportar);

        miCargarDatos.setText("Cargar Datos...");
        miCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCargarDatosActionPerformed(evt);
            }
        });
        mArchivo.add(miCargarDatos);

        miSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mArchivo.add(miSalir);

        BarraMenu.add(mArchivo);

        mSalas.setText("Salas");

        miListaSalas.setText("Lista");
        miListaSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListaSalasActionPerformed(evt);
            }
        });
        mSalas.add(miListaSalas);

        miNuevoSala.setText("Nuevo");
        mSalas.add(miNuevoSala);

        BarraMenu.add(mSalas);

        mUbicaciones.setText("Ubicaciones");

        miListaCategorias.setText("Lista");
        miListaCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListaCategoriasActionPerformed(evt);
            }
        });
        mUbicaciones.add(miListaCategorias);

        miNuevoCategoria.setText("Nuevo");
        mUbicaciones.add(miNuevoCategoria);

        BarraMenu.add(mUbicaciones);

        mQuimicos.setText("Productos Químicos");

        miListaQuimicos.setText("Lista");
        mQuimicos.add(miListaQuimicos);

        miNuevoQuimico.setText("Nuevo");
        mQuimicos.add(miNuevoQuimico);

        BarraMenu.add(mQuimicos);

        mAyuda.setText("Ayuda");

        miSobreMi.setText("Sobre...");
        mAyuda.add(miSobreMi);

        BarraMenu.add(mAyuda);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverInicioActionPerformed
        Inicio VentanaInicio = new Inicio();  //acceso a la ventana anterior
        VentanaInicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bVolverInicioActionPerformed

    private void busquedaPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaPorNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedaPorNombreActionPerformed

    private void iBuscarFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBuscarFormatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iBuscarFormatoActionPerformed

    private void iBuscarTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBuscarTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iBuscarTipoProductoActionPerformed

    private void bInsertarReactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertarReactivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bInsertarReactivoActionPerformed

    private void bInsertarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertarMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bInsertarMaterialActionPerformed

    private void miExportarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExportarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miExportarUsuariosActionPerformed

    private void miCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCargarDatosActionPerformed
        /*
        int opcion = JOptionPane.showConfirmDialog(null,
            "Quieres cargar datos para la base de datos \"Quimicos\"? La información existente se sobreescribirá.",
            "Confirmar reescritura",
            JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION){
            CargarDatosController cargarDatosController = new CargarDatosController();
            cargarDatosController.cargarDatosDesdeCSV();
        }
         */
    }//GEN-LAST:event_miCargarDatosActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        // Lógica para mostrar el cuadro de diálogo de confirmación
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de querer salir?", "Salir", JOptionPane.YES_NO_OPTION);

        // Verificar la opción seleccionada por el usuario
        if (opcion == JOptionPane.YES_OPTION) {
            // Si el usuario elige "Sí", cerrar la aplicación
            System.exit(0);
        }
    }//GEN-LAST:event_miSalirActionPerformed

    private void miListaCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListaCategoriasActionPerformed

    }//GEN-LAST:event_miListaCategoriasActionPerformed

    private void miListaSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListaSalasActionPerformed

        // Creamos una instancia de LocalizacionController
        LocalizacionController localizacionController = new LocalizacionController();
        ListaSalas listaSalas = new ListaSalas(localizacionController);

        // Añadimos la ventana al escritorio (JDesktopPane)
        escritorio.add(listaSalas);
        listaSalas.show();

    }//GEN-LAST:event_miListaSalasActionPerformed

    private void botonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBusquedaActionPerformed
        DefaultTableModel tablaBase = new DefaultTableModel(new Object[][]{},
                new String[]{"Nombre", "Cantidad", "Tipo", "Ubicación", "Localización"});

        ArrayList<Producto> listado = Conexion.busquedaBasica(busquedaPorNombre.getText());
        for (Producto producto : listado) {
            tablaBase.addRow(new Object[]{
                producto.getNombre(), producto.getCantidad(),
                producto.getTipoToString(), producto.getNombreUbicacion(), 
                producto.getNombreLocalizacion()
            });
                    tablaPrincipal.setModel(tablaBase);
        }

    }//GEN-LAST:event_botonBusquedaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton bInsertarMaterial;
    private javax.swing.JButton bInsertarProductoAuxiliar;
    private javax.swing.JButton bInsertarReactivo;
    private javax.swing.JButton bVolverInicio;
    private javax.swing.JButton botonBusqueda;
    private javax.swing.JTextField busquedaPorNombre;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JTextField iBuscarFormato;
    private javax.swing.JTextField iBuscarTipoProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mExportar;
    private javax.swing.JMenu mQuimicos;
    private javax.swing.JMenu mSalas;
    private javax.swing.JMenu mUbicaciones;
    private javax.swing.JMenuItem miCargarDatos;
    private javax.swing.JMenuItem miExportarCategorias;
    private javax.swing.JMenuItem miExportarQuimicos;
    private javax.swing.JMenuItem miExportarSalas;
    private javax.swing.JMenuItem miExportarUsuarios;
    private javax.swing.JMenuItem miListaCategorias;
    private javax.swing.JMenuItem miListaQuimicos;
    private javax.swing.JMenuItem miListaSalas;
    private javax.swing.JMenuItem miNuevoCategoria;
    private javax.swing.JMenuItem miNuevoQuimico;
    private javax.swing.JMenuItem miNuevoSala;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JMenuItem miSobreMi;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
