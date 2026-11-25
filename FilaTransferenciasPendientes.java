import java.util.LinkedList;
import java.util.Queue;

public class FilaTransferenciasPendientes {
    private static FilaTransferenciasPendientes instancia;
    private Queue<String> filaTransferencias;

    private FilaTransferenciasPendientes() {
        this.filaTransferencias = new LinkedList<>();
    }

    public static FilaTransferenciasPendientes getInstancia() {
        if (instancia == null) {
            instancia = new FilaTransferenciasPendientes();
        }
        return instancia;
    }

    public void agregarALaFila(String detalleTransferencia) {
        filaTransferencias.add(detalleTransferencia);
        System.out.println("[FILA] Ingresó: " + detalleTransferencia + " (En espera: " + filaTransferencias.size() + ")");
    }

    public void procesarSiguiente() {
        if (filaTransferencias.isEmpty()) {
            System.out.println("[FILA] No hay transferencias pendientes.");
        } else {
            String atendida = filaTransferencias.poll();
            System.out.println("[PROCESADA] Se completó -> " + atendida);
        }
    }
}