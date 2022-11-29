/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewKhuyenMai;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiSanPhamService;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import com.mycompany.ungdungbanlaptop.service.impl.KhuyenMaiSanPhamServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.KhuyenMaiServiceImpl;
import com.mycompany.ungdungbanlaptop.service.impl.SanPhamServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.DefaultListModel;

/**
 *
 * @author thang
 */
public class ViewThemSanPhamKhuyenMai extends javax.swing.JFrame {

    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
    private KhuyenMaiSanPhamService khuyenMaiSanPhamService = new KhuyenMaiSanPhamServiceImpl();
    private List< SanPhamCustomRespone> SanPhams = new ArrayList<>();
    private Map<UUID, SanPhamCustomRespone> listSanPhamKhuyenMai = new HashMap<>();
    private KhuyenMai khuyenMai;
    private String ma;

    public ViewThemSanPhamKhuyenMai(String ma) {
        initComponents();
        this.ma = ma;
        KhuyenMai khuyenMai = khuyenMaiService.getOne(ma);
         this.khuyenMai = khuyenMai;
        SanPhams = sanPhamService.getListSanPham();
        khuyenMaiSanPhamService.findSanPhamById(ma).stream().forEach(item -> {
            listSanPhamKhuyenMai.put(item.getId(), item);
        });
        loadListSanPham(SanPhams);
        loadListSanPhamKhuyenMai(listSanPhamKhuyenMai);

    }

    private void loadListSanPham( List< SanPhamCustomRespone> list) {
        DefaultListModel model = new DefaultListModel();
        for (SanPhamCustomRespone sanPhamCustomRespone : list) {
            model.addElement(sanPhamCustomRespone.getTenSanPham());
        }
        listSanPham.setModel(model);
    }

    private void loadListSanPhamKhuyenMai(Map<UUID, SanPhamCustomRespone> list) {
        DefaultListModel model = new DefaultListModel();
        for (SanPhamCustomRespone sanPhamCustomRespone : list.values()) {
            model.addElement(sanPhamCustomRespone.getTenSanPham());
        }
        jList1.setModel(model);
    }

    private List< SanPhamCustomRespone> findByMaAndTen(String text) {
        List< SanPhamCustomRespone> list = new ArrayList<>();
        SanPhams.stream().forEach(item -> {
            if (item.getMa().toLowerCase().contains(text) || item.getTen().toLowerCase().contains(text)) {
                list.add( item);
            }
        });
        return list;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSanPham = new javax.swing.JList<>();
        txtseach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        listSanPham.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listSanPham);

        txtseach.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtseachCaretUpdate(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(">>");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(71, 71, 71)
                        .addComponent(jButton3)
                        .addGap(61, 61, 61)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(70, 70, 70))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtseachCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtseachCaretUpdate
        loadListSanPham(findByMaAndTen(txtseach.getText().toLowerCase().trim()));
    }//GEN-LAST:event_txtseachCaretUpdate

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (listSanPham.getSelectedIndex() == -1) {
            return;
        } else {
            String value = listSanPham.getSelectedValue();
            SanPhams.stream().forEach(item ->{
            if(item.getTenSanPham().equals(value)){
                     listSanPhamKhuyenMai.put(item.getId(), item);
//                     SanPhams.remove(item);
                   
                }
           
            
        });
            
        }
        loadListSanPhamKhuyenMai(listSanPhamKhuyenMai);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jList1.getSelectedIndex() == -1) {
            return;
        } else {
            String value = jList1.getSelectedValue();
            UUID id = null;
            SanPhamCustomRespone sanPham = null;
            List keys = new ArrayList(listSanPhamKhuyenMai.keySet());
            for(SanPhamCustomRespone sanPhamCustomRespone : listSanPhamKhuyenMai.values()){
                if(sanPhamCustomRespone.getTenSanPham().equals(value)){
                    id = sanPhamCustomRespone.getId();
                    sanPham = sanPhamCustomRespone;
                }
            };
            
            // do stuff here
            List values = new ArrayList(listSanPhamKhuyenMai.values());
            
            SanPhams.add(sanPham);
            listSanPhamKhuyenMai.remove(id);
        }
        loadListSanPham(SanPhams);
        loadListSanPhamKhuyenMai(listSanPhamKhuyenMai);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jList1.getSelectedIndex() == -1) {
            return;
        } else {
            List<String> values = jList1.getSelectedValuesList();
             List< SanPhamCustomRespone> sanPhams = new ArrayList(listSanPhamKhuyenMai.values());
             for(SanPhamCustomRespone sanPhamCustomRespone : sanPhams){
                 values.stream().forEach(item ->{
                 if(sanPhamCustomRespone.getTenSanPham().equals(item)){
                     SanPhams.add(sanPhamCustomRespone);
                     listSanPhamKhuyenMai.remove(sanPhamCustomRespone.getId());
                 }
                 });
                 
             } 
        }
        loadListSanPham(SanPhams);
        loadListSanPhamKhuyenMai(listSanPhamKhuyenMai);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if (listSanPham.getSelectedIndex() == -1) {
            return;
        } else {
            List<String> values = listSanPham.getSelectedValuesList();
            List<SanPhamCustomRespone> list = new ArrayList<>();
             SanPhams.stream().forEach(sanPham ->{
             values.stream().forEach(item ->{
                    
                 if(sanPham.getTenSanPham().equals(item)){
                     listSanPhamKhuyenMai.put(sanPham.getId(),sanPham);
                     list.add(sanPham);
                 }
                 });
             });
             for(SanPhamCustomRespone sp : list){
                 SanPhams.remove(sp);
             }
        }
        loadListSanPham(SanPhams);
        loadListSanPhamKhuyenMai(listSanPhamKhuyenMai);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        khuyenMaiSanPhamService.deleteKhuyenMaiById(khuyenMai.getMa());
       khuyenMaiSanPhamService.saveAllKhuyenMai(khuyenMai, listSanPhamKhuyenMai);
       List<SanPhamCustomRespone> list = new ArrayList<>();
       listSanPhamKhuyenMai.values().stream().forEach(item ->{
           list.add(item);
       });
       ViewChiTietKhuyenMai.loadDanhSachSanPham(list);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThemSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemSanPhamKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewThemSanPhamKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listSanPham;
    private javax.swing.JTextField txtseach;
    // End of variables declaration//GEN-END:variables

}
