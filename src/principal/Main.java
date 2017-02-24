package principal;

import animacions.Cercles;
import com.sun.javafx.tk.Toolkit;
import fitxerConfiguracio.EscriptorConfiguracio;
import fitxerConfiguracio.LectorConfiguracio;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class Main extends Application {

    /**
     * Crida al fxml i prepara l'stage amb l'última configuració guardada.
     * 
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        administradorDeConfiguracio admConfig = new administradorDeConfiguracio(primaryStage);
        admConfig.recuperar();

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        /**
         * Guarda les dades abans de que es tanqui el programa.
         */
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println(primaryStage.isFullScreen());
                admConfig.salvar();
                primaryStage.setFullScreen(false);
                Platform.exit();
            }
        });

    }

    /**
     * Classe que administra el fitxer de configuració.
     */
    private class administradorDeConfiguracio {

        private Stage stage;

        /**
         * Constructor que crea el directori utilitzat si no existeix.
         * 
         * @param stage 
         */
        public administradorDeConfiguracio(Stage stage) {
            this.stage = stage;
            crearDirectori();
        }

        
        /**
         * Crea el directori si no existeix.
         */
        public void crearDirectori() {

            File theDir = new File("fitxersPrograma");

            if (!theDir.exists()) {
                System.out.println("creating directory: " + theDir.getName());
                boolean result = false;

                try {
                    theDir.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    //handle it
                }
                if (result) {
                    System.out.println("DIR created");
                }
            }

        }

        /**
         * Recupera les dades del fitxar i les aplica.
         */
        public void recuperar() {

            LectorConfiguracio lector = new LectorConfiguracio();
            aplicar(lector.llegir());

        }

        /**
         * Salva les dades al fitxer.
         */
        public void salvar() {

            EscriptorConfiguracio escriptor = new EscriptorConfiguracio();
            escriptor.escriureFitxer(stage);

        }

        /**
         * Aplica la configuració a l'stage.
         * 
         * @param normes 
         */
        public void aplicar(ArrayList<String> normes) {

            boolean canviatCompleta = false;

            for (String norm : normes) {

                String[] parts = norm.split("->");

                switch (parts[0]) {
                    case "##pantallaCompleta":
                        if (parts[1].equals("cert")) {
                            stage.setFullScreen(true);
                        } else if (parts[1].equals("fals")) {
                            stage.setFullScreen(false);
                        }
                        canviatCompleta = true;
                        break;
                    case "##ampladaPantalla":
                        try {
                            stage.setWidth(Double.parseDouble(parts[1]));

                        } catch (Exception e) {
                            stage.setWidth(750);
                        }
                        break;
                    case "##alçadaPantalla":
                        try {
                            stage.setHeight(Double.parseDouble(parts[1]));

                        } catch (Exception e) {
                            stage.setHeight(750);
                        }
                        break;
                }

            }
            if (!canviatCompleta) {
                stage.setFullScreen(true);

            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
