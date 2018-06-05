package io.khasang.rtrail.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(255),\n" +
                    "  description character varying(255),\n" +
                    "  color_id integer,\n" +
                    "  CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed " + e.getMessage();
        }
    }

    public String getCatByName(String name) {
        return String.valueOf(jdbcTemplate.query("select * from cats where name = " + "'" + name + "'",
                (rs, rowCount) -> new CatForJdbcInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4))));
    }

    public String getCatById(int id) {
        return String.valueOf(jdbcTemplate.query("select * from cats where id = " + "'" + id + "'",
                (rs, rowCount) -> new CatForJdbcInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4))));
    }

    public String deleteCatById(int id) {
        String cat = getCatById(id);
        try {
            jdbcTemplate.update("DELETE FROM cats WHERE id = ?", id);
            return "cat " + cat + " deleted";
        } catch (Exception e) {
            return "cat's " + cat + " deletion failed: \n" + e;
        }
    }

    public String updateCatNameById(int id, String name) {
        String cat = getCatById(id);
        try {
            jdbcTemplate.update("UPDATE cats SET name = ? WHERE id = ?", name, id);
            return "cat's " + cat + " name updated";
        } catch (Exception e) {
            return "cat's " + cat + " updating failed: " + e;
        }
    }

    public String addCat(CatForJdbcInfo cat) {
        try {
            jdbcTemplate.update("INSERT INTO cats (id, name, description, color_id) VALUES (?,?,?,?)",
                    cat.getId(), cat.getName(), cat.getDescription(), cat.getColorId());
            return "New cat added";
        } catch (Exception e) {
            return "cat's adding failed: \n" + e;
        }
    }

    public String getCatByColorName(String colorName) {
        return String.valueOf(jdbcTemplate.query("SELECT * FROM cats WHERE color_id in " +
                "(SELECT id FROM cats_color WHERE name = '" + colorName + "')", (rs, rowCount) ->
                new CatForJdbcInfo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4))));

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
