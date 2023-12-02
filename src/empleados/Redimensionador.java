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
    
    public void resizeImageIcon(JPanel panel, String ruta) {
    ImageIcon imageIcon = new ImageIcon(ruta);
    Image image = imageIcon.getImage();

    int panelWidth = panel.getWidth();
    int panelHeight = panel.getHeight();

    Image resizedImage = image.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(resizedImage);

    JLabel label = new JLabel(resizedIcon);
    panel.removeAll();
    panel.add(label);
    panel.revalidate();
    panel.repaint();
}
    
}
