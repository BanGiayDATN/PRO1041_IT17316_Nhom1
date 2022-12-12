/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.repository.ChucVuRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.ChucVuRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ChucVuService;

/**
 *
 * @author vinhnv
 */
public class ChucVuServiceImpl implements ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepositoryImpl();

    @Override
    public ChucVu getOneByName(String name) {
        return chucVuRepository.getOneByeName(name);
    }
}
