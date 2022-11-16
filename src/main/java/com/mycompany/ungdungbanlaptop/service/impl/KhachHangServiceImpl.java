/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.repository.KhachHangRepository;
import com.mycompany.ungdungbanlaptop.service.KhachHangService;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public String add(KhachHang khachHang) {
        KhachHang add = khachHangRepository.add(khachHang);
        if(add !=null){
            return "Thêm thành công";
        }else{
            return"Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang khachHang) {
        KhachHang update = khachHangRepository.update(khachHang);
        if(update !=null){
            return "Sửa thành công";
        }else{
            return"Sửa thất bại";
        }
    }

    @Override
    public String delete(KhachHang khachHang) {
        KhachHang delete = khachHangRepository.delete(khachHang);
        if(delete !=null){
            return "Sửa thành công";
        }else{
            return"Sửa thất bại";
        }
    }

    @Override
    public List<KhachHang> search(List<KhachHang> list, String tenKh) {
        return khachHangRepository.sreach(tenKh);
    }
    
}
