package uy.edu.ucu.aed;

/*
 * NO LICENCE 
 * Author: Ing. Agustin Paredes
 */

import java.util.Collection;
import java.util.LinkedList;


/**
 *
 * @author agustinp
 */
public class TMedidor
{
    public TDato obtenerMayorMedicion(TDato[] datos)
    {
        int mayor = 0;
        TDato res = new TDato(0.0,0);
        for (TDato dato : datos) {
           if (dato.getValor()> mayor) {
               res = dato;
           }
        }
       return res;
    }


}
