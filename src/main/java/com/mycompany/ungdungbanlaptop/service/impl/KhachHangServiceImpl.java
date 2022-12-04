/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.model.resquest.KhachHangRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.KhachHangRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.KhachHangRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.KhachHangService;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Diệm DZ
 */
public class KhachHangServiceImpl implements KhachHangService {
      private String regexSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    private KhachHangRepository khachHangRepository = new KhachHangRepositoryImpl();

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public int add(KhachHangRequest khachHang) {
         String ma = "KH" + new TaoChuoiNgauNhien().getMkRanDum(5);
        String hoTen = khachHang.getHoTen().trim();
        String gioiTinh = khachHang.getGioiTinh().trim();
        String dateStr = khachHang.getNgaySinh();
        String sdt = khachHang.getSdt().trim();
        String email = khachHang.getEmail().trim();
        String diaChi = khachHang.getDiaChi().trim();
        
        if (ma.isBlank() || hoTen.isBlank() || dateStr == null || sdt.isBlank() || email.isBlank()
              || diaChi.isBlank() || gioiTinh.isBlank()) {
            return 1;

        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return 2;
        }
        if (!sdt.matches(regexSDT)) {
            return 3;
        }
        KhachHang checkTontai = khachHangRepository.getByEmail(email);
        if (checkTontai != null) {
            return 4;
        }
       
        KhachHang  kh = new KhachHang();
        kh.setEmail(khachHang.getEmail());
        kh.setMa(ma);
        kh.setDiaChi(khachHang.getDiaChi());
        kh.setGioiTinh(khachHang.getGioiTinh());
        kh.setNgaySinh(new ConverDate().dateToLong(dateStr, "yyyy/MM/dd"));
        kh.setSdt(khachHang.getSdt());
        kh.setHoTen(khachHang.getHoTen());
        kh.setTrangThai(khachHang.getTrangThai());
         KhachHang add = khachHangRepository.add(kh);
        if (add != null) {
            return 5;
        } else {
            return 6;
        }
        
        
       
        
       
    }

    @Override
    public String update(KhachHang khachHang) {
        KhachHang update = khachHangRepository.update(khachHang);
        if (update != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(KhachHang khachHang) {
        KhachHang delete = khachHangRepository.delete(khachHang);
        if (delete != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<KhachHang> search(List<KhachHang> list, String soDienThoai) {
        return khachHangRepository.sreach(soDienThoai);
    }

    @Override
    public KhachHang getByTen(String ten) {
        return khachHangRepository.getByTen(ten);
    }

    @Override
    public List<LichSuMuaHangViewModel> getLichSuMuaHang(String ma ) {
        return khachHangRepository.getLichSuMuaHang(ma);
    }

    @Override
    public KhachHang getBySoDienThoai(String soDienThoai) {
        return khachHangRepository.getBySoDienThoai(soDienThoai);
    }

    @Override
    public List<KhachHang> searchByHoTen(List<KhachHang> list, String hoTen) {
        return khachHangRepository.searchByHoTen(hoTen);
    }

    @Override
    public Long soLuotMua(String maKH) {
        return khachHangRepository.soLuotMua(maKH);
    }
}
