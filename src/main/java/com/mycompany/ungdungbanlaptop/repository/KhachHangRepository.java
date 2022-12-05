/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface KhachHangRepository {

    List<KhachHang> getAll();

    KhachHang add(KhachHang khachHang);

    KhachHang update(KhachHang khachHang);

    KhachHang delete(KhachHang khachHang);

    KhachHang getOne(String maKh);

    KhachHang getByTen(String ten);

    List<KhachHang> sreach(String soDienThoai);
    
     List<LichSuMuaHangViewModel> getLichSuMuaHang(String ma);
     
    KhachHang getBySoDienThoai(String soDienThoai);
    
     List<KhachHang> searchByHoTen(String hoTen);
    
    KhachHang getByEmail(String email);
    
    Long soLuotMua(String maKH);
    
    List<String> getAllTenKhachHang();
    
}
