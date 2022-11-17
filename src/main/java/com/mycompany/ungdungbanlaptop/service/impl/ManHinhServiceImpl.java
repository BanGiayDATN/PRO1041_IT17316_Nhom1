/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.repository.ManHinhRepository;
import com.mycompany.ungdungbanlaptop.service.ManHinhService;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public class ManHinhServiceImpl implements ManHinhService{
    private ManHinhRepository hinhRepository = new ManHinhRepository();
    @Override
    public List<ManHinh> getAll() {
        return hinhRepository.getAll();
    }

    @Override
    public String add(ManHinh mh) {
        ManHinh add = hinhRepository.add(mh);
        if(add != null){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ManHinh mh) {
         ManHinh update = hinhRepository.update(mh);
        if(update != null){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(ManHinh mh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ManHinh getOne(String ma) {
        return hinhRepository.getOne(ma);
    }

    @Override
    public ManHinh getByTen(String ten) {
        return hinhRepository.getByTen(ten);
    }
    
}
