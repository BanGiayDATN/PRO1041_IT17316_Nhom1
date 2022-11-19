/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import com.mycompany.ungdungbanlaptop.util.ConverDate;
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
    private long ngayBatDau;
    private long ngayKetThuc;
    private int trangThai;
    private int soLuong;
    private int phanTram;

    public Object[] todata() {
        return new Object[]{
           new Object[]{ma, new ConverDate().longToDate(ngayBatDau, "yyyy/MM/dd"), new ConverDate().longToDate(ngayKetThuc, "yyyy/MM/dd"), trangThai == 0 ? "Còn" : "Hết", soLuong, phanTram+ "%"}
        };
    }

    public KhuyenMaiViewModel(String ma, long ngayBatDau, long ngayKetThuc, int trangThai, int soLuong, int phanTram) {
        this.ma = ma;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.phanTram = phanTram;
    }

    
}
