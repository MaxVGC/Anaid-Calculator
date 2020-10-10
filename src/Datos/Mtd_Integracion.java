/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Datos.Expresion;

/**
 *
 * @author carlo
 */
public class Mtd_Integracion {

    Expresion e = new Expresion();

    public double mtd_trapecio(double A, double B, int N, String fx) throws Exception {
        if (N == 1) {
            N = 2;
        }
        double h = (B - A) / N;
        double h2 = h / 2;
        double fa = e.Evaluar(fx, A);
        double fb = e.Evaluar(fx, B);
        double sm = 0;
        double aux = A;
        int i = 1;
        do {
            aux = aux + h;
            sm = sm + e.Evaluar(fx, aux);
            i++;
        } while (i != (N));
        double res = (h2) * (fa + fb + 2 * sm);
        return res;
    }

    public double mtd_smps_1_3(double A, double B, int N, String fx) throws Exception {
        if (N == 1) {
            N = 2;
        }
        double h = (B - A) / N;
        double h2 = h / 3;
        double fa = e.Evaluar(fx, A);
        double fb = e.Evaluar(fx, B);
        double sm_imp = 0;
        double sm_par = 0;
        double aux = A;
        int i = 1;
        do {
            aux = aux + h;
            if (i % 2 == 0) {
                sm_par = sm_par + e.Evaluar(fx, aux);
            } else {
                sm_imp = sm_imp + e.Evaluar(fx, aux);
            }
            i++;
        } while (i != (N));
        double res = (h2) * (fa + fb + 2 * sm_par + 4 * sm_imp);
        return res;
    }

    public double mtd_smps_3_8(double A, double B, int N, String fx) throws Exception {
        if (N == 1) {
            N = 2;
        }
        double h = (B - A) / N;
        double h2 = (3 * h) / 8;
        double fa = e.Evaluar(fx, A);
        double fb = e.Evaluar(fx, B);
        double sm_3n = 0;
        double sm_ord = 0;
        double aux = A;
        int i = 1;
        do {
            aux = aux + h;
            if (i % 3 == 0) {
                sm_3n = sm_3n + e.Evaluar(fx, aux);
            } else {
                sm_ord = sm_ord + e.Evaluar(fx, aux);
            }
            i++;
        } while (i != (N));
        double res = (h2) * (fa + fb + 2 * sm_3n + 3 * sm_ord);
        return res;
    }

    public static void main(String[] args) throws Exception {
        Mtd_Integracion m = new Mtd_Integracion();
        Expresion e = new Expresion();
        System.out.println(e.Evaluar("exp(x)", 2));
    }
}
