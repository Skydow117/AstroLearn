/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import animacions.Cercles;
import java.io.File;
import java.net.URL;
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
    private Label label;
    
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
    private ImageView imageViewSatelits01;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Cercles cercle = new Cercles();
        try {
            hbContenidor.getChildren().add(cercle.crearSubscena());
            
            //Tots els botons estàn dins el mateix ToggleGroup ja que nomes pot averhi una animaciò alhora.
            final ToggleGroup toggle01;
            toggle01 = new ToggleGroup();
            
            radioPlanetes01.setToggleGroup(toggle01);
            radioPlanetes02.setToggleGroup(toggle01);
            radioPlanetes03.setToggleGroup(toggle01);
            radioPlanetes04.setToggleGroup(toggle01);

            radioSatelits01.setToggleGroup(toggle01);
            radioSatelits02.setToggleGroup(toggle01);
            
            radioEstrelles01.setToggleGroup(toggle01);
            
             //File file = new File("src/imatges/solMiniatura.jpg");
            ClassLoader cldr = this.getClass().getClassLoader();
            java.net.URL imageURL   = cldr.getResource("imatges/solMiniatura.jpg");
            Image image = new Image(imageURL.toURI().toString());
            imageViewSatelits01.setImage(image);
            
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
