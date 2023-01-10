import java.util.ArrayList;
import java.util.Arrays;

public class AppUT5EjerArrays {
    public static void main(String[] args) {
        UT5EjerArrays ej = new UT5EjerArrays();

        //Prueba ejercicio 5.6
        double media = ej.calcularMedia(new double[]{10, 4.5, 6.5});
        System.out.println("La media de 10, 3.5 y 6.5 es " + media);

        //Prueba 5.7
        int max = ej.devolverMaximo(new int[]{12, 5, 2, -24, 45, 33});
        System.out.println("El máximo de 12, 5, 2,-24, 45, 33 es " + max);

        //Prueba 5.8
        int[] ej5_8 = {12, 6, 7, 5, 14, 9, 5};
        int[] pares = ej.filtrarPares(ej5_8);
        int[] paresV2 = ej.filtrarParesV2(ej5_8);
        System.out.print("Array sin filtrar: ");
        System.out.println(Arrays.toString(ej5_8));
        System.out.println("Filtrados pares: " + Arrays.toString(pares));
        System.out.println("Filtrados pares v2: " + Arrays.toString(paresV2));

        //Prueba 5.9
        int[] nums = {1, 2, 3, 4};
        System.out.println("Antes de rotar a la derecha: " + Arrays.toString(nums));
        ej.rotarDerechaV1(nums);
        System.out.println("Después de rotar a la derecha: " + Arrays.toString(nums));
        int[] nums2 = {1, 2, 3, 4};
        ej.rotarDerechaV2(nums2);
        System.out.println("Después de rotar a la derecha V2: " + Arrays.toString(nums2));
        int[] nums3 = {1, 2, 3, 4};
        ej.rotarDerechaV3(nums3);
        System.out.println("Después de rotar a la derecha V3: " + Arrays.toString(nums3));

        //Prueba ej 5.10
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println("Antes de expandir: " + Arrays.toString(nums));
        int[] expandido = ej.expandir(nums);
        System.out.println("Después de expandir: " + Arrays.toString(expandido));

        //Prueba ej 5.11
        int[] arrFrecuencias = ej.calcularFrecuencias();
        System.out.println("Probando la función calcularFrecuencias():");
        for (int i = 0; i < arrFrecuencias.length; i++) {
            System.out.println("Apariciones del " + (i + 1) + ": " + arrFrecuencias[i]);
        }


        /*Pruebas funciones extras navidades */
        separador();
        System.out.println("\n----------- navidades01() ---------------");
        int[] numeros = new int[]{2034, 12, 223, 5432, 9999};
        System.out.println(Arrays.toString(numeros));
        UT5EjerArrays.navidades01(numeros);

        separador();

        System.out.println("\n----------- puente02() ---------------");
        numeros = new int[]{2, 5, 7, 12, 9, 3};
        UT5EjerArrays.navidades02(numeros);

        separador();

        System.out.println("\n----------- puente03() ---------------");
        numeros = new int[]{2, 15, 7, 12, 9, 3};
        System.out.println(Arrays.toString(numeros));
        int a = 1;
        int b = 4;
        System.out.println("Copia ordenada en el intervalo [" + a + ", " + b + "]\n" +
                Arrays.toString(UT5EjerArrays.navidades03(numeros, a, b)));
        a = 4;
        b = 5;
        System.out.println("Copia ordenada en el intervalo [" + a + ", " + b + "]\n" +
                Arrays.toString(UT5EjerArrays.navidades03(numeros, a, b)));
        a = 1;
        b = 14;
        System.out.println("Copia ordenada en el intervalo [" + a + ", " + b + "]\n" +
                Arrays.toString(UT5EjerArrays.navidades03(numeros, a, b)));
    }

    public static void separador() {
        System.out.println("*************************************");

    }
}
