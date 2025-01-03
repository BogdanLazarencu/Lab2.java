import java.io.*;
import java.util.*;

public class Judete {
    public static void main(String[] args) {
        try {
            // Citire din fișier
            BufferedReader reader = new BufferedReader(new FileReader("src/judete_in.txt"));
            List<String> jList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                jList.add(line.trim());
            }
            reader.close();
            String[] judete = jList.toArray(new String[0]);
            Arrays.sort(judete);

            System.out.println("Județele ordonate arata asa:");
            for (String judet : judete) {
                System.out.println(judet);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți numele județului: ");
            String judetCautat = scanner.nextLine().trim();

            int pozitie = Arrays.binarySearch(judete, judetCautat);

            if (pozitie >= 0) {
                System.out.println("Județul " + judetCautat + " se află pe poziția " + pozitie + " în vectorul ordonat.");
            } else {
                System.out.println("Județul " + judetCautat + " nu a fost găsit.");
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }
}
