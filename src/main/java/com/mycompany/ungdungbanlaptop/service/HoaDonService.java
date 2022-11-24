/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface HoaDonService {
    
    
    List<HoaDon> getAll();

    HoaDon add(HoaDon hoaDon);

    HoaDon update(HoaDon hoaDon);

    HoaDon delete(HoaDon hoaDon);

    HoaDon getOne(String maSp);
    
    boolean setTrangThai(UUID id, HoaDon hoaDon);
    
    List<HoaDonBanHangViewModel> getHoaDonBanHang();
    
    List<HoaDonBanHangViewModel> getTrangThai(int trangThai);
    
    List<HoaDonBanHangViewModel> getHoaDonCho();
}
