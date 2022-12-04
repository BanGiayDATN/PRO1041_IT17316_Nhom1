/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.Date;
=======
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
>>>>>>> fd2951e2e0f49c1c610dbceed8407c70cd5441e2
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

<<<<<<< HEAD
<<<<<<< HEAD
    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);

=======
     List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);
     
=======
>>>>>>> develop
    List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngạyetThuc);

    List<HoaDonChiTietSanPham> getListHoaDonSanPham(String ma);

    List<HoaDonChiTiet> getAllByMa(String ma);

>>>>>>> fd2951e2e0f49c1c610dbceed8407c70cd5441e2
    List<GioHangViewModel> getGioHang(UUID idHoaDon);
<<<<<<< HEAD

    HoaDonChiTiet getById(UUID idHDCT);

    HoaDonChiTiet getByIdHoaDon(UUID idHD);

    BigDecimal tongDoanhThu();

    BigDecimal toDay(long toDay);

    BigDecimal theoKhoangNgay(long ngayBatDau, long ngayKetThuc);

    long soHoaDon(long ngayBatDau, long ngayKetThuc);

    long soHoaDonTong();
    
    
=======

    HoaDonChiTiet getById(UUID idHDCT);
>>>>>>> develop

}
