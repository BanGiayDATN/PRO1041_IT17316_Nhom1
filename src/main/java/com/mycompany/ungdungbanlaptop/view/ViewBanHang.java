/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.google.zxing.WriterException;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.QRCode.GenerateQRCode;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.infrastructure.email.EmailKhachHang;
import com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.CreartTableWord;
import com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.GeneratePdf;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.ImeiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ImeiRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.KhachHangService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.KhachHangServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
    private ImeiRepository imeiRepository = new ImeiRepositoryImpl();
    private Map<UUID, GioHangViewModel> listGioHang = new HashMap<>();
    private List<GioHangViewModel> list = new ArrayList<>();
    private List<String> listSoDienThoai = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private NhanVien nhanVien;
    private HoaDon hoaDon;
    private KhachHang khachHang;
    private HoaDonChiTiet hoaDonChiTiet;

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
        String[] sp = {"id", "STT", "Mã SP", "Tên SP", "Năm SX", "Trọng lượng", "Số lượng", "Giá bán", "Mô tả"};
        dtm3.setColumnIdentifiers(sp);
        dtm3.setRowCount(0);
        for (SanPhamBanHangViewModel x : list) {
            dtm3.addRow(new Object[]{x.getId(), jTableSanPham.getRowCount() + 1, x.getMa(), x.getTen(), x.getNamBH(), x.getTrongLuong(), x.getSoLuongTon(), x.getGiaBan(), x.getMoTa()});
        }
        jTableSanPham.removeColumn(jTableSanPham.getColumnModel().getColumn(0));
    }

    private void showGioHang(Map<UUID, GioHangViewModel> list) {

        jTableGiohang.setModel(dtm2);
        String[] gh = {"idSP", "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn Giá"};
        dtm2.setColumnIdentifiers(gh);

        dtm2.setRowCount(0);
        for (GioHangViewModel x : list.values()) {
            dtm2.addRow(new Object[]{x.getIdSanPham(), jTableGiohang.getRowCount() + 1, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia()});
        }
        jTableGiohang.removeColumn(jTableGiohang.getColumnModel().getColumn(0));

    }

    private void showHoaDon(List<HoaDonBanHangViewModel> list) {
        jTableHoaDon.setModel(dtm1);
        String[] hd = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV"};
        dtm1.setColumnIdentifiers(hd);

        dtm1.setRowCount(0);
        for (HoaDonBanHangViewModel x : list) {
            dtm1.addRow(new Object[]{jTableHoaDon.getRowCount() + 1, x.getMa(), new ConverDate().longToDate(x.getNgayTao(), "dd/MM/yyyy"), x.getHoTen()});
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        miXoa = new javax.swing.JMenuItem();
        miUpdateSoLuong = new javax.swing.JMenuItem();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        cbbPhanLoai = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGiohang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenKHHoaDon = new javax.swing.JLabel();
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
        txtTimKiemSoDienThoai = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnHuyDon = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();

        miXoa.setText("Xóa sản phẩm");
        miXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miXoaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miXoa);

        miUpdateSoLuong.setText("Cập nhập số lượng");
        miUpdateSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdateSoLuongActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miUpdateSoLuong);

        setBackground(new java.awt.Color(242, 247, 242));
        setPreferredSize(new java.awt.Dimension(1100, 683));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 0, 0)));

        jTableHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tên nhân viên"
            }
        ));
        jTableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableHoaDon);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Hóa đơn chờ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 51, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jTableSanPham.setAutoCreateRowSorter(true);
        jTableSanPham.setBackground(new java.awt.Color(204, 255, 204));
        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm SX", "Trọng lượng", "Số lượng tốn", "Đơn giá", "Mô tả"
            }
        ));
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableSanPham);

        cbbPhanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhanLoaiActionPerformed(evt);
            }
        });

        txtTimKiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiem.setText("Nhập thông tin tìm kiếm...");
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(183, 183, 218));
        jLabel15.setText("Phân loại");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(183, 183, 218));
        jLabel30.setText("Tìm kiếm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Sản phẩm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(cbbPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 0, 0));

        jTableGiohang.setBackground(new java.awt.Color(204, 255, 204));
        jTableGiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        jTableGiohang.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(jTableGiohang);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Giỏ hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        txtPhiship.setText("0");

        jScrollPane5.setViewportView(txtDiaChiHoaDon);

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

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
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhiship, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(txtTimKiemSoDienThoai)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtNgaytao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtTenNhanvien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtTenKHHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                                        .addGap(105, 105, 105)
                                                        .addComponent(rbShip)))
                                                .addGap(0, 41, Short.MAX_VALUE))))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(rbTaiCuahang)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))))
                .addContainerGap())
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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtTimKiemSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
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

        btnTaoHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        btnHuyDon.setBackground(new java.awt.Color(255, 255, 255));
        btnHuyDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:

        int row = jTableSanPham.getSelectedRow();
        int soLuong = soLuongMua(row);
        if (soLuong != 0) {
            UUID idSanPham = UUID.fromString(jTableSanPham.getModel().getValueAt(row, 0).toString());
            GioHangViewModel ghvm = new GioHangViewModel();
            ghvm.setMa(jTableSanPham.getModel().getValueAt(row, 2).toString());
            ghvm.setTen(jTableSanPham.getModel().getValueAt(row, 3).toString());
            ghvm.setSoLuong(soLuong);
            BigDecimal donGia = new BigDecimal(jTableSanPham.getModel().getValueAt(row, 7).toString());
            ghvm.setDonGia(donGia);
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
            if (numBer >= soLuong) {
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

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        // TODO add your handling code here:
        HoaDon newHoaDon = new HoaDon();
        newHoaDon.setTinhTrang(0);
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
        try {
            // TODO add your handling code here:
            int sum = 0;
            for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setSoLuong(x.getValue().getSoLuong());
                hoaDonChiTiet.setDonGia(x.getValue().getDonGia());
                hoaDonChiTiet.setHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()));
                hoaDonChiTiet.setSanPham(sanPhamService.getOne(x.getValue().getMa()));
                hoaDonChiTietService.add(hoaDonChiTiet);

                int soLuong = x.getValue().getSoLuong();
                for (int i = 1; i < soLuong + 1; ++i) {
                    Imei imei = new Imei();
                    imei.setMa(new TaoChuoiNgauNhien().getiMei(16));
                    imei.setTrangThai(0);
                    imei.setHoaDonChiTiet(hoaDonChiTiet);
                    imeiRepository.add(imei);
                }
            }
            ////// update hoadon
            hoaDon = hoaDonService.getOne(txtMaHoaDon.getText());
            hoaDon.setTinhTrang(1);
            hoaDon.setDiaChhi(txtDiaChiHoaDon.getText());
            hoaDon.setKhachHang(khachHangService.getBySoDienThoai(txtTimKiemSoDienThoai.getText()));
            String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
            hoaDon.setNgayThanhToan(new ConverDate().dateToLong(date, "dd/MM/yyyy"));
            hoaDon.setTenNguoiNhan(txtTenKHHoaDon.getText());
            hoaDon.setSdt(txtTimKiemSoDienThoai.getText());
            hoaDonService.setTrangThai(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon(), hoaDon);

            // in hoa don
            UUID idHoaDon = hoaDon.getIdHoaDon();
            String maQRHoaDonChiTiet = new TaoChuoiNgauNhien().getMaHoaDon("HD", 5);
            List<HoaDonChiTiet> list = hoaDonChiTietService.getWord(idHoaDon);
            new GenerateQRCode().CreateQRCode(String.valueOf(idHoaDon), maQRHoaDonChiTiet);

            // word
//            new CreartTableWord().word(date,hoaDon.getTenNguoiNhan(),maQRHoaDonChiTiet, maQRHoaDonChiTiet, list);
            // pdf
            new GeneratePdf().exportBill(maQRHoaDonChiTiet, maQRHoaDonChiTiet, hoaDon, list);

            // gưi email cho khách hàng
            String emailKhach = hoaDon.getKhachHang().getEmail();
            System.out.println(emailKhach);
            new EmailKhachHang().guiEmailDinhKiem(emailKhach, maQRHoaDonChiTiet);

            // tinh tien
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
            showHoaDon(hoaDonService.getHoaDonBanHang());
            listGioHang.entrySet().clear();
            showGioHang(listGioHang);
            clearHoaDon();
        } catch (WriterException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnThanhToanMouseClicked

    private int tongSoLuong() {
        int tong = 0;
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            tong += x.getValue().getSoLuong();

        }
        return tong;
    }
    private void btnHuyDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyDonMouseClicked
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn Chắc chắn muốn hủy?", "Hủy hóa đơn", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            HoaDon hd = new HoaDon();
            hd.setIdHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon());
            hoaDonService.delete(hd);
            showHoaDon(hoaDonService.getHoaDonBanHang());
            removeGioHang();
            clearHoaDon();
        }
    }//GEN-LAST:event_btnHuyDonMouseClicked
    private void clearHoaDon() {
        txtMaHoaDon.setText("");
        txtNgaytao.setText("");
        txtTenNhanvien.setText("");
        txtTenKHHoaDon.setText("");
        txtTimKiemSoDienThoai.setText("");
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
        KhachHang kh = khachHangService.getBySoDienThoai(soDienThoai);

        if (kh != null) {
            txtTenKHHoaDon.setText(kh.getHoTen());
            txtDiaChiHoaDon.setText(kh.getDiaChi());

        } else {
            KhachHang khachHang1 = new KhachHang();
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại, hãy thêm khách hàng mới!");

            new ViewThemKhachHang(khachHang1).setVisible(true);
        }


    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void jTableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHoaDonMouseClicked
        // TODO add your handling code here:
        int row = jTableHoaDon.getSelectedRow();
        txtMaHoaDon.setText(jTableHoaDon.getValueAt(row, 1).toString());
        txtNgaytao.setText(jTableHoaDon.getValueAt(row, 2).toString());
        txtTenNhanvien.setText(jTableHoaDon.getValueAt(row, 3).toString());


    }//GEN-LAST:event_jTableHoaDonMouseClicked

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        BigDecimal tienKhachDua = new BigDecimal(txtTienKhachDua.getText());
        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
        txtTienThua.setText(String.valueOf(tienKhachDua.subtract(tongTien)));
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void miXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miXoaActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            int row = jTableGiohang.getSelectedRow();
            UUID id = UUID.fromString(jTableGiohang.getModel().getValueAt(row, 0).toString());

            SanPham sanPham = sanPhamService.getById(id);
            int soLuongUpdate = sanPham.getSoLuongTon() + Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString());
            System.out.println(soLuongUpdate);
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());

            listGioHang.remove(id);
            showGioHang(listGioHang);
        }
    }//GEN-LAST:event_miXoaActionPerformed

    private void miUpdateSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateSoLuongActionPerformed
        // TODO add your handling code here:
        int row = jTableGiohang.getSelectedRow();
        UUID id = UUID.fromString(jTableGiohang.getModel().getValueAt(row, 0).toString());

        int numBer = soLuongMua(row);
        if (numBer > Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString())) {
            GioHangViewModel gioHangViewModel = listGioHang.get(id);
            gioHangViewModel.setSoLuong(numBer);

            SanPham sanPham = sanPhamService.getById(id);
            int soLuongUpdate = sanPham.getSoLuongTon() - (numBer - Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString()));
            System.out.println(soLuongUpdate);
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());

            BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
            txtTongTien.setText(String.valueOf(tongTien().add(phiShip)));

            showGioHang(listGioHang);

        } else {
            GioHangViewModel gioHangViewModel = listGioHang.get(id);
            gioHangViewModel.setSoLuong(numBer);

            SanPham sanPham = sanPhamService.getById(id);
            int soLuongUpdate = sanPham.getSoLuongTon() + (Integer.valueOf(jTableGiohang.getValueAt(row, 3).toString()) - numBer);
            System.out.println(soLuongUpdate);
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());

            BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
            txtTongTien.setText(String.valueOf(tongTien().add(phiShip)));

            showGioHang(listGioHang);
        }
    }//GEN-LAST:event_miUpdateSoLuongActionPerformed
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnHuyDon;
    private javax.swing.JPanel btnTaoHoaDon;
    private javax.swing.JPanel btnThanhToan;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbbPhanLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableGiohang;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JMenuItem miUpdateSoLuong;
    private javax.swing.JMenuItem miXoa;
    private javax.swing.JRadioButton rbShip;
    private javax.swing.JRadioButton rbTaiCuahang;
    private javax.swing.JEditorPane txtDiaChiHoaDon;
    private javax.swing.JLabel txtMaHoaDon;
    private javax.swing.JLabel txtNgaytao;
    private javax.swing.JTextField txtPhiship;
    private javax.swing.JLabel txtTenKHHoaDon;
    private javax.swing.JLabel txtTenNhanvien;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemSoDienThoai;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
