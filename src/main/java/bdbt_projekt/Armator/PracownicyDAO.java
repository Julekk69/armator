package bdbt_projekt.Armator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;




@Repository
public class PracownicyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
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
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("ID_pracownika","Imie","Nazwisko",
                "Nr_Konta","Data_urodzenia","Plec","Pesel","Email","Nr_telefonu","ID_adresu","ID_stanowiska","ID_armatora");

        BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param1);
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int ID_pracownika) {
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_pracownika = ?";
        Object[] args = {ID_pracownika};
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    public Pracownik get2(int ID_pracownika){
        Object[] args = {ID_pracownika};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET Imie=:Imie,Nazwisko=:Nazwisko," +
                "Nr_Konta=:Nr_Konta,Data_urodzenia=:Data_urodzenia,Plec=:Plec,Email=:Email" +
                "Nr_telefonu=:Nr_telefonu,ID_adresu=:ID_adresu,ID_stanowiska=:ID_stanowiska,ID_armatora=ID_armatora" +
                " WHERE ID_pracownika=:ID_pracownika";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param3);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_pracownika) {
        String sql = "DELETE FROM PRACOWNICY WHERE ID_pracownika = ?";
        jdbcTemplate.update(sql, ID_pracownika);
    }
}
