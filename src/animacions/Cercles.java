package animacions;

import java.util.List;

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
    private Path generateCurvyPath(final double pathOpacity) {
        final Path path = new Path();
        path.getElements().add(new MoveTo(380, 120));
        for (int i = 0; i < 10; i++) {
            path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
            path.getElements().add(new CubicCurveTo(760, 240, 760, 120, 380, 120));   
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
    private PathTransition generatePathTransition(final Shape shape, final Path path) {
        final PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(50.0));
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
        circle.setFill(Color.DARKRED);
        final Path path = generateCurvyPath(determinePathOpacity());
        group.getChildren().add(path);
        group.getChildren().add(circle);
        group.getChildren().add(new Circle(20, 20, 5));
        group.getChildren().add(new Circle(380, 240, 5));
        Circle prova = new Circle(30, 30, 30);
        prova.setFill(Color.TRANSPARENT);
        prova.setStroke(Color.RED);
        group.getChildren().add(prova);
        final PathTransition transition = generatePathTransition(circle, path);
        transition.play();
    }


    public SubScene crearSubscena() throws Exception {
        final Group rootGroup = new Group();
        final SubScene scene = new SubScene(rootGroup, 800, 500, true,SceneAntialiasing.BALANCED);
        
        applyAnimation(rootGroup);
        return scene;
    }


}