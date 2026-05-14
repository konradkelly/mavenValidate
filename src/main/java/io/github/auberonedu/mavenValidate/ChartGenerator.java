package io.github.auberonedu.mavenValidate;

import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeriesCollection;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.Page;
import java.awt.Rectangle;

/**
 * Generates a JFreeChart line chart from a dataset.
 */
public class ChartGenerator {

    /**
     * @param dataset a TimeSeriesCollection
     * @return a JFreeChart with axes labeled appropriately
     */
    public JFreeChart createChart(TimeSeriesCollection dataset) {
        return ChartFactory.createTimeSeriesChart(
            "Understanding of Maven Over Time", // chart title
            "Time",                             // domain axis label
            "Understanding of Maven",           // range axis label
            dataset,                            // data
            false,                              // legend
            false,                              // tooltips
            false                               // URLs
        );
    }

public void exportToPDF(JFreeChart chart, String filename, int width, int height) {
    PDFDocument pdfDoc = new PDFDocument();
    Rectangle bounds = new Rectangle(width, height);
    Page page = pdfDoc.createPage(bounds);
    chart.draw(page.getGraphics2D(), bounds);
    pdfDoc.writeToFile(new File(filename));
    }
}