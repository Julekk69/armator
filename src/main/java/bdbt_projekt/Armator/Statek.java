package bdbt_projekt.Armator;

public class Statek {
    private int ID_statku;
    private String Nazwa;
    private int Dlugosc;
    private int Nosnosc;
    private int Predkosc_eksploatacyjna;
    private int Min_licz_zalogi;
    private String Data_wodowania;
    private int ID_armatora;
    private int ID_bandery;

    public Statek(){}

    public Statek(int ID_statku, String nazwa, int dlugosc, int nosnosc, int predkosc_eksploatacyjna, int min_licz_zalogi, String data_wodowania, int ID_armatora, int ID_bandery) {
        this.ID_statku = ID_statku;
        Nazwa = nazwa;
        Dlugosc = dlugosc;
        Nosnosc = nosnosc;
        Predkosc_eksploatacyjna = predkosc_eksploatacyjna;
        Min_licz_zalogi = min_licz_zalogi;
        Data_wodowania = data_wodowania;
        this.ID_armatora = ID_armatora;
        this.ID_bandery = ID_bandery;
    }

    public int getID_statku() {
        return ID_statku;
    }

    public void setID_statku(int ID_statku) {
        this.ID_statku = ID_statku;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public int getDlugosc() {
        return Dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        Dlugosc = dlugosc;
    }

    public int getNosnosc() {
        return Nosnosc;
    }

    public void setNosnosc(int nosnosc) {
        Nosnosc = nosnosc;
    }

    public int getPredkosc_eksploatacyjna() {
        return Predkosc_eksploatacyjna;
    }

    public void setPredkosc_eksploatacyjna(int predkosc_eksploatacyjna) {
        Predkosc_eksploatacyjna = predkosc_eksploatacyjna;
    }

    public int getMin_licz_zalogi() {
        return Min_licz_zalogi;
    }

    public void setMin_licz_zalogi(int min_licz_zalogi) {
        Min_licz_zalogi = min_licz_zalogi;
    }

    public String getData_wodowania() {
        return Data_wodowania;
    }

    public void setData_wodowania(String data_wodowania) {
        Data_wodowania = data_wodowania;
    }

    public int getID_armatora() {
        return ID_armatora;
    }

    public void setID_armatora(int ID_armatora) {
        this.ID_armatora = ID_armatora;
    }

    public int getID_bandery() {
        return ID_bandery;
    }

    public void setID_bandery(int ID_bandery) {
        this.ID_bandery = ID_bandery;
    }

    @Override
    public String toString() {
        return "Statek{" +
                "ID_statku=" + ID_statku +
                ", Nazwa='" + Nazwa + '\'' +
                ", Dlugosc=" + Dlugosc +
                ", Nosnosc=" + Nosnosc +
                ", Predkosc_eksploatacyjna=" + Predkosc_eksploatacyjna +
                ", Min_licz_zalogi=" + Min_licz_zalogi +
                ", Data_wodowania='" + Data_wodowania + '\'' +
                ", ID_armatora=" + ID_armatora +
                ", ID_bandery=" + ID_bandery +
                '}';
    }
}
