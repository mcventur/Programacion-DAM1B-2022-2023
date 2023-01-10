
/**
 * clase InterfazDiccionario 
 *  
 */
import javax.swing.*;
import java.util.Scanner;
public class InterfazDiccionario
{
    private static final int AÑADIR = 1;
    private static final int MOSTRAR = 2;
    private static final int TRADUCIR = 3;
    private static final int SALIR = 4;

    private Scanner teclado;
    private Diccionario diccionario;

    /**
     * Constructor de objetos de la clase InterfazDiccionario
     * Crea e inicializa adecuadamente los atributos
     */
    public InterfazDiccionario(Diccionario diccionario)
    {
        teclado = new Scanner(System.in);
        this.diccionario = diccionario;

    }

    /**
     * Incluye la lógica de la aplicación
     *  
     */
    public void iniciar()
    {
        borrarPantalla();
        int opcion = menu();
        while (opcion !=4)     {
            switch (opcion){
                case AÑADIR:
                    añadirPalabra();
                    break;
                case MOSTRAR:
                    mostrarDiccionario();
                    break;
                case TRADUCIR:
                    traducirPalabra();
                    break;
                case SALIR:
                    System.out.println("Hasta luego");
            }
            opcion = menu(); 
        }
    }

    /**
     * Presenta el menú - pide una opción y la valida
     * 
     * @return  la opción seleccionada ya validada
     */
    private int menu()
    {
        System.out.println("********************************");
        System.out.println("Gestión de un diccionario\n");
        System.out.println("********************************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Mostrar diccionario");
        System.out.println("3. Traducir palabra");
        System.out.println("4. Salir");
        System.out.print("Teclea opción: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion))    {
             System.out.print("Opción incorrecta, Teclea opción: ");
             opcion = teclado.nextInt();
        }
        return opcion;

    }

    /**
     *  Valida una opción recibida como parámetro
     *  Devuelve true si la opción es correcta, false en otro caso
     *   Sin if
     */
    private boolean opcionValida(int opcion)
    {
		return opcion >= AÑADIR && opcion <= SALIR;
    }

    /**
     * Añade una nueva palabra al diccioanrio
     */
    private void añadirPalabra()
    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        // completar
        System.out.println("Introduce la palabra a añadir: ");
        System.out.print("Español: ");
        String palEsp = teclado.nextLine();
        System.out.print("Inglés: ");
        String palEng = teclado.nextLine();
        Palabra p = new Palabra(palEsp, palEng);
        diccionario.insertarPalabra(p);
    }

    /**
     * Mostrar el diccioanrio
     */
    private void mostrarDiccionario()
    {
        borrarPantalla();
        // completar
        System.out.println(diccionario.toString());
    }

    /**
     * Traducir una  palabra al diccioanrio
     */
    private void traducirPalabra()
    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        // completar
        System.out.print("Introduce la posición de la palabra a traducir: ");
        int posicion = teclado.nextInt();
        String traduccion = diccionario.traducirPalabra(posicion);
        if(traduccion!=null){
            System.out.println(traduccion);
        }
        else{
            System.out.println("No hay ninguna palabra guardada en la posición indicada");
        }


    }

    /**
     * Borrar la pantalla
     */
    private void borrarPantalla()
    {
        System.out.println("\u000C");
    }

    
    
    
}
