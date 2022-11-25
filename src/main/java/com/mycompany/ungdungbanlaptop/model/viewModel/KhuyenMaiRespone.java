/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiKhuyenMai;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bridj.ann.Alignment;

/**
 *
 * @author thang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiRespone {

    private UUID id;
    private String ma;
    private String ten;
    private long ngaybatDau;
    private long ngayKethuc;
    private EnumLoaiKhuyenMai loaiKhuyenMai;
    private int soLuong;

    public String getNgayBatDauString() {
        return new ConverDate().longToDate(ngaybatDau, "dd/MM/yyyy");
    }

    public String getNgayKethucString() {
        return new ConverDate().longToDate(ngayKethuc, "dd/MM/yyyy");
    }

    public String getHinhThuc() {
        if(loaiKhuyenMai != null){
            switch (loaiKhuyenMai) {
            case PHAN_TRAM:
                return "Phần trăm";
            case TIEN_MAT:
                return " theo giá tiền";
            default:
                return "";
        }
        }
        return "";
    }

}
