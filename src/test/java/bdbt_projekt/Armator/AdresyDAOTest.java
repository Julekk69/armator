package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyDAOTest {

    private AdresyDAO daoa;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daoa = new AdresyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Adres> listAdres = daoa.list();

        assertFalse(listAdres.isEmpty());
    }

    @Test
    void save() {
        Adres adres = new Adres(60,"wer","wqw","sqsq","sqsq","sqsqs","sqs");
        daoa.save(adres);
    }

    @Test
    void get() {
        int ID_adresu = 4;
        Adres adres = daoa.get(ID_adresu);
        assertNotNull(adres);
    }

    @Test
    void update() {
        Adres adres = new Adres();
        adres.setID_adresu(23);
        adres.setKod_pocztowy("2323");
        adres.setKraj("wlochy");
        adres.setUlica("wegierksa");
        adres.setNr_budynku("23");
        adres.setNr_lokalu("3213");
        adres.setMiasto("ople");
    }

    @Test
    void delete() {
        int ID_adresu = 13;
        daoa.delete(ID_adresu);
    }
}