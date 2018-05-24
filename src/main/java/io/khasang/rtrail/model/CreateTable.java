package io.khasang.rtrail.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        return String.valueOf(jdbcTemplate.query("SELECT * FROM cats WHERE name = 'Barsik'", new RowMapper<Cat>() {
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

    public String updateColorCat(int colorId, String name) {
        try {
            jdbcTemplate.update("UPDATE cats SET color_id = ? WHERE name = ?", colorId, name);
            return "cat's color updated";
        } catch (Exception e) {
            return "color's updating failed: \n" + e;
        }
    }

    public String deleteCatById(int id) {
        try {
            jdbcTemplate.update("DELETE FROM cats WHERE id = ?", id);
            return "cat deleted";
        } catch (Exception e) {
            return "cat's deletion failed: \n" + e;
        }
    }

    public String insertIntoCat(Cat cat) {
        try {
            jdbcTemplate.update("INSERT INTO cats (id, name, description, color_id) VALUES (?,?,?,?)",
                    cat.getId(), cat.getName(), cat.getDescription(), cat.getColorId());
            return "New cat inserted";
        } catch (Exception e) {
            return "cat's insert failed: \n" + e;
        }
    }

    public String showAllCatsWithColor(String colorName) {
        return String.valueOf(jdbcTemplate.query("SELECT * FROM cats WHERE color_id in " +
                "(SELECT id FROM cats_color WHERE name = '" + colorName + "')", new RowMapper<Cat>() {
            @Override
            public Cat mapRow(ResultSet rs, int rowCount) throws SQLException {
                return new Cat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        }));

    }

    public String showAllCats() {
        return String.valueOf(jdbcTemplate.query("SELECT c.*, cc.name FROM cats c JOIN cats_color cc ON c.color_id = cc.id", new RowMapper<ColorfulCat>() {
            @Override
            public ColorfulCat mapRow(ResultSet rs, int rowCount) throws SQLException {
                return new ColorfulCat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            }
        }));
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
