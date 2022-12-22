import java.util.Arrays;

/**
 * Modela una lista de números
 * Tiene un atributo que es un array
 */
public class ListaNumeros {
    private final int[] numeros;
    private int pos;

    /**
     * @param n el tamaño máximo del array
     */
    public ListaNumeros(int n) {
        numeros = new int[n];
        pos = 0;  // longitud lógica
    }

    /**
     * Constructor sobrecaragdo
     * Creamos el array a partir de otro que se recibe como parámetro
     */
    public ListaNumeros(int[] array) {
        numeros = array;
        pos = array.length;
    }

    /**
     * Añadir un nº a la lista solo si no está completa
     */
    public void addNumero(int valor) {
        if (pos < numeros.length) {
            numeros[pos] = valor;
            pos++;
        }
        else{
            System.out.println("No se admite el valor: " + valor + ". La lista está llena");
        }
    }

    /**
     * Representación textual de la lista
     */
    public String toString() {
        return Arrays.toString(Arrays.copyOf(numeros,pos));
    }

    /**
     * Comprueba si la lista de números está completa o no
     */
    public boolean estaLlena() {
        return pos == numeros.length;
    }

    /**
     * Calcula y devuelve la suma de todos los nºs
     */
    public int suma() {
        int suma = 0;

        //Ojo: sólo recorremos hasta la última posición con valor recogido: pos - 1
        for (int i = 0; i < pos; i++) {
            suma += numeros[i];
        }
        return suma;
    }


    /**
     * Añadir un nº a la lista en una posición
     */
    public void insertarEnPosición(int valor, int p) {
        //Diapositivas 90 a 92 de presentación I
        //Tenemos que desplazar hacia la derecha todos los elementos desde el punto de inserción hasta el final
        //Primero comprobamos que hay espacio
        if (!estaLlena()) {
            //Podemos comprobar que la posición de inserción es correcta, en el rango [0,pos)
            if (p >= 0 && p < pos) {
                //Para rotar derecha, recordad que es más fácil de derecha a izquierda
                //Vamos recorriendo de derecha a izquierda, haciendo el desplazamiento, hasta llegar al punto de inserción
                for (int i = pos - 1; i >= p; i--) {
                    numeros[i + 1] = numeros[i];
                }
                //Hacemos la inserción, una vez desplazados los elementos a su derecha
                numeros[p] = valor;
                pos++; //Contabilizamos el nuevo elemento
            }
        }

    }

    /**
     * Añadir un nº a la lista en una posición
     * Versión 2: con System.arraycopy para hacer el desplazamiento de elementos a la derecha
     */
    public void insertarEnPosiciónV2(int valor, int p) {
        //Diapositiva 93 de la presentación I UT5
        if (!estaLlena()) {
            if (p >= 0 && p < pos) {
                //Desplazamiento a la derecha de los elementos desde el punto de inserción en adelante
                System.arraycopy(numeros, pos, numeros, pos + 1, pos - p);
                //Hacemos la inserción
                numeros[p] = valor;
                pos++; //Contabilizamos el nuevo elemento
            }
        }

    }

    /**
     * Añadir un nº a la lista de forma que quede ordenada
     */
    public void insertarEnOrden(int valor) {
        //Diapositiva 94 a 97 de presentación I UT5
        //Se supone que al array está ordenado. Pero lo voy a ordenar por si acaso
        Arrays.sort(numeros);//Como es un array de enteros, lo puedo ordenar con la función Arrays.sort

        int i = pos - 1;
        //Voy recorriendo de derecha a izquierda y desplazando hasta encontrar el punto de inserción
        while (i >= 0 && numeros[i] > valor) {
            numeros[i + 1] = numeros[i];
            i--;
        }
        //Llegados a este punto, el punto de inserción es i + 1
        numeros[i + 1] = valor;
        pos++;
    }

    /**
     * Borrar un elemento de una posición
     */
    public void borrar(int posicion) {
        //Diapositiva 49 de presentación I UT5
        //Compruebo la posición correcta: [0, pos)
        if (posicion >= 0 && posicion < pos) {
            for (int i = posicion + 1; i < pos; i++) {
                numeros[i - 1] = numeros[i];
            }
            pos--;
        }
    }

    /**
     * Versión con System.arraycopy
     */
    public void borrarV2(int posicion) {
        //Diapositiva 53 de presentación I UT5
        if (posicion >= 0 && posicion < pos) {
            System.arraycopy(numeros, posicion + 1, numeros, posicion, pos - posicion - 1);
            pos--;
        }
    }

    /**
     * Borrar varios elementos
     * Con while de avance condicionado, de izquierda a derecha
     */
    public void borrarImpares() {
        //Diapositivas 54 a 56 de Presentación I UT5
        int i = 0;
        while (i < pos) {
            if(numeros[i] % 2 != 0){
                borrar(i);//Valdría también borrarV2()
            }
            else{
                i++; //Sólo avanzamos cuando no toque borrar en esa posición
            }
        }
    }

    /**
     * Versión con for. Recorriendo de derecha a izquierda
     */
    public void borrarImparesV2() {
        //Diapositivas 54 a 56 de Presentación I UT5
        for (int i = pos -1; i >= 0 ; i--) {
            if(numeros[i] % 2 != 0){
                borrarV2(i); //Valdría también borrar()
            }
        }
    }

    /**
     * Borra todos los elementos del array
     */
    public void borrarTodos(){
        //Así de simple. No se borra realmente, pero sí "nos olvidamos" de todos.
        pos = 0;
    }

}
