
/**
 *  
 * 
 * @author  Marce
 * @version  
 */
public class TresNumeros
{
     private int num1;
     private int num2;
     private int num3;
     

    /**
     * Constructor  
     */
    public TresNumeros(int queNum1, int queNum2, int queNum3)    {
         num1 = queNum1;
         num2 = queNum2;
         num3 = queNum3;
    }

    /**
     *  devuelve el valor máximo de los tres números. Haz una versión sin
     *  utilizar el operador lógico && y usando variables auxiliares.
     */
    public int getMaximo() {
        int max = num1;
        
        if(num2 > max){
            max = num2;   
        }
        
        if(num3 > max){
            max = num3;
        }
        
        return max;
    }
    
    /**
     * devuelve el mínimo de los 3
     */
    public int getMinimo(){

        if(num1 <= num2 && num1 <= num3){
            return num1;
        }
        else if (num2 <= num1 && num2 <= num3){
            return num2;
        }
        else{
            return num3;
        }
    }
    
    /**
     * Devuelve true si los 3 numeros son iguales
     */
    public boolean sonIguales(){
        return num1 == num2 && num1 == num3;
    }
    
    /**
     * Devuelve cuántos de los 3 números son pares
     */
    public int cuantosPares(){
        int pares = 0;
        
        if(num1 % 2 == 0){
            pares++;
        }
        
        if(num2 % 2 == 0){
            pares++;
        }
        
        if(num3 % 2 == 0){
            pares++;
        }
        
        return pares;
    }
    
    /**
     * devuelve cuántos de los 3 números acaban en 7
     */
    public int cuantosAcabanEn7(){
        int acaban = 0;
        
        if(num1 % 10 == 7){
            acaban++;
        }
        
        if(num2 % 10 == 7){
            acaban ++;
        }
        
        if (num3 % 10 == 7){
            acaban ++;
        }
        
        return acaban;
    }
    
    /**
     * ordena los atributos en orden ascendente
     * sin usar &&, con variables auxiliares
     */
    public void ordenar(){
    
        //Comparamos e intercambiamos valores directamente para ordenarlos
        //Vamos comprobando si están mal colocados, hundiendo el menor hacia num1
        //el orden de los if es importante
        if(num2 < num1){
            int aux = num1;
            num1 = num2;
            num2 = aux;
        }
        if(num3 < num1){
            int aux = num1;
            num1 = num3;
            num3 = aux;
        }
        
        //Ya tenemos seguro el mínimo en num1. 
        //Ahora comprobamos si hay que intercambiar num2 y num3. 
        if(num3 < num2){
            int aux = num2;
            num2 = num3;
            num3 = aux;
        }
    }
}
