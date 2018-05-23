package io.khasang.rtrail.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private JdbcTemplate jdbcTemplate;

    public Catalog(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, String> getSections() {
        Map<String, String> sections = new HashMap<>();
        sections.put("/catalog/videoregistratory", "Видеорегистраторы");
        sections.put("/catalog/radardetektory", "Радар-детекторы");
        sections.put("/catalog/avtoholodilniki", "Автохолодильники");
        return sections;

        // todo read from db, 404 page
    }

    public Map<String, String> getElements(String sectionCode) {
        Map<String, String> elements = new HashMap<>();
        switch (sectionCode) {
            case "videoregistratory":
                elements.put("/catalog/videoregistratory/videoregistrator-artway-AV-110", "Видеорегистратор Artway AV-110");
                elements.put("/catalog/videoregistratory/videoregistrator-prestigio-roa", "Видеорегистратор Prestigio RoadRunner 325");
                break;
            case "radardetektory":
                elements.put("/catalog/radardetektory/radar-detektor-artway-RD-516", "Радар-детектор Artway RD-516");
                elements.put("/catalog/radardetektory/radar-detektor-sho-me-520-STR", "Радар-детектор Sho-Me 520 STR");
                break;
            case "avtoholodilniki":
                elements.put("/catalog/avtoholodilniki/avtoholodilnik-starwind-CF-123", "Автохолодильник Starwind CF-123");
                break;
            default:
                elements = null; // page not found 404
                break;
        }

        return elements;

        // todo read from db
    }

    public String getElement(String section, String element) {
        return "Описание товара ...";

        // todo read from db, 404 page
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // to do вынести в отдельный класс
    public String createIblockTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS iblock");
            jdbcTemplate.execute("CREATE TABLE public.iblock\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(50),\n" +
                    "  description character varying(255),\n" +
                    "  CONSTRAINT \"iblock_pkey\" PRIMARY KEY (id)\n" +
                    ")");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed " + e.getMessage();
        }
    }

    public String createIblockSectionTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS iblock_section");
            jdbcTemplate.execute("CREATE TABLE public.iblock_section\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(50),\n" +
                    "  description character varying(255),\n" +
                    "  iblock_id integer,\n" +
                    "  code character varying(30),\n" +
                    "  CONSTRAINT \"section_pkey\" PRIMARY KEY (id),\n" +
                    "  CONSTRAINT \"section_iblock_id_fkey\" FOREIGN KEY (iblock_id)\n" +
                    "      REFERENCES public.iblock (id) MATCH SIMPLE\n" +
                    "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                    ")");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed " + e.getMessage();
        }
    }

    public String createIblockElementTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS iblock_element");
            jdbcTemplate.execute("CREATE TABLE public.iblock_element\n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(50),\n" +
                    "  description character varying(255),\n" +
                    "  iblock_id integer,\n" +
                    "  section_id integer,\n" +
                    "  code character varying(30),\n" +
                    "  CONSTRAINT \"element_pkey\" PRIMARY KEY (id),\n" +
                    "  CONSTRAINT \"element_iblock_id_fkey\" FOREIGN KEY (iblock_id)\n" +
                    "      REFERENCES public.iblock (id) MATCH SIMPLE\n" +
                    "      ON UPDATE NO ACTION ON DELETE NO ACTION,\n" +
                    "  CONSTRAINT \"element_section_id_fkey\" FOREIGN KEY (section_id)\n" +
                    "      REFERENCES public.iblock_section (id) MATCH SIMPLE\n" +
                    "      ON UPDATE NO ACTION ON DELETE NO ACTION\n" +
                    ")");
            return "Table created";
        } catch (Exception e) {
            return "Table creation failed " + e.getMessage();
        }
    }

}
