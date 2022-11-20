/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface NhanVienService {

    String addNhanVien(NhanVien nv);

    String updateNhanVien(NhanVien nv);

    String deleteNhanVien(NhanVien nv);

    NhanVien getNhanVienByEmail(String email);
    
    List<NhanVien> getAll();
    

    List<NhanVien> searchByEmail(List<NhanVien> list,String email);

    NhanVien getByTen(String ten);
    
    

}
