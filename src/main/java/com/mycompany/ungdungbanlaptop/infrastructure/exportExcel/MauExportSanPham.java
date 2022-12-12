/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author thang
 */
public class MauExportSanPham {

    public static void exportData(String tenFile) {
        try ( SXSSFWorkbook workbook = new SXSSFWorkbook()) {
            SXSSFSheet sheet = workbook.createSheet("Example");
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

            Cell cell1 = row.createCell(0);
            cell1.setCellValue("Mã ");
            cell1.setCellStyle(cellStyle);

            Cell cell2 = row.createCell(1);
            cell2.setCellValue("Tên");
            cell2.setCellStyle(cellStyle);

            Cell cell3 = row.createCell(2);
            cell3.setCellValue("Giá");
            cell3.setCellStyle(cellStyle);

            Cell cell4 = row.createCell(3);
            cell4.setCellValue("Trọng Lượng");
            cell4.setCellStyle(cellStyle);

            Cell cell5 = row.createCell(4);
            cell5.setCellValue("Số lượng tồn");
            cell5.setCellStyle(cellStyle);

            Cell cell6 = row.createCell(5);
            cell6.setCellValue("Năm");
            cell6.setCellStyle(cellStyle);

            Cell cell7 = row.createCell(6);
            cell7.setCellValue("Độ phân giải");
            cell7.setCellStyle(cellStyle);

            Cell cell8 = row.createCell(7);
            cell8.setCellValue("Kích thước");
            cell8.setCellStyle(cellStyle);

            Cell cell9 = row.createCell(8);
            cell9.setCellValue("Tên CPU");
            cell9.setCellStyle(cellStyle);

            Cell cell10 = row.createCell(9);
            cell10.setCellValue("Tên màu");
            cell10.setCellStyle(cellStyle);

            Cell cell11 = row.createCell(10);
            cell11.setCellValue("version hệ điều hành");
            cell11.setCellStyle(cellStyle);

            Cell cell12 = row.createCell(11);
            cell12.setCellValue("Hệ điều hành");
            cell12.setCellStyle(cellStyle);

            Cell cell13 = row.createCell(12);
            cell13.setCellValue("Dung lượng");
            cell13.setCellStyle(cellStyle);

            Cell cell14 = row.createCell(13);
            cell14.setCellValue("Loai ram");
            cell14.setCellStyle(cellStyle);

            Cell cell15 = row.createCell(14);
            cell15.setCellValue("Tên hãng");
            cell15.setCellStyle(cellStyle);

            Row row1 = sheet.createRow(1);

            int numberOfColumn = 15; // sheet.getRow(0).getPhysicalNumberOfCells();
            autosizeColumn(sheet, numberOfColumn);

            DataValidation dataValidation = null;
            DataValidationConstraint constraint = null;
            DataValidationHelper validationHelper = null;

            validationHelper = sheet.getDataValidationHelper();
            CellRangeAddressList addressList = new CellRangeAddressList(1, 1, 11, 11);
            constraint = validationHelper.createExplicitListConstraint(new String[]{"Windows", "Macos", "Linux", "Khác"});
            dataValidation = validationHelper.createValidation(constraint, addressList);
            dataValidation.setSuppressDropDownArrow(true);
            sheet.addValidationData(dataValidation);

            DataValidation dataValidation1 = null;
            DataValidationConstraint constraint1 = null;
            DataValidationHelper validationHelper1 = null;

            validationHelper1 = sheet.getDataValidationHelper();
            CellRangeAddressList addressList1 = new CellRangeAddressList(1, 1, 13, 13);
            constraint1 = validationHelper1.createExplicitListConstraint(new String[]{"SDRAM", "DDR1", "DDR2", "DDR3", "DDR4", "DDR5"});
            dataValidation1 = validationHelper1.createValidation(constraint1, addressList1);
            dataValidation1.setSuppressDropDownArrow(true);
            sheet.addValidationData(dataValidation1);

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

    public static void main(String[] args) {
        MauExportSanPham.exportData("C:\\Users\\thang\\Downloads\\hello.xlsx");
    }

}
