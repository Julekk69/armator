package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatkiDAOTest {

    private StatkiDAO daos;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daos = new StatkiDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Statek> listStatek = daos.list();

        assertFalse(listStatek.isEmpty());
    }

    @Test
    void save() {
        Statek statek = new Statek(4,"Szybki",100,33333,230,10,"",4,6);
        daos.update(statek);
    }

    @Test
    void get() {
        int ID_statku = 1;
        Statek statek = daos.get(ID_statku);
        assertNotNull(statek);
    }

    @Test
    void update() {
        Statek statek = new Statek();
        statek.setID_statku(3);
        statek.setData_wodowania("");
        statek.setDlugosc(212);
        statek.setID_armatora(1);
        statek.setNazwa("swsw");
        statek.setNosnosc(12);
        statek.setMin_licz_zalogi(1212);
        statek.setMin_licz_zalogi(12);
    }

    @Test
    void delete() {
    }
}