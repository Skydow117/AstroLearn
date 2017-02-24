package fitxerConfiguracio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Llegeix el fitxer de configuració creat anteriorment.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class LectorConfiguracio {

    /**
     * Constructor buit
     */
    public LectorConfiguracio() {
    }

    /**
     * Retorna un arrayList d'strings amb el contingut de cada linia de configuració.
     * 
     * @return 
     */
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
