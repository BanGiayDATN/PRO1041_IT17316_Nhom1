/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.model.resquest.SeachHoaDon;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface HoaDonService {
    
    
    List<HoaDonRespone> getAll(SeachHoaDon seachHoaDon);

    HoaDon add(HoaDon hoaDon);

    HoaDon update(HoaDon hoaDon);

    HoaDon delete(HoaDon hoaDon);

    HoaDon getOne(String maHoaDon);
    
    boolean setTrangThai(UUID id, HoaDon hoaDon);
    
    List<HoaDonBanHangViewModel> getHoaDonBanHang();
    
    List<HoaDonBanHangViewModel> getTrangThai(int trangThai);
    
    List<HoaDonBanHangViewModel> getHoaDonCho();
    
    HoaDon getById(UUID id);
    
    List<HoaDonKhuyenMai> findAllByMaKhuyenMai(String ma);
    
    long countKhachHang(long batDau , long ketThuc);
    
    long soKhachHangTheoNgay(long toDay);
    
    long tongSoKhachHang();
    
    List<HoaDonRespone> getListHoaDonByMaOrSDT(String ma, String sdt);
    
}
