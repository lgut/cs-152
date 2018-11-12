
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

/**
 * Write a description of JavaFX class HelloJavaFX here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HelloJavaFX extends Application
{   
    public void start(Stage primaryStage)
    {
        Circle c1, c2, c3;
        c1 = new Circle(100,100,100);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.RED);
        c1.setStrokeWidth(5);
        
        c2 = new Circle(300,100,100);
        c3 = new Circle(500,100,100);
        Group root = new Group(c1,c2,c3);
        Scene scene = new Scene(root, 600,200, Color.LIGHTBLUE);
        primaryStage.setTitle("Three Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

