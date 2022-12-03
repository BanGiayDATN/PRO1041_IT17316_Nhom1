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
 * @author HuynhPhung
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietSanPham {

    private String maSanPham;
    private String tenSanPham;
    private int dungLuong;
    private String chatLieu;
    private String tenHeDieuHanh;
    private String tenKhachhang;
    private int soLuong;
  

}
