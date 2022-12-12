/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewDoiTra;

import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietRespone;
import java.math.BigDecimal;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author thang
 */
public class ItemSanPham extends javax.swing.JPanel {

    /**
     * Creates new form ItemSanPham
     */
    private int index;
    private HoaDonChiTietRespone hoaDonRespone;

    public ItemSanPham(int i, HoaDonChiTietRespone hoaDonRespone) {
        initComponents();
        this.index = i;
        this.hoaDonRespone = hoaDonRespone;
        txtMa.setText(hoaDonRespone.getMaSanPham());
        txtTen.setText(hoaDonRespone.getTenSanPham());
        txtSoLuongSanPham.setText(String.valueOf(hoaDonRespone.getSoLuong()));
        txtGia.setText(String.valueOf(hoaDonRespone.getGia()));
        SpinnerNumberModel model = new SpinnerNumberModel();
        int value = Integer.parseInt(txtSoLuongSanPham.getText());
        model.setMaximum(value);
        model.setMinimum(0);
        txtSoLuongTra.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        txtTen = new javax.swing.JLabel();
        txtTong = new javax.swing.JLabel();
        txtSoLuongTra = new javax.swing.JSpinner();
        txtSoLuongSanPham = new javax.swing.JLabel();
        txtGia = new javax.swing.JLabel();
        txtSoLuongSanPham1 = new javax.swing.JLabel();

        jLabel5.setText("100000");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtMa.setText("SP123");

        txtTen.setText("LapTop");

        txtTong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTong.setText("0");

        txtSoLuongTra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtSoLuongTraStateChanged(evt);
            }
        });

        txtSoLuongSanPham.setText("10");

        txtGia.setText("100000");

        txtSoLuongSanPham1.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMa)
                .addGap(48, 48, 48)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuongSanPham1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoLuongSanPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa)
                    .addComponent(txtTen)
                    .addComponent(txtTong)
                    .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongSanPham)
                    .addComponent(txtSoLuongSanPham1)
                    .addComponent(txtGia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongTraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtSoLuongTraStateChanged
        int soLuong = (int) txtSoLuongTra.getValue();
        BigDecimal tong = new BigDecimal(txtGia.getText()).multiply(new BigDecimal(soLuong));
        txtTong.setText(String.valueOf(tong));
        hoaDonRespone.setSoLuong(soLuong);
        ViewDoiTraTheoHoaDon.updateSoLuong(index, hoaDonRespone);
    }//GEN-LAST:event_txtSoLuongTraStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel txtGia;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtSoLuongSanPham;
    private javax.swing.JLabel txtSoLuongSanPham1;
    private javax.swing.JSpinner txtSoLuongTra;
    private javax.swing.JLabel txtTen;
    private javax.swing.JLabel txtTong;
    // End of variables declaration//GEN-END:variables
}
