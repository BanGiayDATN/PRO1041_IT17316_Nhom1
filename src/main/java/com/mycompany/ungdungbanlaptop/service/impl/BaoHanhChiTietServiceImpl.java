/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.repository.BaoHanhChiTietRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.BaohanhChiTietRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.BaoHanhChitietService;

/**
 *
 * @author Diệm DZ
 */
public class BaoHanhChiTietServiceImpl implements BaoHanhChitietService{
    private BaoHanhChiTietRepository baoHanhChiTietRepository = new BaohanhChiTietRepositoryImpl();
    @Override
    public String add(BaoHanhChiTiet baoHanhChiTiet) {
        BaoHanhChiTiet add = baoHanhChiTietRepository.add(baoHanhChiTiet);
        if(add !=null){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
        
    }
    
}
