/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import admin.Usuarios;
import domain.Conexion;
import java.sql.*;

/**
 *
 * @author Gabo
 */
public class SQL_Cuenta {
    
    Conexion conexion = new Conexion();
    Connection c = conexion.conectar();
    int n=0;
    
    // Metodo para gregar una nueva Cuenta de tipo Usuario 
    public int ingresarUsuario(Usuarios usuario){
        String insert = "INSERT INTO usuarios (correo,contrasenia,rol) VALUES(?,?,?)";
        
        try {
            PreparedStatement pst = c.prepareStatement(insert);
            pst.setString(1, usuario.getCorreo());
            pst.setString(2, usuario.getContrasenia());
            pst.setString(3, usuario.getRol());
            n =  pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;
    }
    
}
