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
public class PortyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PortyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Port> list(){
        String sql = "SELECT * FROM PORTY";

        List<Port> listPort = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Port.class));

        return listPort;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Port port) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("porty").usingColumns("ID_portu","Rodzaj_portu","Czy_rozladunek",
                "Glebokosc","Szer_kanalu","Nr_telefonu","ID_adresu");

        BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(port);
        insertActor.execute(param1);
    }
    /* Read – odczytywanie danych z bazy */
    public Port get(int ID_portu) {
        String sql = "SELECT * FROM PORTY WHERE ID_portu = ?";
        Object[] args = {ID_portu};
        Port port = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Port.class));
        return port;
    }
    public Port get2(int ID_portu){
        Object[] args = {ID_portu};
        String sql = "SELECT * FROM PORTY WHERE ID_portu = " + args[0];
        Port port = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Port.class));
        return port;
    }
    /* Update – aktualizacja danych */
    public void update(Port port) {
        String sql = "UPDATE PORTY SET Rodzaj_portu=:Rodzaj_portu,Czy_rozladunek=:Czy_rozladunek," +
                "Glebokosc=:Glebokosc,Szer_kanalu=:Szer_kanalu,Nr_telefonu=:Nr_telefonu  WHERE ID_portu=:ID+portu,ID_adresu=:ID_adresu";
        BeanPropertySqlParameterSource param8 = new BeanPropertySqlParameterSource(port);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param8);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_portu) {
        String sql = "DELETE FROM PORTY WHERE ID_portu = ?";
        jdbcTemplate.update(sql, ID_portu);
    }
}
