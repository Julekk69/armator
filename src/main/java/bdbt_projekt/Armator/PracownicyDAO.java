package bdbt_projekt.Armator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jbcTemplate){
        super();
        this.jdbcTemplate = jbcTemplate;
    }
    /* Import java.util.List */
    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return listPracownik;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int Id_praconwika) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int Id_pracownika) {
    }


}
