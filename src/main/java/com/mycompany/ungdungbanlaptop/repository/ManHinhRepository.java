/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import java.util.List;




/**
 *
 * @author vinhnv
 */

public interface ManHinhRepository {

    List<ManHinh> getAll();

    ManHinh add(ManHinh sanPham);

    ManHinh update(ManHinh sanPham);

    ManHinh delete(ManHinh sanPham);

    ManHinh getOne(String maMh);

    ManHinh getByTen(String ten);

}
