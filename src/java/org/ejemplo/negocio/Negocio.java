/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ejemplo.negocio;

/**
 *
 * @author juandaviddavila
 */
public class Negocio {

    private int nContador = 0;

    public int suma(int n1, int n2) {
        return n1 + n2;
    }

    public int contador() {
        return nContador++;
    }
}
