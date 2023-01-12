package bdbt_projekt.Armator;

public class Pracownik {
    private int Id_pracownika;
    private String imie;
    private String nazwisko;
    private String Nr_konta;
    private String Data_urodzenia;
    private String plec;
    private String pesel;
    private String email;
    private String Nr_telefonu;
    private int Id_adresu;
    private int Id_stanowiska;
    private int Id_armatora;

    public Pracownik(){

    }

    public Pracownik(int id_pracownika, String imie, String nazwisko, String nr_konta, String data_urodzenia, String plec, String pesel, String email, String nr_telefonu, int id_adresu, int id_stanowiska, int id_armatora) {
        Id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        Nr_konta = nr_konta;
        Data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.email = email;
        Nr_telefonu = nr_telefonu;
        Id_adresu = id_adresu;
        Id_stanowiska = id_stanowiska;
        Id_armatora = id_armatora;
    }

    public int getId_pracownika() {
        return Id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        Id_pracownika = id_pracownika;
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

    public String getNr_konta() {
        return Nr_konta;
    }

    public void setNr_konta(String nr_konta) {
        Nr_konta = nr_konta;
    }

    public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        Nr_telefonu = nr_telefonu;
    }

    public int getId_adresu() {
        return Id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        Id_adresu = id_adresu;
    }

    public int getId_stanowiska() {
        return Id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        Id_stanowiska = id_stanowiska;
    }

    public int getId_armatora() {
        return Id_armatora;
    }

    public void setId_armatora(int id_armatora) {
        Id_armatora = id_armatora;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "Id_pracownika=" + Id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", Nr_konta='" + Nr_konta + '\'' +
                ", Data_urodzenia='" + Data_urodzenia + '\'' +
                ", plec='" + plec + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", Nr_telefonu='" + Nr_telefonu + '\'' +
                ", Id_adresu=" + Id_adresu +
                ", Id_stanowiska=" + Id_stanowiska +
                ", Id_armatora=" + Id_armatora +
                '}';
    }
}

