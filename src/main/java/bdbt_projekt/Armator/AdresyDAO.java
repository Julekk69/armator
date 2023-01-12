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
public class AdresyDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";

        List<Adres> listAdres = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Adres.class));

        return listAdres;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("ID_adresu","Kraj","Miasto",
                "Kod_pocztowy","Ulica","Nr_budynku","Nr_lokalu");

        BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param1);
    }
    /* Read – odczytywanie danych z bazy */
    public Adres get(int ID_adresu) {
        String sql = "SELECT * FROM ADRESY WHERE ID_adresu = ?";
        Object[] args = {ID_adresu};
        Adres adres = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
    public Adres get2(int ID_adresu){
        Object[] args = {ID_adresu};
        String sql = "SELECT * FROM ADRESY WHERE ID_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
    /* Update – aktualizacja danych */
    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET Kraj=:Kraj,Miasto=:Miasto," +
                "Kod_pocztowy=:Kod_pocztowy,Ulica=:Ulica,Nr_budynku=:Nr_budynku,Nr_lokalu=:Nr_lokalu WHERE ID_adresu=:ID_adresu";
        BeanPropertySqlParameterSource param3 = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param3);
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int ID_adresu) {
        String sql = "DELETE FROM ADRESY WHERE ID_adresu = ?";
        jdbcTemplate.update(sql, ID_adresu);
    }
}
