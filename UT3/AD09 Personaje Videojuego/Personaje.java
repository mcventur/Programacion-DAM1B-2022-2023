
/**
 *  
 * 
 * @author  
 * @version  
 */
public class Personaje
{
    //Constantes
    private final char NORTE = 'N';
    private final char SUR = 'S';
    private final char ESTE = 'E';
    private final char OESTE = 'O';
    //Atributos 
    private String nombre;
    private int x;
    private int y;
    private char orientacion;

    /**
     * Constructor  
     */
    public Personaje(String queNombre)    {
        nombre = queNombre;
        x = 0;
        y = 0;
        orientacion = NORTE;
    }

    /**
     * Modifica las coordenadas del personaje que
     * avanzar� la distancia (en unidades) especificada como par�metro
     */
    public void avanzar(int queDistancia) {
        switch(orientacion){
            case NORTE:
                y += queDistancia;
                //y = y + queDistancia;
                break;
            case SUR:
                y -= queDistancia;
                break;
            case ESTE:
                x += queDistancia;
                break;
            case OESTE:
                x -= queDistancia;
        }
    }

    /**
     * cambia la orientaci�n del personaje que siempre gira
     * en sentido horario
     */
    public void girar() {
        switch(orientacion){
            case NORTE:
                orientacion = ESTE;
                break;
            case ESTE:
                orientacion = SUR;
                break;
            case SUR:
                orientacion = OESTE;
                break;
            case OESTE:
                orientacion = NORTE;
        }
    }
    
    
    public String toString(){
        return "Personaje = " + nombre + "\n" + 
        "Orientacion " + orientacion + "\n" + 
        "Posici�n [" + x + "," + y + "]\n"; 
    }
    
}




