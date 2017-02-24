package astreList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe generica per enmagatzemar objectes dinàmicament.
 * Nosaltres l'utilitzarem per a les instàncies de la classe Astre.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class AstreList<T> {

    LinkedList<T> llista;

    /**
     * Constructor que crea la llista.
     */
    public AstreList() {

        llista = new LinkedList<T>();
    }

    /**
     * Afegeix un objecte al array.
     * 
     * @param objecte Objecte del tipus T.
     */
    public void afegir(T objecte) {
        llista.add(objecte);
    }

    /**
     * Retorna l'objecte de l'array a la posició indicada.
     * 
     * @param index
     * @return T Objecte de la classe T.
     */
    public T agafar(int index) {
        return llista.get(index);

    }

    /**
     * Retorna la mida del array de la classe.
     * 
     * @return Integer Mida del array.
     */
    public int mida() {
        return llista.size();
    }

}
