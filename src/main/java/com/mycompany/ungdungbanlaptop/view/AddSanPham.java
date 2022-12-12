/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import com.mycompany.ungdungbanlaptop.service.impl.HangServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.HeDieuHanhServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.ImeiServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.ManHinhServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.MauServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.RamServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author vinhnv
 */
public class AddSanPham extends javax.swing.JFrame {

    /**
     * Creates new form AddSanPham
     */
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

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

    public AddSanPham() {
        initComponents();
        this.setIconImage(new ImageIcon(new File("").getAbsolutePath() + "//src//main//resources//img//icon.jpg").getImage());
        txtMaSanPham.setEditable(false);
        loadDataCombobox();
        comBoBoxMau(listMau);
        comBoBoxChatLieu(listChatLieu);
        comBoBoxCPU(listCPU);
        comBoBoxNam();
        comBoBoxManHinh(listManHinh);
        comBoBoxHang(listHang);
        comBoBoxRam(listRam);
        comBoBoxHeDieuHanh(listHeDieuHanh);
    }

    private void loadDataCombobox() {
        clearComBoBox();
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
            this.listHeDieuHanh.add(a.getTen());
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

    private void comBoBoxNam() {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        List<Integer> list = new ArrayList<>();
        for (int i = 1950; i <= year; i++) {
            list.add(i);
        }
        boxModel = (DefaultComboBoxModel) cbb_nam.getModel();
        boxModel.addAll(list);
    }

    private static void comBoBoxMau(List<String> list) {
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        cbbMauSac.removeAllItems();
        boxModel = (DefaultComboBoxModel) cbbMauSac.getModel();
        boxModel.addAll(list);
        cbbMauSac.setSelectedIndex(0);
    }

    private static void comBoBoxCPU(List<String> list) {
        cbbCPU.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbCPU.getModel();
        boxModel.addAll(list);
        cbbCPU.setSelectedIndex(0);
    }

    private static void comBoBoxChatLieu(List<String> list) {
        cbbChatLieu.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbChatLieu.getModel();
        boxModel.addAll(list);
        cbbChatLieu.setSelectedIndex(0);
    }

    private static void comBoBoxHang(List<String> list) {
        cbbNhaSanXuat.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbNhaSanXuat.getModel();
        boxModel.addAll(list);
        cbbNhaSanXuat.setSelectedIndex(0);
    }

    private static void comBoBoxManHinh(List<String> list) {
        cbbManHinh.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbManHinh.getModel();
        boxModel.addAll(list);
        cbbManHinh.setSelectedIndex(0);
    }

    private static void comBoBoxRam(List<String> list) {
        cbbRam.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbRam.getModel();
        boxModel.addAll(list);
        cbbRam.setSelectedIndex(0);
    }

    private static void comBoBoxHeDieuHanh(List<String> list) {
        cbbHeDieuHanh.removeAllItems();
        DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
        boxModel = (DefaultComboBoxModel) cbbHeDieuHanh.getModel();
        boxModel.addAll(list);
        cbbHeDieuHanh.setSelectedIndex(0);
    }

    private void clearComBoBox() {

        listCPU.clear();
        listChatLieu.clear();
        listHang.clear();
        listHeDieuHanh.clear();
        listManHinh.clear();
        listMau.clear();
        listRam.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        cbb_nam = new javax.swing.JComboBox<>();
        lab_errorRam = new javax.swing.JLabel();
        lab_errorCPU = new javax.swing.JLabel();
        lab_errorHang = new javax.swing.JLabel();
        lab_errorManHinh = new javax.swing.JLabel();
        lab_errorMau = new javax.swing.JLabel();
        lab_errorTrongLuong = new javax.swing.JLabel();
        lab_errorNam = new javax.swing.JLabel();
        lab_errorTen = new javax.swing.JLabel();
        lab_errorMa = new javax.swing.JLabel();
        lab_errorRam9 = new javax.swing.JLabel();
        lab_errorHeDieuHanh = new javax.swing.JLabel();
        lab_errorSoLuong = new javax.swing.JLabel();
        lab_errorChatLieu = new javax.swing.JLabel();
        lab_errorGiaBan = new javax.swing.JLabel();
        lab_errorGiaNhap = new javax.swing.JLabel();
        lab_errorMoTa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Refresh.png"))); // NOI18N
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
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel39.setText("Mô tả:");

        jLabel40.setText("Chất liệu:");

        jLabel41.setText("Imei:");

        jScrollPane3.setViewportView(txtMoTa);

        btnManHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManHinhActionPerformed(evt);
            }
        });

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangActionPerformed(evt);
            }
        });

        btnCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });

        btnRam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });

        btnHeDieuHanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnHeDieuHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeDieuHanhActionPerformed(evt);
            }
        });

        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnImei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Create.png"))); // NOI18N
        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
            }
        });

        cbb_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mời bạn chọn" }));

        lab_errorRam.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorCPU.setForeground(new java.awt.Color(204, 0, 0));

        lab_errorHang.setForeground(new java.awt.Color(204, 0, 0));

        lab_errorManHinh.setForeground(new java.awt.Color(204, 0, 0));

        lab_errorMau.setForeground(new java.awt.Color(204, 0, 0));

        lab_errorTrongLuong.setForeground(new java.awt.Color(204, 0, 0));

        lab_errorNam.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorTen.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorMa.setForeground(new java.awt.Color(255, 0, 51));

        lab_errorRam9.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorHeDieuHanh.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorSoLuong.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorChatLieu.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorGiaBan.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorGiaNhap.setForeground(new java.awt.Color(255, 0, 0));

        lab_errorMoTa.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCPU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbRam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lab_errorCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab_errorHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lab_errorRam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab_errorManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(131, 131, 131)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lab_errorNam, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lab_errorMa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lab_errorTen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lab_errorTrongLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lab_errorMau, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel37)
                        .addComponent(jLabel40)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)
                            .addComponent(jLabel39))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(76, 76, 76)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(btnCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lab_errorSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(lab_errorHeDieuHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbImai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuongTon)
                            .addComponent(lab_errorChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_errorGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaBan))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lab_errorMoTa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lab_errorGiaNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiaNHap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(lab_errorRam9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorMa, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaNHap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lab_errorTen, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_errorNam, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChatLieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab_errorChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab_errorSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31))))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lab_errorTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lab_errorHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30)))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbImai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lab_errorRam9, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lab_errorMau, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel32))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lab_errorManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)))
                        .addGap(10, 10, 10)
                        .addComponent(lab_errorHang, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33))
                            .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))
                            .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_errorRam, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String checkComBoBox = "Mời bạn chọn";
        String tenSP = txtTenSanPham.getText().trim();
        String trongLuongString = txtTrongLuong.getText().toString().trim();
        String soLuongString = txtSoLuongTon.getText().trim();
        String ram = cbbRam.getSelectedItem().toString().trim();
        String moTa = txtMoTa.getText().trim();
        String manHinh = cbbManHinh.getSelectedItem().toString().trim();
        String mauSac = cbbMauSac.getSelectedItem().toString().trim();
        String heDieuHanh = cbbHeDieuHanh.getSelectedItem().toString().trim();
        String nhaSX = cbbNhaSanXuat.getSelectedItem().toString().trim();
        String giaBan = txtGiaBan.getText().trim();
        String giaNhap = txtGiaNHap.getText().trim();
        String cpu = cbbCPU.getSelectedItem().toString().trim();
        String chatLieu = cbbChatLieu.getSelectedItem().toString().trim();
        String namString = cbb_nam.getSelectedItem().toString();

        // vali
        if (namString.equalsIgnoreCase(checkComBoBox)) {
            lab_errorNam.setText("Vui lòng chọn");
            return;
        } else {
            lab_errorNam.setText("");
        }

        if (tenSP.isEmpty()) {
            lab_errorTen.setText("Không để trống");
        } else {
            lab_errorTen.setText("");
        }
        
        if (moTa.isEmpty()) {
            lab_errorMoTa.setText("Không để trống");
        } else {
            lab_errorMoTa.setText("");
        }


        if (ram.equalsIgnoreCase(checkComBoBox)) {
            lab_errorRam.setText("Vui lòng chọn");
        } else {
            lab_errorRam.setText("");
        }

        if (manHinh.equalsIgnoreCase(checkComBoBox)) {
            lab_errorManHinh.setText("Vui lòng chọn");
        } else {
            lab_errorManHinh.setText("");
        }

        if (mauSac.equalsIgnoreCase(checkComBoBox)) {
            lab_errorMau.setText("Vui lòng chọn");
        } else {
            lab_errorMau.setText("");
        }

        if (heDieuHanh.equalsIgnoreCase(checkComBoBox)) {
            lab_errorHeDieuHanh.setText("Vui lòng chọn");
        } else {
            lab_errorHeDieuHanh.setText("");
        }

        if (nhaSX.equalsIgnoreCase(checkComBoBox)) {
            lab_errorHang.setText("Vui lòng chọn");
        } else {
            lab_errorHang.setText("");
        }

        if (cpu.equalsIgnoreCase(checkComBoBox)) {
            lab_errorCPU.setText("Vui lòng chọn");
        } else {
            lab_errorCPU.setText("");
        }

        if (chatLieu.equalsIgnoreCase(checkComBoBox)) {
            lab_errorChatLieu.setText("Vui lòng chọn");
        } else {
            lab_errorChatLieu.setText("");
        }

        if (trongLuongString.isEmpty()) {
            lab_errorTrongLuong.setText("Không để trống");
            return;
        } else if (!NumberUtils.isNumber(trongLuongString)) {
            lab_errorTrongLuong.setText("Phải là số ");
            return;
        } else {
            lab_errorTrongLuong.setText(" ");
        }

        if (soLuongString.isEmpty()) {
            lab_errorSoLuong.setText("Không để trống");
            return;
        } else if (!NumberUtils.isNumber(soLuongString)) {
            lab_errorSoLuong.setText("Phải là số ");
            return;
        } else {
            lab_errorSoLuong.setText(" ");
        }

        if (giaBan.isEmpty()) {
            lab_errorGiaBan.setText("Không để trống");
            return;
        } else if (!NumberUtils.isNumber(giaBan)) {
            lab_errorGiaBan.setText("Phải là số ");
            return;
        } else {
            lab_errorGiaBan.setText(" ");
        }

        if (giaNhap.isEmpty()) {
            lab_errorGiaNhap.setText("Không để trống");
            return;
        } else if (!NumberUtils.isNumber(giaBan)) {
            lab_errorGiaNhap.setText("Phải là số ");
            return;
        } else {
            lab_errorGiaNhap.setText(" ");
        }
        if (new BigDecimal(giaBan).compareTo(new BigDecimal(giaNhap)) < 1) {
            lab_errorGiaBan.setText("Giá bán < giá nhập");
            return;
        }

        SanPham sanPham = new SanPham();
        sanPham.setMa(new TaoChuoiNgauNhien().getMaSanPham("SP", 4));
        sanPham.setTen(tenSP);
        sanPham.setNamBH((int) cbb_nam.getSelectedItem());
        sanPham.setGiaBan(new BigDecimal(giaBan));
        sanPham.setGiaNhap(new BigDecimal(giaNhap));
        sanPham.setChatLieu(chatLieuSevice.getByTen(chatLieu));
        sanPham.setCpu(cPUService.getByTen(cpu));
        sanPham.setHang(hangService.getByTen(nhaSX));
        sanPham.setHeDieuHanh(dieuHanhService.getByTen(heDieuHanh));
        sanPham.setManHinh(manHinhService.getOne(manHinh));
        sanPham.setMoTa(moTa);
        sanPham.setRam(ramService.getByTen(ram));
        sanPham.setSoLuongTon(Integer.valueOf(soLuongString));
        sanPham.setTen(tenSP);
        sanPham.setTrongLuong(Float.valueOf(trongLuongString));
        sanPham.setMau(mauService.getByTen(mauSac));
        sanPham.setTrangThai(0);
       boolean ktra = sanPhamService.add(sanPham);
        if (ktra) {
            JOptionPane.showMessageDialog(this, " Thêm thành công");
            ViewSanPham.addSanPham(sanPham);
            this.dispose();
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManHinhActionPerformed
        new ViewchucNang(new AdQuanLiManHinh()).setVisible(true);
    }//GEN-LAST:event_btnManHinhActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMauSacActionPerformed

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(AddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnHang;
    private javax.swing.JButton btnHeDieuHanh;
    private javax.swing.JButton btnImei;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnManHinh;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnThem;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbCPU;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbChatLieu;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbHeDieuHanh;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbImai;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbManHinh;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbMauSac;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbNhaSanXuat;
    private static com.mycompany.ungdungbanlaptop.cboCustom.AutoComboBox cbbRam;
    private static javax.swing.JComboBox<String> cbb_nam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lab_errorCPU;
    private javax.swing.JLabel lab_errorChatLieu;
    private javax.swing.JLabel lab_errorGiaBan;
    private javax.swing.JLabel lab_errorGiaNhap;
    private javax.swing.JLabel lab_errorHang;
    private javax.swing.JLabel lab_errorHeDieuHanh;
    private javax.swing.JLabel lab_errorMa;
    private javax.swing.JLabel lab_errorManHinh;
    private javax.swing.JLabel lab_errorMau;
    private javax.swing.JLabel lab_errorMoTa;
    private javax.swing.JLabel lab_errorNam;
    private javax.swing.JLabel lab_errorRam;
    private javax.swing.JLabel lab_errorRam9;
    private javax.swing.JLabel lab_errorSoLuong;
    private javax.swing.JLabel lab_errorTen;
    private javax.swing.JLabel lab_errorTrongLuong;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNHap;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTrongLuong;
    // End of variables declaration//GEN-END:variables
}
