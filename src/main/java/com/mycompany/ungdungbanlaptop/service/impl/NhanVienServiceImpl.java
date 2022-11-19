/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.model.resquest.NhanVienResquest;
import com.mycompany.ungdungbanlaptop.repository.NhanVienRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.NhanVienRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.ChucVuService;
import com.mycompany.ungdungbanlaptop.service.NhanVienService;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author vinhnv
 */


public class NhanVienServiceImpl implements NhanVienService {

    private String regexSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    private NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();
    private ChucVuService chucVuService = new ChucVuServiceImpl();

    @Override
    public int addNhanVien(NhanVienResquest response) {
        String ma = "NV" + new TaoChuoiNgauNhien().getMkRanDum(5);
        String hoTen = response.getHoTen().trim();
        String gioiTinh = response.getGioiTinh().trim();
        String dateStr = response.getNgaySinh();
        String sdt = response.getSdt().trim();
        String email = response.getEmail().trim();
        String password = response.getPassword().trim();
        String diaChi = response.getDiaChi().trim();
        int trangThai = 0;
        if (ma.isBlank() || hoTen.isBlank() || dateStr == null || sdt.isBlank() || email.isBlank()
                || password.isBlank() || diaChi.isBlank() || gioiTinh.isBlank()) {
            return 1;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return 2;
        }
        if (!sdt.matches(regexSDT)) {
            return 3;
        }
        NhanVien checkTontai = nhanVienRepository.getNhanVienByEmail(email);
        if (checkTontai != null) {
            return 5;
        }
        if (password.length() < 8) {
            return 6;
        }
        ChucVu chucVu = chucVuService.getOneByName("Nhân viên");
        NhanVien nhanVien = new NhanVien();
        nhanVien.setEmail(response.getEmail());
        nhanVien.setMa(ma);
        nhanVien.setDiaChi(response.getDiaChi());
        nhanVien.setGioiTinh(response.getGioiTinh());
        nhanVien.setNgaySinh(new ConverDate().dateToLong(dateStr, "yyyy/MM/dd"));
        nhanVien.setPassword(matKhauMD5(response.getPassword())); // tạo mật khẩu mã hóa
        nhanVien.setSdt(response.getSdt());
        nhanVien.setHoTen(response.getHoTen());
        nhanVien.setTrangThai(response.getTrangThai());
        nhanVien.setChucVu(chucVu); // chua them chuc vu
        nhanVienRepository.addNhanVien(nhanVien);
        return 0;
    }

    ;

    @Override
    public int updateNhanVien(NhanVienResquest response) {
        String ma = response.getMa().trim();
        String hoTen = response.getHoTen().trim();
        String gioiTinh = response.getGioiTinh().trim();
        String dateStr = response.getNgaySinh();
        String sdt = response.getSdt().trim();
        String email = response.getEmail().trim();
        String password = response.getPassword().trim();
        String diaChi = response.getDiaChi().trim();
        int trangThai = response.getTrangThai();
        if (ma.isBlank() || hoTen.isBlank() || dateStr == null || sdt.isBlank() || email.isBlank()
                || password.isBlank() || diaChi.isBlank() || gioiTinh.isBlank()) {
            return 1;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return 2;
        }
        if (!sdt.matches(regexSDT)) {
            return 3;
        }

        if (password.length() < 8) {
            return 6;
        }
        ChucVu chucVu = chucVuService.getOneByName("Nhân viên");
        NhanVien nhanVien = nhanVienRepository.getNhanVienByMa(ma);
        System.out.println(nhanVien+"11111111111");
        nhanVien.setEmail(email);
        nhanVien.setMa(ma);
        nhanVien.setDiaChi(diaChi);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setNgaySinh(new ConverDate().dateToLong(dateStr, "yyyy/MM/dd"));
        nhanVien.setPassword(matKhauMD5(password)); // tạo mật khẩu mã hóa
        nhanVien.setSdt(sdt);
        nhanVien.setHoTen(hoTen);
        nhanVien.setTrangThai(trangThai);
        nhanVien.setChucVu(chucVu); // chua them chuc vu
        nhanVienRepository.update(nhanVien);
        return 0;
    }

    @Override
    public String deleteNhanVien(NhanVien nv) {
        // Muốn check gì thì check ở đây
        NhanVien add = nhanVienRepository.delete(nv);
        if (add == null) {
            return " Delete thất bại";
        }
        return "Delete thành công ";
    }

    @Override
    public NhanVien getNhanVienByEmail(String email) {
        return nhanVienRepository.getNhanVienByEmail(email);
    }

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public NhanVien getByTen(String ten) {
        return nhanVienRepository.getByTen(ten);
    }

    public static String matKhauMD5(String matKhau) {
        String md5Hex = DigestUtils.md5Hex(matKhau).toUpperCase();
        return md5Hex;
    }

    @Override
    public List<NhanVien> getSearchByName(String hoTen) {
        return nhanVienRepository.getSearchByName(hoTen);
    }

    @Override
    public NhanVien getNhanVienByMa(String ma) {
        return nhanVienRepository.getNhanVienByMa(ma);
    }
}
