/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.Mau;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface MauRepository {

    List<Mau> getAll();

    boolean addNew(Mau mau);

    boolean update(Mau mau);

    Mau getOne(String ma);

    Mau getByTen(String ten);
}
