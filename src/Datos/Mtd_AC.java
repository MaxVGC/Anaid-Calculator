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
            }else{
                aux++;
            }
            i++;

        } while (i != (n));
        double[] f = matriz2x2(n - aux,sumlnx,sumlnx,sumlnx2,sumlny,sumlnxlny);
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

    public double[] matriz2x2(double x00, double x01, double x10, double x11, double r1, double r2) {
        double det = det2x2(x00, x01, x10, x11);
        double detx = det2x2(r1, r2, x10, x11);
        double dety = det2x2(x00, x01, r1, r2);
        double[] res = {(detx / det), (dety / det)};
        return res;
    }

}
