/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.BaoHanhChiTietViewMoDel;
import com.mycompany.ungdungbanlaptop.repository.BaoHanhChiTietRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class BaohanhChiTietRepositoryImpl implements BaoHanhChiTietRepository{

    @Override
    public BaoHanhChiTiet add(BaoHanhChiTiet baoHanhChiTiet) {
         Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(baoHanhChiTiet);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return baoHanhChiTiet;
    }

    @Override
    public List<BaoHanhChiTietViewMoDel> getBHCT(String maBH) {
        List<BaoHanhChiTietViewMoDel> list = new ArrayList<>();
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.BaoHanhChiTietViewMoDel(bh.ma,bh.ngayBatDau,bh.ngayKetThuc,bhct.trangThai,bhct.hoaDonChiTiet)  FROM BaoHanh bh "
                    + " INNER JOIN BaoHanhChiTiet bhct"
                    + " ON bh.idBaoHanh = bhct.baoHanh.idBaoHanh"
                    + " WHERE bh.ma = :ma";
            Query<BaoHanhChiTietViewMoDel> query = session.createQuery(hql);
            query.setParameter("ma",maBH );
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(new BaohanhChiTietRepositoryImpl().getBHCT("BH70904"));
    }

    
}
