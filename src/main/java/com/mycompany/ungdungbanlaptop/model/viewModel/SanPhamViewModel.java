/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import java.math.BigDecimal;
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
public class SanPhamViewModel {

    private UUID idSanPham;

    private int namBH;

    private String ma;

    private String ten;

    private float trongLuong;

    private int soLuongTon;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;

    private String moTa;

    private ManHinh manHinh;

    private CPU cpu;

    private GPM gpm;

    private HeDieuHanh heDieuHanh;

    private Ram ram;

    private KhuyenMai khuyenMai;

    private ChatLieu chatLieu;

    private Hang hang;

    private Imei imei;
}
