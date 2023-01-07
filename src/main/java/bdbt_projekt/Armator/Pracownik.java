package bdbt_projekt.Armator;

public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;

    public Pracownik(){
    }

    public Pracownik(int id, String imie, String nazwisko){
        super();
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}

