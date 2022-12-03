/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiRespone;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.KhuyenMaiRepositoryImpl;

import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import java.util.List;


/**
 *
 * @author HuynhPhung
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepositoryImpl();

    @Override
    public List<KhuyenMai> getALl() {
        return khuyenMaiRepository.getALl();
    }

    @Override
    public String add(KhuyenMai km) {
        KhuyenMai check = khuyenMaiRepository.getOne(km.getMa());
        if (check != null) {
            return "Mã khuyến mại " + "'" + km.getMa() + "'" + " đã tồn tại";
        }

        if (km.getMa().isEmpty() || km.getMa().length() == 0) {
            return "Mã không để trống, Vui lòng nhập mã khuyến mại";
        }

        if (km.getSoLuong() < 0) {
            return "Số lượng phải lớn hơn 0";
        }
        boolean add = khuyenMaiRepository.add(km);
        if (add) {
            return "Thêm mã khuyến mại thành công";
        }
        return "Thêm mã khuyến mại thất bại";
    }

    @Override
    public KhuyenMai getOne(String ma) {
        return khuyenMaiRepository.getOne(ma);
    }

    @Override
    public List<KhuyenMai> search(List<KhuyenMai> list, String km) {
        return khuyenMaiRepository.search(km);
    }

    @Override
    public String update(KhuyenMai ma) {
        KhuyenMai up = khuyenMaiRepository.update(ma);
        if (up != null) {
            return "Sua thanh cong";
        }
        return "Sua that bai";

    }

    @Override
    public List<KhuyenMai> searchNgayBd(List<KhuyenMai> list, Long km) {
        return khuyenMaiRepository.searchNgayBd(km);
    }


    @Override
    public String delete(KhuyenMai km) {
        KhuyenMai getMa = khuyenMaiRepository.getOne(km.getMa());
        KhuyenMai delete = khuyenMaiRepository.delete(getMa);

        if (delete != null) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";

    }

    @Override
    public List<KhuyenMaiRespone> listKhuyenMaiRespone() {
        return  khuyenMaiRepository.listKhuyenMaiRespone();
    }
}
