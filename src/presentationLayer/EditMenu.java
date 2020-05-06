package presentationLayer;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.IMenuItem;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerialization;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Float.parseFloat;

public class EditMenu{


    private Restaurant restaurant;

    @FXML
    private Button edit;

    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private Button back;


    public void  getObject(Restaurant restaurant)
    {
        System.out.println(restaurant.toString());
        this.restaurant=restaurant;


    }

    @FXML
    public void handleButtonBackAction(MouseEvent event) {


        if (event.getSource() == back) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("administratorgraphicaluserinterface.fxml")));
                Parent root=loader.load();
                AdministratorGraphicalUserInterface controllerpag = loader.getController();
                System.out.println(this.restaurant.toString());
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
    public void handleButtonEditAction(MouseEvent event) {


        if (event.getSource() == edit) {


                String nameC=name.getText();
                Float priceC=parseFloat(price.getText());
               this.restaurant.editMenu_(nameC,priceC);




            }



        }


    }













