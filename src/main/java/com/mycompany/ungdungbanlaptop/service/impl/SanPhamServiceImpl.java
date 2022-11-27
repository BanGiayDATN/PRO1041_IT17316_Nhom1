/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.SanPhamRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.SanPhamService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Diệm DZ
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String add(SanPham sanPham) {
//        String ma = sanPhamRepository.getOne(sanPham.getMa()).getMa();
//        if(ma != null){
//            return "Mã đã tồn tại";
//        }
        if (sanPham.getMa().isEmpty()) {
            return "Vui lòng nhập mã";
        }
        if (sanPham.getMoTa().isEmpty()) {
            return "Vui lòng nhập mô tả";
        }
        if (sanPham.getTen().isEmpty()) {
            return "Vui lòng nhập tên";
        }

        SanPham add = sanPhamRepository.add(sanPham);
        if (add != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sanPham) {
        SanPham update = sanPhamRepository.update(sanPham);
        if (update != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(SanPham sanPham) {
        SanPham delete = sanPhamRepository.delete(sanPham);
        if (delete != null) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public SanPham getOne(String ma) {
        return sanPhamRepository.getOne(ma);
    }

    @Override
    public List<SanPham> search(List<SanPham> list, String maSp) {
        return sanPhamRepository.search(maSp);
    }

    @Override
    public List<SanPham> searchByTen(List<SanPham> list, String tenSp) {
        return sanPhamRepository.searchByTen(tenSp);
    }

    @Override
    public List<SanPham> searchFill(SanPhamSearchRequest request) {
        return sanPhamRepository.searchFill(request);
    }

    @Override
    public List<SanPhamBanHangViewModel> getSanPhamBanHang() {
        return sanPhamRepository.getSanPhamBanHang();
    }

    @Override
    public List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max) {
        return sanPhamRepository.getByGia(min, max);
    }

    @Override
    public List<SanPhamBanHangViewModel> searchByTenBanHang(List<SanPhamBanHangViewModel> list, String tenSp) {
        return sanPhamRepository.searchByTenBanHang(tenSp);

    }

    @Override
    public void updateSoLuongSanPham(Map<UUID, SanPham> list) {
        sanPhamRepository.updateSoLuongSanPham(list);
    }

    @Override
    public SanPham getById(UUID id) {
        return sanPhamRepository.getById(id);
    }

    @Override
    public List<SanPhamCustomRespone> getListSanPham() {
        return sanPhamRepository.getListSanPham();
    }
}
