/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class HoaDonChiTietRepository {
 
    public List<HoaDonChiTiet> getAll(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM SanPham");
            List<HoaDonChiTiet> list = query.getResultList();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(hoaDonChiTiet);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }
    public HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDonChiTiet);
            transaction.commit();
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }
//    public HoaDonChiTiet getOne(String maSp){
//        
//        try (Session session = HibernateUtil.getFACTORY().openSession()){
//            String hql = "SELECT sp FROM SanPham sp WHERE sp.ma like :ma";
//            Query<HoaDonChiTiet> query = session.createQuery(hql);
//            query.setParameter("ma", "%"+ maSp+ "%");
//            HoaDonChiTiet sp = query.uniqueResult();
//            return sp;
//        } catch (Exception e) {
//             e.printStackTrace(System.out);
//        }
//        return null;
//    }
    public static void main(String[] args) {
//        HoaDonChiTiet hdct = new HoaDonChiTiet(1, BigDecimal.valueOf(Double.valueOf(2000)), new HoaDon(UUID.fromString("c0a83801-847e-19b9-8184-7ea9be380000")));
        System.out.println(new HoaDonChiTietRepository().getAll());
    }
}
