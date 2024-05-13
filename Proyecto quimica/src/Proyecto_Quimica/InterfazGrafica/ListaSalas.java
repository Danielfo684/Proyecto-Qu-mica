package Proyecto_Quimica.InterfazGrafica;

import Proyecto_Quimica.Codigo_Principal.Controlador.LocalizacionController;
import Proyecto_Quimica.Modelos.Localizacion;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListaSalas extends javax.swing.JInternalFrame {
    private LocalizacionController localizacionController;
    List<Localizacion> listaSalas;
   

    public ListaSalas(LocalizacionController localizacionController) {
        this.localizacionController = localizacionController;
        initComponents();
        listaSalas = localizacionController.getSalas();
        mostrarDatos(listaSalas);
        
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
        TablaSalas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Salas");

        TablaSalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Sala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaSalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaSalasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaSalas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void TablaSalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaSalasMouseClicked
  
        int filaClickada = TablaSalas.getSelectedRow();
        // Verificamos que se haya seleccionado una fila
        if (filaClickada != -1) { 
            Localizacion sala = listaSalas.get(filaClickada);
            // Abrir una nueva ventana de edición de usuario
            FichaSalas fichaSalas = new FichaSalas(localizacionController, sala.getIdLocalizacion(), sala.getNombreAlmacen(), TablaSalas); 
            this.add(fichaSalas);
            fichaSalas.show();
        }
    }//GEN-LAST:event_TablaSalasMouseClicked
    
    
    public JTable getTablaUsuarios(){
        return TablaSalas;
    }
    
    public void mostrarDatos(List<Localizacion> listaSalas){
        
        // La JTable model que he añadido en el diseño de la vista
        // tomará la estructura del DefaultTableModel, ya que no tenemos
        // una estructura definida para la tabla
        // https://www.thoughtco.com/defaulttablemodel-overview-2033890
        // https://es.stackoverflow.com/questions/23295/asignar-un-defaulttablemodel-a-un-jtable-mvc
        // y con vieew.getTablaUsuarios() cogemos el JTable de la vista y con el 
        // .getModel(), segun la definicion: Returns the TableModel that provides the data displayed by this JTable.
        DefaultTableModel model = (DefaultTableModel) this.getTablaUsuarios().getModel();
        // Limpiar la tabla antes de cargar nuevos datos
        model.setRowCount(0); 
        for (Localizacion sala: listaSalas){
            Object[] fila = {sala.getIdLocalizacion(), sala.getNombreAlmacen()};
            model.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaSalas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
