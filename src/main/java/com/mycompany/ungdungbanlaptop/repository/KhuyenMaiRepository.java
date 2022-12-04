/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;


import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiRespone;
import java.math.BigDecimal;
import java.util.List;



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
    
    List<KhuyenMaiRespone> listKhuyenMaiRespone();

    List<KhuyenMai> findAllKhuyenMaiByDieuKien(long ngayHienTai, BigDecimal dieuKien);
}
