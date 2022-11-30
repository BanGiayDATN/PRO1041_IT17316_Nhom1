/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.mycompany.ungdungbanlaptop.entity.HoaDon;
import com.mycompany.ungdungbanlaptop.entity.HoaDonChiTiet;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vinhnv
 */
public class GeneratePdf {

    public static final String pathUnicode = "font\\unicode.ttf";
    public static final String home = System.getProperty("user.home");

    public void exportBill(String nameFile, String maQRHoaDonChiTiet, HoaDon hoaDon, List<HoaDonChiTiet> list) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a zzz dd-MM-yyyy");
            String date = sdf.format(new Date());
            String path = new File(home + "/Downloads/" + nameFile) + ".pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            float col = 280f;
            float columWidth[] = {col, col};
            
            ImageData imageData = ImageDataFactory.create(
                    new File("").getAbsolutePath() + "//src//main//resources//img//" + maQRHoaDonChiTiet + ".png");
            Image img = new Image(imageData);
            img.setHeight(40f);
            img.setWidth(40f);
            
            PdfFont font = PdfFontFactory.createFont(pathUnicode, BaseFont.IDENTITY_H);

            Table table = new Table(columWidth);
            table.setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE);
            table.setFont(font);

            table.addCell(new Cell().add("POST - Chuyên Laptop ").setTextAlignment(TextAlignment.CENTER)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setFontSize(27f)
                    .setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(" \n Mã hóa đơn: " + hoaDon.getMa() + "\n POST - Laptop" ).setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));
            table.addCell(new Cell().add(img).setTextAlignment(TextAlignment.RIGHT)
                    .setMarginTop(30f)
                    .setMarginBottom(30f)
                    .setBorder(Border.NO_BORDER)
                    .setMarginRight(10f));

            float colWidth[] = {80, 250, 200, 200};
            Table customerInforTable = new Table(colWidth);
            customerInforTable.setFont(font);
            customerInforTable.addCell(new Cell(0, 4)
                    .add("Thông tin khách hàng").setBold().setBorder(Border.NO_BORDER));

            customerInforTable.addCell(new Cell().add("Họ tên:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add(hoaDon.getTenNguoiNhan()).setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("Số điện thoại:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add(hoaDon.getSdt()).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add("Địa chỉ:").setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add(hoaDon.getDiaChhi()).setBorder(Border.NO_BORDER));
            customerInforTable.addCell(new Cell().add("Ngày thanh toán:").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            customerInforTable.addCell(new Cell().add(date).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            float itemColWidth[] = {17, 146, 146, 146, 146};
            Table itemTable = new Table(itemColWidth);
            itemTable.setFont(font);
            itemTable.addCell(new Cell().add("STT").setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Tên sản phẩm").setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Số lượng").setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Giá bán").setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add("Thành tiền").setBackgroundColor(new DeviceRgb(255, 69, 0)).setFontColor(Color.WHITE));

            double tong = 0;
            for (int i = 0; i < list.size(); i++) {
                itemTable.addCell(new Cell().add(String.valueOf(i + 1)));
                itemTable.addCell(new Cell().add(list.get(i).getSanPham().getTen()));
                itemTable.addCell(new Cell().add(String.valueOf(list.get(i).getSoLuong())));
                itemTable.addCell(new Cell().add(String.valueOf(list.get(i).getDonGia())));
                itemTable.addCell(new Cell().add(String.valueOf(list.get(i).getDonGia().multiply(BigDecimal.valueOf(list.get(i).getSoLuong())))));
                tong += Double.valueOf(list.get(i).getDonGia().multiply(BigDecimal.valueOf(list.get(i).getSoLuong())).toString());
            }

            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(255, 69, 0)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(255, 69, 0)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("").setBackgroundColor(new DeviceRgb(255, 69, 0)).setBorder(Border.NO_BORDER));
            itemTable.addCell(new Cell().add("Tổng tiền").setBackgroundColor(new DeviceRgb(255, 69, 0)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            itemTable.addCell(new Cell().add(String.valueOf(new BigDecimal(tong))).setBackgroundColor(new DeviceRgb(255, 69, 0)).setBorder(Border.NO_BORDER).setFontColor(Color.WHITE));
            document.add(table);
            document.add(new Paragraph("\n"));
            document.add(customerInforTable);
            document.add(new Paragraph("\n"));
            document.add(itemTable);
            document.add(new Paragraph("\n"));
            document.close();
            System.out.println("Export successfully");
            System.out.println("Image added successfully and PDF file created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String name = " thangNgu";
//        new GeneratePdf().exportBill(name);
        SimpleDateFormat sdf = new SimpleDateFormat("ss:mm:hh dd-MM-yyyy");
        String date = sdf.format(new Date());
        System.out.println(date);
    }

}
