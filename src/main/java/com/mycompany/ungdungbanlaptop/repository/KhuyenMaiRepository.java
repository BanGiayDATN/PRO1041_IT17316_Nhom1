/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;


import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiViewModel;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author vinhnv
 */
public interface KhuyenMaiRepository {

    List<KhuyenMai> getALl();

    boolean add(KhuyenMai km);

    boolean update(KhuyenMai ma);

    List<KhuyenMai> search(String km);

    List<KhuyenMai> searchNgayBd(String km);

    List<KhuyenMai> searchNgayKt(String km);

    KhuyenMai getOne(String ma);

}
