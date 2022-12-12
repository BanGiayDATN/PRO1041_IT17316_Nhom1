/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface ImeiRepository {

    List<Imei> getAll();

    Imei add(Imei imei);

    Imei update(Imei imei);

    Imei delete(Imei imei);

    Imei getOne(String maImei);

    long getImeiByIDHDCT(UUID idHDCT);

    List<HoaDonChiTiet> getByIDHDCT(String maHD);
}
