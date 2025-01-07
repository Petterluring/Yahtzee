package app;

import com.frontend.scenes.welcome.Welcome;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {

        /* 
        StackPane root = new StackPane();

        // Create a scene with black background
        Scene scene = new Scene(root, 300, 200, Color.BLACK);

        stage.setTitle("Scene Background Example");
        stage.setScene(scene);
        stage.show();
        */
        Welcome welcomeScene = new Welcome(1000, 600);
        stage.setScene(welcomeScene.getScene());
        stage.show();
    }

        
        

    public static void main(String[] args) {
        launch(args);
    }
}
