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
public class KlienciDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";

        List<Klient> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));

        return listKlient;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("ID_klienta","Imie","Nazwisko",
                "Data_urodzenia","Plec","Nazwa_firmy","Pesel","Email","Nr_telefonu","ID_armatora","ID_adresu");

        BeanPropertySqlParameterSource param5 = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param5);
    }
    /* Read – odczytywanie danych z bazy */
    public Klient get(int ID_klienta) {
        String sql = "SELECT * FROM KLIENCI WHERE ID_klienta = ?";
        Object[] args = {ID_klienta};
        Klient klient = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    public Klient get5(int ID_klienta){
        Object[] args = {ID_klienta};
        String sql = "SELECT * FROM KLIENCI WHERE ID_klienta = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    /* Update – aktualizacja danych */
    public void update(Klient klient) {
        String sql = "UPDATE KLIENCI SET Imie=:Imie,Nazwisko=:Nazwisko," +
                "Data_urodzenia=:Data_urodzenia,Plec=:Plec,Nazwa_firmy=:Nazwa_firmy,Pesel=:Pesel,Email=:Email,Nr_telefonu=:Nr_telefonu WHERE ID_klienta=:ID_klienta,ID_armatora=:ID_armatora,ID_adresu=:ID_adresu";
        BeanPropertySqlParameterSource param5 = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param5);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_klienta) {
        String sql = "DELETE FROM KLIENCI WHERE ID_klienta = ?";
        jdbcTemplate.update(sql, ID_klienta);
    }
}
