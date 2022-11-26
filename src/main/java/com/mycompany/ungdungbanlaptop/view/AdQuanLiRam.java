/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import com.mycompany.ungdungbanlaptop.service.RamService;
import com.mycompany.ungdungbanlaptop.service.impl.RamServiceImpl;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author thang
 */
public class AdQuanLiRam extends javax.swing.JPanel {

    private RamService ramService = new RamServiceImpl();
    private List<Ram> listRam = ramService.getList();
    private int index = 0;

    public AdQuanLiRam() {
        initComponents();
        loadCbo();
        loadTable(listRam);
        loadCboSeach();
    }

    private void loadTable(List<Ram> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"id", "Mã", "Tên", "Dung lượng", "Megahertz", "Loại Ram"});
        if (list != null) {
            for (Ram ram : list) {
                Object object[] = new Object[]{ram.getIdRam(), ram.getMa(), ram.getTen(),
                    ram.getDungLuong(), ram.getMegahertz(), ram.getEnumLoaiRam()};
                model.addRow(object);
            }
            tblRam.setModel(model);
            tblRam.removeColumn(tblRam.getColumnModel().getColumn(0));
        }
    }

    private void loadCbo() {
        cboLoaiRam.setModel(new DefaultComboBoxModel<>(new String[]{"SDRAM", "DDR1", "DDR2", "DDR3", "DDR4", "DDR5"}));
    }

    private void loadCboSeach() {
        cboSeachRam.setModel(new DefaultComboBoxModel<>(new String[]{"SDRAM", "DDR1", "DDR2", "DDR3", "DDR4", "DDR5"}));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRam = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDungLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMegahertz = new javax.swing.JTextField();
        cboLoaiRam = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        errorMa = new javax.swing.JLabel();
        errorTen = new javax.swing.JLabel();
        errorDungLuong = new javax.swing.JLabel();
        errorMegahertz = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        viewTimKiem = new javax.swing.JPanel();
        txtSeachten = new javax.swing.JTextField();
        txtSeachDungLuong = new javax.swing.JTextField();
        cboSeachRam = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblRam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRam);

        jLabel1.setText("Mã:");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên:");

        jLabel3.setText("Dung lượng:");

        jLabel4.setText("Megahertz:");

        cboLoaiRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Loại Ram:");

        errorMa.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorMa.setForeground(new java.awt.Color(255, 0, 51));

        errorTen.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorTen.setForeground(new java.awt.Color(255, 0, 51));

        errorDungLuong.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorDungLuong.setForeground(new java.awt.Color(255, 0, 51));

        errorMegahertz.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        errorMegahertz.setForeground(new java.awt.Color(255, 0, 51));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 3)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));

        viewTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        viewTimKiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSeachten.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeachtenCaretUpdate(evt);
            }
        });

        txtSeachDungLuong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeachDungLuongCaretUpdate(evt);
            }
        });

        cboSeachRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSeachRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSeachRamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewTimKiemLayout = new javax.swing.GroupLayout(viewTimKiem);
        viewTimKiem.setLayout(viewTimKiemLayout);
        viewTimKiemLayout.setHorizontalGroup(
            viewTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSeachten, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSeachDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboSeachRam, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        viewTimKiemLayout.setVerticalGroup(
            viewTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewTimKiemLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(viewTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSeachten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeachDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSeachRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(37, 37, 37)
                .addComponent(btnSua)
                .addGap(68, 68, 68))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(viewTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(errorMa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errorDungLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDungLuong)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(76, 76, 76)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(errorTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(errorMegahertz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboLoaiRam, 0, 177, Short.MAX_VALUE)
                            .addComponent(txtMegahertz))))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(txtId)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMegahertz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(errorMa)
                    .addComponent(errorMegahertz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboLoaiRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(2, 2, 2)
                .addComponent(errorTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDungLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorDungLuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(57, 57, 57)
                .addComponent(viewTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkFrom()) {
            Ram ram = ramRequest();
            if (ramService.findByMa(ram.getMa()) != null) {
                errorMa.setText("mã đã tồn tại");
            } else {
                errorMa.setText("");
                int check = JOptionPane.showConfirmDialog(this, "bạn có muốn lưu ram " + ram.getTen() + ", Dung lượng: " + ram.getDungLuong() + "GB");
                if (check == 0) {
                    ramService.insert(ram);
                    listRam.add(ram);
                    ViewSanPham.addRam(ram);
                }
            }
        }
        loadTable(listRam);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblRamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRamMouseClicked
        index = tblRam.getSelectedRow();
        txtId.setText(tblRam.getModel().getValueAt(index, 0).toString());
        txtMa.setText(tblRam.getModel().getValueAt(index, 1).toString());
        txtTen.setText(tblRam.getModel().getValueAt(index, 2).toString());
        txtDungLuong.setText(tblRam.getModel().getValueAt(index, 3).toString());
        txtMegahertz.setText(tblRam.getModel().getValueAt(index, 4).toString());
        cboLoaiRam.setSelectedItem(tblRam.getModel().getValueAt(index, 5).toString());
    }//GEN-LAST:event_tblRamMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Vui lòng chọn ram");
        } else {
            Ram ram = ramRequest();
            UUID id = UUID.fromString(txtId.getText());
            errorMa.setText("");
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn lưu ram " + ram.getTen() + ", Dung lượng: " + ram.getDungLuong() + "GB");
            if (check == 0) {
                JOptionPane.showMessageDialog(this, ramService.update(id, ram));
                listRam.set(index, ram);
                ViewSanPham.editRam(index, ram);
            }
        }
        loadTable(listRam);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSeachtenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeachtenCaretUpdate
        String dungLuongString = null;
        if (!txtSeachDungLuong.getText().isEmpty()) {
            try {
               int dungLuong = Integer.parseInt(txtSeachDungLuong.getText());
               dungLuongString = String.valueOf(dungLuong) ;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "vui lòng nhập số");
                return;
            }
        }

        loadTable(ramService.getSeachListRam(txtSeachten.getText(), dungLuongString, getSeachLoaiRam()));
    }//GEN-LAST:event_txtSeachtenCaretUpdate

    private void cboSeachRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSeachRamActionPerformed
       String dungLuongString = null;
        if (!txtSeachDungLuong.getText().isEmpty()) {
            try {
               int dungLuong = Integer.parseInt(txtSeachDungLuong.getText());
               dungLuongString = String.valueOf(dungLuong) ;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "vui lòng nhập số");
                return;
            }
        }

        loadTable(ramService.getSeachListRam(txtSeachten.getText(), dungLuongString, getSeachLoaiRam()));
    }//GEN-LAST:event_cboSeachRamActionPerformed

    private void txtSeachDungLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeachDungLuongCaretUpdate
        String dungLuongString = null;
        if (!txtSeachDungLuong.getText().isEmpty()) {
            try {
               int dungLuong = Integer.parseInt(txtSeachDungLuong.getText());
               dungLuongString = String.valueOf(dungLuong) ;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "vui lòng nhập số");
                return;
            }
        }

        loadTable(ramService.getSeachListRam(txtSeachten.getText(), dungLuongString, getSeachLoaiRam()));
    }//GEN-LAST:event_txtSeachDungLuongCaretUpdate

    private boolean checkFrom() {
        int check = 0;
        if (txtMa.getText().isEmpty()) {
            errorMa.setText("vui lòng nhập mã");
            check++;
        } else {
            errorMa.setText("");
        }
        if (txtTen.getText().isEmpty()) {
            errorTen.setText("vui lòng nhập tên");
            check++;
        } else {
            errorTen.setText("");
        }
        if (txtDungLuong.getText().isEmpty()) {
            errorDungLuong.setText(" vui lòng nhập dung lượng");
            check++;
        } else if (checkNumber(txtDungLuong.getText()) != null) {
            errorDungLuong.setText(checkNumber(txtDungLuong.getText()));
            check++;
        } else {
            errorDungLuong.setText("");
        }
        if (txtMegahertz.getText().isEmpty()) {
            errorMegahertz.setText("vui lòng nhập megahertz");
            check++;
        } else if (checkNumber(txtMegahertz.getText()) != null) {
            errorMegahertz.setText(checkNumber(txtMegahertz.getText()));
            check++;
        } else {
            errorMegahertz.setText("");
        }

        if (check == 0) {
            return true;
        }
        return false;
    }

    private Ram ramRequest() {
        Ram ram = new Ram();
        ram.setMa(txtMa.getText());
        ram.setTen(txtTen.getText());
        ram.setDungLuong(Integer.parseInt(txtDungLuong.getText()));
        ram.setMegahertz(Integer.parseInt(txtMegahertz.getText()));
        ram.setEnumLoaiRam(getLoaiRam());
        return ram;
    }

    private EnumLoaiRam getLoaiRam() {
        String loaiRam = cboLoaiRam.getSelectedItem().toString();
        if (loaiRam.equals("SDRAM")) {
            return EnumLoaiRam.SDRAM;
        } else if (loaiRam.equals("DDR1")) {
            return EnumLoaiRam.DDR1;
        } else if (loaiRam.equals("DDR2")) {
            return EnumLoaiRam.DDR2;
        } else if (loaiRam.equals("DDR3")) {
            return EnumLoaiRam.DDR3;
        } else if (loaiRam.equals("DDR4")) {
            return EnumLoaiRam.DDR4;
        }
        return EnumLoaiRam.DDR5;
    }

    private EnumLoaiRam getSeachLoaiRam() {
        String loaiRam = cboSeachRam.getSelectedItem().toString();
        if (loaiRam.equals("SDRAM")) {
            return EnumLoaiRam.SDRAM;
        } else if (loaiRam.equals("DDR1")) {
            return EnumLoaiRam.DDR1;
        } else if (loaiRam.equals("DDR2")) {
            return EnumLoaiRam.DDR2;
        } else if (loaiRam.equals("DDR3")) {
            return EnumLoaiRam.DDR3;
        } else if (loaiRam.equals("DDR4")) {
            return EnumLoaiRam.DDR4;
        }
        return EnumLoaiRam.DDR5;
    }

    private String checkNumber(String number) {
        try {
            int check = Integer.parseInt(number);
            if (check <= 0) {
                return "vui lòng nhập số > 0";
            }
        } catch (Exception e) {
            return "vui lòng nhập số";
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboLoaiRam;
    private javax.swing.JComboBox<String> cboSeachRam;
    private javax.swing.JLabel errorDungLuong;
    private javax.swing.JLabel errorMa;
    private javax.swing.JLabel errorMegahertz;
    private javax.swing.JLabel errorTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRam;
    private javax.swing.JTextField txtDungLuong;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMegahertz;
    private javax.swing.JTextField txtSeachDungLuong;
    private javax.swing.JTextField txtSeachten;
    private javax.swing.JTextField txtTen;
    private javax.swing.JPanel viewTimKiem;
    // End of variables declaration//GEN-END:variables
}
