/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewKhuyenMai;

import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiRespone;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import com.mycompany.ungdungbanlaptop.service.impl.KhuyenMaiServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thang
 */
public class ViewKhuyenMai extends javax.swing.JPanel {

    private KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
    private List<KhuyenMaiRespone> list = new ArrayList<>();

    public ViewKhuyenMai() {
        initComponents();
        list = khuyenMaiService.listKhuyenMaiRespone();
        lbSoLuong.setText(lbSoLuong.getText() + ": " + list.size());
        loadTable(list);
    }

    private void loadTable(List<KhuyenMaiRespone> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"id", "Mã", "Tên", "Ngày bắt đầu", "Ngày kết thúc", "Hình thức", "Số lượng"});
        if (list != null) {
            list.stream().forEach(item -> {
                model.addRow(new Object[]{item.getId(), item.getMa(), item.getTen(), item.getNgayBatDauString(), item.getNgayKethucString(), item.getHinhThuc(), item.getSoLuong()});
            });
        }
        tblKhuyenMai.setModel(model);
        tblKhuyenMai.removeColumn(tblKhuyenMai.getColumnModel().getColumn(0));
    }

    private List<KhuyenMaiRespone> getListSeach(List<KhuyenMaiRespone> list, String seach, boolean conHan, boolean hetHan) {
        List<KhuyenMaiRespone> listKhuyenMai = new ArrayList<>();
        String dateString = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        long date = new ConverDate().dateToLong(dateString, "dd/MM/yyyy");
        if (conHan) {
            if (seach == null) {
                list.stream().forEach(item -> {
                    if (item.getNgaybatDau() <= date && item.getNgayKethuc() >= date) {
                        listKhuyenMai.add(item);
                    }
                });
            } else {
                list.stream().forEach(item -> {
                    if (item.getNgaybatDau() <= date && item.getNgayKethuc() >= date) {
                        if (item.getMa().toLowerCase().contains(seach) || item.getTen().toLowerCase().contains(seach)) {
                            listKhuyenMai.add(item);
                        }
                    }
                });
            }
        } else if (hetHan) {
            if (seach == null) {
                list.stream().forEach(item -> {
                    if (item.getNgaybatDau() <= date && item.getNgayKethuc() >= date) {
                    } else {
                        listKhuyenMai.add(item);
                    }
                });
            } else {
                list.stream().forEach(item -> {
                    if (item.getNgaybatDau() <= date && item.getNgayKethuc() >= date) {
                    } else {
                        if (item.getMa().toLowerCase().contains(seach) || item.getTen().toLowerCase().contains(seach)) {
                            listKhuyenMai.add(item);
                        }
                    }
                });
            }
        }else{
            if (seach == null) {
                list.stream().forEach(item -> {
                        listKhuyenMai.add(item);
                });
            } else {
                list.stream().forEach(item -> {
                        if (item.getMa().toLowerCase().contains(seach) || item.getTen().toLowerCase().contains(seach)) {
                            listKhuyenMai.add(item);
                        }
                });
            }
        }

        return listKhuyenMai;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoConHieuLuc = new javax.swing.JRadioButton();
        rdoHetHieuLuc = new javax.swing.JRadioButton();
        lbSoLuong = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        txtSeachKhuyenMai = new javax.swing.JTextField();
        btnAddKhuyenMai = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Hiệu lực:");

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setText("Tất cả");
        rdoTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoConHieuLuc);
        rdoConHieuLuc.setText("Còn hiệu lực");
        rdoConHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConHieuLucActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHetHieuLuc);
        rdoHetHieuLuc.setText("Hết hiệu lực ");
        rdoHetHieuLuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHetHieuLucActionPerformed(evt);
            }
        });

        lbSoLuong.setText("số lượng khuyến mãi: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoConHieuLuc)
                            .addComponent(rdoTatCa)
                            .addComponent(rdoHetHieuLuc))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoTatCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoConHieuLuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoHetHieuLuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbSoLuong))
        );

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        txtSeachKhuyenMai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSeachKhuyenMaiCaretUpdate(evt);
            }
        });
        txtSeachKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSeachKhuyenMaiMouseClicked(evt);
            }
        });

        btnAddKhuyenMai.setText("khuyến mãi");
        btnAddKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKhuyenMaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSeachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddKhuyenMai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(txtSeachKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSeachKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSeachKhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeachKhuyenMaiMouseClicked

    private void txtSeachKhuyenMaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSeachKhuyenMaiCaretUpdate
        String search = txtSeachKhuyenMai.getText().toLowerCase().trim();
        if(rdoConHieuLuc.isSelected()){
            loadTable(getListSeach(list, search, true, false));
        }else if(rdoHetHieuLuc.isSelected()){
            loadTable(getListSeach(list, search, false, true));
        }else{
            loadTable(getListSeach(list, search, false, false));
        }
    }//GEN-LAST:event_txtSeachKhuyenMaiCaretUpdate

    private void rdoHetHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHetHieuLucActionPerformed
        loadTable(getListSeach(list, null, false, true));
    }//GEN-LAST:event_rdoHetHieuLucActionPerformed

    private void rdoConHieuLucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConHieuLucActionPerformed
        loadTable(getListSeach(list, null, true, false));
    }//GEN-LAST:event_rdoConHieuLucActionPerformed

    private void rdoTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaActionPerformed
         loadTable(getListSeach(list, null, false, false));
    }//GEN-LAST:event_rdoTatCaActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
       int index = tblKhuyenMai.getSelectedRow();
       UUID idkhuyenMai = UUID.fromString(tblKhuyenMai.getModel().getValueAt(index, 0).toString());
       new ViewChiTietKhuyenMai(idkhuyenMai).setVisible(true);
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnAddKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKhuyenMaiActionPerformed
        new ViewThemKhuyenMai().setVisible(true);
    }//GEN-LAST:event_btnAddKhuyenMaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JRadioButton rdoConHieuLuc;
    private javax.swing.JRadioButton rdoHetHieuLuc;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtSeachKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
