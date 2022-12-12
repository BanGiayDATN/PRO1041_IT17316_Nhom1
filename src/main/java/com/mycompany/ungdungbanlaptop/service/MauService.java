/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.Mau;
import java.util.List;

/**
 *
 * @author Hoàng Ngô
 */
public interface MauService {

    List<Mau> getAll();

    String addNew(Mau mau);

    String update(Mau mau);

    Mau getOne(String ma);

    Mau getByTen(String ten);
}
