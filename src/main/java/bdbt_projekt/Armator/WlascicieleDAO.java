package bdbt_projekt.Armator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class WlascicieleDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WlascicieleDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */ //(zawiera info z bazy danych)
    public List<Wlasciciel> list(){
        String sql = "SELECT * FROM wlasciciele";

        List<Wlasciciel> listWlasciciel = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wlasciciel.class));

        return listWlasciciel;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Wlasciciel wlasciciel) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wlasciciele").usingColumns("ID_wlasciciela","Imie","Nazwisko","Nazwa_firmy");

        BeanPropertySqlParameterSource param4 = new BeanPropertySqlParameterSource(wlasciciel);
        insertActor.execute(param4);
    }

    /* Read – odczytywanie danych z bazy */
    public Wlasciciel get(int ID_wlasciciela) {
        String sql = "SELECT * FROM WLASCICIELE WHERE ID_wlasciciela = ?";
        Object[] args = {ID_wlasciciela};
        Wlasciciel wlasciciel = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Wlasciciel.class));
        return wlasciciel;
    }
    public Wlasciciel get4(int ID_wlasciciela){
        Object[] args = {ID_wlasciciela};
        String sql = "SELECT * FROM WLASCICIELE WHERE ID_wlasciciela = " + args[0];
        Wlasciciel wlasciciel = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Wlasciciel.class));
        return wlasciciel;
    }

    /* Update – aktualizacja danych */
    public void update(Wlasciciel wlasciciel) {
        String sql = "UPDATE WLASCICIELE SET  Imie=:Imie,Nazwisko=:Nazwisko,Nazwa_firmy=:Nazwa_firmy WHERE ID_wlasciciela=:ID_wlasciciela";
        BeanPropertySqlParameterSource param4 = new BeanPropertySqlParameterSource(wlasciciel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param4);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_wlasciela) {
        String sql = "DELETE FROM WLASCICIELE WHERE ID_wlasciciela = ?";
        jdbcTemplate.update(sql, ID_wlasciela);
    }
}
