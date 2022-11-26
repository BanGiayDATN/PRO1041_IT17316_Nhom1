/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.model.viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamCustomRespone {
    
    private UUID id;
    private String ma;
    private String ten;
    
    public String getTenSanPham(){
        return ma + "-"+ ten;
    }
}
