import javax.persistence.Embeddable;

@Embeddable
public class AdresTbl {
    String miasto;
    String ulica;
    String kod;

    public AdresTbl(String miasto, String ulica, String kod) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.kod = kod;
    }

    public AdresTbl() {
    }
}
