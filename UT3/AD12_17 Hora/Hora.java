
/**
 *  
 * 
 * @author  
 * @version  
 */
public class Hora
{
     private int horas;
     private int minutos;
     private int segundos;
     

    /**
     * Constructor  
     */
    public Hora(int queHora, int queMinutos, int queSegundos)    {
         horas = queHora;
         minutos = queMinutos;
         segundos = queSegundos;
    }

    /**
     * devuelve la hora que guarda el objeto Hora en segundos
     */
    public int aSegundos() {
         return horas * 3600 + minutos * 60 + segundos;
    }
    
    /**
     * Incrementa un segundo la hora
     */
    public void avanzarSegundo(){
        segundos ++;
        if(segundos == 60){
            segundos = 0;
            minutos ++;
            if(minutos == 60){
                minutos = 0;
                horas ++;
                if(horas == 24){
                    horas = 0;
                    //Avanzaría la fecha, de haberla
                }
            }
        }
    }
    
    /**
     * Decrementa un segundo la hora
     */
    public void atrasarSegundo(){
        segundos--;
        if(segundos == -1){
            segundos = 59;
            minutos --;
            if(minutos == -1){
                minutos = 59;
                horas --;
                if (horas == -1){
                    horas = 23;
                }
            }
        }
    }
    
    @Override //Anotación opcional. Le indica al compilador que el método sobreescribe uno heredado de una clase padre
    public String toString(){
        String strHoras = "" + horas;
        String strMinutos = "" + minutos;
        String strSegundos = "" + segundos;
        
        //Si es necesario, añadimos un 0 a la izquierda a cualquiera de los 3 trozos de la hora
        if(horas<10){
            strHoras = "0" + horas;
        }
        
        if(minutos < 10){
            strMinutos = "0" + minutos;
        }
        
        if(segundos < 10){
            strSegundos = "0" + segundos;
        }
        
        return strHoras  + ":" + strMinutos + ":" + strSegundos;
    }
    
    //Funciones de la actividad 17
    public String enFormatoAmPm(){
        int horaAmPm;
        String amPm="";
        
        //Calculamos el valor de hora equivalente en formato AM/PM
        horaAmPm = horas % 12;
        
        //00:12:07 se devuelve como 12:12:07 AM
        if(horaAmPm == 0){
            horaAmPm = 12;
        }
        
        //Calulamos si es AM o PM. 
        if(horas / 12 < 1){
            amPm = "AM";
        }
        else{
            amPm = "PM";
        }
        
        
        //Seguimos el mismo procedimiento que en la función toString() 
        //para añadir un 0 a la izquierda en cada campo si es necesario
        String strHoras = "" + horaAmPm;
        String strMinutos = "" + minutos;
        String strSegundos = "" + segundos;        
        
        if(horaAmPm<10){
            strHoras = "0" + horaAmPm;
        }
        
        if(minutos < 10){
            strMinutos = "0" + minutos;
        }
        
        if(segundos < 10){
            strSegundos = "0" + segundos;
        }
        
        return strHoras  + ":" + strMinutos + ":" + strSegundos + " " + amPm;        
        
        
        
    }
    
}
