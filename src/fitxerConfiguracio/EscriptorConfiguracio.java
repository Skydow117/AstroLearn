package fitxerConfiguracio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.stage.Stage;

/**
 *  Classe que escriu el fitxer que guarda la configuració de la resolució.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class EscriptorConfiguracio {

    /**
     * Escriu el fitxer basantse en el stage proporcionat.
     * I seguint les normes proporcionades.
     * 
     * @param stage 
     */
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
