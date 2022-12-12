/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.repository.ImeiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ImeiRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ImeiService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public class ImeiServiceImpl implements ImeiService {

    private ImeiRepository imeiRepository = new ImeiRepositoryImpl();

    @Override
    public List<Imei> getAll() {
        return imeiRepository.getAll();
    }

    @Override
    public String add(Imei imei) {
        Imei ma = imeiRepository.getOne(imei.getMa());
        if(ma != null){
            return "Đã tồn tại Imei này";
        }
        if(imei.getMa().isEmpty()){
            return "Vui lòng nhập mã Imei!";
        }
        if( 15> imei.getMa().length() || 15<imei.getMa().length() ){
            return "Imei phải là 15 kí tự!";
        }
       
        Imei add = imeiRepository.add(imei);
        if(add != null){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Imei imei) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(Imei imei) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Imei getOne(String ma) {
        return imeiRepository.getOne(ma);
    }

    @Override
    public long getImeiByIDHDCT(UUID idHDCT) {
        return imeiRepository.getImeiByIDHDCT(idHDCT);
    }

    @Override
    public List<HoaDonChiTiet> getByIDHDCT(String maHD) {
        return imeiRepository.getByIDHDCT(maHD);
       
    }

}
