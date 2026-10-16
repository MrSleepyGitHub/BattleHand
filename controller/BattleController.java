package controller;
import  model.BattleHand;
import au.edu.uts.ap.javafx.*;
import javafx.fxml.FXML;
import java.util.ResourceBundle.Control;

public class BattleController extends Controller<BattleHand> {
    public BattleHand gBattleHand() {
        return model;
    }

    @FXML
    private void handleClose() {
        stage.close();
    }

    
}
