/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Noe
 */
public class Fuentes {

    
    public static Font setFuente(final String ruta) {
        Font fuente = null;
        try {
            InputStream EB = ClassLoader.class.getResourceAsStream(ruta);
            fuente = Font.createFont(Font.TRUETYPE_FONT, EB);
        } catch (FontFormatException ex) {
            Logger.getLogger(Fuentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fuentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        fuente = fuente.deriveFont(20f);
        return fuente;
    }
}
