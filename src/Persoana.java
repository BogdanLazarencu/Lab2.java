import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        // Extragem data nașterii din CNP
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        // Determinăm secolul nașterii
        char primaCifra = cnp.charAt(0);
        if (primaCifra == '1' || primaCifra == '2') {
            an += 1900;
        } else if (primaCifra == '5' || primaCifra == '6') {
            an += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();

        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }
}


