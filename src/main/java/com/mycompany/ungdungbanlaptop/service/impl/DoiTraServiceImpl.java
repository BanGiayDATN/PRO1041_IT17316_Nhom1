/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import com.mycompany.ungdungbanlaptop.repository.DoiTraRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.DoiTraRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.DoiTraService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DoiTraServiceImpl implements DoiTraService{
    private DoiTraRepository doiTraRepo = new DoiTraRepositoryImpl();

    @Override
    public List<DoiTRa> gelAll() {
        return doiTraRepo.gelAll();
    }

    @Override
    public String add(DoiTRa doiTRa) {
        DoiTRa add = doiTraRepo.add(doiTRa);
        if(add != null){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }
    
}
