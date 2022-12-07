/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewDoiTra;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

/**
 *
 * @author thang
 */
public class DoiSanPham extends javax.swing.JFrame {

    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    
    public DoiSanPham() {
        initComponents();
        showSanPham(sanPhamService.getSanPhamBanHang());
        TableFilterHeader filterHeader = new TableFilterHeader(tblSanPham, AutoChoices.ENABLED);
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
        tblSanPham.setModel(model);
        tblSanPham.removeColumn(tblSanPham.getColumnModel().getColumn(0));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
       int row = tblSanPham.getSelectedRow();
            int soLuong = soLuongMua(row);
            if(soLuong > 0){
                GioHangViewModel sanPham = new GioHangViewModel();
                sanPham.setIdSanPham(UUID.fromString(tblSanPham.getModel().getValueAt(row, 0).toString()));
                sanPham.setMa(tblSanPham.getModel().getValueAt(row, 2).toString());
                sanPham.setTen(tblSanPham.getModel().getValueAt(row, 3).toString());
                sanPham.setSoLuong(soLuong);
                sanPham.setDonGia(new BigDecimal(tblSanPham.getModel().getValueAt(row, 7).toString()));
                ViewDoiTraTheoHoaDon.addSanPham(sanPham);
            }
    }//GEN-LAST:event_tblSanPhamMouseClicked

     private int soLuongMua(int index) {

        int soLuong = Integer.valueOf(tblSanPham.getModel().getValueAt(index, 6).toString());
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
            java.util.logging.Logger.getLogger(DoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham;
    // End of variables declaration//GEN-END:variables
}
