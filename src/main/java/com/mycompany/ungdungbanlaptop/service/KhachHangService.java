/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public interface KhachHangService {

    List<KhachHang> getAll();

    String add(KhachHang khachHang);

    String update(KhachHang khachHang);

    String delete(KhachHang khachHang);

    List<KhachHang> search(List<KhachHang> list, String soDienThoai);

    KhachHang getByTen(String ten);

    List<LichSuMuaHangViewModel> getLichSuMuaHang(String ma);

    KhachHang getBySoDienThoai(String soDienThoai);

}
