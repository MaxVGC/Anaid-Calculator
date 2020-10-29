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
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.ParseException;
import org.nfunk.jep.Node;

import java.util.Scanner;

public class Mtd_Taylor {

    public double Taylor(String a , double b) throws Exception{
        Expresion e=new Expresion();
        derivar(a);
        return e.Evaluart(a, b);
    }
    public String derivar(String funcion) {
        String fpr = "";
        String variable = "x";

        DJep dev = new DJep();

        dev.addStandardFunctions();
        dev.addStandardConstants();
        dev.addComplex();
        dev.setAllowUndeclared(true);
        dev.setAllowAssignment(true);
        dev.setImplicitMul(true);
        dev.addStandardDiffRules();

        try {
            Node diff = dev.parse(funcion);
            diff = dev.differentiate(diff, variable);
            diff = dev.simplify(diff);
            fpr = dev.toString(diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        return fpr;
    }

}
