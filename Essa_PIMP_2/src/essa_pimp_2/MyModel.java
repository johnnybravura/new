/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essa_pimp_2;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return ElementContainer.elements.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "posX";
            case 1 -> "posY";
            case 2 -> "width";
            case 3 -> "height";
            default -> "";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Element element = ElementContainer.elements.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return element.getPosX();
            case 1:
                return element.getPosY();
            case 2:
                return element.getWidth();
            case 3:
                return element.getHeight();
            default:
                return 0;
        }
    }
}
