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
public class LichSuMuaHangViewModel {

    private String idKhachHang;
    private String ma;
    private int soLuong;
    private BigDecimal donGia;
    private long ngayTao;
    private long ngayThanhToan;
    private int tinhTrang;

    public LichSuMuaHangViewModel(String ma, int soLuong, BigDecimal donGia, long ngayTao, long ngayThanhToan, int tinhTrang) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
    }

  
    
}
