import jdk.swing.interop.SwingInterOpUtils;

import java.nio.charset.UnmappableCharacterException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 */
public class PracticaBucles {
    private static final char ASTERISCO = '*';
    private static final char CRUZ = 'X';
    private static final char ALMOHADILLA = '#';
    private static final char GUION = '-';
    private static final char ESPACIO = ' ';
    private static final Scanner teclado = new Scanner(System.in);
    private static final Random generador = new Random();


    /**
     * Escribe los impares entre 1 y 100 (con un for)
     * (con for) - escribe en cada línea 8 números
     */
    public static void metodo01() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.print(i + "\t");
        }
        System.out.println();
    }

    /**
     * Escribe los 10 primeros múltiplos de n
     * (con for) -
     * Ejemplo de Salida con n y 5:
     * 5   10  15  20  25  30  35  40 45  50
     */
    public static void metodo02(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.print((n * i) + "\t");
        }
        System.out.println();
    }

    /**
     * Detecta si n es un nº primo
     * Hazlo con un while. En cuanto detectes que el
     * nº no es primo sal del bucle con un return
     * El 1 no es un nº primo
     */
    public static boolean esPrimo(int n) {
        int divisor = n / 2; //Empiezo comprobando desde la mitad del número, que es el mayor divisor que puede tener

        while (divisor > 1) { //El 1 excluido
            if (n % divisor == 0) {
                return false;
            }
            divisor--;
        }
        return true;
    }

    /**
     * Calcula y devuelve el primo inferior más cercano a n
     * Si n = 12 el primo más cercano es 11
     * Si n = 15 el primo más cercano es 13
     * Si n = 17, el primo más cercano es el 17
     * Utiliza el método anterior para detectar si un nº es primo o no
     * Con while
     */
    public static int metodo03(int n) {
        int primo = n; //Asumimos que n ya es primo y
        while (primo > 1) {
            if (esPrimo(primo)) {
                return primo;
            }
            primo--;
        }
        //Sólo llegamos aquí si se introduce n = 1
        return 1;

    }

    /**
     * Escribe los n primeros números primos
     * Si n = 7 entonces  2   3   5   7   11   13   17
     * <p>
     * Con while
     */
    public static void metodo04(int n) {
        int cuentaPrimos = 0;
        int pruebaPrimo = 2;
        while (cuentaPrimos < n) {
            if (esPrimo(pruebaPrimo)) {
                cuentaPrimos++;
                System.out.print(pruebaPrimo + "\t");
            }
            pruebaPrimo++;
        }

    }

    /**
     * Genera y devuelve una cadena con el caracter c repetido n veces
     */
    private static String generarCadena(char c, int n) {
        String retorno = "";
        for (int i = 0; i < n; i++) {
            retorno += c;
        }
        return retorno;
    }

    /**
     * Genera aleatorios entre 0 y 50 (ambos incluídos) y por cada aleatorio escribe tantas X
     * como indique el nº .  El final del proceso termina con el 0
     * Imprime cada número alineado a la derecha a 4 posiciones
     * y a continuación, separado por un espacio, la representación con asteriscos
     * <p>
     * Hay que hacer un bucle anidado
     * <p>
     * Posible resultado
     * 18 ******************
     * 7 *******
     * 20 ********************
     * 46 **********************************************
     * 30 ******************************
     * 1 *
     * 46 **********************************************
     * 7 *******
     * 22 **********************
     * 0
     */
    public static void metodo05() {
        int aleatorio = 0;
        do {
            aleatorio = generador.nextInt(51);
            String asteriscos = generarCadena(ASTERISCO, aleatorio);
            System.out.printf("%4d %s\n", aleatorio, asteriscos);
        } while (aleatorio != 0);

    }

    /**
     * Escribe los números entre ALTO y BAJO que
     * son múltiplos de 4 pero no de 5 (con for)
     * Salida esperada: 4	8	12	16	24	28	32	36
     */
    public static void metodo06() {
        final int ALTO = 40;
        final int BAJO = 2;
        for (int i = BAJO; i <= ALTO; i++) {
            if ((i % 4 == 0) && (i % 5 != 0)) {
                System.out.print(i + "\t");
            }
        }
    }

    /**
     * Escribe la siguiente figura (10 filas y 8 columnas) con for
     * <p>
     * ########
     * ########
     * ########
     * ########
     * ########
     * ########
     * ########
     * ########
     * ########
     * ########
     */
    public static void metodo07() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(ALMOHADILLA);
            }
            System.out.println();
        }


    }

    /**
     * Cuenta y devuelve las apariciones de cifra en numero
     * (con while)
     */
    public static int metodo08(int numero, int cifra) {
        int apariciones = 0;
        while (numero > 0) {
            if (numero % 10 == cifra) {
                apariciones++;
            }
            numero /= 10;
        }

        return apariciones;

    }

    /**
     * Escribe la siguiente figura
     * (con for) - utiliza el método escribirGuiones()
     * usa las constantes adecuadas (revisa las constantes de esta clase)
     * utiliza el método escribirGuiones donde convenga
     * <p>
     * *
     * -*
     * --*
     * ---*
     * ----*
     * -----*
     */
    public static void metodo09(int filas) {
        for (int i = 0; i < filas; i++) {
            String guiones = generarCadena(GUION, i);
            System.out.println(guiones + ASTERISCO);
        }
    }

    /**
     * Calcula y escribe las 10 primeras potencias de 2 (con for)
     * Utiliza Math.pow() - Con for
     * <p>
     * 2 elevado a 0 es 1
     * 2 elevado a 1 es 2
     * 2 elevado a 2 es 4
     * 2 elevado a 3 es 8
     * 2 elevado a 4 es 16
     * 2 elevado a 5 es 32
     * 2 elevado a 6 es 64
     * 2 elevado a 7 es 128
     * 2 elevado a 8 es 256
     * 2 elevado a 9 es 512
     * 2 elevado a 10 es 1024
     */
    public static void metodo10() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("2 elevado a " + i + " es " + (int) Math.pow(2, i));
        }
    }

    /**
     * Escribe la siguiente figura donde inicio marca el primer valor
     * en la primera fila del cuadrado y fin el primer valor en la última fila del cuadrado
     * Con for
     * <p>
     * El ejemplo es para la llamada  printCuadrado(3, 8);
     * <p>
     * 3   4   5   6   7   8
     * 4   5   6   7   8   3
     * 5   6   7   8   3   4
     * 6   7   8   3   4   5
     * 7   8   3   4   5   6
     * 8   3   4   5   6   7
     */
    public static void metodo11(int inicio, int fin) {
        int fila = 0;
        int resta = fin - inicio + 1;
        for (int i = inicio; i <= fin; i++) {
            for (int j = inicio; j <= fin; j++) {
                int num = j + fila;
                if (num > fin) {
                    num -= resta;
                }
                System.out.print(num);
            }
            System.out.println();
            fila++;
        }
    }

    /**
     * Genera aleatorios entre 0 y 10
     * Calcula y escribe la longitud de la secuencia más larga de números iguales seguidos
     * El final del proceso termina con el 0
     *
     * Ej.  Para la secuencia  2  2  2  4  4  7  6  6  6  1  1  9  9  9  2  2  2  2  2  2  5  0
     *
     * el valor a mostrar sería "La longitud de la secuencia más larga de números seguidos es 6 y
     * corresponde al valor 2"
     *
     * Otras posibles ejecuciones:
     *
     * 10   10  20  27
     * La longitud secuencia más larga de números seguidos es 2
     * y  corresponde al valor 10
     *
     * 10   3   5   1   1   4   7   8   3   6
     * 10   4  10   7   3   6   7   7   3   5
     *  4   9   9   5   1   3   6   3   9
     * La longitud de la secuencia más larga es 2 y corresponde al 1
     *
     * 13 9 11 12 11 10 11
     * La longitud de la secuencia más larga es 1 y corresponde al 13
     *
     * 10   7   6   6   6   6   8   5   7   5
     *  3   5   4  10   9   5   6   6   4   9
     *  8   2   7   5   7   2   6   4  10   3
     *  5   5
     * La longitud de la secuencia más larga es 4 y corresponde al 6
     *
     *
     * Con bucles while
     */
    public static void metodo12() {
            int maxRepeticiones = 1;
            int numAnterior = 0;
            int repeticiones = 1;
            int contador = 0; //Contador para meter un salto de línea cada 10 números (Para facilitar lectura);

            int aleatorio = generador.nextInt(11);

            int numRepetidoMax = aleatorio;

            while (aleatorio != 0) {
                System.out.printf("%4d", aleatorio);
                if (numAnterior == aleatorio) {
                    repeticiones++;
                    if (repeticiones > maxRepeticiones) {
                        maxRepeticiones = repeticiones;
                        numRepetidoMax = aleatorio;
                    }
                } else {
                    numAnterior = aleatorio;
                    repeticiones = 1;
                }

                aleatorio = generador.nextInt(11);
                contador++;
                if (contador % 10 == 0) System.out.println();
            }
            System.out.println("\nLa longitud de la secuencia más larga es " + maxRepeticiones +
                    " y corresponde al " + numRepetidoMax);
    }

    /**
     * Calcula y devuelve formateado a 2 decimales el valor de la serie
     * para el valor de n proporcionado como parámetro (primero calcúlalo
     * como double y luego lo devuelves con String.format()
     * <p>
     * Hazlo con bucles for
     * <p>
     * 1 / 1  + 1 / 2! + 1 / 3! + 1 / 4! + ..........  + 1 / n
     * <p>
     * <p>
     * Para n = 3 se devuelve el valor 1.6667
     * Para n = 5 se devuelve el valor 1.7167
     * Para n = 6 se devuelve el valor 1.7181
     */
    public static String metodo13(int n)
    {
        int deno = 1;
        double suma = 1;
        for (int termino = 2; termino <= n; termino++)  {
            deno = deno * termino;
            suma = suma + (double) 1 / deno;

        }
        return String.format("%10.4f", suma);
    }

    /**
     *  Escribe los factores primos del nº n - Con while
     *
     *  Si n = 9 entonces    3   3
     *  Si n = 18 entonces    2  3   3
     *  Si n =  24    entonces 2   2  2  3
     *
     */
    public static void metodo14(int n)
    {
        int factor = 2;
        int aux = n;
        while (aux > 1)   {
            if (aux % factor == 0)       {
                System.out.print(factor + "\t");
                aux = aux / factor;
            }
            else    {
                factor++;
            }
        }
    }

    /**
     *  Escribe la siguiente figura
     *
     *  00
     *  10  11
     *  20  21  22
     *  30  31  32  33
     *  40  41  42  43  44
     *  50  51  52  53  54  55
     *  60  61  62  63  64  65  66
     *  70  71  72  73  74  75  76  77
     *  80  81  82  83  84  85  86  87  88
     *  90  91  92  93  94  95  96  97  98  99
     *
     */
    public static void metodo15()
    {
        for (int fila = 0; fila < 10; fila++)    {
            for (int col = 1; col <= (fila + 1); col++)       {
                System.out.print(fila + "" + (col - 1) + "\t");
            }
            System.out.println();
        }
    }


    /**
     * Hacer una pausa en la pantalla
     */
    public static void hacerPausa() {
        System.out.println("Pulse Intro para continuar");
        teclado.nextLine();

    }

}
