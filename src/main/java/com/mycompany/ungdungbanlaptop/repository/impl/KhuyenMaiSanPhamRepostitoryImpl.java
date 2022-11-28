/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiSanPhamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author thang
 */
public class KhuyenMaiSanPhamRepostitoryImpl implements KhuyenMaiSanPhamRepository{

    @Override
    public List<SanPhamCustomRespone> findSanPhamById(String ma) {
        List<SanPhamCustomRespone> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = """
                         SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone
                         (kmsp.sanPham.id, kmsp.sanPham.ma,kmsp.sanPham.ten, kmsp.sanPham.soLuongTon, 
                         kmsp.sanPham.hang.ten, kmsp.sanPham.heDieuHanh.ten, 
                         kmsp.sanPham.ram.dungLuong  )
                         FROM KhuyenMaiSanPham kmsp
                         WHERE kmsp.khuyenMai.ma = :ma
                         """;
            Query query = session.createQuery(hql).setParameter("ma", ma);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public static void main(String[] args) {
        KhuyenMaiSanPhamRepostitoryImpl km = new KhuyenMaiSanPhamRepostitoryImpl();
        System.out.println(km.findSanPhamById("KM202"));
    }
    
}
