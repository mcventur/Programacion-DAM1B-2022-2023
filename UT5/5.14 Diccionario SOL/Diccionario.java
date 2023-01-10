/**
 * la clase Diccionario representa a un diccionario
 * de palabras
 */

public class Diccionario {
    private static final int MAX_PALABRAS = 10;
    private Palabra[] listaPalabras;
    private int pos;

    /**
     * Constructor de la clase Diccionario
     *
     * @param numPalabras la cantidad de palabras máxima
     *                    que guardará el diccionario
     */
    public Diccionario(int numPalabras) {
        int tam = Math.min(MAX_PALABRAS, numPalabras);
        listaPalabras = new Palabra[tam];
        pos = 0;
    }

    /**
     * @param palabra la palabra a añadir
     */
    public void insertarPalabra(Palabra palabra) {
        if (pos < listaPalabras.length) {
            listaPalabras[pos] = palabra;
            pos++;
        }
    }

    /**
     * @param posicion la posición de la palabra
     *                 a devolver. A partir de 1.
     * @return la palabra de posicion
     */
    public Palabra obtenerPalabra(int posicion) {
        //que nos llegue posicion a partir de 1 es muy importante en el if y en el return.
        if(posicion >= 1 && posicion <= pos){
            return listaPalabras[posicion-1];
        }
        else{
            return null;
        }
    }

    /**
     * @param posicion la posición de la palabra
     * a traducir. A partir de 1.
     * @return la traducción al inglés de la palabra
     * de posición
     */
    public String traducirPalabra(int posicion) {
        if(posicion >=1 && posicion <= pos){
            return listaPalabras[posicion-1].getIngles();
        }
        else{
            return null;
        }

    }

    /**
     * Mostrar el diccionario
     */
    public void escribirDiccionario() {
        System.out.println(this);
    }

    /**
     * Representación textual del diccionario
     */
    public String toString() {
        String texto = "";
        for (int i = 0; i < pos; i++) {
            texto += listaPalabras[i].toString() + "\n";
        }
        return texto;
    }

}
