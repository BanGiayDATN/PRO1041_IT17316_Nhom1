/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.model.response.NhanVienResponse;

/**
 *
 * @author vinhnv
 */
public interface LoginService {

    String login(String email, String password);

    String quenMK(String email, String sdt);
    
    String dangKy(NhanVienResponse response);
}
