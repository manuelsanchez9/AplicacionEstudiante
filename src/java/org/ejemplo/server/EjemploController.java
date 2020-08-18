/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.ejemplo.negocio.Negocio;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/ejemplo")
public class EjemploController {

    @Resource
    private Negocio objNegocio;

    @RequestMapping(value = "/hola_mundo", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String HolaMundo(
            HttpServletRequest httpRequest) {
        return "Hola Mundo";
    }

    @RequestMapping(value = "/suma/{n1}/{n2}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String suma(@PathVariable int n1, @PathVariable int n2, HttpServletRequest httpRequest) {
        Negocio objNegocio = new Negocio();
        return String.valueOf(objNegocio.suma(n1, n2));
    }

    @RequestMapping(value = "/suma2/{n1}/{n2}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String suma2(@PathVariable int n1, @PathVariable int n2, HttpServletRequest httpRequest) {
        return String.valueOf(objNegocio.suma(n1, n2));
    }
        @RequestMapping(value = "/contador", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String contador( HttpServletRequest httpRequest) {
        Negocio objNegocio = new Negocio();
        return String.valueOf(objNegocio.contador());
    }

    @RequestMapping(value = "/contador2", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String contador2( HttpServletRequest httpRequest) {
        return String.valueOf(objNegocio.contador());
    }
}
