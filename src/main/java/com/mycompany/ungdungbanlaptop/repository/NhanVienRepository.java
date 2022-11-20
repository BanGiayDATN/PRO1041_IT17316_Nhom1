/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface NhanVienRepository {
    List<NhanVien> getAll();

    NhanVien addNhanVien(NhanVien nhanVien);

    NhanVien update(NhanVien nv);

    NhanVien delete(NhanVien nv);

    NhanVien getNhanVienByEmail(String email);

    NhanVien getNhanVienByEmailAndPass(String email, String password);

    NhanVien getNhanVienByEmailAndSDT(String email, String sdt);

    NhanVien getByTen(String ten);
    
    List<NhanVien> searchByEmail(String email);
    
   
}
