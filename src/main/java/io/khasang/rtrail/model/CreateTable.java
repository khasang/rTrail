package io.khasang.rtrail.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats2");
            jdbcTemplate.execute("CREATE TABLE public.cats2\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
        } catch (Exception e) {
            return "table creation failed:\n" + e;
        }
    }

    public String getCatByName(String name) {
        String query = "SELECT * FROM cats WHERE name = 'Barsik'";

        return String.valueOf(jdbcTemplate.query(query, new RowMapper<Cat>() {
            @Override
            public Cat mapRow(ResultSet rs, int rowCount) throws SQLException {
                Cat cat = new Cat();
                cat.setId(rs.getInt(1));
                cat.setName(rs.getString(2));
                cat.setDescription(rs.getString(3));
                cat.setColorId(rs.getInt(4));
                return cat;
            }
        }));
//        return jdbcTemplate.execute(query, new PreparedStatementCallback<String>() {
//            @Override
//            public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//                ps.setString(1, name);
//                return String.valueOf(ps.execute());
//            }
//        });

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
