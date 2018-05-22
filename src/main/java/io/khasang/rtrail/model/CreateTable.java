package io.khasang.rtrail.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableStatus(){
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.cats\n"+
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255),\n" +
                    "    description character varying(255),\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
        }catch (Exception e){
            return "Table creation failed: " + e;
        }
    }

    public String getCatByName(String name){
        return String.valueOf(jdbcTemplate.query("select * from cats where name = " +"'"+ name +"'", new RowMapper<Cat>(){
            @Override
            public Cat mapRow(ResultSet rs, int rownumber) throws SQLException {
                Cat e =new Cat();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setDescription(rs.getString(3));
                e.setColorid(rs.getInt(4));
                return e;
            }
        }));

    }

    public String updateCatDescription (String description, int catId){
        try {
            jdbcTemplate.update("UPDATE cats SET description = ? WHERE id = ?", description, catId);
            return "table updated, cats id: " + catId + "new description is: " +description ;
        }catch (Exception e) {
            return "table undated failed: " + e;
        }
    }

    public String deleteCatById(int catId){
        try{
            jdbcTemplate.update("DELETE FROM cats WHERE id = ?", catId);
            return "cat under id: " + catId + " was successfully deleted!";
        }catch (Exception e){
            return "cat was not deleted: " + e;
        }
    }

    public String insertNewCat(int id, String name, String description, int colorId){
        try{
            jdbcTemplate.update("INSERT INTO cats (id, name, description ,color_id) VALUES (?, ?, ?, ?)", id, name, description, colorId);
            return "cat id:" +id+ " name: " + name + " description: " + description + " color_id: " + colorId + " was inserted!";
        }catch (Exception e){
            return "cat was not inserted: " + e;
        }
    }

    public String joinTables(){
        return "";
    }

}
