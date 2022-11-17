/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRespository;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import java.util.List;

/**
 *
 * @author HuynhPhung
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService{
    private KhuyenMaiRespository ql = new KhuyenMaiRespository();
    @Override
    public List<KhuyenMai> getALl() {
        return ql.getAll();
    }

    @Override
    public String add(KhuyenMai km) {
        if(km.getMa().isEmpty() || String.valueOf(km.getNgayBatDau()).isEmpty()||String.valueOf(km.getNgayKetThuc()).isEmpty()||String.valueOf(km.getSoLuong()).isEmpty()){
            return "Không được để trống thông tin";
        }
        boolean add = ql.add(km);
        if(add){
            return "Thêm mã khuyến mại thành công";
        }
        return "Thêm mã khuyến mại thất bại";
    }

    @Override
    public String update(KhuyenMai km) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhuyenMai getOne(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
