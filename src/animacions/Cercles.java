package animacions;

import java.util.List;
import cossosCelestes.*;
import java.util.Random;
import javafx.animation.Interpolator;
import principal.*;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.Screen;

public class Cercles {

    /**
     * Generate Path upon which animation will occur.
     *
     * @param pathOpacity The opacity of the path representation.
     * @return Generated path.
     */
    private Planeta p1 = new Planeta(8, 87, (int) (57));
    private Planeta p2 = new Planeta(22, 87, (int) (108));
    private Planeta p3 = new Planeta(36, 87, (int) (149));
    private Planeta p4 = new Planeta(68, 87, (int) (227));
    private Planeta p5 = new Planeta(433, 87, (int) (778));
    private Planeta p6 = new Planeta(1058, 87, (int) (1429));
    private Planeta p7 = new Planeta(3066, 87, (int) (2871));
    private Planeta p8 = new Planeta(5986, 87, (int) (4491));
    
    private Path generateCurvyPath(final double pathOpacity, int distance,SubScene subScene) {
        Path path = new Path();

        int x = (int)subScene.getWidth()/2;
        int y = (int)subScene.getHeight()/2;
        

        path.getElements().add(new MoveTo(x, y - distance));
        path.getElements().add(new CubicCurveTo(x - distance, y - distance, x - distance, y + distance, x, y + distance));
        path.getElements().add(new CubicCurveTo(x + distance, y + distance, x + distance, y - distance, x, y - distance));
        

        path.setOpacity(pathOpacity);
        return path;
    }

    /**
     * Generate the path transition.
     *
     * @param shape Shape to travel along path.
     * @param path Path to be traveled upon.
     * @return PathTransition.
     */
    private PathTransition generatePathTransition(final Shape shape, final Path path, int periode) {
        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(periode/8));
        pathTransition.setDelay(Duration.seconds(0));
        pathTransition.setPath(path);
        pathTransition.setNode(shape);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);

        return pathTransition;
    }

    /**
     * Determine the path's opacity based on command-line argument if supplied
     * or zero by default if no numeric value provided.
     *
     * @return Opacity to use for path.
     */
    private double determinePathOpacity() {
        return 1;
    }

    /**
     * Apply animation, the subject of this class.
     *
     * @param group Group to which animation is applied.
     */
    private void applyAnimation(final Group group,SubScene subScene) {
        final Circle circle = new Circle(20, 20, 4, Color.ORANGE); //1
        final Circle circle2 = new Circle(10, 20, 7, Color.AQUAMARINE); //2
        final Circle circle3 = new Circle(20, 20, 12, Color.BLUE); //3
        final Circle circle4 = new Circle(10, 20, 6, Color.RED); //7
        final Circle circle5 = new Circle(10, 20, 142, Color.BEIGE); //7
        final Circle circle6 = new Circle(10, 20, 120, Color.BROWN); //7
        final Circle circle7 = new Circle(10, 20, 51, Color.AQUA); //7
        final Circle circle8 = new Circle(10, 20, 51, Color.BLUE);
        
        
        ///
        Random r = new Random();
        int Low = 7;
        int High = 30;
        int Result = r.nextInt(High - Low) + Low;

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        double x= primaryScreenBounds.getMaxX();
        double y= primaryScreenBounds.getMaxY()+300;
        
        for (int i = 0; i < y; i+=r.nextInt(15 - 1) + 1) {
            for (int j = 0; j < x; j+=r.nextInt(High - Low) + Low) {
                group.getChildren().add(new Circle(r.nextInt((j+15) - j) + j,r.nextInt((i+15) - i) + i,0.35 , Color.WHITE));
            }
        }
         
        ///
        final Path path = generateCurvyPath(determinePathOpacity(), p1.getDistanciaEstrella(),subScene);
        final Path path2 = generateCurvyPath(determinePathOpacity(), p2.getDistanciaEstrella(),subScene);
        final Path path3 = generateCurvyPath(determinePathOpacity(), p3.getDistanciaEstrella(),subScene);
        final Path path4 = generateCurvyPath(determinePathOpacity(), p4.getDistanciaEstrella(),subScene);
        final Path path5 = generateCurvyPath(determinePathOpacity(), p5.getDistanciaEstrella(),subScene);
        final Path path6 = generateCurvyPath(determinePathOpacity(), p6.getDistanciaEstrella(),subScene);
        final Path path7 = generateCurvyPath(determinePathOpacity(), p7.getDistanciaEstrella(),subScene);
        final Path path8 = generateCurvyPath(determinePathOpacity(), p8.getDistanciaEstrella(),subScene);
        group.getChildren().add(path);
        group.getChildren().add(circle);
        group.getChildren().add(path2);
        group.getChildren().add(circle2);
        group.getChildren().add(path3);
        group.getChildren().add(circle3);
        group.getChildren().add(path4);
        group.getChildren().add(circle4);
        group.getChildren().add(path5);
        group.getChildren().add(circle5);
         group.getChildren().add(path6);
        group.getChildren().add(circle6);
         group.getChildren().add(path7);
        group.getChildren().add(circle7);
         group.getChildren().add(path8);
        group.getChildren().add(circle8);
        group.getChildren().add(new Circle(subScene.getWidth()/2, subScene.getHeight()/2, 40, Color.YELLOW));

        final PathTransition transition = generatePathTransition(circle, path, p1.getPeriode());
        final PathTransition transition2 = generatePathTransition(circle2, path2, p2.getPeriode());
        final PathTransition transition3 = generatePathTransition(circle3, path3, p3.getPeriode());
        final PathTransition transition4 = generatePathTransition(circle4, path4, p4.getPeriode());
        final PathTransition transition5 = generatePathTransition(circle5, path5, p5.getPeriode());
        final PathTransition transition6 = generatePathTransition(circle6, path6, p6.getPeriode());
        final PathTransition transition7 = generatePathTransition(circle7, path7, p7.getPeriode());
        final PathTransition transition8 = generatePathTransition(circle8, path8, p8.getPeriode());
        transition.play();
        transition2.play();
        transition3.play();
        transition4.play();
        transition5.play();
        transition6.play();
        transition7.play();
        transition8.play();
    }

    public SubScene crearSubscena(int x1,int y1,ReadOnlyDoubleProperty y, ReadOnlyDoubleProperty x) throws Exception {
        final Group rootGroup = new Group();
        final SubScene scene = new SubScene(rootGroup, x1, y1, true, SceneAntialiasing.BALANCED);
        //scene.heightProperty().bind(y);
        //scene.widthProperty().bind(x);
        scene.setFill(Color.BLACK);

        applyAnimation(rootGroup,scene);
        return scene;
    }
    
    public void applyAnimationLluna(){
        
    }
    public void generatePathTransitionLuna(){
        
    }
    public void generateCurvyPathLluna(){
        
    }

}
