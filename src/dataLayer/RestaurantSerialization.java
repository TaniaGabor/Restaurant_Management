package dataLayer;


import businessLayer.Restaurant;

import java.io.*;
import java.util.ArrayList;


public class RestaurantSerialization implements Serializable {

   public RestaurantSerialization()
   {

   }
   public void serialize(Restaurant restaurant,String serfile)
   {

        try {
             FileOutputStream fileOut =new FileOutputStream(serfile);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);
             out.writeObject(restaurant);
             out.close();
             fileOut.close();
        } catch (IOException i) {
             i.printStackTrace();
        }
   }
    public Restaurant deserialize(String serfile)
    {
        Restaurant restaurant = null;
        try {
            FileInputStream fileIn = new FileInputStream(serfile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            restaurant = (Restaurant) in.readObject();
            restaurant.setObserverList(new ArrayList<>());
            in.close();
            fileIn.close();
        }
        catch (FileNotFoundException e)
        {
       restaurant=new Restaurant();
        }catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Restaurant class not found");
            c.printStackTrace();

        }
        return restaurant;
    }


}
