/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.dao;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.ejemplo.dominio.EstudianteDominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author juandaviddavila
 */
public class EstudianteDao {

    protected DataSource dataSource;
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplatee;
    protected PlatformTransactionManager transactionManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplatee = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public int grabar(EstudianteDominio objEstudianteDominio) {
        if (objEstudianteDominio.getId() == 0) {
            String SQL = "INSERT INTO estudiante(nombre,direccion,nota)VALUES(:nombre,:direccion,:nota);";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplatee.update(SQL, new BeanPropertySqlParameterSource(objEstudianteDominio),
                    keyHolder, new String[]{"id"});
            return keyHolder.getKey().intValue();
        } else {
            String SQL = "UPDATE estudiante SET nombre=:nombre,direccion=:direccion,nota=:nota WHERE id=:id;";
            namedParameterJdbcTemplatee.update(SQL, new BeanPropertySqlParameterSource(objEstudianteDominio));
            return 0;
        }
    }

    public int grabar2(EstudianteDominio objEstudianteDominio) {
        if (objEstudianteDominio.getId() == 0) {
            String SQL = "INSERT INTO estudiante(nombre,direccion,nota)VALUES(:nombre,:direccion,:nota);";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplatee.update(SQL, new MapSqlParameterSource().addValue("nombre", objEstudianteDominio.getNombre())
                    .addValue("direccion", objEstudianteDominio.getDireccion())
                    .addValue("nota", objEstudianteDominio.getNota()),
                    keyHolder, new String[]{"id"});
            return keyHolder.getKey().intValue();
        } else {
            String SQL = "UPDATE estudiante SET nombre=:nombre,direccion=:direccion,nota=:nota WHERE id=:id2;";
            namedParameterJdbcTemplatee.update(SQL, new MapSqlParameterSource().addValue("nombre", objEstudianteDominio.getNombre())
                    .addValue("direccion", objEstudianteDominio.getNombre())
                    .addValue("nota", objEstudianteDominio.getNota())
                    .addValue("id2", objEstudianteDominio.getId()));
            return 0;
        }
    }

    public List<EstudianteDominio> cosultarTodos() {
        return namedParameterJdbcTemplatee.query("SELECT id,nombre,direccion,nota FROM estudiante;",
                new MapSqlParameterSource(), new BeanPropertyRowMapper(EstudianteDominio.class));
    }

    public List<Map<String, Object>> cosultarTodos2() {
        return namedParameterJdbcTemplatee.queryForList("SELECT id,nombre,direccion,nota,1 as adicional FROM estudiante;",
                new MapSqlParameterSource());
    }

    public List<EstudianteDominio> cosultarTodos3() {
        return namedParameterJdbcTemplatee.query("SELECT id,nombre,direccion,nota,1 as adicional FROM estudiante;",
                new MapSqlParameterSource(), new BeanPropertyRowMapper(EstudianteDominio.class));
    }

}
