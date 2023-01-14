package bdbt_projekt.Armator;

public class Bandera {
    private int ID_bandery;
    private String Nazwa_bandery;
    private String Panstwo;

    public Bandera(){
    }

    public Bandera(int ID_bandery, String nazwa_bandery, String panstwo) {
        super();
        this.ID_bandery = ID_bandery;
        this.Nazwa_bandery = nazwa_bandery;
        this.Panstwo = panstwo;
    }

    public int getID_bandery() {
        return ID_bandery;
    }

    public void setID_bandery(int ID_bandery) {
        this.ID_bandery = ID_bandery;
    }

    public String getNazwa_bandery() {
        return Nazwa_bandery;
    }

    public void setNazwa_bandery(String nazwa_bandery) {
        Nazwa_bandery = nazwa_bandery;
    }

    public String getPanstwo() {
        return Panstwo;
    }

    public void setPanstwo(String panstwo) {
        Panstwo = panstwo;
    }

    @Override
    public String toString() {
        return "Bandera{" +
                "ID_bandery=" + ID_bandery +
                ", Nazwa_bandery='" + Nazwa_bandery + '\'' +
                ", Panstwo='" + Panstwo + '\'' +
                '}';
    }
}
