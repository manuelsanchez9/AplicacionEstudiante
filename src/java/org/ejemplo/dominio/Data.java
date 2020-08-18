/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.dominio;

import java.io.IOException;


/**
 *
 * @author Desarrollador
 */
public class Data {

    // <editor-fold defaultstate="collapsed" desc="Metodos Publicos">
    /**
     * Guarda la empresa
     *
     * @param message save,update,validar
     * @param type 1 que guardò correctamente y 0 que hubo error
     * @param retorno
     * @return retorna un json, con type que es el tipo de query, luego el value
     * que hay dos tipos de valor: 1 que guardò correctamente y 0 que hubo error
     * al guardar, y por ultimo esta retorno que es el ID del registro que se
     * acabó de registrar
     */
    public static tipoMensajes getMensajeJson(String message, int type, String retorno) {
        return tipoMensajes.generarJson(message, type, retorno);
//        String json = "{\"type\":\"" + type + "\",\"message\":\"" + message + "\",\"retorno\":\"" + retorno + "\"}";
//        return json;
    }

    /**
     * Guarda la empresa
     *
     * @param message save,update,validar
     * @param type 1 que guardò correctamente y 0 que hubo error
     * @return retorna un json, con type que es el tipo de query, luego el
     * message que hay dos tipos de valor: 1 que guardò correctamente y 0 que
     * hubo error al guardar, y por ultimo esta retorno que es el ID del
     * registro que se acabó de registrar
     */
    public static tipoMensajes getMensajeJson(String message, int type) {
        return getMensajeJson(message, type, "");
    }
  
}
