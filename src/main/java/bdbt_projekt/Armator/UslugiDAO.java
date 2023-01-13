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
public class UslugiDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UslugiDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Usluga> list(){
        String sql = "SELECT * FROM USLUGI";

        List<Usluga> listUsluga = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Usluga.class));

        return listUsluga;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Usluga usluga) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("uslugi").usingColumns("ID_uslugi","Rodzaj_uslugi","Koszt",
                "Opis","Data_rozpoczecia","Data_zakonczenia","ID_klienta","ID_statku","ID_portu_rozpoczecia","ID_portu_zakonczenia","ID_armatora");

        BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(usluga);
        insertActor.execute(param1);
    }
    /* Read – odczytywanie danych z bazy */
    public Usluga get(int ID_uslugi) {
        String sql = "SELECT * FROM USLUGI WHERE ID_uslugi = ?";
        Object[] args = {ID_uslugi};
        Usluga usluga = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Usluga.class));
        return usluga;
    }
    public Usluga get7(int ID_uslugi){
        Object[] args = {ID_uslugi};
        String sql = "SELECT * FROM USLUGI WHERE ID_uslugi = " + args[0];
        Usluga usluga = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Usluga.class));
        return usluga;
    }
    /* Update – aktualizacja danych */
    public void update(Usluga usluga) {
        String sql = "UPDATE USLUGI SET Rodzaj_uslugi=:Rodzaj_uslugi,Koszt=:Koszt," +
                "Opis=:Opis,Data_rozpoczecia=:Data_rozpoczecia," +
                "Data_zakonczenia=:Data_zakonczenia WHERE ID_uslugi=:ID_uslugi,ID_klienta=:ID_klienta," +
                "ID_statku=:ID_statku,ID_portu_rozpoczecia=:ID_portu_rozpoczecia,ID_portu_zakonczenia=:ID_portu_zakonczenia," +
                "ID_armatora=:ID_armatora";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(usluga);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param3);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_uslugi) {
        String sql = "DELETE FROM USLUGI WHERE ID_uslugi = ?";
        jdbcTemplate.update(sql, ID_uslugi);
    }
}
