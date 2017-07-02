package BusinessLogic.User;
import BusinessLogic.Order.Order;
import DataAccess.ORMapper;
import java.util.ArrayList;


public class Customer extends User
{
        private static Customer instance = new Customer();
	public String address;
	public String CustID;
	public String email;
	public String firstname;
	public String lastname;
        public String pic="pic1.png";
	public ArrayList<Order> orderHistory = new ArrayList<>();
        private Customer()
        {
            
        }
        public static Customer getInstance()
        {
            return instance;
        }
	public void newCustomer(String firstname, String lastname, String email, String address)
        {
            ORMapper.getInstance().setCustomer(firstname, lastname, email, address);
        }
	public void OpensOrderHistory()
	{
		
	}
	public Order SelectsOrder(int orderID)
	{
            Order or = new Order();
            return or;
	}
	
}
