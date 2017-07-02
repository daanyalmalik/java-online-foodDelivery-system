
package BusinessLogic.Order;


import BusinessLogic.Controller.Controller;
import BusinessLogic.FoodChain.Location;
import BusinessLogic.FoodChain.Menu;
import BusinessLogic.User.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author daany
 */
public class Order {
    
    public String cust_id;
    public static String order_id = "9";
    public String order_date;
    public String address;
    public ArrayList<OrderLineItem> itemList = new ArrayList<>();
    public OrderStatus status = new OrderStatus();
    public String totalPrice;
    
    
    public Order()
    {
        
    }
    
    public String addFoodItems(String item)
    {
        String amount = null;
        for (int i=0; i<Menu.getInstance().FoodItemList.size(); i++)
        {
            if (Menu.getInstance().FoodItemList.get(i).name.equals(item))
            {
                OrderLineItem OLI = new OrderLineItem();
                OLI.foodID = Menu.getInstance().FoodItemList.get(i).foodID;
                int num = Integer.parseInt(OLI.foodID);
                num++;
                OLI.id = Integer.toString(num);
                OLI.price = Menu.getInstance().FoodItemList.get(i).price; 
                amount = OLI.price;
                OLI.quantity = Menu.getInstance().FoodItemList.get(i).price;
                itemList.add(OLI);
            }
        }
        return amount;
    }
    
    public void changeOrder()
    {

    }

    
    public String getOrderStatus()
    {
        return this.status.getStatus();
    }
    
    public void placeOrder(String name)
    {
        Controller.DB_OR.getMenu(name);
        Controller.the_Order.cust_id = Customer.getInstance().CustID;
    }

    
}
