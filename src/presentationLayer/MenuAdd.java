package presentationLayer;

import businessLayer.BaseProduct;
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

import static java.lang.Float.parseFloat;

public class MenuAdd {


    private Restaurant restaurant;
    private RestaurantSerialization serialization;
    @FXML
    private Button composite;
    @FXML
    private Button base;
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
    public void handleButtonCompositeAction(MouseEvent event) {




        if (event.getSource() == composite) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("addcomposite.fxml")));
                Parent root=loader.load();
               AddComposite controllerpag = loader.getController();
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
    public void handleButtonBaseAction(MouseEvent event) {


        if (event.getSource() == base) {

            String nameC=name.getText();
            Float priceC=parseFloat(price.getText());
            BaseProduct product=new BaseProduct(nameC,priceC);
            this.restaurant.addMenu_(product);
            for(IMenuItem menu:this.restaurant.getAllmenuItems())
            {
                System.out.println(menu.toString());
            }
        }

    }



}









