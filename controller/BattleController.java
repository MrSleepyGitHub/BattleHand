package controller;
import  model.BattleHand;
import au.edu.uts.ap.javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Card;
import model.AttackType;

public class BattleController extends Controller<BattleHand> {
    
    @FXML
    private ListView<Card> cardsList;

    public BattleHand gBattleHand() {
        return model;
    }

    @FXML
    public  void initialize(){
        cardsList.setCellFactory(param -> new javafx.scene.control.ListCell<Card>() {
            @Override
            protected void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);
                if (empty || card == null) {
                    int index = getIndex();
                    String typeName = AttackType.nameFromSlot(index);
                    setText(typeName + ": Empty");
                } else {
                    setText(card.toString());
                }
            }
        });
    }

    @FXML
    private void handleClose() {
        stage.close();
    }

    
}
