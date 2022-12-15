public class Main {
    public static void main(String[] args) {
        ContadorDias c = new ContadorDias();
        int dias = c.contarDias(13,12,2022);
        System.out.println("Días transcurridos hasta el 13 de Diciembre de 2022: " + dias);
    }
}
