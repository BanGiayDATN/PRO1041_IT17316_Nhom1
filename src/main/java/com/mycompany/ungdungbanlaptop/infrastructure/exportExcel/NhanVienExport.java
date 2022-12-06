/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.entity.NhanVien;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author thang
 */
public class NhanVienExport {
     public static void exportData(List<NhanVien> list, String tenFile) {
        try ( SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            SXSSFSheet sheet = workbook.createSheet("Sheet");
            sheet.trackAllColumnsForAutoSizing();
            CellStyle cellStyle = workbook.createCellStyle();
            //set border to table
            cellStyle.setBorderTop(BorderStyle.MEDIUM);
            cellStyle.setBorderRight(BorderStyle.MEDIUM);
            cellStyle.setBorderBottom(BorderStyle.MEDIUM);
            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            // Header
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("STT");
            cell.setCellStyle(cellStyle);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue("Mã nhân viên");
            cell1.setCellStyle(cellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue("Họ tên");
            cell2.setCellStyle(cellStyle);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue("Ngày sinh");
            cell3.setCellStyle(cellStyle);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue("Giới tính");
            cell4.setCellStyle(cellStyle);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue("Địa chỉ");
            cell5.setCellStyle(cellStyle);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue("Số điện thoại");
            cell6.setCellStyle(cellStyle);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue("Email");
            cell7.setCellStyle(cellStyle);

            Cell cell8 = row.createCell(8);
            cell8.setCellValue("Trạng thái");
            cell8.setCellStyle(cellStyle);

            //Set data
            int rowNum = 1;
            int index = 1;
            for (NhanVien nhanVien : list) {
                Row empDataRow = sheet.createRow(rowNum++);
                if(nhanVien.getTrangThai() == 1){
                    Font font = workbook.getFontAt(rowNum);
                    Color Color;
                    font.setColor(Short.decode("#fc5959"));
                    cellStyle.setFont(font);
                }else{
                    Font font = workbook.getFontAt(rowNum);
                    Color Color;
                    font.setColor(Short.decode("#0f0e0e"));
                    cellStyle.setFont(font);
                }
                Cell empSttCell = empDataRow.createCell(0);
                empSttCell.setCellStyle(cellStyle);
                empSttCell.setCellValue(index);
                
                Cell empMaNhanVienCell = empDataRow.createCell(1);
                empMaNhanVienCell.setCellStyle(cellStyle);
                empMaNhanVienCell.setCellValue(nhanVien.getMa());
                
                Cell empTenNhanVienCell = empDataRow.createCell(1);
                empTenNhanVienCell.setCellStyle(cellStyle);
                empTenNhanVienCell.setCellValue(nhanVien.getHoTen());
                
                 Cell empNgaySinhCell = empDataRow.createCell(1);
                empNgaySinhCell.setCellStyle(cellStyle);
                empNgaySinhCell.setCellValue(new ConverDate().longToDate(nhanVien.getNgaySinh(), "dd/MM/yyyy"));
                
                Cell empGioiTinhCell = empDataRow.createCell(1);
                empGioiTinhCell.setCellStyle(cellStyle);
                empGioiTinhCell.setCellValue(nhanVien.getGioiTinh());
                
                Cell empDiaChihCell = empDataRow.createCell(1);
                empDiaChihCell.setCellStyle(cellStyle);
                empDiaChihCell.setCellValue(nhanVien.getDiaChi());
                
                Cell empSoDienThoaiCell = empDataRow.createCell(1);
                empSoDienThoaiCell.setCellStyle(cellStyle);
                empSoDienThoaiCell.setCellValue(nhanVien.getSdt());
                
                Cell empEmailCell = empDataRow.createCell(1);
                empEmailCell.setCellStyle(cellStyle);
                empEmailCell.setCellValue(nhanVien.getEmail());
                
                Cell empTrangThaiCell = empDataRow.createCell(1);
                empTrangThaiCell.setCellStyle(cellStyle);
                empTrangThaiCell.setCellValue( nhanVien.getTrangThai() == 0 ? "Còn làm" : "Nghỉ làm");
                
                
                
            }
            //write output to response
 
            int numberOfColumn = 9; // sheet.getRow(0).getPhysicalNumberOfCells();
            autosizeColumn(sheet, numberOfColumn);
            
            File path = new File(tenFile);
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void autosizeColumn(SXSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
    
}
