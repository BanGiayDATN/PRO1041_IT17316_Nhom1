/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.model.resquest.SeachHoaDon;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonBanHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone;
import com.mycompany.ungdungbanlaptop.repository.HoaDonRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Override
    public List<HoaDonRespone> getAll(SeachHoaDon seachHoaDon) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(""" 
                                              SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone(hd.ma, hd.ngayTao, hd.nhanVien.ma, hd.nhanVien.hoTen, hd.khachHang.hoTen,hd.tinhTrang, SUM(hdct.soLuong), SUM(hdct.donGia))
                                              FROM HoaDon hd
                                              JOIN HoaDonChiTiet hdct ON hdct.hoaDon.id = hd.id
                                              WHERE (:ma IS NULL
                                                    OR :ma LIKE ''
                                                    OR hd.ma LIKE CONCAT('%',:ma,'%'))
                                              AND   (:ngayTao = 0L
                                                    OR hd.ngayTao = :ngayTao)
                                              AND   (:maNhanVien IS NULL
                                                    OR :maNhanVien LIKE ''
                                                     OR hd.nhanVien.ma = :maNhanVien)
                                              AND    (:tenNhanVien IS NULL
                                                      OR :tenNhanVien LIKE ''
                                                      OR hd.nhanVien.hoTen = :tenNhanVien)
                                              AND    (:tenKhachHang IS NULL
                                                       OR :tenKhachHang LIKE ''
                                                       OR hd.khachHang.hoTen = :tenKhachHang)
                                              GROUP BY hd.ma, hd.ngayTao, hd.nhanVien.ma, hd.nhanVien.hoTen, hd.khachHang.hoTen,hd.tinhTrang
                                              """).setParameter("ma", seachHoaDon.getMa())
                                                   .setParameter("ngayTao", seachHoaDon.getNgayTao())
                                                    .setParameter("maNhanVien", seachHoaDon.getMaNhanVien())
                                                    .setParameter("tenNhanVien", seachHoaDon.getTenNhanVien())
                                                    .setParameter("tenKhachHang",seachHoaDon.getTenKhachHang()); 
            List<HoaDonRespone> list = query.getResultList();

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
                    + " WHERE hd.tinhTrang = 0";
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
     public static void main(String[] args) {
    
        System.out.println(new HoaDonRepositoryImpl().getHoaDonBanHang());
    }
}

  





