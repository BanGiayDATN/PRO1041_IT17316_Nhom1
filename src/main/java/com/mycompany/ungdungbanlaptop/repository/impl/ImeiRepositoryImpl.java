/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.repository.ImeiRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class ImeiRepositoryImpl implements ImeiRepository {

    @Override
    public List<Imei> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Imei");
            List<Imei> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Imei add(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(imei);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return imei;
    }

    @Override
    public Imei update(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(imei);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return imei;
    }

    @Override
    public Imei delete(Imei imei) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(imei);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return imei;
    }

    @Override
    public Imei getOne(String maImei) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT i FROM Imei i WHERE i.ma like :ma";
            Query<Imei> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maImei + "%");
            Imei i = query.uniqueResult();
            return i;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public long getImeiByIDHDCT(UUID idHDCT) {
         long count = 0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(imei.ma) FROM Imei imei"
                    + " WHERE imei.hoaDonChiTiet.idHoaDonChiTiet = :idHoaDonChiTiet";
            Query query = session.createQuery(hql);
            query.setParameter("idHoaDonChiTiet", idHDCT);

            count = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    @Override
    public List<HoaDonChiTiet> getByIDHDCT(String maHD) {
          List<HoaDonChiTiet> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct"
                    + " WHERE hdct.hoaDon.ma = :ma AND hdct.idHoaDonChiTiet not in (SELECT imei.hoaDonChiTiet.idHoaDonChiTiet FROM Imei imei)";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("ma", maHD);
            list =  query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new ImeiRepositoryImpl().getByIDHDCT("HD837"));
    }
  
}
