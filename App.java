import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;

import java.util.Random;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Random random = new Random();
        ViewLoader.showStage(new Game(random), "/view/GameView.fxml", "Dashboard", stage);
    }
}
