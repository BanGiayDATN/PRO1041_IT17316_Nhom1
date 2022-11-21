/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class SanPhamRepositoryImpl implements SanPhamRepository {

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

    @Override
    public List<SanPham> search(String maSp) {
        List<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ma like :ma ";
            Query query = session.createQuery(hql);

            query.setParameter("ma", "%" + maSp + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<SanPham> searchByTen(String tenSp) {
        List<SanPham> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sp FROM SanPham sp WHERE sp.ten like :ten ";
            Query query = session.createQuery(hql);

            query.setParameter("ten", "%" + tenSp + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
//        SanPham sp = new SanPham(1, "MH3", "MSI", 100);
//        SanPham add = new SanPhamRepositoryImpl().add(sp);
//        System.out.println(add);
//        
//         SanPham delete = new SanPhamRepositoryImpl().delete(add);
//        System.out.println(delete);

//        System.out.println(new SanPhamRepositoryImpl().getAll());
        System.out.println(new SanPhamRepositoryImpl().getOne("SP3"));
    }

    @Override
    public void updateSoLuongSanPham(Map<UUID, SanPham> list) {
       Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            for(Map.Entry<UUID, SanPham> entry : list.entrySet()){
//                if (entry.getValue().getStatus() != 0) {
                    Query query = session.createQuery("UPDATE SanPham SET soLuongTon = :soLuong WHERE id = :id");
//                            setParameter("soLuong", entry.getValue().getSoLuongTon()).
//                            setParameter("id", entry.getValue().getIdChiTietSP());
                    query.executeUpdate();
//                }
            }
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
