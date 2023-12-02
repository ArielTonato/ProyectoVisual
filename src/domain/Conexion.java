/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Conexion {

    Connection conexion = null;

    public Connection conectar() {
        String url = "jdbc:mysql://aws.connect.psdb.cloud/visualproyecto?sslMode=VERIFY_IDENTITY";
        String user = "58glqboc06iha6cboynx";
        String password = "pscale_pw_FEfkoJ7tpWUEpM4oF6uXF7FZK8RcJRnWWnX0zG3KtNg";
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return conexion;
    }
}
