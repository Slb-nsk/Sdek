package org.sdek.dao;

import org.sdek.entities.NameEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class NamesDao {

    private static final Logger log = LoggerFactory.getLogger(NamesDao.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NamesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<NameEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM names", new RowMapper<NameEntity>() {
            @Override
            public NameEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new NameEntity(rs.getInt("id"), rs.getString("name"));
            }
        });
    }

    public void save(String name) {
        jdbcTemplate.update("INSERT INTO names(name) VALUES (?)", name);
    }
}
