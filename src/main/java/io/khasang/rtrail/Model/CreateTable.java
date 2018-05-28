package io.khasang.rtrail.Model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS cats (id INTEGER PRIMARY KEY NOT NULL, " +
                    "name VARCHAR(255), " +
                    "description VARCHAR(255), " +
                    "color_id INTEGER)");
            return "table created";
        } catch (Exception e) {
            return "table creation failed" + e;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
