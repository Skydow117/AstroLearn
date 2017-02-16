/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import animacions.Cercles;
import astreList.AstreList;
import cossosCelestes.Planeta;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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

    private ArrayList<RadioButton> radioGrup = new ArrayList();
    private ArrayList<URL> imatgesToggleGroup = new ArrayList();
    private LectorXML lector = new LectorXML();
    private int nUltimAstre = 2;
    final ToggleGroup toggle01 = new ToggleGroup();

    @FXML
    private void accioRadioButtons(ActionEvent event) {
        canviaAstre(radioGrup.indexOf(toggle01.getSelectedToggle()));
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
        // TODO
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
            
            Planeta nouP=new Planeta("Terra","Molt maca");
            
            AstreList<Planeta> astreList = new AstreList<Planeta>();
            astreList.afegir(nouP);
            
            System.out.println(astreList.agafar(0).getNom());
            
          

        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
