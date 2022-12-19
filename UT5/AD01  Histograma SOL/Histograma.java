import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * La clase contiene un array que se inicializa
 * con una serie de valores y se utiliza para dibujar
 * un histograma
 */

public class Histograma {
    public final char ASTERISCO = '*';
    private final int MAX = 10;
    private int[] valores;

    /**
     * Constructor
     */
    public Histograma() {
        inicializar();

    }

    /**
     * inicializa el array con valores aleatorios
     */
    private void inicializar() {
        valores = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            valores[i] = generarAleatorio();
        }
    }

    /**
     * genera y devuelve un aleatorio entre 5 y 50 inclusive
     */
    private int generarAleatorio() {
        Random generador = new Random();
        return generador.nextInt(45) + 5;
    }

    /**
     * muestra el histograma
     */
    public void escribirHistograma() {
        for (int i = 0; i < valores.length; i++) {
            imprimirAsteriscos(valores[i]);
            System.out.println();
        }
    }

    /**
     * Añadida al proyecto de partida: escribe los asteriscos indicados en el parámetro cantidad
     */
    private void imprimirAsteriscos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print(ASTERISCO);
        }
    }


    /**
     * devuelve una copia del array
     */
    public int[] getValoresV1() {
        return valores.clone();
    }

    /**
     * devuelve una copia del array
     */
    public int[] getValoresV2() {
        return Arrays.copyOf(valores,valores.length);
    }

}
