/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matt
 */
public class Redimensionador {
    
    public void resizeImageIcon(JButton button, String ruta) {
        ImageIcon imageIcon = new ImageIcon(ruta);
        Image image = imageIcon.getImage();

        int buttonWidth = button.getWidth();
        int buttonHeight = button.getHeight();

        Image resizedImage = image.getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        button.setIcon(resizedIcon);
    }
    
    public void resizeImageLabel(JLabel label, String ruta) {
        ImageIcon imageIcon = new ImageIcon(ruta);
        Image image = imageIcon.getImage();
        
         int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        
         Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        label.setIcon(resizedIcon);
        

        
}
    
}
