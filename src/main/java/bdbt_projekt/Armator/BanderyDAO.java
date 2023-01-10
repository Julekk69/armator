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
public class BanderyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BanderyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */ //(zawiera info z bazy danych)
    public List<Bandera> list(){
        String sql = "SELECT * FROM bandery";

        List<Bandera> listBandera = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bandera.class));

        return listBandera;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Bandera bandera) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("bandery").usingColumns("ID_bandery","Nazwa_bandery","Panstwo");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bandera);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Bandera get(int ID_bandery) {
        String sql = "SELECT * FROM BANDERY WHERE ID_bandery = ?";
        Object[] args = {ID_bandery};
        Bandera bandera = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Bandera.class));
        return bandera;
    }
    public Bandera get1(int ID_bandery){
        Object[] args = {ID_bandery};
        String sql = "SELECT * FROM BANDERY WHERE ID_bandery = " + args[0];
        Bandera bandera = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Bandera.class));
        return bandera;
    }

    /* Update – aktualizacja danych */
    public void update(Bandera bandera) {
        String sql = "UPDATE BANDERY SET  Nazwa_bandery=:Nazwa_bandery,Panstwo=:Panstwo WHERE ID_bandery=:ID_bandery";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bandera);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_bandery) {
        String sql = "DELETE FROM BANDERY WHERE ID_bandery = ?";
        jdbcTemplate.update(sql, ID_bandery);
    }
}
