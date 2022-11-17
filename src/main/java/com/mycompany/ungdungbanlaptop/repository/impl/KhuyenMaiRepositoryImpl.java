/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class KhuyenMaiRepositoryImpl implements KhuyenMaiRepository {

    @Override
    public List<SanPham> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham");
            List<SanPham> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sanPham;
    }

    @Override
    public SanPham getOne(String maSp) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ma like :ma";
            Query<SanPham> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maSp + "%");
            SanPham sp = query.uniqueResult();
            return sp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
