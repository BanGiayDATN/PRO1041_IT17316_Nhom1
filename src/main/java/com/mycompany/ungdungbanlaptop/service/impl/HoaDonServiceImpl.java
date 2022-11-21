/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.repository.HoaDonRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.HoaDonRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HoaDonService;

/**
 *
 * @author thang
 */
public class HoaDonServiceImpl implements HoaDonService{

    private HoaDonRepository hoadonRepository = new HoaDonRepositoryImpl();
    
    @Override
    public HoaDon add(HoaDon hoaDon) {
       return hoadonRepository.add(hoaDon);
    }
    
}
