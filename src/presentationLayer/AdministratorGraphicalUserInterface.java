package presentationLayer;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerialization;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
public class AdministratorGraphicalUserInterface {
    private Restaurant restaurant;


    @FXML
    private Button addMenu;
    @FXML
    private Button editMenu;
    @FXML
    private Button deleteMenu;
    @FXML
    private Button viewMenu;
    @FXML
    private Button back;
    @FXML
    private Button viewOrders;

    public void  getObject(Restaurant restaurant)
    {

        this.restaurant=restaurant;

    }

    @FXML
    public void handleButtonaddMenuAction(MouseEvent event) {

        if (event.getSource() == addMenu) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(("addmenu.fxml")));
                Parent root = loader.load();
                MenuAdd controllerpag = loader.getController();
                controllerpag.getObject(this.restaurant);
                Scene scene = new Scene(root, 841, 658);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }

    @FXML
    public void handleButtoneditMenuAction(MouseEvent event) {

        if (event.getSource() == editMenu) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(("editmenu.fxml")));
                Parent root = loader.load();
                EditMenu controllerpag = loader.getController();
                controllerpag.getObject(this.restaurant);
                Scene scene = new Scene(root, 841, 658);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

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
    public void handleButtondeleteMenuAction(MouseEvent event) {

        if (event.getSource() == deleteMenu) {
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("deletemenu.fxml")));
                Parent root=loader.load();
               DeleteMenu controllerpag = loader.getController();
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
    public void handleButtonViewMenuAction(MouseEvent event) throws IOException {

        if (event.getSource() == viewMenu)
        {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("viewmenu.fxml")));
                Parent root=loader.load();
                ViewMenu controllerpag = loader.getController();
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
    public void handleButtonViewOrdersAction(MouseEvent event) throws IOException {

        if (event.getSource() == viewOrders)
        {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("vieworders.fxml")));
                Parent root=loader.load();
                ViewOrders controllerpag = loader.getController();
                controllerpag.getObject(this.restaurant);
                Scene scene=new Scene(root, 841, 658);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }


    }

    }









