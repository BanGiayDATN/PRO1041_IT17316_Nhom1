/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface KhuyenMaiSanPhamRepository {
    
    List<SanPhamCustomRespone> findSanPhamById(String id);
    
    boolean deleteKhuyenMaiById(String ma);
    
    boolean saveAllKhuyenMai(KhuyenMai khuyenMai,Map<UUID, SanPhamCustomRespone> list);
}
