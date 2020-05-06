package presentationLayer;

import businessLayer.IMenuItem;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerialization;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
public class Controller {

   private Restaurant restaurant;
    private RestaurantSerialization serialization = new RestaurantSerialization();
    @FXML
    private Button done;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label lblErrors;
    @FXML
    private Button finishedaction;

      public void  getObject(Restaurant restaurant)
      {
          this.restaurant=restaurant;


      }

    @FXML
    public void handleButtonfinishedActionMenuAction(MouseEvent event) {

        if (event.getSource() == finishedaction) {


          this.serialization.serialize(this.restaurant,"restaurant.ser");


        }

    }
    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == done) {
            if (logIn().equals("administrator")) {
                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource(("administratorgraphicaluserinterface.fxml")));
                    Parent root = loader.load();
                    AdministratorGraphicalUserInterface controllerpag = loader.getController();
                    controllerpag.getObject(this.restaurant);
                    Scene scene = new Scene(root, 841, 658);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }


            }
            else if (logIn().equals("chef")) {
                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource(("chefgraphicaluserinterface.fxml")));
                    Parent root = loader.load();
                    ChefGraphicalUserInterface controllerpag = loader.getController();
                    controllerpag.getObject(this.restaurant);
                    Scene scene = new Scene(root, 841, 658);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
           else if (logIn().equals("waiter")) {
                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource(("waitergraphicaluserinterface.fxml")));
                    Parent root = loader.load();
                   WaiterGraphicalUserInterface controllerpag = loader.getController();
                    controllerpag.getObject(this.restaurant);
                    Scene scene = new Scene(root, 800, 658);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }

            else if(logIn().equals("noSuccess"))
            {
             lblErrors.setText("Username or Password incorrect");
            }
        }
    }

        private String logIn() {

            String userName = username.getText();
            String passWord = password.getText();
            if (userName.isEmpty() || passWord.isEmpty()) {
                lblErrors.setText("You must fill all the fields");
                return "Error";
            } else {
                if (userName.equals("administrator") && passWord.equals("administrator")) {
                    return "administrator";
                } else if (userName.equals("chef") && passWord.equals("chef")) {
                    return "chef";
                } else if (userName.equals("waiter") && passWord.equals("waiter")) {
                    return "waiter";
                } else return "noSuccess";

            }
        }
}



