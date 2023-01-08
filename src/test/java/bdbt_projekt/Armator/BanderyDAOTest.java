package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BanderyDAOTest {

    private BanderyDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        dao = new BanderyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Bandera> listBandera = dao.list();

        assertFalse(listBandera.isEmpty());
    }

    @Test
    void save() {
        Bandera bandera = new Bandera(6,"Tomek","Norwegia");
        dao.save(bandera);
    }

    @Test
    void get() {
        fail("NOT YET IMPLEMENTED4");
    }

    @Test
    void update() {
        fail("NOT YET IMPLEMENTED5");
    }

    @Test
    void delete() {
        fail("NOT YET IMPLEMENTED6");
    }
}