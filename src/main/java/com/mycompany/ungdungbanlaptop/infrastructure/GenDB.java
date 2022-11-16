/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure;

import com.mycompany.ungdungbanlaptop.entity.BaoHanh;
import com.mycompany.ungdungbanlaptop.entity.CPU;
import com.mycompany.ungdungbanlaptop.entity.ChatLieu;
import com.mycompany.ungdungbanlaptop.entity.ChucVu;
import com.mycompany.ungdungbanlaptop.entity.Hang;
import com.mycompany.ungdungbanlaptop.entity.HeDieuHanh;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.entity.KhuyenMai;
import com.mycompany.ungdungbanlaptop.entity.ManHinh;
import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.entity.Ram;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.constant.EnumHeDieuHanh;
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

        // sản phẩm cáp sạc
        HeDieuHanh dieuHanh = new HeDieuHanh();
        dieuHanh.setTen(" Windows XP");
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

        // sản phẩm bàn phím
        Hang hang = new Hang();
        hang.setTen("Asus");
        hang.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang);

        Hang hang1 = new Hang();
        hang1.setTen("Dell");
        hang1.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang1);

        Hang hang2 = new Hang();
        hang2.setTen("MSI");
        hang2.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang2);

        Hang hang3 = new Hang();
        hang3.setTen("Lenovo");
        hang3.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang3);

        Hang hang4 = new Hang();
        hang4.setTen("Razer");
        hang4.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang4);

        Hang hang5 = new Hang();
        hang5.setTen("Samsung");
        hang5.setMa(new TaoChuoiNgauNhien().getMkRanMa("H", 3));
//        sanPham8.setIdSanPham(sanPham.getIdSanPham());
        session.save(hang5);

        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai.setSoLuong(10);
        khuyenMai.setTrangThai(0);
        khuyenMai.setNgayBatDau(new ConverDate().dateToLong("01/01/2022", "dd/MM/yyyy"));
        khuyenMai.setNgayKetThuc(new ConverDate().dateToLong("01/05/2022", "dd/MM/yyyy"));
        khuyenMai.setPhanTram(20);
        session.save(khuyenMai);

        KhuyenMai khuyenMai1 = new KhuyenMai();
        khuyenMai1.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai1.setSoLuong(10);
        khuyenMai1.setTrangThai(0);
        khuyenMai1.setNgayBatDau(new ConverDate().dateToLong("01/06/2022", "dd/MM/yyyy"));
        khuyenMai1.setNgayKetThuc(new ConverDate().dateToLong("15/10/2022", "dd/MM/yyyy"));
        khuyenMai1.setPhanTram(20);
        session.save(khuyenMai1);

        KhuyenMai khuyenMai2 = new KhuyenMai();
        khuyenMai2.setMa(new TaoChuoiNgauNhien().getMkRanMa("KM", 3));
        khuyenMai2.setSoLuong(10);
        khuyenMai2.setTrangThai(0);
        khuyenMai2.setNgayBatDau(new ConverDate().dateToLong("01/04/2022", "dd/MM/yyyy"));
        khuyenMai2.setNgayKetThuc(new ConverDate().dateToLong("01/08/2022", "dd/MM/yyyy"));
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
        nhanVien.setPassword( new LoginServiceImpl().matKhauMD5("12345678"));
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
        khachHang.setSdt("0962784188");
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
        sanPham.setGiaNhap(new BigDecimal(200000.0));
        sanPham.setGiaBan(new BigDecimal(240000.0));
        sanPham.setNamBH(2022);
        sanPham.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham.setManHinh(manHinh);
        sanPham.setCpu(cpu);
        sanPham.setGpm(null);
        sanPham.setHeDieuHanh(dieuHanh);
        sanPham.setRam(ram);
        sanPham.setKhuyenMai(khuyenMai);
        sanPham.setChatLieu(chatLieu);
        sanPham.setHang(hang);
        session.save(sanPham);

        SanPham sanPham1 = new SanPham();
        sanPham1.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham1.setTen("Laptop Asus TUF Gaming");
        sanPham1.setTrongLuong((float) 2.3);
        sanPham1.setSoLuongTon(25);
        sanPham1.setGiaNhap(new BigDecimal(15500.0));
        sanPham1.setGiaBan(new BigDecimal(184900.0));
        sanPham1.setNamBH(2022);
        sanPham1.setMoTa("Asus TUF Gaming F15 FX506LHB-HN188W là "
                + "chiếc laptop gaming giá rẻ với thiết kế tuyệt đẹp,"
                + " phong cách chuẩn game thủ và cấu hình mạnh mẽ cho cả học tập,"
                + " công việc cũng như chơi game. Bên cạnh đó là "
                + "độ bền chuẩn quân đội đã làm nên tên tuổi của dòng TUF.");
        sanPham1.setManHinh(manHinh);

        sanPham1.setCpu(cpu1);
        sanPham1.setGpm(null);
        sanPham1.setHeDieuHanh(dieuHanh);
        sanPham1.setRam(ram2);
        sanPham1.setKhuyenMai(khuyenMai2);
        sanPham1.setChatLieu(chatLieu);
        sanPham1.setHang(hang);
        session.save(sanPham1);

        SanPham sanPham2 = new SanPham();
        sanPham2.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham2.setTen("Laptop Lenovo IdeaPad Gaming 3");
        sanPham2.setTrongLuong((float) 2.2);
        sanPham2.setSoLuongTon(25);
        sanPham2.setGiaNhap(new BigDecimal(450000.0));
        sanPham2.setGiaBan(new BigDecimal(599000.0));
        sanPham2.setNamBH(2022);
        sanPham2.setMoTa("Lenovo IdeaPad Gaming 3 15IAH7 là "
                + "đại diện tiêu biểu của một chiếc laptop chơi game"
                + " thế hệ mới với bộ vi xử lý Intel Gen 12 tối ưu cho gaming,"
                + " card đồ họa RTX 30 series chuyên dụng và công nghệ "
                + "làm mát mang tính cách mạng.");
        sanPham2.setManHinh(manHinh3);
        sanPham2.setCpu(cpu3);
        sanPham2.setGpm(null);
        sanPham2.setHeDieuHanh(dieuHanh2);
        sanPham2.setRam(ram3);
        sanPham2.setKhuyenMai(khuyenMai1);
        sanPham2.setChatLieu(chatLieu2);
        sanPham2.setHang(hang3);
        session.save(sanPham2);

        SanPham sanPham3 = new SanPham();
        sanPham3.setMa(new TaoChuoiNgauNhien().getMkRanMa("SP", 3));
        sanPham3.setTen("Laptop MSI Gaming Katana GF66");
        sanPham3.setTrongLuong((float) 2.25);
        sanPham3.setSoLuongTon(25);
        sanPham3.setGiaNhap(new BigDecimal(200000.0));
        sanPham3.setGiaBan(new BigDecimal(240000.0));
        sanPham3.setNamBH(2022);
        sanPham3.setMoTa("Sở hữu những công nghệ mới nhất,"
                + " màn hình chơi game chuyên nghiệp và "
                + "đến từ một thương hiệu rất được các game "
                + "thủ yêu thích, Gigabyte Gaming G5 GD là "
                + "chiếc laptop gaming rất nổi bật trong tầm giá rẻ.");
        sanPham3.setManHinh(manHinh);
        sanPham3.setCpu(cpu);
        sanPham3.setGpm(null);
        sanPham3.setHeDieuHanh(dieuHanh);
        sanPham3.setRam(ram);
        sanPham3.setKhuyenMai(khuyenMai);
        sanPham3.setChatLieu(chatLieu);
        sanPham3.setHang(hang);
        session.save(sanPham3);

        BaoHanh baoHanh = new BaoHanh();
        baoHanh.setNgayBatDau(new ConverDate().dateToLong("01/08/2022", "dd/MM/yyyy"));
        baoHanh.setNgayKetThuc(new ConverDate().dateToLong("01/08/2023", "dd/MM/yyyy"));
        baoHanh.setMoTa("");
        baoHanh.setKhachHang(khachHang);
        baoHanh.setNhanVien(nhanVien1);
        session.save(baoHanh);
        
        BaoHanh baoHanh1 = new BaoHanh();
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
        hdct.setSanPham(sanPham3);
        hdct.setDonGia(new BigDecimal(240000.0));
        hdct.setBaoHanh(baoHanh);
        session.save(hdct);

        HoaDonChiTiet hdct1 = new HoaDonChiTiet();
        hdct1.setHoaDon(hd1);
        hdct.setSoLuong(1);
        hdct.setSanPham(sanPham1);
        hdct.setDonGia(new BigDecimal(184900.0));
        hdct.setBaoHanh(baoHanh);
        session.save(hdct1);
      
        // db generator : gen bảng tự động
        trans.commit();
    }

}