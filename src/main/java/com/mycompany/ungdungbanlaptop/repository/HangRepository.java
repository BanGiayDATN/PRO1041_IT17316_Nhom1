/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.Hang;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public interface HangRepository {

    List<Hang> getList();

    boolean insert(Hang hang);

    boolean update(Hang hang);

    Hang getByTen(String ten);

    Hang getOne(String ma);
}
