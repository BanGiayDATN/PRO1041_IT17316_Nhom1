/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import java.math.BigDecimal;
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
public class SanPhamBanHangViewModel {
    private String ma;
    private String ten;
    private int namBH;
    private float trongLuong;
    private int soLuongTon;
    private BigDecimal giaBan;
    private String moTa;
   
}
