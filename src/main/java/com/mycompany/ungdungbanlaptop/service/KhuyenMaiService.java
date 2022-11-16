/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import java.util.List;

/**
 *
 * @author HuynhPhung
 */
public interface KhuyenMaiService {

    List<KhuyenMai> getALl();

    String add(KhuyenMai km);

    String update(KhuyenMai km);

    KhuyenMai getOne(String ma);

}
