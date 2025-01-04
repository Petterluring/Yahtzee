package app;

import com.frontend.die.DieAnimation;
import com.frontend.die.DieDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        DieDisplay die = new DieDisplay(100.0, "WHITE", "BLACK");
        Scene scene = new Scene(die.getDie(), 500, 500,  Paint.valueOf("BLACK"));
        stage.setScene(scene);
        DieAnimation.dieRoll(5, 50.0, 12, die);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
