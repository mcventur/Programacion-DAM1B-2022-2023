/**
 * Clase que modela a un alumno
 */
public class Alumno {
    public static final int MAX_ASIGNATURAS = 5;
    private final String nombre;
    private final int[] notas;
    private int pos; //Este atributo almacenará el tamaño ocupado realmente del array, o
    //lo que es equivalente: la posición a escribir el próximo elemento

    /**
     * @param nombre el nombre del alumno
     *               inicializa adecuadamente los atributos
     */
    public Alumno(String nombre) {
        this.nombre = nombre;
        //En este caso, la cantidad máxima de elemento viene dada en una constante
        //pero podría venir como parámetro en el constructor
        notas = new int[MAX_ASIGNATURAS];
        pos = 0; //Al empezar, tenemos 0 elementos.
    }

    /**
     * Devuelve true si el array notas está lleno
     */
    public boolean notasLleno() {
        //Sólo tenemos que comparar la cantidad de elementos reales del array con su capacidad máxima
        //Podríamos usar la constante MAX_ASIGNATURAS para la capacidad máxima
        //pero queda más genérico usar .length
        return pos == notas.length;
    }

    /**
     * @param nota la nota del alumno que hay que registrar
     */
    public void registrarNota(int nota) {
        if (!notasLleno()) {//Si aún caben elementos en el array
            notas[pos] = nota;//Guardamos el elemento en la posición que corresponde.
            pos++;//Aumentamos el atributo con la cantidad de elementos
        }
    }

    /**
     * Calcular y devolver el nº de suspensos
     */
    public int totalSuspensos() {
        //Recorremos el array contabilizando notas menores que 5
        int suspensos = 0;
        //OJO: el array se recorre desde el inicio hasta su ocupación REAL. No hasta el .length (como de costumbre)
        for (int i = 0; i < pos; i++) {
            if (notas[i] < 5) suspensos++;
        }
        return suspensos;
    }

    /**
     * Representación textual del alumno de la forma
     * Nombre: XXXXX Notas: XX  XX  XX ......
     */
    public String toString() {
        //En los toString solemos declarar una variable tipo String,
        // que iremos cumplimentando a base de concatenar fragmentos
        String texto = "";
        texto += "Nombre: " + nombre + ", Notas: ";
        //De nuevo, vamos desde 0 hasta la cantidad real de elementos
        for (int i = 0; i < pos; i++) {
            texto += notas[i] + "\t";
        }
        //Le meto un salto de línea al final
        texto += "\n";
        return texto;
    }
} 
