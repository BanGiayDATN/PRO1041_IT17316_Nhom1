/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import java.util.List;

/**
 *
 * @author Du
 */
public interface BaoHanhService {
    List<BaoHanh> getAll();
    
    String add(BaoHanh baohanh);
}
