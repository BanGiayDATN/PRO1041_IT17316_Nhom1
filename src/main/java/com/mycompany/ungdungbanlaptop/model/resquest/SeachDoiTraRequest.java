/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHinhThucDoiTra;
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
public class SeachDoiTraRequest {
    
    private long firtDay;
    private long lastDay;
    private String maNhanVien;
    private String tenKhach;
    private EnumHinhThucDoiTra enumHinhThucDoiTra;
}
