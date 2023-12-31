/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import SQL.Sentencias;
import empleados.Empleados;
import empleados.Redimensionador;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import login.Login;

/**
 *
 * @author Gabo
 */
public class Administrador extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Redimensionador r = new Redimensionador();
    Sentencias sentencia = new Sentencias();
    Login log = new Login();

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        setLocationRelativeTo(null);
        r.resizeImageIcon(jbtnInicio, "src/images/volver.png");
        r.resizeImageIcon(jbtnGuardar, "src/images/guardar.png");
        r.resizeImageIcon(jbtnEditar, "src/images/editar.png");
        r.resizeImageIcon(jbtnCancelar, "src/images/clean.png");
        r.resizeImageIcon(jbtnEliminar, "src/images/delete.png");
        llenarCombo();
        setIconImage(new ImageIcon(getClass().getResource("/images/profesor.png")).getImage());
        cargarTabla();
        seleccionarFila();
    }

    public void seleccionarFila() {
        jtblDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtblDatos.getSelectedRow() != -1) {
                    int fila = jtblDatos.getSelectedRow();
                    jtxtCedula.setText(jtblDatos.getValueAt(fila, 0).toString());
                    jtxtPnombre.setText(jtblDatos.getValueAt(fila, 1).toString());
                    jtxtSnombre.setText(jtblDatos.getValueAt(fila, 2).toString());
                    jtxtPapellido.setText(jtblDatos.getValueAt(fila, 3).toString());
                    jtxtSapellido.setText(jtblDatos.getValueAt(fila, 4).toString());
                    jtxtTelefono.setText(jtblDatos.getValueAt(fila, 5).toString());
                    jtxtSueldo.setText(jtblDatos.getValueAt(fila, 6).toString());
                    jformatFecha.setText(jtblDatos.getValueAt(fila, 7).toString());
                    jcbxNacionalidad.setSelectedItem(jtblDatos.getValueAt(fila, 8).toString());
                    jcbxCantones.setSelectedItem(jtblDatos.getValueAt(fila, 9).toString());
                    jtxtIdDigital.setText(jtblDatos.getValueAt(fila, 10).toString());
                    jtxtCorreo.setText(jtblDatos.getValueAt(fila, 11).toString());

                    jtxtCorreo.setEnabled(false);
                    jtxtCedula.setEnabled(false);

                }
            }

        });
    }

    public void llenarCombo() {
        String[] naciones = {"Seleccionar", "Ecuatoriana", "Colombiana", "Ingles"};
        String[] cantones = {"Seleccionar", "Ambato", "Patate", "Baños"};
        for (String na : naciones) {
            jcbxNacionalidad.addItem(na);
        }
        for (String can : cantones) {
            jcbxCantones.addItem(can);
        }

    }

    public void limpiarCampos() {
        jtxtCedula.setText("");
        jtxtPnombre.setText("");
        jtxtSnombre.setText("");
        jtxtPapellido.setText("");
        jtxtSapellido.setText("");
        jtxtSueldo.setText("");
        jtxtTelefono.setText("");
        jformatFecha.setText("");
        jcbxNacionalidad.setSelectedItem("Seleccionar");
        jcbxCantones.setSelectedItem("Seleccionar");
        jtxtIdDigital.setText("");
    }
    
     public void Clean() {
        jtxtCedula.setText("");
        jtxtPnombre.setText("");
        jtxtSnombre.setText("");
        jtxtPapellido.setText("");
        jtxtSapellido.setText("");
        jtxtSueldo.setText("");
        jtxtTelefono.setText("");
        jformatFecha.setText("");
        jcbxNacionalidad.setSelectedItem("Seleccionar");
        jcbxCantones.setSelectedItem("Seleccionar");
        jtxtIdDigital.setText("");
        jtxtCedula.setEnabled(true);
        jtxtCorreo.setEnabled(true);
        jtxtCorreo.setText("");
    }

    public void cargarTabla() {

        String[] titles = {"Cedula", "Nombre ", "Nombre ", "Apellido ", "Apellido ", "Telefono", "Sueldo ", "F.Nac ", "Nacionalidad", "Canton", "IdD", "Correo"};
        modelo.setColumnIdentifiers(titles);

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Empleados empleado : sentencia.cargarDatos()) {
            Object[] fila = {empleado.getCedula(), empleado.getPrimerNombre(), empleado.getSegundoNombre(), empleado.getPrimerApellido(), empleado.getTelefono(), empleado.getSegundoApellido(),
                empleado.getSueldo(), empleado.getFechNacimiento(), empleado.getNacionalidad(), empleado.getCanton(), empleado.getIdDigital(), empleado.getCorreoPertenece()};
            modelo.addRow(fila);
        }
        jtblDatos.setModel(modelo);
    }

    public void ingresarEmpleado() {
        Sentencias s = new Sentencias();

        Empleados empleado = new Empleados(jtxtCedula.getText(), jtxtPnombre.getText(), jtxtSnombre.getText(),
                jtxtPapellido.getText(), jtxtSapellido.getText(), jtxtTelefono.getText(), Double.parseDouble(jtxtSueldo.getText()),
                jformatFecha.getText(), jcbxNacionalidad.getSelectedItem().toString(), jcbxCantones.getSelectedItem().toString(),
                jtxtIdDigital.getText(), jtxtCorreo.getText());

        if (s.ingresarEmpleado(empleado, jtxtCorreo.getText()) > 0) {
            JOptionPane.showMessageDialog(null, "Empleado Ingresado");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Empleado No  Ingresado");
        }
    }

    public void editarEmpleado() {
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de actualizar?",
                "Actualizar estudiante", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {

            Empleados empleado = new Empleados(jtxtCedula.getText(), jtxtPnombre.getText(), jtxtSnombre.getText(),
                    jtxtPapellido.getText(), jtxtSapellido.getText(), jtxtTelefono.getText(), Double.parseDouble(jtxtSueldo.getText()),
                    jformatFecha.getText(), jcbxNacionalidad.getSelectedItem().toString(), jcbxCantones.getSelectedItem().toString(),
                    jtxtIdDigital.getText(), jtxtCorreo.getText());

            if (sentencia.editarEmpleado(empleado, jtxtCorreo.getText()) > 0) {
                JOptionPane.showMessageDialog(rootPane, "Se ha actualizado el estudiante");
                limpiarCampos();
                cargarTabla();
            }
        }
    }
    
     public void eliminarEmpleado() {
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de Eliminar?",
                "Eliminar Empleado", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            
              Empleados empleado = new Empleados(jtxtCedula.getText(), jtxtPnombre.getText(), jtxtSnombre.getText(),
                    jtxtPapellido.getText(), jtxtSapellido.getText(), jtxtTelefono.getText(), Double.parseDouble(jtxtSueldo.getText()),
                    jformatFecha.getText(), jcbxNacionalidad.getSelectedItem().toString(), jcbxCantones.getSelectedItem().toString(),
                    jtxtIdDigital.getText(), jtxtCorreo.getText());
         
            if (sentencia.eliminarEmpleado(empleado, jtxtCorreo.getText())> 0) {
                JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el Empleado");
                limpiarCampos();
                cargarTabla();
                Clean();
            }
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

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblCedula = new javax.swing.JLabel();
        jlblPnombre = new javax.swing.JLabel();
        jlblSnombre = new javax.swing.JLabel();
        jlblPapellido = new javax.swing.JLabel();
        jlblSapellido = new javax.swing.JLabel();
        jlblSueldo = new javax.swing.JLabel();
        jlblFechaNacimiento = new javax.swing.JLabel();
        jlblNacionalidad = new javax.swing.JLabel();
        jlblCanton = new javax.swing.JLabel();
        jlblTsangre = new javax.swing.JLabel();
        jtxtCedula = new javax.swing.JTextField();
        jtxtPnombre = new javax.swing.JTextField();
        jtxtSnombre = new javax.swing.JTextField();
        jtxtPapellido = new javax.swing.JTextField();
        jtxtSapellido = new javax.swing.JTextField();
        jcbxNacionalidad = new javax.swing.JComboBox<>();
        jtxtIdDigital = new javax.swing.JTextField();
        jtxtSueldo = new javax.swing.JTextField();
        jformatFecha = new javax.swing.JFormattedTextField();
        jtxtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlblTelefono = new javax.swing.JLabel();
        jtxtTelefono = new javax.swing.JTextField();
        jcbxCantones = new javax.swing.JComboBox<>();
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

        jlblFechaNacimiento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblFechaNacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jlblFechaNacimiento.setText("Fecha de Nacimiento:");

        jlblNacionalidad.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblNacionalidad.setForeground(new java.awt.Color(0, 0, 0));
        jlblNacionalidad.setText("Nacionalidad:");

        jlblCanton.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblCanton.setForeground(new java.awt.Color(0, 0, 0));
        jlblCanton.setText("Canton");

        jlblTsangre.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblTsangre.setForeground(new java.awt.Color(0, 0, 0));
        jlblTsangre.setText("ID Digital");

        jcbxNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxNacionalidadActionPerformed(evt);
            }
        });

        jformatFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Correo:");

        jlblTelefono.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jlblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jlblTelefono.setText("Telefono:");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSapellido)
                            .addComponent(jlblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSapellido)
                            .addComponent(jtxtTelefono))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jlblNacionalidad)
                        .addGap(18, 18, 18)
                        .addComponent(jcbxNacionalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblTsangre)
                            .addComponent(jlblCanton)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtIdDigital, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbxCantones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtCorreo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblSueldo)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblFechaNacimiento)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jformatFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
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
                        .addComponent(jlblFechaNacimiento)
                        .addComponent(jformatFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlblSnombre)
                            .addComponent(jtxtSnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jlblPapellido)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblSapellido)
                            .addComponent(jtxtSapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTelefono)
                            .addComponent(jtxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbxNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblNacionalidad))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblCanton)
                            .addComponent(jcbxCantones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtIdDigital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTsangre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Administrador de Empleados");

        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
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
        jtblDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jtblDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(0, 70, Short.MAX_VALUE))
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
                        .addGap(6, 6, 6)
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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
        Clean();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
        ingresarEmpleado();
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        log.setVisible(true);
    }//GEN-LAST:event_jbtnInicioActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        // TODO add your handling code here:
        editarEmpleado();
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jcbxNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxNacionalidadActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarEmpleado();
    }//GEN-LAST:event_jbtnEliminarActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnInicio;
    private javax.swing.JComboBox<String> jcbxCantones;
    private javax.swing.JComboBox<String> jcbxNacionalidad;
    private javax.swing.JFormattedTextField jformatFecha;
    private javax.swing.JLabel jlblCanton;
    private javax.swing.JLabel jlblCedula;
    private javax.swing.JLabel jlblFechaNacimiento;
    private javax.swing.JLabel jlblNacionalidad;
    private javax.swing.JLabel jlblPapellido;
    private javax.swing.JLabel jlblPnombre;
    private javax.swing.JLabel jlblSapellido;
    private javax.swing.JLabel jlblSnombre;
    private javax.swing.JLabel jlblSueldo;
    private javax.swing.JLabel jlblTelefono;
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
    private javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables
}
