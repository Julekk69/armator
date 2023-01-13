package bdbt_projekt.Armator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Klient {
    private int ID_klienta;
    private String Imie;
    private String Nazwisko;
    private String Data_urodzenia;
    private String Plec;
    private String Nazwa_firmy;
    private String Pesel;
    private String Email;
    private String Nr_telefonu;
    private int ID_armatora;
    private int ID_adresu;

    public Klient(){}

    public Klient(int ID_klienta, String imie, String nazwisko, String data_urodzenia, String plec, String nazwa_firmy, String pesel, String email, String nr_telefonu, int ID_armatora, int ID_adresu) {
        super();
        this.ID_klienta = ID_klienta;
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.Data_urodzenia = data_urodzenia;
        this.Plec = plec;
        this.Nazwa_firmy = nazwa_firmy;
        this.Pesel = pesel;
        this.Email = email;
        this.Nr_telefonu = nr_telefonu;
        this.ID_armatora = ID_armatora;
        this.ID_adresu = ID_adresu;
    }


    public int getID_klienta() {
        return ID_klienta;}

    public void setID_klienta(int ID_klienta) {
        this.ID_klienta = ID_klienta;
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

    public String getData_urodzenia() {
        return Data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        Data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return Plec;
    }

    public void setPlec(String plec) {
        Plec = plec;
    }

    public String getNazwa_firmy() {
        return Nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        Nazwa_firmy = nazwa_firmy;
    }

    public String getPesel() {
        return Pesel;
    }

    public void setPesel(String pesel) {
        Pesel = pesel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNr_telefonu() {
        return Nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        Nr_telefonu = nr_telefonu;
    }

    public int getID_armatora() {
        return ID_armatora;
    }

    public void setID_armatora(int ID_armatora) {
        this.ID_armatora = ID_armatora;
    }

    public int getID_adresu() {
        return ID_adresu;
    }

    public void setID_adresu(int ID_adresu) {
        this.ID_adresu = ID_adresu;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "ID_klienta=" + ID_klienta +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", Data_urodzenia=" + Data_urodzenia +
                ", Plec='" + Plec + '\'' +
                ", Nazwa_firmy='" + Nazwa_firmy + '\'' +
                ", Pesel='" + Pesel + '\'' +
                ", Email='" + Email + '\'' +
                ", Nr_telefonu='" + Nr_telefonu + '\'' +
                ", ID_armatora='" + ID_armatora + '\'' +
                ", ID_adresu='" + ID_adresu + '\'' +
                '}';
    }
}
