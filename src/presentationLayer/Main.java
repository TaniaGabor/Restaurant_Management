package presentationLayer;

import businessLayer.IMenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerialization;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{



        RestaurantSerialization serialization=new RestaurantSerialization();
        Restaurant restaurant=serialization.deserialize("restaurant.ser");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(("sample.fxml")));
        Parent root=loader.load();
        Controller controllerpag = loader.getController();
        controllerpag.getObject(restaurant);

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource(("chefgraphicaluserinterface.fxml")));
        Parent root1=loader1.load();
       ChefGraphicalUserInterface controllerpag1 = loader1.getController();
        controllerpag1.getObject(restaurant);
        restaurant.addObserver(controllerpag1);
        Stage stage1=new Stage();
         stage1.setScene(new Scene(root1, 841, 658));
         stage1.show();
        primaryStage.setTitle("Restaurant");
        primaryStage.setScene(new Scene(root, 841, 658));
        primaryStage.show();
    }

    public static void main(String[] args) {
      launch(args);
    }
}
