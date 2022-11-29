/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.QRCode.GenerateQRCode;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.repository.impl.HoaDonChiTietRepositoryImpl;
import com.mycompany.ungdungbanlaptop.repository.impl.SanPhamRepositoryImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowHeightRule;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/**
 *
 * @author vinhnv
 */
public class CreartTableWord {

    public static void main(String[] args) throws Exception {
        SanPham sp = new SanPhamRepositoryImpl().getOne("SP308");
        System.out.println(sp.getIdSanPham());
        String ok = String.valueOf(sp.getIdSanPham());
        String maQRHoaDonChiTiet = new TaoChuoiNgauNhien().getMaHoaDon("HD", 5);
        new GenerateQRCode().CreateQRCode(ok, maQRHoaDonChiTiet);
        String maHD = new TaoChuoiNgauNhien().getMaSanPham("HD", 3);
        List<HoaDonChiTiet> list = new HoaDonChiTietRepositoryImpl().getAll();
//        word(maQRHoaDonChiTiet, maQRHoaDonChiTiet, list);
    }

    public static boolean word(String ngayThanhToan, String nguoiNhan,
            String maHoaDon, String maQRHoaDonChiTiet, List<HoaDonChiTiet> list) {
        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);

            // set font
            XWPFRun r1 = p1.createRun();
            r1.setBold(true);
            r1.setItalic(true);
            r1.setFontSize(22);
            r1.setFontFamily("New Roman");
            r1.setText("POST - Chuyên Laptop");
            r1.setText(ngayThanhToan);
            r1.setText(nguoiNhan);
            XWPFRun r2 = p1.createRun();
            r2.setBold(true);
            r2.setItalic(true);
            r2.setFontSize(16);
            r2.setFontFamily("New Roman");
            r2.setText(ngayThanhToan);
            XWPFRun r3 = p1.createRun();
            r3.setBold(true);
            r3.setItalic(true);
            r3.setFontSize(16);
            r3.setFontFamily("New Roman");
            r3.setText(nguoiNhan);
            
            
            // tạo table
            XWPFTable table = doc.createTable();
            CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
            width.setType(STTblWidth.DXA);
            width.setW(BigInteger.valueOf(9072));

            //Creating first Row
            XWPFTableRow row1 = table.getRow(0);
            row1.setHeight(50);
            row1.getCell(0).setText("STT");
            row1.addNewTableCell().setText("Tên sản phẩm");
            row1.addNewTableCell().setText("Số lượng");
            row1.addNewTableCell().setText("Đơn giá");
            row1.addNewTableCell().setText("Tổng tiền");
            double tong = 0;
            for (int i = 0; i < list.size(); i++) {
                XWPFTableRow row = table.createRow();
                row.setHeight(50);
                row.getCell(0).setText(String.valueOf(i + 1));
                row.getCell(1).setText(list.get(i).getSanPham().getTen());
                row.getCell(2).setText(String.valueOf(list.get(i).getSoLuong()));
                row.getCell(3).setText(String.valueOf(list.get(i).getDonGia()));
                row.getCell(4).setText(String.valueOf(list.get(i).getDonGia().multiply(BigDecimal.valueOf(list.get(i).getSoLuong()))));
                tong += Double.valueOf(list.get(i).getDonGia().multiply(BigDecimal.valueOf(list.get(i).getSoLuong())).toString());
            }
            
            XWPFTableRow rowTong = table.createRow();
            rowTong.getCell(3).setText("tong");
            rowTong.getCell(4).setText(String.valueOf(new BigDecimal(tong)));
            XWPFParagraph p = doc.createParagraph();
            XWPFRun r = p.createRun();
            r.addBreak();

            // add png image
            String path = new File("").getAbsolutePath()+"D:\\FPT POLYTECHNIC\\HocKy4-Summer2022\\Block2\\PRO1041_IT17346_Nhom1\\src\\main\\resources\\img"+maQRHoaDonChiTiet+".png";
            try (FileInputStream is = new FileInputStream(path)) {
                r.addPicture(is,
                        Document.PICTURE_TYPE_PNG, // png file
                        path,
                        Units.toEMU(100),
                        Units.toEMU(100));

            }
            String home = System.getProperty("user.home");
            // xuất hóa đơn            
            try (FileOutputStream out = new FileOutputStream(new File(home + "/Downloads/"+ maHoaDon + ".doc"))) {
                doc.write(out);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }
}
