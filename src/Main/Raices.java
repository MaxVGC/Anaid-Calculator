/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
//piñeros hp

import Datos.Expresion;
import Datos.Mtd_Raices;
import Datos.Tiempo;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * df
 *
 * @author carlo
 */
public class Raices extends javax.swing.JFrame {

    /**
     * Creates new form Raices
     */
    public ChartPanel chartPanel;
    private static final int SIZE = 456;

    public Raices() throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(btn_close, "src/assets/icon_close.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(btn_home, "src/assets/icon_home.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(btn_equal, "src/assets/icon_equal.png");
        XYDataset paresDeDatos = generarDatos("x", 0, 0);
        JFreeChart diagrama = crearDiagrama(paresDeDatos);
        chartPanel = new ChartPanel(diagrama);
        grafica.setLayout(new java.awt.BorderLayout());
        grafica.add(chartPanel, BorderLayout.CENTER);
        //Graficador g = new Graficador();
    }

    public void HiloRaices() {
        Runnable miRunnable = new Runnable() {
            public void run() {
                try {
                    ecuacion.setEditable(false);
                    ecuacion.setFocusable(false);
                    btn_equal.setFocusable(false);
                    carga.setIcon(new ImageIcon("src/assets/carga.gif"));
                    boolean x = RaicesX();
                    if (x == true) {
                        btn_equal.setFocusable(true);
                        ecuacion.setEditable(true);
                        ecuacion.setFocusable(true);
                        carga.setIcon(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
    }

    private XYDataset generarDatos(String eq, int r, double raiz) throws Exception {
        //le pasamos una funcion generadora f(x)
        XYSeries datos = new XYSeries("Linea Funcion");
        for (double x = r - 5; x <= r + 5; x += 1) {
            datos.add(x, f(x, eq));
        }
        XYSeries raizx = new XYSeries("Raiz");
        raizx.add(raiz, 0);
        raizx.add(0, 0);

        XYSeriesCollection conjuntoDatos = new XYSeriesCollection();
        conjuntoDatos.addSeries(datos);
        conjuntoDatos.addSeries(raizx);

        return conjuntoDatos;
    }

    public boolean RaicesX() {
        try {
            String eq = ecuacion.getText();
            Mtd_Raices mr = new Mtd_Raices();
            Expresion e = new Expresion();
            int x = mr.clc_raiz(eq);
            lbl_mtd_bi.setText("X=" + mr.mtd_biseccion(x, eq));
            lbl_mtd_fp.setText("X=" + mr.mtd_falsa_posicion(x, eq));
            lbl_mtd_sc1.setText("X=" + mr.mtd_secante_1(x, eq));
            lbl_mtd_sc2.setText("X=" + mr.mtd_secante_1(x, eq));

            XYDataset paresDeDatos = generarDatos(eq, x, mr.mtd_secante_1(x, eq));
            JFreeChart diagrama = crearDiagrama(paresDeDatos);
            chartPanel.setChart(diagrama);
            return true;

        } catch (Exception ex) {
            Logger.getLogger(Raices.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    private JFreeChart crearDiagrama(XYDataset conjuntoDatos) throws IOException {
        JFreeChart diag = ChartFactory.createXYLineChart(
                null, //Titulo Grafica
                "X", // Leyenda eje X
                "Y", // Leyenda eje Y
                conjuntoDatos, // Los datos
                PlotOrientation.VERTICAL, //orientacion
                false, // ver titulo de linea
                true, //tooltips
                false //URL
        );
        XYPlot xyplot = (XYPlot) diag.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setRangeZeroBaselineVisible(true);
        xyplot.setDomainZeroBaselineVisible(true);
        xyplot.setOutlinePaint(Color.WHITE);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
//        renderer.setBaseItemLabelGenerator(xy);
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBaseLinesVisible(true);
//        renderer.setBaseItemLabelsVisible(true);
        return diag;
    }

    //aqui definimos la funcion que desees, en esta caso la f(x) = 4sen(x)
    private double f(double x, String eq) throws Exception {
        Expresion e = new Expresion();
        double a = e.Evaluar(eq, x);
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carga = new javax.swing.JLabel();
        grafica = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ecuacion = new javax.swing.JTextField();
        btn_equal = new javax.swing.JLabel();
        btn_home = new javax.swing.JLabel();
        btn_close = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_mtd_bi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_mtd_fp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_mtd_sc1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_mtd_sc2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        carga.setMaximumSize(new java.awt.Dimension(1280, 720));
        carga.setMinimumSize(new java.awt.Dimension(1280, 720));
        carga.setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().add(carga);
        carga.setBounds(0, 0, 1280, 720);

        grafica.setLayout(new java.awt.BorderLayout());
        getContentPane().add(grafica);
        grafica.setBounds(389, 118, 850, 570);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Ingrese la ecuación");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(42, 35, 329, 65);

        ecuacion.setBackground(new java.awt.Color(255, 255, 255));
        ecuacion.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        ecuacion.setForeground(new java.awt.Color(0, 0, 0));
        ecuacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ecuacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        ecuacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ecuacionKeyPressed(evt);
            }
        });
        getContentPane().add(ecuacion);
        ecuacion.setBounds(389, 35, 767, 65);

        btn_equal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_equalMouseClicked(evt);
            }
        });
        getContentPane().add(btn_equal);
        btn_equal.setBounds(1162, 35, 65, 65);

        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        getContentPane().add(btn_home);
        btn_home.setBounds(1240, 60, 40, 40);

        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });
        getContentPane().add(btn_close);
        btn_close.setBounds(1240, 0, 40, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Metodo biseccion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(42, 118, 205, 32);

        lbl_mtd_bi.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_mtd_bi.setText("Esperando ecuación...");
        getContentPane().add(lbl_mtd_bi);
        lbl_mtd_bi.setBounds(42, 168, 193, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("Metodo falsa posicion");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 210, 255, 32);

        lbl_mtd_fp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_mtd_fp.setText("Esperando ecuación...");
        getContentPane().add(lbl_mtd_fp);
        lbl_mtd_fp.setBounds(42, 260, 193, 24);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Metodo secante");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(42, 302, 182, 32);

        lbl_mtd_sc1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_mtd_sc1.setText("Esperando ecuación...");
        getContentPane().add(lbl_mtd_sc1);
        lbl_mtd_sc1.setBounds(42, 352, 193, 24);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Metodo secante modificada");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(42, 394, 316, 32);

        lbl_mtd_sc2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_mtd_sc2.setText("Esperando ecuación...");
        getContentPane().add(lbl_mtd_sc2);
        lbl_mtd_sc2.setBounds(42, 444, 193, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        rsscalelabel.RSScaleLabel.setScaleLabel(btn_close, "src/assets/icon_close_focus.png");
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        rsscalelabel.RSScaleLabel.setScaleLabel(btn_close, "src/assets/icon_close.png");
    }//GEN-LAST:event_btn_closeMouseExited

    private void btn_equalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_equalMouseClicked
        HiloRaices();
    }//GEN-LAST:event_btn_equalMouseClicked

    private void ecuacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ecuacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            HiloRaices();
        }
    }//GEN-LAST:event_ecuacionKeyPressed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        Inicio a = new Inicio();
        this.dispose();
        a.setVisible(true);
    }//GEN-LAST:event_btn_homeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Raices().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(Raices.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private javax.swing.JLabel btn_equal;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel carga;
    private javax.swing.JTextField ecuacion;
    private javax.swing.JPanel grafica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_mtd_bi;
    private javax.swing.JLabel lbl_mtd_fp;
    private javax.swing.JLabel lbl_mtd_sc1;
    private javax.swing.JLabel lbl_mtd_sc2;
    // End of variables declaration//GEN-END:variables
}
