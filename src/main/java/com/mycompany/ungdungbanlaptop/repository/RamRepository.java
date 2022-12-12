/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface RamRepository {

    List<Ram> getList();

    boolean insert(Ram ram);

    boolean update(Ram ram);

    Ram findByMa(String ma);

    Ram getByTen(String ten);
    
    List<Ram> getSeachListRam(String ten, String dungLuong, EnumLoaiRam loaiRam);
}
