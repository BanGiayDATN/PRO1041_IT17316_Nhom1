/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public interface SanPhamService {

    List<SanPham> getAll();

    String add(SanPham sanPham);

    String update(SanPham sanPham);

    String delete(SanPham sanPham);

    SanPham getOne(String ma);

    List<SanPham> search(List<SanPham> list, String maSp);

    List<SanPham> searchByTen(List<SanPham> list, String tenSp);

    List<SanPham> searchFill(SanPhamSearchRequest request);

    List<SanPhamBanHangViewModel> getSanPhamBanHang();

    List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max);

    List<SanPhamBanHangViewModel> searchByTenBanHang(List<SanPhamBanHangViewModel> list, String tenSp);

    void updateSoLuongSanPham(Map<UUID, SanPham> list);

    SanPham getById(UUID id);
    
    List<SanPhamCustomRespone> getListSanPham();
    
}
