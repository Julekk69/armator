package bdbt_projekt.Armator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;


@Repository
public class StatkiDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StatkiDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Statek> list(){
        String sql = "SELECT * FROM STATKI";

        List<Statek> listStatek = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Statek.class));

        return listStatek;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Statek statek) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("statki").usingColumns("ID_statku","Nazwa","Dlugosc",
                "Nosnosc","Predkosc_eksploatacyjna","Min_licz_zalogi","Data_wodowania","ID_armatora","ID_bandery");

        BeanPropertySqlParameterSource param9 = new BeanPropertySqlParameterSource(statek);
        insertActor.execute(param9);
    }
    /* Read – odczytywanie danych z bazy */
    public Statek get(int ID_statku) {
        String sql = "SELECT * FROM STATKI WHERE ID_statku = ?";
        Object[] args = {ID_statku};
        Statek statek = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Statek.class));
        return statek;
    }
    public Statek get2(int ID_statku){
        Object[] args = {ID_statku};
        String sql = "SELECT * FROM STATKI WHERE ID_statku = " + args[0];
        Statek statek = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Statek.class));
        return statek;
    }
    /* Update – aktualizacja danych */
    public void update(Statek statek) {
        String sql = "UPDATE STATKI SET Nazwa=:Nazwa,Dlugosc=:Dlugosc," +
                "Nosnosc=:Nosnosc,Predkosc_eksploatacyjna=:Predkosc_eksploatacyjna," +
                "Min_licz_zalogi=:Min_licz_zalogi,Data_wodowania=:Data_wodowania WHERE ID_statku=:ID_statku,ID_armatora=:ID_armatora,ID_bandery=:ID_bandery";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(statek);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param3);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_statku) {
        String sql = "DELETE FROM STATKI WHERE ID_statku = ?";
        jdbcTemplate.update(sql, ID_statku);
    }
}
