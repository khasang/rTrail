package io.khasang.rtrail.model.catsquery;

import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateCat {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UpdateCat() {
    }

    public UpdateCat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String updateCatDescription(String description, int catId) {
        try {
            jdbcTemplate.update("UPDATE cats SET description = ? WHERE id = ?", description, catId);
            return "table updated, cats id: " + catId + "new description is: " + description;
        } catch (Exception e) {
            return "table undated failed: " + e;
        }
    }
}
