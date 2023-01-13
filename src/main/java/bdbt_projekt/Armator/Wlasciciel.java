package bdbt_projekt.Armator;

public class Wlasciciel {
    private int ID_wlasciciela;
    private String Imie;
    private String Nazwisko;
    private String Nazwa_firmy;

    public Wlasciciel(){
    }

    public Wlasciciel(int ID_wlasciciela, String imie, String nazwisko, String nazwa_firmy) {
        super();
        this.ID_wlasciciela = ID_wlasciciela;
        Imie = imie;
        Nazwisko = nazwisko;
        Nazwa_firmy = nazwa_firmy;
    }

    public int getID_wlasciciela() {
        return ID_wlasciciela;
    }

    public void setID_wlasciciela(int ID_wlasciciela) {
        this.ID_wlasciciela = ID_wlasciciela;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getNazwa_firmy() {
        return Nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        Nazwa_firmy = nazwa_firmy;
    }

    @Override
    public String toString() {
        return "Wlasciciel{" +
                "ID_wlasciciela=" + ID_wlasciciela +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", Nazwa_firmy='" + Nazwa_firmy + '\'' +
                '}';
    }
}
