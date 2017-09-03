package com.xfinity.view.widget;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author supun
 */
public class CustomCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof String[]) {
            String[] values = (String[]) value;
            return new JLabel(values[0]);
        } else {
            return new JLabel(value == null ? "" : value.toString());
        }
    }
}
