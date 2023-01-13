package bdbt_projekt.Armator;

public class Usluga {
    private int ID_uslugi;
    private String Rodzaj_uslugi;
    private int Koszt;
    private String Opis;
    private String Data_rozpoczecia;
    private String Data_zakonczenia;
    private int ID_klienta;
    private int ID_statku;
    private int ID_portu_rozpoczecia;
    private int ID_portu_zakonczenia;
    private int ID_armatora;

    public Usluga(){}

    public Usluga(int ID_uslugi, String rodzaj_uslugi, int koszt, String opis, String data_rozpoczecia, String data_zakonczenia, int ID_klienta, int ID_statku, int ID_portu_rozpoczecia, int ID_portu_zakonczenia, int ID_armatora) {
        super();
        this.ID_uslugi = ID_uslugi;
        this.Rodzaj_uslugi = rodzaj_uslugi;
        this.Koszt = koszt;
        this.Opis = opis;
        this.Data_rozpoczecia = data_rozpoczecia;
        this.Data_zakonczenia = data_zakonczenia;
        this.ID_klienta = ID_klienta;
        this.ID_statku = ID_statku;
        this.ID_portu_rozpoczecia = ID_portu_rozpoczecia;
        this.ID_portu_zakonczenia = ID_portu_zakonczenia;
        this.ID_armatora = ID_armatora;
    }

    public int getID_uslugi() {
        return ID_uslugi;
    }

    public void setID_uslugi(int ID_uslugi) {
        this.ID_uslugi = ID_uslugi;
    }

    public String getRodzaj_uslugi() {
        return Rodzaj_uslugi;
    }

    public void setRodzaj_uslugi(String rodzaj_uslugi) {
        Rodzaj_uslugi = rodzaj_uslugi;
    }

    public int getKoszt() {
        return Koszt;
    }

    public void setKoszt(int koszt) {
        Koszt = koszt;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getData_rozpoczecia() {
        return Data_rozpoczecia;
    }

    public void setData_rozpoczecia(String data_rozpoczecia) {
        Data_rozpoczecia = data_rozpoczecia;
    }

    public String getData_zakonczenia() {
        return Data_zakonczenia;
    }

    public void setData_zakonczenia(String data_zakonczenia) {
        Data_zakonczenia = data_zakonczenia;
    }

    public int getID_klienta() {
        return ID_klienta;
    }

    public void setID_klienta(int ID_klienta) {
        this.ID_klienta = ID_klienta;
    }

    public int getID_statku() {
        return ID_statku;
    }

    public void setID_statku(int ID_statku) {
        this.ID_statku = ID_statku;
    }

    public int getID_portu_rozpoczecia() {
        return ID_portu_rozpoczecia;
    }

    public void setID_portu_rozpoczecia(int ID_portu_rozpoczecia) {
        this.ID_portu_rozpoczecia = ID_portu_rozpoczecia;
    }

    public int getID_portu_zakonczenia() {
        return ID_portu_zakonczenia;
    }

    public void setID_portu_zakonczenia(int ID_portu_zakonczenia) {
        this.ID_portu_zakonczenia = ID_portu_zakonczenia;
    }

    public int getID_armatora() {
        return ID_armatora;
    }

    public void setID_armatora(int ID_armatora) {
        this.ID_armatora = ID_armatora;
    }

    @Override
    public String toString() {
        return "Usluga{" +
                "ID_uslugi=" + ID_uslugi +
                ", Rodzaj_uslugi='" + Rodzaj_uslugi + '\'' +
                ", Koszt=" + Koszt +
                ", Opis='" + Opis + '\'' +
                ", Data_rozpoczecia='" + Data_rozpoczecia + '\'' +
                ", Data_zakonczenia='" + Data_zakonczenia + '\'' +
                ", ID_klienta=" + ID_klienta +
                ", ID_statku=" + ID_statku +
                ", ID_portu_rozpoczecia=" + ID_portu_rozpoczecia +
                ", ID_portu_zakonczenia=" + ID_portu_zakonczenia +
                ", ID_armatora=" + ID_armatora +
                '}';
    }
}
