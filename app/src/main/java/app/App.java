package app;

import com.frontend.scenes.Welcome;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        Welcome welcome = new Welcome(500, 500);
        stage.setScene(welcome.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
