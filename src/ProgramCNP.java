import java.util.Scanner;

public class ProgramCNP {
    public static boolean esteCnpValid(String cnp) {
        if (cnp.length() != 13) return false;
        if (!cnp.matches("\\d{13}")) return false;

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' || primaCifra != '2' || primaCifra != '5' || primaCifra != '6') return true;

        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }
        int cifraControl = suma % 11;
        if (cifraControl == 10) cifraControl = 1;

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumăm linia rămasă

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceți informațiile pentru persoana " + (i + 1) + ":");
            System.out.print("Nume: ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.print("CNP: ");
                cnp = scanner.nextLine();
                if (esteCnpValid(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid. Vă rugăm să reintroduceți.");
                }
            }
            persoane[i] = new Persoana(nume, cnp);
        }
        System.out.println("\nInformațiile introduse:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana.getNume() + ", " + persoana.getCnp() + ", " + persoana.getVarsta() + " ani");
        }
        scanner.close();
    }
}