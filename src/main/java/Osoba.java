import javax.persistence.*;
// Encja wrzucana do dwóch tablic osoba i adres
@Entity
@Table(name = "osoba")
@SecondaryTable(name = "adres")
public class Osoba {
    @Id
    @GeneratedValue
    int id;
    String imie;
    String nazwisko;
    int wiek;
    @Column(table = "adres")
    String miasto;
    @Column(table = "adres")
    String ulica;
    @Column(table = "adres")
    String kod;

    public Osoba() {
    }

    public Osoba(String imie, String nazwisko, int wiek, String miasto, String ulica, String kod) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kod = kod;
    }
}
