package dataLayer;

import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

public class FileWriter {
    public void write(int orderId,String date, int tableNr,Float priceT) throws IOException {

        java.io.FileWriter fileWriter = new java.io.FileWriter("bill"+orderId+".txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("OrderId  " + orderId);
        printWriter.println("TableNo " + tableNr);
        printWriter.println("Data  " + date);
        printWriter.println("Total Price  " + priceT);
        printWriter.close();
    }
}
