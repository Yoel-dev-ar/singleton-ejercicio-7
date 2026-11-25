public class Main {
    public static void main(String[] args) {
        FilaTransferenciasPendientes filaAppCelular = FilaTransferenciasPendientes.getInstancia();
        FilaTransferenciasPendientes filaPaginaWeb = FilaTransferenciasPendientes.getInstancia();

        // Llegan transferencias desde distintos canales a la misma fila
        filaAppCelular.agregarALaFila("Ana envía $50.000 a Carlos");
        filaPaginaWeb.agregarALaFila("Luis envía $120.000 a María");
        filaAppCelular.agregarALaFila("Pedro envía $15.000 a Sofía");

        System.out.println("\n--- Ejecutando pagos en orden ---");
        filaPaginaWeb.procesarSiguiente(); // Atiende a Ana primero
        filaAppCelular.procesarSiguiente(); // Atiende a Luis segundo

        System.out.println("\n¿Ambos canales usan la misma fila?: " + (filaAppCelular == filaPaginaWeb));
    }
}