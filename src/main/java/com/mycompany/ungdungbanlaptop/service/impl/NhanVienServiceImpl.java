/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.NhanVienRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.NhanVienRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.NhanVienService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();

    @Override
    public String addNhanVien(NhanVien nv) {
        // Muốn check gì thì check ở đây
        if(nv.getMa().isEmpty()){
            return "Vui lòng nhập mã";
        }
        if(nv.getDiaChi().isEmpty()){
            return "Vui lòng nhập địa chỉ";
        }
        if(nv.getEmail().isEmpty()){
            return "Vui lòng nhập email";
        }
        if(nv.getHoTen().isEmpty()){
            return "Vui lòng nhập họ tên";
        }
        if(nv.getPassword().isBlank()){
            return "Vui lòng nhập mật khẩu";
        }
        if(nv.getSdt().isEmpty()){
            return "Vui lòng nhập số điện thoại";
        }
        NhanVien add = nhanVienRepository.addNhanVien(nv);
        if (add == null) {
            return " Add thất bại";
        }
        return "Add thành công ";
    }

    ;

    @Override
    public String updateNhanVien(NhanVien nv) {
        // Muốn check gì thì check ở đây
           if(nv.getMa().isEmpty()){
            return "Vui lòng nhập mã";
        }
        if(nv.getDiaChi().isEmpty()){
            return "Vui lòng nhập địa chỉ";
        }
        if(nv.getEmail().isEmpty()){
            return "Vui lòng nhập email";
        }
        if(nv.getHoTen().isEmpty()){
            return "Vui lòng nhập họ tên";
        }
        if(nv.getPassword().isBlank()){
            return "Vui lòng nhập mật khẩu";
        }
       
        if(nv.getSdt().isEmpty()){
            return "Vui lòng nhập số điện thoại";
        }
        NhanVien add = nhanVienRepository.update(nv);
        if (add == null) {
            return " Sửa thất bại";
        }else{
            
        return "Sửa thành công ";
        }
    }

    @Override
    public String deleteNhanVien(NhanVien nv) {
      
        NhanVien add = nhanVienRepository.delete(nv);
        if (add == null) {
            return " Xóa thất bại";
        }
        return "Xóa thành công ";
    }

    @Override
    public NhanVien getNhanVienByEmail(String email) {
        return nhanVienRepository.getNhanVienByEmail(email);
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    public NhanVien getByTen(String ten) {
        return nhanVienRepository.getByTen(ten);
    }

    

    @Override
    public List<NhanVien> searchByEmail(List<NhanVien> list, String email) {
        return nhanVienRepository.searchByEmail(email);
    }

    


}
