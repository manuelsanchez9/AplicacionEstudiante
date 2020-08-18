/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.server;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.ejemplo.dao.EstudianteDao;
import org.ejemplo.dominio.Data;
import org.ejemplo.dominio.EstudianteDominio;
import org.ejemplo.dominio.tipoMensajes;
import org.ejemplo.negocio.Negocio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juandaviddavila
 */
@RestController
//@Scope("session")  
@RequestMapping("/estudiante")
public class EstudianteController {

    @Resource
    private EstudianteDao objEstudianteDao;

    @RequestMapping(value = "/grabar", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    tipoMensajes grabar(@RequestBody EstudianteDominio objEstudianteDominio,
            HttpServletRequest httpRequest) {
        try {
            return Data.getMensajeJson("save", 1, String.valueOf(objEstudianteDao.grabar(objEstudianteDominio)));
        } catch (Exception ex) {
            return Data.getMensajeJson("save", 0, ex.getMessage());
        }
    }

    @RequestMapping(value = "/grabar2", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    tipoMensajes grabar2(@RequestBody EstudianteDominio objEstudianteDominio,
            HttpServletRequest httpRequest) {
        try {
            return Data.getMensajeJson("save", 1, String.valueOf(objEstudianteDao.grabar2(objEstudianteDominio)));
        } catch (Exception ex) {
            return Data.getMensajeJson("save", 0, ex.getMessage());
        }
    }

    @RequestMapping(value = "/cosultarTodos", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<EstudianteDominio> cosultarTodos(
            HttpServletRequest httpRequest) {
        List<EstudianteDominio> cosultarTodos = objEstudianteDao.cosultarTodos();
        return cosultarTodos;
    }

    @RequestMapping(value = "/cosultarTodos2", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Map<String, Object>> cosultarTodos2(
            HttpServletRequest httpRequest) {
        return objEstudianteDao.cosultarTodos2();
    }

    @RequestMapping(value = "/cosultarTodos3", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<EstudianteDominio> cosultarTodos3(
            HttpServletRequest httpRequest) {
        return objEstudianteDao.cosultarTodos3();
    }
}
