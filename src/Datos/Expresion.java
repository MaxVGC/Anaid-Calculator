package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carlo
 */
import java.util.*;
import java.util.regex.*;
import java.lang.reflect.*;

public class Expresion {

    public Expresion() {
    }
    enum TipoToken  {   NUMERO, VARIABLE, FUNCION, ADD, SUB, MUL, DIV,
                        EXP, P_IZQ, P_DER, ERROR };
    class Token {
        TipoToken tipo;
        String    texto;
        Token(TipoToken ti, String te) { tipo=ti; texto=te;}
        Token(TipoToken ti) { tipo = ti; }
    }
    Queue<Token>    colaTokens;
    String          cadenaFuncion;
    double          variable;

    Expresion(String c) throws Exception {
        cadenaFuncion = c;
    }

    private void generarTokens() throws Exception {
        colaTokens = new LinkedList<Token>();
        StringBuffer entrada   = new StringBuffer(cadenaFuncion);
       Pattern pNumero = Pattern.compile("\\d+(\\.\\d+)?");
        Pattern pID     = Pattern.compile("\\p{Alpha}\\w+");
        while(entrada.length()>0) {
            Matcher      m  = pNumero.matcher(entrada);
            if(m.lookingAt()) {
                colaTokens.add(new Token(TipoToken.NUMERO,m.group()));
                entrada.delete(0, m.end());
                continue;
            }
            if(entrada.charAt(0) == 'x' || entrada.charAt(0) == 'X') {
                colaTokens.add(new Token(TipoToken.VARIABLE,"x"));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '+') {
                colaTokens.add(new Token(TipoToken.ADD));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '-') {
                colaTokens.add(new Token(TipoToken.SUB));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '*') {
                colaTokens.add(new Token(TipoToken.MUL));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '/') {
                colaTokens.add(new Token(TipoToken.DIV));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '(') {
                colaTokens.add(new Token(TipoToken.P_IZQ));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == ')') {
                colaTokens.add(new Token(TipoToken.P_DER));
                entrada.deleteCharAt(0);
                continue;
            }
            if(entrada.charAt(0) == '^') {
                colaTokens.add(new Token(TipoToken.EXP));
                entrada.deleteCharAt(0);
                continue;
            }
            m = pID.matcher(entrada);
            if(m.lookingAt()) {
                colaTokens.add(new Token(TipoToken.FUNCION, m.group()));
                entrada.delete(0, m.end());
                continue;
            }
            throw new Exception("Elemento no reconocido en la entrada: " 
                                 + entrada.charAt(0));
        }
    }

    private double evaluar(double x) throws Exception {
        generarTokens();
        variable = x;
        return expresion();
    }

    private double expresion() {
        double respuesta=termino();
        while(!colaTokens.isEmpty() ) {
            switch(colaTokens.element().tipo) {
                case ADD:   colaTokens.remove();
                            respuesta+=termino();
                            continue;
                case SUB:   colaTokens.remove();
                            respuesta-=termino();
                            continue;
            }
            break;
        }
        return respuesta;
    }

    private double termino() {
        double respuesta=factor();
        while(!colaTokens.isEmpty() ) {
            switch(colaTokens.element().tipo) {
                case MUL:   colaTokens.remove();
                            respuesta*=factor();
                            continue;
                case DIV:   colaTokens.remove();
                            respuesta/=factor();
                            continue;
                default:
            }
            break;
        }
        return respuesta;
    }

    private double factor() {
        double respuesta=valor();
        while(!colaTokens.isEmpty() ) {
            switch(colaTokens.element().tipo) {
                case EXP:   colaTokens.remove();
                            respuesta=Math.pow(respuesta,valor());
                            continue;
            }
            break;
        }
        return respuesta;
    }
//Pattern pNumero = Pattern.compile("\\-?\\d+(\\.\\d+)?")

    private double valor() {
        Token token;
        try {
            double respuesta = 0;
            token     = colaTokens.poll();
            switch(token.tipo) {
                case P_IZQ:     respuesta = expresion();
                                leaToken(TipoToken.P_DER);
                                return respuesta;
                case NUMERO:    return Double.parseDouble(token.texto);
                case VARIABLE:  return variable;
                case FUNCION:   leaToken(TipoToken.P_IZQ);
                                double argumento=expresion();
                                leaToken(TipoToken.P_DER);
                                Method m = java.lang.Math.class.
                                           getMethod(token.texto, Double.TYPE);
                                return (Double) m.invoke(null, argumento);
            }
            return respuesta;
        }
        catch(Exception ex) {
            System.err.println("Error: "  + ex.getMessage());
            System.exit(0);
        }
        return 0;
    }

    private boolean leaToken(TipoToken t) {
        Token token = colaTokens.poll();
        if(token.tipo.equals(t)) {
            return true;
        }
        else {
            System.err.println("Error: elemento no permitido "  + token.texto );
            return false;
        }
    }
    
    public double Evaluar(String a,double b) throws Exception{
        String funcion = a;
        Expresion  exp = new Expresion(funcion);
        return exp.evaluar(b);
    }

}
