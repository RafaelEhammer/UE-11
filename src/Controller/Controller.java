package Controller;

import Model.CarDatabase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable
{
    private Stage stage;


    @FXML
    private TextField TextField;
    @FXML
    private TextArea TextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("MainFXML.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            Controller ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle("Welcome");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (IOException ex)
        {

        }
    }
}
