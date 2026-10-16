package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Card;
import model.Deck;

public class DeckController extends Controller<Deck> {

    @FXML 
    private ListView<Card> cardsList;

    public Deck getDeck(){
        return model;
    }

    @FXML 
    private void handleViewCard(){
        Card selectedCard = cardsList.getSelectionModel().getSelectedItem();
        if(selectedCard != null){
            try{
                javafx.stage.Stage cardStage = new javafx.stage.Stage();
                au.edu.uts.ap.javafx.ViewLoader.showStage(selectedCard, "/view/CardView.fxml", selectedCard.toString().split(" ")[0], cardStage);
            } catch(Exception e){
                System.out.println("Error opening window: " + e.getMessage());
            }
        }
    }

    @FXML 
    private void handleShuffle(){
        getDeck().shuffle();
    }

    @FXML 
    private void handleClose(){
        stage.close();
    }

}
