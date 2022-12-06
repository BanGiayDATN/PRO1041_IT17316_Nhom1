/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import com.mycompany.ungdungbanlaptop.model.resquest.SeachDoiTraRequest;
import com.mycompany.ungdungbanlaptop.repository.DoiTraRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.DoiTraRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.DoiTraService;
import java.util.List;

/**
 *
 * @author thang
 */
public class DoiTraServiceImpl implements DoiTraService{
    
    private DoiTraRepository doiTraRepository = new DoiTraRepositoryImpl();

    @Override
    public List<DoiTRa> getList(SeachDoiTraRequest request) {
        return doiTraRepository.getList(request);
    }
    
    
}
