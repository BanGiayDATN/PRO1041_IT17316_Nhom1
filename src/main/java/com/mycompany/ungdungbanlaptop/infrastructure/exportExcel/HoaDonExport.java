/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.model.viewModel.HoaDonRespone;
import com.mycompany.ungdungbanlaptop.util.ConverDate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author thang
 */
public class HoaDonExport {

    public static void exportData(List<HoaDonRespone> listHoaDon, String tenFile) {
        try ( Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Nhóm DATN");
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
            cell1.setCellValue("Mã Hóa Đơn");
            cell1.setCellStyle(cellStyle);

            Cell cell2 = row.createCell(2);
            cell2.setCellValue("Ngày Tạo");
            cell2.setCellStyle(cellStyle);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue("Mã Nhân viên");
            cell3.setCellStyle(cellStyle);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue("Tên Nhân Viên");
            cell4.setCellStyle(cellStyle);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue("Tên Khách hàng");
            cell5.setCellStyle(cellStyle);

            Cell cell6 = row.createCell(6);
            cell6.setCellValue("Tình trạng");
            cell6.setCellStyle(cellStyle);
            
            Cell cell7 = row.createCell(7);
            cell7.setCellValue("Số lượng");
            cell7.setCellStyle(cellStyle);

            Cell cell8 = row.createCell(8);
            cell8.setCellValue("Tổng tiền");
            cell8.setCellStyle(cellStyle);

            //Set data
            int rowNum = 1;
            int index = 1;
            for (HoaDonRespone hoaDon : listHoaDon) {
                Row empDataRow = sheet.createRow(rowNum++);

                Cell empSttCell = empDataRow.createCell(0);
                empSttCell.setCellStyle(cellStyle);
                empSttCell.setCellValue(index);

                Cell empMaNhomCell = empDataRow.createCell(1);
                empMaNhomCell.setCellStyle(cellStyle);
                empMaNhomCell.setCellValue(hoaDon.getMa());

                Cell empMonDangKyCell = empDataRow.createCell(2);
                empMonDangKyCell.setCellStyle(cellStyle);
                empMonDangKyCell.setCellValue(new ConverDate().longToDate(hoaDon.getNgayTao(), "dd/MM/yyyy"));

                Cell empTenDeTaiCell = empDataRow.createCell(3);
                empTenDeTaiCell.setCellStyle(cellStyle);
                empTenDeTaiCell.setCellValue(hoaDon.getMaNhanVien());

                Cell empTenChuyenNganhCell = empDataRow.createCell(4);
                empTenChuyenNganhCell.setCellStyle(cellStyle);
                empTenChuyenNganhCell.setCellValue(hoaDon.getTenNhanVien());

                Cell empSoThanhVienCell = empDataRow.createCell(5);
                empSoThanhVienCell.setCellStyle(cellStyle);
                empSoThanhVienCell.setCellValue(hoaDon.getTenKhachHang());
                
                Cell empTinhTrangCell = empDataRow.createCell(6);
                empTinhTrangCell.setCellStyle(cellStyle);
                empTinhTrangCell.setCellValue(hoaDon.getTrangThai());

                Cell empTenGvhdCell = empDataRow.createCell(7);
                empTenGvhdCell.setCellStyle(cellStyle);
                empTenGvhdCell.setCellValue(hoaDon.getSoLuong());

                Cell empTrangThaiCell = empDataRow.createCell(8);
                empTrangThaiCell.setCellStyle(cellStyle);
                empTrangThaiCell.setCellValue(String.valueOf(hoaDon.getTong()));
            }
            //write output to response
 
            File path = new File(tenFile);
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
