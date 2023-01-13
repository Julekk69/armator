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
public class ArmatorzyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArmatorzyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Armator> list(){
        String sql = "SELECT * FROM ARMATORZY";

        List<Armator> listArmator = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Armator.class));

        return listArmator;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Armator armator) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("armatorzy").usingColumns("ID_armatora","Nazwa","Data_zalozenia",
                "Nr_telefonu","ID_adresu","ID_wlasciciela");

        BeanPropertySqlParameterSource param11 = new BeanPropertySqlParameterSource(armator);
        insertActor.execute(param11);
    }
    /* Read – odczytywanie danych z bazy */
    public Armator get(int ID_armatora) {
        String sql = "SELECT * FROM ARMATORZY WHERE ID_armatora = ?";
        Object[] args = {ID_armatora};
        Armator armator= jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Armator.class));
        return armator;
    }
    public Armator get2(int ID_armatora){
        Object[] args = {ID_armatora};
        String sql = "SELECT * FROM ARMATORZY WHERE ID_armatora = " + args[0];
        Armator armator = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Armator.class));
        return armator;
    }
    /* Update – aktualizacja danych */
    public void update(Armator armator) {
        String sql = "UPDATE ARMATORZY SET Nazwa=:Nazwa,Data_zalozenia=:Data_zalozenia," +
                "Nr_telefonu=:Nr_telefonu,ID_adresu=:ID_adresu,ID_wlasciciela=:ID_wlasciciela WHERE ID_armatora=:ID_armatora";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(armator);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param3);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_armatora) {
        String sql = "DELETE FROM ARMATORZY WHERE ID_armatora = ?";
        jdbcTemplate.update(sql, ID_armatora);
    }
}
