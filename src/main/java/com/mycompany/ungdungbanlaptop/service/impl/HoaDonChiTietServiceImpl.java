/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.repository.HoaDonChiTietRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.HoaDonChiTietRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonChiTietService;
import java.util.List;
/**
 *
 * @author Diệm DZ
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepositoryImpl();
    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.getAll();
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.add(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.update(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet) {
         return hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }
    
}
