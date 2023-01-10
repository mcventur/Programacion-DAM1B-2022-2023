/**
 * 
 *  
 */
public class AppDiccionario
{

    /**
     *   crea el diccionario
     *   crea e inicia el interfaz
     *  
     */
    public static void main(String[] args)
    {
        Diccionario d = new Diccionario(5);
        InterfazDiccionario interfaz = new InterfazDiccionario(d);
        interfaz.iniciar();
    }
}
