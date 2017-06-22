package com.xfinity.view.widget;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

public class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {

        private TableCellEditor editor;

        private final TableModel tableModel;

        public CustomTableCellEditor(TableModel tableModel) {
            this.tableModel = tableModel;
        }

        @Override
        public Object getCellEditorValue() {
            if (editor != null) {
                return editor.getCellEditorValue();
            }
            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (tableModel.getValueAt(row, 5) == null) {
                tableModel.setValueAt(value, row, 5);
            }
            value = tableModel.getValueAt(row, 5);
            if (value == null) {
                editor = new DefaultCellEditor(new JTextField());
            } else if (value instanceof String) {
                editor = new DefaultCellEditor(new JTextField());
            } else if (value instanceof String[]) {
                String[] values = (String[]) value;
                JComboBox jComboBox = new JComboBox(values);
                jComboBox.setEditable(true);
                jComboBox.setSelectedIndex(0);
                editor = new DefaultCellEditor(jComboBox);
                tableModel.setValueAt(values[0], row, 1);
            }
            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
}
