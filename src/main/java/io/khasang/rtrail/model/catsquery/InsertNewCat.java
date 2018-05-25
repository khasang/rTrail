package io.khasang.rtrail.model.catsquery;

import org.springframework.jdbc.core.JdbcTemplate;

public class InsertNewCat {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public InsertNewCat() {
    }

    public InsertNewCat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertNewCat(int id, String name, String description, int colorId) {
        try {
            jdbcTemplate.update("INSERT INTO cats (id, name, description ,color_id) VALUES (?, ?, ?, ?)", id, name, description, colorId);
            return "cat id:" + id + " name: " + name + " description: " + description + " color_id: " + colorId + " was inserted!";
        } catch (Exception e) {
            return "cat was not inserted: " + e;
        }
    }
}
