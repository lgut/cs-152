
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class Lines here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lines extends Application
{
    private final int SIZE = 500;
    private final int DIST = 20;
    
    public void hLines(int y, Group group)
    {
        Line line;
        for (int i = y; i < SIZE; i+=DIST)
        {
            line = new Line(DIST, i, SIZE - DIST, i);
            line.setStrokeWidth(5);
            line.setStroke(Color.BLACK);
            group.getChildren().add(line);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception
    {
        Group root = new Group();
        hlines(0, root);
        Scene scene = new Scene(root, SIZE, SIZE, Color.LIGHTBLUE);
        stage.setTitle("Fuck");
        stage.setScene(scene);
        stage.show();
    }
    
}