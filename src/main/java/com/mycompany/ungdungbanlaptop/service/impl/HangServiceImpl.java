/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.repository.HangRepository;
import com.mycompany.ungdungbanlaptop.service.HangService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public class HangServiceImpl implements HangService{

    private HangRepository hangRepository = new HangRepository();
    
    @Override
    public List<Hang> getList() {
        return hangRepository.getList();
    }

    @Override
    public String insert(Hang hang) {
        if(hangRepository.insert(hang)){
            return "Thêm mới thành công";
        }else{
            return "Thêm mới thất bại";
        }
    }

    @Override
    public String update(UUID id, Hang hang) {
        Hang updateHang = hang;
        updateHang.setIdChatLieu(id);
        if(hangRepository.update(updateHang)){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public Hang findById(String ma) {
        return hangRepository.findByMa(ma);
    }
    
}
