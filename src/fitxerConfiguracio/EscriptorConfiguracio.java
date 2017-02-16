/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitxerConfiguracio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.stage.Stage;

/**
 *
 * @author davidcastillomartinez
 */
public class EscriptorConfiguracio {

    public void escriureFitxer(Stage stage) {

        BufferedWriter writer = null;
        try {
            File logFile = new File("fitxersPrograma/configuracio.txt");

            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));

            //Comença escriptura
            writer.write("#!#Conproplang#¡#");
            writer.write("\n##comença##");
            if (stage.isFullScreen()) {
                writer.write("\n##pantallaCompleta->cert");
            } else if (!stage.isFullScreen()) {
                writer.write("\n##pantallaCompleta->fals");
            }
            writer.write("\n##ampladaPantalla->" + stage.getWidth());
            writer.write("\n##alçadaPantalla->" + stage.getHeight());
            writer.write("\n##acaba##");
            //acaba escriptura

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }

    }

}
