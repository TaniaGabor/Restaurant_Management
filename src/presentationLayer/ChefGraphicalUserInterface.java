package presentationLayer;

import businessLayer.Observer;
import businessLayer.Order;
import businessLayer.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
public class ChefGraphicalUserInterface implements Observer {


    private Restaurant restaurant;

    @FXML
    private Button back;
    @FXML
    private ListView orderList;
    @FXML
    private Label lblOrders;


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


    @Override
    public void update() {
        lblOrders.setText("New Order!");
        String ord=new String("You got a new order");
        this.orderList.getItems().add(ord);




    }
}









