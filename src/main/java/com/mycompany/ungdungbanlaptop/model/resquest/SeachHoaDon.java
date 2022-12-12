/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

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
public class SeachHoaDon {
    private String ma;
    private long ngayTao;
    private String maNhanVien;
    private String tenNhanVien;
    private String tenKhachHang;
}
