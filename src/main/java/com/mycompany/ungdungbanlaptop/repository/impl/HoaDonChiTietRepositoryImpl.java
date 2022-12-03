/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai;
import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham;
import com.mycompany.ungdungbanlaptop.repository.HoaDonChiTietRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.math.BigDecimal;
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
public class HoaDonChiTietRepositoryImpl implements HoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> getAll() {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" FROM HoaDonChiTiet");

            List<HoaDonChiTiet> list = query.getResultList();

            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }

    @Override
    public HoaDonChiTiet update(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(hoaDonChiTiet);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }

    @Override
    public HoaDonChiTiet delete(HoaDonChiTiet hoaDonChiTiet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hoaDonChiTiet);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoaDonChiTiet;
    }

    @Override
    public HoaDonChiTiet getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.idHoaDonChiTiet = :idHoaDonChiTiet";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idHoaDonChiTiet", id);
            HoaDonChiTiet hdct = query.uniqueResult();
            return hdct;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveAllHoaDonChiTiet(Map<UUID, GioHangViewModel> list) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            list.values().forEach(item -> {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setHoaDon(session.get(HoaDon.class, item.getIdHoaDon()));
                hoaDonChiTiet.setSanPham(session.get(SanPham.class, item.getIdSanPham()));
                hoaDonChiTiet.setDonGia(item.getDonGia());
                hoaDonChiTiet.setSoLuong(item.getSoLuong());
                session.save(hoaDonChiTiet);
            });
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        }

        return false;
    }

    @Override
    public List<HoaDonChiTietKhuyenMai> getListHoaDonApDungKhuyenMai(long ngayBatDau, long ngayketThuc) {
        List<HoaDonChiTietKhuyenMai> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietKhuyenMai( hd.hoaDon.ma, hd.sanPham.ten, hd.sanPham.hang.ten, hd.sanPham.ram.dungLuong , hd.sanPham.heDieuHanh.ten, hd.hoaDon.khachHang.hoTen, hd.hoaDon.khachHang.gioiTinh, hd.soLuong ) "
                    + " FROM  HoaDonChiTiet hd "
                    + " WHERE hd.hoaDon.ngayThanhToan BETWEEN :ngayBatDau AND :ngayKetThu";
            Query query = session.createQuery(hql).setParameter("ngayBatDau", Long.valueOf("1659286800000")).setParameter("ngayKetThu", Long.valueOf("9659286800000"));
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    @Override
    public List<HoaDonChiTietSanPham> getListHoaDonSanPham(String ma) {
        List<HoaDonChiTietSanPham> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham( hd.sanPham.ma,"
                    + " hd.sanPham.ten,"
                    + "hd.sanPham.ram.dungLuong,"
                    + "hd.sanPham.chatLieu.ten ,"
                    + "hd.sanPham.heDieuHanh.ten, "
                    + "hd.hoaDon.khachHang.hoTen,"
                    + " hd.soLuong) "
                    + " FROM  HoaDonChiTiet hd "
                    + " WHERE hd.hoaDon.ma = :ma";
            Query query = session.createQuery(hql).setParameter("ma",ma);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public List<HoaDonChiTiet> getWord(UUID idHoaDon) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.idHoaDon = :idHoaDon";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idHoaDon", idHoaDon);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> develop
  

    @Override
    public List<HoaDonChiTiet> getAllByMa(String ma) {
         try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" FROM HoaDonChiTiet hd where hd.hoaDon.ma = :ma ");
            query.setParameter("ma", ma);
            List<HoaDonChiTiet> list = query.getResultList();
            
            return list;
<<<<<<< HEAD
=======
=======

>>>>>>> develop

    @Override
    public List<GioHangViewModel> getGioHang(UUID idHoaDon) {
        List<GioHangViewModel> list = new ArrayList<>();
<<<<<<< HEAD
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel(hdct.idHoaDonChiTiet,sp.idSanPham,sp.ma,sp.ten,hdct.soLuong,hdct.donGia)"
                    + "FROM HoaDonChiTiet hdct"
=======

        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel(hdct.idHoaDonChiTiet,sp.idSanPham,sp.ma,sp.ten,hdct.soLuong,hdct.donGia) FROM HoaDonChiTiet hdct"
>>>>>>> develop
                    + " INNER JOIN SanPham sp"
                    + " ON sp.idSanPham = hdct.sanPham.idSanPham"
                    + " INNER JOIN HoaDon hd"
                    + " ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + " WHERE hd.idHoaDon = :idHoaDon";
            Query<GioHangViewModel> query = session.createQuery(hql);
            query.setParameter("idHoaDon", idHoaDon);
            list = query.getResultList();
<<<<<<< HEAD
            tran.commit();
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public HoaDonChiTiet getByIdSanPham(UUID idSanPham) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.sanPham.idSanPham = :idSanPham";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idSanPham", idSanPham);
            HoaDonChiTiet hdct = query.uniqueResult();
            return hdct;
>>>>>>> develop
=======
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public static void main(String[] args) {
//        System.out.println( new HoaDonChiTietRepositoryImpl().getGioHang());
    }

   

    @Override
    public HoaDonChiTiet getById(UUID idHDCT) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.idHoaDonChiTiet = :idHoaDonChiTiet";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idHoaDonChiTiet", idHDCT);
            HoaDonChiTiet hdct = query.uniqueResult();
            return hdct;

>>>>>>> develop
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
<<<<<<< HEAD
<<<<<<< HEAD
     public static void main(String[] args) {
        System.out.println(new HoaDonChiTietRepositoryImpl().getAllByMa("HD65877"));
        
    }
   
=======
>>>>>>> develop
=======

>>>>>>> develop
}
