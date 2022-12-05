/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface BaoHanhRepository {

    List<BaoHanh> getAll();

    BaoHanh add(BaoHanh baoHanh);

    BaoHanh getOne(String maBh);
//    
//    List<BaoHanh> sreach(String soDienThoai);
}
