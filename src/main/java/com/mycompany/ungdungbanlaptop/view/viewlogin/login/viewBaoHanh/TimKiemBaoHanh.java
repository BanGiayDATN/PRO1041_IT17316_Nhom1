/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.view.viewlogin.login.viewBaoHanh;

/**
 *
 * @author Du
 */
public class TimKiemBaoHanh extends javax.swing.JPanel {

    /**
     * Creates new form TimKiemBaoHanh
     */
    public TimKiemBaoHanh() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_SoSO = new javax.swing.JTextField();
        txt_SĐTLienHe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_SoHoaDonDo = new javax.swing.JTextField();
        txt_SoImei = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        Btn_TaoMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_TimkiemBaoHanh = new javax.swing.JTable();

        jLabel1.setText("Số Điện Thoại :");

        jLabel2.setText("Số SO :");

        jLabel3.setText("Số Imei :");

        jLabel4.setText("Hóa Đơn Đỏ :");

        txt_SoHoaDonDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoHoaDonDoActionPerformed(evt);
            }
        });

        btn_TimKiem.setText("Tìm Kiếm");

        Btn_TaoMoi.setText("Tạo Mới");
        Btn_TaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TaoMoiActionPerformed(evt);
            }
        });

        jtable_TimkiemBaoHanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Imei", "Tên Sản Phẩm", "Tên Khách Hàng", "Hạn Bảo Hành", "Số Lượng", "Số Điện Thoại", "Email", "Địa Chỉ"
            }
        ));
        jScrollPane1.setViewportView(jtable_TimkiemBaoHanh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_SĐTLienHe))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(46, 46, 46)
                                .addComponent(txt_SoSO, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_SoHoaDonDo, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(txt_SoImei))
                        .addGap(39, 39, 39)
                        .addComponent(btn_TimKiem)
                        .addGap(26, 26, 26)
                        .addComponent(Btn_TaoMoi)))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_SĐTLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_SoImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_TimKiem)
                            .addComponent(Btn_TaoMoi))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_SoSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_SoHoaDonDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SoHoaDonDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoHoaDonDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoHoaDonDoActionPerformed

    private void Btn_TaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TaoMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_TaoMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_TaoMoi;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable_TimkiemBaoHanh;
    private javax.swing.JTextField txt_SoHoaDonDo;
    private javax.swing.JTextField txt_SoImei;
    private javax.swing.JTextField txt_SoSO;
    private javax.swing.JTextField txt_SĐTLienHe;
    // End of variables declaration//GEN-END:variables
}