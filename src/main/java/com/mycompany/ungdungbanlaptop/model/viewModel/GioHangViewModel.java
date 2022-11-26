/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Diệm DZ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GioHangViewModel {
    private UUID idHoaDon;
    private UUID idSanPham;
    private String ma;
    private String ten;
    private int soLuong;
    private BigDecimal donGia;

    public GioHangViewModel(UUID idSanPham, String ma, String ten, int soLuong, BigDecimal donGia) {
        this.idSanPham = idSanPham;
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
<<<<<<< HEAD

=======
    
>>>>>>> develop
    
}
