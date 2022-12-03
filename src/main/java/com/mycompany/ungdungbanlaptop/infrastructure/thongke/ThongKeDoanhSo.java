/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ungdungbanlaptop.infrastructure.thongke;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author vinhnv
 */
public class ThongKeDoanhSo {

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thống kê doanh số",
                "Tháng ", " Doanh số ",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(230000000, "Số người", " 1");
        dataset.addValue(280000000, "Số người", " 2");
        dataset.addValue(300000000, "Số người", " 3");
        dataset.addValue(335000000, "Số người", " 4");
        dataset.addValue(450000000, "Số người", " 5");
        dataset.addValue(550000000, "Số người", " 6");
        dataset.addValue(690000000, "Số người", " 7");
        dataset.addValue(780000000, "Số người", " 8");
        dataset.addValue(800000000, "Số người", " 9");
        dataset.addValue(810000000, "Số người", " 10");
        dataset.addValue(815000000, "Số người", " 11");
        dataset.addValue(830500000, "Số người", " 12");
        
        return dataset;
    }

    public static void main(String[] args) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ thống kê doanh số ");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
