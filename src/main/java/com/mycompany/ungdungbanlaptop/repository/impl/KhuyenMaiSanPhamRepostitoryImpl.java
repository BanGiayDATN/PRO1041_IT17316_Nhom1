/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMaiSanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamCustomRespone;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiSanPhamRepository;
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author thang
 */
public class KhuyenMaiSanPhamRepostitoryImpl implements KhuyenMaiSanPhamRepository{

    private SanPhamRepository SanPhamRepository = new SanPhamRepositoryImpl();
    
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
    
    
    @Override
    public boolean deleteKhuyenMaiById(String ma) {
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            String sql = """
                         DELETE FROM KhuyenMaiSanPham kmsp
                         Where kmsp.ma like :ma
                         """;
            Query query = session.createQuery(sql).setParameter("ma", ma);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean saveAllKhuyenMai(KhuyenMai khuyenMai,Map<UUID, SanPhamCustomRespone> list) {
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            for(SanPhamCustomRespone sanPham : list.values()){
                KhuyenMaiSanPham khuyenMaiSanPham = new KhuyenMaiSanPham();
                khuyenMaiSanPham.setKhuyenMai(khuyenMai);
                khuyenMaiSanPham.setSanPham(SanPhamRepository.getOne(sanPham.getMa()));
                khuyenMaiSanPham.setMa(khuyenMai.getMa());
                session.save(khuyenMaiSanPham);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
}
