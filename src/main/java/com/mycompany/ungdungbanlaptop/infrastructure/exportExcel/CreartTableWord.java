/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowHeightRule;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author vinhnv
 */
public class CreartTableWord {

    public static void main(String[] args) throws Exception {
        String imgFile = "D:\\DuAn1\\word\\1.jpg";
        String maHD = new TaoChuoiNgauNhien().getMaSanPham("HD", 3);
        word(maHD, imgFile);
    }

    public static boolean word(String maHoaDon, String maQRHoaDonChiTiet) {
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

            // tạo table
            XWPFTable table = doc.createTable();

            //Creating first Row
            XWPFTableRow row1 = table.getRow(0);
            row1.setHeight(50);
            row1.getCell(0).setText("STT");
            row1.addNewTableCell().setText("Tên sản phẩm");
            row1.addNewTableCell().setText("Số lượng");
            row1.addNewTableCell().setText("Đơn giá");
            row1.addNewTableCell().setText("Tổng tiền");
            
            XWPFTableRow rowTong = table.createRow();
            rowTong.getCell(4).setText("tong");

            XWPFParagraph p = doc.createParagraph();
            XWPFRun r = p.createRun();
            r.addBreak();

            // add png image
            try (FileInputStream is = new FileInputStream(maQRHoaDonChiTiet)) {
                r.addPicture(is,
                        Document.PICTURE_TYPE_PNG, // png file
                        maQRHoaDonChiTiet,
                        Units.toEMU(100),
                        Units.toEMU(100));
            }

            // xuất hóa đơn            
            try (FileOutputStream out = new FileOutputStream("D:\\DuAn1\\word\\" + maHoaDon + ".doc")) {
                doc.write(out);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }
}
