package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.BattleHand;
import model.Card;
import model.Player;
import model.exception.BattleException;
import model.exception.FullHandException;
// clean up the imports later, idk why it's breaking

public class PlayerController extends Controller<Player>{
    @FXML
    private TableView<Card> cardsTable;
    @FXML
    private TableColumn<Card, String> nameColumn;
    @FXML
    private TableColumn<Card, String> typeColumn;
    @FXML
    private TableColumn<Card, Number> strengthColumn;

    public Player getPlayer() {
        return model;
    }

    @FXML 
    public void initialize(){
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        typeColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getType().name()));
        strengthColumn.setCellValueFactory(cellData -> cellData.getValue().strengthProperty());

        cardsTable.setItems(getPlayer().getHand().getCards());
    }

    @FXML
    private void handleDiscard(){
        Card selected = cardsTable.getSelectionModel().getSelectedItem();
        if (selected != null){
            getPlayer().discard(selected);
        }
    }

    @FXML
    private void handlePlace(){
        Card selected = cardsTable.getSelectionModel().getSelectedItem();
        if (selected != null){
            try{
                getPlayer().battle(selected);
            } catch (BattleException | FullHandException e) {
                System.out.println("Card error:" + e.getMessage());
            }
        }
    }

}
