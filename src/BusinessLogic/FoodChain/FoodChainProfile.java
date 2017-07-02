package BusinessLogic.FoodChain;

import BusinessLogic.Order.Order;
import java.util.ArrayList;

public class FoodChainProfile 
{
    public String fc_id;
    public String name;  
    public String area;
    public String city;
    public String delivery_time;
    public ArrayList<Order> order_hist = new ArrayList<>();
    public String logo;

    public FoodChainProfile() 
    {
        this.fc_id = "";
        this.name = "";
        this.area = "";
        this.city = "";
        this.delivery_time = "";
        this.logo = "";    
    }
    public void modifyFoodChain()
    {
        //Makes changes in the DB of the recorded food chain. 
    }

    
    
}
