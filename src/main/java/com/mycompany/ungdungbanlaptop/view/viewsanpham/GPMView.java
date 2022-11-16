/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewsanpham;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.repository.GPMRepository;
import com.mycompany.ungdungbanlaptop.service.GPMService;
import com.mycompany.ungdungbanlaptop.service.impl.GPMServiceImpl;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GPMView extends javax.swing.JPanel {

    private DefaultTableModel tbmodel;
    private GPMService service = new GPMServiceImpl();

    public GPMView() {
        initComponents();
    }

    public void loadTable(List<GPM> list) {
        tbmodel = (DefaultTableModel) tbGPM.getModel();
        tbmodel.setRowCount(0);
        tbmodel.setColumnIdentifiers(new String[]{"ID", "Mã", "Tên GPM"});
        for (GPM x : list) {
            tbmodel.addRow(new Object[]{x.getIdGPU(), x.getMa(), x.getTen()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtGPM = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGPM = new javax.swing.JTable();

        jLabel1.setText("Mã");

        jLabel2.setText("Tên GPM");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxem.setText("Xem");
        btnxem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemActionPerformed(evt);
            }
        });

        tbGPM.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGPMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbGPM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGPM, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnxem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem)
                    .addComponent(btnxem))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        GPM gpm = new GPM();
        gpm.setMa(txtma.getText());
        gpm.setTen(txtGPM.getText());
        try {
            JOptionPane.showMessageDialog(this, service.addNew(gpm));
            loadTable(service.getAll());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");

        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tbGPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGPMMouseClicked
        int row = tbGPM.getSelectedRow();
        GPM gpm = service.getAll().get(row);
        txtma.setText(gpm.getMa());
        txtGPM.setText(gpm.getTen());
    }//GEN-LAST:event_tbGPMMouseClicked

    private void btnxemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemActionPerformed
        loadTable(service.getAll());
    }//GEN-LAST:event_btnxemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        String ma = txtma.getText();
        String ten = txtGPM.getText();
        GPM gpm = service.getOne(ma);
        System.out.println(gpm);
        gpm.setMa(ma);
        gpm.setTen(ten);
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không?", "Update", 0);
        if (check == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, service.update(gpm));
        } else if (check == JOptionPane.NO_OPTION) {
            txtma.setText("");
            txtGPM.setText("");
        }
        loadTable(service.getAll());
    }//GEN-LAST:event_btnsuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGPM;
    private javax.swing.JTextField txtGPM;
    private javax.swing.JTextField txtma;
    // End of variables declaration//GEN-END:variables
}
