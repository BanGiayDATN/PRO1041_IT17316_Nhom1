/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HuynhPhung
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMaiViewModel {

    private UUID id;
    private String ma;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int trangThai;
    private int soLuong;
    private int phanTram;

    public KhuyenMaiViewModel(String ma, String ngayBatDau, String ngayKetThuc, int trangThai, int soLuong, int phanTram) {
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.phanTram = phanTram;
    }

    
}
