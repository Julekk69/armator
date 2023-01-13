package bdbt_projekt.Armator;

public class Armator {
    private int ID_armatora;
    private String Nazwa;
    private String Data_zalozenia;
    private String Nr_telefonu;
    private int ID_adresu;
    private int ID_wlasciciela;

    public Armator(){}

    public Armator(int ID_armatora, String nazwa, String data_zalozenia, String nr_telefonu, int ID_adresu, int ID_wlasciciela) {
        super();
        this.ID_armatora = ID_armatora;
        this.Nazwa = nazwa;
        this.Data_zalozenia = data_zalozenia;
        this.Nr_telefonu = nr_telefonu;
        this.ID_adresu = ID_adresu;
        this.ID_wlasciciela = ID_wlasciciela;
    }

    public int getID_armatora() {
        return ID_armatora;
    }

    public void setID_armatora(int ID_armatora) {
        this.ID_armatora = ID_armatora;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return Data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        Data_zalozenia = data_zalozenia;
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

    public int getID_wlasciciela() {
        return ID_wlasciciela;
    }

    public void setID_wlasciciela(int ID_wlasciciela) {
        this.ID_wlasciciela = ID_wlasciciela;
    }

    @Override
    public String toString() {
        return "Armator{" +
                "ID_armatora=" + ID_armatora +
                ", Nazwa='" + Nazwa + '\'' +
                ", Data_zalozenia='" + Data_zalozenia + '\'' +
                ", Nr_telefonu='" + Nr_telefonu + '\'' +
                ", ID_adresu=" + ID_adresu +
                ", ID_wlasciciela=" + ID_wlasciciela +
                '}';
    }
}
