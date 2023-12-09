/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.*;
import admin.Usuarios;
import domain.Conexion;
import java.util.ArrayList;

/**
 *
 * @author Gabo
 */
public class Sentencias {
    
    Conexion conexion = new Conexion();
    
    // Metodo de Obtencion de las Credenciales de la BD para el acceso
    public ArrayList<Usuarios> ingreso(String correo) {
        
     ArrayList<Usuarios> usuario = new ArrayList<>();
    
    try {
        Connection con = conexion.conectar();
        
        String sql = "SELECT correo, contrasenia, rol, estado FROM usuarios WHERE estado = 'activo' AND correo = '" + correo + "'";
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()) {
            String correoDB = rs.getString("correo");
            String psw = rs.getString("contrasenia");
            String rol = rs.getString("rol");
            String estado = rs.getString("estado");
             usuario.add(new Usuarios (correoDB, psw, rol, estado));
        }
        
    } catch (Exception e) {
        System.out.println(e);
    }
    return usuario;
}

    
    
}
