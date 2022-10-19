
/**
 *  
 * 
 * @author  Marce
 */
public class Fecha
{
     private int dia;
     private int mes;
     private int anyo;
     
     

    /**
     * Constructor  
     */
    public Fecha(int queDia, int queMes, int queAnyo)    {
         dia = queDia;
         mes = queMes;
         anyo = queAnyo;
    }

    /**
     * Un año es bisiesto si es múltiplo de 4 pero no de 100 aunque si de 400. 
     * (No utilices en este método la sentencia if)
     */
    public boolean esBisiesto() {
         return (anyo % 4 == 0) && (anyo % 100 !=0 || anyo % 400 == 0);
    }
    
    /**
     * devuelve la cantidad de días que tiene el mes (influirá si año es bisiesto
     * en el caso de febrero). Utiliza la sentencia switch.
     */
    public int diasMes(){
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if((anyo % 4 == 0) && (anyo % 100 !=0 || anyo % 400 == 0)){
                    return 29;
                }
                else return  28;
            default:
                System.out.println("Si sale esto es que hemos metido un mes incorrecto");
                return 0;
        }
    }
    
    /**
     * escribe la fecha en formato corto: “3 – 11 – 2005”
     */
    public void printCorta(){
        System.out.println(dia + " - " + mes + " - " + anyo);
    }
    
    /**
     * escribe la fecha en formato largo: “3 de Noviembre de 2005”.
     * Utiliza la sentencia switch.
     */
    public void printLargo(){
        String nombreMes="";
        
        switch (mes){
            case 1:
                nombreMes = "enero";
                break;
            case 2:
                nombreMes = "febrero";
                break;
            case 3:
                nombreMes = "marzo";
                break;
            case 4:
                nombreMes = "abril";
                break;
            case 5:
                nombreMes = "mayo";
                break;
            case 6:
                nombreMes = "junio";
                break;
            case 7:
                nombreMes = "julio";
                break;
            case 8:
                nombreMes = "agosto";
                break;
            case 9:
                nombreMes = "septiembre";
                break;
            case 10:
                nombreMes = "octubre";
                break;
            case 11:
                nombreMes = "noviembre";
                break;
            case 12:
                nombreMes = "diciembre";
            // Asumo que no hay errores en el número de mes, no pongo default:
        }
        System.out.println(dia  + " de " + nombreMes + " de " + anyo);
    }
    
    /**
     * devuelve true si la fecha que contiene el objeto es correcta
     */
    public boolean esCorrecta(){
        if(dia < 1 || dia < 31)
            return false;
        
        if(mes < 1 || mes > 12){
            return false;
        }

        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return dia <= 31;
            case 4: case 6: case 9: case 11:
                return dia <= 30;
            case 2:
                if((anyo % 4 == 0) && (anyo % 100 !=0 || anyo % 400 == 0)){
                    return dia <= 29;
                }
                else return  dia <= 28;
            default:
                //No se puede llegar aquí, pero lo ponemos para que nos deje compilar
                return false;
        }        
    }
    
    //Funciones AD 14
    
    /**
     * devuelve true si la
     * fecha que guarda el objeto actual precede a la fecha que representan los tres parámetros que
     * se pasan al método. Suponemos que la fecha representada por los tres parámetros es
     * correcta.
     */
    public boolean precedeA(int queDia, int queMes, int queAnyo) {
        return (anyo < queAnyo) ||
        (anyo == queAnyo && (mes < queMes || 
                (mes == queMes &&  dia < queDia)));
    }
    
    /**
     * avanza un dia la fecha
     */
    public void avanzarDia(){
        //Empiezo calculando los dias del mes en curso
        int diasMes = 31;
        switch (mes){
            case 4: case 6: case 9: case 11:
                diasMes = 30;
                break;
            case 2:
                if((anyo % 4 == 0) && (anyo % 100 !=0 || anyo % 400 == 0)){
                    diasMes = 29;
                }
                else diasMes = 28;
        }
        
        dia ++; //Incrementamos el dia y evaluamos el resultado a continuación
        
        //Si el día siguiente supera los dias del mes
        if (dia > diasMes) {
            dia = 1;
            mes ++;
            //Si el mes al incrementarse supera el 12
            if(mes > 12){
                mes = 1;
                anyo ++;
            }            
        }

    }
}
