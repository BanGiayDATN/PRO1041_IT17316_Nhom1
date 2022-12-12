/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface RamService {
    
    List<Ram> getList();
    
    String insert(Ram ram);
    
    String update(UUID id, Ram ram);
    
    Ram findByMa(String ma);
    
    Ram getByTen(String ten);
    
    List<Ram> getSeachListRam(String ten, String dungLuong, EnumLoaiRam loaiRam);
    
}
