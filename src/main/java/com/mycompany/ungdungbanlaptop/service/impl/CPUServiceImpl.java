/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.model.viewModel.CPUViewModel;
import com.mycompany.ungdungbanlaptop.repository.CPURespository;
import com.mycompany.ungdungbanlaptop.repository.impl.CPURespositoryImpl;
import com.mycompany.ungdungbanlaptop.service.CPUService;
import java.util.List;

/**
 *
 * @author HuynhPhung
 */
public class CPUServiceImpl implements CPUService {

    private CPURespository cpuRespository = new CPURespositoryImpl();

    @Override
    public String add(CPU cpu) {

        CPU check = cpuRespository.getOne(cpu.getMa());
        if (check != null) {
            return "Trung ma";
        }
        if (cpu.getMa().isEmpty() || cpu.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean add = cpuRespository.add(cpu);
        if (add) {
            return " Add thanh cong";
        }
        return "Add that bai";
    }

    @Override
    public String update(CPU cpu) {
        String ma = cpu.getMa();
        if (cpu.getMa().isEmpty() || cpu.getTen().isEmpty()) {
            return "Không được để trống thông tin";
        }
        boolean update = cpuRespository.update(cpu);

        if (update) {
            return "Update thanh cong";
        }

        return "Update that bai";
    }

    @Override
    public CPU getOne(String ma) {
        return cpuRespository.getOne(ma);
    }

    @Override
    public List<CPUViewModel> getALl() {
        return cpuRespository.getAll();
    }

    @Override
    public CPU getByTen(String ten) {
        return cpuRespository.getByTen(ten);
    }

   

};
