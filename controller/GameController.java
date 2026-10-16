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
        System.out.println("deal button pressed");
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
        System.out.println("battlehand button pressed");
    }

    @FXML 
    private void handleWeaken(){
        //ToDo
        //Weaken amount
        // clear weaken field
        // chose weaken text
        System.out.println("weaken button pressed");
    }

    @FXML 
    private void handleExit(){
        System.out.println("Quitting Game :(");
        stage.close();
    }

}
