/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.service.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRespository;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author HuynhPhung
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRespository ql = new KhuyenMaiRespository();

    @Override
    public List<KhuyenMai> getALl() {
        return ql.getAll();
    }

    @Override
    public String add(KhuyenMai km) {
        KhuyenMai check = ql.getOne(km.getMa());
        if (check != null) {
            return "Mã khuyến mại " + "'" + km.getMa() + "'" + " đã tồn tại";
        }

       
        if (km.getMa().isEmpty() || km.getMa().length()==0) {
            return "Mã không để trống, Vui lòng nhập mã khuyến mại";
        }
        
        if(km.getSoLuong()<0){
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

}
