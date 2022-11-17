/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface HeDieuHanhRepository {

    List<HeDieuHanh> getList();

    boolean insert(HeDieuHanh heDieuHanh);

    boolean update(HeDieuHanh heDieuHanh);

    HeDieuHanh findByMa(String ma);

    HeDieuHanh getByTen(String ten);
}
