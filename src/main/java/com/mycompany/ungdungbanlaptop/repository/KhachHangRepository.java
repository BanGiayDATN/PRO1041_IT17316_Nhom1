/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
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
public class KhachHangRepository {

    public List<KhachHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang");
            List<KhachHang> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public KhachHang add(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }

    public KhachHang update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(khachHang);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }

    public KhachHang delete(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    }

    public KhachHang getOne(String maKh) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.ma like :ma";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("ma", "%" + maKh + "%");
            KhachHang kh = query.uniqueResult();
            return kh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<KhachHang> sreach(String tenKh) {
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.hoTen like :hoTen";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("hoTen", "%" + tenKh + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
