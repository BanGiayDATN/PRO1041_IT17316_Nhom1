/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;


import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiViewModel;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author vinhnv
 */
public interface KhuyenMaiRepository {

    List<KhuyenMai> getALl();

    boolean add(KhuyenMai km);

    KhuyenMai update(KhuyenMai ma);
    
    KhuyenMai delete(KhuyenMai km);

    List<KhuyenMai> search(String km);

    List<KhuyenMai> searchNgayBd(Long km);

    KhuyenMai getOne(String ma);

}
