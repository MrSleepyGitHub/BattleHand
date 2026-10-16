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
    private void handleShuffle(){
        getDeck().shuffle();
    }

    @FXML 
    private void handleClose(){
        stage.close();
    }

}
