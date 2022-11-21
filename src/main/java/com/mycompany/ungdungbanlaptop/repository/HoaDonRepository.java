/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface HoaDonRepository {

    List<HoaDon> getAll();

    HoaDon add(HoaDon hoaDon);

    HoaDon update(HoaDon hoaDon);

    HoaDon delete(HoaDon hoaDon);

    HoaDon getOne(String maSp);
    
    boolean setTrangThai(UUID id, HoaDon hoaDon);
}
