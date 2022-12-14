import java.util.Arrays;
import java.util.Random;

public class UT5EjerArrays {
    //No ponemos constructor. Así que aplicará el constructor por defecto, sin parámetros.

    /**
     * Ejercicio 5.6
     * calcula la media del array que recibe como parámetro
     */
    public double calcularMedia(double[] notas) {
        double total = 0;
        //Sumamos cada elemento del array
        for (int i = 0; i < notas.length; i++) {
            total += notas[i];
        }
        //Devolvemos la media: total / cantidad de elementos
        return total / notas.length;
    }

    /**
     * Ejercicio 5.7
     * Define un método que reciba un array de enteros y devuelva el valor máximo
     */
    public int devolverMaximo(int[] array) {
        int max = Integer.MIN_VALUE; //Inicializamos max al menor valor posible de un int
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Ejercicio 5.8
     * Define un método que reciba como parámetro un array de enteros y devuelva otro
     * array con los valores pares encontrados en el original.
     */
    public int[] filtrarPares(int[] array) {
        //Haremos dos recorridos por el array recibido: uno para contar cuántos pares hay
        // y otro para recoger los valores pares correspondientes en el array de retorno

        int[] arrayPares; //No podemos aún indicar el tamaño del array. No sabemos cuántos pares hay
        //Primer recorrido: para contar la cantida de pares
        int cuantosPares = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                cuantosPares++;
            }
        }

        //Ya tenemos la cantidad de pares. Podemos crear nuestro array de retorno, una vez conocido su tamaño
        arrayPares = new int[cuantosPares];

        //Segundo recorrido
        //Ojo: tenemos que llevar la cuenta de la posición del array de destino en que vamos guardando.
        // (no será la misma posición que la del array original)
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayPares[pos] = array[i];
                pos++;
            }
        }

        return arrayPares;
    }

    /**
     * Ejercicio 7 (Versión 2)
     * Versión más corta usando la función Arrays.copyOf (requiere un import)
     */
    public int[] filtrarParesV2(int[] array) {
        //Creamos un primer arrayPares al mismo tamaño que al array recibido. (Como mucho todos serán pares)
        int[] arrayPares = new int[array.length];
        //Variable para ir guardando sin dejar 0 intercalados.
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrayPares[pos] = array[i];
                pos++;
            }
        }
        //Tras esto tendremos un array con todos los pares hacia el inicio del array, y ceros a continuación:
        //Ej.: [2, 8, 12, 4, -6, 0, 0,  0] (si el original tuviese 3 impares)

        //Devolvemos una copia del arraPares truncada. Nos olvidamos de todos los ceros que han quedado tras los pares
        return Arrays.copyOf(arrayPares, pos);
    }

    /**
     * Ejercicio 5.9
     * Rota una posición a la derecha cada elemento del array recibido
     */
    public void rotarDerechaV1(int[] numeros) {
        int aux = numeros[numeros.length - 1];//Guardamos el valor de la última posición

        //Lo más fácil es hacer el cambio recorriendo de derecha a izquierda
        for (int i = numeros.length - 1; i > 0; i--) {
            numeros[i] = numeros[i - 1];
        }

        numeros[0] = aux;//Escribimos al principio el valor de la última posición

        //No se devuelve nada. El array original se puede modificar al ser su referencia lo que se recibe!!
    }

    /**
     * De izquierda a derecha. Más complicado
     */
    public void rotarDerechaV2(int[] numeros) {
        int anterior = numeros[numeros.length - 1];//Guardamos el valor de la última posición
        for (int i = 0; i < numeros.length; i++) {
            int aux = numeros[i];
            numeros[i] = anterior;
            anterior = aux;
        }
        //No se devuelve nada. El array original se puede modificar al ser su referencia lo que se recibe!!
    }

    /**
     * Con System.arraycopy, con el mismo array como origen y destino
     */
    public void rotarDerechaV3(int[] numeros) {
        int ultimo = numeros[numeros.length - 1];//Guardamos el valor de la última posición
        //Copiamos cada elemento al mismo array, una posición a la derecha. Todos excepto el último, que ya hemos guardado
        System.arraycopy(numeros, 0, numeros, 1, numeros.length - 1);
        numeros[0] = ultimo;
    }

    /**
     * Ejercicio 5.10
     * expande el array original numeros de la forma:
     *  crea un nuevo array con el doble de tamaño que el original
     *  guarda en el nuevo array cada elemento del original copiado dos veces
     */
    public int[] expandir(int[] numeros) {
        int[] expandido = new int[numeros.length * 2];
        //Vamos recorriendo el array de origen
        for (int i = 0; i < numeros.length; i++) {
            expandido[i * 2] = numeros[i];
            expandido[i * 2 + 1] = numeros[i];
        }
        return expandido;
    }

    /**
     * Ejercicio 5.11
     * genera 100 nos aleatorios entre 1 y 9 y devuelve la frecuencia de aparición del valor 1, del
     * valor 2, del valor 3
     */
    public int[] calcularFrecuencias() {
        //Usaremos la posición i del array como número del que medimos la frecuancia.
        // Así que necesitamos un array de 9 posiciones
        int[] frecuencias = new int[9];
        //Generamos 100 aleatorios
        Random generador = new Random();
        for (int i = 0; i < 100; i++) {
            int aleatorio = generador.nextInt(9) + 1;
            frecuencias[aleatorio - 1]++;
        }
        return frecuencias;
    }

    /* FUNCIONES EXTRAS PARA NAVIDAD */
    /**
     *   Escribe el array recibido como argumento desde el final hasta el principio
     *   y en cada línea de la pantalla muestra el valor del elemento del array
     *   junto a la suma de sus cifras
     *
     *   Si el array recibido es {2034, 12, 223, 5432, 9999}
     *   se mostrará en pantalla:
     *
     *   9999 - 36
     *   5432 - 14
     *   223 - 7
     *   12 - 3
     *   2034 - 9
     *
     *   Hay que usar el método sumarCifras()
     *
     */
    public static void navidades01(int[] numeros)    {
        for (int i = numeros.length - 1; i >= 0; i--)  {
            System.out.println(numeros[i]  + " - " + sumarCifras(numeros[i]));
        }

    }

    /**
     *  Dado un nº devuelve la suma de sus cifras
     */
    public static int sumarCifras(int n)    {
        int suma = 0;
        while (n != 0)  {
            suma += n % 10;
            n = n / 10;
        }

        return suma;
    }

    /**
     *   Sustituir cada elemento del array numeros por el cuadrado del que está a su derecha
     *   El último se sustituye por el cuadrado del primero
     *
     *   Si el array recibido es {2, 5, 7, 12, 9, 3}
     *   al final queda {25, 49, 144, 81, 9, 4}
     *
     */
    public static void navidades02(int[] numeros)    {
        System.out.println(Arrays.toString(numeros));
        int primero = numeros[0];
        for (int i = 0; i < numeros.length - 1; i++)   {
            numeros[i] = numeros[i + 1] * numeros[i + 1];
        }
        numeros[numeros.length - 1] = primero * primero;
        System.out.println(Arrays.toString(numeros));
    }

    /**
     *   Usando solo métodos de la clase Arrays
     *   devuelve una copia ordenada del rango de valores
     *   que están en el intervalo de posiciones [a, b] (ambos inclusive)
     *   dentro de numeros
     *
     *   Si alguno de los parámetros a o b son incorrectos
     *   se devuelve como copia un array de valores -1 de la
     *   misma longitud que numeros
     *
     *   Si el array recibido es {2, 15, 7, 12, 9, 3}
     *   y llamamos a navidades03(numeros, 1, 4)
     *   se devuelve {7, 9, 12, 15}
     *
     *   Si el array recibido es {2, 15, 7, 12, 9, 3}
     *   y llamamos a navidades03(numeros, 4, 5)
     *   se devuelve {3, 9}
     *
     *   Si el array recibido es {2, 15, 7, 12, 9, 3}
     *   y llamamos a navidades03(numeros, 1, 14)
     *   se devuelve {-1, -1, -1, -1, -1, -1}
     *
     */
    public static int[] navidades03(int[] numeros, int a, int b)    {
        int[] copiaOrdenada;
        if (a < 0 || b >= numeros.length || a > b) {
            copiaOrdenada = new int[numeros.length];
            Arrays.fill(copiaOrdenada, -1);
        }
        else {
            copiaOrdenada =  Arrays.copyOfRange(numeros, a, b + 1);
            Arrays.sort(copiaOrdenada);
        }

        return copiaOrdenada;
    }


}
