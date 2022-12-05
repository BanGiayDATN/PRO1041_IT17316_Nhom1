/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.HoaDonExport;
import com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.MauExportSanPham;
import static com.mycompany.ungdungbanlaptop.infrastructure.exportExcel.SanPhamExportExcel.writeExcel;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel;
import com.mycompany.ungdungbanlaptop.service.CPUService;
import com.mycompany.ungdungbanlaptop.service.ChatLieuService;
import com.mycompany.ungdungbanlaptop.service.HangService;
import com.mycompany.ungdungbanlaptop.service.HeDieuHanhService;
import com.mycompany.ungdungbanlaptop.service.ImeiService;
import com.mycompany.ungdungbanlaptop.service.ManHinhService;
import com.mycompany.ungdungbanlaptop.service.MauService;
import com.mycompany.ungdungbanlaptop.service.RamService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.CPUServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.ChatLieuServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.MauServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HangServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HeDieuHanhServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.ImeiServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.ManHinhServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.RamServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

/**
 *
 * @author Diệm DZ
 */
public class ViewSanPham extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
    private ButtonGroup buttonGroup = new ButtonGroup();

    private CPUService cPUService = new CPUServiceImpl();
    private ChatLieuService chatLieuSevice = new ChatLieuServiceImpl();
    private MauService mauService = new MauServiceImpl();
    private HangService hangService = new HangServiceImpl();
    private HeDieuHanhService dieuHanhService = new HeDieuHanhServiceImpl();
    private ImeiService imeiService = new ImeiServiceImpl();
    private ManHinhService manHinhService = new ManHinhServiceImpl();
    private RamService ramService = new RamServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private int numBerTab;
    private static List<String> listHeDieuHanh = new ArrayList<>();
    private static List<String> listMau = new ArrayList<>();
    private static List<String> listManHinh = new ArrayList<>();
    private static List<String> listCPU = new ArrayList<>();
    private static List<String> listChatLieu = new ArrayList<>();
    private static List<String> listHang = new ArrayList<>();
    private static List<String> listRam = new ArrayList<>();
    private static List<SanPham> listSanPham = new ArrayList<>();

    long count, soTrang, trang = 1;
    private NhanVien nhanVien;
    ;
    /**
     * Creates new form ViewSanPham
     */
    public ViewSanPham(NhanVien nhanVien) {
        initComponents();
        this.nhanVien = nhanVien;
        jTableSanPham.setModel(dtm);
        String[] a = {"STT", "Mã SP", "Tên Sp", "Trọng lượng", "Năm sản xuất", "Số lượng tồn", "Giá nhập", "Giá bán", "Mô tả"};
        dtm.setColumnIdentifiers(a);
        radio();
        rd_ban.setSelected(true);
        loadDataCombobox();
        comBoBoxMau(listMau);
        comBoBoxChatLieu(listChatLieu);
        comBoBoxCPU(listCPU);
        comBoBoxNam();
        comBoBoxGiaBan();
        comBoBoxManHinh(listManHinh);
        comBoBoxHang(listHang);
        comBoBoxRam(listRam);
        comBoBoxHeDieuHanh(listHeDieuHanh);
        showData(listSanPham);
        TableFilterHeader filterHeader = new TableFilterHeader(jTableSanPham, AutoChoices.ENABLED);
        filterHeader.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (nhanVien.getChucVu().getTen().equals("Nhân viên")) {
            jToggleButton1.setVisible(false);
            btn_export.setVisible(false);
            btnImport.setVisible(false);
            jButton1.setVisible(false);
        }
    }

    private void radio() {
        buttonGroup.add(rd_ban);
        buttonGroup.add(rd_khongBan);
    }

    private void loadDataCombobox() {
        clearComBoBox();
        List<CPUViewModel> listCPU = cPUService.getALl();
        List<SanPham> listSanPham = sanPhamService.getAll();
        List<ChatLieu> listChatLieu = chatLieuSevice.getAll();
        List<Hang> listHang = hangService.getList();
        List<Mau> listMau = mauService.getAll();
        List<HeDieuHanh> listHeDieuHanh = dieuHanhService.getList();
        List<Imei> listImei = imeiService.getAll();
        List<ManHinh> listManHinh = manHinhService.getAll();
        List<Ram> listRam = ramService.getList();
        // khoi tao gia tri mac dinh
        this.listHeDieuHanh.add("Mời bạn chọn");
        this.listMau.add("Mời bạn chọn");
        this.listManHinh.add("Mời bạn chọn");
        this.listCPU.add("Mời bạn chọn");
        this.listChatLieu.add("Mời bạn chọn");
        this.listHang.add("Mời bạn chọn");
        this.listRam.add("Mời bạn chọn");
        listSanPham.forEach(a -> {
            this.listSanPham.add(a);
        });
        listHeDieuHanh.forEach(a -> {
            this.listHeDieuHanh.add(a.getMa());
        });
        listMau.forEach(a -> {
            this.listMau.add(a.getTen());
        });
        listManHinh.forEach(a -> {
            this.listManHinh.add(a.getMa());
        });
        listCPU.forEach(a -> {
            this.listCPU.add(a.getTen());
        });
        listChatLieu.forEach(a -> {
            this.listChatLieu.add(a.getTen());
        });
        listHang.forEach(a -> {
            this.listHang.add(a.getTen());
        });
        listRam.forEach(a -> {
            this.listRam.add(a.getTen());
        });
    }

    public static void addHeDieuHanh(HeDieuHanh heDieuHanh) {
        listHeDieuHanh.add(heDieuHanh.getMa());
        comBoBoxHeDieuHanh(listHeDieuHanh);
    }

    public static void editHeDieuHanh(int index, HeDieuHanh heDieuHanh) {
        listHeDieuHanh.set(index, heDieuHanh.getMa());
        comBoBoxHeDieuHanh(listHeDieuHanh);
    }

    public static void addMau(Mau mau) {
        listMau.add(mau.getMa());
        comBoBoxMau(listMau);
    }

    public static void editMau(int index, Mau mau) {
        listMau.set(index, mau.getMa());
        comBoBoxMau(listMau);
    }

    public static void addManHinh(ManHinh manHinh) {
        listManHinh.add(manHinh.getMa());
        comBoBoxManHinh(listManHinh);
    }

    public static void editManHinh(int index, ManHinh manHinh) {
        listManHinh.set(index, manHinh.getMa());
        comBoBoxManHinh(listManHinh);
    }

    public static void addCPU(CPU cpu) {
        listCPU.add(cpu.getMa());
        comBoBoxCPU(listCPU);
    }

    public static void editCPU(int index, CPU cpu) {
        listCPU.set(index, cpu.getMa());
        comBoBoxCPU(listCPU);
    }

    public static void addChatLieu(ChatLieu chatLieu) {
        listChatLieu.add(chatLieu.getMa());
        comBoBoxChatLieu(listChatLieu);
    }

    public static void editChatLieu(int index, ChatLieu chatLieu) {
        listChatLieu.set(index, chatLieu.getMa());
        comBoBoxChatLieu(listChatLieu);
    }

    public static void addhang(Hang hang) {
        listHang.add(hang.getMa());
        comBoBoxHang(listHang);
    }

    public static void editHang(int index, Hang hang) {
        listHang.set(index, hang.getMa());
        comBoBoxHang(listHang);
    }

    public static void addRam(Ram ram) {
        listRam.add(ram.getMa());
        comBoBoxRam(listRam);
    }

    public static void editRam(int index, Ram ram) {
        listRam.set(index, ram.getMa());
        comBoBoxRam(listRam);
    }

    public static void addSanPham(SanPham sanPham) {
        listSanPham.add(sanPham);
        showData(listSanPham);
    }

    public static void editSanPham(int index, SanPham sanPham) {
        listSanPham.set(index, sanPham);
        showData(listSanPham);
    }

    private static void showData(List<SanPham> list) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel = (DefaultTableModel) jTableSanPham.getModel();
        tableModel.setRowCount(0);
        for (SanPham x : list) {
            tableModel.addRow(new Object[]{jTableSanPham.getRowCount() + 1, x.getMa(), x.getTen(),
                x.getTrongLuong(), x.getNamBH(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan(), x.getMoTa()});
        }
    }

    private void comBoBoxNam() {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        List<String> list = new ArrayList<>();
        for (int i = 1950; i <= year; i++) {
            list.add(i + "");
        }
        boxModel = (DefaultComboBoxModel) cbb_namSearch.getModel();
        boxModel.addAll(list);
    }

    private static void comBoBoxMau(List<String> list) {
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        cbbMauSacSearch.removeAllItems();
        boxModelSearch = (DefaultComboBoxModel) cbbMauSacSearch.getModel();
        boxModelSearch.addAll(list);
        cbbMauSacSearch.setSelectedIndex(0);
    }

    private static void comBoBoxCPU(List<String> list) {
        cbbCPUSearch.removeAllItems();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbCPUSearch.getModel();
        boxModelSearch.addAll(list);
        cbbCPUSearch.setSelectedIndex(0);
    }

    private static void comBoBoxChatLieu(List<String> list) {
        cbbChatLieuSearch.removeAllItems();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbChatLieuSearch.getModel();
        boxModelSearch.addAll(list);
        cbbChatLieuSearch.setSelectedIndex(0);
    }

    private static void comBoBoxHang(List<String> list) {
        cbbNhaSanXuatSearch.removeAllItems();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbNhaSanXuatSearch.getModel();
        boxModelSearch.addAll(list);
        cbbNhaSanXuatSearch.setSelectedIndex(0);
    }

    private static void comBoBoxManHinh(List<String> list) {
        cbbManHinhSearch.removeAllItems();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbManHinhSearch.getModel();
        boxModelSearch.addAll(list);
        cbbManHinhSearch.setSelectedIndex(0);
    }

    private static void comBoBoxRam(List<String> list) {
        cbbRamSearch.removeAllItems();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbRamSearch.getModel();
        boxModelSearch.addAll(list);
        cbbRamSearch.setSelectedIndex(0);
    }

    private static void comBoBoxHeDieuHanh(List<String> list) {
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModelSearch = (DefaultComboBoxModel) cbbHeDieuHanhSearch.getModel();
        boxModelSearch.addAll(list);
        cbbHeDieuHanhSearch.setSelectedIndex(0);
    }

    private void comBoBoxGiaBan() {
        List<String> list = new ArrayList<>();
        list.add(" Dưới 100000 ");
        list.add(" Từ 100000 - 200000 ");
        list.add(" Từ 200000 - 300000 ");
        list.add(" Từ 300000 - 400000");
        list.add(" Trên 400000 ");
        boxModel = (DefaultComboBoxModel) cbbGiaBanSearch.getModel();
        boxModel.addAll(list);
    }

    private void clearComBoBox() {
        listCPU.clear();
        listChatLieu.clear();
        listHang.clear();
        listHeDieuHanh.clear();
        listManHinh.clear();
        listMau.clear();
        listRam.clear();
        listSanPham.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        conBan = new javax.swing.JMenuItem();
        KhongBan = new javax.swing.JMenuItem();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        TimKiemSanPham = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSanPhamSearch = new javax.swing.JTextField();
        txtTrongLuongSearch = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSoLuongTonSearch = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbbGiaBanSearch = new javax.swing.JComboBox<>();
        btn_search = new javax.swing.JButton();
        cbb_namSearch = new javax.swing.JComboBox<>();
        cbbMauSacSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbManHinhSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbNhaSanXuatSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbCPUSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbRamSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbHeDieuHanhSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbChatLieuSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        rd_ban = new javax.swing.JRadioButton();
        rd_khongBan = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_lamMoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        btn_export = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("Update SanPham");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        conBan.setText("Không bán");
        conBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conBanActionPerformed(evt);
            }
        });
        jPopupMenu1.add(conBan);

        KhongBan.setText("Còn Bán");
        KhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhongBanActionPerformed(evt);
            }
        });
        jPopupMenu1.add(KhongBan);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quản Lý Sản Phẩm");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        TimKiemSanPham.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tên sản phẩm:");

        jLabel15.setText("Năm sản xuất:");

        jLabel16.setText("Hãng");

        jLabel17.setText("Màu sắc:");

        jLabel18.setText("Trọng lượng:");

        jLabel19.setText("Màn hình:");

        jLabel20.setText("CPU:");

        jLabel21.setText("Ram:");

        jLabel22.setText("Giá bán:");

        jLabel24.setText("Số lượng :");

        jLabel25.setText("Hệ điều hành:");

        jLabel29.setText("Chất liệu:");

        cbbGiaBanSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mời chọn khoảng giá" }));

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Search.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbb_namSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mời bạn chọn" }));

        rd_ban.setText("Đang bán");

        rd_khongBan.setText("Không bán");

        jLabel1.setText("Tình trạng");

        btn_lamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
        btn_lamMoi.setText("Làm mới");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel20)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenSanPhamSearch, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrongLuongSearch, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(cbb_namSearch, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbCPUSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_lamMoi))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbRamSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuongTonSearch)
                        .addComponent(cbbGiaBanSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbHeDieuHanhSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbChatLieuSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(rd_ban)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rd_khongBan)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSanPhamSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(cbbRamSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHeDieuHanhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChatLieuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrongLuongSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_namSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cbbGiaBanSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtSoLuongTonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_ban)
                            .addComponent(rd_khongBan)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(cbbCPUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_search)
                        .addComponent(btn_lamMoi)))
                .addGap(14, 14, 14))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableSanPham.setBackground(new java.awt.Color(204, 255, 204));
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
        jTableSanPham.setComponentPopupMenu(jPopupMenu1);
        jTableSanPham.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSanPham);

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        jToggleButton1.setText("Thêm");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        btn_export.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Download.png"))); // NOI18N
        btn_export.setText("ExportExcel");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        btnImport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Upload.png"))); // NOI18N
        btnImport.setText("Import Excel");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Upload.png"))); // NOI18N
        jButton1.setText("Import Mẫu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_export)
                        .addGap(18, 18, 18)
                        .addComponent(btnImport)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_export, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImport)
                            .addComponent(jButton1)))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TimKiemSanPhamLayout = new javax.swing.GroupLayout(TimKiemSanPham);
        TimKiemSanPham.setLayout(TimKiemSanPhamLayout);
        TimKiemSanPhamLayout.setHorizontalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimKiemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TimKiemSanPhamLayout.setVerticalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", TimKiemSanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        new AddSanPham().setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        int soLuong = 0;
        float trongLuong;
        BigDecimal startGiaBan = new BigDecimal(-1);
        BigDecimal endGiaBan;
        String ktra = "Mời bạn chọn";
        String ten = txtTenSanPhamSearch.getText().trim();
        String tenMau = cbbMauSacSearch.getSelectedItem().toString();
        String tenManHinh = cbbManHinhSearch.getSelectedItem().toString();
        String tenHang = cbbNhaSanXuatSearch.getSelectedItem().toString();
        String tenCPU = cbbCPUSearch.getSelectedItem().toString();
        String tenRam = cbbRamSearch.getSelectedItem().toString();
        String tenHeDieuHanh = cbbHeDieuHanhSearch.getSelectedItem().toString();
        String tenChatLieu = cbbChatLieuSearch.getSelectedItem().toString();
        String soLuongString = txtSoLuongTonSearch.getText().trim();
        String namSXString = cbb_namSearch.getSelectedItem().toString().trim();
        int nam = 0;
        if (namSXString.equalsIgnoreCase(ktra.trim())) {
            nam = 0;
        } else {
            nam = Integer.parseInt(namSXString);
        }
        String trongluongString = txtTrongLuongSearch.getText().trim();
        if (ten.equalsIgnoreCase(ktra.trim())) {
            ten = null;
        }
        if (tenCPU.equalsIgnoreCase(ktra.trim())) {
            tenCPU = null;
        }
        if (tenChatLieu.equalsIgnoreCase(ktra.trim())) {
            tenChatLieu = null;
        }
        if (tenHang.equalsIgnoreCase(ktra.trim())) {
            tenHang = null;
        }
        if (tenHeDieuHanh.equalsIgnoreCase(ktra.trim())) {
            tenHeDieuHanh = null;
        }
        if (tenManHinh.equalsIgnoreCase(ktra.trim())) {
            tenManHinh = null;
        }
        if (tenMau.equalsIgnoreCase(ktra.trim())) {
            tenMau = null;
        }
        if (tenRam.equalsIgnoreCase(ktra.trim())) {
            tenRam = null;
        }
        if (trongluongString.isEmpty()) {
            trongLuong = 0;
        } else {
            trongLuong = Float.parseFloat(trongluongString);
        }
        if (soLuongString.isEmpty()) {
            soLuong = 0;
        } else {
            soLuong = Integer.parseInt(soLuongString);
        }
        int indexGiaBan = cbbGiaBanSearch.getSelectedIndex();
        if (indexGiaBan == 0) {
            endGiaBan = null;
        } else if (indexGiaBan == 1) {
            startGiaBan = new BigDecimal(0);
            endGiaBan = new BigDecimal(10000000);
        } else if (indexGiaBan == 2) {
            startGiaBan = new BigDecimal(10000000);
            endGiaBan = new BigDecimal(20000000);
        } else if (indexGiaBan == 3) {
            startGiaBan = new BigDecimal(20000000);
            endGiaBan = new BigDecimal(30000000);
        } else if (indexGiaBan == 4) {
            startGiaBan = new BigDecimal(30000000);
            endGiaBan = new BigDecimal(40000000);
        } else {
            startGiaBan = new BigDecimal(40000000);
            endGiaBan = new BigDecimal(900000000);
        }
        int trangThai = 0;
        if (rd_ban.isSelected()) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        SanPhamSearchRequest request = new SanPhamSearchRequest(ten, tenManHinh, tenCPU, tenMau, tenHeDieuHanh, tenRam,
                tenChatLieu, tenHang, nam, trongLuong, soLuong, startGiaBan, endGiaBan, trangThai);
        List<SanPham> listSearch = sanPhamService.searchFill(request);
        showData(listSearch);

    }//GEN-LAST:event_btn_searchActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int row = jTableSanPham.getSelectedRow();
        SanPham sanPham = sanPhamService.getAll().get(row);
        new UpdateSanPham(row, sanPham).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void conBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conBanActionPerformed
        // TODO add your handling code here:
        int row = jTableSanPham.getSelectedRow();
        SanPham sanPham = sanPhamService.getAllByTrangThai(0).get(row);
        SanPham sp = sanPhamService.updateTrangThai(sanPham, 1);
        showData(sanPhamService.getAllByTrangThai(0));
    }//GEN-LAST:event_conBanActionPerformed

    private void KhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhongBanActionPerformed
        // TODO add your handling code here:
        int row = jTableSanPham.getSelectedRow();
        SanPham sanPham = sanPhamService.getAllByTrangThai(1).get(row);
        System.out.println(sanPham);
        SanPham sp = sanPhamService.updateTrangThai(sanPham, 0);
        showData(sanPhamService.getAllByTrangThai(1));
    }//GEN-LAST:event_KhongBanActionPerformed

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        // TODO add your handling code here:
        String loaiFile = ".xlsx";
        try {
            writeExcel(sanPhamService.getAll(), loaiFile);
            JOptionPane.showMessageDialog(this, "Export thành công ");
        } catch (IOException ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Export thất bại ");
        }
    }//GEN-LAST:event_btn_exportActionPerformed

    private void jTableSanPhamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseMoved
        if (nhanVien.getChucVu().getTen().equals("Nhân viên")) {
            jTableSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_jTableSanPhamMouseMoved

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            JOptionPane.showMessageDialog(this, sanPhamService.SanPhamImport(new File(filename)));
        } catch (Exception ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Import thất bại ");
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            MauExportSanPham.exportData(filename + ".xlsx");
        } catch (Exception ex) {
            Logger.getLogger(ViewSanPham.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Import thất bại ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem KhongBan;
    private javax.swing.JPanel TimKiemSanPham;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_search;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbCPUSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbChatLieuSearch;
    private static javax.swing.JComboBox<String> cbbGiaBanSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbHeDieuHanhSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbManHinhSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbMauSacSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbNhaSanXuatSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbRamSearch;
    private static javax.swing.JComboBox<String> cbb_namSearch;
    private javax.swing.JMenuItem conBan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTable jTableSanPham;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton rd_ban;
    private javax.swing.JRadioButton rd_khongBan;
    private static javax.swing.JTextField txtSoLuongTonSearch;
    private javax.swing.JTextField txtTenSanPhamSearch;
    private javax.swing.JTextField txtTrongLuongSearch;
    // End of variables declaration//GEN-END:variables
}
