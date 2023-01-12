package bdbt_projekt.Armator;

public class Adres {

    private int ID_adresu;
    private String Kraj;
    private String Miasto;
    private String Kod_pocztowy;
    private String Ulica;
    private String Nr_budynku;
    private String Nr_lokalu;

    public Adres(){

    }

    public Adres(int ID_adresu, String kraj, String miasto, String kod_pocztowy, String ulica, String nr_budynku, String nr_lokalu) {
        super();
        this.ID_adresu = ID_adresu;
        this.Kraj = kraj;
        this.Miasto = miasto;
        this.Kod_pocztowy = kod_pocztowy;
        this.Ulica = ulica;
        this.Nr_budynku = nr_budynku;
        this.Nr_lokalu = nr_lokalu;
    }

    public int getID_adresu() {
        return ID_adresu;
    }

    public void setID_adresu(int ID_adresu) {
        this.ID_adresu = ID_adresu;
    }

    public String getKraj() {
        return Kraj;
    }

    public void setKraj(String kraj) {
        Kraj = kraj;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String miasto) {
        Miasto = miasto;
    }

    public String getKod_pocztowy() {
        return Kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        Kod_pocztowy = kod_pocztowy;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    public String getNr_budynku() {
        return Nr_budynku;
    }

    public void setNr_budynku(String nr_budynku) {
        Nr_budynku = nr_budynku;
    }

    public String getNr_lokalu() {
        return Nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        Nr_lokalu = nr_lokalu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "ID_adresu=" + ID_adresu +
                ", Kraj='" + Kraj + '\'' +
                ", Miasto='" + Miasto + '\'' +
                ", Kod_pocztowy='" + Kod_pocztowy + '\'' +
                ", Ulica='" + Ulica + '\'' +
                ", Nr_budynku='" + Nr_budynku + '\'' +
                ", Nr_lokalu='" + Nr_lokalu + '\'' +
                '}';
    }
}
