
/**
 * La clase modela un contador de días transcurridos 
 * hasta una fecha determinada
 * Ejer 5.12
 */
public class ContadorDias
{
    private int[] diasMes;

    /**
     * 
     */
    public ContadorDias()
    {
        diasMes = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    }

    /**
     * Cuenta el nº de días desde el inicio de año
     *
     * @param  mes mes actual entre 1 y 12
     * @param  dia actual  entre 1 y 31
     * @param  año actual
     * @return la cantidad de días desde el comienzo de año
     */

    public int contarDias(int dia, int mes, int año)
    {
        int numDias = dia;
        for (int i = 0; i < mes - 1; i++) {
            numDias += diasMes[i];
        }
        return numDias;
    }
    
    
    /**
     * return true si año es bisiesto
     * Un año es bisiesto si es múltiplo de 4 pero no de 100 o sí de 400
     * Hazlo sin if
     */
    private boolean esBisiesto(int año)
    {
        return (año%4==0) && ((año % 100 != 0) || (año % 400 == 0));
    }

}
