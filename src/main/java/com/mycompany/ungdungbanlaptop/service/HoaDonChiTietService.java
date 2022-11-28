/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet);
    
     List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);
}
