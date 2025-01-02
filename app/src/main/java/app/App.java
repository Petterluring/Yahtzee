package app;

import com.frontend.die.DieGraphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        DieGraphics die = new DieGraphics(100.0, "WHITE", "BLACK");
        Scene scene = new Scene(die.getDie(), 500, 500,  Paint.valueOf("BLACK"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
