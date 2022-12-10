/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewDoiTra;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietRespone;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.swing.ScrollBar;
import com.mycompany.ungdungbanlaptop.swing.WrapLayout;
import java.awt.MenuComponent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thang
 */
public class ViewDoiTraTheoHoaDon extends javax.swing.JFrame {

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private static Map<UUID, GioHangViewModel> listGioHang = new HashMap<>();
    private static List<HoaDonChiTietRespone> listHoaDon = new ArrayList<>();

    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    public ViewDoiTraTheoHoaDon(String ma, NhanVien nv) {
        initComponents();
        listHoaDon = hoaDonChiTietService.findHoaDonChiTietByMaHoaDon(ma);
        init(listHoaDon);
        showGioHangHDCT(null);
        lbMa.setText(ma);
        lbMaNhanVien.setText(hoaDonService.getOne(ma).getNhanVien().getMa());
        lbTenNhanVien.setText(hoaDonService.getOne(ma).getNhanVien().getHoTen());
        lbTenKhach.setText(hoaDonService.getOne(ma).getKhachHang().getHoTen());
        for (HoaDonChiTietRespone x : listHoaDon) {
            lbTongTien.setText(String.valueOf(new BigDecimal(x.getSoLuong()).multiply(x.getGia())));
        }

    }

    private void init(List<HoaDonChiTietRespone> list) {
        jpanelTra.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        int index = 0;
        if (list != null) {
            for (HoaDonChiTietRespone item : list) {
                jpanelTra.add(new ItemSanPham(index, item));
                index++;
            };
        }
        jpanelTra.revalidate();
        jpanelTra.repaint();
    }

    private static void showGioHangHDCT(Map<UUID, GioHangViewModel> listGioHang) {
        DefaultTableModel model = new DefaultTableModel();
        String[] gh = {"idSP", "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn Giá"};
        model.setColumnIdentifiers(gh);
        int i = 0;
        if (listGioHang != null) {
            for (GioHangViewModel x : listGioHang.values()) {
                i++;
                model.addRow(new Object[]{x.getIdSanPham(), i, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia()});
            }
        }
        TableGiohang.setModel(model);
        TableGiohang.removeColumn(TableGiohang.getColumnModel().getColumn(0));
    }

    public static void updateSoLuong(int index, HoaDonChiTietRespone hoaDonChiTietRespone) {
        listHoaDon.set(index, hoaDonChiTietRespone);
    }

    public static void addSanPham(GioHangViewModel GioHangViewModel) {
        listGioHang.put(GioHangViewModel.getIdSanPham(), GioHangViewModel);

        showGioHangHDCT(listGioHang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableGiohang = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbMa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTenKhach = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbMaNhanVien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbTenNhanVien = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtThu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtLiDo = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbDoiHang = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtPhi = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTongTienTraLai = new javax.swing.JTextField();
        jpanelTra = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Đổi hàng"));

        TableGiohang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableGiohang);

        jButton2.setText("add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Mã hóa đơn: ");

        lbMa.setText("1");

        jLabel2.setText("Tên Khách hàng: ");

        lbTenKhach.setText("1");

        jLabel3.setText("Tổng tiền:");

        lbTongTien.setText("100000");

        jLabel4.setText("Mã nhân Viên:");

        lbMaNhanVien.setText("NV123");

        jLabel5.setText("Tên Nhân Viên:");

        lbTenNhanVien.setText("Tran Van B");

        jLabel7.setText("Thu:");

        jLabel8.setText("Trả");

        jLabel9.setText("lí do:");

        txtLiDo.setColumns(20);
        txtLiDo.setRows(5);
        jScrollPane4.setViewportView(txtLiDo);

        jLabel10.setText("Tình Trạng:");

        jButton1.setText("Lưu ");

        jLabel11.setText("hình thức:");

        cbbDoiHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đổi hàng", "Trả hàng" }));
        cbbDoiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDoiHangActionPerformed(evt);
            }
        });

        jLabel12.setText("Phí:");

        txtPhi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhiKeyReleased(evt);
            }
        });

        jLabel13.setText("Tổng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThu)
                            .addComponent(txtTra)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 31, Short.MAX_VALUE)
                                .addComponent(cbbDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addComponent(txtPhi)
                            .addComponent(txtTinhTrang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txtTongTienTraLai)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbMa))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbTenKhach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbMaNhanVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbTenNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbDoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1))
        );

        jpanelTra.setBackground(new java.awt.Color(255, 255, 255));
        jpanelTra.setBorder(javax.swing.BorderFactory.createTitledBorder(" Trả hàng "));

        javax.swing.GroupLayout jpanelTraLayout = new javax.swing.GroupLayout(jpanelTra);
        jpanelTra.setLayout(jpanelTraLayout);
        jpanelTraLayout.setHorizontalGroup(
            jpanelTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelTraLayout.setVerticalGroup(
            jpanelTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jpanelTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new DoiSanPham().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbDoiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDoiHangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbDoiHangActionPerformed

    private void txtPhiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhiKeyReleased
        // TODO add your handling code here:
        if (cbbDoiHang.getSelectedIndex() == 1) {
            for (HoaDonChiTietRespone x : listHoaDon) {
                txtTra.setText(String.valueOf((new BigDecimal(x.getSoLuong()).multiply(x.getGia())).subtract(new BigDecimal(txtPhi.getText()))));
            }
            txtThu.setText("0");
        } else if (cbbDoiHang.getSelectedIndex() == 0) {
            for (GioHangViewModel x : listGioHang.values()) {
                txtThu.setText(String.valueOf((new BigDecimal(x.getSoLuong()).multiply(x.getDonGia())).add(new BigDecimal(txtPhi.getText()))));
            }

            for (HoaDonChiTietRespone x : listHoaDon) {
                txtTra.setText(String.valueOf((new BigDecimal(x.getSoLuong()).multiply(x.getGia()))));
            }
        }
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewDoiTraTheoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoiTraTheoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoiTraTheoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoiTraTheoHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }//GEN-LAST:event_txtPhiKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewDoiTraTheoHoaDon("HD).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable TableGiohang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDoiHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpanelTra;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbMaNhanVien;
    private javax.swing.JLabel lbTenKhach;
    private javax.swing.JLabel lbTenNhanVien;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTextArea txtLiDo;
    private javax.swing.JTextField txtPhi;
    private javax.swing.JTextField txtThu;
    private javax.swing.JTextField txtTinhTrang;
    private javax.swing.JTextField txtTongTienTraLai;
    private javax.swing.JTextField txtTra;
    // End of variables declaration//GEN-END:variables
}
