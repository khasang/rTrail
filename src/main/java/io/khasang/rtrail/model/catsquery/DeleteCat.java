package io.khasang.rtrail.model.catsquery;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteCat {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DeleteCat() {
    }

    public DeleteCat(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String deleteCatById(int catId) {
        try {
            jdbcTemplate.update("DELETE FROM cats WHERE id = ?", catId);
            return "cat under id: " + catId + " was successfully deleted!";
        } catch (Exception e) {
            return "cat was not deleted: " + e;
        }
    }
}
