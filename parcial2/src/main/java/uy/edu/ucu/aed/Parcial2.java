package uy.edu.ucu.aed;

import java.util.LinkedList;

public class Parcial2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1 - Cargar el Grafo
        TGrafoRedDatos grafo = UtilGrafos.cargarGrafo("parcial2\\src\\main\\dispositivos.txt",
                "parcial2\\src\\main\\conexiones.txt", false,
                TGrafoRedDatos.class);

        // 2 - Verificar que los componentes se encuentren conectados
        // boolean conectados = grafo.conectados("nodoX","nodoY");
        boolean x = grafo.conectados("CS10", "CS20");
        System.out.println(x);
        // 3 - Leer y cargar archivo mediciones.txt
        TDato[] datos = Parcial2.cargarMediciones("parcial2\\src\\main\\mediciones.txt");

        // 4 - Obtener dato de mayor medicion.
        TMedidor medidor = new TMedidor();
        TDato mayorMedicion = medidor.obtenerMayorMedicion(datos);
        imprimirRuta(mayorMedicion);
        // 5 - Emitir archivo de salida salida.txt
        // COMPLETAR CÓDIGO
        // ManejadorArchivosGenerico.escribirArchivo("src/main/java/salida.txt", vector
        // con lineas del archivo);
    }

    private static TDato[] cargarMediciones(String rutaAlArchivo) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaAlArchivo, false);

        TDato[] mediciones = new TDato[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            String[] datos = lineas[i].split(",");
            mediciones[i] = new TDato(Double.parseDouble(datos[1]), Integer.parseInt(datos[0]));
        }

        return mediciones;
    }

    public static void imprimirRuta(TDato mayorMedicion) {
        try {
            String[] rutasImprimir = new String[2];
            rutasImprimir[0] = mayorMedicion.getFecha() + "";
            rutasImprimir[1] = mayorMedicion.getValor() + "";


            ManejadorArchivosGenerico.escribirArchivo("salida.txt", rutasImprimir);
        } catch (Exception e) {
            System.out.println("ruta: null");
        }
    }
}
