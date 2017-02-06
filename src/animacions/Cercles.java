package animacions;

import java.util.List;
import cossosCelestes.*;
import principal.*;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Cercles {


    /**
     * Generate Path upon which animation will occur.
     *
     * @param pathOpacity The opacity of the path representation.
     * @return Generated path.
     */
    private Planeta p1=new Planeta(11,87,57);
    private Planeta p2=new Planeta(22,87,108);
    private Planeta p3=new Planeta(36,87,149);
    private Planeta p4=new Planeta(68,87,227);
    private Path generateCurvyPath(final double pathOpacity,int distance) {
        final Path path = new Path();
        final int x=250;
        final int y=250;
        path.getElements().add(new MoveTo(x, y-distance));
        for (int i = 0; i < 10; i++) {
            path.getElements().add(new CubicCurveTo(x-distance, y-distance, x-distance, y+distance, x, y+distance));
            path.getElements().add(new CubicCurveTo(x+distance, y+distance, x+distance, y-distance, x, y-distance));   
        }
        
        path.setOpacity(pathOpacity);
        return path;
    }

    /**
     * Generate the path transition.
     *
     * @param shape Shape to travel along path.
     * @param path  Path to be traveled upon.
     * @return PathTransition.
     */
    private PathTransition generatePathTransition(final Shape shape, final Path path,int periode) {
        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(periode));
        pathTransition.setDelay(Duration.seconds(0));
        pathTransition.setPath(path);
        pathTransition.setNode(shape);
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
        return 0.2;
    }

    /**
     * Apply animation, the subject of this class.
     *
     * @param group Group to which animation is applied.
     */
    private void applyAnimation(final Group group) {
        final Circle circle = new Circle(20, 20, 15);
        final Circle circle2 = new Circle(10, 20, 30);
        final Circle circle3 = new Circle(20, 20, 10);
        final Circle circle4 = new Circle(10, 20, 5);
        circle.setFill(Color.DARKRED);
        circle2.setFill(Color.AQUAMARINE);
        final Path path = generateCurvyPath(determinePathOpacity(),p1.getDistanciaEstrella());
        final Path path2 = generateCurvyPath(determinePathOpacity(),p2.getDistanciaEstrella());
        final Path path3 = generateCurvyPath(determinePathOpacity(),p3.getDistanciaEstrella());
        final Path path4 = generateCurvyPath(determinePathOpacity(),p4.getDistanciaEstrella());
        group.getChildren().add(path);
        group.getChildren().add(circle);
        group.getChildren().add(path2);
        group.getChildren().add(circle2);
        group.getChildren().add(path3);
        group.getChildren().add(circle3);
        group.getChildren().add(path4);
        group.getChildren().add(circle4);
        group.getChildren().add(new Circle(250,250,5));
        
        
       
        final PathTransition transition = generatePathTransition(circle, path,p1.getPeriode());
        final PathTransition transition2 = generatePathTransition(circle2, path2,p2.getPeriode());
        final PathTransition transition3 = generatePathTransition(circle3, path3,p3.getPeriode());
        final PathTransition transition4 = generatePathTransition(circle4, path4,p4.getPeriode());
        transition.play();
        transition2.play();
        transition3.play();
        transition4.play();
    }


    public SubScene crearSubscena() throws Exception {
        final Group rootGroup = new Group();
        final SubScene scene = new SubScene(rootGroup, 500 , 500, true,SceneAntialiasing.BALANCED);
        
        applyAnimation(rootGroup);
        return scene;
    }


}