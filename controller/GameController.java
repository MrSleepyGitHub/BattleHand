package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Game;
import model.exception.EmptyDeckException;

public class GameController extends Controller<Game> {

    /////////////////////////////////////////////////////
    // MAIN WINDOW
    ////

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
            try{
                javafx.stage.Stage errorStage = new javafx.stage.Stage();
                au.edu.uts.ap.javafx.ViewLoader.showStage(e, "/view/ErrorView.fxml", "Error", errorStage);
            } catch (Exception e2){ 
                // error with the error window(it was this or a switch case)
                System.out.println("Error: " + e2.getMessage());
            }
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
        try{
            javafx.stage.Stage battleStage = new javafx.stage.Stage();
            au.edu.uts.ap.javafx.ViewLoader.showStage(getGame().getBattleHand(), "/view/BattleView.fxml", "Battle Hand", battleStage);
        } catch (Exception e) {
            try{
                javafx.stage.Stage errorStage = new javafx.stage.Stage();
                au.edu.uts.ap.javafx.ViewLoader.showStage(e, "/view/ErrorView.fxml", "Error", errorStage);
            } catch (Exception e2){ 
                // error with the error window(it was this or a switch case)
                System.out.println("Error: " + e2.getMessage());
            }
            System.out.println("Error opening window: " +e.getMessage());
        }
        System.out.println("battlehand button pressed");
    }

    @FXML 
    private void handleWeaken(){
        try{
            int amount = Integer.parseInt(weakenField.getText());
            getGame().weaken(amount);
            weakenField.clear();
        } catch (NumberFormatException e) {
            System.out.println("Invalid weaken value!");
        }
        System.out.println("weaken button pressed");
    }

    @FXML 
    private void handleExit(){
        System.out.println("Quitting Game :(");
        stage.close();
    }

    /////////////////////////////////////////////////////
    // PLAYER WINDOWS
    ////

    @FXML 
    private void handlePlayer1(){
        openPlayerView(0, "Player 1");
    }
    @FXML 
    private void handlePlayer2(){
        openPlayerView(0, "Player 2");
    }
    @FXML 
    private void handlePlayer3(){
        openPlayerView(0, "Player 3");
    }

    private  void openPlayerView(int playerIndex, String title){
        try{
            javafx.stage.Stage playerStage = new javafx.stage.Stage();
            model.Player player = getGame().getPlayers()[playerIndex];
            au.edu.uts.ap.javafx.ViewLoader.showStage(player, "/view/PlayerView.fxml", title, playerStage);
        } catch(Exception e){
            System.out.println("Error opening window for " + title + ": " +e.getMessage());
        }
    }

    /////////////////////////////////////////////////////
    // DECK WINDOW
    ////
    
    @FXML 
    private void handleMainDeck(){
        openDeckView(getGame().getMainDeck(), "Main Deck");
    }

    @FXML 
    private void handleSpecialDeck(){
        openDeckView(getGame().getMainDeck(), "Special Deck");
    }

    @FXML 
    private void handleDiscardPile(){
        openDeckView(getGame().getMainDeck(), "Discard Pile");
    }

    private void  openDeckView(model.Deck deck, String title){
        try{
            javafx.stage.Stage deckStage = new javafx.stage.Stage();
            au.edu.uts.ap.javafx.ViewLoader.showStage(deck, "/view/DeckView.fxml", title, deckStage);
        } catch(Exception e){
            System.out.println("Error opening window for " + title + ": " +e.getMessage());
        }
    }

}
