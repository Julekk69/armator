package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KlienciDAOTest {

    private KlienciDAO daok;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daok = new KlienciDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Klient> listKlient = daok.list();

        assertFalse(listKlient.isEmpty());
    }

    @Test
    void save() {
        Klient klient = new Klient(23,"Arek","Moks","2023-09-21","weres","dwdwd","dwdwdwd","dwdwdw","dwdwd",1,7);
        daok.save(klient);
    }

    @Test
    void get() {
        int ID_klienta = 1;
        Klient klient = daok.get(ID_klienta);
        assertNotNull(klient);
    }

    @Test
    void update() {
        Klient klient = new Klient();
        klient.setID_klienta(2);
        klient.setID_adresu(6);
        klient.setEmail("swsws");
        klient.setData_urodzenia("1212-08-98");
        klient.setImie("wererlich");
        klient.setNazwa_firmy("were");
        klient.setID_armatora(1);
        klient.setPesel("weqweqweqweq");
        klient.setNazwisko("hfuyyufuy");
        klient.setNr_telefonu("342354352");
        klient.setPlec("M");
    }

    @Test
    void delete() {
        int ID_klienta = 2;
        daok.delete(ID_klienta);
    }
}