package service;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pnunes
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    private static Map<String,BufferedImage> t;
    public ImageRenderer(Map<String,BufferedImage> t){
        ImageRenderer.t = t;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
         String numero = table.getValueAt(row, 1).toString();
        if (value != null) {
            label.setHorizontalAlignment(JLabel.CENTER);
            //value is parameter which filled by BufferedImage
            try {
                BufferedImage foto = t.get(numero);
                ImageIcon imageIcon = new javax.swing.ImageIcon(foto);
                Image img = imageIcon.getImage(); // transform it 
                Image newimg = img.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);  // transform it back
                label.setIcon(imageIcon);
            } catch (Exception e) {
//                System.out.println(e.getMessage());
                ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Fotos/anonimo1.jpg")); // load the image to a imageIcon
                Image img = imageIcon.getImage(); // transform it 
                Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);  // transform it back
                label.setIcon(imageIcon);
            }

        } else {
            label.setText("none");
        }
        return label;
    }
}
