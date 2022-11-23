/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietServive;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiveImpl;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thangdt
 */
public class ViewBanHangNhanVien extends javax.swing.JPanel {

    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private HoaDonChiTietServive hoaDonChiTietServive = new HoaDonChiTietServiveImpl();
    private Map<UUID, GioHangViewModel> listGioHang = new HashMap<>();
    private List<HoaDonBanHangViewModel> listHoaDonCho = new ArrayList<>();
    private HoaDon hoaDon;
    private NhanVien nhanVien;

    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHangNhanVien(NhanVien nhanVien) {
        initComponents();
        this.nhanVien = nhanVien;
        listHoaDonCho = hoaDonService.getHoaDonCho();
        showHoaDon(listHoaDonCho);
        showSanPham(sanPhamService.getSanPhamBanHang());
        cbbHinhThucThanhToan();
        cbbPhanLoai();

    }

    private void cbbHinhThucThanhToan() {
        DefaultComboBoxModel dcmHinhThucThanhToan = new DefaultComboBoxModel();

        cbbHinhThucThanhToan.setModel(dcmHinhThucThanhToan);
        dcmHinhThucThanhToan.addElement("Quét QR");
        dcmHinhThucThanhToan.addElement("Tiền mặt");
    }

    private void cbbPhanLoai() {
        DefaultComboBoxModel dcmPhanLoai = new DefaultComboBoxModel();
        cbbPhanLoai.setModel(dcmPhanLoai);
        dcmPhanLoai.addElement("Tất cả");
        dcmPhanLoai.addElement("10.000.000 - 15.000.000");
        dcmPhanLoai.addElement("15.000.000 - 20.000.000");
        dcmPhanLoai.addElement("20.000.000 - 30.000.000");
        dcmPhanLoai.addElement("30.000.000 - 50.000.000");
        dcmPhanLoai.addElement("Trên 50.000.000");
    }

    private void showSanPham(List<SanPhamBanHangViewModel> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] sp = {"id","STT", "Mã SP", "Tên SP", "Năm BH", "Trọng lượng", "Số lượng", "Giá bán", "Mô tả"};
        model.setColumnIdentifiers(sp);
        int index =0;
        model.setRowCount(0);
        for (SanPhamBanHangViewModel x : list) {
            index++;
            model.addRow(new Object[]{x.getId(),index, x.getMa(), x.getTen(), x.getNamBH(), x.getTrongLuong(), x.getSoLuongTon(), x.getGiaBan(), x.getMoTa()});
        }
        jTableSanPham.setModel(model);
        jTableSanPham.removeColumn(jTableSanPham.getColumnModel().getColumn(0));
    }

    private void showGioHang(Map<UUID, GioHangViewModel> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] gh = {"STT", "Mã SP", "Tên SP", "Số lượng", "Đơn Giá", "Thành tiền"};
        model.setColumnIdentifiers(gh);
        int index =0;
         for (GioHangViewModel x : list.values()) {
             index++;
            BigDecimal soLuong = new BigDecimal(x.getSoLuong());
            model.addRow(new Object[]{x.getIdSanPham(), x.getIdHoaDon(), index, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia(), soLuong.multiply(x.getDonGia())});
        }
        jTableGiohang.setModel(model);
        jTableGiohang.removeColumn(jTableGiohang.getColumnModel().getColumn(0));
        jTableGiohang.removeColumn(jTableGiohang.getColumnModel().getColumn(1));
    }

    private void showHoaDon(List<HoaDonBanHangViewModel> list) {
        DefaultTableModel model = new DefaultTableModel();
        String[] hd = {"id","STT", "Mã HĐ", "Ngày tạo", "Tên Khách", "Tình trạng"};
        model.setColumnIdentifiers(hd);
        int index =0;
        model.setRowCount(0);
        for (HoaDonBanHangViewModel x : list) {
            index++;
            model.addRow(new Object[]{x.getId(),index , x.getMa(), new ConverDate().longToDate(x.getNgayTao(), "dd/MM/yyyy"), x.getHoTen(), x.getTinhTrang() == 0 ? "Đã thanh toán " : "Chưa thanh toán"});
        }
        jTableHoaDon.setModel(model);
        jTableHoaDon.removeColumn(jTableHoaDon.getColumnModel().getColumn(0));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbMaHoaDon = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnXuatHoaDon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGiohang = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        cbbPhanLoai = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1100, 683));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Sản phẩm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Giỏ hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Mã hóa đơn:");

        jLabel3.setText("Tên khách hàng:");

        jLabel8.setText("Tên nhân viên:");

        jLabel9.setText("Ngày tạo:");

        jLabel10.setText("Số điện thoại:");

        jLabel11.setText("Tổng tiền:");

        jLabel12.setText("Tiền khách đưa:");

        jLabel13.setText("Tiền thừa:");

        jLabel14.setText("Hình thức thanh toán:");

        lbMaHoaDon.setBackground(new java.awt.Color(123, 80, 80));
        lbMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbMaHoaDon.setText("d");

        lbNgayTao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNgayTao.setText("d");

        lbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNhanVien.setText("d");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("d");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("d");

        cbbHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnXuatHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnXuatHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXuatHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatHoaDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("    Hủy đơn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienKhachDua)
                            .addComponent(lbMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(lbNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbMaHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbNgayTao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8))
                    .addComponent(lbNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableHoaDon);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableGiohang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableGiohang.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableGiohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGiohangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGiohang);

        btnXoaSanPham.setText("Xóa Sản Phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnXoaSanPham)
                .addGap(18, 18, 18))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setForeground(new java.awt.Color(255, 51, 0));

        jTableSanPham.setBackground(new java.awt.Color(204, 204, 204));
        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableSanPham);

        cbbPhanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbPhanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhanLoaiActionPerformed(evt);
            }
        });

        txtTimKiem.setBackground(new java.awt.Color(209, 208, 208));
        txtTimKiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Phân loại");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(215, 215, 215)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:

        int row = jTableGiohang.getSelectedRow();

        GioHangViewModel gioHangViewModel = listGioHang.get(row);
        SanPham sanPham = sanPhamService.getOne(gioHangViewModel.getMa());
        int soLuongUpdate = sanPham.getSoLuongTon() + Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString());
        System.out.println(soLuongUpdate);
        sanPham.setSoLuongTon(soLuongUpdate);
        sanPhamService.update(sanPham);
        showSanPham(sanPhamService.getSanPhamBanHang());
        listGioHang.remove(row);
        showGioHang(listGioHang);

    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked

        int row = jTableSanPham.getSelectedRow();
        int soLuong = soLuongMua(row);
        UUID idSanPham = UUID.fromString(jTableSanPham.getModel().getValueAt(row, 0).toString());
        UUID idHoaDon = hoaDon.getIdHoaDon();
        GioHangViewModel ghvm = new GioHangViewModel();
        ghvm.setMa(jTableSanPham.getModel().getValueAt(row, 1).toString());
        ghvm.setTen(jTableSanPham.getModel().getValueAt(row, 2).toString());
        ghvm.setSoLuong(soLuong);
        ghvm.setDonGia(BigDecimal.valueOf(Double.valueOf(jTableSanPham.getModel().getValueAt(row, 7).toString())));
        ghvm.setIdSanPham(idSanPham);
        ghvm.setIdHoaDon(idHoaDon);
        listGioHang.put(idSanPham, ghvm);
        showGioHang(listGioHang);


    }//GEN-LAST:event_jTableSanPhamMouseClicked
    private int soLuongMua(int index) {

        int soLuong = Integer.valueOf(jTableSanPham.getModel().getValueAt(index, 6).toString());
        int numBer = 0;
        try {
            numBer = Integer.valueOf(JOptionPane.showInputDialog("Nhập số lượng", 0));
            if (numBer <= 0) {
                JOptionPane.showMessageDialog(this, "so luong mua phai > 0 ");
                return 0;
            }
            if (numBer > soLuong) {
                JOptionPane.showMessageDialog(this, "so luong sản phẩm còn lại không đủ ");
                return 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập số lượng cần mua");
            return 0;
        }
        return numBer;
    }
    private void cbbPhanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhanLoaiActionPerformed
        // TODO add your handling code here:
        switch (cbbPhanLoai.getSelectedIndex()) {
            case 0:
                showSanPham(sanPhamService.getSanPhamBanHang());
                break;
            case 1:
                showSanPham(sanPhamService.getByGia(BigDecimal.valueOf(10000000), BigDecimal.valueOf(15000000)));
                break;
            case 2:
                showSanPham(sanPhamService.getByGia(BigDecimal.valueOf(15000000), BigDecimal.valueOf(20000000)));
                break;
            case 3:
                showSanPham(sanPhamService.getByGia(BigDecimal.valueOf(20000000), BigDecimal.valueOf(30000000)));
                break;
            case 4:
                showSanPham(sanPhamService.getByGia(BigDecimal.valueOf(30000000), BigDecimal.valueOf(50000000)));
                break;
            default:
                showSanPham(sanPhamService.getByGia(BigDecimal.valueOf(50000000), BigDecimal.valueOf(2000000000)));
                break;
        }
    }//GEN-LAST:event_cbbPhanLoaiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
         String ten = txtTimKiem.getText();
        List<SanPhamBanHangViewModel> list = sanPhamService.searchByTenBanHang(sanPhamService.getSanPhamBanHang(), ten);
        showSanPham(list);

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        if(!listGioHang.isEmpty()){
           hoaDonChiTietServive.saveAllHoaDonChiTiet(listGioHang);
           listGioHang.clear();
       }
        HoaDon newHoaDon = new HoaDon();
        newHoaDon.setMa(new TaoChuoiNgauNhien().getMkRanMa("HD", 7));
        newHoaDon.setNgayTao(new ConverDate().dateToLong( LocalDate.now().toString(), "yyyy/mm/dd"));
        newHoaDon.setNhanVien(nhanVien);
        newHoaDon.setTinhTrang(0);
        hoaDonService.add(newHoaDon);
        hoaDon = newHoaDon;
        lbMaHoaDon.setText(hoaDon.getMa());
        lbNgayTao.setText(new ConverDate().longToDate(hoaDon.getNgayTao(), "dd/mm/yyyy"));
        lbNhanVien.setText(hoaDon.getNhanVien().getHoTen());
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void jTableGiohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGiohangMouseClicked
       
    }//GEN-LAST:event_jTableGiohangMouseClicked

    private void btnXuatHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatHoaDonMouseClicked
       if(!listGioHang.isEmpty()){
           hoaDonChiTietServive.saveAllHoaDonChiTiet(listGioHang);
           listGioHang.clear();
       }
    }//GEN-LAST:event_btnXuatHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JLabel btnXuatHoaDon;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbbPhanLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableGiohang;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JLabel lbMaHoaDon;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
