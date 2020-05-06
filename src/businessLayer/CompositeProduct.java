package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct implements IMenuItem , Serializable {

    private String nameCompositeProduct;
    private Float price;
    private List<IMenuItem> menuComposite=new ArrayList<IMenuItem>();
    public CompositeProduct(String nameCompositeProduct,Float price,List<IMenuItem> menuComposite)
    {
        this.nameCompositeProduct=nameCompositeProduct;
        this.price=price;
        this.menuComposite=menuComposite;

    }

    public String getNameCompositeProduct() {
        return nameCompositeProduct;
    }

    public void setNameCompositeProduct(String nameCompositeProduct) {
        this.nameCompositeProduct = nameCompositeProduct;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CompositeProduct{" +
                "nameCompositeProduct='" + nameCompositeProduct + '\'' +
                ", price=" + price +
                ", menuComposite=" + menuComposite +
                '}';
    }

    public List<IMenuItem> getMenuComposite() {
        return menuComposite;
    }

    public void setMenuComposite(List<IMenuItem> menuComposite) {
        this.menuComposite = menuComposite;
    }
    public void addItem(IMenuItem item)
    {
        menuComposite.add(item);
    }
    public void removeItem(IMenuItem item)
    {
        menuComposite.remove(item);
        this.compositePrice_();

    }
    @Override
    public Float compositePrice_() {
        this.price=0.f;
     for(IMenuItem a:this.menuComposite)
     {
       if(a instanceof BaseProduct)
       {
           this.price+=a.compositePrice_();
       }
     }
        return this.price;
    }
}
