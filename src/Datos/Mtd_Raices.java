/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Expresion;
import java.io.IOException;
import static java.lang.Double.NaN;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Mtd_Raices {

    Tiempo t = new Tiempo();

    public int clc_raiz(String formula) throws Exception {
        int i = 0;
        double raizp = 0;
        boolean dc = false;
        t.Contar();
        Expresion e = new Expresion();
        raizp = e.Evaluar(formula, 0);
        if (raizp < 0) {
            do {
                i = i + 1;
                raizp = e.Evaluar(formula, i);
                if (t.getSegundos() == 10) {
                    dc = true;
                    break;
                }
            } while (raizp < 0);

        } else {
            do {
                i = i + 1;
                raizp = e.Evaluar(formula, i);
                if (t.getSegundos() == 10) {
                    dc = true;
                    break;
                }
            } while (raizp > 0);
        }
        if (dc == true) {
            JOptionPane.showMessageDialog(null, "Ha habido un error de escritura en la formula o no se pudo hallar una raiz");
            return 3612;
        } else {
            return i;
        }

    }

    public double mtd_biseccion(int raiz, String exp) throws Exception {
        if (raiz != 3612) {
            Expresion e = new Expresion();
            double xi = raiz + 2;
            double xu = raiz - 2;
            double fi, fu, fr;
            double xr;
            int i = 0;
            do {
                xr = (xu + xi) / 2;
                fi = e.Evaluar(exp, xi);
                fu = e.Evaluar(exp, xu);
                fr = e.Evaluar(exp, xr);
                if ((fi * fr) < 0) {
                    xi = xi;
                    xu = xr;
                } else {
                    xi = xr;
                    xu = xu;
                }
                i = i + 1;
            } while (i != 50);
            return xr;
        } else {
            return 0;
        }
    }

    public double mtd_falsa_posicion(int raiz, String exp) throws Exception {
        if (raiz != 3612) {
            Expresion e = new Expresion();
            double xi = raiz + 1;
            double xu = raiz - 1;
            double fi, fu, fr;
            double xr = 0;
            int i = 0;
            do {
                fi = e.Evaluar(exp, xi);
                fu = e.Evaluar(exp, xu);
                if ((fu - fi) == 0) {
                    return xr;
                }
                xr = (fu * xi - fi * xu) / (fu - fi);
                fr = e.Evaluar(exp, xr);
                if ((fi * fr) < 0) {
                    xi = xi;
                    xu = xr;
                } else {
                    xi = xr;
                    xu = xu;
                }
                i = i + 1;
            } while (i != 50);
            return xr;
        } else {
            return 0;
        }
    }

    public double mtd_secante_1(int raiz, String exp) throws Exception {
        if (raiz != 3612) {
        Expresion e = new Expresion();
        double xi = raiz - 1;
        double xl = xi - 0.5;
        double fi, fl, fr, a;
        double xr;
        int i = 0;
        do {
            fi = e.Evaluar(exp, xi);
            fl = e.Evaluar(exp, xl);
            if ((fi - fl) == 0) {
                return xi;
            }
            xr = xi - (fi * ((xi - xl) / (fi - fl)));
            fr = e.Evaluar(exp, xr);
            a = xi;
            xi = xr;
            xl = a;
            i = i + 1;
        } while (i != 50);
        return xr;
        }else{
            return 0;
        }
    }

    public double mtd_secante_2(int raiz, String exp) throws Exception {
        if (raiz != 3612) {
        Expresion e = new Expresion();
        double xi, xdxi, fxi, fdxi, xr;
        xr = 0;
        int i = 0;
        xi = raiz;
        do {
            xdxi = xi + (0.01 * xi);
            fxi = e.Evaluar(exp, xi);
            fdxi = e.Evaluar(exp, xdxi);
            if ((fdxi - fxi) == 0) {
                return xr;
            }
            xr = xi - (0.01 * xi * fxi) / (fdxi - fxi);
            xi = xr;
            i = i + 1;
        } while (i != 50);

        return xr;
        }else{
            return 0;
        }
    }

    public static int fact(int n) {
        if (n <= 2) {
            return n;
        }
        return n * fact(n - 1);
    }

    public static void main(String[] args) throws IOException, Exception {
        Expresion e = new Expresion();
        int i = 0;
        do {
            System.out.println(e.Evaluar("(" + fact(i) + ")*(2^x)", i));
            i++;
        } while (i != 10);

    }

}
