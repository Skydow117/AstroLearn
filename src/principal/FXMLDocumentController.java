/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import animacions.Cercles;
import astreList.AstreList;
import cossosCelestes.Planeta;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import utilitatXML.EscriptorXML;
import utilitatXML.LectorXML;

/**
 *
 * @author davidcastillomartinez
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private HBox hbContenidor;

    @FXML
    private RadioButton radioSatelits01;

    @FXML
    private RadioButton radioSatelits02;

    @FXML
    private RadioButton radioPlanetes01;

    @FXML
    private RadioButton radioPlanetes02;

    @FXML
    private RadioButton radioPlanetes03;

    @FXML
    private RadioButton radioPlanetes04;

    @FXML
    private RadioButton radioEstrelles01;

    @FXML
    private ImageView imageViewEstrelles;

    @FXML
    private ImageView imageViewSatelits;

    @FXML
    private ImageView imageViewPlanetes;

    @FXML
    private Label lTitol;

    @FXML
    private Label lDescripcio;

    @FXML
    public Label lbDies;

    @FXML
    private AnchorPane apMainAnchor;

    private ArrayList<RadioButton> radioGrup = new ArrayList();
    private ArrayList<URL> imatgesToggleGroup = new ArrayList();
    private LectorXML lector = new LectorXML();
    private int nUltimAstre = 2;
    final ToggleGroup toggle01 = new ToggleGroup();
    public int nDies = 0;

    @FXML
    private void accioRadioButtons(ActionEvent event) {
        canviaAstre(radioGrup.indexOf(toggle01.getSelectedToggle()));
    }

    @FXML
    private void obreFitxerDadesXML(ActionEvent event) throws IOException {
        File file = new File("fitxersPrograma/astres.xml");

        Desktop desktop = Desktop.getDesktop();

        desktop.open(file);
    }

    @FXML
    private void obreFitxerUltimAstreXML(ActionEvent event) throws IOException {
        File file = new File("fitxersPrograma/ultimAstre.xml");

        Desktop desktop = Desktop.getDesktop();

        desktop.open(file);
    }

    @FXML
    private void obreFitxerConfiguracio(ActionEvent event) throws IOException {
        File file = new File("fitxersPrograma/configuracio.txt");

        Desktop desktop = Desktop.getDesktop();

        desktop.open(file);
    }

    @FXML
    private void obreDialeg(ActionEvent event) throws IOException {
        Stage stage = (Stage) apMainAnchor.getScene().getWindow();

        Stage dialog = new Stage();

        dialog.initOwner(stage);
        dialog.initModality(Modality.APPLICATION_MODAL);

        ///
        Label label = new Label();
        label.setAlignment(Pos.CENTER);
        label.setText("                          ASTRO LEARN©\n"
                + "\nAstro Learn és un programa desenvolupat per "
                + "\nDavid Castillo i Esteve Cabrera com a projecte"
                + "\nde JavaFX per a l'assignatura de Java durant"
                + "\nl'any 2017 al curs DAM 2.\n"
                + "\nEl propòsit d'aquest programa és ensenyar a "
                + "\nalumnes de secundària o primària coneixements "
                + "\nastrònomics d'una forma més divertida amb "
                + "\nl'utilització d'animacions.\n"
                + "\nEn quant als fitxer de configuracó, es recomana"
                + "\nno modificarlos excepte previa lectura del fitxer"
                + "\nreadme.txt de la carpeta del programa.\n\n\n\n");

        Button btn = new Button();
        btn.setText("Sortir d'aqui");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                dialog.close();

            }
        });

        StackPane root = new StackPane();

        VBox vbox2 = new VBox();
        vbox2.getChildren().add(label);
        vbox2.getChildren().add(btn);
        vbox2.setPadding(new Insets(10, 10, 10, 10));

        vbox2.setAlignment(Pos.CENTER);

        root.getChildren().add(vbox2);

        Scene scene = new Scene(root, 300, 250);

        dialog.setTitle("En quant a AstroLearn");
        dialog.setScene(scene);
        dialog.setResizable(false);
        //
        dialog.setScene(scene);
        dialog.show();
        dialog.setWidth(325);

        dialog.setHeight(400);
        dialog.centerOnScreen();

    }

    @FXML
    private void tancarFinestra(ActionEvent event) throws IOException, Throwable {
        Platform.exit();
    }

    public void canviaAstre(int index) {
        switch (index) {

            case 0:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(0).toString()));
                System.out.println(imatgesToggleGroup.get(0).toString());
                canviarTextPlaneta(lector.obtenirPlaneta(0));
                toggle01.selectToggle(radioPlanetes01);
                break;
            case 1:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(1).toString()));
                System.out.println(imatgesToggleGroup.get(1).toString());
                canviarTextPlaneta(lector.obtenirPlaneta(1));
                toggle01.selectToggle(radioPlanetes02);
                break;
            case 2:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(2).toString()));
                System.out.println(imatgesToggleGroup.get(2).toString());
                canviarTextPlaneta(lector.obtenirPlaneta(2));
                toggle01.selectToggle(radioPlanetes03);
                break;
            case 3:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(3).toString()));
                System.out.println(imatgesToggleGroup.get(3).toString());
                canviarTextPlaneta(lector.obtenirPlaneta(3));
                toggle01.selectToggle(radioPlanetes04);

                break;
            case 4:
                imageViewSatelits.setImage(new Image(imatgesToggleGroup.get(4).toString()));
                System.out.println(imatgesToggleGroup.get(4).toString());
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(null);
                canviarTextPlaneta(lector.obtenirPlaneta(4));
                toggle01.selectToggle(radioSatelits01);
                break;
            case 5:
                imageViewSatelits.setImage(new Image(imatgesToggleGroup.get(5).toString()));
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(null);
                System.out.println(imatgesToggleGroup.get(5).toString());
                canviarTextPlaneta(lector.obtenirPlaneta(5));
                toggle01.selectToggle(radioSatelits02);
                break;
            case 6:
                imageViewSatelits.setImage(null);
                System.out.println(imatgesToggleGroup.get(6).toString());
                imageViewEstrelles.setImage(new Image(imatgesToggleGroup.get(6).toString()));
                imageViewPlanetes.setImage(null);
                canviarTextPlaneta(lector.obtenirPlaneta(6));
                toggle01.selectToggle(radioEstrelles01);
                break;
        }

        nUltimAstre = radioGrup.indexOf(toggle01.getSelectedToggle());
        System.out.println(nUltimAstre);
        EscriptorXML escriptorX = new EscriptorXML();
        escriptorX.escriure(String.valueOf(nUltimAstre));
    }

    public void valorsPerDefecte() {
        imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(2).toString()));

    }

    public void canviarTextPlaneta(Planeta planeta) {
        lTitol.setText(planeta.getNom());
        lDescripcio.setText(planeta.getDescripcio());

    }

    public void carregarImatges() {

        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL;

        StringBuilder urlImatge = new StringBuilder();
        urlImatge.append("imatges/miniatura0.jpg");

        for (int i = 0; i < 7; i++) {

            urlImatge.delete(17, 24);
            urlImatge.append(i + ".jpg");

            imageURL = cldr.getResource(urlImatge.toString());
            System.out.println(urlImatge.toString());
            imatgesToggleGroup.add(imageURL);
        }
    }

    public void iniciarToggleGroup() {

        radioGrup.add(radioPlanetes01);
        radioGrup.add(radioPlanetes02);
        radioGrup.add(radioPlanetes03);
        radioGrup.add(radioPlanetes04);

        radioGrup.add(radioSatelits01);
        radioGrup.add(radioSatelits02);

        radioGrup.add(radioEstrelles01);

        for (int i = 0; i < 7; i++) {

            radioGrup.get(i).setToggleGroup(toggle01);

        }

        carregarImatges();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                int i = 0;
                while (true) {
                    final int finalI = i;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lbDies.setText("Díes terrestres: " + finalI);
                        }
                    });
                    i++;
                    Thread.sleep(12000);
                }
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        //ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        //executor.scheduleAtFixedRate(contaDies, 0, 3, TimeUnit.SECONDS);
        Cercles cercle = new Cercles();
        try {

            hbContenidor.fillHeightProperty();
            hbContenidor.getChildren().add(cercle.crearSubscena(hbContenidor.heightProperty(), hbContenidor.widthProperty()));
            iniciarToggleGroup();
            valorsPerDefecte();

            try {
                lector.adquirir();
                canviaAstre(lector.getUltimPlaneta());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            Planeta nouP = new Planeta("Terra", "Molt maca");

            AstreList<Planeta> astreList = new AstreList<Planeta>();
            astreList.afegir(nouP);

            System.out.println(astreList.agafar(0).getNom());

        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
