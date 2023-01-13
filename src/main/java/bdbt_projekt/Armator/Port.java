package bdbt_projekt.Armator;

public class Port {
    private int ID_portu;
    private String Rodzaj_portu;
    private String Czy_rozladunek;
    private int Glebokosc;
    private Integer Szer_kanalu;
    private String Nr_telefonu;
    private int ID_adresu;

    public Port(){}

    public Port(int ID_portu, String rodzaj_portu, String czy_rozladunek, int glebokosc, Integer szer_kanalu, String nr_telefonu, int ID_adresu) {
        super();
        this.ID_portu = ID_portu;
        this.Rodzaj_portu = rodzaj_portu;
        this.Czy_rozladunek = czy_rozladunek;
        this.Glebokosc = glebokosc;
        this.Szer_kanalu = szer_kanalu;
        this.Nr_telefonu = nr_telefonu;
        this.ID_adresu = ID_adresu;
    }

    public int getID_portu() {
        return ID_portu;
    }

    public void setID_portu(int ID_portu) {
        this.ID_portu = ID_portu;
    }

    public String getRodzaj_portu() {
        return Rodzaj_portu;
    }

    public void setRodzaj_portu(String rodzaj_portu) {
        Rodzaj_portu = rodzaj_portu;
    }

    public String getCzy_rozladunek() {
        return Czy_rozladunek;
    }

    public void setCzy_rozladunek(String czy_rozladunek) {
        Czy_rozladunek = czy_rozladunek;
    }

    public int getGlebokosc() {
        return Glebokosc;
    }

    public void setGlebokosc(int glebokosc) {
        Glebokosc = glebokosc;
    }

    public Integer getSzer_kanalu() {
        return Szer_kanalu;
    }

    public void setSzer_kanalu(Integer szer_kanalu) {
        Szer_kanalu = szer_kanalu;
    }

    public String getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        Nr_telefonu = nr_telefonu;
    }

    public int getID_adresu() {
        return ID_adresu;
    }

    public void setID_adresu(int ID_adresu) {
        this.ID_adresu = ID_adresu;
    }

    @Override
    public String toString() {
        return "Port{" +
                "ID_portu=" + ID_portu +
                ", Rodzaj_portu='" + Rodzaj_portu + '\'' +
                ", Czy_rozladunek='" + Czy_rozladunek + '\'' +
                ", Glebokosc=" + Glebokosc +
                ", Szer_kanalu=" + Szer_kanalu +
                ", Nr_telefonu='" + Nr_telefonu + '\'' +
                ", ID_adresu=" + ID_adresu +
                '}';
    }
}
