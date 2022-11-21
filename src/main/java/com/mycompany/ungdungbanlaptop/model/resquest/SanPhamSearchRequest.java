/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vinhnv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamSearchRequest {

    private String ma;
    private String ten;
    private String manHinh;
    private String tenCpu;
    private String tenMau;
    private String tenHeDieuHanh;
    private String tenRam;
    private String tenChatLieu;
    private String tenHang;
    private int namSX;
    private float trongLuong;
    private int soLuong;
    private BigDecimal giaNhap;
    private BigDecimal startsGiaNhap;
    private BigDecimal startsGiaBan;
    private BigDecimal giaBan;
}
