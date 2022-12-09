/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.importExcel;

package com.mycompany.ungdungbanlaptop.infrastructure.importExcel;

import com.github.pjfanning.xlsx.StreamingReader;
import com.mycompany.ungdungbanlaptop.model.resquest.HangRequest;
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

public class HangImport {

    public List<HangRequest> importDate(File excelDataFile) {
        List<HangRequest> lstHang = new ArrayList<>();
        Workbook wb = StreamingReader.builder().bufferSize(4096).rowCacheSize(50).open(excelDataFile);
        Sheet workSheet = wb.getSheetAt(0);
        for (Row row : workSheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            if (String.valueOf(getCellValue(row.getCell(0))).trim().length() == 0
                    && String.valueOf(getCellValue(row.getCell(1))).trim().length() == 0) {
                continue;
            }

            HangRequest hangRequest = new HangRequest();
            hangRequest.setMa(String.valueOf(row.getCell(0).getStringCellValue().trim()));
            hangRequest.setTen(String.valueOf(row.getCell(1).getStringCellValue().trim()));
            lstHang.add(hangRequest);
        }
        return lstHang;
    }

    private Object getCellValue(Cell cell) {
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

}
