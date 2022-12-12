/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.repository.ManHinhRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class ManHinhRepositoryImpl implements ManHinhRepository {

    @Override
    public List<ManHinh> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ManHinh");
            List<ManHinh> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ManHinh add(ManHinh sanPham) {
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
    public ManHinh update(ManHinh sanPham) {
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
    public ManHinh delete(ManHinh sanPham) {
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
    public ManHinh getOne(String maMh) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT mh FROM ManHinh mh WHERE mh.ma like :ma";
            Query<ManHinh> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maMh + "%");
            ManHinh mh = query.uniqueResult();
            return mh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ManHinh getByTen(String ten) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT mh FROM ManHinh mh WHERE mh.ten like :ten";
            Query<ManHinh> query = session.createQuery(hql);
            query.setParameter("ten", "%" + ten + "%");
            ManHinh mh = query.uniqueResult();
            return mh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
//        ManHinh mh = new ManHinh("MH3", "HD", "14 inch", "Cảm ứng", "120hz");
//        System.out.println(new ManHinhRepositoryImpl().add(mh));
    }
}
