import java.util.Arrays;
import java.util.Random;

public class JuegoAmigoInvisible {
    private static final int MAX_PARTICIPANTES = 50;
    private static final Random generador = new Random();
    private final Participante[] participantes;
    private int pos;

    /**
     * crea la "bolsa" de participantes al tamaño máximo
     */
    public JuegoAmigoInvisible() {
        participantes = new Participante[MAX_PARTICIPANTES];
        pos = 0;
    }

    /**
     * Devuelve true si la bolsa está llena (tiene ya el maximo número de participantes)
     * false si aún hay sitio para más participantes
     */
    public boolean bolsaLlena() {
        return pos == MAX_PARTICIPANTES;
    }

    /**
     * Añade un participante al final de la bolsa si no está llena
     * se asume que el participante no existe
     */
    public void add(Participante participante) {
        if (!bolsaLlena()) {
            participantes[pos] = participante;
            pos++;
        }
    }

    /**
     * devuelve el total de participantes
     */
    public int totalParticipantes() {
        return pos;
    }

    /**
     * devuelve una copia con el número real de participantes
     */
    public Participante[] getParticipantes() {
        return Arrays.copyOf(participantes, pos);
    }

    /**
     * dado un nombre de participante devuelve la posición donde se encuentra o -1 si
     * no está
     * Nota -  para comparar cadenas haremos cadena1.equalsIgnoreCase(cadena2)
     * que devuelve true si cadena1 es igual a cadena2
     * (sin importar mayúsculas o minúsculas)
     */
    private int buscarParticipante(String nombre) {

        for (int i = 0; i < pos; i++) {
            if (participantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        //Llegados a este punto, significa que el nombre no está en la lista de participantes
        return -1;
    }

    /**
     * dado un nombre de participante indica si está ya en la bolsa
     */
    public boolean estaParticipante(String nombre) {
        //Aprovechamos la función anterior
        return buscarParticipante(nombre) != -1;
    }

    /**
     * dado un nombre de participante devuelve el objeto asociado a él
     */
    public Participante datosDe(String nombre) {
        nombre = nombre.toUpperCase();
        int p = buscarParticipante(nombre);

        if (p == -1) {
            throw new RuntimeException("Error, no existe ese participante");
        }

        return participantes[p];
    }

    /**
     * Representación textual de todos los participantes
     */
    public String toString() {
        String texto="";
        for (int i = 0; i < pos; i++) {
            texto += participantes[i].toString() + "\n";
        }
        return texto;
    }

    /**
     * "Revuelve" la bolsa de participantes.
     * Se puede hacer de forma sencilla
     * intercambiando un nº determinado de veces pares de elementos
     * del array participantes de posiciones aleatorias
     */
    public void revolverParticipantes() {
        //Voy a intercambiar elementos 50 veces (cualquier número algo alto es válido)
        for (int i = 0; i < 50; i++) {
            //Generamos de forma aleatoria las dos posiciones a intercambiar
            // en el rango [0, pos)
            int p1 = generador.nextInt(pos);
            int p2 = generador.nextInt(pos);

            //Siempre que intercambiamos valores, usamos una variable auxiliar
            //En este caso intercambiamos objetos Participante, así que nuestra variable
            //auxiliar será de ese tipo
            Participante aux = participantes[p1];
            participantes[p1] = participantes[p2];
            participantes[p2] = aux;
        }

    }

    /**
     * Elimina todas las asignaciones de emisor y receptor
     * de todos los participantes
     */
    public void reset() {
        for (int i = 0; i < pos; i++) {
            participantes[i].setEmisor(null);
            participantes[i].setReceptor(null);
        }
    }

    /**
     * Realiza la asignación a cada participante del amigo invisible
     * previo "barajeo" de la bolsa inicial
     */
    public void asignarAmigos() {
        revolverParticipantes();
        //Empiezo definiendo manualmente (fuera de bucle) los dos casos especiales
        //el primero recibe del último
        participantes[0].setReceptor(participantes[pos - 1]);
        //el último regala al primero
        participantes[pos - 1].setEmisor(participantes[0]);
        //El resto de asignaciones se pueden hacer en bucle, excluyendo estos dos casos
        for (int i = 0; i < pos; i++) {
            if (i != 0) {
                participantes[i].setReceptor(participantes[i - 1]);
            }
            if (i != pos - 1) {
                participantes[i].setEmisor(participantes[i + 1]);
            }
        }

    }

    /**
     * dado un participante lo borra. Se devuelve true si la operación ha tenido éxito
     * (estaba el participante) o false si no ha habido éxito (el participante no existía)
     * Cada vez que se borra un participante hay que eliminar
     * todas las asignaciones de emisor y receptor
     */
    public boolean borrarParticipante(String nombre) {
        int p = buscarParticipante(nombre);
        if(p != -1){
            //Ver diapositiva 53 de la presentación I UT5
            System.arraycopy(participantes, p +1, participantes, p, pos - p - 1 );
            pos--;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * borra todos los participantes
     */
    public void borrarTodos() {
        //Más que borrarlos, nos "olvidamos" de todos
        pos = 0;
    }


}
