/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import java.util.List;

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

    NhanVien getNhanVienByMa(String ma);

}
