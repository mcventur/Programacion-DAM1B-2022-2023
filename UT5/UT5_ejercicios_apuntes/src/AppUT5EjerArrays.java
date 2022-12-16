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
    }
}
