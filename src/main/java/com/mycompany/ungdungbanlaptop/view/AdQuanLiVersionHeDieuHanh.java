/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHeDieuHanh;
import com.mycompany.ungdungbanlaptop.service.HeDieuHanhService;
import com.mycompany.ungdungbanlaptop.service.impl.HeDieuHanhServiceImpl;

import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author thang
 */
public class AdQuanLiVersionHeDieuHanh extends javax.swing.JPanel {

    private HeDieuHanhService heDieuHanhService = new HeDieuHanhServiceImpl();

    public AdQuanLiVersionHeDieuHanh() {
        initComponents();
        loadCbo();
        List<HeDieuHanh> list = heDieuHanhService.getList();
        loadTable(list);
    }

    private String getHeDieuHanh(EnumHeDieuHanh heDieuHanh) {
        switch (heDieuHanh) {
            case WINDOWS:
                return "Windows";
            case MACOS:
                return "Macos";
            case LINUX:
                return "Linux";
            case KHAC:
                return "Khác";
            default:
                throw new AssertionError();
        }
    }

    private void loadTable(List<HeDieuHanh> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"id", "Mã", "Tên version", "Hệ điều hành"});
        if (list != null) {
            for (HeDieuHanh heDieuHanh : list) {
                Object[] objects = new Object[]{heDieuHanh.getIdHeDieuHanh(), heDieuHanh.getMa(), heDieuHanh.getTen(), getHeDieuHanh(heDieuHanh.getHeDieuHanh())};
                model.addRow(objects);
            }
        }
        tblHeDieuHanh.setModel(model);
        tblHeDieuHanh.removeColumn(tblHeDieuHanh.getColumnModel().getColumn(0));
    }

    private void loadCbo() {
        cboHeDieuHanh.setModel(new DefaultComboBoxModel<>(new String[]{"Windows", "Macos", "Linux", "Khác"}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenVersion = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHeDieuHanh = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cboHeDieuHanh = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtID = new javax.swing.JLabel();
        errorMa = new javax.swing.JLabel();
        errorTen = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã:");

        jLabel2.setText("Tên version:");

        tblHeDieuHanh.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        tblHeDieuHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHeDieuHanhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHeDieuHanh);

        jLabel3.setText("Hệ điều hành:");

        cboHeDieuHanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        btnThem.setText("thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 3)); // NOI18N
        txtID.setForeground(new java.awt.Color(255, 255, 255));

        errorMa.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorMa.setForeground(new java.awt.Color(255, 102, 102));

        errorTen.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorTen.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnThem)
                                .addGap(33, 33, 33)
                                .addComponent(btnSua)
                                .addGap(45, 45, 45))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(37, 37, 37)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(errorMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                                        .addComponent(txtTenVersion)
                                                        .addComponent(errorTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(cboHeDieuHanh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtID)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtID)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(cboHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorMa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtTenVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem)
                                        .addComponent(btnSua))
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkFrom()) {
            HeDieuHanh heDieuHanh = new HeDieuHanh();
            heDieuHanh.setMa(txtMa.getText());
            heDieuHanh.setTen(txtTenVersion.getText());
            heDieuHanh.setHeDieuHanh(getEumHeDieuHanh());
            try {
                if (heDieuHanhService.findById(heDieuHanh.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã version hệ điều hành đã tồn tại");
                } else {
                    int index;
                    index = JOptionPane.showConfirmDialog(this, "bạn có muốn lưu " + txtMa.getText() + ": " + txtTenVersion.getText());
                    if (index == 0) {
                        heDieuHanhService.insert(heDieuHanh);
                    }
                }
            } catch (Exception e) {
            }
        }
        loadTable(heDieuHanhService.getList());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn hệ điều hành cần thay đổi");
            return;
        }

        UUID id = UUID.fromString(txtID.getText());
        HeDieuHanh heDieuHanh = new HeDieuHanh();
        heDieuHanh.setMa(txtMa.getText());
        heDieuHanh.setTen(txtTenVersion.getText());
        heDieuHanh.setHeDieuHanh(getEumHeDieuHanh());
        heDieuHanhService.update(id, heDieuHanh);
        loadTable(heDieuHanhService.getList());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblHeDieuHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHeDieuHanhMouseClicked
        int index = tblHeDieuHanh.getSelectedRow();
        txtID.setText(tblHeDieuHanh.getModel().getValueAt(index, 0).toString());
        txtMa.setText(tblHeDieuHanh.getModel().getValueAt(index, 1).toString());
        txtTenVersion.setText(tblHeDieuHanh.getModel().getValueAt(index, 2).toString());
        cboHeDieuHanh.setSelectedItem(tblHeDieuHanh.getModel().getValueAt(index, 3).toString());
    }//GEN-LAST:event_tblHeDieuHanhMouseClicked

    public EnumHeDieuHanh getEumHeDieuHanh() {
        String tenHeDieuHanh = cboHeDieuHanh.getSelectedItem().toString();
        if (tenHeDieuHanh.equalsIgnoreCase("Windows")) {
            return EnumHeDieuHanh.WINDOWS;
        } else if (tenHeDieuHanh.equalsIgnoreCase("Macos")) {
            return EnumHeDieuHanh.MACOS;
        } else if (tenHeDieuHanh.equalsIgnoreCase("Linux")) {
            return EnumHeDieuHanh.LINUX;
        }
        return EnumHeDieuHanh.KHAC;
    }

    public boolean checkFrom() {
        int check = 0;
        if (txtMa.getText().isEmpty()) {
            errorMa.setText("vui lòng nhập mã");
            check++;
        } else {
            errorMa.setText("");
        }
        if (txtTenVersion.getText().isEmpty()) {
            errorTen.setText("vui lòng nhập tên");
            check++;
        } else {
            errorTen.setText("");
        }
        if (check == 0) {
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboHeDieuHanh;
    private javax.swing.JLabel errorMa;
    private javax.swing.JLabel errorTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHeDieuHanh;
    private javax.swing.JLabel txtID;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTenVersion;
    // End of variables declaration//GEN-END:variables
}
