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
import java.time.LocalDate;
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
    private static List<SanPham> listSanPham = new ArrayList<>();

    long count, soTrang, trang = 1;

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
        showData(listSanPham);

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
        List<Integer> list = new ArrayList<>();
        for (int i = 1950; i <= year; i++) {
            list.add(i);
        }
        boxModel = (DefaultComboBoxModel) cbb_namSearch.getModel();
        boxModel.addAll(list);
        boxModel.setSelectedItem(0);
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        cbb_namSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));

        jToggleButton1.setText("Thêm");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

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
                        .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbCPUSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(134, 134, 134)
                                .addComponent(btn_search)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(cbb_namSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(54, 54, 54))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTenSanPhamSearch)
                                                    .addComponent(txtTrongLuongSearch)
                                                    .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addGap(84, 84, 84)
                                        .addComponent(jLabel22)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbRamSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongTonSearch)
                                    .addComponent(cbbGiaBanSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbHeDieuHanhSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbChatLieuSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(25, 25, 25))))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_search)
                            .addComponent(jToggleButton1))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cbbCPUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
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

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(56, 56, 56))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout TimKiemSanPhamLayout = new javax.swing.GroupLayout(TimKiemSanPham);
        TimKiemSanPham.setLayout(TimKiemSanPhamLayout);
        TimKiemSanPhamLayout.setHorizontalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addGroup(TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
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

        int row = jTableSanPham.getSelectedRow();
        SanPham sp = sanPhamService.getAll().get(row);
        new UpdateSanPham(row, sp).setVisible(true);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

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
        int namSX = (int) cbb_namSearch.getSelectedItem();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TimKiemSanPham;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTable jTableSanPham;
    private javax.swing.JToggleButton jToggleButton1;
    private static javax.swing.JTextField txtSoLuongTonSearch;
    private javax.swing.JTextField txtTenSanPhamSearch;
    private javax.swing.JTextField txtTrongLuongSearch;
    // End of variables declaration//GEN-END:variables
}
