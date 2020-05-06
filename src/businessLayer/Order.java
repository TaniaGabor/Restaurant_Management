package businessLayer;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private int OrderID;
    private int tableNo;
    private String dateOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(OrderID, order.OrderID) &&
                Objects.equals(tableNo, order.tableNo) &&
                Objects.equals(dateOrder, order.dateOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OrderID, tableNo, dateOrder);
    }

    public Order(int OrderID, int tableNo, String dateOrder)
    {
        this.OrderID=OrderID;
        this.tableNo=tableNo;
        this.dateOrder=dateOrder;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }
}
