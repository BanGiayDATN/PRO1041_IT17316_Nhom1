/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiSanPhamRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.KhuyenMaiSanPhamRepostitoryImpl;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiSanPhamService;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author thang
 */
public class KhuyenMaiSanPhamServiceImpl implements KhuyenMaiSanPhamService{

    private KhuyenMaiSanPhamRepository KhuyenMaiSanPhamRepository = new KhuyenMaiSanPhamRepostitoryImpl();
    
    @Override
    public List<SanPhamCustomRespone> findSanPhamById(String ma) {
        return KhuyenMaiSanPhamRepository.findSanPhamById(ma);
    }

    @Override
    public boolean deleteKhuyenMaiById(UUID id) {
        return KhuyenMaiSanPhamRepository.deleteKhuyenMaiById(id);
    }

    @Override
    public boolean saveAllKhuyenMai(KhuyenMai khuyenMai, Map<UUID, SanPhamCustomRespone> list) {
        return KhuyenMaiSanPhamRepository.saveAllKhuyenMai(khuyenMai, list);
    }
    
}
