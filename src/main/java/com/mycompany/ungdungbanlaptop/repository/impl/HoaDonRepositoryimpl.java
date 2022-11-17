/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.repository.HoaDonRepository;
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
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Override
    public List<HoaDon> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon");
            List<HoaDon> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public HoaDon add(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }

    @Override
    public HoaDon update(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(hoaDon);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }

    @Override
    public HoaDon delete(HoaDon hoaDon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }

    @Override
    public HoaDon getOne(String maSp) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hd FROM HoaDon hd WHERE hd.ma like :ma";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maSp + "%");
            HoaDon hd = query.uniqueResult();
            return hd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
