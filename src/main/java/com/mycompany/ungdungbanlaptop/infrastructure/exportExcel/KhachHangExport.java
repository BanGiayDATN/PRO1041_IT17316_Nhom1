/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.entity.KhachHang;
import com.mycompany.ungdungbanlaptop.model.viewModel.BaoHanhChiTietViewMoDel;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Diệm DZ
 */
public class KhachHangExport {
    public static void exportData(List<KhachHang> list, String tenFile) {
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
            cell1.setCellValue("Mã Khách Hàng");
            cell1.setCellStyle(cellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue("Họ Và Tên");
            cell2.setCellStyle(cellStyle);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue("Giới tính");
            cell3.setCellStyle(cellStyle);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue("Số Điện Thoại");
            cell4.setCellStyle(cellStyle);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue("Email");
            cell5.setCellStyle(cellStyle);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue("Địa Chỉ");
            cell6.setCellStyle(cellStyle);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue("Tình trạng");
            cell7.setCellStyle(cellStyle);
            


            //Set data
            int rowNum = 1;
            int index = 1;
            for (KhachHang x : list) {
                Row empDataRow = sheet.createRow(rowNum++);

                Cell empSttCell = empDataRow.createCell(0);
                empSttCell.setCellStyle(cellStyle);
                empSttCell.setCellValue(index++);

                Cell empMaNhomCell = empDataRow.createCell(1);
                empMaNhomCell.setCellStyle(cellStyle);
                empMaNhomCell.setCellValue(x.getMa());

                Cell empMonDangKyCell = empDataRow.createCell(2);
                empMonDangKyCell.setCellStyle(cellStyle);
                empMonDangKyCell.setCellValue(x.getHoTen());

                Cell empTenDeTaiCell = empDataRow.createCell(3);
                empTenDeTaiCell.setCellStyle(cellStyle);
                empTenDeTaiCell.setCellValue(x.getGioiTinh());

                Cell empTenChuyenNganhCell = empDataRow.createCell(4);
                empTenChuyenNganhCell.setCellStyle(cellStyle);
                empTenChuyenNganhCell.setCellValue(x.getSdt());

                Cell empSoThanhVienCell = empDataRow.createCell(5);
                empSoThanhVienCell.setCellStyle(cellStyle);
                empSoThanhVienCell.setCellValue(x.getEmail());
                
                Cell empTinhTrangCell = empDataRow.createCell(6);
                empTinhTrangCell.setCellStyle(cellStyle);
                empTinhTrangCell.setCellValue(x.getDiaChi());
                
                Cell empDiaChiCell = empDataRow.createCell(7);
                empDiaChiCell.setCellStyle(cellStyle);
                empDiaChiCell.setCellValue(x.getTrangThai());

                
            }
            //write output to response
 
            int numberOfColumn = 8; // sheet.getRow(0).getPhysicalNumberOfCells();
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
