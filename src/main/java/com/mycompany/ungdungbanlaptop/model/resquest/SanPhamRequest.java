/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bridj.ann.Alignment;

/**
 *
 * @author thang
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamRequest {
    
    private String ma;
    private String ten;
    private String giaBan;
    private String trongLuong;
    private String soLuongTon;
    private String namBH;
    private String maManHinh;
    private String doPhanGiaMan;
     private String kichThuoc;
     private String maCPU;
     private String tenCPU;  
     private String maMau;
     private String tenMau;
     private String maHeDieuHanh;
     private String tenHeDieuHanh;
     private String maRam;
     private int dungLuong;
     private EnumLoaiRam enumLoaiRam;
     private String tenHang;
     
}
