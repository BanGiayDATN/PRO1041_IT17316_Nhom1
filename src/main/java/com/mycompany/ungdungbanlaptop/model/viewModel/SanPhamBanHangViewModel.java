/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Diệm DZ
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamBanHangViewModel {
    private UUID id;
    private String ma;
    private String ten;
    private int namBH;
    private float trongLuong;
    private int soLuongTon;
    private BigDecimal giaBan;
    private String moTa;

    public SanPhamBanHangViewModel(String ma, String ten, int namBH, float trongLuong, int soLuongTon, BigDecimal giaBan, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.namBH = namBH;
        this.trongLuong = trongLuong;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.moTa = moTa;
    }
    
    
   
}
