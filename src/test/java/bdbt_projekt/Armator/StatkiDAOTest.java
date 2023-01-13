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
    }

    @Test
    void get() {
    }

    @Test
    void get2() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}