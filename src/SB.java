import java.util.Scanner;

public class SB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți șirul principal: ");
            String sir = scanner.nextLine();
             StringBuilder sb = new StringBuilder(sir);

        System.out.print("Introduceți șirul de inserat: ");
        String sirnou = scanner.nextLine();
        System.out.print("Introduceți poziția la care doriți să inserați șirul: ");
        int poz = scanner.nextInt();
        scanner.nextLine();

        if (poz >= 0 && poz <= sb.length()) {
            sb.insert(poz, sirnou);
            System.out.println("Șirul după inserare: " + sb);
        } else {
            System.out.println("Poziție invalidă pentru inserare.");
        }

        System.out.print("Introduceți poziția de început a ștergerii: ");
        int sd = scanner.nextInt();
        System.out.print("Introduceți numărul de caractere de șters: ");
        int snr = scanner.nextInt();

        if (sd >= 0 && sd < sb.length() && sd + snr <= sb.length()) {
            sb.delete(sd, sd + snr);
            System.out.println("Șirul după ștergere: " + sb);
        } else {
            System.out.println("Eroare la alegerea pozitiei ( sirul e mai mic ).");
        }

        scanner.close();
    }
}
