/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietRespone;
import java.math.BigDecimal;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author vinhnv
 */
public interface HoaDonChiTietRepository {

    
   List<HoaDonChiTiet> getAll();

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet);

    HoaDonChiTiet getOne(UUID id);

    boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list);

    List<HoaDonChiTiet> getWord(UUID idHoaDon);

    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);

    List<HoaDonChiTietSanPham> getListHoaDonSanPham(String ma);

    List<HoaDonChiTiet> getAllByMa(String ma);

    List<GioHangViewModel> getGioHang(UUID idHoaDon);

    HoaDonChiTiet getById(UUID idHDCT);

    HoaDonChiTiet getByIdHoaDon(UUID idHD);

    HoaDonChiTiet getByIdSanPham(UUID idSP);

    BigDecimal tongDoanhThu();

    BigDecimal toDay(long toDay);

    BigDecimal theoKhoangNgay(long ngayBatDau, long ngayKetThuc);

    long soHoaDontheoKhoangNgay(long ngayBatDau, long ngayKetThuc);

    long soHoaDonTong();

    long soHoaDontheoNgay(long toDay);

    List<HoaDonChiTiet> getListByIdHoaDon(UUID idHD);

    List<HoaDonChiTietRespone> findHoaDonChiTietByMaHoaDon(String ma);

    List<HoaDonChiTiet> getHdctByHoaDon (String maHoaDon);
}
