/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Ithiel
 */
 import javax.swing.JPanel;
 import java.awt.Dimension;
 import org.jfree.chart.ChartFactory;
 import org.jfree.chart.ChartPanel;
 import org.jfree.chart.JFreeChart;
 import org.jfree.chart.plot.PlotOrientation;
 import org.jfree.data.category.DefaultCategoryDataset;
 import org.jfree.ui.ApplicationFrame;
 import model.Histogram;
 
 public class HistogramDisplay <T> extends ApplicationFrame {
     
     private final Histogram<T> histogram;
     private final String ejeX;
     public HistogramDisplay(Histogram<T> histogram,String ejeX){
         super("Histograma");
         this.histogram = histogram;
         this.ejeX=ejeX;
         setContentPane(createPanel());
         pack();
     }
     
     public void execute() {
         setVisible(true);
     }
     
     private JPanel createPanel(){
         ChartPanel chartPanel = new ChartPanel (createChart(createDataset()));
         chartPanel.setPreferredSize(new Dimension(500, 400));
         return chartPanel;
     }
     
     private JFreeChart createChart (DefaultCategoryDataset dataset) {
         JFreeChart chart = ChartFactory.createBarChart(
                 "Histograma de emails",
                 "dominio email",
                 "nº de emails recibidos",
                 dataset,
                 PlotOrientation.VERTICAL,
                 false,
                 rootPaneCheckingEnabled,
                 rootPaneCheckingEnabled);
         return chart;
     }
 
     private DefaultCategoryDataset createDataset() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         for (T key: histogram.keySet()){
             dataset.addValue(histogram.get(key), "",(Comparable) key);
         }
         return dataset;
     }
 }
