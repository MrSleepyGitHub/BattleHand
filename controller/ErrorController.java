package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorController extends Controller<Exception>{
    @FXML
    private Label exceptionLabel;
    @FXML 
    private Label messageLabel;

    @FXML
    public void initialize(){
        if(model != null){
            exceptionLabel.setText(model.getClass().getSimpleName());
            messageLabel.setText(model.getMessage());
        }
    }

    @FXML 
    private void handleClose(){
        stage.close();
    }
}
