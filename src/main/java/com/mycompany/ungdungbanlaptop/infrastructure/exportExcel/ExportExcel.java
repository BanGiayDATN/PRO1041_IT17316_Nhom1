/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.exportExcel;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author thang
 */
public class ExportExcel {

    private static void writeToExcell(JTable table, File path)  {
        try {
            Workbook wb = new XSSFWorkbook(); //Excell workbook
        Sheet sheet = wb.createSheet(); //WorkSheet
        Row row = sheet.createRow(2); //Row created at line 3
        TableModel model = table.getModel(); //Table model

        Row headerRow = sheet.createRow(0); //Create row at line 0
        for (int headings = 0; headings < model.getColumnCount(); headings++) { //For each column
            headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
        }

        for (int rows = 0; rows < model.getRowCount(); rows++) { //For each table row
            for (int cols = 0; cols < table.getColumnCount(); cols++) { //For each table column
                row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
            }

            //Set the row to the next one in the sequence 
            row = sheet.createRow((rows + 3));
        }
        wb.write(new FileOutputStream(path.toString()));//Save the file  
        } catch (Exception e) {
            System.out.println(e);
        }
   
    }

    public static void main(String[] args) {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"id","mã"});
        for (int i = 0; i < 10; i++) {
            model.addRow(new Object[]{i, 12});
        }
        table.setModel(model);
        table.removeColumn(table.getColumnModel().getColumn(0));
        String home = System.getProperty("user.home");
        File file = new File(home + "/Downloads/hello.xlsx");
      
        writeToExcell(table, file);
    }
}
