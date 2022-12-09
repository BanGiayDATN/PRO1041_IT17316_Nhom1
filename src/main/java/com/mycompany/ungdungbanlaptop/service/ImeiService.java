/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.Imei;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public interface ImeiService {

    List<Imei> getAll();

    String add(Imei imei);

    String update(Imei imei);

    String delete(Imei imei);

    Imei getOne(String ma);

    long getImeiByIDHDCT(UUID idHDCT);

}
