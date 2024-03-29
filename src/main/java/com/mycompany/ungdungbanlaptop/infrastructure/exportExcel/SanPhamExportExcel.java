/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import com.mycompany.ungdungbanlaptop.entity.SanPham;
import com.mycompany.ungdungbanlaptop.infrastructure.TaoChuoiNgauNhien;
import com.mycompany.ungdungbanlaptop.repository.impl.SanPhamRepositoryImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author vinhnv
 */
public class SanPhamExportExcel {

    public static final String home = System.getProperty("user.home");
    public static final int COLUMN_INDEX_STT = 0;
    public static final int COLUMN_INDEX_TEN_CPU = 8;
    public static final int COLUMN_INDEX_TEN_CHAT_LIEU = 9;
    public static final int COLUMN_INDEX_TEN_HANG = 10;
    public static final int COLUMN_INDEX_TEN_HE_DIEU_HANG = 11;
    public static final int COLUMN_INDEX_TEN_RAM = 12;
    public static final int COLUMN_INDEX_DO_PHAN_GIAI = 13;
    public static final int COLUMN_INDEX_KICH_THUOC = 14;
    public static final int COLUMN_INDEX_MAU = 15;
    public static final int COLUMN_INDEX_MA = 1;
    public static final int COLUMN_INDEX_TEN = 2;
    public static final int COLUMN_INDEX_NAMSX = 3;
    public static final int COLUMN_INDEX_TRONGLUONG = 4;
    public static final int COLUMN_INDEX_SOLUONG = 5;
    public static final int COLUMN_INDEX_GIANHAP = 6;
    public static final int COLUMN_INDEX_GIABAN = 7;
    private static CellStyle cellStyleFormatNumber = null;

    // Write header with format
    private static void writeHeader(SXSSFSheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        SXSSFRow row = sheet.createRow(rowIndex);

        // Create cells
        SXSSFCell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("STT");

        cell = row.createCell(COLUMN_INDEX_TEN_CPU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên CPU");

        cell = row.createCell(COLUMN_INDEX_TEN_CHAT_LIEU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Chất liệu");

        cell = row.createCell(COLUMN_INDEX_TEN_HANG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hãng");

        cell = row.createCell(COLUMN_INDEX_TEN_HE_DIEU_HANG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hệ điều hành");

        cell = row.createCell(COLUMN_INDEX_TEN_RAM);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ram");

        cell = row.createCell(COLUMN_INDEX_DO_PHAN_GIAI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Độ phân giải");

        cell = row.createCell(COLUMN_INDEX_KICH_THUOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Kích thước ");

        cell = row.createCell(COLUMN_INDEX_MAU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Màu");

        cell = row.createCell(COLUMN_INDEX_MA);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã sản phẩm");

        cell = row.createCell(COLUMN_INDEX_TEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên sản phẩm");

        cell = row.createCell(COLUMN_INDEX_NAMSX);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Năm sản xuất");

        cell = row.createCell(COLUMN_INDEX_TRONGLUONG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Trọng lượng");

        cell = row.createCell(COLUMN_INDEX_SOLUONG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số lượng");

        cell = row.createCell(COLUMN_INDEX_GIANHAP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đơn giá nhập");

        cell = row.createCell(COLUMN_INDEX_GIABAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đơn giá bán");
    }

    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Auto resize column width
    private static void autosizeColumn(SXSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private static void createOutputFile(SXSSFWorkbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    public static void writeExcel(List<SanPham> list, String loaiFile) throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("Sheet"); // Create sheet with sheet name
        sheet.trackAllColumnsForAutoSizing();
        int rowIndex = 0;
        writeHeader(sheet, rowIndex);
        rowIndex++;
        for (SanPham sanPham : list) {
            // Create row
            SXSSFRow row = sheet.createRow(rowIndex);
            // Write data on row
            if (cellStyleFormatNumber == null) {
                // Format number
                short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
                workbook = row.getSheet().getWorkbook();
                cellStyleFormatNumber = workbook.createCellStyle();
                cellStyleFormatNumber.setDataFormat(format);
            }
            SXSSFCell cell = row.createCell(COLUMN_INDEX_STT);
            cell.setCellValue(rowIndex);

            cell = row.createCell(COLUMN_INDEX_TEN_CPU);
            cell.setCellValue(sanPham.getCpu().getTen());

            cell = row.createCell(COLUMN_INDEX_TEN_CHAT_LIEU);
            cell.setCellValue(sanPham.getChatLieu().getTen());

            cell = row.createCell(COLUMN_INDEX_TEN_HANG);
            cell.setCellValue(sanPham.getHang().getTen());

            cell = row.createCell(COLUMN_INDEX_TEN_HE_DIEU_HANG);
            cell.setCellValue(sanPham.getHeDieuHanh().getTen());

            cell = row.createCell(COLUMN_INDEX_TEN_RAM);
            cell.setCellValue(sanPham.getRam().getTen());

            cell = row.createCell(COLUMN_INDEX_DO_PHAN_GIAI);
            cell.setCellValue(sanPham.getManHinh().getDoPhanGiaMan());

            cell = row.createCell(COLUMN_INDEX_KICH_THUOC);
            cell.setCellValue(sanPham.getManHinh().getKichThuoc());

            cell = row.createCell(COLUMN_INDEX_MAU);
            cell.setCellValue(sanPham.getMau().getTen());

            cell = row.createCell(COLUMN_INDEX_MA);
            cell.setCellValue(sanPham.getMa());

            cell = row.createCell(COLUMN_INDEX_TEN);
            cell.setCellValue(sanPham.getTen());

            cell = row.createCell(COLUMN_INDEX_NAMSX);
            cell.setCellValue(sanPham.getNamBH());

            cell = row.createCell(COLUMN_INDEX_TRONGLUONG);
            cell.setCellValue(sanPham.getTrongLuong());
            cell.setCellStyle(cellStyleFormatNumber);

            cell = row.createCell(COLUMN_INDEX_SOLUONG);
            cell.setCellValue(sanPham.getSoLuongTon());

            cell = row.createCell(COLUMN_INDEX_GIANHAP);
            cell.setCellValue(Double.valueOf(sanPham.getGiaNhap().toString()));
            cell.setCellStyle(cellStyleFormatNumber);

            cell = row.createCell(COLUMN_INDEX_GIABAN);
            cell.setCellValue(Double.valueOf(sanPham.getGiaBan().toString()));
            cell.setCellStyle(cellStyleFormatNumber);

            rowIndex++;
        }
        // Auto resize column witdth
        int numberOfColumn = 16; // sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File( new TaoChuoiNgauNhien().getMaSanPham("Danh_sach_san_pham", 9)));
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            String path = new File( fileToSave.getAbsolutePath()) + loaiFile;
            createOutputFile(workbook, path);
            System.out.println("Done!!!");
        }
    }

    public static void main(String[] args) throws IOException {
        List<SanPham> list = new SanPhamRepositoryImpl().getAll();
        String sanphamExport = new TaoChuoiNgauNhien().getMaHoaDon("san_pham", 3);
        String loaiFile = ".xlsx";
        writeExcel(list, loaiFile);

        
    }
}
