/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

// JTable Colouring Class
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomRenderer extends DefaultTableCellRenderer {

    public CustomRenderer(){
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
  
    }

    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Object val = table.getValueAt(row, 3);
        String sval = val.toString();
        if (sval.equals("Resposta Incorreta")) {
            cellComponent.setForeground(Color.red);
            cellComponent.setBackground(Color.white);
        } else {
            cellComponent.setBackground(Color.white);
            cellComponent.setForeground(Color.black);
        }
        return cellComponent;
    }
}
