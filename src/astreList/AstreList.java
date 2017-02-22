/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astreList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author davidcastillomartinez
 */
public class AstreList<T> {

    LinkedList<T> llista;

    public AstreList() {

        llista = new LinkedList<T>();
    }

    public void afegir(T objecte) {
        llista.add(objecte);
    }

    public T agafar(int index) {
        return llista.get(index);

    }

    public int mida() {
        return llista.size();
    }

}
