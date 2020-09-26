/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author carlo
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.*;
import java.awt.Dimension;
public class Graficador extends ApplicationFrame {

    public Graficador() throws Exception {
        super("Graficador");
        XYDataset paresDeDatos = generarDatos();
        JFreeChart diagrama = crearDiagrama(paresDeDatos);
        ChartPanel chartPanel = new ChartPanel(diagrama);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        setContentPane(chartPanel);
        pack();
        this.setVisible(true);
    }

    private XYDataset generarDatos() throws Exception {
        //le pasamos una funcion generadora f(x)
        XYSeries datos = new XYSeries("Linea Funcion");
        for (double x = -10.0; x <= 10.0; x += 1) {
            datos.add(x, f(x));
        }

        XYSeriesCollection conjuntoDatos = new XYSeriesCollection();
        conjuntoDatos.addSeries(datos);

        return conjuntoDatos;
    }

    private JFreeChart crearDiagrama(XYDataset conjuntoDatos) {
        JFreeChart diag = ChartFactory.createXYLineChart(
                "Graficador", //Titulo Grafica
                "X", // Leyenda eje X
                "Y", // Leyenda eje Y
                conjuntoDatos, // Los datos
                PlotOrientation.VERTICAL, //orientacion
                false, // ver titulo de linea
                false, //tooltips
                false //URL
        );
        return diag;
    }

    //aqui definimos la funcion que desees, en esta caso la f(x) = 4sen(x)
    private double f(double x) throws Exception {
        Expresion e = new Expresion();
        double a=e.Evaluar("(x^2)-43", x);
        System.out.println(a);
        return a;
    }

//    public static void main(String[] arg) throws Exception {
//        Graficador miGraficador = new Graficador();
//        miGraficador.pack();
//        //RefineryUtilities.centerFrameOnScreen(miGraficador);
//        miGraficador.setVisible(true);
//    }
}
