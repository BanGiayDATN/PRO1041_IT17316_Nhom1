/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import java.util.List;

/**
 *
 * @author Diệm DZ
 */
public interface ManHinhService {

    List<ManHinh> getAll();

    String add(ManHinh mh);

    String update(ManHinh mh);

    String delete(ManHinh mh);

    ManHinh getOne(String ma);

    ManHinh getByTen(String ten);
}
