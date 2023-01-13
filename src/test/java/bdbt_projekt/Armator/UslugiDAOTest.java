package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UslugiDAOTest {

    private UslugiDAO daou;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daou = new UslugiDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Usluga> listUsluga = daou.list();
        assertFalse(listUsluga.isEmpty());
    }

    @Test
    void save() {
        Usluga usluga = new Usluga(4,"WER",12,"fvfdvd","2222-03-02","2223-08-09",1,1,1,1,1);
        daou.save(usluga);
    }

    @Test
    void get() {
        int ID_uslugi = 1;
        Usluga usluga = daou.get(ID_uslugi);
        assertNotNull(usluga);
    }

    @Test
    void update() {
        Usluga usluga = new Usluga();
        usluga.setData_rozpoczecia("2020-09-09");
        usluga.setData_zakonczenia("2200-08-08");
        usluga.setID_armatora(1);
        usluga.setID_uslugi(4);
        usluga.setID_portu_rozpoczecia(1);
        usluga.setID_portu_zakonczenia(1);
        usluga.setKoszt(2323);
        usluga.setOpis("jbuvyvuyhvuyv");
        usluga.setID_statku(1);
        usluga.setID_klienta(1);
    }

    @Test
    void delete() {
        int ID_uslugi = 4;
        daou.delete(ID_uslugi);
    }
}