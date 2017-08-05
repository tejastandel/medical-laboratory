/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.view.panel;

import com.xfinity.controller.DoctorController;
import com.xfinity.controller.ReportController;
import com.xfinity.controller.TestController;
import com.xfinity.data_access_object.Doctor;
import com.xfinity.data_access_object.Element;
import com.xfinity.data_access_object.ElementResult;
import com.xfinity.data_access_object.Report;
import com.xfinity.data_access_object.Test;
import com.xfinity.util.PrintManager;
import com.xfinity.view.widget.CustomCellRenderer;
import com.xfinity.view.widget.CustomTableCellEditor;
import com.xfinity.view.widget.Gender;
import com.xfinity.view.widget.Title;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Supun Lakshan
 */
public class AddTestResult extends javax.swing.JPanel {

    /**
     * Creates new form AddRestResult
     */
    public AddTestResult() {
        initComponents();
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(5));
        jTable1.removeColumn(jTable1.getColumnModel().getColumn(4));
        jTable1.setRowHeight((int) (jTable1.getRowHeight() * 1.5));
        jTable1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        DefaultComboBoxModel<Test> cmbTestModel = (DefaultComboBoxModel<Test>) cmbTest.getModel();
        cmbTestModel.removeAllElements();
        List<Test> availableTests = TestController.getAvailableTests();
        availableTests.stream().forEach((test) -> {
            cmbTestModel.addElement(test);
        });

        DefaultComboBoxModel<Doctor> cmbDocModel = (DefaultComboBoxModel<Doctor>) cmbRefferedBy.getModel();
        ArrayList<Doctor> doctors = DoctorController.getDoctors();
        doctors.add(0, new Doctor());
        doctors.stream().forEach((doc) -> {
            cmbDocModel.addElement(doc);
        });
        btnGroupAgeSuffix.add(rBtnYears);
        btnGroupAgeSuffix.add(rBtnMonths);
        rBtnYears.setSelected(true);

        cmbTitle.setModel(new DefaultComboBoxModel(new Title[]{
            new Title("MR", Gender.MALE),
            new Title("MRS", Gender.FEMALE),
            new Title("MISS", Gender.FEMALE),
            new Title("BABY", Gender.UNKNOWN),
            new Title("REV", Gender.UNKNOWN),
            new Title("DR", Gender.UNKNOWN),
            new Title("MS", Gender.FEMALE),
            new Title("MASTER", Gender.MALE)
        }));
        cmbGender.setEnabled(false);

        jTable1.getColumnModel().getColumn(1).setCellEditor(new CustomTableCellEditor(jTable1.getModel()));
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAgeSuffix = new javax.swing.ButtonGroup();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        btnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cmbTitle = new javax.swing.JComboBox();
        cmbGender = new javax.swing.JComboBox();
        txtAge = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rBtnYears = new javax.swing.JRadioButton();
        rBtnMonths = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTest = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbRefferedBy = new javax.swing.JComboBox();
        btnReset = new javax.swing.JButton();
        testPerformedDateChooser = new de.wannawork.jcalendar.JCalendarComboBox();
        specimenCollectedDateChooser = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();

        btnSave.setText("Save and Print");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Result", "Units", "Ranges", "ElementId", "ExpectedResults", "Grouping", "FloatingPoints"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbTitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MR", "MRS", "MISS", "BABY", "REV", "DR", "MS", "MASTER" }));
        cmbTitle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTitleItemStateChanged(evt);
            }
        });

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel1.setText("Title");

        jLabel2.setText("Name");

        jLabel3.setText("Gender");

        jLabel4.setText("Age");

        rBtnYears.setText("Year(s)");

        rBtnMonths.setText("Month(s)");

        jLabel5.setText("Time Period");

        jLabel7.setText("Referred By");

        cmbTest.setModel(new DefaultComboBoxModel<Test>());
        cmbTest.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTestItemStateChanged(evt);
            }
        });

        jLabel8.setText("Test");

        cmbRefferedBy.setModel(new DefaultComboBoxModel<Doctor>());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTitle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rBtnYears)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rBtnMonths))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRefferedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTest, 0, 122, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rBtnYears)
                    .addComponent(rBtnMonths)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRefferedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setText("Speciemen Collected Date");

        jLabel9.setText("Test Performed Date");

        jLabel10.setText("Comment");

        txtComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(specimenCollectedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(testPerformedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtComment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(specimenCollectedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(testPerformedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnReset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Test test = (Test) cmbTest.getSelectedItem();
        Report report = new Report();
        report.setPatientName(String.format("%S.%S", cmbTitle.getSelectedItem().toString(), txtName.getText()).replaceAll("\t+", " ").replaceAll(" +", " ").trim());
        report.setTestName(test.getName());
        report.setTestId(test.getTestId());
        report.setSpeciemen(test.getSpeciemen());
        String docName;
        if ((docName = ((Doctor) cmbRefferedBy.getSelectedItem()).getDocName()) != null) {
            report.setReferredBy(String.format("DR.%S", docName));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        report.setTestPerformedDate(simpleDateFormat.format(testPerformedDateChooser.getDate()));
        report.setSpeciemenCollectedDate(simpleDateFormat.format(specimenCollectedDateChooser.getDate()));
        if (!txtComment.getText().trim().isEmpty()) {
            report.setComment(String.format("* %S", txtComment.getText().trim()));
        }
        report.setFooter(test.getFooter());
        report.setAge(String.format("%s %s", txtAge.getText().trim(), rBtnYears.isSelected() ? "Year(s)" : "Month(s)"));
        report.setGender(cmbGender.getSelectedItem().toString());
        List<ElementResult> results = new ArrayList<>();
        Vector<Vector> dataVector = ((DefaultTableModel) jTable1.getModel()).getDataVector();
        ElementResult result;
        Object temp;
        for (Vector vector : dataVector) {
            results.add(result = new ElementResult());
            result.setName(vector.elementAt(0).toString());
            Object value = vector.elementAt(1) instanceof String[] ? (((String[]) vector.elementAt(1))[0]) : vector.elementAt(1);
            if (value.toString().matches("\\d+\\.*\\d*")) {
                try {
                    NumberFormat formatter = NumberFormat.getInstance();
                    value = formatter.parse(value.toString());
                    formatter.setGroupingUsed((boolean) vector.elementAt(6));
                    int floatingPoints = (int) vector.elementAt(7);
                    formatter.setMinimumFractionDigits(floatingPoints);
                    formatter.setMaximumFractionDigits(floatingPoints);
                    value = formatter.format(value);
                } catch (ParseException ex) {
                    System.out.println(ex.getCause());
                }
            }
            result.setResult(value.toString());
            result.setUnit((temp = vector.elementAt(2)) != null ? temp.toString() : null);
            result.setRange((temp = vector.elementAt(3)) != null ? temp.toString() : null);
            result.setElementId((int) vector.elementAt(4));
        }
        report.setResults(results);
        if (ReportController.saveReport(report)) {
            JOptionPane.showMessageDialog(null, "Report Saved Successfully", null, JOptionPane.INFORMATION_MESSAGE);
            try {
                PrintManager.printReport(report);
            } catch (JRException | FileNotFoundException | ParseException ex) {
                Logger.getLogger(AddTestResult.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbTestItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTestItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            Test selectedTest = (Test) evt.getItem();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Element element : selectedTest.getElements()) {
                Object expectedResults = element.getResults();

                if (expectedResults != null && expectedResults.toString().contains("|")) {
                    expectedResults = expectedResults.toString().trim().split("[|]");
                }

                model.addRow(new Object[]{
                    element.getName(),
                    (expectedResults instanceof String[]) ? (((String[]) expectedResults)[0]) : expectedResults,
                    element.getUnit(),
                    element.getRange(),
                    element.getElementId(),
                    expectedResults,
                    element.isGrouping(),
                    element.getFloatingPoints()
                });
            }
        }
    }//GEN-LAST:event_cmbTestItemStateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

    }//GEN-LAST:event_btnResetActionPerformed

    private void txtCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCommentActionPerformed

    private void cmbTitleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTitleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Title title = (Title) evt.getItem();
            if (title.gender != Gender.UNKNOWN) {
                cmbGender.setSelectedIndex(title.gender.VALUE);
                cmbGender.setEnabled(false);
            } else {
                cmbGender.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cmbTitleItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupAgeSuffix;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JComboBox cmbRefferedBy;
    private javax.swing.JComboBox cmbTest;
    private javax.swing.JComboBox cmbTitle;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rBtnMonths;
    private javax.swing.JRadioButton rBtnYears;
    private de.wannawork.jcalendar.JCalendarComboBox specimenCollectedDateChooser;
    private de.wannawork.jcalendar.JCalendarComboBox testPerformedDateChooser;
    private javax.swing.JFormattedTextField txtAge;
    private javax.swing.JTextField txtComment;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
