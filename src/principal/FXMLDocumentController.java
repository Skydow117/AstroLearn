/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import animacions.Cercles;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javax.swing.ImageIcon;

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

    private ArrayList<RadioButton> radioGrup = new ArrayList();
    private ArrayList<URL> imatgesToggleGroup = new ArrayList();
    final ToggleGroup toggle01 = new ToggleGroup();

    @FXML
    private void accioRadioButtons(ActionEvent event) {

        System.out.println(radioGrup.indexOf(toggle01.getSelectedToggle()));

        switch (radioGrup.indexOf(toggle01.getSelectedToggle())) {

            case 0:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(0).toString()));
                System.out.println(imatgesToggleGroup.get(0).toString());
                break;
            case 1:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(1).toString()));
                System.out.println(imatgesToggleGroup.get(1).toString());

                break;
            case 2:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(2).toString()));
                System.out.println(imatgesToggleGroup.get(2).toString());
                break;
            case 3:
                imageViewSatelits.setImage(null);
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(3).toString()));
                System.out.println(imatgesToggleGroup.get(3).toString());
                break;
            case 4:
                imageViewSatelits.setImage(new Image(imatgesToggleGroup.get(4).toString()));
                System.out.println(imatgesToggleGroup.get(4).toString());
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(null);
                break;
            case 5:
                imageViewSatelits.setImage(new Image(imatgesToggleGroup.get(5).toString()));
                imageViewEstrelles.setImage(null);
                imageViewPlanetes.setImage(null);
                System.out.println(imatgesToggleGroup.get(5).toString());
                break;
            case 6:
                imageViewSatelits.setImage(null);
                System.out.println(imatgesToggleGroup.get(6).toString());
                imageViewEstrelles.setImage(new Image(imatgesToggleGroup.get(6).toString()));
                imageViewPlanetes.setImage(null);
                break;
        }

    }

    public void valorsPerDefecte() {
        imageViewPlanetes.setImage(new Image(imatgesToggleGroup.get(2).toString()));

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
        // TODO
        Cercles cercle = new Cercles();
        try {
            hbContenidor.getChildren().add(cercle.crearSubscena());

            //Tots els botons estàn dins el mateix ToggleGroup ja que nomes pot averhi una animaciò alhora.
            iniciarToggleGroup();

            valorsPerDefecte();

            //File file = new File("src/imatges/solMiniatura.jpg");
//            ClassLoader cldr = this.getClass().getClassLoader();
//            java.net.URL imageURL   = cldr.getResource("imatges/solMiniatura.jpg");
//            Image image = new Image(imageURL.toURI().toString());
//            imageViewSatelits01.setImage(image);
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
