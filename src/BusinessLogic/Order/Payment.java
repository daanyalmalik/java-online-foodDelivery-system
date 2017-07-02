package BusinessLogic.Order;

import BusinessLogic.Controller.Controller;
import BusinessLogic.User.Customer;
import java.util.Date;

/**
 *
 * @author daany
 */
public class Payment {
    
    public String amount;
    public String cust_id;
    public String payment_date;
    public String paymentID;
    public PaymentType p_type;
    
    
    public Payment()
    {
        
    }
    
    
    public void ChoosePaymentMethod(String type)
    {
        
        cust_id = Customer.getInstance().CustID;
        amount =  Controller.the_Order.totalPrice;
        Date d = new Date();
        payment_date = d.toString();
        
        this.p_type.description = type;
        if (type.equals("Cash"))
        {
            System.out.println("IN cas");
            this.p_type.PaymentID = "1";
        }
        else if (type.equals("Credit/Debit"))
        {
            System.out.println("IN cre");
            this.p_type.PaymentID = "2";
        }
    }
    

    
}
