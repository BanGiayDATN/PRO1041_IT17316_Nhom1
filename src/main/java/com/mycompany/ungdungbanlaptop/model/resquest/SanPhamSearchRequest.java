/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vinhnv
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamSearchRequest {

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
    private BigDecimal startsGiaBan;
    private BigDecimal giaBan;
}
