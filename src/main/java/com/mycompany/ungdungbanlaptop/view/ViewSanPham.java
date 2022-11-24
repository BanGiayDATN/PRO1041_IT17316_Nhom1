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
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diệm DZ
 */
public class ViewSanPham extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();

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

    ;
    /**
     * Creates new form ViewSanPham
     */
    public ViewSanPham() {
        initComponents();
        jTableSanPham.setModel(dtm);
        String[] a = {"STT", "Mã SP", "Tên Sp", "Trọng lượng", "Năm sản xuất", "Số lượng tồn", "Giá nhập", "Giá bán", "Mô tả"};
        dtm.setColumnIdentifiers(a);
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
        showData(sanPhamService.getAll());

    }

    private void loadDataCombobox() {
        List<CPUViewModel> listCPU = cPUService.getALl();
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

    private void showData(List<SanPham> list) {
        dtm.setRowCount(0);
        for (SanPham x : list) {
            dtm.addRow(new Object[]{jTableSanPham.getRowCount() + 1, x.getMa(), x.getTen(), x.getTrongLuong(), x.getNamBH(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan(), x.getMoTa()});
        }
    }

    private void comBoBoxNam() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1950; i < 2030; i++) {
            list.add(i);
        }
        boxModel = (DefaultComboBoxModel) cbb_nam.getModel();
        boxModel.addAll(list);
        boxModel.setSelectedItem(0);
    }

    private static void comBoBoxMau(List<String> list) {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        cbbMauSac.removeAllItems();
        cbbMauSacSearch.removeAllItems();
        boxModel = (DefaultComboBoxModel) cbbMauSac.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbMauSacSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbMauSac.setSelectedIndex(0);
        cbbMauSacSearch.setSelectedIndex(0);
    }

    private static void comBoBoxCPU(List<String> list) {
        cbbCPU.removeAllItems();
        cbbCPUSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbCPU.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbCPUSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbCPU.setSelectedIndex(0);
        cbbCPUSearch.setSelectedIndex(0);
    }

    private static void comBoBoxChatLieu(List<String> list) {
        cbbChatLieu.removeAllItems();
        cbbChatLieuSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbChatLieu.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbChatLieuSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbChatLieu.setSelectedIndex(0);
        cbbChatLieuSearch.setSelectedIndex(0);
    }

    private static void comBoBoxHang(List<String> list) {
        cbbNhaSanXuat.removeAllItems();
        cbbNhaSanXuatSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbNhaSanXuat.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbNhaSanXuatSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbNhaSanXuat.setSelectedIndex(0);
        cbbNhaSanXuatSearch.setSelectedIndex(0);
    }

    private static void comBoBoxManHinh(List<String> list) {
        cbbManHinh.removeAllItems();
        cbbManHinhSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbManHinh.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbManHinhSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbManHinh.setSelectedIndex(0);
        cbbManHinhSearch.setSelectedIndex(0);
    }

    private static void comBoBoxRam(List<String> list) {
        cbbRam.removeAllItems();
        cbbRamSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbRam.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbRamSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbRam.setSelectedIndex(0);
        cbbRamSearch.setSelectedIndex(0);
    }

    private static void comBoBoxHeDieuHanh(List<String> list) {
        cbbHeDieuHanh.removeAllItems();
        cbbHeDieuHanhSearch.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel boxModelSearch = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbHeDieuHanh.getModel();
        boxModelSearch = (DefaultComboBoxModel) cbbHeDieuHanhSearch.getModel();
        boxModel.addAll(list);
        boxModelSearch.addAll(list);
        cbbHeDieuHanh.setSelectedIndex(0);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cbb_nam = new javax.swing.JComboBox<>();
        cbbMauSacSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbManHinhSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbNhaSanXuatSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbCPUSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbRamSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbHeDieuHanhSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbChatLieuSearch = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        QanLiSanPham = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNamBaoHanh = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        txtTrongLuong = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtGiaNHap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextPane();
        btnManHinh = new javax.swing.JButton();
        btnMauSac = new javax.swing.JButton();
        btnHang = new javax.swing.JButton();
        btnCPU = new javax.swing.JButton();
        btnRam = new javax.swing.JButton();
        btnHeDieuHanh = new javax.swing.JButton();
        btnChatLieu = new javax.swing.JButton();
        btnImei = new javax.swing.JButton();
        cbbMauSac = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbManHinh = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbNhaSanXuat = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbCPU = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbRam = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbHeDieuHanh = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbChatLieu = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();
        cbbImai = new com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quản Lý Sản Phẩm");

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

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbb_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));

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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbb_nam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(54, 54, 54))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTenSanPhamSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(txtTrongLuongSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel22))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbCPUSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(127, 127, 127)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbRamSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongTonSearch)
                                    .addComponent(cbbGiaBanSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbHeDieuHanhSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbChatLieuSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                            .addComponent(cbb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btn_search)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbbCPUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane2.setViewportView(jTableSanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout TimKiemSanPhamLayout = new javax.swing.GroupLayout(TimKiemSanPham);
        TimKiemSanPham.setLayout(TimKiemSanPhamLayout);
        TimKiemSanPhamLayout.setHorizontalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TimKiemSanPhamLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );
        TimKiemSanPhamLayout.setVerticalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tìm kiếm sản phẩm", TimKiemSanPham);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Mã sản phẩm:");

        jLabel3.setText("Tên sản phẩm:");

        jLabel27.setText("Năm sản xuất:");

        jLabel28.setText("Hãng");

        jLabel30.setText("Màu sắc:");

        jLabel31.setText("Trọng lượng:");

        jLabel32.setText("Màn hình:");

        jLabel33.setText("CPU:");

        jLabel34.setText("Ram:");

        jLabel35.setText("Giá bán:");

        jLabel36.setText("Giá nhập:");

        jLabel37.setText("Số lượng tồn:");

        jLabel38.setText("Hệ điều hành:");

        jPanel6.setBorder(new javax.swing.border.MatteBorder(null));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel39.setText("Mô tả:");

        jLabel40.setText("Chất liệu:");

        jLabel41.setText("Imei:");

        jScrollPane3.setViewportView(txtMoTa);

        btnManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManHinhActionPerformed(evt);
            }
        });

        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });

        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });

        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });

        btnHeDieuHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeDieuHanhActionPerformed(evt);
            }
        });

        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addComponent(jLabel27)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(txtMaSanPham)
                                .addComponent(txtNamBaoHanh))
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cbbRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbCPU, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbManHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel40)
                    .addComponent(jLabel35)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41)
                    .addComponent(jLabel39)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaNHap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbImai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtGiaNHap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel35))
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37))
                            .addComponent(txtNamBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbImai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(btnHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel33)
                                        .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbbCPU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout QanLiSanPhamLayout = new javax.swing.GroupLayout(QanLiSanPham);
        QanLiSanPham.setLayout(QanLiSanPhamLayout);
        QanLiSanPhamLayout.setHorizontalGroup(
            QanLiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QanLiSanPhamLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        QanLiSanPhamLayout.setVerticalGroup(
            QanLiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QanLiSanPhamLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lí sản phẩm", QanLiSanPham);

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
                .addContainerGap(49, Short.MAX_VALUE))
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

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:

        jTabbedPane1.setSelectedIndex(1);
        int row = jTableSanPham.getSelectedRow();
        SanPham sp = sanPhamService.getAll().get(row);
        txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
        txtGiaNHap.setText(String.valueOf(sp.getGiaNhap()));
        txtMaSanPham.setText(sp.getMa());
        txtMoTa.setText(sp.getMoTa());
        txtNamBaoHanh.setText(String.valueOf(sp.getNamBH()));
        txtSoLuongTon.setText(String.valueOf(sp.getSoLuongTon()));
        txtTenSanPham.setText(sp.getTen());
        txtTrongLuong.setText(String.valueOf(sp.getTrongLuong()));
        cbbCPU.setSelectedItem(sp.getCpu().getTen());
        cbbChatLieu.setSelectedItem(sp.getChatLieu().getTen());

        cbbHeDieuHanh.setSelectedItem(sp.getHeDieuHanh().getTen());
        cbbMauSac.setSelectedItem(sp.getMau().getTen());// chua cos du lieu

        //        cbbImai.setSelectedItem(sanPhamService.getOne(jTableSanPham.getValueAt(row, 1).toString()).getImei().getMa()); // chua cos du lieu
        cbbManHinh.setSelectedItem(sp.getManHinh().getMa());
        cbbNhaSanXuat.setSelectedItem(sp.getHang().getTen());
        cbbRam.setSelectedItem(sp.getRam().getTen());

    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();

        sanPham.setChatLieu(new ChatLieu(chatLieuSevice.getByTen(cbbChatLieu.getSelectedItem().toString()).getIdChatLieu()));
        sanPham.setCpu(new CPU(cPUService.getByTen(cbbCPU.getSelectedItem().toString()).getIdCPU()));
        sanPham.setGiaBan(BigDecimal.valueOf(Double.valueOf(txtGiaBan.getText())));
        sanPham.setGiaNhap(BigDecimal.valueOf(Double.valueOf(txtGiaNHap.getText())));
        sanPham.setMau(new Mau(mauService.getByTen(cbbMauSac.getSelectedItem().toString()).getIdMau()));
        sanPham.setHang(new Hang(hangService.getByTen(cbbNhaSanXuat.getSelectedItem().toString()).getIdHang()));
        sanPham.setHeDieuHanh(new HeDieuHanh(dieuHanhService.getByTen(cbbHeDieuHanh.getSelectedItem().toString()).getIdHeDieuHanh()));
        //        sanPham.setImei(new Imei(imeiService.getOne(cbbImai.getSelectedItem().toString()).getIdImei()));

        sanPham.setMa(new TaoChuoiNgauNhien().getMaSanPham("SP", 3));
        sanPham.setManHinh(new ManHinh(manHinhService.getOne(cbbManHinh.getSelectedItem().toString()).getIdManHinh()));
        sanPham.setMoTa(txtMoTa.getText());
        sanPham.setNamBH(Integer.valueOf(txtNamBaoHanh.getText()));
        sanPham.setRam(new Ram(ramService.getByTen(cbbRam.getSelectedItem().toString()).getIdRam()));
        sanPham.setSoLuongTon(Integer.valueOf(txtSoLuongTon.getText()));
        sanPham.setTen(txtTenSanPham.getText());
        sanPham.setTrongLuong(Float.valueOf(txtTrongLuong.getText()));
        sanPham.setMau(new Mau(mauService.getByTen(cbbMauSac.getSelectedItem().toString()).getIdMau()));
        sanPham.setImei(null);
        JOptionPane.showMessageDialog(this, sanPhamService.add(sanPham));
        showData(sanPhamService.getAll());
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();
        sanPham.setChatLieu(new ChatLieu(chatLieuSevice.getByTen(cbbChatLieu.getSelectedItem().toString()).getIdChatLieu()));
        sanPham.setCpu(new CPU(cPUService.getByTen(cbbCPU.getSelectedItem().toString()).getIdCPU()));
        sanPham.setGiaBan(BigDecimal.valueOf(Double.valueOf(txtGiaBan.getText())));
        sanPham.setGiaNhap(BigDecimal.valueOf(Double.valueOf(txtGiaNHap.getText())));
        sanPham.setMau(new Mau(mauService.getByTen(cbbMauSac.getSelectedItem().toString()).getIdMau()));
        sanPham.setHang(new Hang(hangService.getByTen(cbbNhaSanXuat.getSelectedItem().toString()).getIdHang()));
        sanPham.setHeDieuHanh(new HeDieuHanh(dieuHanhService.getByTen(cbbHeDieuHanh.getSelectedItem().toString()).getIdHeDieuHanh()));
        //        sanPham.setImei(new Imei(imeiService.getOne(cbbImai.getSelectedItem().toString()).getIdImei()));
        sanPham.setMa(txtMaSanPham.getText());
        sanPham.setManHinh(new ManHinh(manHinhService.getOne(cbbManHinh.getSelectedItem().toString()).getIdManHinh()));
        sanPham.setMoTa(txtMoTa.getText());
        sanPham.setNamBH(Integer.valueOf(txtNamBaoHanh.getText()));
        sanPham.setRam(new Ram(ramService.getByTen(cbbRam.getSelectedItem().toString()).getIdRam()));
        sanPham.setSoLuongTon(Integer.valueOf(txtSoLuongTon.getText()));
        sanPham.setTen(txtTenSanPham.getText());
        sanPham.setTrongLuong(Float.valueOf(txtTrongLuong.getText()));

        int row = jTableSanPham.getSelectedRow();
        sanPham.setIdSanPham(sanPhamService.getOne(jTableSanPham.getValueAt(row, 1).toString()).getIdSanPham());
        JOptionPane.showMessageDialog(this, sanPhamService.update(sanPham));
        showData(sanPhamService.getAll());
        jTabbedPane1.setSelectedIndex(0);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManHinhActionPerformed
        new ViewchucNang(new AdQuanLiManHinh()).setVisible(true);
    }//GEN-LAST:event_btnManHinhActionPerformed

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
        String soLuongString = txtSoLuongTon.getText().trim();
        int namSX = (int) cbb_nam.getSelectedItem();
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
            endGiaBan = new BigDecimal(100000);
        } else if (indexGiaBan == 2) {
            startGiaBan = new BigDecimal(100000);
            endGiaBan = new BigDecimal(200000);
        } else if (indexGiaBan == 3) {
            startGiaBan = new BigDecimal(200000);
            endGiaBan = new BigDecimal(300000);
        } else if (indexGiaBan == 4) {
            startGiaBan = new BigDecimal(300000);
            endGiaBan = new BigDecimal(400000);
        } else {
            startGiaBan = new BigDecimal(400000);
            endGiaBan = new BigDecimal(500000000);
        }
        SanPhamSearchRequest request = new SanPhamSearchRequest(ten, tenManHinh, tenCPU, tenMau, tenHeDieuHanh, tenRam, tenChatLieu, tenHang, namSX, trongLuong, soLuong, startGiaBan, endGiaBan);
        List<SanPham> listSearch = sanPhamService.searchFill(request);
        showData(listSearch);


    }//GEN-LAST:event_btn_searchActionPerformed

    private void btnHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangActionPerformed
        new ViewchucNang(new AdQuanLiHang()).setVisible(true);
    }//GEN-LAST:event_btnHangActionPerformed

    private void btnCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPUActionPerformed
        new ViewchucNang(new CPUview()).setVisible(true);
    }//GEN-LAST:event_btnCPUActionPerformed

    private void btnRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRamActionPerformed
        new ViewchucNang(new AdQuanLiRam()).setVisible(true);
    }//GEN-LAST:event_btnRamActionPerformed

    private void btnHeDieuHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeDieuHanhActionPerformed
        new ViewchucNang(new AdQuanLiVersionHeDieuHanh()).setVisible(true);
    }//GEN-LAST:event_btnHeDieuHanhActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        new ViewchucNang(new ChatLieuView()).setVisible(true);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImeiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QanLiSanPham;
    private javax.swing.JPanel TimKiemSanPham;
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnHeDieuHanh;
    private javax.swing.JButton btnImei;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnManHinh;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btn_search;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbCPU;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbCPUSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbChatLieu;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbChatLieuSearch;
    private static javax.swing.JComboBox<String> cbbGiaBanSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbHeDieuHanh;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbHeDieuHanhSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbImai;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbManHinh;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbManHinhSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbMauSac;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbMauSacSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbNhaSanXuat;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbNhaSanXuatSearch;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbRam;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbRamSearch;
    private static javax.swing.JComboBox<String> cbb_nam;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNHap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtNamBaoHanh;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtSoLuongTonSearch;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenSanPhamSearch;
    private javax.swing.JTextField txtTrongLuong;
    private javax.swing.JTextField txtTrongLuongSearch;
    // End of variables declaration//GEN-END:variables
}
