/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.repository.RamRepository;
import com.mycompany.ungdungbanlaptop.repository.impl.RamRepositoryImpl;
import com.mycompany.ungdungbanlaptop.service.RamService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author thang
 */
public class RamServiceImpl implements RamService {

    private RamRepository ramRepository = new RamRepositoryImpl();

    @Override
    public List<Ram> getList() {
        return ramRepository.getList();
    }

    @Override
    public String insert(Ram ram) {
        if (ramRepository.insert(ram)) {
            return "thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public String update(UUID id, Ram ram) {
        Ram updateRam = ram;
        updateRam.setIdRam(id);
        if (ramRepository.update(updateRam)) {
            return "sửa thành công";
        } else {
            return "sửa thất bại";
        }
    }

    @Override
    public Ram findByMa(String ma) {
        return ramRepository.findByMa(ma);
    }

    @Override
    public Ram getByTen(String ten) {
        return ramRepository.getByTen(ten);
    }

    

}
