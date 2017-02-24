package comparador;

import cossosCelestes.Planeta;
import java.util.Comparator;

/**
 * Comparador de planetes.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class ComparadorPlanetes implements Comparator<Planeta> {
    
    /**
     * Compara dos planetes per la seva distancia del sol.
     * 
     * @param a Planeta
     * @param b Planeta
     * @return Integer
     */
    @Override
    public int compare(Planeta a, Planeta b) {
                
        return a.getDistanciaEstrella() < b.getDistanciaEstrella() ? -1 : a.getDistanciaEstrella() == b.getDistanciaEstrella() ? 0 : 1;
    }
}