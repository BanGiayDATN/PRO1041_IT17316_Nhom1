/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.resquest.SeachHoaDon;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.NhanVienService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.NhanVienServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.oxbow.swingbits.table.filter.TableRowFilterSupport;

/**
 *
 * @author thang
 */
public class QuanLiHoaDon extends javax.swing.JPanel {

    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private List<HoaDonRespone> list;

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();

    public QuanLiHoaDon() {
        initComponents();
        list = hoaDonService.getAll(new SeachHoaDon());

        loadTable(list);
        loadcbo(nhanVienService.getAllMaNhanVien());
        tblHoaDon = TableRowFilterSupport
                .forTable(tblHoaDon)
                .searchable(true)
                .apply();

    }

    private void loadDonHangBan(List<HoaDonChiTiet> list) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã SP", "Tên SP", "Dung lượng", "Chất liệu", "Hệ điều hành", "Ram", "CPU", "Hang", "Khách hàng", "Số lượng", "Tổng tiền"});
        if (list != null) {
            for (HoaDonChiTiet hd : list) {
                model.addRow(new Object[]{hd.getSanPham().getMa(), hd.getSanPham().getTen(), hd.getSanPham().getRam().getDungLuong(),
                    hd.getSanPham().getChatLieu().getTen(), hd.getSanPham().getHeDieuHanh().getTen(), hd.getSanPham().getRam().getTen(), hd.getSanPham().getCpu().getTen(),
                    hd.getSanPham().getHang().getTen(), hd.getHoaDon().getKhachHang().getHoTen(), hd.getSoLuong(), hd.getSanPham().getGiaBan().multiply(new BigDecimal(hd.getSoLuong()))});
            }
        }
        tbHoaDon.setModel(model);
    }

    private void loadcbo(List<String> list) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("mã nhân viên");
        for (String ma : list) {
            model.addElement(ma);
        }
        cboMa.setModel(model);
        cboMa.setSelectedIndex(0);
    }

    private void loadTable(List<HoaDonRespone> hoaDons) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã", "Ngày Tạo", "Mã Nhân Viên", "Tên Nhân viên", "Tên khách hàng", "Tình trạng", "Số Lượng", "Tổng"});
        if (hoaDons != null) {
            for (HoaDonRespone hoaDon : hoaDons) {
                String ngayTao = new ConverDate().longToDate(hoaDon.getNgayTao(), "dd/MM/yyyy");
                model.addRow(new Object[]{hoaDon.getMa(), ngayTao, hoaDon.getMaNhanVien(), hoaDon.getTenNhanVien(), hoaDon.getTenKhachHang(), hoaDon.getTrangThai(), hoaDon.getSoLuong(), hoaDon.getTong()});
            }
        }
        tblHoaDon.setModel(model);
    }

    private SeachHoaDon getSeachHoaDon() {
        SeachHoaDon seachHoaDon = new SeachHoaDon();
        seachHoaDon.setMa(txtMa.getText());
        if (cboMa.getSelectedIndex() == 0) {
            seachHoaDon.setMaNhanVien(null);
        } else {
            seachHoaDon.setMaNhanVien(cboMa.getSelectedItem().toString());
        }
        seachHoaDon.setTenKhachHang(txtTenKhach.getText());
        seachHoaDon.setTenNhanVien(txtTenNhanVien.getText());
        if (txtNgayTao.getDate() != null) {
            String ngaybatdau = new ConverDate().convertDateToString(txtNgayTao.getDate(), "dd/MM/yyyy");
            long converNgayBatDau = new ConverDate().dateToLong(ngaybatdau, "dd/MM/yyyy");
            seachHoaDon.setNgayTao(converNgayBatDau);
        } else {
            seachHoaDon.setNgayTao(0L);
        }
        return seachHoaDon;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenKhach = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboMa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        btnSeach = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setText("Mã hóa đơn");

        jLabel2.setText("Tên nhân viên ");

        jLabel3.setText("Tên Khách hàng");

        jLabel4.setText("Mã Nhân Viên");

        cboMa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mã nhân viên" }));
        cboMa.setToolTipText("");

        jLabel5.setText("Ngày Tạo");

        btnSeach.setText("Seach");
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        jButton1.setText("Xuất");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtMa))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboMa, 0, 200, Short.MAX_VALUE)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSeach)
                                .addGap(39, 39, 39))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeach)))
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        loadTable(hoaDonService.getAll(getSeachHoaDon()));
    }//GEN-LAST:event_btnSeachActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ChooseFileExcel(hoaDonService.getAll(getSeachHoaDon())).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        int row = tblHoaDon.getSelectedRow();
        String ma = txtMa.getText();
        HoaDonRespone repon = list.get(row);
        ma = repon.getMa();
        List<HoaDonChiTiet> list = hoaDonChiTietService.getAllByMa(ma);
        loadDonHangBan(list);


    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeach;
    private javax.swing.JComboBox<String> cboMa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMa;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
