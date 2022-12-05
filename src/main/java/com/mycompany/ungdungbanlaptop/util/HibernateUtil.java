/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.util;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.entity.DoiTRa;
import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.Imei;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMaiSanPham;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 * @author thang
 */
public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Properties prop = getProperties();

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(prop).build();
        Configuration conf = getConfiguration(prop);
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");


        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=db_BanLaptop;encrypt=true;trustServerCertificate=true");
        properties.put(Environment.USER, ""); // nhớ thay tài khoản SQL
        properties.put(Environment.PASS, ""); // nhớ thay mật khẩu SQL

        properties.put(Environment.SHOW_SQL, "true");
        //gen DB tự động
//        properties.put(Environment.HBM2DDL_AUTO, "create");
        return properties;
    }

    public static Configuration getConfiguration(Properties prop) {
        Configuration conf = new Configuration();

        conf.setProperties(prop);
        conf.addAnnotatedClass(ChatLieu.class);
        conf.addAnnotatedClass(HeDieuHanh.class);
        conf.addAnnotatedClass(Ram.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(Imei.class);
        conf.addAnnotatedClass(ManHinh.class);
        conf.addAnnotatedClass(Mau.class);
        conf.addAnnotatedClass(CPU.class);
        conf.addAnnotatedClass(Hang.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(KhuyenMaiSanPham.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(DoiTRa.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(BaoHanh.class);
        conf.addAnnotatedClass(BaoHanhChiTiet.class);
        return conf;
    }
}
