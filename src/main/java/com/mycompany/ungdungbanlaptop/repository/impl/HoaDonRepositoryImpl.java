/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.HoaDonRepository;
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
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Override
    public List<HoaDon> getAll() {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
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
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
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
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
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
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDon;
    }

    @Override
    public HoaDon getOne(String maHoaDon) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hd FROM HoaDon hd WHERE hd.ma = :ma";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("ma",  maHoaDon );
            HoaDon hd = query.uniqueResult();
            return hd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean setTrangThai(UUID id, HoaDon hoaDon) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            hoaDon.setIdHoaDon(id);
            session.update(hoaDon);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<HoaDonBanHangViewModel> getHoaDonBanHang() {
        List<HoaDonBanHangViewModel> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel(hd.id,hd.ma,hd.ngayTao,nv.hoTen,hd.tinhTrang) from HoaDon hd join NhanVien nv ON nv.idNhanVien = hd.nhanVien.idNhanVien"
                    + " WHERE hd.tinhTrang = 0";
            Query query = session.createQuery(hql);
            list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDonBanHangViewModel> getTrangThai(int trangThai) {
        List<HoaDonBanHangViewModel> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel(hd.ma,hd.ngayTao,nv.hoTen,hd.tinhTrang) from HoaDon hd join NhanVien nv ON nv.idNhanVien = hd.nhanVien.idNhanVien WHERE hd.tinhTrang = :tinhTrang";
            Query query = session.createQuery(hql);
            query.setParameter("tinhTrang", trangThai);
            list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDonBanHangViewModel> getHoaDonCho() {
        List<HoaDonBanHangViewModel> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel(hd.idHoaDon,hd.ma,hd.ngayTao,hd.khachHang.hoTen,hd.tinhTrang) "
                    + "FROM HoaDon hd "
                    + " WHERE hd.tinhTrang = 1";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }


    @Override
    public HoaDon getById(UUID id) {
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hd FROM HoaDon hd WHERE hd.idHoaDon = :idHoaDon";
            Query<HoaDon> query = session.createQuery(hql);
            query.setParameter("idHoaDon", id );
            HoaDon hd = query.uniqueResult();
            return hd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

  

}
