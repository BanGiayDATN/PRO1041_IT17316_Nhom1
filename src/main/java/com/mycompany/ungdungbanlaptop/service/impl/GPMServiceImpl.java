
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.repository.GPMRepository;
import com.mycompany.ungdungbanlaptop.service.GPMService;
import java.util.List;


public class GPMServiceImpl implements GPMService {

    private GPMRepository gpmRepo = new GPMRepository();

    @Override
    public List<GPM> getAll() {
        return gpmRepo.getAll();
    }

    @Override
    public String addNew(GPM gpm) {
        GPM check = gpmRepo.getOne(gpm.getMa());
        if (check != null) {
            return "Mã GPM đã tồn tại";
        }
        if (gpm.getMa().isEmpty() || gpm.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean add = gpmRepo.addNew(gpm);
        if (add) {
            return " Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(GPM gpm) {
        String ma = gpm.getMa();
        if (gpm.getMa().isEmpty() || gpm.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean update = gpmRepo.update(gpm);
        if (update) {
            return "Update thành công";
        }

        return "Update thất bại";
    }

    @Override
    public GPM getOne(String ma) {
        return gpmRepo.getOne(ma);
    }

}
