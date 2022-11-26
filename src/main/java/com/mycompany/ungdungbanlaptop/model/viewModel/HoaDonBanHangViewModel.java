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

<<<<<<< HEAD

=======
    public HoaDonBanHangViewModel(String ma, long ngayTao, String hoTen, int tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.hoTen = hoTen;
        this.tinhTrang = tinhTrang;
    }


    
>>>>>>> develop
    public HoaDonBanHangViewModel(String ma, long ngayTao, int tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public HoaDonBanHangViewModel(String ma, long ngayTao, String hoTen, int tinhTrang) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.hoTen = hoTen;
        this.tinhTrang = tinhTrang;
    }
    
    
    public String trangThai(){
        return switch (tinhTrang) {
            case 0 -> "Đã thanh toán";
            case 1 -> "Chưa thanh toán";
            default -> "Đã hủy";
        };
    }
<<<<<<< HEAD
=======
    
>>>>>>> develop

}
