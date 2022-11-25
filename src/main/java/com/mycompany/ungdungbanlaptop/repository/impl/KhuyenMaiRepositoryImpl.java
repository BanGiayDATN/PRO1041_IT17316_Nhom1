/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiRespone;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRepository;

/**
 *
 * @author huynhphung
 */
public class KhuyenMaiRepositoryImpl implements KhuyenMaiRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<KhuyenMai> getALl() {
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            //String ma, long ngayBatDau, long ngayKetThuc, int trangThai, int soLuong, int phanTram
            Query query = session.createQuery("SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km");
            List<KhuyenMai> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public boolean add(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(km);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public KhuyenMai update(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(km);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return km;
    }

    @Override
    public KhuyenMai delete(KhuyenMai km) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(km);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return km;
    }

    @Override
    public List<KhuyenMai> search(String ma) {
        List<KhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.idKhuyenMai,km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ma like :ma ";
            Query query = session.createQuery(hql);

            query.setParameter("ma", "%" + ma + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public KhuyenMai getOne(String ma) {
        Transaction transaction = null;
        KhuyenMai km = new KhuyenMai();
        try {
            String query = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.idKhuyenMai,km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ma like :ma";
            Query<KhuyenMai> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            km = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return km;
    }

    @Override
    public List<KhuyenMai> searchNgayBd(Long ngayBatDau) {
        List<KhuyenMai> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.idKhuyenMai,km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ngayBatDau >= :ngayBatDau ";
            Query query = session.createQuery(hql);

            query.setParameter("ngayBatDau", ngayBatDau);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<KhuyenMaiRespone> listKhuyenMaiRespone(String search) {
        List<KhuyenMaiRespone> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiRespone"
                    + "(km.idKhuyenMai,km.ma,km.ten,km.ngayBatDau,km.ngayKetThuc,km.loaiKhuyenMai,km.soLuong) "
                    + "FROM KhuyenMai km "
                    + "WHERE  (:search IS NULL \n"
                    + "                            OR :search LIKE '' \n"
                    + "                            OR km.ten LIKE CONCAT('%',:search,'%')) "
                    + " OR"
                    + " (:search IS NULL \n"
                    + "                            OR :search LIKE '' \n"
                    + "                            OR km.ma LIKE CONCAT('%',:search,'%'))";
            Query query = session.createQuery(hql);

            query.setParameter("search", search);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
