package Controller;

import Model.CarDatabase;
import Model.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    private CarDatabase db = new CarDatabase();

    @FXML
    private TextField textfield;
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.db.db();
    }
    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Welcome");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception ex)
        {
            System.out.println("Error occured!");
        }
    }
    public void QuickSearch ()
    {
        if (!textfield.getText().equals("")) {
            long ST = System.nanoTime();
            textArea.setText("");
            ArrayList<Vehicle> l = db.QuickSearch(textfield.getText());
            for (Vehicle vehicle : l) {
                textArea.appendText(vehicle.toString() + "\n\n");
            }
            long ET = System.nanoTime();
            System.out.println("Search took: " + ((ET - ST) / 1000000) + "ms");
        }
        else{
            System.out.println("No License Plate found");
        }
    }
    public void Search ()
    {
        long ST = System.nanoTime();
        try{
            textArea.setText(db.Search(textfield.getText()).toString());
        }catch (NullPointerException ex){
            System.out.println("No License Plate found");
        }
        long ET = System.nanoTime();
        System.out.println("Search took: " + ((ET-ST) / 1000000) + "ms");
    }
}
