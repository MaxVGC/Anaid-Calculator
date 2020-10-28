/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Mtd_AC {

    public double[] A_Lineal(double[] x, double[] y) {
        int n = x.length;
        double x2 = 0;
        double xy = 0;
        double sumx = 0;
        double sumy = 0;

        int i = 0;
        do {
            sumx = sumx + x[i];
            sumy = sumy + y[i];
            x2 = x2 + (x[i] * x[i]);
            xy = xy + (x[i] * y[i]);
            i++;
        } while (i != (n));
        double[] res = matriz2x2(n, sumx, sumx, x2, sumy, xy);
        return res;
    }

    public double[] A_Pol_2(double[] x, double[] y) {
        int n = x.length;
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;
        double y1 = 0;
        double xy = 0;
        double x2y = 0;
        int i = 0;
        do {
            x1 = x1 + x[i];
            x2 = x2 + (Math.pow(x[i], 2));
            x3 = x3 + (Math.pow(x[i], 3));
            x4 = x4 + (Math.pow(x[i], 4));
            y1 = y1 + y[i];
            xy = xy + (x[i] * y[i]);
            x2y = x2y + ((Math.pow(x[i], 2)) * y[i]);
            i++;
        } while (i != (n));
        double[][] det = {{n, x1, x2}, {x1, x2, x3}, {x2, x3, x4}};
        double[][] detx = {{y1, x1, x2}, {xy, x2, x3}, {x2y, x3, x4}};
        double[][] dety = {{n, y1, x2}, {x1, xy, x3}, {x2, x2y, x4}};
        double[][] detz = {{n, x1, y1}, {x1, x2, xy}, {x2, x3, x2y}};
        double detf = determinante(det);
        double detxf = determinante(detx);
        double detyf = determinante(dety);
        double detzf = determinante(detz);
        double[] res = {(detxf / detf), (detyf / detf), (detzf / detf)};

        return res;
    }

    public double[] A_Pol_3(double[] x, double[] y) {
        int n = x.length;
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;
        double x5 = 0;
        double x6 = 0;
        double y1 = 0;
        double xy = 0;
        double x2y = 0;
        double x3y = 0;
        int i = 0;
        do {
            x1 = x1 + x[i];
            x2 = x2 + (Math.pow(x[i], 2));
            x3 = x3 + (Math.pow(x[i], 3));
            x4 = x4 + (Math.pow(x[i], 4));
            x5 = x5 + (Math.pow(x[i], 5));
            x6 = x6 + (Math.pow(x[i], 6));

            y1 = y1 + y[i];
            xy = xy + (x[i] * y[i]);
            x2y = x2y + ((Math.pow(x[i], 2)) * y[i]);
            x3y = x3y + ((Math.pow(x[i], 3)) * y[i]);

            i++;
        } while (i != (n));
        double[][] det = {{n, x1, x2, x3}, {x1, x2, x3, x4}, {x2, x3, x4, x5}, {x3, x4, x5, x6}};
        double[][] deta = {{y1, x1, x2, x3}, {xy, x2, x3, x4}, {x2y, x3, x4, x5}, {x3y, x4, x5, x6}};
        double[][] detb = {{n, y1, x2, x3}, {x1, xy, x3, x4}, {x2, x2y, x4, x5}, {x3, x3y, x5, x6}};
        double[][] detc = {{n, x1, y1, x3}, {x1, x2, xy, x4}, {x2, x3, x2y, x5}, {x3, x4, x3y, x6}};
        double[][] detd = {{n, x1, x2, y1}, {x1, x2, x3, xy}, {x2, x3, x4, x2y}, {x3, x4, x5, x3y}};

        double detf = determinante(det);
        double detaf = determinante(deta);
        double detbf = determinante(detb);
        double detcf = determinante(detc);
        double detdf = determinante(detd);

        double[] res = {(detaf / detf), (detbf / detf), (detcf / detf), (detdf / detf)};

        return res;
    }

    public double[] A_Pol_4(double[] x, double[] y) {
        int n = x.length;
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;
        double x5 = 0;
        double x6 = 0;
        double x7 = 0;
        double x8 = 0;

        double y1 = 0;
        double xy = 0;
        double x2y = 0;
        double x3y = 0;
        double x4y = 0;

        int i = 0;
        do {
            x1 = x1 + x[i];
            x2 = x2 + (Math.pow(x[i], 2));
            x3 = x3 + (Math.pow(x[i], 3));
            x4 = x4 + (Math.pow(x[i], 4));
            x5 = x5 + (Math.pow(x[i], 5));
            x6 = x6 + (Math.pow(x[i], 6));
            x7 = x7 + (Math.pow(x[i], 7));
            x8 = x8 + (Math.pow(x[i], 8));

            y1 = y1 + y[i];
            xy = xy + (x[i] * y[i]);
            x2y = x2y + ((Math.pow(x[i], 2)) * y[i]);
            x3y = x3y + ((Math.pow(x[i], 3)) * y[i]);
            x4y = x4y + ((Math.pow(x[i], 4)) * y[i]);

            i++;
        } while (i != (n));
        double[][] det = {{n, x1, x2, x3, x4}, {x1, x2, x3, x4, x5}, {x2, x3, x4, x5, x6}, {x3, x4, x5, x6, x7}, {x4, x5, x6, x7, x8}};
        double[][] deta = {{y1, x1, x2, x3, x4}, {xy, x2, x3, x4, x5}, {x2y, x3, x4, x5, x6}, {x3y, x4, x5, x6, x7}, {x4y, x5, x6, x7, x8}};
        double[][] detb = {{n, y1, x2, x3, x4}, {x1, xy, x3, x4, x5}, {x2, x2y, x4, x5, x6}, {x3, x3y, x5, x6, x7}, {x4, x4y, x6, x7, x8}};
        double[][] detc = {{n, x1, y1, x3, x4}, {x1, x2, xy, x4, x5}, {x2, x3, x2y, x5, x6}, {x3, x4, x3y, x6, x7}, {x4, x5, x4y, x7, x8}};
        double[][] detd = {{n, x1, x2, y1, x4}, {x1, x2, x3, xy, x5}, {x2, x3, x4, x2y, x6}, {x3, x4, x5, x3y, x7}, {x4, x5, x6, x4y, x8}};
        double[][] dete = {{n, x1, x2, x3, y1}, {x1, x2, x3, x4, xy}, {x2, x3, x4, x5, x2y}, {x3, x4, x5, x6, x3y}, {x4, x5, x6, x7, x4y}};

        double detf = determinante(det);
        double detaf = determinante(deta);
        double detbf = determinante(detb);
        double detcf = determinante(detc);
        double detdf = determinante(detd);
        double detef = determinante(dete);

        double[] res = {(detaf / detf), (detbf / detf), (detcf / detf), (detdf / detf), (detef / detf)};

        return res;
    }

    public double[] A_Pol_5(double[] x, double[] y) {
        int n = x.length;
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        double x4 = 0;
        double x5 = 0;
        double x6 = 0;
        double x7 = 0;
        double x8 = 0;
        double x9 = 0;
        double x10 = 0;

        double y1 = 0;
        double xy = 0;
        double x2y = 0;
        double x3y = 0;
        double x4y = 0;
        double x5y = 0;

        int i = 0;
        do {
            x1 = x1 + x[i];
            x2 = x2 + (Math.pow(x[i], 2));
            x3 = x3 + (Math.pow(x[i], 3));
            x4 = x4 + (Math.pow(x[i], 4));
            x5 = x5 + (Math.pow(x[i], 5));
            x6 = x6 + (Math.pow(x[i], 6));
            x7 = x7 + (Math.pow(x[i], 7));
            x8 = x8 + (Math.pow(x[i], 8));
            x9 = x9 + (Math.pow(x[i], 9));
            x10 = x10 + (Math.pow(x[i], 10));

            y1 = y1 + y[i];
            xy = xy + (x[i] * y[i]);
            x2y = x2y + ((Math.pow(x[i], 2)) * y[i]);
            x3y = x3y + ((Math.pow(x[i], 3)) * y[i]);
            x4y = x4y + ((Math.pow(x[i], 4)) * y[i]);
            x5y = x5y + ((Math.pow(x[i], 5)) * y[i]);

            i++;
        } while (i != (n));
        double[][] det = {{n, x1, x2, x3, x4, x5}, {x1, x2, x3, x4, x5, x6}, {x2, x3, x4, x5, x6, x7}, {x3, x4, x5, x6, x7, x8}, {x4, x5, x6, x7, x8, x9}, {x5, x6, x7, x8, x9, x10}};
        double[][] deta = {{y1, x1, x2, x3, x4, x5}, {xy, x2, x3, x4, x5, x6}, {x2y, x3, x4, x5, x6, x7}, {x3y, x4, x5, x6, x7, x8}, {x4y, x5, x6, x7, x8, x9}, {x5y, x6, x7, x8, x9, x10}};
        double[][] detb = {{n, y1, x2, x3, x4, x5}, {x1, xy, x3, x4, x5, x6}, {x2, x2y, x4, x5, x6, x7}, {x3, x3y, x5, x6, x7, x8}, {x4, x4y, x6, x7, x8, x9}, {x5, x5y, x7, x8, x9, x10}};
        double[][] detc = {{n, x1, y1, x3, x4, x5}, {x1, x2, xy, x4, x5, x6}, {x2, x3, x2y, x5, x6, x7}, {x3, x4, x3y, x6, x7, x8}, {x4, x5, x4y, x7, x8, x9}, {x5, x6, x5y, x8, x9, x10}};
        double[][] detd = {{n, x1, x2, y1, x4, x5}, {x1, x2, x3, xy, x5, x6}, {x2, x3, x4, x2y, x6, x7}, {x3, x4, x5, x3y, x7, x8}, {x4, x5, x6, x4y, x8, x9}, {x5, x6, x7, x5y, x9, x10}};
        double[][] dete = {{n, x1, x2, x3, y1, x5}, {x1, x2, x3, x4, xy, x6}, {x2, x3, x4, x5, x2y, x7}, {x3, x4, x5, x6, x3y, x8}, {x4, x5, x6, x7, x4y, x9}, {x5, x6, x7, x8, x5y, x10}};
        double[][] detg = {{n, x1, x2, x3, x4, y1}, {x1, x2, x3, x4, x5, xy}, {x2, x3, x4, x5, x6, x2y}, {x3, x4, x5, x6, x7, x3y}, {x4, x5, x6, x7, x8, x4y}, {x5, x6, x7, x8, x9, x5y}};

        double detf = determinante(det);
        double detaf = determinante(deta);
        double detbf = determinante(detb);
        double detcf = determinante(detc);
        double detdf = determinante(detd);
        double detef = determinante(dete);
        double detgf = determinante(detg);

        double[] res = {(detaf / detf), (detbf / detf), (detcf / detf), (detdf / detf), (detef / detf), (detgf / detf)};
        return res;
    }

    public static double determinante(double[][] matriz) {
        assert matriz != null;
        assert matriz.length > 0;
        assert matriz.length == matriz[0].length;

        double determinante = 0.0;

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Si la matriz es 1x1, el determinante es el elemento de la matriz
        if ((filas == 1) && (columnas == 1)) {
            return matriz[0][0];
        }

        int signo = 1;

        for (int columna = 0; columna < columnas; columna++) {
            // Obtiene el adjunto de fila=0, columna=columna, pero sin el signo.
            double[][] submatriz = getSubmatriz(matriz, filas, columnas,
                    columna);
            determinante = determinante + signo * matriz[0][columna] * determinante(submatriz);
            signo *= -1;
        }

        return determinante;
    }

    public static double[][] getSubmatriz(double[][] matriz, int filas, int columnas, int columna) {
        double[][] submatriz = new double[filas - 1][columnas - 1];
        int contador = 0;
        for (int j = 0; j < columnas; j++) {
            if (j == columna) {
                continue;
            }
            for (int i = 1; i < filas; i++) {
                submatriz[i - 1][contador] = matriz[i][j];
            }
            contador++;
        }
        return submatriz;
    }

    public double[] A_Log(double[] x, double[] y) {
        int n = x.length;

        double sumlnx = 0;
        double sumlnx2 = 0;
        double sumylnx = 0;
        double sumy = 0;
        int i = 0;
        int aux = 0;
        do {
            if (x[i] != 0) {
                sumy = sumy + y[i];
                sumlnx = sumlnx + Math.log(x[i]);
                sumlnx2 = sumlnx2 + (Math.log(x[i]) * Math.log(x[i]));
                sumylnx = sumylnx + y[i] * Math.log(x[i]);
            } else {
                aux++;
            }
            i++;

        } while (i != (n));
        double[] f = matriz2x2(n - aux, sumlnx, sumlnx, sumlnx2, sumy, sumylnx);
        double[] res = {f[0], f[1]};
        return res;
    }

    public double[] A_Pot(double[] x, double[] y) {
        int n = x.length;

        double sumlnx = 0;
        double sumlnx2 = 0;
        double sumlny = 0;
        double sumlnxlny = 0;
        int i = 0;
        int aux = 0;
        do {
            if (x[i] != 0 && y[i] != 0) {
                sumlnx = sumlnx + Math.log(x[i]);
                sumlny = sumlny + Math.log(y[i]);
                sumlnx2 = sumlnx2 + Math.log(x[i]) * Math.log(x[i]);
                sumlnxlny = sumlnxlny + Math.log(x[i]) * Math.log(y[i]);
            } else {
                aux++;
            }
            i++;

        } while (i != (n));
        double[] f = matriz2x2(n - aux, sumlnx, sumlnx, sumlnx2, sumlny, sumlnxlny);
        double[] res = {Math.exp(f[0]), f[1]};
        return res;
    }

    public double[] A_Exp(double[] x, double[] y) {
        int n = x.length;
        double smx = 0, smx2 = 0, smlny = 0, smxlny = 0;
        int i = 0;
        do {
            if (y[i] != 0) {
                smx = smx + x[i];
                smx2 = smx2 + x[i] * x[i];
                smlny = smlny + Math.log(y[i]);
                smxlny = smxlny + x[i] * Math.log(y[i]);
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error en la muestra de los datos, no pueden haber 0 en los valores de Y");
                return null;
            }
            i++;
        } while (i != n);

        double[] f = matriz2x2(n, smx, smx, smx2, smlny, smxlny);
        double[] res = {Math.exp(f[0]), f[1]};
        return res;
    }

    public double det2x2(double x00, double x01, double x10, double x11) {
        return ((x00 * x11) - (x01 * x10));
    }

    public double error(String f, double[] x, double[] y, int grado) throws Exception {
        Expresion e = new Expresion();
        double aux = 0;
        int i=0;
        do {
            aux=aux+(y[i]-e.Evaluar(f, x[i]))*(y[i]-e.Evaluar(f, x[i]));
            i++;
        } while (i!=x.length);
        double r=Math.sqrt((aux)/(x.length-(grado+1)));
        System.out.println(1-r);
        return 1-r;
    }

    public double[] matriz2x2(double x00, double x01, double x10, double x11, double r1, double r2) {
        double det = det2x2(x00, x01, x10, x11);
        double detx = det2x2(r1, r2, x10, x11);
        double dety = det2x2(x00, x01, r1, r2);
        double[] res = {(detx / det), (dety / det)};
        return res;
    }

}
