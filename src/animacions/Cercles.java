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
    private Planeta p1 = new Planeta(11, 87, (int) (57 * 1.5));
    private Planeta p2 = new Planeta(22, 87, (int) (108 * 1.5));
    private Planeta p3 = new Planeta(36, 87, (int) (149 * 1.5));
    private Planeta p4 = new Planeta(68, 87, (int) (227 * 1.5));

    private Path generateCurvyPath(final double pathOpacity, int distance) {
        final Path path = new Path();

        final int x = 500;
        final int y = 400;
        Rectangle2D psb = Screen.getPrimary().getVisualBounds();
        double p = (psb.getWidth() / psb.getHeight());
        System.out.println(p);

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
        pathTransition.setDuration(Duration.seconds(periode/3));
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
        return 0.2;
    }

    /**
     * Apply animation, the subject of this class.
     *
     * @param group Group to which animation is applied.
     */
    private void applyAnimation(final Group group) {
        final Circle circle = new Circle(20, 20, 4, Color.ORANGE); //1
        final Circle circle2 = new Circle(10, 20, 7, Color.AQUAMARINE); //2
        final Circle circle3 = new Circle(20, 20, 12, Color.BLUE); //3
        final Circle circle4 = new Circle(10, 20, 6, Color.RED); //7

        ///
        Random r = new Random();
        int Low = 7;
        int High = 30;
        int Result = r.nextInt(High - Low) + Low;

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        double x = primaryScreenBounds.getMaxX();
        double y = primaryScreenBounds.getMaxY() + 300;

        for (int i = 0; i < y; i += r.nextInt(15 - 1) + 1) {
            for (int j = 0; j < x; j += r.nextInt(High - Low) + Low) {
                group.getChildren().add(new Circle(r.nextInt((j + 15) - j) + j, r.nextInt((i + 15) - i) + i, 0.35, Color.WHITE));
            }
        }

        ///
        final Path path = generateCurvyPath(determinePathOpacity(), p1.getDistanciaEstrella());
        final Path path2 = generateCurvyPath(determinePathOpacity(), p2.getDistanciaEstrella());
        final Path path3 = generateCurvyPath(determinePathOpacity(), p3.getDistanciaEstrella());
        final Path path4 = generateCurvyPath(determinePathOpacity(), p4.getDistanciaEstrella());
        group.getChildren().add(path);
        group.getChildren().add(circle);
        group.getChildren().add(path2);
        group.getChildren().add(circle2);
        group.getChildren().add(path3);
        group.getChildren().add(circle3);
        group.getChildren().add(path4);
        group.getChildren().add(circle4);
        group.getChildren().add(new Circle(500, 400, 40, Color.YELLOW));

        final PathTransition transition = generatePathTransition(circle, path, p1.getPeriode());
        final PathTransition transition2 = generatePathTransition(circle2, path2, p2.getPeriode());
        final PathTransition transition3 = generatePathTransition(circle3, path3, p3.getPeriode());
        final PathTransition transition4 = generatePathTransition(circle4, path4, p4.getPeriode());
        transition.play();
        transition2.play();
        transition3.play();
        transition4.play();
    }

    public SubScene crearSubscena(ReadOnlyDoubleProperty y, ReadOnlyDoubleProperty x) throws Exception {
        final Group rootGroup = new Group();
        final SubScene scene = new SubScene(rootGroup, 500, 500, true, SceneAntialiasing.BALANCED);
        scene.heightProperty().bind(y);
        scene.widthProperty().bind(x);
        scene.setFill(Color.BLACK);

        applyAnimation(rootGroup);
        return scene;
    }

}
