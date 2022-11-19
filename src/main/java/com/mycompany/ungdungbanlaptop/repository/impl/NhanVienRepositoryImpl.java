/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.repository.NhanVienRepository;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author vinhnv
 */
public class NhanVienRepositoryImpl implements NhanVienRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM NhanVien");
            list = query.getResultList();
            return list;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public NhanVien addNhanVien(NhanVien nhanVien) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;
    }

    @Override
    public NhanVien update(NhanVien nv) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public NhanVien delete(NhanVien nv) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public NhanVien getNhanVienByEmail(String email) {
        NhanVien nv = new NhanVien();
        try {
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.email = :email ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public NhanVien getNhanVienByEmailAndPass(String email, String password) {
        NhanVien nv = new NhanVien();
        try {
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.email = :email AND nv.password = :password";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            hth.setParameter("password", password);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public NhanVien getNhanVienByEmailAndSDT(String email, String sdt) {
        NhanVien nv = new NhanVien();
        try {
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.email = :email AND nv.sdt = :sdt ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("email", email);
            hth.setParameter("sdt", sdt);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public NhanVien getByTen(String ten) {
        NhanVien nv = new NhanVien();
        try {
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.hoTen = :hoTen ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("hoTen", ten);
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
    }

    @Override
    public List<NhanVien> getSearchByName(String hoTen) {
        List<NhanVien> list = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String query = "SELECT nv "
                    + "FROM NhanVien nv "
                    + "WHERE nv.hoTen LIKE :hoTen ";
            list = session.createQuery(query).setParameter("hoTen", "%" + hoTen + "%").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienRepositoryImpl().getSearchByName("nh");
        list.forEach(a->System.out.println(a));
    }
}
