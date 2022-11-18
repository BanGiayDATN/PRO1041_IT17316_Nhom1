/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.infrastructure.SendEmail;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.model.response.NhanVienResquest;
import com.mycompany.ungdungbanlaptop.repository.NhanVienRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.NhanVienRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.LoginService;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author vinhnv
 */
public class LoginServiceImpl implements LoginService {

    private String regexSDT = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    private NhanVienRepository nhanVienRepository = new NhanVienRepositoryImpl();

    @Override
    public NhanVien login(String email, String password) {
        NhanVien nhanVien = new NhanVien();
        if (email.isBlank() || password.isBlank()) {
            return null;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return null;
        }
        nhanVien = nhanVienRepository.getNhanVienByEmailAndPass(email, matKhauMD5(password));
        if (nhanVien == null) {
            return null;
        }
        return nhanVien;
    }

    @Override
    public String quenMK(String email, String sdt) {
        if (email.isBlank() || sdt.isBlank()) {
            return "Không để trống ";
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return "Email sai định dạng ";
        }
        if (!sdt.matches(regexSDT)) {
            return "SĐT sai định dạng ";
        }
        NhanVien nhanVien = nhanVienRepository.getNhanVienByEmailAndSDT(email, sdt);
        if (nhanVien == null) {
            return "Tài khoản không tồn tại";
        }
        String matKhauMoi = new TaoChuoiNgauNhien().getMkRanDum(8);
        String maHoaMK = matKhauMD5(matKhauMoi);
        try {
            new SendEmail().guiMail(email, "Laptop", matKhauMoi);
        } catch (MessagingException ex) {
            Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        nhanVien.setPassword(maHoaMK);
        NhanVien nhanVienUpdate = nhanVienRepository.update(nhanVien);
        return "Gửi thành công";
    }

    @Override
    public int dangKy(NhanVienResquest response) {
        String ma = "NV" + new TaoChuoiNgauNhien().getMkRanDum(5);
        String hoTen = response.getHoTen().trim();
        String gioiTinh = response.getGioiTinh().trim();
        String dateStr = response.getNgaySinh();
        String sdt = response.getSdt().trim();
        String email = response.getEmail().trim();
        String password = response.getPassword().trim();
        String diaChi = response.getDiaChi().trim();
        int trangThai = 0;
        ChucVu chucVu = null;
        if (ma.isBlank() || hoTen.isBlank() || dateStr.isBlank() || sdt.isBlank() || email.isBlank()
                || password.isBlank() || diaChi.isBlank() || gioiTinh.isBlank()) {
            return 1;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return 2;
        }
        if (!sdt.matches(regexSDT)) {
            return 3;
        }
        if (!isValid(dateStr)) {
            return 4;
        }
        NhanVien checkTontai = nhanVienRepository.getNhanVienByEmail(email);
        if (checkTontai != null) {
            return 5;
        }
        if (password.length() < 8) {
            return 6;
        }

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
        nhanVien.setChucVu(null); // chua them chuc vu
        nhanVienRepository.addNhanVien(nhanVien);
        return 0;
    }

    public static boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String matKhauMD5(String matKhau) {
        String md5Hex = DigestUtils.md5Hex(matKhau).toUpperCase();
        return md5Hex;
    }

    @Override
    public NhanVien doiMK(String email, String password, String passwordMoi, String passwordNhapLai) {
        NhanVien nhanVien = new NhanVien();
        if (email.isBlank() || password.isBlank()) {
            return null;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            return null;
        }
        if (!passwordNhapLai.equals(passwordMoi)) {
            return null;
        }
        nhanVien = nhanVienRepository.getNhanVienByEmailAndPass(email, matKhauMD5(password));
        if (nhanVien == null) {
            return null;
        }
        String matKhauMoi = matKhauMD5(passwordMoi);
        nhanVien.setPassword(matKhauMoi);
        return nhanVien;
    }
}
