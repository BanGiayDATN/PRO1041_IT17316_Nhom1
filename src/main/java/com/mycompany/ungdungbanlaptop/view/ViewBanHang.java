/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import antlr.debug.InputBufferEvent;
import com.google.zxing.WriterException;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.QRCode.GenerateQRCode;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiKhuyenMai;
import com.mycompany.ungdungbanlaptop.infrastructure.email.EmailKhachHang;
import com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.GeneratePdf;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.ImeiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ImeiRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;
import com.mycompany.ungdungbanlaptop.service.KhachHangService;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import com.mycompany.ungdungbanlaptop.service.NhanVienService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonChiTietServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HoaDonServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.KhachHangServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.KhuyenMaiServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.NhanVienServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.Cursor;
>>>>>>> develop
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

/**
 *
 * @author Diệm DZ
 */
public class ViewBanHang extends javax.swing.JPanel {

    private DefaultTableModel dtm1 = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private DefaultTableModel dtm3 = new DefaultTableModel();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private ImeiRepository imeiRepository = new ImeiRepositoryImpl();
    private Map<UUID, GioHangViewModel> listGioHang = new HashMap<>();
    private List<HoaDonChiTiet> listHDCT = hoaDonChiTietService.getAll();
    private List<String> listSoDienThoai = new ArrayList<>();
    private KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();

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
        btnSeach.setToolTipText("tìm khuyến mãi");
        cbbHinhThucThanhToan();
        cbbPhanLoai();
<<<<<<< HEAD
        TableFilterHeader filterHeader = new TableFilterHeader(jTableSanPham, AutoChoices.ENABLED);
=======
        TableFilterHeader filterHeader = new TableFilterHeader(TableSanPham, AutoChoices.ENABLED);
        
>>>>>>> develop
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

        DefaultTableModel model = new DefaultTableModel();
        String[] sp = {"id", "STT", "Mã SP", "Tên SP", "Năm SX", "Trọng lượng", "Số lượng", "Giá bán", "Mô tả"};
        model.setColumnIdentifiers(sp);
        int row = 0;
        for (SanPhamBanHangViewModel x : list) {
            row += 1;
            model.addRow(new Object[]{x.getId(), row, x.getMa(), x.getTen(), x.getNamBH(), x.getTrongLuong(), x.getSoLuongTon(), x.getGiaBan(), x.getMoTa()});
        }
        jTableSanPham.setModel(model);
        jTableSanPham.removeColumn(jTableSanPham.getColumnModel().getColumn(0));
        jTableSanPham.setModel(model);
        jTableSanPham.removeColumn(jTableSanPham.getColumnModel().getColumn(0));

    }

    private void showGioHangHDCT(List<GioHangViewModel> list) {

        TableGiohang.setModel(dtm2);
        String[] gh = {"idHDCT", "idSP", "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn Giá"};
        dtm2.setColumnIdentifiers(gh);

        dtm2.setRowCount(0);
        for (GioHangViewModel x : list) {
            dtm2.addRow(new Object[]{x.getIdHoaDonChiTiet(), x.getIdSanPham(), TableGiohang.getRowCount() + 1, x.getMa(), x.getTen(), x.getSoLuong(), x.getDonGia()});
        }

        TableGiohang.removeColumn(TableGiohang.getColumnModel().getColumn(1));
        TableGiohang.removeColumn(TableGiohang.getColumnModel().getColumn(0));

    }

    private void showHoaDon(List<HoaDonBanHangViewModel> list) {
        TableHoaDon.setModel(dtm1);
        String[] hd = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV"};
        dtm1.setColumnIdentifiers(hd);

        dtm1.setRowCount(0);
        for (HoaDonBanHangViewModel x : list) {
            dtm1.addRow(new Object[]{TableHoaDon.getRowCount() + 1, x.getMa(), new ConverDate().longToDate(x.getNgayTao(), "dd/MM/yyyy"), x.getHoTen()});
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
        TableHoaDon = new javax.swing.JTable();
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
        TableGiohang = new javax.swing.JTable();
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
        jLabel21 = new javax.swing.JLabel();
        cbbKhuyenMaiSanPham = new javax.swing.JComboBox<>();
        btnSeach = new javax.swing.JButton();
        btnImei = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(1150, 720));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 0, 0)));

        TableHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        TableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tên nhân viên"
            }
        ));
        TableHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableHoaDon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TableHoaDonMouseMoved(evt);
            }
        });
        TableHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableHoaDon);

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm SX", "Trọng lượng", "Số lượng tốn", "Đơn giá", "Mô tả"
            }
        ));
<<<<<<< HEAD
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
=======
        TableSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableSanPham.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TableSanPhamMouseMoved(evt);
            }
        });
        TableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
>>>>>>> develop
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
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
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

        TableGiohang.setBackground(new java.awt.Color(204, 255, 204));
        TableGiohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        TableGiohang.setComponentPopupMenu(jPopupMenu1);
        TableGiohang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableGiohang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TableGiohangMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(TableGiohang);

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
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Payment.png"))); // NOI18N
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

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
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
        txtTongTien.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtTongTienCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTongTienInputMethodTextChanged(evt);
            }
        });
        txtTongTien.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTongTienPropertyChange(evt);
            }
        });
        txtTongTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTongTienKeyReleased(evt);
            }
        });

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

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setText("Mã khuyến mãi:");

        cbbKhuyenMaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhuyenMaiSanPhamActionPerformed(evt);
            }
        });

        btnSeach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        btnSeach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeachActionPerformed(evt);
            }
        });

        btnImei.setText("Imei");
        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
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
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel10)
                                    .addComponent(btnImei)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18))
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
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
                                                        .addComponent(rbTaiCuahang)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rbShip)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPhiship, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 58, Short.MAX_VALUE))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbKhuyenMaiSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbHinhThucThanhToan, 0, 197, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiemSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTaiCuahang)
                    .addComponent(rbShip)
                    .addComponent(jLabel40))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(44, 44, 44)
                        .addComponent(btnImei))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhiship, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua)
                    .addComponent(jLabel18))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel19))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSeach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(cbbKhuyenMaiSanPham, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
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
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        jLabel29.setText("Tạo hóa đơn");

        javax.swing.GroupLayout btnTaoHoaDonLayout = new javax.swing.GroupLayout(btnTaoHoaDon);
        btnTaoHoaDon.setLayout(btnTaoHoaDonLayout);
        btnTaoHoaDonLayout.setHorizontalGroup(
            btnTaoHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTaoHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addContainerGap())
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
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Delete.png"))); // NOI18N
        jLabel23.setText(" Hủy đơn");

        javax.swing.GroupLayout btnHuyDonLayout = new javax.swing.GroupLayout(btnHuyDon);
        btnHuyDon.setLayout(btnHuyDonLayout);
        btnHuyDonLayout.setHorizontalGroup(
            btnHuyDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHuyDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuyDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:
        if (txtMaHoaDon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy tạo hóa đơn");
        } else {
            int row = jTableSanPham.getSelectedRow();
            int soLuong = soLuongMua(row);
            if (soLuong != 0) {

                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setSoLuong(soLuong);
                BigDecimal donGia = new BigDecimal(jTableSanPham.getModel().getValueAt(row, 7).toString());
                hoaDonChiTiet.setDonGia(donGia);
                hoaDonChiTiet.setSanPham(sanPhamService.getOne(jTableSanPham.getModel().getValueAt(row, 2).toString()));
                hoaDonChiTiet.setHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()));
                hoaDonChiTietService.add(hoaDonChiTiet);
                showGioHangHDCT(hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon()));
            }

            SanPhamBanHangViewModel model = sanPhamService.getSanPhamBanHang().get(row);
            System.out.println(model);
            SanPham sanPham = sanPhamService.getById(model.getId());
            int soLuongUpdate = sanPham.getSoLuongTon() - soLuong;
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);

            showSanPham(sanPhamService.getSanPhamBanHang());

            BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
            
            txtTongTien.setText(String.format("%.0f",tongTien().add(phiShip)));
            System.out.println(tongTien());

        }
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private BigDecimal tongTien() {
        List<GioHangViewModel> list = hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon());
        BigDecimal tong = new BigDecimal(BigInteger.ZERO);
        for (GioHangViewModel x : list) {
            BigDecimal soLuong = new BigDecimal(x.getSoLuong());
            tong = tong.add(soLuong.multiply(x.getDonGia()));
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

        if (txtTimKiemSoDienThoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại trống");
        } else if (txtDiaChiHoaDon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ trống");
        } else if (txtTienKhachDua.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa trống");
        } else {
            String convertNgayString = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
            long ngayHienTai = new ConverDate().dateToLong(convertNgayString, "dd/MM/yyyy");
            BigDecimal dieuKien;
            if (txtTongTien.getText().isEmpty()) {
                dieuKien = new BigDecimal("0");
            } else {
                dieuKien = new BigDecimal(txtTongTien.getText());
            }
            List<KhuyenMai> listKhuyenMai = khuyenMaiService.findAllKhuyenMaiByDieuKien(ngayHienTai, dieuKien);
            for (KhuyenMai item : listKhuyenMai) {
                if (item.getMa().equalsIgnoreCase(cbbKhuyenMaiSanPham.getSelectedItem().toString())) {
                    item.setSoLuong(item.getSoLuong() - 1);
                    khuyenMaiService.update(item);
                }
            }
            try {

                // TODO add your handling code here:
//            for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
//                // add imei
//                int soLuong = x.getValue().getSoLuong();
//                for (int i = 1; i < soLuong + 1; ++i) {
//                    Imei imei = new Imei();
//                    imei.setMa(new TaoChuoiNgauNhien().getiMei(16));
//                    imei.setTrangThai(0);
//                    imei.setHoaDonChiTiet(hoaDonChiTiet);
//                    imeiRepository.add(imei);
//                }
//            }
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
                new GenerateQRCode().CreateQRCode(String.valueOf(hoaDon.getIdHoaDon()), maQRHoaDonChiTiet);
                new GeneratePdf().exportBill(maQRHoaDonChiTiet, maQRHoaDonChiTiet, hoaDon, list);

                // gưi email cho khách hàng
                String emailKhach = hoaDon.getKhachHang().getEmail();
                System.out.println(emailKhach);
                new EmailKhachHang().guiEmailDinhKiem(emailKhach, maQRHoaDonChiTiet);

                // tinh tien
                JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
                showHoaDon(hoaDonService.getHoaDonBanHang());
                dtm2.setRowCount(0);

                clearHoaDon();
            } catch (WriterException ex) {
                Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(ViewBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            List<GioHangViewModel> list = hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon());

            for (GioHangViewModel x : list) {
                hoaDonChiTiet.setIdHoaDonChiTiet(x.getIdHoaDonChiTiet());
                hoaDonChiTietService.delete(hoaDonChiTiet);
            }

            HoaDon hd = new HoaDon();
            hd.setIdHoaDon(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon());
            hoaDonService.delete(hd);
            int row = TableHoaDon.getSelectedRow();
            HoaDonBanHangViewModel viewModel = hoaDonService.getHoaDonBanHang().get(row);
            HoaDon hoaDon = hoaDonService.getById(viewModel.getId());
            hoaDonService.delete(hoaDon);

            showHoaDon(hoaDonService.getHoaDonBanHang());
            dtm2.setRowCount(0);
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
        txtPhiship.setText("0");
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

    private void TableHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableHoaDonMouseClicked

        // TODO add your handling code here:
        int row = TableHoaDon.getSelectedRow();
        showGioHangHDCT(hoaDonChiTietService.getGioHang(hoaDonService.getOne(TableHoaDon.getValueAt(row, 1).toString()).getIdHoaDon()));
        txtMaHoaDon.setText(TableHoaDon.getValueAt(row, 1).toString());
        txtNgaytao.setText(TableHoaDon.getValueAt(row, 2).toString());
        txtTenNhanvien.setText(TableHoaDon.getValueAt(row, 3).toString());
        BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
        
         txtTongTien.setText(String.format("%.0f",tongTien().add(phiShip)));

        // Show giỏ hàng chi tiết khi click vào hoá đơn chờ

    }//GEN-LAST:event_TableHoaDonMouseClicked

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
            int row = TableGiohang.getSelectedRow();
            UUID id = UUID.fromString(TableGiohang.getModel().getValueAt(row, 1).toString());

            SanPham sanPham = sanPhamService.getById(id);
            int soLuongUpdate = sanPham.getSoLuongTon() + Integer.valueOf(TableGiohang.getValueAt(row, 3).toString());
            System.out.println(soLuongUpdate);
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());

            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setIdHoaDonChiTiet(UUID.fromString(TableGiohang.getModel().getValueAt(row, 0).toString()));
            hoaDonChiTietService.delete(hdct);
            showGioHangHDCT(hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon()));

        }
        BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
        txtTongTien.setText(String.valueOf(tongTien().add(phiShip)));


    }//GEN-LAST:event_miXoaActionPerformed

    private void miUpdateSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateSoLuongActionPerformed
        // TODO add your handling code here:
        int row = TableGiohang.getSelectedRow();
        UUID idSP = UUID.fromString(TableGiohang.getModel().getValueAt(row, 1).toString());
        UUID idHDCT = UUID.fromString(TableGiohang.getModel().getValueAt(row, 0).toString());
        int numBer = soLuongMua(row);
        if (numBer != 0) {
            if (numBer > Integer.valueOf(TableGiohang.getValueAt(row, 3).toString())) {
                HoaDonChiTiet hdct = hoaDonChiTietService.getById(idHDCT);
                hdct.setSoLuong(numBer);
                hoaDonChiTietService.update(hdct);

                SanPham sanPham = sanPhamService.getById(idSP);
                int soLuongUpdate = sanPham.getSoLuongTon() - (numBer - Integer.valueOf(TableGiohang.getValueAt(row, 3).toString()));
                System.out.println(soLuongUpdate);
                sanPham.setSoLuongTon(soLuongUpdate);
                sanPhamService.update(sanPham);
                showSanPham(sanPhamService.getSanPhamBanHang());

                showGioHangHDCT(hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon()));

            } else {
                HoaDonChiTiet hdct = hoaDonChiTietService.getById(idHDCT);
                hdct.setSoLuong(numBer);
                hoaDonChiTietService.update(hdct);

                SanPham sanPham = sanPhamService.getById(idSP);
                int soLuongUpdate = sanPham.getSoLuongTon() + (Integer.valueOf(TableGiohang.getValueAt(row, 3).toString()) - numBer);
                System.out.println(soLuongUpdate);
                sanPham.setSoLuongTon(soLuongUpdate);
                sanPhamService.update(sanPham);
                showSanPham(sanPhamService.getSanPhamBanHang());

                showGioHangHDCT(hoaDonChiTietService.getGioHang(hoaDonService.getOne(txtMaHoaDon.getText()).getIdHoaDon()));
            }
            BigDecimal phiShip = new BigDecimal(txtPhiship.getText());
            txtTongTien.setText(String.valueOf(tongTien().add(phiShip)));
        }
    }//GEN-LAST:event_miUpdateSoLuongActionPerformed

    private void jTableSanPhamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseMoved
        // TODO add your handling code here:


    }//GEN-LAST:event_jTableSanPhamMouseMoved

    private void btnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImeiActionPerformed
        // TODO add your handling code here:
        int row = TableGiohang.getSelectedRow();
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.getById(UUID.fromString(TableGiohang.getModel().getValueAt(row, 0).toString()));
        System.out.println(hoaDonChiTiet.getIdHoaDonChiTiet());
        new ViewImei(hoaDonChiTiet).setVisible(true);


    }//GEN-LAST:event_btnImeiActionPerformed


    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equals("Nhập thông tin tìm kiếm...")) {
            txtTimKiem.setText(null);
            txtTimKiem.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().equals(null)) {
            txtTimKiem.setText("Nhập thông tin tìm kiếm...");
            txtTimKiem.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTongTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTongTienKeyReleased

    }//GEN-LAST:event_txtTongTienKeyReleased

    private void txtTongTienInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTongTienInputMethodTextChanged

    }//GEN-LAST:event_txtTongTienInputMethodTextChanged

    private void txtTongTienCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTongTienCaretPositionChanged

    }//GEN-LAST:event_txtTongTienCaretPositionChanged

    private void txtTongTienPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTongTienPropertyChange

    }//GEN-LAST:event_txtTongTienPropertyChange

    private void cbbKhuyenMaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhuyenMaiSanPhamActionPerformed
        int giamPhanTram = 1;
        BigDecimal giamTienMat = new BigDecimal("0");
        if (!cbbKhuyenMaiSanPham.getSelectedItem().equals("")) {
            String convertNgayString = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
            long ngayHienTai = new ConverDate().dateToLong(convertNgayString, "dd/MM/yyyy");
            BigDecimal dieuKien;
            if (txtTongTien.getText().isEmpty()) {
                dieuKien = new BigDecimal("0");
            } else {
                dieuKien = new BigDecimal(txtTongTien.getText());
            }
            List<KhuyenMai> list = khuyenMaiService.findAllKhuyenMaiByDieuKien(ngayHienTai, dieuKien);
            for (KhuyenMai item : list) {
                if (item.getMa().equalsIgnoreCase(cbbKhuyenMaiSanPham.getSelectedItem().toString())) {
                    if (item.getTrangThai() == 1) {
                        giamPhanTram = item.getPhanTram();
                        System.out.println(giamPhanTram);
                    } else {
                        giamTienMat = item.getGiaTienGiam();
                        System.out.println(String.valueOf(giamTienMat));
                    }

                }
            }
        }
        if (giamPhanTram == 1) {
            txtTongTien.setText(String.valueOf(new BigDecimal(txtTongTien.getText()).subtract(giamTienMat)));

        } else {
            float tongPhanTram = 20;
            BigDecimal tongGiam = new BigDecimal(txtTongTien.getText()).multiply(new BigDecimal(tongPhanTram /100));
            txtTongTien.setText( String.format("%.0f",new BigDecimal(txtTongTien.getText()).subtract(tongGiam)));

        }
    }//GEN-LAST:event_cbbKhuyenMaiSanPhamActionPerformed

    private void btnSeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeachActionPerformed
        String convertNgayString = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        long ngayHienTai = new ConverDate().dateToLong(convertNgayString, "dd/MM/yyyy");
        BigDecimal dieuKien;
        if (txtTongTien.getText().isEmpty()) {
            dieuKien = new BigDecimal("0");
        } else {
            dieuKien = new BigDecimal(txtTongTien.getText());
        }
        loadComboboxKhuyemMai(khuyenMaiService.findAllKhuyenMaiByDieuKien(ngayHienTai, dieuKien));
    }//GEN-LAST:event_btnSeachActionPerformed

    private void TableHoaDonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableHoaDonMouseMoved
        // TODO add your handling code here:
        TableHoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        int row = TableHoaDon.rowAtPoint(evt.getPoint());
        if (row > -1) {
            // easiest way:
            TableHoaDon.clearSelection();
            TableHoaDon.setRowSelectionInterval(row, row);
        } else {
            TableHoaDon.setSelectionBackground(Color.blue);
        }
    }//GEN-LAST:event_TableHoaDonMouseMoved

    private void TableGiohangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableGiohangMouseMoved
        // TODO add your handling code here:
         TableGiohang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        int row = TableGiohang.rowAtPoint(evt.getPoint());
        if (row > -1) {
            // easiest way:
            TableGiohang.clearSelection();
            TableGiohang.setRowSelectionInterval(row, row);
        } else {
            TableGiohang.setSelectionBackground(Color.blue);
        }
    }//GEN-LAST:event_TableGiohangMouseMoved

    private void TableSanPhamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSanPhamMouseMoved
        // TODO add your handling code here:
         TableSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        int row = TableSanPham.rowAtPoint(evt.getPoint());
        if (row > -1) {
            // easiest way:
            TableSanPham.clearSelection();
            TableSanPham.setRowSelectionInterval(row, row);
        } else {
            TableSanPham.setSelectionBackground(Color.blue);
        }
    }//GEN-LAST:event_TableSanPhamMouseMoved

    public void loadComboboxKhuyemMai(List<KhuyenMai> list) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        System.out.println(list);
        if (list != null) {
            list.forEach(item -> {
                model.addElement(item.getMa());
            });
        }
        cbbKhuyenMaiSanPham.setModel(model);
    }

   

    private void removeGioHang() {
        for (Map.Entry<UUID, GioHangViewModel> x : listGioHang.entrySet()) {
            SanPham sanPham = sanPhamService.getOne(x.getValue().getMa());
            int soLuongUpdate = sanPham.getSoLuongTon() + x.getValue().getSoLuong();
            sanPham.setSoLuongTon(soLuongUpdate);
            sanPhamService.update(sanPham);
            showSanPham(sanPhamService.getSanPhamBanHang());
        }
        listGioHang.entrySet().clear();
        showGioHangHDCT((List<GioHangViewModel>) listGioHang);
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableGiohang;
    private javax.swing.JTable TableHoaDon;
    private javax.swing.JPanel btnHuyDon;
    private javax.swing.JButton btnImei;
    private javax.swing.JButton btnSeach;
    private javax.swing.JPanel btnTaoHoaDon;
    private javax.swing.JPanel btnThanhToan;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbbKhuyenMaiSanPham;
    private javax.swing.JComboBox<String> cbbPhanLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
