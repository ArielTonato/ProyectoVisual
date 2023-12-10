/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.*;
import admin.Usuarios;
import domain.Conexion;
import empleados.Empleados;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabo
 */
public class Sentencias {

    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();

    // Metodo de Obtencion de las Credenciales de la BD para el acceso
    public ArrayList<Usuarios> ingreso(String correo) {

        ArrayList<Usuarios> usuario = new ArrayList<>();

        try {

            String sql = "SELECT Corr_Usu, Con_Usu, Rol_Usu, Est_Usu FROM usuarios WHERE Est_Usu = 'activo' AND Corr_Usu = '" + correo + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String correoDB = rs.getString("Corr_Usu");
                String psw = rs.getString("Con_Usu");
                String rol = rs.getString("Rol_Usu");
                String estado = rs.getString("Est_Usu");
                usuario.add(new Usuarios(correoDB, psw, rol, estado));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

    //Metodo para cargar los datos del Empleado de la BD en nuestra Ventana
    public ArrayList<Empleados> cargarDatos() {

        ArrayList<Empleados> empleado = new ArrayList<>();

        try {

            String sql = "SELECT * FROM empleados";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String cedula = rs.getString("Ced_Emp");
                String nombre1 = rs.getString("Nom1_Emp");
                String nombre2 = rs.getString("Nom2_Emp");
                String apellido1 = rs.getString("Ape1_Emp");
                String apellido2 = rs.getString("Ape2_Emp");
                String telefono = rs.getString("Tel_Emp");
                Double sueldo = rs.getDouble("Sue_Emp");
                String nacimiento = rs.getNString("Fec_Nac");
                String nacionalidad = rs.getString("Nac_Emp");
                String canton = rs.getNString("Can_Emp");
                String IdDigital = rs.getString("idDigital");
                String correo = rs.getString("Corr_Emp_Per");
                empleado.add(new Empleados(cedula, nombre1, nombre2, apellido1,
                        apellido2, telefono, sueldo, nacimiento, nacionalidad, canton, IdDigital, correo));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empleado;
    }

    public String obtenerForeignKey(String correo) {

        String sql = "SELECT Corr_Usu FROM usuarios WHERE Corr_Usu = '" + correo + "'";
        //String obtenerCorreo = "SELECT correo FROM usuarios WHERE correo = (SELECT correo FROM trabajadores WHERE rol = 'empleado')";
        String almacenar = "";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String correoDB = rs.getString("Corr_Usu");
                almacenar = correoDB;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return almacenar;
    }

    public int editarEmpleado(Empleados empleado, String correo) {
        int n = 0;
        PreparedStatement preparedStatement = null;
        try {
            String edit = "UPDATE empleados set Ced_Emp=?, Nom1_Emp=?, Nom2_Emp=?, Ape1_Emp=?, Ape2_Emp=?,Tel_Emp=?, Sue_Emp=?, Fec_Nac=?, Nac_Emp=?, "
                    + "Can_Emp=?, idDigital=? WHERE Corr_Emp_Per='" + correo + "'";

            preparedStatement = con.prepareStatement(edit);

            preparedStatement.setString(1, empleado.getCedula());
            preparedStatement.setString(2, empleado.getPrimerNombre());
            preparedStatement.setString(3, empleado.getSegundoNombre());
            preparedStatement.setString(4, empleado.getPrimerApellido());
            preparedStatement.setString(5, empleado.getSegundoApellido());
            preparedStatement.setString(6, empleado.getTelefono());
            preparedStatement.setDouble(7, empleado.getSueldo());
            preparedStatement.setString(8, empleado.getFechNacimiento());
            preparedStatement.setString(9, empleado.getNacionalidad());
            preparedStatement.setString(10, empleado.getCanton());
            preparedStatement.setString(11, empleado.getIdDigital());

            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return n;
    }
    
    
     public int eliminarEmpleado(Empleados empleado , String correo) {
        int n = 0;
        empleado.setCorreoPertenece(correo);
        try {
            String eliminar = "DELETE FROM empleados WHERE Corr_Emp_Per=?";
            PreparedStatement statement = con.prepareStatement(eliminar);
            statement.setString(1, empleado.getCorreoPertenece());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }
    

    public int ingresarEmpleado(Empleados empleado, String correoComparacion) {

        empleado.setCorreoPertenece(obtenerForeignKey(correoComparacion));
        int n = 0;
        PreparedStatement preparedStatement = null;

        try {
            String insertQuery = "INSERT INTO empleados (Ced_Emp, Nom1_Emp, Nom2_Emp, Ape1_Emp, Ape2_Emp,Tel_Emp, Sue_Emp, Fec_Nac, Nac_Emp, "
                    + "Can_Emp, idDigital, Corr_Emp_Per) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            preparedStatement = con.prepareStatement(insertQuery);

            preparedStatement.setString(1, empleado.getCedula());
            preparedStatement.setString(2, empleado.getPrimerNombre());
            preparedStatement.setString(3, empleado.getSegundoNombre());
            preparedStatement.setString(4, empleado.getPrimerApellido());
            preparedStatement.setString(5, empleado.getSegundoApellido());
            preparedStatement.setString(6, empleado.getTelefono());
            preparedStatement.setDouble(7, empleado.getSueldo());
            preparedStatement.setString(8, empleado.getFechNacimiento());
            preparedStatement.setString(9, empleado.getNacionalidad());
            preparedStatement.setString(10, empleado.getCanton());
            preparedStatement.setString(11, empleado.getIdDigital());
            preparedStatement.setString(12, empleado.getCorreoPertenece());

            n = preparedStatement.executeUpdate(); // Ejecuta la inserción

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return n;
    }

}
