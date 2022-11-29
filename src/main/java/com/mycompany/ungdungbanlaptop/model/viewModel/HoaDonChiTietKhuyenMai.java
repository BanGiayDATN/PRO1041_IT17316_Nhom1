/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietKhuyenMai {
    
    private String maHoaDon;
    private String tenSanPham;
    private String tenHang;
    private int dungLuong;
    private String tenHeDieuHanh;
    private String tenKhachhang;
    private String gioiTinh;
    private int soLuong;
}
