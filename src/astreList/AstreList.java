/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astreList;

import java.util.ArrayList;

/**
 *
 * @author davidcastillomartinez
 */
public class AstreList<T> {

    ArrayList<T> llista;

    public AstreList() {

        llista = new ArrayList<T>();
    }

    public void afegir(T objecte) {
        llista.add(objecte);
    }

    public T agafar(int index) {
        return llista.get(index);

    }

}
