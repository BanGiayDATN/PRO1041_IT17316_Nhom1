package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.repository.MauRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.MauRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.MauService;
import java.util.List;

public class MauServiceImpl implements MauService {

    private MauRepository mauRepository = new MauRepositoryImpl();

    @Override
    public List<Mau> getAll() {
        return mauRepository.getAll();
    }

    @Override
    public String addNew(Mau gpm) {
        Mau check = mauRepository.getOne(gpm.getMa());
        if (check != null) {
            return "Mã GPM đã tồn tại";
        }
        if (gpm.getMa().isEmpty() || gpm.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean add = mauRepository.addNew(gpm);
        if (add) {
            return " Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(Mau mau) {
        String ma = mau.getMa();
        if (mau.getMa().isEmpty() || mau.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean update = mauRepository.update(mau);
        if (update) {
            return "Update thành công";
        }

        return "Update thất bại";
    }

    @Override
    public Mau getOne(String ma) {
        return mauRepository.getOne(ma);
    }

    @Override
    public Mau getByTen(String ten) {
        return mauRepository.getByTen(ten);
    }

}
