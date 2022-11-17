/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.repository.ImeiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ImeiRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ImeiService;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

}
