package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;

public class CardController extends Controller<Card>{

    @FXML 
    private ImageView cardImageView;
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

            try{
                String cardName = model.nameProperty() != null ? model.nameProperty().get() : model.toString();
                String imageName = cardName.toLowerCase().replaceAll("[^a-z0-9]", "") + ".png";
                String imagePath = "/view/image/cards/" + imageName;
                cardImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
            } catch (Exception e) {
                System.out.println("Can't find card image! " + e.getMessage());
            }
        }
    }

    @FXML 
    private void handleClose(){
        stage.close();
    }
}
