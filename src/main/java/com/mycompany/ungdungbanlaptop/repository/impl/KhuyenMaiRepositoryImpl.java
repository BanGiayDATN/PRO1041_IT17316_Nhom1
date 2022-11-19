/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.KhuyenMaiViewModel;
import com.mycompany.ungdungbanlaptop.repository.KhuyenMaiRepository;
import com.mycompany.ungdungbanlaptop.service.KhuyenMaiService;
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
public class KhuyenMaiRepositoryImpl implements KhuyenMaiRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    @Override
    public List<KhuyenMai> getALl() {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
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
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
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
    public boolean update(KhuyenMai ma) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(ma);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;

    }

    @Override
    public List<KhuyenMai> search(String ma) {
        List<KhuyenMai> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ma like :ma ";
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
                    + "(km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ma like :ma";
            Query<KhuyenMai> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            km = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return km;
    }

   

    @Override
    public List<KhuyenMai> searchNgayBd(String ngayBatDau) {
        List<KhuyenMai> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ngayBatDau like :ngayBatDau ";
            Query query = session.createQuery(hql);

            query.setParameter("ma", "%" + ngayBatDau + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<KhuyenMai> searchNgayKt(String ngayKetThuc) {
        List<KhuyenMai> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.entity.KhuyenMai"
                    + "(km.ma,km.ngayBatDau,km.ngayKetThuc,km.trangThai,km.soLuong,km.phanTram) FROM KhuyenMai km WHERE km.ngayKetThuc like :ngayKetThuc ";
            Query query = session.createQuery(hql);

            query.setParameter("ma", "%" + ngayKetThuc + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

     public static void main(String[] args) {
//                KhuyenMai khuyenMai = new KhuyenMaiRepositoryImpl().getOne("KM111");
//                System.out.println(khuyenMai)
        KhuyenMai km = new KhuyenMai("KM777", 06/11/2022, 07/12/2022, 1, 50, 10);
        boolean add = new KhuyenMaiRepositoryImpl().add(km);
        System.out.println(add);
//        List<KhuyenMai> list = new KhuyenMaiRepositoryImpl().getALl();
//        System.out.println(list);
    }
}
