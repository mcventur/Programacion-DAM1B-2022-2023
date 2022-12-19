/**
 * clase FrecuenciaDado
 */
public class FrecuenciaDado {
    private final Dado dado;
    private final int[] frecuencia;

    /**
     * Constructor de la clase FrecuenciaDado
     */
    public FrecuenciaDado() {
        frecuencia = new int[6];
        dado = new Dado();
    }

    /**
     * tirar el dado n veces y contabilizar la frecuencia de aparición
     * de la tirada
     */
    public void tirarDado(int veces) {
        for (int i = 0; i < veces; i++) {
            dado.tirarDado();
            int cara = dado.getCara();
            //Las caras devueltas van del 1 al 6, y nuestro array va del 0 al 5 --> Restamos uno a la cara
            frecuencia[cara-1]++;
        }

    }

    /**
     * Mostrar las frecuencias
     */
    public void escribirFrecuencia() {
        System.out.println("Cara Frecuencia");
        for (int i = 0; i < frecuencia.length; i++) {
            //Alineamos a la izquierda (no consta en el enunciado, pero para repasar)
            System.out.printf("%-4d %-10d\n", i+1, frecuencia[i]);
        }


    }

}
