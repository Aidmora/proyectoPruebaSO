import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TiendaMusicaProcesos {

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            for (int clienteId = 1; clienteId <= 2; clienteId++) {
                ProcessBuilder processBuilder = new ProcessBuilder("java", "src\\Compra.java",
                        String.valueOf(clienteId));
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                processes.add(process);
                executorService.submit(() -> readProcessOutput(process));
            }
            for (Process process : processes) {
                process.waitFor();
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readProcessOutput(Process process) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
