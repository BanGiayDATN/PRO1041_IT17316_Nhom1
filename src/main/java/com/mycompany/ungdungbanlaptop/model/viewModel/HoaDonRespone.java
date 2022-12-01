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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoaDonRespone {
    private String ma;
    private long ngayTao;
    private String maNhanVien;
    private String tenNhanVien;
    private String tenKhachHang;
    private int tinhTrang;
    private long soLuong;
    private BigDecimal tong;
    
    public String getTrangThai(){
        if(tinhTrang == 0){
            return "Hóa đơn chờ";
        }else{
            return "Đã thanh toán";
        }
    }
    
}
