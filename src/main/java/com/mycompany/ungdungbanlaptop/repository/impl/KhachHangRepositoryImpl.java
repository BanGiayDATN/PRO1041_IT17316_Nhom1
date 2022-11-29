/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel;
import com.mycompany.ungdungbanlaptop.repository.KhachHangRepository;
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
public class KhachHangRepositoryImpl implements KhachHangRepository {

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public KhachHang getByTen(String ten) {

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.hoTen like :hoTen ";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("hoTen", "%" + ten + "%");
            KhachHang kh = query.uniqueResult();
            return kh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<KhachHang> sreach(String soDienThoai) {
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.sdt like :sdt";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("sdt", "%" + soDienThoai + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }
     @Override
    public List<LichSuMuaHangViewModel> getLichSuMuaHang(String ma) {
        List<LichSuMuaHangViewModel> list = new ArrayList<>();
        try  (Session session = HibernateUtil.getFACTORY().openSession()){
            String hql ="SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.LichSuMuaHangViewModel(hd.ma,hdct.soLuong,hdct.donGia,hd.ngayTao,hd.ngayThanhToan,hd.tinhTrang) FROM HoaDonChiTiet hdct "
                    + "inner join HoaDon hd "
                    + "ON hd.idHoaDon = hdct.hoaDon.idHoaDon"
                    + " inner join KhachHang kh"
                    + " ON kh.idKhachHang = hd.khachHang.idKhachHang"
                    + " WHERE kh.ma like :ma";
            Query<LichSuMuaHangViewModel> query = session.createQuery(hql);
            query.setParameter("ma","%"+ ma+"%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    

    @Override
    public KhachHang getBySoDienThoai(String soDienThoai) {
        
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.sdt = :sdt";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("sdt", soDienThoai );
            KhachHang kh = query.uniqueResult();
            return kh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new KhachHangRepositoryImpl().getLichSuMuaHang("KH709"));
    }

    @Override
    public KhachHang getByEmail(String email) {
          try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.email = :email ";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("email",  email);
            KhachHang kh = query.uniqueResult();
            return kh;
        } catch (Exception e) {
            e.printStackTrace(System.out);
           
        }
        return null;
    }

    @Override
    public List<KhachHang>  searchByHoTen(String hoTen) {
          List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.hoTen like :hoTen";
            Query<KhachHang> query = session.createQuery(hql);
            query.setParameter("hoTen", "%" + hoTen + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
             e.printStackTrace(System.out);
        }
        return null;
    }
}
