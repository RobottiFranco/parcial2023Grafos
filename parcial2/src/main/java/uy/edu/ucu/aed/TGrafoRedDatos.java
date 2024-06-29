package uy.edu.ucu.aed;


/*
 * NO LICENCE 
 * Author: Ing. Agustin Paredes
 */

import java.util.Collection;


/**
 *
 * @author agustinp
 */
public class TGrafoRedDatos extends TGrafoNoDirigido implements ITGrafoRedDatos
{

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas)
    {
        // Descomentar la siguiente línea luego de elegir una superclase
        super(vertices, aristas);

    }

    @Override
    public boolean conectados(Comparable a, Comparable b)
    {
        TVertice vert1 =  getVertices().get(a);
        TVertice vert2 = getVertices().get(b);
        desvisitarVertices();

        return vert1.conectadoCon(vert2) || vert2.conectadoCon(vert1);
    }

}
