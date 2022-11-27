/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.KhachHangService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.KhachHangServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author Diệm DZ
 */
public class ViewBanHang extends javax.swing.JPanel {

    private DefaultTableModel dtm1 = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private DefaultTableModel dtm3 = new DefaultTableModel();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private Map<UUID, GioHangViewModel> listGioHang = new HashMap<>();
    private List<GioHangViewModel> list = new ArrayList<>();
    private NhanVien nhanVien;
    private HoaDon hoaDon;

    /**
     * Creates new form ViewBanHang
     */
    public ViewBanHang(NhanVien nhanVien) {
        initComponents();
        this.nhanVien = nhanVien;
        showHoaDon(hoaDonService.getHoaDonBanHang());
        showSanPham(sanPhamService.getSanPhamBanHang());

        cbbHinhThucThanhToan();
        cbbPhanLoai();
        phiShip();

    }

    private void phiShip() {
        if (rbTaiCuahang.isSelected()) {
            txtPhiship.setText("0");
        }
    }

    private void cbbHinhThucThanhToan() {
        DefaultComboBoxModel dcmHinhThucThanhToan = new DefaultComboBoxModel();

        cbbHinhThucThanhToan.setModel(dcmHinhThucThanhToan);
        dcmHinhThucThanhToan.addElement("Chuyển khoản");
        dcmHinhThucThanhToan.addElement("Tiền mặt");
        dcmHinhThucThanhToan.addElement("Chuyển khoản & Tiền mặt");

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
        jTableSanPham.setModel(dtm3);
        String[] sp = {"id", "STT", "Mã SP", "Tên SP", "Năm BH", "Trọng lượng", "Số lượng", "Giá bán", "Mô tả"};
        dtm3.setColumnIdentifiers(sp);
        dtm3.setRowCount(0);
        for (SanPhamBanHangViewModel x : list) {
            dtm3.addRow(new Object[]{x.getId(), jTableSanPham.getRowCount() + 1, x.getMa(), x.getTen(), x.getNamBH(), x.getTrongLuong(), x.getSoLuongTon(), x.getGiaBan(), x.getMoTa()});
        }
        jTableSanPham.removeColumn(jTableSanPham.getColumnModel().getColumn(0));
    }

//    private void showGioHang(List<GioHangViewModel> list) {
//        dtm2.setRowCount(0);
//        for (GioHangViewModel x : list) {
//            BigDecimal soLuong = new BigDecimal(x.getSoLuong());
//            dtm2.addRow(new Object[]{jTableGiohang.getRowCount() + 1, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia(), soLuong.multiply(x.getDonGia())});
//        }
//    }
    private void showGioHang(Map<UUID, GioHangViewModel> list) {

        jTableGiohang.setModel(dtm2);
        String[] gh = {"idSP","STT", "Mã SP", "Tên SP", "Số lượng", "Đơn Giá", "Thành tiền"};
        dtm2.setColumnIdentifiers(gh);

        dtm2.setRowCount(0);
        for (GioHangViewModel x : list.values()) {
            BigDecimal soLuong = new BigDecimal(x.getSoLuong());
            dtm2.addRow(new Object[]{x.getIdSanPham(), jTableGiohang.getRowCount() + 1, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia(), soLuong.multiply(x.getDonGia())});
        }
        jTableGiohang.removeColumn(jTableGiohang.getColumnModel().getColumn(0));

    }

    private void showHoaDon(List<HoaDonBanHangViewModel> list) {
        jTableHoaDon.setModel(dtm1);
        String[] hd = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Tình trạng"};
        dtm1.setColumnIdentifiers(hd);

        dtm1.setRowCount(0);
        for (HoaDonBanHangViewModel x : list) {
            dtm1.addRow(new Object[]{jTableHoaDon.getRowCount() + 1, x.getMa(), new ConverDate().longToDate(x.getNgayTao(), "dd/MM/yyyy"), x.getHoTen(), x.trangThai()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        btnDaThanhToan = new javax.swing.JRadioButton();
        btnChuaThanhToan = new javax.swing.JRadioButton();
        btnDaHuy = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        cbbPhanLoai = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGiohang = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        XoaAll = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenKHHoaDon = new javax.swing.JLabel();
        txtSDTHoaDon = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTenNhanvien = new javax.swing.JLabel();
        txtNgaytao = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        rbTaiCuahang = new javax.swing.JRadioButton();
        rbShip = new javax.swing.JRadioButton();
        txtTongTien = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPhiship = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDiaChiHoaDon = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        rbHoatDong = new javax.swing.JRadioButton();
        txtTenKhachHang = new javax.swing.JTextField();
        rbNgungHoatDong = new javax.swing.JRadioButton();
        btnThemKhachHanh = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        rbNam = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        rbNu = new javax.swing.JRadioButton();
        btnThanhToan = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnHuyDon = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiemSoDienThoai = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JLabel();
        btnMucThemKH = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 683));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 204), new java.awt.Color(204, 204, 255)));

        jTableHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableHoaDon);

        btnDaThanhToan.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(btnDaThanhToan);
        btnDaThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnDaThanhToan.setText("Đã thanh toán");
        btnDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaThanhToanActionPerformed(evt);
            }
        });

        btnChuaThanhToan.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(btnChuaThanhToan);
        btnChuaThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnChuaThanhToan.setSelected(true);
        btnChuaThanhToan.setText("Chưa thanh toán");
        btnChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuaThanhToanActionPerformed(evt);
            }
        });

        btnDaHuy.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(btnDaHuy);
        btnDaHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnDaHuy.setText("Đã hủy");
        btnDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnDaThanhToan)
                .addGap(34, 34, 34)
                .addComponent(btnChuaThanhToan)
                .addGap(38, 38, 38)
                .addComponent(btnDaHuy)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDaThanhToan)
                    .addComponent(btnChuaThanhToan)
                    .addComponent(btnDaHuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        jPanel4.setForeground(new java.awt.Color(255, 51, 0));

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

        txtTimKiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Phân loại");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setText("Tìm kiếm");

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
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel30)
                .addGap(237, 237, 237)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Sản phẩm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Giỏ hàng");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(255, 204, 204), new java.awt.Color(204, 204, 255)));

        jTableGiohang.setBorder(new javax.swing.border.MatteBorder(null));
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
        jScrollPane2.setViewportView(jTableGiohang);

        btnXoaSanPham.setText("Xóa Sản Phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã hóa đơn");

        XoaAll.setText("Xóa tất cả");
        XoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnXoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(XoaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XoaAll)
                    .addComponent(btnXoaSanPham))
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("Ngày tạo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Tên nhân viên:");

        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("Số điện thoại:");

        txtTenKHHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenKHHoaDon.setText(" ");

        txtSDTHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSDTHoaDon.setText(" ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setText("Địa chỉ:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel28.setText("Mã hóa đơn:");

        txtTenNhanvien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenNhanvien.setText(" ");
        txtTenNhanvien.setToolTipText("");

        txtNgaytao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNgaytao.setText(" ");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel40.setText("Giao hàng:");

        buttonGroup3.add(rbTaiCuahang);
        rbTaiCuahang.setSelected(true);
        rbTaiCuahang.setText("Tại cửa hàng");

        buttonGroup3.add(rbShip);
        rbShip.setText("Ship hàng");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTongTien.setText(" ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setText("Tổng tiền hàng:");

        txtTienThua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTienThua.setText(" ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel17.setText("Tiền khách đưa:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel18.setText("Tiền thừa:");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setText("Hình thức thanh toán:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setText("Phí ship:");

        jScrollPane5.setViewportView(txtDiaChiHoaDon);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTienKhachDua)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPhiship, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel40))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtNgaytao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtTenNhanvien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTenKHHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(rbTaiCuahang)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbShip))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtSDTHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(10, 10, 10))))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtMaHoaDon))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNgaytao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenNhanvien))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKHHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSDTHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(rbTaiCuahang)
                    .addComponent(rbShip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPhiship, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTongTien))
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel8);

        jLabel31.setText("Email:");

        jLabel32.setText("Trạng thái:");

        jLabel33.setText("Địa chỉ:");

        jLabel34.setText("Số điện thoại:");

        jTextField2.setText("Mã khách hàng tự tạo");

        rbHoatDong.setSelected(true);
        rbHoatDong.setText("Hoạt động");

        rbNgungHoatDong.setText("Ngừng hoạt động");

        btnThemKhachHanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btnThemKhachHanh.setText("Thêm");
        btnThemKhachHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHanhActionPerformed(evt);
            }
        });

        jLabel35.setText("Mã khách hàng:");

        jLabel36.setText("Họ và tên:");

        jLabel37.setText("Giới tính:");

        rbNam.setSelected(true);
        rbNam.setText("Nam");

        jLabel38.setText("Ngày sinh:");

        rbNu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel34))
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rbNam)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbNu))
                                .addComponent(jTextField2)
                                .addComponent(txtTenKhachHang)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addComponent(txtSoDienThoai)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbHoatDong)
                                .addGap(18, 18, 18)
                                .addComponent(rbNgungHoatDong))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnThemKhachHanh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(rbNam)
                            .addComponent(rbNu))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(rbHoatDong)
                    .addComponent(rbNgungHoatDong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemKhachHanh)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách hàng", jPanel1);

        btnThanhToan.setBackground(new java.awt.Color(0, 102, 102));
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(0, 102, 102));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText(" Thanh toán");

        javax.swing.GroupLayout btnThanhToanLayout = new javax.swing.GroupLayout(btnThanhToan);
        btnThanhToan.setLayout(btnThanhToanLayout);
        btnThanhToanLayout.setHorizontalGroup(
            btnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnThanhToanLayout.setVerticalGroup(
            btnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThanhToanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 102, 102));
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Tạo hóa đơn");

        javax.swing.GroupLayout btnTaoHoaDonLayout = new javax.swing.GroupLayout(btnTaoHoaDon);
        btnTaoHoaDon.setLayout(btnTaoHoaDonLayout);
        btnTaoHoaDonLayout.setHorizontalGroup(
            btnTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTaoHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnTaoHoaDonLayout.setVerticalGroup(
            btnTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTaoHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnHuyDon.setBackground(new java.awt.Color(0, 102, 102));
        btnHuyDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyDonMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText(" Hủy đơn");

        javax.swing.GroupLayout btnHuyDonLayout = new javax.swing.GroupLayout(btnHuyDon);
        btnHuyDon.setLayout(btnHuyDonLayout);
        btnHuyDonLayout.setHorizontalGroup(
            btnHuyDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHuyDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        btnHuyDonLayout.setVerticalGroup(
            btnHuyDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHuyDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel27.setText("Tìm kiếm KH:");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        btnMucThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add.png"))); // NOI18N
        btnMucThemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMucThemKHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6)
                                .addGap(91, 91, 91)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiemSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(btnMucThemKH)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimKiem)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiemSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27))
                            .addComponent(btnMucThemKH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaThanhToanActionPerformed
        // TODO add your handling code here:
        showHoaDon(hoaDonService.getTrangThai(0));
    }//GEN-LAST:event_btnDaThanhToanActionPerformed

    private void btnChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuaThanhToanActionPerformed
        // TODO add your handling code here:
        showHoaDon(hoaDonService.getTrangThai(1));
    }//GEN-LAST:event_btnChuaThanhToanActionPerformed

    private void btnDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaHuyActionPerformed
        // TODO add your handling code here:
        showHoaDon(hoaDonService.getTrangThai(2));
    }//GEN-LAST:event_btnDaHuyActionPerformed

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:
        if (txtMaHoaDon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy tạo hóa đơn");
        } else {
            int row = jTableSanPham.getSelectedRow();
            int soLuong = soLuongMua(row);
            if (soLuong != 0) {
                UUID idSanPham = UUID.fromString(jTableSanPham.getModel().getValueAt(row, 0).toString());
                GioHangViewModel ghvm = new GioHangViewModel();
                ghvm.setMa(jTableSanPham.getModel().getValueAt(row, 2).toString());
                ghvm.setTen(jTableSanPham.getModel().getValueAt(row, 3).toString());
                ghvm.setSoLuong(soLuong);
                ghvm.setDonGia(BigDecimal.valueOf(Double.valueOf(jTableSanPham.getModel().getValueAt(row, 7).toString())));
                ghvm.setIdSanPham(idSanPham);

                listGioHang.put(idSanPham, ghvm);
                showGioHang(listGioHang);
            }

            SanPhamBanHangViewModel model = sanPhamService.getSanPhamBanHang().get(row);
            System.out.println(model);
            SanPham sanPham = sanPhamService.getById(model.getId());
            int soLuongUpdate = sanPham.getSoLuongTon() - soLuong;
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);

            showSanPham(sanPhamService.getSanPhamBanHang());

            BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
            txtTongTien.setText(String.valueOf(tongTien().add(phiShip)));

        }


    }//GEN-LAST:event_jTableSanPhamMouseClicked
    private BigDecimal tongTien() {
        BigDecimal tong = new BigDecimal(BigInteger.ZERO);
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            BigDecimal soLuong = new BigDecimal(x.getValue().getSoLuong());
            tong = tong.add(soLuong.multiply(x.getValue().getDonGia()));

        }
        return tong;
    }

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
        // TODO add your handling code here:
        String ten = txtTimKiem.getText();
        List<SanPhamBanHangViewModel> listNew = sanPhamService.searchByTenBanHang(sanPhamService.getSanPhamBanHang(), ten);
        showSanPham(listNew);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        // TODO add your handling code here:
        JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
        int row = jTableGiohang.getSelectedRow();
         UUID id = UUID.fromString(jTableGiohang.getModel().getValueAt(row, 0).toString());
      

            SanPham sanPham = sanPhamService.getById(id);
            int soLuongUpdate = sanPham.getSoLuongTon() + Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString());
            System.out.println(soLuongUpdate);
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());
            
        
//        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
//
//            SanPham sanPham = sanPhamService.getById(x.getValue().getIdSanPham());
//            int soLuongUpdate = sanPham.getSoLuongTon() + x.getValue().getSoLuong();
//            System.out.println(soLuongUpdate);
//            sanPham.setSoLuongTon(soLuongUpdate);
//            sanPhamService.update(sanPham);
//            showSanPham(sanPhamService.getSanPhamBanHang());
//            
//        }
        
       
        listGioHang.remove(id);
        showGioHang(listGioHang);

    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnMucThemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMucThemKHMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnMucThemKHMouseClicked

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        // TODO add your handling code here:
        HoaDon newHoaDon = new HoaDon();
        newHoaDon.setTinhTrang(1);
        newHoaDon.setMa(new TaoChuoiNgauNhien().getMaHoaDon("HD", 3));
        String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        System.out.println(date);
        newHoaDon.setNgayTao(new ConverDate().dateToLong(date, "dd/MM/yyyy"));
        newHoaDon.setNhanVien(nhanVien);
        hoaDonService.add(newHoaDon);

        hoaDon = newHoaDon;
        txtMaHoaDon.setText(hoaDon.getMa());
        txtNgaytao.setText(new ConverDate().longToDate(hoaDon.getNgayTao(), "dd/MM/yyyy"));
        txtTenNhanvien.setText(hoaDon.getNhanVien().getHoTen());

        showHoaDon(hoaDonService.getHoaDonBanHang());
    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:

        // add hoa don chi tiet
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setSoLuong(x.getValue().getSoLuong());
            hoaDonChiTiet.setDonGia(x.getValue().getDonGia());
            hoaDonChiTiet.setHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()));
            hoaDonChiTiet.setSanPham(sanPhamService.getOne(x.getValue().getMa()));
            hoaDonChiTietService.add(hoaDonChiTiet);

        }
        ////// update hoadon
        hoaDon = hoaDonService.getOne(txtMaHoaDon.getText());
        hoaDon.setTinhTrang(0);
        hoaDon.setDiaChhi(txtDiaChiHoaDon.getText());
        hoaDon.setKhachHang(khachHangService.getBySoDienThoai(txtSDTHoaDon.getText()));
        String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        hoaDon.setNgayThanhToan(new ConverDate().dateToLong(date, "dd/MM/yyyy"));
        hoaDon.setTenNguoiNhan(txtTenKHHoaDon.getText());
        hoaDon.setSdt(txtSDTHoaDon.getText());
        hoaDonService.setTrangThai(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon(), hoaDon);

        // tinh tien
//        BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
//        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
//        txtTienThua.setText(String.valueOf(tienKhachDua.subtract(tongTien)));
        removeGioHang();
        clearHoaDon();

    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnHuyDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyDonMouseClicked
        // TODO add your handling code here:
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setSoLuong(x.getValue().getSoLuong());
            hoaDonChiTiet.setDonGia(x.getValue().getDonGia());
            hoaDonChiTiet.setHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()));
            hoaDonChiTiet.setSanPham(sanPhamService.getOne(x.getValue().getMa()));
            hoaDonChiTietService.add(hoaDonChiTiet);

        }
        hoaDon = hoaDonService.getOne(txtMaHoaDon.getText());
        hoaDon.setTinhTrang(2);
        hoaDon.setDiaChhi(khachHangService.getByTen(txtTenKHHoaDon.getText()).getDiaChi());
        hoaDon.setKhachHang(khachHangService.getBySoDienThoai(txtSDTHoaDon.getText()));
        String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        hoaDon.setNgayThanhToan(new ConverDate().dateToLong(date, "dd/MM/yyyy"));
        hoaDon.setTenNguoiNhan(txtTenKHHoaDon.getText());
        hoaDon.setSdt(txtSDTHoaDon.getText());
        hoaDonService.setTrangThai(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon(), hoaDon);
        showHoaDon(hoaDonService.getHoaDonBanHang());
        removeGioHang();
        clearHoaDon();

        BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
        txtTienThua.setText(String.valueOf(tienKhachDua.subtract(tongTien)));


    }//GEN-LAST:event_btnHuyDonMouseClicked
    private void clearHoaDon() {
        txtMaHoaDon.setText("");
        txtNgaytao.setText("");
        txtTenNhanvien.setText("");
        txtTenKHHoaDon.setText("");
        txtSDTHoaDon.setText("");
        buttonGroup3.clearSelection();
        txtDiaChiHoaDon.setText("");
        txtPhiship.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
    }
    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        String soDienThoai = txtTimKiemSoDienThoai.getText();
        KhachHang khachHang = khachHangService.getBySoDienThoai(soDienThoai);

        txtTenKHHoaDon.setText(khachHang.getHoTen());
        txtSDTHoaDon.setText(khachHang.getSdt());

        if (rbTaiCuahang.isSelected()) {

            txtDiaChiHoaDon.setText("");
            txtPhiship.setText("0");
        } else {
            txtDiaChiHoaDon.setText(khachHang.getDiaChi());
            txtPhiship.setText("");
        }


    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void jTableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHoaDonMouseClicked
        // TODO add your handling code here:
        int row = jTableHoaDon.getSelectedRow();
        txtMaHoaDon.setText(jTableHoaDon.getValueAt(row, 1).toString());
        txtNgaytao.setText(jTableHoaDon.getValueAt(row, 2).toString());
        txtTenNhanvien.setText(jTableHoaDon.getValueAt(row, 3).toString());


    }//GEN-LAST:event_jTableHoaDonMouseClicked

    private void btnThemKhachHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHanhActionPerformed
        // TODO add your handling code here:
        KhachHang khachHang = new KhachHang();
        khachHang.setMa(new TaoChuoiNgauNhien().getMaKhachHang("KH", 3));
        khachHang.setHoTen(txtTenKhachHang.getText());
        khachHang.setDiaChi(txtDiaChi.getText());
        khachHang.setEmail(txtEmail.getText());
        if (rbNam.isSelected()) {
            khachHang.setGioiTinh("Nam");
        } else {
            khachHang.setGioiTinh("Nữ");
        }

        Date ngaySinh = txtNgaySinh.getDate();
        String conver = new ConverDate().convertDateToString(ngaySinh, "dd/MM/yyyy");
        khachHang.setNgaySinh(new ConverDate().dateToLong(conver, "dd/MM/yyyy"));
        khachHang.setSdt(txtSoDienThoai.getText());

        if (rbHoatDong.isSelected()) {
            khachHang.setTrangThai(0);
        } else {
            khachHang.setTrangThai(1);
        }
        JOptionPane.showMessageDialog(this, khachHangService.add(khachHang));

    }//GEN-LAST:event_btnThemKhachHanhActionPerformed

    private void XoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaAllActionPerformed
        // TODO add your handling code here:   
        JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
        removeGioHang();


    }//GEN-LAST:event_XoaAllActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
       BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
        txtTienThua.setText(String.valueOf(tienKhachDua.subtract(tongTien)));
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased
    private void removeGioHang() {
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            SanPham sanPham = sanPhamService.getOne(x.getValue().getMa());
            int soLuongUpdate = sanPham.getSoLuongTon() + x.getValue().getSoLuong();
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());
        }
        listGioHang.entrySet().clear();
        showGioHang(listGioHang);
    }

    private void clearKhachHang() {
        txtTenKhachHang.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSoDienThoai.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton XoaAll;
    private javax.swing.JRadioButton btnChuaThanhToan;
    private javax.swing.JRadioButton btnDaHuy;
    private javax.swing.JRadioButton btnDaThanhToan;
    private javax.swing.JPanel btnHuyDon;
    private javax.swing.JLabel btnMucThemKH;
    private javax.swing.JPanel btnTaoHoaDon;
    private javax.swing.JPanel btnThanhToan;
    private javax.swing.JButton btnThemKhachHanh;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbbPhanLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableGiohang;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rbHoatDong;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNgungHoatDong;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JRadioButton rbShip;
    private javax.swing.JRadioButton rbTaiCuahang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JEditorPane txtDiaChiHoaDon;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtMaHoaDon;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JLabel txtNgaytao;
    private javax.swing.JTextField txtPhiship;
    private javax.swing.JLabel txtSDTHoaDon;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JLabel txtTenKHHoaDon;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JLabel txtTenNhanvien;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemSoDienThoai;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
