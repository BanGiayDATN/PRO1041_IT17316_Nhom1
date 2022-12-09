/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewDoiTra;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author thang
 */
public class ViewShowDoiTra extends javax.swing.JPanel {

    /**
     * Creates new form ViewShowDoiTra
     */
    public ViewShowDoiTra(NhanVien nhanVien) {
        initComponents();
        viewChucNang.removeAll();
        ViewDoiTra form = new ViewDoiTra(nhanVien);
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        form.setVisible(true);
    }

    public static void loadView(JPanel form) {
        viewChucNang.removeAll();
        viewChucNang.add(form);
        viewChucNang.setLayout(new FlowLayout());
        form.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewChucNang = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        viewChucNang.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout viewChucNangLayout = new javax.swing.GroupLayout(viewChucNang);
        viewChucNang.setLayout(viewChucNangLayout);
        viewChucNangLayout.setHorizontalGroup(
            viewChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        viewChucNangLayout.setVerticalGroup(
            viewChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel viewChucNang;
    // End of variables declaration//GEN-END:variables
}
