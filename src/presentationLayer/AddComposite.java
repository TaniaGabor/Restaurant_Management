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

public class AddComposite {


    private Restaurant restaurant;
    private RestaurantSerialization serialization;
    @FXML
    private Button addcomp;


    @FXML
    private TextField nametoadd;
    @FXML
    private TextField pricetoadd;
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
                loader.setLocation(getClass().getResource(("addmenu.fxml")));
                Parent root=loader.load();
                MenuAdd controllerpag = loader.getController();
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

        int ok=0;
        int i=-1;
        if (event.getSource() == addcomp) {
            List<IMenuItem> thingstoAdd=new ArrayList<>();
            String nameC=searchname.getText();
            String nameAdd=nametoadd.getText();
            Float priceC=parseFloat(pricetoadd.getText());
            if(this.restaurant.getAllmenuItems().isEmpty()==false) {
                for (IMenuItem themenu : this.restaurant.getAllmenuItems()) {
                    if (themenu instanceof CompositeProduct) {
                        if (((CompositeProduct) themenu).getNameCompositeProduct().equals(nameC)) {
                            ok = 1;
                            i = this.restaurant.getAllmenuItems().indexOf(themenu);
                            thingstoAdd.add(new BaseProduct(nameAdd, priceC));


                        }
                    }

                }
                if (i > 0) {
                    if (this.restaurant.getAllmenuItems().get(i) instanceof CompositeProduct) {
                        ((CompositeProduct) this.restaurant.getAllmenuItems().get(i)).getMenuComposite().addAll(thingstoAdd);
                        ((CompositeProduct) this.restaurant.getAllmenuItems().get(i)).setPrice(this.restaurant.getAllmenuItems().get(i).compositePrice_());
                    }
                    this.restaurant.getAllmenuItems().addAll(thingstoAdd);

                }
            }

            if(ok==0)
            {
                List<IMenuItem> newList=new ArrayList<IMenuItem>();
               CompositeProduct comp=new CompositeProduct(nameC,0f,newList);
               BaseProduct baseP=new BaseProduct(nameAdd,priceC);
               comp.getMenuComposite().add(baseP);
                comp.setPrice(comp.compositePrice_());
               this.restaurant.getAllmenuItems().add(comp);
               this.restaurant.getAllmenuItems().add(baseP);

            }




        }
    }




}









