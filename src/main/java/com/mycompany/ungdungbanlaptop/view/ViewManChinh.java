/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.view.viewKhuyenMai.ViewKhuyenMai;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author thang
 */
public class ViewManChinh extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private NhanVien nhanVien;

    public ViewManChinh(NhanVien nhanVien) {
        initComponents();
        this.nhanVien = nhanVien;
        this.setLocationRelativeTo(null);
        if (nhanVien.getChucVu().getTen().equals("Nhân viên")) {
            btnSanPham.setVisible(false);
            btnNhanVien.setVisible(false);
            btnThongKe.setVisible(false);
            menu.setVisible(false);
        }
        menu.setIcon(new ImageIcon(new File("").getAbsolutePath() + "//src//main//resources//img//icon.png"));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        viewChucNang = new javax.swing.JPanel();
        ViewMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnHoaDOn = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnBaoHanh = new javax.swing.JButton();
        btnDoiTra = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menu = new javax.swing.JMenu();
        menuHang = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuCPU = new javax.swing.JMenuItem();
        menuChatLieu = new javax.swing.JMenuItem();
        MenuGPM = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu8.setText("File");
        jMenuBar2.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar2.add(jMenu9);

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewChucNang.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout viewChucNangLayout = new javax.swing.GroupLayout(viewChucNang);
        viewChucNang.setLayout(viewChucNangLayout);
        viewChucNangLayout.setHorizontalGroup(
            viewChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        viewChucNangLayout.setVerticalGroup(
            viewChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        ViewMenu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add to basket.png"))); // NOI18N
        btnBanHang.setText("Bán hàng");
        btnBanHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBanHangMouseMoved(evt);
            }
        });
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBanHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBanHangMouseExited(evt);
            }
        });
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Brick house.png"))); // NOI18N
        btnTrangChu.setText("Trang Chủ");
        btnTrangChu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseMoved(evt);
            }
        });
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseExited(evt);
            }
        });
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Full basket.png"))); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseMoved(evt);
            }
        });
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseExited(evt);
            }
        });
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnHoaDOn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHoaDOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lists.png"))); // NOI18N
        btnHoaDOn.setText("Hóa Đơn");
        btnHoaDOn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnHoaDOnMouseMoved(evt);
            }
        });
        btnHoaDOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHoaDOnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHoaDOnMouseExited(evt);
            }
        });
        btnHoaDOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDOnActionPerformed(evt);
            }
        });

        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Conference.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseMoved(evt);
            }
        });
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseExited(evt);
            }
        });
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Boy.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseMoved(evt);
            }
        });
        btnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNhanVienMouseExited(evt);
            }
        });
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Date.png"))); // NOI18N
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseMoved(evt);
            }
        });
        btnKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKhuyenMaiMouseExited(evt);
            }
        });
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnBaoHanh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBaoHanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Brief case.png"))); // NOI18N
        btnBaoHanh.setText("Bảo hành");
        btnBaoHanh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBaoHanhMouseMoved(evt);
            }
        });
        btnBaoHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBaoHanhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBaoHanhMouseExited(evt);
            }
        });
        btnBaoHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoHanhActionPerformed(evt);
            }
        });

        btnDoiTra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Payment.png"))); // NOI18N
        btnDoiTra.setText("Đổi Trả");
        btnDoiTra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnDoiTraMouseMoved(evt);
            }
        });
        btnDoiTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoiTraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoiTraMouseExited(evt);
            }
        });
        btnDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiTraActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThongKeMouseMoved(evt);
            }
        });
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeMouseExited(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBaoHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDoiTra, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoaDOn, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDOn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout ViewMenuLayout = new javax.swing.GroupLayout(ViewMenu);
        ViewMenu.setLayout(ViewMenuLayout);
        ViewMenuLayout.setHorizontalGroup(
            ViewMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewMenuLayout.setVerticalGroup(
            ViewMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMenuLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu2.setText("File");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        menu.setText("Cấu hình máy");

        menuHang.setText("Hãng");
        menuHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHangActionPerformed(evt);
            }
        });
        menu.add(menuHang);

        jMenuItem2.setText("Ram");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem2);

        jMenuItem4.setText("Version hệ điều hành");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu.add(jMenuItem4);

        menuCPU.setText("CPU");
        menuCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCPUActionPerformed(evt);
            }
        });
        menu.add(menuCPU);

        menuChatLieu.setText("Chất liệu");
        menuChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChatLieuActionPerformed(evt);
            }
        });
        menu.add(menuChatLieu);

        MenuGPM.setText("GPM");
        MenuGPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGPMActionPerformed(evt);
            }
        });
        menu.add(MenuGPM);

        jMenuBar1.add(menu);

        jMenu10.setText("Sản phẩm");
        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(viewChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHangActionPerformed
        viewChucNang.removeAll();
        AdQuanLiHang form = new AdQuanLiHang();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_menuHangActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        viewChucNang.removeAll();
        AdQuanLiRam form = new AdQuanLiRam();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        viewChucNang.removeAll();
        AdQuanLiVersionHeDieuHanh form = new AdQuanLiVersionHeDieuHanh();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCPUActionPerformed
        viewChucNang.removeAll();
        CPUview form = new CPUview();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_menuCPUActionPerformed

    private void menuChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChatLieuActionPerformed
        viewChucNang.removeAll();
        ChatLieuView form = new ChatLieuView();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_menuChatLieuActionPerformed

    private void MenuGPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGPMActionPerformed
        viewChucNang.removeAll();
        GPMView form = new GPMView();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_MenuGPMActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed

        viewChucNang.removeAll();
        ViewBanHang form = new ViewBanHang(nhanVien);
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        viewChucNang.removeAll();
        ViewSanPham form = new ViewSanPham();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnHoaDOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDOnActionPerformed
        viewChucNang.removeAll();
        QuanLiHoaDon form = new QuanLiHoaDon();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnHoaDOnActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        viewChucNang.removeAll();
        ViewKhachHang form = new ViewKhachHang();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        viewChucNang.removeAll();
        ViewNhanVien form = new ViewNhanVien();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        viewChucNang.removeAll();
        ViewKhuyenMai form = new ViewKhuyenMai();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnBaoHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoHanhActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiTraActionPerformed

    private void btnTrangChuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseEntered
        btnTrangChu.setBackground(Color.green);
    }//GEN-LAST:event_btnTrangChuMouseEntered

    private void btnBanHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseEntered
        btnBanHang.setBackground(Color.green);
    }//GEN-LAST:event_btnBanHangMouseEntered

    private void btnHoaDOnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDOnMouseEntered
        btnHoaDOn.setBackground(Color.green);
    }//GEN-LAST:event_btnHoaDOnMouseEntered

    private void btnSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseEntered
        btnSanPham.setBackground(Color.green);
    }//GEN-LAST:event_btnSanPhamMouseEntered

    private void btnNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseEntered
        btnNhanVien.setBackground(Color.green);
    }//GEN-LAST:event_btnNhanVienMouseEntered

    private void btnKhachHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseEntered
        btnKhachHang.setBackground(Color.green);
    }//GEN-LAST:event_btnKhachHangMouseEntered

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseEntered
        btnThongKe.setBackground(Color.green);        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeMouseEntered

    private void btnBaoHanhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoHanhMouseEntered
        btnBaoHanh.setBackground(Color.green);        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoHanhMouseEntered

    private void btnDoiTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiTraMouseEntered
        btnDoiTra.setBackground(Color.green);        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiTraMouseEntered

    private void btnKhuyenMaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseEntered
        btnKhuyenMai.setBackground(Color.green);        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhuyenMaiMouseEntered

    private void btnTrangChuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseExited
        btnTrangChu.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnTrangChuMouseExited

    private void btnBanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseExited
        btnBanHang.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHangMouseExited

    private void btnHoaDOnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDOnMouseExited
        btnHoaDOn.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoaDOnMouseExited

    private void btnSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseExited
        btnSanPham.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnSanPhamMouseExited

    private void btnNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseExited
        btnNhanVien.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhanVienMouseExited

    private void btnKhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseExited
        btnKhachHang.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhachHangMouseExited

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseExited
        btnThongKe.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeMouseExited

    private void btnBaoHanhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoHanhMouseExited
        btnBaoHanh.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoHanhMouseExited

    private void btnDoiTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiTraMouseExited
        btnDoiTra.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiTraMouseExited

    private void btnKhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseExited
        btnKhuyenMai.setBackground(new Color(240, 240, 240));        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhuyenMaiMouseExited

    private void btnTrangChuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseMoved
        btnTrangChu.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangChuMouseMoved

    private void btnBanHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseMoved
        btnBanHang.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHangMouseMoved

    private void btnHoaDOnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHoaDOnMouseMoved
        btnHoaDOn.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoaDOnMouseMoved

    private void btnSanPhamMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseMoved
        btnSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnSanPhamMouseMoved

    private void btnNhanVienMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhanVienMouseMoved
        btnNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhanVienMouseMoved

    private void btnKhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseMoved
        btnKhachHang.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhachHangMouseMoved

    private void btnThongKeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseMoved
        btnThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeMouseMoved

    private void btnBaoHanhMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoHanhMouseMoved
        btnBaoHanh.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoHanhMouseMoved

    private void btnDoiTraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiTraMouseMoved
        btnDoiTra.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiTraMouseMoved

    private void btnKhuyenMaiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhuyenMaiMouseMoved
        btnKhuyenMai.setCursor(new Cursor(Cursor.HAND_CURSOR));        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhuyenMaiMouseMoved

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewManChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewManChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewManChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewManChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ViewManChinh(new NhanVien()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuGPM;
    private javax.swing.JPanel ViewMenu;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnBaoHanh;
    private javax.swing.JButton btnDoiTra;
    private javax.swing.JButton btnHoaDOn;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem menuCPU;
    private javax.swing.JMenuItem menuChatLieu;
    private javax.swing.JMenuItem menuHang;
    private javax.swing.JPanel viewChucNang;
    // End of variables declaration//GEN-END:variables
}
