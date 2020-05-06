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
import java.util.ListIterator;

import static java.lang.Float.parseFloat;

public class DeleteMenu {


    private Restaurant restaurant;
    private RestaurantSerialization serialization;
    @FXML
    private Button delete;
    @FXML
    private TextField searchname;
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
    public void handleButtonDeleteAction(MouseEvent event) {

        int ok=0;
        int i=-1;
        if (event.getSource() ==delete)
        {

            String nameC=searchname.getText();
            this.restaurant.deleteMenu_(nameC);
           /* Iterator<IMenuItem> itr=this.restaurant.getAllmenuItems().iterator();
            while(itr.hasNext()) {
                IMenuItem item = itr.next();
                if (item instanceof CompositeProduct)
                    if (((CompositeProduct) item).getNameCompositeProduct().equals(nameC)) {
                        itr.remove();

                    }
                if (item instanceof BaseProduct) {
                    if (((BaseProduct) item).getNameBaseProduct().equals(nameC))
                        itr.remove();
                }
            }

                    Iterator<IMenuItem> itr1=this.restaurant.getAllmenuItems().iterator();
                      while(itr1.hasNext())
                      {
                          IMenuItem item1 =itr1.next();
                          if(item1 instanceof CompositeProduct)
                          {
                              Iterator<IMenuItem> itr2=((CompositeProduct) item1).getMenuComposite().iterator();
                              while(itr2.hasNext())
                              {
                                  IMenuItem item2=itr2.next();
                                  if(item2 instanceof  BaseProduct)
                                  {
                                      if(((BaseProduct) item2).getNameBaseProduct().equals(nameC))
                                      {
                                          itr1.remove();
                                      }
                                  }
                              }

                          }

              }*/

            }



        }
    }











