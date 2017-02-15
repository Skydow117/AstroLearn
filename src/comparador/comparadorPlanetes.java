/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador;

import cossosCelestes.Planeta;
import java.util.Comparator;

/**
 *
 * @author davidcastillomartinez
 */
public class comparadorPlanetes implements Comparator<Planeta> {
    @Override
    public int compare(Planeta a, Planeta b) {
                
        return a.getDistanciaEstrella() < b.getDistanciaEstrella() ? -1 : a.getDistanciaEstrella() == b.getDistanciaEstrella() ? 0 : 1;
    }
}