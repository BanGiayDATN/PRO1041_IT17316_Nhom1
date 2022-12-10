/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;


import com.mycompany.ungdungbanlaptop.view.viewBaoHanh.BaoHanh1;
import com.mycompany.ungdungbanlaptop.view.viewDoiTra.ViewShowDoiTra;
import com.mycompany.ungdungbanlaptop.view.viewKhuyenMai.ViewKhuyenMai;
import java.awt.FlowLayout;

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
            btnHoaDon.setVisible(false);
        }

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();

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
            .addGap(0, 789, Short.MAX_VALUE)
        );

        ViewMenu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add to basket.png"))); // NOI18N
        jButton1.setText("Bán hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Brick house.png"))); // NOI18N
        jButton2.setText("Trang Chủ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add to basket.png"))); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lists.png"))); // NOI18N
        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Conference.png"))); // NOI18N
        jButton5.setText("Khách hàng");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Boy.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Date.png"))); // NOI18N
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Brief case.png"))); // NOI18N
        jButton9.setText("Bảo hành");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Payment.png"))); // NOI18N
        jButton10.setText("Đổi Trả");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout ViewMenuLayout = new javax.swing.GroupLayout(ViewMenu);
        ViewMenu.setLayout(ViewMenuLayout);
        ViewMenuLayout.setHorizontalGroup(
            ViewMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ViewMenuLayout.setVerticalGroup(
            ViewMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewMenuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        viewChucNang.removeAll();
        ViewBanHang form = new ViewBanHang(nhanVien);
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        viewChucNang.removeAll();
        ViewSanPham form = new ViewSanPham(nhanVien);
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        viewChucNang.removeAll();
        QuanLiHoaDon form = new QuanLiHoaDon();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        viewChucNang.removeAll();
        ViewKhachHang form = new ViewKhachHang();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        viewChucNang.removeAll();
        BaoHanh1 form = new BaoHanh1();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        viewChucNang.removeAll();
        ViewThongKe form = new ViewThongKe();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        viewChucNang.removeAll();
        ViewShowDoiTra form = new ViewShowDoiTra(nhanVien);
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        this.pack();
        form.setVisible(true);

    }//GEN-LAST:event_jButton10ActionPerformed

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
    private javax.swing.JPanel ViewMenu;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel viewChucNang;
    // End of variables declaration//GEN-END:variables
}
