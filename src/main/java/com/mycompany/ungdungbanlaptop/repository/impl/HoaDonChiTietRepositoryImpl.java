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
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.text.NumberFormat;
import java.util.Locale;

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
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonChiTietSanPham( hd.sanPham.ma,"
                    + " hd.sanPham.ten,"
                    + "hd.sanPham.ram.dungLuong,"
                    + "hd.sanPham.chatLieu.ten ,"
                    + "hd.sanPham.heDieuHanh.ten, "
                    + "hd.hoaDon.khachHang.hoTen,"
                    + " hd.soLuong) "
                    + " FROM  HoaDonChiTiet hd "
                    + " WHERE hd.hoaDon.ma = :ma";
            Query query = session.createQuery(hql).setParameter("ma", ma);
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

    @Override
    public List<HoaDonChiTiet> getAllByMa(String ma) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(" FROM HoaDonChiTiet hd where hd.hoaDon.ma = :ma ");
            query.setParameter("ma", ma);
            List<HoaDonChiTiet> list = query.getResultList();

            return list;
        }
    }

    @Override
    public List<GioHangViewModel> getGioHang(UUID idHoaDon) {
        List<GioHangViewModel> list = new ArrayList<>();

        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.GioHangViewModel(hdct.idHoaDonChiTiet,sp.idSanPham,sp.ma,sp.ten,hdct.soLuong,hdct.donGia) FROM HoaDonChiTiet hdct"
                    + " INNER JOIN SanPham sp"
                    + " ON sp.idSanPham = hdct.sanPham.idSanPham"
                    + " INNER JOIN HoaDon hd"
                    + " ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + " WHERE hd.idHoaDon = :idHoaDon";
            Query<GioHangViewModel> query = session.createQuery(hql);
            query.setParameter("idHoaDon", idHoaDon);
            list = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    @Override
    public HoaDonChiTiet getById(UUID idHDCT) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.idHoaDonChiTiet = :idHoaDonChiTiet";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idHoaDonChiTiet", idHDCT);
            HoaDonChiTiet hdct = query.uniqueResult();
            return hdct;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public HoaDonChiTiet getByIdHoaDon(UUID idHD) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.idHoaDon = :idHoaDon";
            Query<HoaDonChiTiet> query = session.createQuery(hql);
            query.setParameter("idHoaDon", idHD);
            HoaDonChiTiet hdct = query.uniqueResult();
            return hdct;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public BigDecimal tongDoanhThu() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            BigDecimal tong;
            String hql = "SELECT SUM(hdct.soLuong*hdct.donGia) FROM HoaDonChiTiet hdct ";
            Query query = session.createQuery(hql);
            tong = (BigDecimal) query.uniqueResult();
            return tong;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public BigDecimal toDay(long toDay) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            BigDecimal tong;
            String hql = "SELECT SUM(hdct.soLuong*hdct.donGia) FROM HoaDonChiTiet hdct"
                    + " INNER JOIN HoaDon hd"
                    + " ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + " WHERE hd.ngayThanhToan = :toDay";
            Query query = session.createQuery(hql);
            query.setParameter("toDay", toDay);
            tong = (BigDecimal) query.uniqueResult();
            return tong;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public BigDecimal theoKhoangNgay(long ngayBatDau, long ngayKetThuc) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            BigDecimal tong;
            String hql = "SELECT SUM(hdct.soLuong*hdct.donGia) FROM HoaDonChiTiet hdct"
                    + " INNER JOIN HoaDon hd"
                    + " ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + " WHERE hd.ngayThanhToan BETWEEN :ngayBatDau AND :ngayKetThuc";
            Query query = session.createQuery(hql);
            query.setParameter("ngayBatDau", ngayBatDau);
            query.setParameter("ngayKetThuc", ngayKetThuc);
            tong = (BigDecimal) query.uniqueResult();
            return tong;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

   
    @Override
    public long soHoaDontheoKhoangNgay(long ngayBatDau, long ngayKetThuc) {
        long tong = 0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(hd.ma) FROM HoaDon hd"
                    + " WHERE hd.ngayThanhToan BETWEEN :ngayBatDau AND :ngayKetThuc";
            Query query = session.createQuery(hql);
            query.setParameter("ngayBatDau", ngayBatDau);
            query.setParameter("ngayKetThuc", ngayKetThuc);

            tong = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tong;

    }

    @Override
    public long soHoaDonTong() {
        long tong = 0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(hd.ma) FROM HoaDon hd";
            Query query = session.createQuery(hql);
            tong = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tong;
    }
    
     public static void main(String[] args) {
//        Locale localerEN = new Locale("en", "EN");
//        NumberFormat format = NumberFormat.getInstance(localerEN);
//        String i = format.format(new HoaDonChiTietRepositoryImpl().toDay(1659286800000l));
//        System.out.println(i);
//            System.out.println(new HoaDonChiTietRepositoryImpl().soHoaDontheoKhoangNgay(1659286800000l, 1661101200000l));
//            System.out.println(new HoaDonChiTietRepositoryImpl().soHoaDonTong());
 String date = new ConverDate().convertDateToString(new Date(), "dd/MM/yyyy");
        System.out.println(new HoaDonChiTietRepositoryImpl().soHoaDontheoNgay(new ConverDate().dateToLong(date, "dd/MM/yyyy")));
    }

    @Override
    public long soHoaDontheoNgay(long toDay) {
        long tong = 0;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(hd.ma) FROM HoaDon hd"
                    + " WHERE hd.ngayThanhToan = :toDay";
            Query query = session.createQuery(hql);
            query.setParameter("toDay", toDay);

            tong = (Long) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tong;
    }

}
