/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.entity.BaoHanhChiTiet;
import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMaiSanPham;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.Mau;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHeDieuHanh;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiKhuyenMai;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumLoaiRam;
import com.mycompany.ungdungbanlaptop.service.impl.LoginServiceImpl;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import com.mycompany.ungdungbanlaptop.util.HibernateUtil;
import static com.mycompany.ungdungbanlaptop.util.HibernateUtil.getConfiguration;
import java.math.BigDecimal;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author vinhnv
 */
public class GenDB {
    //Tạo DB trong SQL SERVER = SOFT2041_PTPM
    //Sau đó tiến hành chạy đển zen bảng

    public static void main(String[] args) {

        Properties prop = HibernateUtil.getProperties();
        prop.put(Environment.HBM2DDL_AUTO, "create");
        // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(prop)
                .build();

        // tạo lớp giao tiếp với jdbc
        Configuration conf = getConfiguration(prop);
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        // tạo giao dịch tương ứng 
        Transaction trans = session.beginTransaction();

//        Imei imei = new Imei();
//        imei.setMa(new TaoChuoiNgauNhien().getMkRanMa("", 3));
//        session.save(imei);
//
//        Imei imei1 = new Imei();
//        imei1.setMa(new TaoChuoiNgauNhien().getMkRanMa("", 3));
//        session.save(imei1);
//
//        Imei imei2 = new Imei();
//        imei2.setMa(new TaoChuoiNgauNhien().getMkRanMa("", 3));
//        session.save(imei2);
//
        Mau mauSac1 = new Mau();
        mauSac1.setMa(new TaoChuoiNgauNhien().getMkRanMa("#", 3));
        mauSac1.setTen("Red");
        session.save(mauSac1);

        Mau mauSac2 = new Mau();
        mauSac2.setMa(new TaoChuoiNgauNhien().getMkRanMa("#", 3));
        mauSac2.setTen("Yellow");
        session.save(mauSac2);

        Mau mauSac3 = new Mau();
        mauSac3.setMa(new TaoChuoiNgauNhien().getMkRanMa("#", 3));
        mauSac3.setTen("Blue");
        session.save(mauSac3);

        Mau mauSac4 = new Mau();
        mauSac4.setMa(new TaoChuoiNgauNhien().getMkRanMa("#", 3));
        mauSac4.setTen("Black");
        session.save(mauSac4);

        Mau mauSac5 = new Mau();
        mauSac5.setMa(new TaoChuoiNgauNhien().getMkRanMa("#", 3));
        mauSac5.setTen("White");
        session.save(mauSac5);

        Ram ram = new Ram();
        ram.setMa(new TaoChuoiNgauNhien().getMkRanMa("Ram", 4));
        ram.setTen("Static RAM");
        ram.setDungLuong(8);
        ram.setEnumLoaiRam(EnumLoaiRam.SDRAM);
        ram.setMegahertz(4266);
        session.save(ram);

        Ram ram1 = new Ram();
        ram1.setMa(new TaoChuoiNgauNhien().getMkRanMa("Ram", 4));
        ram1.setTen("RAM Laptop Kingston");
        ram1.setDungLuong(16);
        ram1.setEnumLoaiRam(EnumLoaiRam.DDR5);
        ram1.setMegahertz(4800);
        session.save(ram1);

        Ram ram2 = new Ram();
        ram2.setMa(new TaoChuoiNgauNhien().getMkRanMa("Ram", 4));
        ram2.setTen("RAM Kingston Fury Beast ");
        ram2.setDungLuong(16);
        ram2.setEnumLoaiRam(EnumLoaiRam.DDR4);
        ram2.setMegahertz(3200);
        session.save(ram2);

        Ram ram3 = new Ram();
        ram3.setMa(new TaoChuoiNgauNhien().getMkRanMa("Ram", 4));
        ram3.setTen("Ram DDR3 Server ECC");
        ram3.setDungLuong(32);
        ram3.setEnumLoaiRam(EnumLoaiRam.DDR3);
        ram3.setMegahertz(1866);
        session.save(ram3);

        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setTen("Nhựa");
        chatLieu.setMa(new TaoChuoiNgauNhien().getMkRanMa("CL", 3));
        session.save(chatLieu);

        ChatLieu chatLieu1 = new ChatLieu();
        chatLieu1.setTen("Kim loại");
        chatLieu1.setMa(new TaoChuoiNgauNhien().getMkRanMa("CL", 3));
        session.save(chatLieu1);

        ChatLieu chatLieu2 = new ChatLieu();
        chatLieu2.setTen("Nhôm");
        chatLieu2.setMa(new TaoChuoiNgauNhien().getMkRanMa("CL", 3));
        session.save(chatLieu2);

        CPU cpu = new CPU();
        cpu.setTen("Ryzen 5");
        cpu.setMa(new TaoChuoiNgauNhien().getMkRanMa(" AMD Ryzen", 3));
        session.save(cpu);

        CPU cpu1 = new CPU();
        cpu1.setTen("Core i5");
        cpu1.setMa(new TaoChuoiNgauNhien().getMkRanMa("Intel", 3));
        session.save(cpu1);

        CPU cpu2 = new CPU();
        cpu2.setTen("Core i7");
        cpu2.setMa(new TaoChuoiNgauNhien().getMkRanMa("Intel", 3));
        session.save(cpu2);

        CPU cpu3 = new CPU();
        cpu3.setTen("Core i9");
        cpu3.setMa(new TaoChuoiNgauNhien().getMkRanMa("Intel", 3));
        session.save(cpu3);

        ManHinh manHinh = new ManHinh();
        manHinh.setMa(new TaoChuoiNgauNhien().getMkRanMa("MH", 4));
        manHinh.setKichThuoc("	15.6 inch");
        manHinh.setLoaiCamUng("Không cảm ứng");
        manHinh.setDoPhanGiaMan("1920 x 1080 Pixels");
        manHinh.setTanSo("144 Hz");
        session.save(manHinh);

        ManHinh manHinh1 = new ManHinh();
        manHinh1.setMa(new TaoChuoiNgauNhien().getMkRanMa("MH", 4));
        manHinh1.setKichThuoc("	15.6 inch");
        manHinh1.setLoaiCamUng("Không cảm ứng");
        manHinh1.setDoPhanGiaMan("1920 x 1080 Pixels");
        manHinh1.setCongNgheMH("Anti-glare LED-backlit");
        manHinh1.setTanSo("144 Hz");
        session.save(manHinh1);

        ManHinh manHinh2 = new ManHinh();
        manHinh2.setMa(new TaoChuoiNgauNhien().getMkRanMa("MH", 4));
        manHinh2.setKichThuoc("	13.3 inch");
        manHinh2.setLoaiCamUng("Không cảm ứng");
        manHinh2.setDoPhanGiaMan("2560 x 1600 Pixels");
        manHinh2.setCongNgheMH("Retina");
        session.save(manHinh2);

        ManHinh manHinh3 = new ManHinh();
        manHinh3.setMa(new TaoChuoiNgauNhien().getMkRanMa("MH", 4));
        manHinh3.setKichThuoc("14.0 inch");
        manHinh3.setLoaiCamUng("Có cảm ứng");
        manHinh3.setDoPhanGiaMan("1920 x 1080 Pixels");
        manHinh3.setCongNgheMH("IPS LCD");
        manHinh3.setTanSo("144 Hz");
        session.save(manHinh3);

        HeDieuHanh dieuHanh = new HeDieuHanh();
        dieuHanh.setTen("Windows XP");
        dieuHanh.setMa(new TaoChuoiNgauNhien().getMkRanMa("HDH", 3));
        dieuHanh.setHeDieuHanh(EnumHeDieuHanh.WINDOWS);
        session.save(dieuHanh);

        HeDieuHanh dieuHanh1 = new HeDieuHanh();
        dieuHanh1.setTen("Windows 10");
        dieuHanh1.setMa(new TaoChuoiNgauNhien().getMkRanMa("HDH", 3));
        dieuHanh1.setHeDieuHanh(EnumHeDieuHanh.WINDOWS);
        session.save(dieuHanh1);

        HeDieuHanh dieuHanh2 = new HeDieuHanh();
        dieuHanh2.setTen("High Sierra");
        dieuHanh2.setMa(new TaoChuoiNgauNhien().getMkRanMa("HDH", 3));
        dieuHanh2.setHeDieuHanh(EnumHeDieuHanh.MACOS);
        session.save(dieuHanh2);

        HeDieuHanh dieuHanh3 = new HeDieuHanh();
        dieuHanh3.setTen("Linux Mint");
        dieuHanh3.setMa(new TaoChuoiNgauNhien().getMkRanMa("HDH", 3));
        dieuHanh3.setHeDieuHanh(EnumHeDieuHanh.LINUX);
        session.save(dieuHanh3);

        Hang hang = new Hang();
        hang.setTen("Asus");
        hang.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang);

        Hang hang1 = new Hang();
        hang1.setTen("Dell");
        hang1.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang1);

        Hang hang2 = new Hang();
        hang2.setTen("MSI");
        hang2.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang2);

        Hang hang3 = new Hang();
        hang3.setTen("Lenovo");
        hang3.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang3);

        Hang hang4 = new Hang();
        hang4.setTen("Razer");
        hang4.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang4);

        Hang hang5 = new Hang();
        hang5.setTen("Samsung");
        hang5.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
        session.save(hang5);

        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai.setTen("khuyến mãi tháng 1");
//        khuyenMai.setSoLuong(20);
        khuyenMai.setDieuKienGiamGia(new BigDecimal("1000"));
        khuyenMai.setLoaiKhuyenMai(EnumLoaiKhuyenMai.TIEN_MAT);
        khuyenMai.setTrangThai(0);
        khuyenMai.setHinhThuc(true);
        khuyenMai.setNgayBatDau(new ConverDate().dateToLong("01/01/2022", "dd/MM/yyyy"));
        khuyenMai.setNgayKetThuc(new ConverDate().dateToLong("01/05/2022", "dd/MM/yyyy"));
        khuyenMai.setPhanTram(10);
        session.save(khuyenMai);

        KhuyenMai khuyenMai1 = new KhuyenMai();
        khuyenMai1.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai1.setTen("Tháng đặc biệt");
        khuyenMai1.setSoLuong(10);
        khuyenMai1.setDieuKienGiamGia(new BigDecimal("1000"));
        khuyenMai1.setTrangThai(1);
        khuyenMai1.setHinhThuc(false);
        khuyenMai1.setLoaiKhuyenMai(EnumLoaiKhuyenMai.TIEN_MAT);
//        khuyenMai1.setNgayBatDau(new ConverDate().dateToLong("01/10/2022", "dd/MM/yyyy"));
//        khuyenMai1.setNgayKetThuc(new ConverDate().dateToLong("15/12/2022", "dd/MM/yyyy"));
        khuyenMai1.setPhanTram(20);
        session.save(khuyenMai1);

        KhuyenMai khuyenMai2 = new KhuyenMai();
        khuyenMai2.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai2.setSoLuong(10);
        khuyenMai2.setTen("2 năm");
        khuyenMai2.setHinhThuc(false);
        khuyenMai2.setLoaiKhuyenMai(EnumLoaiKhuyenMai.TIEN_MAT);
        khuyenMai2.setTrangThai(1);
//        khuyenMai2.setNgayBatDau(new ConverDate().dateToLong("01/04/2022", "dd/MM/yyyy"));
//        khuyenMai2.setNgayKetThuc(new ConverDate().dateToLong("01/08/2022", "dd/MM/yyyy"));
        khuyenMai2.setPhanTram(30);
        session.save(khuyenMai2);

        ChucVu chucVu = new ChucVu();
        chucVu.setMa(new TaoChuoiNgauNhien().getMkRanMa("NV", 3));
        chucVu.setTen("Nhân viên");
        session.save(chucVu);

        ChucVu chucVu1 = new ChucVu();
        chucVu1.setMa(new TaoChuoiNgauNhien().getMkRanMa("Adim", 1));
        chucVu1.setTen("Quản lý");
        session.save(chucVu1);

        NhanVien nhanVien = new NhanVien();
        nhanVien.setHoTen("Nguyễn Văn Vinh");
        nhanVien.setMa("Adim");
        nhanVien.setSdt("0987654321");
        nhanVien.setTrangThai(0);
        nhanVien.setPassword(new LoginServiceImpl().matKhauMD5("12345678"));
        nhanVien.setChucVu(chucVu1);
        nhanVien.setNgaySinh(new ConverDate().dateToLong("2000/06/01", "yyyy/MM/dd"));
        nhanVien.setGioiTinh("Nam");
        nhanVien.setDiaChi("Hà Nội");
        nhanVien.setEmail("vinhnvph23845@fpt.edu.vn");
        session.save(nhanVien);

        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setHoTen("Nguyễn Bình An");
        nhanVien1.setMa(new TaoChuoiNgauNhien().getMkRanMa("NV", 3));
        nhanVien1.setSdt("0987654321");
        nhanVien1.setTrangThai(0);
        nhanVien1.setPassword(new LoginServiceImpl().matKhauMD5("12345678"));
        nhanVien1.setChucVu(chucVu);
        nhanVien1.setNgaySinh(new ConverDate().dateToLong("2000/06/04", "yyyy/MM/dd"));
        nhanVien1.setGioiTinh("Nam");
        nhanVien1.setDiaChi("Hà Nội");
        nhanVien1.setEmail("anhvinh12a888@gmail.com");
        session.save(nhanVien1);

        KhachHang khachHang = new KhachHang();
        khachHang.setMa("KH001");
        khachHang.setHoTen("Hà Phương Na");
        khachHang.setNgaySinh(new ConverDate().dateToLong("2000/01/21", "yyyy/MM/dd"));
        khachHang.setSdt("0989999999");
        khachHang.setDiaChi("Hà Nội");
        khachHang.setGioiTinh("Nữ");
        khachHang.setTrangThai(0);
        khachHang.setEmail("anhvinh12a888@gmail.com");
        session.save(khachHang);

        KhachHang khachHang1 = new KhachHang();
        khachHang1.setMa(new TaoChuoiNgauNhien().getMkRanMa("KH", 3));
        khachHang1.setHoTen("Lò Thị Tòng");
        khachHang1.setNgaySinh(new ConverDate().dateToLong("2003/01/21", "yyyy/MM/dd"));
        khachHang1.setSdt("0123456789");
        khachHang1.setDiaChi("Ba Vi");
        khachHang1.setEmail("tonglo@gmail.com");
        khachHang1.setGioiTinh("Nữ");
        khachHang1.setTrangThai(0);
        session.save(khachHang1);

        SanPham sanPham = new SanPham();
        sanPham.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham.setTen("Laptop Gigabyte Gaming G5");
        sanPham.setTrongLuong((float) 2.2);
        sanPham.setSoLuongTon(25);
        sanPham.setGiaNhap(new BigDecimal(20000000.0));
        sanPham.setGiaBan(new BigDecimal(24000000.0));
        sanPham.setNamBH(2022);
        sanPham.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham.setManHinh(manHinh);
        sanPham.setCpu(cpu);
        sanPham.setMau(mauSac1);
        sanPham.setHeDieuHanh(dieuHanh);
        sanPham.setRam(ram);
        sanPham.setChatLieu(chatLieu);
        sanPham.setHang(hang);
        sanPham.setTrangThai(0);
        session.save(sanPham);

        SanPham sanPham1 = new SanPham();
        sanPham1.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham1.setTen("Laptop Asus TUF Gaming");
        sanPham1.setTrongLuong((float) 2.3);
        sanPham1.setSoLuongTon(25);
        sanPham1.setGiaNhap(new BigDecimal(1550000.0));
        sanPham1.setGiaBan(new BigDecimal(18490000.0));
        sanPham1.setNamBH(2022);
        sanPham1.setMoTa("Asus TUF Gaming F15 FX506LHB-HN188W là "
                + "chiếc laptop gaming giá rẻ với thiết kế tuyệt đẹp,"
                + " phong cách chuẩn game thủ và cấu hình mạnh mẽ cho cả học tập,"
                + " công việc cũng như chơi game. Bên cạnh đó là "
                + "độ bền chuẩn quân đội đã làm nên tên tuổi của dòng TUF.");
        sanPham1.setManHinh(manHinh);

        sanPham1.setCpu(cpu1);
        sanPham1.setMau(mauSac2);
        sanPham1.setHeDieuHanh(dieuHanh);
        sanPham1.setRam(ram2);
        sanPham1.setChatLieu(chatLieu);
        sanPham1.setHang(hang);
        sanPham1.setTrangThai(0);
        session.save(sanPham1);

        SanPham sanPham2 = new SanPham();
        sanPham2.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham2.setTen("Laptop Lenovo IdeaPad Gaming 3");
        sanPham2.setTrongLuong((float) 2.2);
        sanPham2.setSoLuongTon(25);
        sanPham2.setGiaNhap(new BigDecimal(45000000.0));
        sanPham2.setGiaBan(new BigDecimal(59900000.0));
        sanPham2.setNamBH(2022);
        sanPham2.setMoTa("Lenovo IdeaPad Gaming 3 15IAH7 là "
                + "đại diện tiêu biểu của một chiếc laptop chơi game"
                + " thế hệ mới với bộ vi xử lý Intel Gen 12 tối ưu cho gaming,"
                + " card đồ họa RTX 30 series chuyên dụng và công nghệ "
                + "làm mát mang tính cách mạng.");
        sanPham2.setManHinh(manHinh3);
        sanPham2.setCpu(cpu3);
        sanPham2.setMau(mauSac3);
        sanPham2.setHeDieuHanh(dieuHanh2);
        sanPham2.setRam(ram3);
        sanPham2.setChatLieu(chatLieu2);
        sanPham2.setHang(hang3);
        sanPham2.setTrangThai(0);
        session.save(sanPham2);

        SanPham sanPham3 = new SanPham();
        sanPham3.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham3.setTen("Laptop MSI Gaming Katana GF66");
        sanPham3.setTrongLuong((float) 2.25);
        sanPham3.setSoLuongTon(25);
        sanPham3.setGiaNhap(new BigDecimal(30000000.0));
        sanPham3.setGiaBan(new BigDecimal(34000000.0));
        sanPham3.setNamBH(2022);
        sanPham3.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham3.setManHinh(manHinh);
        sanPham3.setCpu(cpu);
        sanPham3.setMau(mauSac4);
        sanPham3.setHeDieuHanh(dieuHanh);
        sanPham3.setRam(ram);
        sanPham3.setChatLieu(chatLieu);
        sanPham3.setHang(hang);
        sanPham3.setTrangThai(0);
        session.save(sanPham3);
        
        SanPham sanPham4 = new SanPham();
        sanPham4.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham4.setTen("Laptop Asus TUF Gaming FX506");
        sanPham4.setTrongLuong((float) 2.4);
        sanPham4.setSoLuongTon(25);
        sanPham4.setGiaNhap(new BigDecimal(25000000.0));
        sanPham4.setGiaBan(new BigDecimal(31000000.0));
        sanPham4.setNamBH(2022);
        sanPham4.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích,  Asus TUF Gaming FX50 là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham4.setManHinh(manHinh1);
        sanPham4.setCpu(cpu1);
        sanPham4.setMau(mauSac2);
        sanPham4.setHeDieuHanh(dieuHanh1);
        sanPham4.setRam(ram2);
        sanPham4.setChatLieu(chatLieu1);
        sanPham4.setHang(hang1);
        sanPham4.setTrangThai(0);
        session.save(sanPham4);

        SanPham sanPham5 = new SanPham();
        sanPham5.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham5.setTen("Laptop Gigabyte Gaming G5 GD-51");
        sanPham5.setTrongLuong((float) 2.3);
        sanPham5.setSoLuongTon(25);
        sanPham5.setGiaNhap(new BigDecimal(2550000.0));
        sanPham5.setGiaBan(new BigDecimal(35490000.0));
        sanPham5.setNamBH(2022);
        sanPham5.setMoTa("Gigabyte Gaming G5 GD-51 là "
                + "chiếc laptop gaming giá rẻ với thiết kế tuyệt đẹp,"
                + " phong cách chuẩn game thủ và cấu hình mạnh mẽ cho cả học tập,"
                + " công việc cũng như chơi game. Bên cạnh đó là "
                + "độ bền chuẩn quân đội đã làm nên tên tuổi của dòng G5.");
        sanPham5.setManHinh(manHinh);

        sanPham5.setCpu(cpu1);
        sanPham5.setMau(mauSac2);
        sanPham5.setHeDieuHanh(dieuHanh);
        sanPham5.setRam(ram2);
        sanPham5.setChatLieu(chatLieu);
        sanPham5.setHang(hang);
        sanPham5.setTrangThai(0);
        session.save(sanPham5);

        SanPham sanPham6 = new SanPham();
        sanPham6.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham6.setTen("Laptop Lenovo IdeaPad Gaming 3");
        sanPham6.setTrongLuong((float) 2.5);
        sanPham6.setSoLuongTon(25);
        sanPham6.setGiaNhap(new BigDecimal(25000000.0));
        sanPham6.setGiaBan(new BigDecimal(34900000.0));
        sanPham6.setNamBH(2022);
        sanPham6.setMoTa("Laptop Lenovo IdeaPad Gaming 3 là "
                + "đại diện tiêu biểu của một chiếc laptop chơi game"
                + " thế hệ mới với bộ vi xử lý Intel Gen 12 tối ưu cho gaming,"
                + " card đồ họa RTX 30 series chuyên dụng và công nghệ "
                + "làm mát mang tính cách mạng.");
        sanPham6.setManHinh(manHinh2);
        sanPham6.setCpu(cpu1);
        sanPham6.setMau(mauSac3);
        sanPham6.setHeDieuHanh(dieuHanh3);
        sanPham6.setRam(ram2);
        sanPham6.setChatLieu(chatLieu1);
        sanPham6.setHang(hang4);
        sanPham6.setTrangThai(0);
        session.save(sanPham6);

        SanPham sanPham7 = new SanPham();
        sanPham7.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham7.setTen("Laptop MSI Gaming Katana GF66");
        sanPham7.setTrongLuong((float) 2.25);
        sanPham7.setSoLuongTon(25);
        sanPham7.setGiaNhap(new BigDecimal(30000000.0));
        sanPham7.setGiaBan(new BigDecimal(34000000.0));
        sanPham7.setNamBH(2022);
        sanPham7.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham7.setManHinh(manHinh);
        sanPham7.setCpu(cpu);
        sanPham7.setMau(mauSac4);
        sanPham7.setHeDieuHanh(dieuHanh);
        sanPham7.setRam(ram);
        sanPham7.setChatLieu(chatLieu);
        sanPham7.setHang(hang);
        sanPham7.setTrangThai(0);
        session.save(sanPham7);
        
        SanPham sanPham8 = new SanPham();
        sanPham8.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham8.setTen("Laptop Gigabyte Gaming G5");
        sanPham8.setTrongLuong((float) 2.2);
        sanPham8.setSoLuongTon(25);
        sanPham8.setGiaNhap(new BigDecimal(20000000.0));
        sanPham8.setGiaBan(new BigDecimal(24000000.0));
        sanPham8.setNamBH(2022);
        sanPham8.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham8.setManHinh(manHinh);
        sanPham8.setCpu(cpu);
        sanPham8.setMau(mauSac1);
        sanPham8.setHeDieuHanh(dieuHanh);
        sanPham8.setRam(ram);
        sanPham8.setChatLieu(chatLieu);
        sanPham8.setHang(hang);
        sanPham8.setTrangThai(0);
        session.save(sanPham8);

        SanPham sanPham9 = new SanPham();
        sanPham9.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham9.setTen("Laptop Asus TUF Gaming");
        sanPham9.setTrongLuong((float) 2.3);
        sanPham9.setSoLuongTon(25);
        sanPham9.setGiaNhap(new BigDecimal(1550000.0));
        sanPham9.setGiaBan(new BigDecimal(18490000.0));
        sanPham9.setNamBH(2022);
        sanPham9.setMoTa("Asus TUF Gaming F15 FX506LHB-HN188W là "
                + "chiếc laptop gaming giá rẻ với thiết kế tuyệt đẹp,"
                + " phong cách chuẩn game thủ và cấu hình mạnh mẽ cho cả học tập,"
                + " công việc cũng như chơi game. Bên cạnh đó là "
                + "độ bền chuẩn quân đội đã làm nên tên tuổi của dòng TUF.");
        sanPham9.setManHinh(manHinh);

        sanPham9.setCpu(cpu1);
        sanPham9.setMau(mauSac2);
        sanPham9.setHeDieuHanh(dieuHanh);
        sanPham9.setRam(ram2);
        sanPham9.setChatLieu(chatLieu);
        sanPham9.setHang(hang);
        sanPham9.setTrangThai(0);
        session.save(sanPham9);

        SanPham sanPham10 = new SanPham();
        sanPham10.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham10.setTen("Laptop Lenovo IdeaPad Gaming 3");
        sanPham10.setTrongLuong((float) 2.2);
        sanPham10.setSoLuongTon(25);
        sanPham10.setGiaNhap(new BigDecimal(45000000.0));
        sanPham10.setGiaBan(new BigDecimal(59900000.0));
        sanPham10.setNamBH(2022);
        sanPham10.setMoTa("Lenovo IdeaPad Gaming 3 15IAH7 là "
                + "đại diện tiêu biểu của một chiếc laptop chơi game"
                + " thế hệ mới với bộ vi xử lý Intel Gen 12 tối ưu cho gaming,"
                + " card đồ họa RTX 30 series chuyên dụng và công nghệ "
                + "làm mát mang tính cách mạng.");
        sanPham10.setManHinh(manHinh3);
        sanPham10.setCpu(cpu3);
        sanPham10.setMau(mauSac3);
        sanPham10.setHeDieuHanh(dieuHanh2);
        sanPham10.setRam(ram3);
        sanPham10.setChatLieu(chatLieu2);
        sanPham10.setHang(hang3);
        sanPham10.setTrangThai(0);
        session.save(sanPham10);

        SanPham sanPham11 = new SanPham();
        sanPham11.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham11.setTen("Laptop HP Pavilion 14 dv2036TU");
        sanPham11.setTrongLuong((float) 2.25);
        sanPham11.setSoLuongTon(25);
        sanPham11.setGiaNhap(new BigDecimal(30000000.0));
        sanPham11.setGiaBan(new BigDecimal(34000000.0));
        sanPham11.setNamBH(2022);
        sanPham11.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích,Laptop HP Pavilion 14 dv2036TU là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham11.setManHinh(manHinh);
        sanPham11.setCpu(cpu);
        sanPham11.setMau(mauSac4);
        sanPham11.setHeDieuHanh(dieuHanh);
        sanPham11.setRam(ram);
        sanPham11.setChatLieu(chatLieu);
        sanPham11.setHang(hang);
        sanPham11.setTrangThai(0);
        session.save(sanPham11);
        
        SanPham sanPham12 = new SanPham();
        sanPham12.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham12.setTen("Laptop Asus TUF Gaming FX517ZE-HN045W");
        sanPham12.setTrongLuong((float) 2.4);
        sanPham12.setSoLuongTon(25);
        sanPham12.setGiaNhap(new BigDecimal(25000000.0));
        sanPham12.setGiaBan(new BigDecimal(31000000.0));
        sanPham12.setNamBH(2022);
        sanPham12.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Laptop Asus TUF Gaming FX517ZE-HN045W là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham12.setManHinh(manHinh1);
        sanPham12.setCpu(cpu1);
        sanPham12.setMau(mauSac2);
        sanPham12.setHeDieuHanh(dieuHanh1);
        sanPham12.setRam(ram2);
        sanPham12.setChatLieu(chatLieu1);
        sanPham12.setHang(hang1);
        sanPham12.setTrangThai(0);
        session.save(sanPham12);

        SanPham sanPham13 = new SanPham();
        sanPham13.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham13.setTen("Laptop CHUWI GemiBook Pro");
        sanPham13.setTrongLuong((float) 2.3);
        sanPham13.setSoLuongTon(25);
        sanPham13.setGiaNhap(new BigDecimal(2550000.0));
        sanPham13.setGiaBan(new BigDecimal(35490000.0));
        sanPham13.setNamBH(2022);
        sanPham13.setMoTa("GLaptop CHUWI GemiBook Pro là "
                + "chiếc laptop gaming giá rẻ với thiết kế tuyệt đẹp,"
                + " phong cách chuẩn game thủ và cấu hình mạnh mẽ cho cả học tập,"
                + " công việc cũng như chơi game. Bên cạnh đó là "
                + "độ bền chuẩn quân đội đã làm nên tên tuổi của dòng GemiBook.");
        sanPham13.setManHinh(manHinh);

        sanPham13.setCpu(cpu1);
        sanPham13.setMau(mauSac2);
        sanPham13.setHeDieuHanh(dieuHanh);
        sanPham13.setRam(ram2);
        sanPham13.setChatLieu(chatLieu);
        sanPham13.setHang(hang);
        sanPham13.setTrangThai(0);
        session.save(sanPham13);
        
        //
        SanPham sanPham14= new SanPham();
        sanPham14.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham14.setTen("Laptop HP Envy 13 ba1537TU");
        sanPham14.setTrongLuong((float) 2.2);
        sanPham14.setSoLuongTon(25);
        sanPham14.setGiaNhap(new BigDecimal(20000000.0));
        sanPham14.setGiaBan(new BigDecimal(24000000.0));
        sanPham14.setNamBH(2022);
        sanPham14.setMoTa("HP Envy 13 ba1537TU là chiếc laptop doanh nhân tuyệt "
                + "vời trong tầm giá 20 triệu đồng. Không chỉ thời trang, "
                + "siêu nhỏ gọn, HP Envy 13 còn vô cùng mạnh mẽ và cao cấp tới "
                + "từng đường nét, thể hiện khí chất của riêng bạn.");
        sanPham14.setManHinh(manHinh);
        sanPham14.setCpu(cpu);
        sanPham14.setMau(mauSac1);
        sanPham14.setHeDieuHanh(dieuHanh);
        sanPham14.setRam(ram);
        sanPham14.setChatLieu(chatLieu);
        sanPham14.setHang(hang);
        sanPham14.setTrangThai(0);
        session.save(sanPham14);

        SanPham sanPham15 = new SanPham();
        sanPham15.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham15.setTen("Laptop Dell Vostro V3510 i5");
        sanPham15.setTrongLuong((float) 2.3);
        sanPham15.setSoLuongTon(25);
        sanPham15.setGiaNhap(new BigDecimal(1550000.0));
        sanPham15.setGiaBan(new BigDecimal(18490000.0));
        sanPham15.setNamBH(2022);
        sanPham15.setMoTa("Dell Vostro 3510 là phiên bản laptop doanh nhân 15,6 inch "
                + "mới nhất từ Dell, với thiết kế gọn gàng thanh thoát và hiện đại, "
                + "đồng thời hiệu suất được nâng cấp đáng kể nhờ bộ vi xử lý Intel Core i5 "
                + "thế hệ thứ 11 cùng card đồ họa rời NVIDIA MX350, giúp cho công việc của bạn"
                + " luôn hoạt động hiệu quả và an toàn.");
        sanPham15.setManHinh(manHinh);

        sanPham15.setCpu(cpu1);
        sanPham15.setMau(mauSac2);
        sanPham15.setHeDieuHanh(dieuHanh);
        sanPham15.setRam(ram2);
        sanPham15.setChatLieu(chatLieu);
        sanPham15.setHang(hang);
        sanPham15.setTrangThai(0);
        session.save(sanPham15);

        SanPham sanPham16 = new SanPham();
        sanPham16.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham16.setTen("Laptop Dell Inspiron 16 N5620");
        sanPham16.setTrongLuong((float) 2.2);
        sanPham16.setSoLuongTon(25);
        sanPham16.setGiaNhap(new BigDecimal(45000000.0));
        sanPham16.setGiaBan(new BigDecimal(59900000.0));
        sanPham16.setNamBH(2022);
        sanPham16.setMoTa("Dell Inspiron 16 5620 i5 1240P là một chiếc laptop "
                + "đồ họa vô cùng mạnh mẽ với chip xử lý Intel thế hệ thứ 12 kết hợp"
                + " 16GB RAM tốc độ cao và card rời GeForce MX570. Máy tính xách tay "
                + "cũng có màn hình lớn, kiểu dáng mỏng nhẹ và đa dạng cổng kết nối tích hợp.");
        sanPham16.setManHinh(manHinh3);
        sanPham16.setCpu(cpu3);
        sanPham16.setMau(mauSac3);
        sanPham16.setHeDieuHanh(dieuHanh2);
        sanPham16.setRam(ram3);
        sanPham16.setChatLieu(chatLieu2);
        sanPham16.setHang(hang3);
        sanPham16.setTrangThai(0);
        session.save(sanPham16);

        SanPham sanPham17 = new SanPham();
        sanPham17.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham17.setTen("Laptop Lenovo IdeaPad 5 Pro");
        sanPham17.setTrongLuong((float) 2.25);
        sanPham17.setSoLuongTon(25);
        sanPham17.setGiaNhap(new BigDecimal(30000000.0));
        sanPham17.setGiaBan(new BigDecimal(34000000.0));
        sanPham17.setNamBH(2022);
        sanPham17.setMoTa("Lenovo IdeaPad 5 Pro 16IAH7 cung cấp phương tiện "
                + "làm việc hiệu suất cao với bộ vi xử lý Intel Core i7 12700H"
                + " siêu mạnh và màn hình lớn 16 inch 2,5K 120Hz chuyên nghiệp,"
                + " xứng đáng là một chiếc laptop doanh nhân đẳng cấp.");
        sanPham17.setManHinh(manHinh);
        sanPham17.setCpu(cpu);
        sanPham17.setMau(mauSac4);
        sanPham17.setHeDieuHanh(dieuHanh);
        sanPham17.setRam(ram);
        sanPham17.setChatLieu(chatLieu);
        sanPham17.setHang(hang);
        sanPham17.setTrangThai(0);
        session.save(sanPham17);
        
        SanPham sanPham18 = new SanPham();
        sanPham18.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham18.setTen("Laptop Lenovo ThinkBook 15 ");
        sanPham18.setTrongLuong((float) 2.4);
        sanPham18.setSoLuongTon(25);
        sanPham18.setGiaNhap(new BigDecimal(25000000.0));
        sanPham18.setGiaBan(new BigDecimal(31000000.0));
        sanPham18.setNamBH(2022);
        sanPham18.setMoTa("Lenovo ThinkBook 15 Gen 2 là chiếc laptop"
                + " doanh nhân mạnh mẽ nhưng đầy phong cách. "
                + "Bên cạnh bộ vi xử lý thế hệ thứ 11 tiên tiến,"
                + " máy tính còn tích hợp những tính năng thông minh "
                + "để tối ưu hóa cho khả năng làm việc từ xa vốn đang "
                + "là xu hướng hiện nay.");
        sanPham18.setManHinh(manHinh1);
        sanPham18.setCpu(cpu1);
        sanPham18.setMau(mauSac2);
        sanPham18.setHeDieuHanh(dieuHanh1);
        sanPham18.setRam(ram2);
        sanPham18.setChatLieu(chatLieu1);
        sanPham18.setHang(hang1);
        sanPham18.setTrangThai(0);
        session.save(sanPham18);

        SanPham sanPham19 = new SanPham();
        sanPham19.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham19.setTen("Laptop Dell Gaming G15 5511");
        sanPham19.setTrongLuong((float) 2.3);
        sanPham19.setSoLuongTon(25);
        sanPham19.setGiaNhap(new BigDecimal(2550000.0));
        sanPham19.setGiaBan(new BigDecimal(35490000.0));
        sanPham19.setNamBH(2022);
        sanPham19.setMoTa("Dell G15 5511 i5 sử dụng card đồ họa NVIDIA GeForce RTX 3050 "
                + "được xây dựng trên kiến trúc NVIDIA Ampere – kiến trúc RTX thế "
                + "hệ thứ 2 của NVIDIA. Với các nhân RT, nhân Tensor mới và các bộ "
                + "xử lý đa luồng trực tuyến, giúp khả năng theo dõi tia và các tính "
                + "năng AI được đẩy lên một tầm cao mới. Các tựa game đều chơi mượt ở "
                + "mức đồ họa Full HD, hiệu ứng hình ảnh sống động, fps được duy trì ở"
                + " mức cao và ổn định.");
        sanPham19.setManHinh(manHinh);

        sanPham19.setCpu(cpu1);
        sanPham19.setHeDieuHanh(dieuHanh);
        sanPham19.setRam(ram2);
        sanPham19.setChatLieu(chatLieu);
        sanPham19.setHang(hang);
        sanPham19.setTrangThai(0);
        session.save(sanPham19);

        SanPham sanPham20 = new SanPham();
        sanPham20.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham20.setTen("Laptop Asus Vivobook D515DA-EJ1364W");
        sanPham20.setTrongLuong((float) 2.5);
        sanPham20.setSoLuongTon(25);
        sanPham20.setGiaNhap(new BigDecimal(25000000.0));
        sanPham20.setGiaBan(new BigDecimal(34900000.0));
        sanPham20.setNamBH(2022);
        sanPham20.setMoTa("VivoBook D515DA có vẻ ngoài vô cùng bắt mắt"
                + " với kiểu dáng gọn nhẹ, màn hình viền siêu mỏng và màu "
                + "bạc thời trang. Từ phần mặt lưng cho đến bàn phím, "
                + "chiếu nghỉ tay đều có màu bạc đồng bộ, trong khi đó"
                + " phần viền màn hình màu đen và logo ASUS tạo điểm nhấn.");
        sanPham20.setManHinh(manHinh2);
        sanPham20.setCpu(cpu1);
        sanPham20.setMau(mauSac3);
        sanPham20.setHeDieuHanh(dieuHanh3);
        sanPham20.setRam(ram2);
        sanPham20.setChatLieu(chatLieu1);
        sanPham20.setHang(hang4);
        sanPham20.setTrangThai(0);
        session.save(sanPham20);

        SanPham sanPham21 = new SanPham();
        sanPham21.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham21.setTen("Laptop MSI Gaming Katana GF66");
        sanPham21.setTrongLuong((float) 2.25);
        sanPham21.setSoLuongTon(25);
        sanPham21.setGiaNhap(new BigDecimal(30000000.0));
        sanPham21.setGiaBan(new BigDecimal(34000000.0));
        sanPham21.setNamBH(2022);
        sanPham21.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham21.setManHinh(manHinh);
        sanPham21.setCpu(cpu);
        sanPham21.setMau(mauSac4);
        sanPham21.setHeDieuHanh(dieuHanh);
        sanPham21.setRam(ram);
        sanPham21.setChatLieu(chatLieu);
        sanPham21.setHang(hang);
        sanPham21.setTrangThai(0);
        session.save(sanPham21);
        
        SanPham sanPham22 = new SanPham();
        sanPham22.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham22.setTen("Laptop HP Pavilion 14 dv2034TU");
        sanPham22.setTrongLuong((float) 2.2);
        sanPham22.setSoLuongTon(25);
        sanPham22.setGiaNhap(new BigDecimal(20000000.0));
        sanPham22.setGiaBan(new BigDecimal(24000000.0));
        sanPham22.setNamBH(2022);
        sanPham22.setMoTa("HP Pavilion 14 dv2034TU giúp bạn tự "
                + "tin hoàn thành bất kỳ mọi công việc được giao "
                + "nhờ bộ vi xử lý Intel Core i5 1235U mạnh mẽ."
                + " Đây là con chip thuộc thế hệ thứ 12 Alder Lake mới nhất,"
                + " có tới 10 nhân 12 luồng, trong đó 2 nhân P cực mạnh cùng "
                + "8 nhân E tiết kiệm năng lượng.");
        sanPham22.setManHinh(manHinh);
        sanPham22.setCpu(cpu);
        sanPham22.setMau(mauSac1);
        sanPham22.setHeDieuHanh(dieuHanh);
        sanPham22.setRam(ram);
        sanPham22.setChatLieu(chatLieu);
        sanPham22.setHang(hang);
        sanPham22.setTrangThai(0);
        session.save(sanPham22);

        SanPham sanPham23 = new SanPham();
        sanPham23.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham23.setTen("Laptop MSI Modern 14 B11MOU-1030VN");
        sanPham23.setTrongLuong((float) 2.3);
        sanPham23.setSoLuongTon(25);
        sanPham23.setGiaNhap(new BigDecimal(1550000.0));
        sanPham23.setGiaBan(new BigDecimal(18490000.0));
        sanPham23.setNamBH(2022);
        sanPham23.setMoTa("MSI Modern 14 B11MOU 1030VN là chiếc laptop "
                + "có thiết kế đẹp bậc nhất phân khúc với kiểu dáng hiện "
                + "đại và khả năng di động cao. Cấu hình của máy cũng đảm bảo hoạt "
                + "động mượt mà khi có sẵn tới 8GB RAM và ổ SSD đầy tốc độ.");
        sanPham23.setManHinh(manHinh);

        sanPham23.setCpu(cpu1);
        sanPham23.setMau(mauSac2);
        sanPham23.setHeDieuHanh(dieuHanh);
        sanPham23.setRam(ram2);
        sanPham23.setChatLieu(chatLieu);
        sanPham23.setHang(hang);
        sanPham23.setTrangThai(0);
        session.save(sanPham23);

        SanPham sanPham24 = new SanPham();
        sanPham24.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham24.setTen("Laptop MSI Gaming Katana GF66 ");
        sanPham24.setTrongLuong((float) 2.2);
        sanPham24.setSoLuongTon(25);
        sanPham24.setGiaNhap(new BigDecimal(45000000.0));
        sanPham24.setGiaBan(new BigDecimal(59900000.0));
        sanPham24.setNamBH(2022);
        sanPham24.setMoTa("Mạnh mẽ, sắc bén và cứng cáp như một thanh kiếm,"
                + " MSI Gaming Katana GF66 12UCK-805VN được tối ưu"
                + " hóa để giải phóng sức mạnh đỉnh cao trong mọi trò chơi."
                + " Bộ vi xử lý Intel Core i7 12650H, card đồ họa RTX 3050 và "
                + "bàn phím màu đỏ đậm phong cách giúp bạn luôn tỏa sáng trên chiến trường.");
        sanPham24.setManHinh(manHinh3);
        sanPham24.setCpu(cpu3);
        sanPham24.setMau(mauSac3);
        sanPham24.setHeDieuHanh(dieuHanh2);
        sanPham24.setRam(ram3);
        sanPham24.setChatLieu(chatLieu2);
        sanPham24.setHang(hang3);
        sanPham24.setTrangThai(0);
        session.save(sanPham24);

        KhuyenMaiSanPham khuyenMaiSanPham = new KhuyenMaiSanPham();
        khuyenMaiSanPham.setKhuyenMai(khuyenMai);
        khuyenMaiSanPham.setSanPham(sanPham);
        khuyenMaiSanPham.setMa(khuyenMai.getMa());
        session.save(khuyenMaiSanPham);

        KhuyenMaiSanPham khuyenMaiSanPham1 = new KhuyenMaiSanPham();
        khuyenMaiSanPham1.setKhuyenMai(khuyenMai);
        khuyenMaiSanPham1.setSanPham(sanPham2);
        khuyenMaiSanPham1.setMa(khuyenMai.getMa());
        session.save(khuyenMaiSanPham1);

        BaoHanh baoHanh = new BaoHanh();
        baoHanh.setMa(new TaoChuoiNgauNhien().getMkRanMa("BH", 3));
        baoHanh.setNgayBatDau(new ConverDate().dateToLong("01/08/2022", "dd/MM/yyyy"));
        baoHanh.setNgayKetThuc(new ConverDate().dateToLong("01/08/2023", "dd/MM/yyyy"));
        baoHanh.setMoTa("");
        baoHanh.setKhachHang(khachHang);
        baoHanh.setNhanVien(nhanVien1);
        session.save(baoHanh);

        BaoHanh baoHanh1 = new BaoHanh();
        baoHanh1.setMa(new TaoChuoiNgauNhien().getMkRanMa("BH", 3));
        baoHanh1.setNgayBatDau(new ConverDate().dateToLong("01/08/2022", "dd/MM/yyyy"));
        baoHanh1.setNgayKetThuc(new ConverDate().dateToLong("01/08/2023", "dd/MM/yyyy"));
        baoHanh1.setMoTa("");
        baoHanh1.setKhachHang(khachHang1);
        baoHanh1.setNhanVien(nhanVien1);
        session.save(baoHanh1);

        HoaDon hd = new HoaDon();
        hd.setKhachHang(khachHang1);
        hd.setNhanVien(nhanVien1);
        hd.setMa(new TaoChuoiNgauNhien().getMkRanMa("HD", 5));
        hd.setNgayTao(new ConverDate().dateToLong("2022/08/01", "yyyy/MM/dd"));
        hd.setNgayThanhToan(new ConverDate().dateToLong("2022/08/01", "yyyy/MM/dd"));
        hd.setNgayShip(new ConverDate().dateToLong("2022/08/02", "yyyy/MM/dd"));
        hd.setNgayNhan(new ConverDate().dateToLong("2022/08/04", "yyyy/MM/dd"));
        hd.setTinhTrang(0);
        hd.setTenNguoiNhan("Lương Bằng Huy");
        hd.setDiaChhi("Hà Nội");
        hd.setSdt("0087654321");
        hd.setKhuyenMai(khuyenMai);
        session.save(hd);

        HoaDon hd1 = new HoaDon();
        hd1.setKhachHang(khachHang);
        hd1.setNhanVien(nhanVien1);
        hd1.setMa(new TaoChuoiNgauNhien().getMkRanMa("HD", 5));
        hd1.setNgayTao(new ConverDate().dateToLong("2022/09/05", "yyyy/MM/dd"));
        hd1.setNgayThanhToan(new ConverDate().dateToLong("2022/09/05", "yyyy/MM/dd"));
        hd1.setNgayShip(new ConverDate().dateToLong("2022/09/06", "yyyy/MM/dd"));
        hd1.setNgayNhan(new ConverDate().dateToLong("2022/09/08", "yyyy/MM/dd"));
        hd1.setTinhTrang(0);
        hd1.setTenNguoiNhan("Dương Thắng");
        hd1.setDiaChhi("Hà Nội");
        hd1.setSdt("0962784188");
        session.save(hd1);

        HoaDon hd2 = new HoaDon();
        hd2.setKhachHang(khachHang);
        hd2.setNhanVien(nhanVien);
        hd2.setMa(new TaoChuoiNgauNhien().getMkRanMa("HD", 5));
        hd2.setNgayTao(new ConverDate().dateToLong("2022/08/22", "yyyy/MM/dd"));
        hd2.setNgayThanhToan(new ConverDate().dateToLong("2022/08/22", "yyyy/MM/dd"));
        hd2.setNgayShip(new ConverDate().dateToLong("2022/08/22", "yyyy/MM/dd"));
        hd2.setNgayNhan(new ConverDate().dateToLong("2022/08/22", "yyyy/MM/dd"));
        hd2.setTinhTrang(0);
        hd2.setTenNguoiNhan("Nguyễn Vinh");
        hd2.setDiaChhi("Hà Nội");
        hd2.setSdt("0962784188");
        session.save(hd2);

        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setHoaDon(hd);
        hdct.setSoLuong(1);
        hdct.setSanPham(sanPham);
        hdct.setDonGia(new BigDecimal(24000000.0));
        session.save(hdct);

        HoaDonChiTiet hdct1 = new HoaDonChiTiet();
        hdct1.setHoaDon(hd1);
        hdct1.setSoLuong(1);
        hdct1.setSanPham(sanPham1);
        hdct1.setDonGia(new BigDecimal(18490000.0));
        session.save(hdct1);
        
        BaoHanhChiTiet bhct = new BaoHanhChiTiet();
        bhct.setBaoHanh(baoHanh);
        bhct.setHoaDonChiTiet(hdct);
        bhct.setTrangThai("Con bao hanh");
        
        BaoHanhChiTiet bhct1 = new BaoHanhChiTiet();
        bhct1.setBaoHanh(baoHanh1);
        bhct1.setHoaDonChiTiet(hdct1);
        bhct1.setTrangThai("Con bao hanh");

        // db generator : gen bảng tự động
        trans.commit();
    }

}
