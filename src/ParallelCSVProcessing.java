import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParallelCSVProcessing {
    private static int processLine(String[] line) {
        return line.length;  // Exemple de traitement: compter les cellules
    }

    private static void processLines(List<String> lines, int[] totalCells) {
        for (String line : lines) {
            String[] values = line.split(",");
            totalCells[0] += processLine(values);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String csvFile = "generated_data.csv.csv"; // Remplacez par votre fichier CSV
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();
        int numThreads = 4;
        int chunkSize = lines.size() / numThreads;
        List<Thread> threads = new ArrayList<>();
        int[] totalCells = new int[1];

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? lines.size() : start + chunkSize;
            List<String> subList = lines.subList(start, end);
            Thread thread = new Thread(() -> processLines(subList, totalCells));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("Temps d'exécution parallèle : " + timeElapsed + " ms");
        System.out.println("Nombre total de cellules traitées : " + totalCells[0]);
    }
}
