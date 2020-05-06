package businessLayer;

import java.io.Serializable;

public class BaseProduct implements IMenuItem, Serializable {
    @Override
    public String toString() {
        return "BaseProduct{" +
                "nameBaseProduct='" + nameBaseProduct + '\'' +
                ", price=" + price +
                '}';
    }

    private String nameBaseProduct;
    private Float price;

    public BaseProduct(String nameBaseProduct,Float price)
    {
        this.nameBaseProduct=nameBaseProduct;
        this.price=price;
    }

    public String getNameBaseProduct() {
        return nameBaseProduct;
    }

    public void setNameBaseProduct(String nameBaseProduct) {
        this.nameBaseProduct = nameBaseProduct;
    }


    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public Float compositePrice_() {
        return price;
    }
}
