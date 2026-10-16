package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Game;
import model.exception.EmptyDeckException;

public class GameController extends Controller<Game> {

    @FXML
    private TextField weakenField;

    public  Game getGame() {
        return model;
    }

    @FXML 
    private void handleDeal() {
        try {
            getGame().deal();
        } catch (EmptyDeckException e) {
            // ToDo
            // Make a clean error display
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML 
    private void handleRestore(){
        try {
            getGame().restore();
        } catch (EmptyDeckException e) {
            // ToDo
            // Make a clean error display
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML 
    private void handleBattleHand(){
        //ToDo
        // open the battle window
    }

    @FXML 
    private void handleExit(){
        stage.close();
    }

}
