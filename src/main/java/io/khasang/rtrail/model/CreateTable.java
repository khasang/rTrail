package io.khasang.rtrail.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String getDataFromBD(String name){
//        String query = "SELECT * FROM public.actor WHERE first_name = ?";
//        return jdbcTemplate.execute(query, new PreparedStatementCallback<String>() {
//            @Override
//            public String doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
//                preparedStatement.setString(1, name);
//                return String.valueOf(preparedStatement.execute());
//            }
//        });
//        return  String.valueOf(jdbcTemplate.query("SELECT * FROM public.actor WHERE first_name = 'Penelope'", new RowMapper<Actor>(){
//
//            @Override
//            public Actor mapRow(ResultSet resultSet, int i) throws SQLException {
//                Actor a = new Actor();
//                a.setActor_id(resultSet.getObject(1));
//                a.setFirst_name(resultSet.getString(2));
//                a.setLast_name(resultSet.getString(3));
//                a.setLast_update(resultSet.getString(4));
//                return a;
//            }
//        })
//        );
        name = "SELECT actor.first_name, actor.last_name, film_actor.film_id " +
                "FROM public.actor, public.film_actor WHERE actor.actor_id = " +
                "film_actor.actor_id";

        return  String.valueOf(jdbcTemplate.query(name, new RowMapper<UniversalEntity>(){

            @Override
            public UniversalEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                UniversalEntity a = new UniversalEntity(columnsNumber(resultSet));
                System.out.println(columnsNumber(resultSet));
                for (int j = 1; j< columnsNumber(resultSet); j++){
                    a.add(resultSet.getObject(j));
                }
                return a;
            }
        })
        );
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private int columnsNumber(ResultSet r) {
        int i=1;
        while (true){
            try {
                i++;
                r.getObject(i);
            } catch (SQLException e) {
                return i;
            }
        }

    }
}
