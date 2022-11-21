/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

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
public class NhanVienViewModel {

    private String id;
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private int trangThai;
}
