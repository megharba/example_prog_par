import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SequentialCSVProcessing {
    private static int processLine(String[] line) {
        return line.length;  // Exemple de traitement: compter les cellules
    }

    public static void main(String[] args) {
        String csvFile = "generated_data.csv"; // Remplacez par votre fichier CSV
        long startTime = System.currentTimeMillis();
        int totalCells = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                totalCells += processLine(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("Temps d'exécution séquentiel : " + timeElapsed + " ms");
        System.out.println("Nombre total de cellules traitées : " + totalCells);
    }
}
