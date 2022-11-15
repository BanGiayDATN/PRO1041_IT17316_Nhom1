/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.response.NhanVienResponse;

/**
 *
 * @author vinhnv
 */
public interface LoginService {

    NhanVien login(String email, String password);

    NhanVien doiMK(String email, String password , String passwordMoi);

    String quenMK(String email, String sdt);

    int dangKy(NhanVienResponse response);
}
