/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.dominio;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 * @author juandaviddavila
 */
public class tipoMensajes {
      private int type;
    private String message;
    private String retorno;

    public tipoMensajes() {
    }

    public tipoMensajes(String message, int type, String retorno) {
        this.type = type;
        this.message = message;
        this.retorno = retorno;
    }

    public static tipoMensajes generarJson(String message, int type, String retorno) {
        return new tipoMensajes(message, type, retorno);
    }
  public static String createJsonString(Object object) throws IOException {
        Writer writer = new StringWriter();
        JsonFactory factory = new JsonFactory();
        JsonGenerator generator = factory.createJsonGenerator(writer);
        generator.setCodec(new ObjectMapper());
        generator.writeObject(object);
        generator.close();
        //System.out.println("Json string " + writer.toString());
        return writer.toString();
    }
    public static String generarJson2(String message, int type, String retorno) throws IOException {
        return createJsonString(new tipoMensajes(message, type, retorno));
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

}
