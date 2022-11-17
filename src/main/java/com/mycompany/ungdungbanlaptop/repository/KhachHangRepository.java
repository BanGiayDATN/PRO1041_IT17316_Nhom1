/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import java.util.List;

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

    List<KhachHang> sreach(String tenKh);
}
