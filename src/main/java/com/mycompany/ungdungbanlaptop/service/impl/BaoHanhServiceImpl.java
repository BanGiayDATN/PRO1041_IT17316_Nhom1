/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.repository.BaoHanhRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.BaoHanhRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.BaoHanhService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Du
 */
public class BaoHanhServiceImpl implements BaoHanhService{
    private BaoHanhRepository ql = new BaoHanhRepositoryImpl();

    @Override
    public List<BaoHanh> getAll() {
       return ql.getAll();
    }

    @Override
    public String add(BaoHanh baohanh) {
        BaoHanh add = ql.add(baohanh);
        if(add != null){
            return "Tạo phiếu bảo hành thành công";
        }
            return "Tạo phiếu bảo hành thất bại";
    }

    @Override
    public BaoHanh getById(UUID id) {
        return ql.getById(id);
    }

    @Override
    public BaoHanh getOne(String maBh) {
        return ql.getOne(maBh);
    }
    
}
