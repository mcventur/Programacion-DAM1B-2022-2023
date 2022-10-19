
/**
 *  
 * 
 * @author  
 * @version  
 */
public class Calculadora
{
     private int cantidad;
     private int suma;
     private int maximo;
     private int minimo;
     

    /**
     * Constructor  
     */
    public Calculadora()    {
         cantidad = 0;
         suma = 0;
         maximo = 0;
         minimo = 0;
    }

    /**
     * Accesores
     */
    public int getCantidad() {
         return cantidad;
    }
    
    public int getMinimo(){
        return minimo;
    }
    
    public int getMaximo(){
        return maximo;
    }
    
    /**
     * Añade un nuevo número a la calculadora, 
     * actualizando los parámetros convenientemente
     */
    
    public void introducirNumero(int numero){
        cantidad++;
        suma += numero;
        
        if(cantidad == 1){ // Si es el primer número, será el máximo y el mínimo
            maximo = numero;
            minimo = numero;
        }
        else{
            if(numero > maximo)
                maximo = numero;
                
            if(numero < minimo)
                minimo = numero;
        }
    }
    
    /**
     * devuelve la media de todos los valores introducidos
     */
    public double getMedia(){
        //Multiplico por 1.0 para que el resultado sea double
        return 1.0 * suma / cantidad;
    }
    
    /**
     * Otras opción para el getMedia
     */
    public double getMediaV2(){
        //Conversión explícita de alguno de los dos parámetros
        return  (double) suma / cantidad;
    }    
    
}
