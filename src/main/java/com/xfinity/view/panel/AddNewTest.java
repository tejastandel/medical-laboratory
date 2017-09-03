/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.view.panel;

import com.xfinity.controller.TestController;
import com.xfinity.data_access_object.Element;
import com.xfinity.data_access_object.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Supun Lakshan
 */
public class AddNewTest extends javax.swing.JPanel {

    private final DefaultTableModel model;

    /**
     * Creates new form AddNewTest
     */
    public AddNewTest() {
        initComponents();
        tblResults.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        tblResults.setRowHeight((int) (tblResults.getRowHeight() * 1.5));
        model = (DefaultTableModel) tblResults.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTestName = new javax.swing.JTextField();
        cmbSpecimen = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResults = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFooter = new javax.swing.JTextPane();
        btnAddElement = new javax.swing.JButton();
        btnRemoveElement = new javax.swing.JButton();

        jLabel1.setText("Test Name");

        cmbSpecimen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blood", "Urine" }));

        jLabel2.setText("Specimen");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Results", "Units", "Ranges"
            }
        ));
        tblResults.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblResults);
        if (tblResults.getColumnModel().getColumnCount() > 0) {
            tblResults.getColumnModel().getColumn(0).setResizable(false);
            tblResults.getColumnModel().getColumn(1).setResizable(false);
            tblResults.getColumnModel().getColumn(2).setResizable(false);
            tblResults.getColumnModel().getColumn(3).setResizable(false);
        }

        jScrollPane3.setViewportView(txtFooter);

        btnAddElement.setText("+");
        btnAddElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddElementActionPerformed(evt);
            }
        });

        btnRemoveElement.setText("-");
        btnRemoveElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveElementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTestName)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSpecimen, 0, 123, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoveElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSpecimen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddElement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveElement)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Test test = new Test();
        test.setName(txtTestName.getText());
        test.setSpeciemen(String.format("%S", cmbSpecimen.getSelectedItem().toString()));
        List<Element> elements = new ArrayList<>();
        int indexDescription = model.findColumn("Description");
        int indexResults = model.findColumn("Results");
        int indexUnits = model.findColumn("Units");
        int indexRanges = model.findColumn("Ranges");
        for (Vector row : ((Vector<Vector>) model.getDataVector())) {
            String name = row.get(indexDescription) != null ? row.get(indexDescription).toString().trim() : "";
            String units = row.get(indexUnits) != null ? row.get(indexUnits).toString().trim() : "";
            String ranges = row.get(indexRanges) != null ? row.get(indexRanges).toString().trim() : "";
            String results = row.get(indexResults) != null ? row.get(indexResults).toString().trim() : "";

            if (name.isEmpty()) {
                continue;
            }
            Element e = new Element();
            e.setName(name);
            e.setUnit(units);
            e.setRange(ranges);
            e.setResults(results);
            elements.add(e);
        }
        test.setElements(elements);
        test.setFooter(txtFooter.getText());
        boolean addTest = TestController.addTest(test);
        JOptionPane.showMessageDialog(null, addTest ? "Test Added Successfully" : "Unable to Add Test", null, JOptionPane.INFORMATION_MESSAGE);
        model.setRowCount(0);
        txtFooter.setText("");
        txtTestName.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddElementActionPerformed
        model.addRow(new Vector(4));
    }//GEN-LAST:event_btnAddElementActionPerformed

    private void btnRemoveElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveElementActionPerformed
        int selectedRow;
        if ((selectedRow = tblResults.getSelectedRow()) > 0) {
            model.removeRow(selectedRow);
        }
    }//GEN-LAST:event_btnRemoveElementActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddElement;
    private javax.swing.JButton btnRemoveElement;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbSpecimen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblResults;
    private javax.swing.JTextPane txtFooter;
    private javax.swing.JTextField txtTestName;
    // End of variables declaration//GEN-END:variables
}