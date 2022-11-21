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
    private DefaultComboBoxModel dcm1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm3 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm4 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm5 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm6 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm7 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm8 = new DefaultComboBoxModel();
    private DefaultComboBoxModel dcm9 = new DefaultComboBoxModel();

    private CPUService cPUService = new CPUServiceImpl();
    private ChatLieuService chatLieuSevice = new ChatLieuServiceImpl();
    private MauService mauService = new MauServiceImpl();
    private HangService hangService = new HangServiceImpl();
    private HeDieuHanhService dieuHanhService = new HeDieuHanhServiceImpl();
    private ImeiService imeiService = new ImeiServiceImpl();
    private ManHinhService manHinhService = new ManHinhServiceImpl();
    private RamService ramService = new RamServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private List<CPUViewModel> listCPU = cPUService.getALl();
    private List<ChatLieu> listChatLieu = chatLieuSevice.getAll();
    private List<Hang> listHang = hangService.getList();
    private List<Mau> listMau = mauService.getAll();
    private List<HeDieuHanh> listHeDieuHanh = dieuHanhService.getList();
    private List<Imei> listImei = imeiService.getAll();
    private List<ManHinh> listManHinh = manHinhService.getAll();
    private List<Ram> listRam = ramService.getList();
    private int numBerTab;

    /**
     * Creates new form ViewSanPham
     */
    public ViewSanPham() {
        initComponents();
        jTableSanPham.setModel(dtm);
        String[] a = {"STT", "Mã SP", "Tên Sp", "Trọng lượng", "Năm sản xuất", "Số lượng tồn", "Giá nhập", "Giá bán", "Mô tả"};
        dtm.setColumnIdentifiers(a);
        cbbMauSac.setModel(dcm1);
        cbbMauSacSearch.setModel(dcm1);
        for (Mau x : listMau) {
            dcm1.addElement(x.getTen());
        }

        cbbCPU.setModel(dcm2);
        cbbCPUSearch.setModel(dcm2);
        for (CPUViewModel x : listCPU) {
            dcm2.addElement(x.getTen());
        }

        cbbChatLieu.setModel(dcm3);
        cbbChatLieuSearch.setModel(dcm3);
        for (ChatLieu x : listChatLieu) {
            dcm3.addElement(x.getTen());
        }

        cbbHeDieuHanh.setModel(dcm5);
        cbbHeDieuHanhSearch.setModel(dcm5);
        for (HeDieuHanh x : listHeDieuHanh) {
            dcm5.addElement(x.getTen());
        }
        cbbImai.setModel(dcm6);
        for (Imei x : listImei) {
            dcm6.addElement(x.getMa());
        }
        cbbRam.setModel(dcm7);
        cbbRamSearch.setModel(dcm7);
        for (Ram x : listRam) {
            dcm7.addElement(x.getTen());
        }
        cbbNhaSanXuat.setModel(dcm8);
        cbbNhaSanXuatSearch.setModel(dcm8);
        for (Hang x : listHang) {
            dcm8.addElement(x.getTen());
        }
        cbbManHinh.setModel(dcm9);
        cbbManHinhSearch.setModel(dcm9);
        for (ManHinh x : listManHinh) {
            dcm9.addElement(x.getMa());
        }
        showData(sanPhamService.getAll());

    }

    private void showData(List<SanPham> list) {
        dtm.setRowCount(0);
        for (SanPham x : list) {
            dtm.addRow(new Object[]{jTableSanPham.getRowCount() + 1, x.getMa(), x.getTen(), x.getTrongLuong(), x.getNamBH(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan(), x.getMoTa()});
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

        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        TimKiemSanPham = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNamBaoHanhSearch = new javax.swing.JTextField();
        txtTenSanPhamSearch = new javax.swing.JTextField();
        cbbMauSacSearch = new javax.swing.JComboBox<>();
        cbbManHinhSearch = new javax.swing.JComboBox<>();
        txtTrongLuongSearch = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbbNhaSanXuatSearch = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbbCPUSearch = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbbHeDieuHanhSearch = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSoLuongTonSearch = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbbChatLieuSearch = new javax.swing.JComboBox<>();
        cbbRamSearch = new javax.swing.JComboBox<>();
        cbbGiaBanSearch = new javax.swing.JComboBox<>();
        cbb_GiaNhapSearch = new javax.swing.JComboBox<>();
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
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbManHinh = new javax.swing.JComboBox<>();
        txtTrongLuong = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbbNhaSanXuat = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cbbCPU = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        cbbHeDieuHanh = new javax.swing.JComboBox<>();
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
        cbbChatLieu = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        cbbImai = new javax.swing.JComboBox<>();
        cbbRam = new javax.swing.JComboBox<>();
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

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Quản Lý Sản Phẩm");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tên sản phẩm:");

        cbbMauSacSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbManHinhSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Năm sản xuất:");

        jLabel16.setText("Hãng");

        jLabel17.setText("Màu sắc:");

        jLabel18.setText("Trọng lượng:");

        jLabel19.setText("Màn hình:");

        cbbNhaSanXuatSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("CPU:");

        cbbCPUSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("Ram:");

        cbbHeDieuHanhSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setText("Giá bán:");

        jLabel23.setText("Giá nhập:");

        jLabel24.setText("Số lượng tồn:");

        jLabel25.setText("Hệ điều hành:");

        jLabel29.setText("Chất liệu:");

        cbbChatLieuSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbRamSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbGiaBanSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbb_GiaNhapSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                            .addComponent(jLabel15)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTrongLuongSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSanPhamSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtNamBaoHanhSearch)))
                            .addComponent(cbbCPUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbRamSearch, 0, 140, Short.MAX_VALUE)
                    .addComponent(txtSoLuongTonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(cbbGiaBanSearch, 0, 140, Short.MAX_VALUE)
                    .addComponent(cbbHeDieuHanhSearch, 0, 140, Short.MAX_VALUE)
                    .addComponent(cbbChatLieuSearch, 0, 140, Short.MAX_VALUE)
                    .addComponent(cbb_GiaNhapSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSanPhamSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbRamSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtNamBaoHanhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbHeDieuHanhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrongLuongSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbChatLieuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_GiaNhapSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbbMauSacSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(cbbGiaBanSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cbbManHinhSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNhaSanXuatSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtSoLuongTonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbCPUSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addGroup(TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        TimKiemSanPhamLayout.setVerticalGroup(
            TimKiemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimKiemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tìm kiếm sản phẩm", TimKiemSanPham);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Mã sản phẩm:");

        jLabel3.setText("Tên sản phẩm:");

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbManHinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("Năm sản xuất:");

        jLabel28.setText("Hãng");

        jLabel30.setText("Màu sắc:");

        jLabel31.setText("Trọng lượng:");

        jLabel32.setText("Màn hình:");

        cbbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel33.setText("CPU:");

        cbbCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel34.setText("Ram:");

        cbbHeDieuHanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setText("Imei:");

        cbbImai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(txtMaSanPham)
                                    .addComponent(txtNamBaoHanh)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel40)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38)
                            .addComponent(jLabel41)
                            .addComponent(jLabel39)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGiaNHap, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(txtGiaBan)
                                .addComponent(txtSoLuongTon))
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbImai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
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
                            .addComponent(cbbHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbImai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnImei, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)
                                    .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)
                                    .addComponent(btnManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(btnHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(btnCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34)
                                    .addComponent(btnRam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout QanLiSanPhamLayout = new javax.swing.GroupLayout(QanLiSanPham);
        QanLiSanPham.setLayout(QanLiSanPhamLayout);
        QanLiSanPhamLayout.setHorizontalGroup(
            QanLiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QanLiSanPhamLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        QanLiSanPhamLayout.setVerticalGroup(
            QanLiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QanLiSanPhamLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        new AdQuanLiManHinh().setVisible(true);
    }//GEN-LAST:event_btnManHinhActionPerformed


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
    private javax.swing.JComboBox<String> cbbCPU;
    private javax.swing.JComboBox<String> cbbCPUSearch;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbChatLieuSearch;
    private javax.swing.JComboBox<String> cbbGiaBanSearch;
    private javax.swing.JComboBox<String> cbbHeDieuHanh;
    private javax.swing.JComboBox<String> cbbHeDieuHanhSearch;
    private javax.swing.JComboBox<String> cbbImai;
    private javax.swing.JComboBox<String> cbbManHinh;
    private javax.swing.JComboBox<String> cbbManHinhSearch;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbMauSacSearch;
    private javax.swing.JComboBox<String> cbbNhaSanXuat;
    private javax.swing.JComboBox<String> cbbNhaSanXuatSearch;
    private javax.swing.JComboBox<String> cbbRam;
    private javax.swing.JComboBox<String> cbbRamSearch;
    private javax.swing.JComboBox<String> cbb_GiaNhapSearch;
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
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JTextField txtNamBaoHanhSearch;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtSoLuongTonSearch;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenSanPhamSearch;
    private javax.swing.JTextField txtTrongLuong;
    private javax.swing.JTextField txtTrongLuongSearch;
    // End of variables declaration//GEN-END:variables
}
