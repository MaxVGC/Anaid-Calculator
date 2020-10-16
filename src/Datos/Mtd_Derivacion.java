/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Mtd_Derivacion {

    double h = 0.1;
    Expresion e = new Expresion();

    public double primera_derivada(String f, String a) {
        try {
            double x = Double.parseDouble(a);
            double x1 = x + h;
            double x2 = x - h;
            double der = (e.Evaluar(f, x1) - e.Evaluar(f, x2)) / (2 * h);
            System.out.println(der);
            return der;
        } catch (Exception ex) {
            Logger.getLogger(Mtd_Derivacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un error en los datos por favor revise");

            return 0;
        }
    }

    public double segunda_derivada(String f, String a) {
        try {
            double x = Double.parseDouble(a);
            double x1 = x + h;
            double x2 = x - h;
            System.out.println("x" + e.Evaluar(f, x) + "  x-h: " + e.Evaluar(f, x2) + " x+h: " + e.Evaluar(f, x1));
            double der = (e.Evaluar(f, x1) + e.Evaluar(f, x2) - 2 * (e.Evaluar(f, x)));
            return (der) / (h * h);
        } catch (Exception ex) {
            Logger.getLogger(Mtd_Derivacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un error en los datos por favor revise");

            return 0;
        }
    }

    public double tercera_derivada(String f, String a) {
        try {
            double x = Double.parseDouble(a);
            double x2 = x + 2 * h;
            double x1 = x + h;
            double x3 = x - h;
            double x4 = x - 2 * h;
            double der = (e.Evaluar(f, x2) - e.Evaluar(f, x4) - 2 * (e.Evaluar(f, x1)) + 2 * (e.Evaluar(f, x3)));
            der = der / (2 * (h * h * h));
            System.out.println(der);
            return der;
        } catch (Exception ex) {
            Logger.getLogger(Mtd_Derivacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un error en los datos por favor revise");

            return 0;
        }
    }

    public double cuarta_derivada(String f, String a) {
        try {
            double x = Double.parseDouble(a);
            double x2 = x + 2 * h;
            double x1 = x + h;
            double x3 = x - h;
            double x4 = x - 2 * h;
            double der = (e.Evaluar(f, x2) + e.Evaluar(f, x4) - 4 * e.Evaluar(f, x1) - 4 * e.Evaluar(f, x3) + 6 * e.Evaluar(f, x));
            der = der / ((h * h * h * h));
            System.out.println(der);
            return der;
        } catch (Exception ex) {
            Logger.getLogger(Mtd_Derivacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hubo un error en los datos por favor revise");

            return 0;
        }
    }

    public static void main(String args[]) {
        Mtd_Derivacion d = new Mtd_Derivacion();
        d.cuarta_derivada("(x^3)+3*x", "5");
    }
}
