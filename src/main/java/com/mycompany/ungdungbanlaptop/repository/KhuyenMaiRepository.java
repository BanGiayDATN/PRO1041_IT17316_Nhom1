/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface KhuyenMaiRepository {

    List<SanPham> getAll();

    SanPham add(SanPham sanPham);

    SanPham update(SanPham sanPham);

    SanPham delete(SanPham sanPham);

    SanPham getOne(String maSp);
}
