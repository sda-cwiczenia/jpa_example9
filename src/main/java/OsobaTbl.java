import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Dwie klasy zostają połączone w jednej tablicy ososbatbl. Klasa AdresTbl jest dołączona (osadzona) w klasie OsobaTbl

@Entity
public class OsobaTbl {
    @Id
    @GeneratedValue
    int id;
    String imie;
    String nazwisko;
    int wiek;
    @Embedded
    AdresTbl adres;

    public OsobaTbl(String imie, String nazwisko, int wiek, AdresTbl adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.adres = adres;
    }

    public OsobaTbl() {
    }
}
