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

public class CustomRendererColorDraw extends DefaultTableCellRenderer {

    public CustomRendererColorDraw() {
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);

    }

    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        cellComponent.setForeground(Color.white);
        cellComponent.setBackground(Color.GREEN);
//        Object val = table.getValueAt(row, 2);
//        int ival = Integer.parseInt(val.toString());
//        if ((ival >= 0) && (ival < 6)) {
//            cellComponent.setForeground(Color.white);
//            cellComponent.setBackground(Color.red);
//        } else if (ival < 10) {
//            cellComponent.setForeground(Color.white);
//            cellComponent.setBackground(Color.orange);
//        } else if (ival < 14) {
//            cellComponent.setForeground(Color.white);
//            cellComponent.setBackground(Color.yellow);
//        } else if (ival <= 20) {
//            cellComponent.setForeground(Color.white);
//            cellComponent.setBackground(Color.GREEN);
//        } else {
//            cellComponent.setForeground(Color.black);
//            cellComponent.setBackground(Color.white);
//        }
        return cellComponent;
    }

}
