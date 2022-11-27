/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface KhuyenMaiSanPhamService {
    
    List<SanPhamCustomRespone> findSanPhamById(String  ma);
    
}
