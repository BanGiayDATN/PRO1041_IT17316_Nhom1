/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.repository.HeDieuHanhRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.HeDieuHanhRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.HeDieuHanhService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public class HeDieuHanhServiceImpl implements HeDieuHanhService {

    private HeDieuHanhRepository heDieuHanhRepository = new HeDieuHanhRepositoryImpl();

    @Override
    public List<HeDieuHanh> getList() {
        return heDieuHanhRepository.getList();
    }

    @Override
    public String insert(HeDieuHanh heDieuHanh) {
        if (heDieuHanhRepository.insert(heDieuHanh)) {
            return "thêm mới thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(UUID id, HeDieuHanh heDieuHanh) {
        HeDieuHanh updateHeDieuHanh = heDieuHanh;
        updateHeDieuHanh.setIdHeDieuHanh(id);
        if (heDieuHanhRepository.update(updateHeDieuHanh)) {
            return "update thành công";
        }
        return "update thất bại";
    }

    @Override
    public HeDieuHanh findById(String ma) {
        return heDieuHanhRepository.findByMa(ma);
    }

    @Override
    public HeDieuHanh getByTen(String ten) {
        return heDieuHanhRepository.getByTen(ten);
    }

    
}
