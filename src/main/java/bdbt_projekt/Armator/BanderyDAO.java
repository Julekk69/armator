package bdbt_projekt.Armator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BanderyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BanderyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */ //(zawiera info z bazy danych)
    public List<Bandera> list(){
        String sql = "SELECT * FROM BANDERY";

        List<Bandera> listBandera = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bandera.class));

        return listBandera;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Bandera bandera) {
    }

    /* Read – odczytywanie danych z bazy */
    public Bandera get(int ID_bandery) {
        return null;
    }

    /* Update – aktualizacja danych */
    public void update(Bandera bandera) {
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_bandery) {
    }
}
