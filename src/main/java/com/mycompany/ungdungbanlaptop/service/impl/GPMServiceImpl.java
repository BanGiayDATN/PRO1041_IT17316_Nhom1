/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.GPM;
import com.mycompany.ungdungbanlaptop.repository.GPMRepository;
import com.mycompany.ungdungbanlaptop.service.GPMService;
import java.util.List;

/**
 *
 * @author Hoàng Ngô
 */
public class GPMServiceImpl implements GPMService {

    private GPMRepository gpmRepo = new GPMRepository();

    @Override
    public List<GPM> getAll() {
        return gpmRepo.getAll();
    }

    @Override
    public String addGPM(GPM gpm) {
        if (gpm == null) {
            return "Thêm thất bại";
        }
        return "Thêm thành công";
    }

}
