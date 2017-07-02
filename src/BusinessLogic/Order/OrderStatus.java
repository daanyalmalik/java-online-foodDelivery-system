package BusinessLogic.Order;

/**
 *
 * @author daany
 */
public class OrderStatus {
    
    public String OrderStatusID;
    public String description;
    
    OrderStatus(String id, String des)
    {
        this.OrderStatusID=id;
        this.description=des;
    }

    OrderStatus() {
    
    }
    
    public void setStatus(String status)
    {
        this.OrderStatusID=status;
    }
    
    public String getStatus()
    {
        return this.OrderStatusID;
    }
}
