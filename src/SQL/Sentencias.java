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

            String sql = "SELECT correo, contrasenia, rol, estado FROM usuarios WHERE estado = 'activo' AND correo = '" + correo + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String correoDB = rs.getString("correo");
                String psw = rs.getString("contrasenia");
                String rol = rs.getString("rol");
                String estado = rs.getString("estado");
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
                String cedula = rs.getString("cedula");
                String nombre1 = rs.getString("primerNombre");
                String nombre2 = rs.getString("segundoNombre");
                String apellido1 = rs.getString("primerApellido");
                String apellido2 = rs.getString("segundoApellido");
                Double sueldo = rs.getDouble("sueldo");
                String correo = rs.getString("correo");
                String nacionalidad = rs.getString("nacionalidad");
                String sexo = rs.getString("sexo");
                String IdDigital = rs.getString("idDigital");
                empleado.add(new Empleados(cedula,nombre1,nombre2,apellido1,
                        apellido2,sueldo,correo,nacionalidad,sexo, IdDigital));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return empleado;
    }
    
    
    public void guardarEmpleado(){
        
    }

}
