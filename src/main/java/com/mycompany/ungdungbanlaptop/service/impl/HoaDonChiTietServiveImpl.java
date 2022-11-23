/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.HoaDonChiTietRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.HoaDonChiTietRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietServive;
import java.util.Map;
import java.util.UUID;


/**
 *
 * @author thang
 */
public class HoaDonChiTietServiveImpl implements HoaDonChiTietServive{
    
    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepositoryImpl();

    @Override
    public boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list) {
       return hoaDonChiTietRepository.saveAllHoaDonChiTiet(list);
    }
    
}
