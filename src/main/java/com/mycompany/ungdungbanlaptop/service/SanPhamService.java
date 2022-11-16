/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import java.util.List;

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
}
