package presentationLayer;

import businessLayer.*;
import dataLayer.FileWriter;
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
import java.util.List;
import static java.lang.Integer.parseInt;

public class WaiterGraphicalUserInterface {
    private Restaurant restaurant;

   List<IMenuItem> tempList=new ArrayList<>();
   FileWriter f;
   private Float priceT=0f;

    @FXML
    private TextField menu;
    @FXML
    private TextField totalprice;
    @FXML
    private TextField tableno1;
    @FXML
    private TextField data1;
    @FXML
    private TextField orderid1;
    @FXML
    private TextField orderid;
    @FXML
    private TextField tableno;
    @FXML
    private TextField data;
    @FXML
    private Button createOrder;
    @FXML
    private Button addMenu;
    @FXML
    private Button computePrice;
    @FXML
    private Button generateBill;
    @FXML
    private Button back;
    @FXML
    private Button viewOrders;
    @FXML
    private Button viewMenu;





    public void  getObject(Restaurant restaurant)
    {
        this.restaurant=restaurant;


    }

    @FXML
    public void handleButtonaddMenuOrderAction(MouseEvent event) {

        if (event.getSource() == addMenu) {
            System.out.println(this.restaurant.getAllmenuItems().toString());
            int ok=0;
            String Menu=menu.getText();
            IMenuItem b=null;
            for(IMenuItem a:this.restaurant.getAllmenuItems())
            {
                if(a instanceof CompositeProduct)
                    if(((CompositeProduct) a).getNameCompositeProduct().equals(Menu))
                    {
                        ok=1;
                       b=new CompositeProduct(((CompositeProduct) a).getNameCompositeProduct(),((CompositeProduct) a).getPrice(),((CompositeProduct) a).getMenuComposite());
                    }
                if(a instanceof BaseProduct)
                {
                    if(((BaseProduct) a).getNameBaseProduct().equals(Menu))
                    {
                        ok=1;
                         b=new BaseProduct(((BaseProduct) a).getNameBaseProduct(),a.compositePrice_());
                    }
                }
            }
            if(ok==1)
            {
               this.tempList.add(b);
            }
            else {
                System.out.println("nu exista");
            }

        }
    }

    @FXML
    public void handleButtoncreateOrderAction(MouseEvent event) {

        if (event.getSource() == createOrder) {

            int orderId=parseInt(orderid.getText());
            String date=data.getText();
            int tableNr=parseInt(tableno.getText());
            Order b=new Order(orderId,tableNr,date);
            this.restaurant.notifyObservers();
            this.restaurant.getRestaurantOrder().put(b,new ArrayList<>(tempList));
            System.out.println(this.restaurant.getRestaurantOrder().toString());
            this.tempList.clear();

        }
    }



        @FXML
    public void handleButtoncomputePriceAction(MouseEvent event) {

        if (event.getSource() == computePrice) {
            int orderId=parseInt(orderid1.getText());
            int ok=0;
            String date=data1.getText();
            int tableNr=parseInt(tableno1.getText());
            Order b =new Order(orderId,tableNr,date);
            if(this.restaurant.getRestaurantOrder().isEmpty()==false) {
                if (this.restaurant.getRestaurantOrder().get(b) !=null) {
                for (IMenuItem a : this.restaurant.getRestaurantOrder().get(b)) {
                        if (a instanceof CompositeProduct) {
                            ok = 1;
                            System.out.println(((CompositeProduct) a).getPrice());
                            priceT = ((CompositeProduct) a).getPrice() + priceT;
                        }
                        if (a instanceof BaseProduct) {
                            ok = 1;
                            priceT = a.compositePrice_() + priceT;
                        }
                    }
                }
            }
           if(ok==1)
           totalprice.setText(priceT.toString());
           else totalprice.setText("The order doesnt exist");
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
    public void handleButtongenerateBillMenuAction(MouseEvent event) throws IOException {

        if (event.getSource() == generateBill) {

            int orderId=parseInt(orderid1.getText());
            String date=data1.getText();
            int tableNr=parseInt(tableno1.getText());
            f=new FileWriter();
            f.write(orderId,date,tableNr,priceT);

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







