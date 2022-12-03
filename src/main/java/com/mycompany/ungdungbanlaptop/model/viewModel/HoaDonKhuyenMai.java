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
 * @author thang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonKhuyenMai {
    
    private String ma;
    private long ngayTao;
    private String maNhanVien;
    private String tenNhanVien;
    private String tenKhachHang;
    private long soLuong;
    private BigDecimal tongTien;
}
