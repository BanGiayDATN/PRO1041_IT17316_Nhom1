/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class HoaDonRepository {

    public List<HoaDon> getAll(){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM HoaDon");
            List<HoaDon> list = query.getResultList();
            
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public HoaDon add(HoaDon hoaDon){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }
    public HoaDon update(HoaDon hoaDon){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(hoaDon);
            transaction.commit();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }
    public HoaDon delete(HoaDon hoaDon){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }
    public HoaDon getOne(String maSp){
        
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            String hql = "SELECT hd FROM HoaDon hd WHERE hd.ma like :ma";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("ma", "%"+ maSp+ "%");
            HoaDon hd = query.uniqueResult();
            return hd;
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
//               long ngay = new ConverDate().dateToLong("21/11/2022", "dd/MM/yyyy");
//                long ngay1 = new ConverDate().dateToLong("21/11/2022", "dd/MM/yyyy");
//                 long ngay2 = new ConverDate().dateToLong("22/11/2022", "dd/MM/yyyy");
//                  long ngay3 = new ConverDate().dateToLong("23/11/2022", "dd/MM/yyyy");
//        HoaDon hd = new HoaDon("HD2", ngay, ngay1, ngay2, ngay3, 0, "Huỳnh", "Thái Bình", "0971833489",new KhachHang(UUID.fromString("c0a83801-847e-1400-8184-7e7403cd0000")));
//        System.out.println(new HoaDonRepository().add(hd));
//        System.out.println(new HoaDonRepository().getAll());
    }
}
