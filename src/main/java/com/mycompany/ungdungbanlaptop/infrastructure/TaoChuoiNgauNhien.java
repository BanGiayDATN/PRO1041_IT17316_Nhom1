/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure;

import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author vinhnv
 */
public class TaoChuoiNgauNhien {

    public String getMkRanDum( int soLuong ) {
        String generator =  RandomStringUtils.randomNumeric(soLuong);
        return generator;
    }
    public String getIMEI(String noDung , int soluong) {
        String generator = noDung + RandomStringUtils.randomNumeric(soluong);
        return generator;
    }

    public static void main(String[] args) {
        String ktra = new TaoChuoiNgauNhien().getIMEI("Mật khẩu mới : ", 15);
        System.out.println(ktra);
    }
}
