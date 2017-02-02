package principal;

import animacions.Cercles;
import com.sun.javafx.tk.Toolkit;
import java.awt.FontMetrics;
import java.awt.Insets;
import javafx.application.Application;
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


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
//        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        //StackPane root = new StackPane();
//
//        primaryStage.setTitle("Astro Learn");
//        Cercles cercles = new Cercles();
//        //Scene escenaPrincipal = new Scene(root, 300, 275);
//        HBox layout = new HBox(
//                cercles.crearSubscena()
//        );
//        VBox verticalOne =new VBox();
//        
//        verticalOne.setStyle("-fx-background-color: #b3b3b3;");
//        
//        Button boto1 = new Button("boto2");
//        Button boto2 = new Button("boto2");
//        boto1.setPrefSize(120, 30);
//        TabPane tabPane=new TabPane();
//        Tab tabPlanetes= new Tab("Planetes");
//        Tab tabSatelits= new Tab("Satelits");
//        Tab tabEstrelles= new Tab("Estrelles");
//        tabPlanetes.setContent(boto1);
//        tabSatelits.setContent(boto2);
//        tabPane.getTabs().add(tabPlanetes);
//        tabPane.getTabs().add(tabSatelits);
//        tabPane.getTabs().add(tabEstrelles);
//        
//        
//        
//        verticalOne.getChildren().add(tabPane);
//        layout.getChildren().add(verticalOne);
//
//        Scene scene = new Scene(layout, Color.CORNSILK);
//
//        primaryStage.setScene(scene);
//        primaryStage.setFullScreen(true);
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
