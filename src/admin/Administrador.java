/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import SQL.Sentencias;
import empleados.Empleados;
import empleados.Redimensionador;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabo
 */
public class Administrador extends javax.swing.JFrame {
DefaultTableModel modelo = new DefaultTableModel();
 Redimensionador r = new Redimensionador();
 Sentencias sentencia =  new Sentencias();

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        setLocationRelativeTo(null);
        r.resizeImageIcon(jbtnInicio, "src/images/home.png");
        r.resizeImageIcon(jbtnGuardar, "src/images/guardar.png");
        r.resizeImageIcon(jbtnEditar, "src/images/editar.png");
        r.resizeImageIcon(jbtnCancelar, "src/images/clean.png");
        r.resizeImageIcon(jbtnEliminar, "src/images/delete.png");
        setIconImage(new ImageIcon(getClass().getResource("/images/profesor.png")).getImage());
        cargarTabla();

    }
    
    public void cargarTabla(){
        String[] titles= {"Cedula","Nombre 1","Nombre2","Apellido1","Apellido2","Sueldo","Correo","Nacionalidad","Sexo","ID Digital"};
        modelo.setColumnIdentifiers(titles);
        for (Empleados empleado : sentencia.cargarDatos()) {
            Object[] fila = {empleado.getCedula(),empleado.getPrimerNombre(),empleado.getSegundoNombre(),empleado.getPrimerApellido(),empleado.getSegundoApellido()
           ,empleado.getSueldo(),empleado.getCorreo(),empleado.getNacionalidad(),empleado.getSexo(),empleado.getIdDigital()};
            modelo.addRow(fila);
        }
        jtblDatos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblCedula = new javax.swing.JLabel();
        jlblPnombre = new javax.swing.JLabel();
        jlblSnombre = new javax.swing.JLabel();
        jlblPapellido = new javax.swing.JLabel();
        jlblSapellido = new javax.swing.JLabel();
        jlblSueldo = new javax.swing.JLabel();
        jlblCorreo = new javax.swing.JLabel();
        jlblNacionalidad = new javax.swing.JLabel();
        jlblSexo = new javax.swing.JLabel();
        jlblTsangre = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtPnombre = new javax.swing.JTextField();
        jtxtSnombre = new javax.swing.JTextField();
        jtxtPapellido = new javax.swing.JTextField();
        jtxtSapellido = new javax.swing.JTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jcbxNacionalidad = new javax.swing.JComboBox<>();
        jchxMasculino = new javax.swing.JCheckBox();
        jchxFemenino = new javax.swing.JCheckBox();
        jtxtIdDigital = new javax.swing.JTextField();
        jtxtSueldo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtnGuardar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnInicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jlblCedula.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblCedula.setForeground(new java.awt.Color(0, 0, 0));
        jlblCedula.setText("Cedula:");

        jlblPnombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblPnombre.setForeground(new java.awt.Color(0, 0, 0));
        jlblPnombre.setText("Primer Nombre:");

        jlblSnombre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblSnombre.setForeground(new java.awt.Color(0, 0, 0));
        jlblSnombre.setText("Segundo Nombre");

        jlblPapellido.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblPapellido.setForeground(new java.awt.Color(0, 0, 0));
        jlblPapellido.setText("Primer Apellido:");

        jlblSapellido.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblSapellido.setForeground(new java.awt.Color(0, 0, 0));
        jlblSapellido.setText("Segundo Apellido:");

        jlblSueldo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblSueldo.setForeground(new java.awt.Color(0, 0, 0));
        jlblSueldo.setText("Sueldo:");

        jlblCorreo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jlblCorreo.setText("Correo:");

        jlblNacionalidad.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblNacionalidad.setForeground(new java.awt.Color(0, 0, 0));
        jlblNacionalidad.setText("Nacionalidad:");

        jlblSexo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblSexo.setForeground(new java.awt.Color(0, 0, 0));
        jlblSexo.setText("Sexo:");

        jlblTsangre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblTsangre.setForeground(new java.awt.Color(0, 0, 0));
        jlblTsangre.setText("ID Digital");

        jcbxNacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGroup.add(jchxMasculino);
        jchxMasculino.setText("M");

        btnGroup.add(jchxFemenino);
        jchxFemenino.setText("F");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblCedula)
                        .addGap(55, 55, 55)
                        .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSnombre)
                            .addComponent(jlblPapellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSnombre)
                            .addComponent(jtxtPapellido)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblPnombre)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtPnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblSapellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtSapellido)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblSueldo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtCorreo)
                            .addComponent(jtxtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblSexo)
                            .addComponent(jlblNacionalidad)
                            .addComponent(jlblTsangre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jchxMasculino)
                                    .addGap(18, 18, 18)
                                    .addComponent(jchxFemenino)
                                    .addGap(26, 26, 26))
                                .addComponent(jcbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtxtIdDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCedula)
                    .addComponent(jlblSueldo)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblPnombre)
                        .addComponent(jtxtPnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblCorreo)
                        .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblSnombre)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtSnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlblNacionalidad)
                                .addComponent(jcbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jlblPapellido)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblSapellido)
                            .addComponent(jtxtSapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTsangre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblSexo)
                            .addComponent(jchxMasculino)
                            .addComponent(jchxFemenino))
                        .addGap(18, 18, 18)
                        .addComponent(jtxtIdDigital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Administrador de Empleados");

        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInicioActionPerformed(evt);
            }
        });

        jtblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtblDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnInicio;
    private javax.swing.JComboBox<String> jcbxNacionalidad;
    private javax.swing.JCheckBox jchxFemenino;
    private javax.swing.JCheckBox jchxMasculino;
    private javax.swing.JLabel jlblCedula;
    private javax.swing.JLabel jlblCorreo;
    private javax.swing.JLabel jlblNacionalidad;
    private javax.swing.JLabel jlblPapellido;
    private javax.swing.JLabel jlblPnombre;
    private javax.swing.JLabel jlblSapellido;
    private javax.swing.JLabel jlblSexo;
    private javax.swing.JLabel jlblSnombre;
    private javax.swing.JLabel jlblSueldo;
    private javax.swing.JLabel jlblTsangre;
    private javax.swing.JTable jtblDatos;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtIdDigital;
    private javax.swing.JTextField jtxtPapellido;
    private javax.swing.JTextField jtxtPnombre;
    private javax.swing.JTextField jtxtSapellido;
    private javax.swing.JTextField jtxtSnombre;
    private javax.swing.JTextField jtxtSueldo;
    // End of variables declaration//GEN-END:variables
}
