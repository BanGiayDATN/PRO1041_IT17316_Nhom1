/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiViewModel;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.KhuyenMaiRepositoryImpl;

import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.Validate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HuynhPhung
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepository ql = new KhuyenMaiRepositoryImpl();

    @Override
    public List<KhuyenMai> getALl() {
        return ql.getALl();
    }

    @Override
    public String add(KhuyenMai km) {
        KhuyenMai check = ql.getOne(km.getMa());
        if (check != null) {
            return "Mã khuyến mại " + "'" + km.getMa() + "'" + " đã tồn tại";
        }

        if (km.getMa().isEmpty() || km.getMa().length() == 0) {
            return "Mã không để trống, Vui lòng nhập mã khuyến mại";
        }

        if (km.getSoLuong() < 0) {
            return "Số lượng phải lớn hơn 0";
        }
        boolean add = ql.add(km);
        if (add) {
            return "Thêm mã khuyến mại thành công";
        }
        return "Thêm mã khuyến mại thất bại";
    }

    @Override
    public KhuyenMai getOne(String ma) {
        return ql.getOne(ma);
    }

    @Override
    public List<KhuyenMai> search(List<KhuyenMai> list, String km) {
        return ql.search(km);
    }

    @Override
    public String update(KhuyenMai ma) {
        boolean up = ql.update(ma);
        if (up) {
            return "Sua thanh cong";
        }
        return "Sua that bai";

    }

    @Override
    public List<KhuyenMai> searchNgayBd(List<KhuyenMai> list, String km) {
        return ql.searchNgayBd(km);
    }

    @Override
    public List<KhuyenMai> searchNgayKt(List<KhuyenMai> list, String km) {
        return ql.searchNgayKt(km);
    }

}
