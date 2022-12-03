/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.importExcel;

import com.github.pjfanning.xlsx.StreamingReader;
import com.mycompany.ungdungbanlaptop.model.resquest.SanPhamRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author thang
 */
public class SanPhamImport {
    public  List<SanPhamRequest> importData(File reapExcelDataFile ) {
        List<SanPhamRequest> listSP = new ArrayList<>();
        Workbook workbook = StreamingReader.builder()
                .bufferSize(4096)
                .rowCacheSize(50)
                .open(reapExcelDataFile);
        Sheet worksheet = workbook.getSheetAt(0);
        for (Row row :
                worksheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            if (String.valueOf(getCellValue(row.getCell(0))).trim().length() == 0 &&
                    String.valueOf(getCellValue(row.getCell(1))).trim().length() == 0 &&
                    String.valueOf(getCellValue(row.getCell(2))).trim().length() == 0 &&
                    String.valueOf(getCellValue(row.getCell(3))).trim().length() == 0 &&
                    String.valueOf(getCellValue(row.getCell(4))).trim().length() == 0 &&
                    String.valueOf(getCellValue(row.getCell(5))).trim().length() == 0 
            ) {
                continue;
            }
            SanPhamRequest sanPhamRequest = new SanPhamRequest();
            sanPhamRequest.setMa(String.valueOf(row.getCell(0).getStringCellValue()).trim());
            sanPhamRequest.setTen(String.valueOf(row.getCell(1).getStringCellValue()).trim());
            sanPhamRequest.setGiaBan(String.valueOf(row.getCell(2).getStringCellValue()).trim());
            sanPhamRequest.setTrongLuong(String.valueOf(row.getCell(3).getStringCellValue()).trim());
            sanPhamRequest.setSoLuongTon(String.valueOf(row.getCell(4).getStringCellValue()).trim());
            sanPhamRequest.setNamBH(String.valueOf(row.getCell(5).getStringCellValue()).trim());
            listSP.add(sanPhamRequest);
        }
        return listSP;
    }

    private static Object getCellValue(Cell cell) {
        try {
            switch (cell.getCellType()) {
                case NUMERIC -> {
                    return cell.getNumericCellValue();
                }
                case BOOLEAN -> {
                    return cell.getBooleanCellValue();
                }
                default -> {
                    return cell.getStringCellValue();
                }

            }
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        SanPhamImport sp = new SanPhamImport();
        System.out.println(sp.importData(new File ("C:\\Users\\thang\\Downloads\\12.xlsx")).get(0).getMa());;
    }
}
