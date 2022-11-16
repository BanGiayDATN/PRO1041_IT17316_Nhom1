/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public interface HeDieuHanhService {

    List<HeDieuHanh> getList();

    String insert(HeDieuHanh heDieuHanh);

    String update(UUID id, HeDieuHanh heDieuHanh);

    HeDieuHanh findById(String ma);

    HeDieuHanh getByTen(String ten);
}
