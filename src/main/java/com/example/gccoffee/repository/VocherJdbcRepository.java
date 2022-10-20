package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import com.example.gccoffee.model.Vocher;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.gccoffee.JdbcUtils.toLocalDateTime;
import static com.example.gccoffee.JdbcUtils.toUUID;

@Repository
public class VocherJdbcRepository implements VocherRepository{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public VocherJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vocher> findAll() {
        return jdbcTemplate.query(
                "select * from vochers", vocherRowMapper);
    }


    @Override
    public Vocher insert(Vocher vocher) {
        var update =  jdbcTemplate.update("INSERT INTO vochers(vocher_name, discount, expiration_at, created_at, updated_at)"+
                " VALUES (:vocherName, :discount, :expirationAt, :createdAt, :updatedAt)", toParamMap(vocher));
        if(update != 1){
            throw new RuntimeException("Nothing was inserted");
        }

        return vocher;
    }

    @Override
    public Vocher update(Vocher vocher) {
        var update = jdbcTemplate.update(
                "UPDATE vochers SET vocher_name = :vocherName, discount = :discount, expiration_at = :expirationAt, created_at = :createdAt, updated_at = :updatedAt"
                        +" where vocher_name = :vocherName",
                toParamMap(vocher)
        );
        if(update != 1){
            throw new RuntimeException("Nothing was updated");
        }
        return vocher;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM vochers", Collections.emptyMap());
    }

    private static final RowMapper<Vocher> vocherRowMapper = (resultSet, i) -> {
        var vocherName = resultSet.getString("vocher_name");
        var discount = resultSet.getInt("discount");
        var expirationAt = toLocalDateTime(resultSet.getTimestamp("expiration_at"));
        var createdAt = toLocalDateTime(resultSet.getTimestamp("created_at"));
        var updatedAt = toLocalDateTime(resultSet.getTimestamp("updated_at"));

        return new Vocher(
                vocherName,
                discount,
                expirationAt,
                createdAt,
                updatedAt
        );
    };

    private Map<String, Object> toParamMap(Vocher vocher){
        var paramMap = new HashMap<String, Object>();
        paramMap.put("vocherName", vocher.getVocherName());
        paramMap.put("discount", vocher.getDiscount());
        paramMap.put("expirationAt", vocher.getExpirationAt());
        paramMap.put("createdAt", vocher.getCreatedAt());
        paramMap.put("updatedAt", vocher.getUpdatedAt());

        return paramMap;
    }
}
