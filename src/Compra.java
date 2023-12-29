import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Compra {

    private static void comprarCancion(int clienteId, int cancionNumero) {

        System.out.println("Cliente " + clienteId + " comprando cancion " + cancionNumero);

        try {
            Thread.sleep(cancionNumero * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cliente " + clienteId + " compro cancion " + cancionNumero);
    }

    private static String getTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date(timestamp));
    }

    public static void main(String[] args) {
        String tiempoFinalizacion = "";
        int canciones[] = { 1, 2, 3, 4, 5 };
        int clienteId = Integer.parseInt(args[0]);
        System.out.println("Cliente " + clienteId + " inicio la compra");
        long startTime = System.currentTimeMillis();

        for (int cancionNumero = 0; cancionNumero < canciones.length; cancionNumero++) {
            comprarCancion(clienteId, canciones[cancionNumero]);
        }
        long endTime = System.currentTimeMillis();
        tiempoFinalizacion = String.format(
                "El cliente %d finalizo la compra \n Inicio de Compra: %s \n Final de la compra: %s", clienteId,
                getTime(startTime), getTime(endTime));
    }

}
