package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WlascicieleDAOTest {
    private WlascicieleDAO daow;

    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daow = new WlascicieleDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Wlasciciel> listWlasciciel = daow.list();

        assertFalse(listWlasciciel.isEmpty());
    }

    @Test
    void save() {
        Wlasciciel wlasciciel = new Wlasciciel(3,"Mariusz","Wiktorwicz","BMW");
        daow.save(wlasciciel);
    }

    @Test
    void get() {
        int ID_wlasciciela = 1;
        Wlasciciel wlasciciel = daow.get(ID_wlasciciela);
        assertNotNull(wlasciciel);
    }

    @Test
    void update() {
        Wlasciciel wlasciciel = new Wlasciciel();
        wlasciciel.setID_wlasciciela(3);
        wlasciciel.setImie("Bogdan");
        wlasciciel.setNazwisko("Witko");
        wlasciciel.setNazwa_firmy("Mercedes");

        daow.update(wlasciciel);
    }

    @Test
    void delete() {
        int ID_wlasciciela = 3;
        daow.delete(ID_wlasciciela);
    }
}