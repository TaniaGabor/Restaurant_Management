package presentationLayer;

import businessLayer.IMenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewOrders {

    private Restaurant restaurant;

    @FXML
    private Button back;
    @FXML
    private Button viewOrders;
    @FXML
    private TableView<Order> tableView;
    @FXML
    private TableColumn<Order, Integer> orderid;
    @FXML
    private TableColumn<Order, Integer> tableno;
    @FXML
    private TableColumn<Order, String> date;



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


        if (event.getSource() == viewOrders)
        {

            List<Order> list1=new ArrayList<Order>();
            list1.addAll(this.restaurant.getRestaurantOrder().keySet());
            tableView.getItems().addAll(list1);
            orderid.setCellValueFactory(data->new SimpleIntegerProperty(data.getValue().getOrderID()).asObject());
            tableno.setCellValueFactory(data->new SimpleIntegerProperty(data.getValue().getTableNo()).asObject());
            date.setCellValueFactory(data->new SimpleStringProperty(data.getValue().getDateOrder()));

        }

    }



}









