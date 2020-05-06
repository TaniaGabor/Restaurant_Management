package presentationLayer;

import businessLayer.IMenuItem;
import businessLayer.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
public class ViewMenu {

    private Restaurant restaurant;

    @FXML
    private Button back;
    @FXML
    private Button viewMenu;
    @FXML
    private ListView menuList;

    public void  getObject(Restaurant restaurant)
    {
        this.restaurant=restaurant;


    }
    @FXML
    public void handleButtonBackAction(MouseEvent event) {


        if (event.getSource() == back) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("sample.fxml")));
                Parent root=loader.load();
                Controller controllerpag = loader.getController();
                controllerpag.getObject(this.restaurant);
                Scene scene=new Scene(root, 841, 658);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonviewAction(MouseEvent event) {


        if (event.getSource() == viewMenu)
        {

        menuList.getItems().addAll(this.restaurant.getAllmenuItems());

        }

    }



}









