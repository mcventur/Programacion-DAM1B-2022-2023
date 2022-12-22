public class DemoListaNumeros {
    public static void main(String[] args) {
        System.out.println("********************   Lista desordenada   ********************");
        ListaNumeros ln = new ListaNumeros(5);//Máximo 10 elementos
        ln.addNumero(3);
        ln.addNumero(2);
        ln.addNumero(9);
        ln.addNumero(12);
        ln.addNumero(6);
        //Este no cabrá
        ln.addNumero(8);
        System.out.println("Estado de la lista: " + ln.toString());
        //Borramos un elemento
        ln.borrar(1);
        System.out.println("Después de borrar la posición 1: " + ln.toString());
        //Borramos los impares
        ln.borrarImpares();
        System.out.println("Después de borrar los impares: " + ln.toString());


        //Pruebas con una lista ordenada
        System.out.println();
        System.out.println("********************   Lista ordenada   ********************");
        ListaNumeros lnOrdenado = new ListaNumeros(new int[]{3, 5, 6, 9, 11, 12, 16});
        System.out.println("Lista incial: " + lnOrdenado.toString());
        lnOrdenado.borrarV2(2);
        System.out.println("Después de borrar la posición 2: " + lnOrdenado.toString());
        lnOrdenado.insertarEnOrden(10);
        System.out.println("Después de insertar el 10 en orden: " + lnOrdenado.toString());
        //Borramos los impares (V2)
        lnOrdenado.borrarImparesV2();
        System.out.println("Después de borrar los impares: " + lnOrdenado.toString());

        System.out.println();
        System.out.println("********************   Borrado total   ********************");
        //Borramos todos los elementos
        ln.borrarTodos();
        System.out.println("Después de borrar todos: " + ln);
        //Comprobamos que podemos añadir unm nuevo elemento tras el borrado total
        ln.addNumero(100);
        System.out.println("Añadido un 100 tras el borrado: " + ln);

    }
}
