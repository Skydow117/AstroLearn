/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxerConfiguracio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidcastillomartinez
 */
public class LectorConfiguracio {

    public LectorConfiguracio() {
    }

    public ArrayList<String> llegir() {

        ArrayList<String> linies = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        String fitxer = "fitxersPrograma/configuracio.txt";

        try {

            fr = new FileReader(fitxer);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fitxer));

            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                if (linies.contains("#!#Conproplang#¡#") && linies.contains("##comença##") && i == 2) {
                    System.out.println("Puc començar");
                } else if (i == 2) {
                    System.out.println("Estic malament");
                    break;
                }
                System.out.println(sCurrentLine);
                linies.add(sCurrentLine);
                i++;
                if (linies.contains("##acaba##")) {
                    System.out.println("He acabat");
                    break;
                }
                
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return linies;

    }

}
