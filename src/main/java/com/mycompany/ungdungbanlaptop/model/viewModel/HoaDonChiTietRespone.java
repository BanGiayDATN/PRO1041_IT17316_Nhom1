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
 * @author thang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietRespone {
    private UUID id;
    private String maSanPham;
    private String tenSanPham;
    private BigDecimal gia;
    private int soLuong;

 
    
    
}
