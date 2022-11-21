/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.repository.impl;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
<<<<<<< HEAD
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamSearchRequest;
=======
import com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel;
>>>>>>> develop
import com.mycompany.ungdungbanlaptop.repository.SanPhamRepository;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Diệm DZ
 */
public class SanPhamRepositoryImpl implements SanPhamRepository {

    private Session session = new HibernateUtil().getFACTORY().openSession();

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
<<<<<<< HEAD

    @Override
    public List<SanPham> searchFill(SanPhamSearchRequest request) {
        List<SanPham> list = new ArrayList<>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("""
                        FROM SanPham sp
                        WHERE  
                            (:ten IS NULL 
                            OR :ten LIKE '' 
                            OR sp.ten LIKE CONCAT('%',:ten,'%'))
                        AND
                            (:ma IS NULL 
                            OR :ma LIKE '' 
                            OR sp.ma LIKE CONCAT('%',:ma,'%'))
                        AND( 
                            :tenManHinh IS NULL 
                            OR  :tenManHinh LIKE ''
                            OR manHinh.ma LIKE CONCAT('%',:tenManHinh,'%')) 
                        AND
                            (:tenCpu IS NULL 
                            OR :tenCpu LIKE '' 
                            OR cpu.ten LIKE CONCAT('%',:tenCpu,'%'))
                        AND( 
                            :tenMau IS NULL 
                            OR  :tenMau LIKE ''
                            OR mau.ten LIKE CONCAT('%',:tenMau,'%'))                                        
                        AND
                            (:tenHeDieuHanh IS NULL 
                            OR :tenHeDieuHanh LIKE '' 
                            OR heDieuHanh.ten LIKE CONCAT('%',:tenHeDieuHanh,'%'))
                        AND( 
                            :tenRam IS NULL 
                            OR  :tenRam LIKE ''
                            OR ram.ten LIKE CONCAT('%',:tenRam,'%')) 
                        AND
                            (:tenChatLieu IS NULL 
                            OR :tenChatLieu LIKE '' 
                            OR chatLieu.ten LIKE CONCAT('%',:tenChatLieu,'%'))
                        AND( 
                            :tenHang IS NULL 
                            OR  :tenHang LIKE ''
                            OR hang.ten LIKE CONCAT('%',:tenHang,'%'))
                        AND( 
                            sp.namBH  = :namSX                          
                            OR  :namSX  = 0 )                      
                        AND( 
                            sp.trongLuong  = :trongLuong                          
                            OR  :trongLuong  = 0 )
                        AND( 
                            sp.soLuongTon  = :soLuong                          
                            OR  :soLuong  = 0 ) 
                        AND( 
                             sp.giaBan BETWEEN :startsGiaBan AND :giaBan                       
                             OR  :giaBan  < 0 ) 
                        """);
            query.setParameter("ten", request.getTen());
            query.setParameter("ma", request.getMa());
            query.setParameter("tenManHinh", request.getManHinh());
            query.setParameter("tenCpu", request.getTenCpu());
            query.setParameter("tenMau", request.getTenMau());
            query.setParameter("tenHeDieuHanh", request.getTenHeDieuHanh());
            query.setParameter("tenRam", request.getTenRam());
            query.setParameter("tenChatLieu", request.getTenChatLieu());
            query.setParameter("tenHang", request.getTenHang());
            query.setParameter("namSX", request.getNamSX());
            query.setParameter("trongLuong", request.getTrongLuong());
            query.setParameter("soLuong", request.getSoLuong());
            query.setParameter("startsGiaBan", request.getStartsGiaBan());
            query.setParameter("giaBan", request.getGiaBan());           
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public static void main(String[] args) {
        SanPhamSearchRequest request = new SanPhamSearchRequest();
        request.setStartsGiaBan(new BigDecimal(24000));
        request.setGiaBan(new BigDecimal(599000));
        List<SanPham> list = new SanPhamRepositoryImpl().searchFill(request);
        System.out.println(list.size());
=======
    @Override
    public List<SanPhamBanHangViewModel> getSanPhamBanHang() {
        List<SanPhamBanHangViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel(sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa) FROM SanPham sp";
            Query query = session.createQuery(hql);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     @Override
    public List<SanPhamBanHangViewModel> getByGia(BigDecimal min, BigDecimal max) {
        List<SanPhamBanHangViewModel> list ;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel(sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa) FROM SanPham sp WHERE sp.giaBan >= :min AND sp.giaBan <= :max";
            Query query = session.createQuery(hql);
            query.setParameter("min", min);
            query.setParameter("max", max);
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
        System.out.println(new SanPhamRepositoryImpl().getByGia(BigDecimal.valueOf(200000), BigDecimal.valueOf(500000)));
>>>>>>> develop
    }

    @Override
    public List<SanPhamBanHangViewModel> searchByTenBanHang(String tenSp) {
         List<SanPhamBanHangViewModel> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new com.mycompany.ungdungbanlaptop.model.viewModel.SanPhamBanHangViewModel(sp.ma,sp.ten,sp.namBH,sp.trongLuong,sp.soLuongTon,sp.giaBan,sp.moTa) FROM SanPham sp WHERE sp.ten like :ten";
            Query query = session.createQuery(hql);
            query.setParameter("ten","%"+ tenSp +"%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
}
