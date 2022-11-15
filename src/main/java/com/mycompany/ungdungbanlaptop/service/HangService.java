/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.Hang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface HangService {
    
    List<Hang> getList();
    
    String insert(Hang hang);
    
    String update(UUID id, Hang hang);
    
    Hang findById(String ma);
}
