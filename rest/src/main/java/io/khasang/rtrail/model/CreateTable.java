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
            // open
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            // close

            // open
            jdbcTemplate.execute("CREATE TABLE public.cats\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(255),\n" +
                    "  description character varying(255),\n" +
                    "  color_id integer,\n" +
                    "  CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
        } catch (Exception e) {
            return "Table creation failed: " + e;
        }
    }

//    public String getCatByName(String name) {
////        String query = "Select * from cats where name  = ?";
////        return jdbcTemplate.execute(query, new PreparedStatementCallback<String>() {
////            @Override
////            public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
////                ps.setString(1, name);
////                return String.valueOf(ps.execute());
////            }
////        });
//        return String.valueOf(jdbcTemplate.query("select * from cats where name = 'Barsik'", new RowMapper<Cat>() {
//            @Override
//            public Cat mapRow(ResultSet rs, int rownumber) throws SQLException {
//                Cat e = new Cat();
//                e.setId(rs.getInt(1));
//                e.setName(rs.getString(2));
//                e.setDescription(rs.getString(3));
//                e.setColorId(rs.getInt(4));
//                return e;
//            }
//        }));
//
//    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
