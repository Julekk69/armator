package bdbt_projekt.Armator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmatorzyDAOTest {

    private ArmatorzyDAO daoaa;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB11");
        datasource.setPassword("BDBTGRB11");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        /* Import JdbcTemplate */
        daoaa = new ArmatorzyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Armator> listArmator = daoaa.list();

        assertFalse(listArmator.isEmpty());
    }

    @Test
    void save() {
        Armator armator = new Armator(3,"WER","2020-12-12","6758234",1,1);
        daoaa.save(armator);
    }

    @Test
    void get() {
        int ID_armatora = 1;
        Armator armator = daoaa.get(ID_armatora);
        assertNotNull(armator);
    }

    @Test
    void update() {
        Armator armator = new Armator();
        armator.setID_armatora(2);
        armator.setNazwa("wewe");
        armator.setData_zalozenia("2020-13-13");
        armator.setNr_telefonu("23453");
        armator.setID_adresu(1);
        armator.setID_wlasciciela(1);

    }

    @Test
    void delete() {
        int ID_armatora = 3;
        daoaa.delete(ID_armatora);
    }
}