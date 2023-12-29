import java.util.ArrayList;

public interface ClienteInfo {
    static ArrayList<String> listaTiempoEjecucionClientes = new ArrayList<>();
    static ArrayList<Integer> listaClientesFinalizados = new ArrayList<>();

    static void tiempoEjecucionClientes(String tiempoFinalizacion) {
        listaTiempoEjecucionClientes.add(tiempoFinalizacion);
    }

    static void clientesFinalizados(int clienteId) {
        listaClientesFinalizados.add(clienteId);
    }
}
