/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.resquest;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author vinhnv
 */
@Data
public class NhanVienResquest {

    private String ma;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String password;
    private String diaChi;
    private int trangThai;

 
    public NhanVienResquest(String hoTen, String gioiTinh, String ngaySinh, String sdt, String email, String password, String diaChi) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.password = password;
        this.diaChi = diaChi;
    }   

    public NhanVienResquest(String ma, String hoTen, String gioiTinh, String ngaySinh, String sdt, String email, String password, String diaChi, int trangThai) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.password = password;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }
    
    
}
