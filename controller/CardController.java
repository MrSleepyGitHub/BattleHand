package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Card;

public class CardController extends Controller<Card>{

    @FXML
    private Label strengthLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label typeLabel;

    public Card getCard(){
        return model;
    }

    @FXML
    public void initialize(){
        if(model != null) {
            strengthLabel.setText(String.valueOf(model.getStrength()));
            nameLabel.setText(model.toString());
            typeLabel.setText("Type: " + model.getType().name());
        }
    }

    @FXML 
    private void handleClose(){
        stage.close();
    }
}
