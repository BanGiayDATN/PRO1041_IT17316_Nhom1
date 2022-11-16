/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import java.util.List;

/**
 *
 * @author Hoàng Ngô
 */
public interface GPMService {

    List<GPM> getAll();

    String addNew(GPM gpm);

    String update(GPM gpm);

    GPM getOne(String ma);

    GPM getByTen(String ten);
}
