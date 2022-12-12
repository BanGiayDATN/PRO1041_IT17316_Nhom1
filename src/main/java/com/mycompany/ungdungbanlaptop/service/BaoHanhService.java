/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Du
 */
public interface BaoHanhService {
    List<BaoHanh> getAll();
    
    String add(BaoHanh baohanh);
    
     BaoHanh getById( UUID id);
     
     BaoHanh getOne(String maBh);
     
     List<BaoHanh> searchByMa(String ma);
}
