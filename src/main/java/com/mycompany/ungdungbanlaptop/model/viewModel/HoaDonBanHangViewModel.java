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
 * @author Diệm DZ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonBanHangViewModel {
    private UUID id;
    private String ma;
    private long ngayTao;
    private String hoTen;
    private int tinhTrang;

    public HoaDonBanHangViewModel(String ma, long ngayTao, String hoTen, int tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.hoTen = hoTen;
        this.tinhTrang = tinhTrang;
    }

}
