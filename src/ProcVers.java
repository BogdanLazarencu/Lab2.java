import java.io.*;
import java.util.*;

public class ProcVers {
    public static void main(String[] args) {
        String inputFileName = "src/cantec_in.txt";
        String outputFileName = "cantec_out.txt";
        String grupareAleasa = "re"; // Modifică aici dacă e nevoie de altă grupare

        List<Vers> versuri = new ArrayList<>();
        Random random = new Random();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             PrintWriter pw = new PrintWriter(new FileWriter(outputFileName))) {

            String linie;
            while ((linie = br.readLine()) != null) {
                versuri.add(new Vers(linie));
            }

            for (Vers vers : versuri) {
                StringBuilder outputLine = new StringBuilder();
                outputLine.append(vers.getVers());
                outputLine.append(" | Cuvinte: ").append(vers.numarCuvinte());
                outputLine.append(" | Vocale: ").append(vers.numarVocale());

                if (vers.seIncheieCu(grupareAleasa)) {
                    outputLine.append(" *");
                }

                if (random.nextDouble() < 0.1) {
                    pw.println(outputLine.toString().toUpperCase());
                } else {
                    pw.println(outputLine);
                }
            }

        } catch (IOException e) {
            System.err.println("Eroare la procesarea fișierului: " + e.getMessage());
        }
    }
}
