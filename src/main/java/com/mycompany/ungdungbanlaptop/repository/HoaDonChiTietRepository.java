/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======

import java.util.Map;

>>>>>>> develop
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface HoaDonChiTietRepository {

    List<HoaDonChiTiet> getAll();

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet getOne(UUID id);

    boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list);
}
