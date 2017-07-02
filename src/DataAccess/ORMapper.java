
package DataAccess;
import BusinessLogic.FoodChain.ListofFoodChains;
import BusinessLogic.FoodChain.FoodItem;
import BusinessLogic.FoodChain.ListofFoodItems;
import BusinessLogic.FoodChain.Menu;
import BusinessLogic.FoodChain.FoodChainProfile;
import BusinessLogic.Controller.Controller;
import BusinessLogic.User.FoodChainAdmin;
import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderLineItem;
import BusinessLogic.User.Customer;
import BusinessLogic.User.SystemAdministrator;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ORMapper 
{
    int RETURN_ANS = 0;
    private static String USERNAME = "root";
    private static String PASSWORD = "danimlk456";
    private static String SERVER_NAME = "localhost";
    private static int PORT_NUMBER = 3306;
    private static String DB_NAME = "pos";
    protected static Statement smt = null;
    protected static Statement smt2 = null;
    protected static Statement smt3 = null;
    protected static Connection con;
    protected static Connection con2;
    protected static Connection con3;
    protected ResultSet rs11 = null;
    protected ResultSet rs12 = null;
    private static ORMapper instance = new ORMapper();
    private ORMapper()
    {
        
    }
    public static ORMapper getInstance()
    {
        return instance;
    }
    public ResultSet getCustomers(String id)
    {
        String query= "SELECT * FROM customer where cust_id='" + id+ "'";
        String loginchk = null;
        System.out.println(query);
        try 
        {
            con2 = null;
            Properties connectionProps2 = new Properties();
            connectionProps2.put("user",USERNAME);
            connectionProps2.put("password", PASSWORD);
            con2 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps2);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con2);
            smt2 = con2.createStatement();
            rs11 = smt2.executeQuery(query);

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return rs11;
    }
    
    public void getMenu(String id)
    {
        String query= "SELECT * FROM menu where foodchain='" + id+ "'";
        String loginchk = null;
        System.out.println(query);
         Menu obj = Menu.getInstance();
        try 
        {
            con2 = null;
            Properties connectionProps2 = new Properties();
            connectionProps2.put("user",USERNAME);
            connectionProps2.put("password", PASSWORD);
            con2 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps2);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con2);
            smt2 = con2.createStatement();
            rs11 = smt2.executeQuery(query);
          
            while (rs11.next())
            {
                Menu.getInstance().menu_id = rs11.getString("menu_id");
                Menu.getInstance().description = rs11.getString("description");
                Menu.getInstance().food_chain = rs11.getString("foodchain");
                String temp = rs11.getString("food_item_ids");
                StringTokenizer st1 = new StringTokenizer(temp);
                while(st1.hasMoreTokens())
                {
                    String temp2 = st1.nextToken(";");
                    FoodItem fd = new FoodItem();
                    int i;
                    Controller.DB_FoodItems.UpdateFood();
                    for (i=0; i<Controller.DB_FoodItems.FoodItemList.size(); i++)
                    {
                        if(Controller.DB_FoodItems.FoodItemList.get(i).foodID.equals(temp2) )
                        {
                            
                            obj.FoodItemList.add(Controller.DB_FoodItems.FoodItemList.get(i));
                        }
                    }
                }
                
            }
            con2.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    public void setRegisteration(String v0, String v1, String v2, String v3, String v4, String v5, String v6,String v7)
    {
        String query= "INSERT INTO registrations VALUES ('" + v0 + "','" + v1+ "','" + v2 + "','" + v3 + "','" + v4 + "','" + v5+ "','"+ v6 + "','" + v7 + "','" +"false" +"')";
        System.out.println(query);
        String loginchk = null;
        System.out.println(query);
         Menu obj = Menu.getInstance();
        try 
        {
            con2 = null;
            Properties connectionProps2 = new Properties();
            connectionProps2.put("user",USERNAME);
            connectionProps2.put("password", PASSWORD);
            con2 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps2);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con2);
            smt2 = con2.createStatement();
            smt2.executeUpdate(query);
            Customer.getInstance().newCustomer(v1, v2, v3, v7);
            con2.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    public void setCustomer(String v0, String v1, String v2, String v3)
    {
        //String query= "INSERT INTO customer VALUES ('1','" + v0 + "','" + v1+ "','" + v2 + "','" + v3  + "','" +"')";
        String query= "INSERT INTO customer VALUES ('1','" + v0 + "','" + v1 + "','" + v2 + "','"+ "" + "','" + v3 + "','" + "" + "')";
        
        System.out.println(query);
        String loginchk = null;
        System.out.println(query);
         Menu obj = Menu.getInstance();
        try 
        {
            con2 = null;
            Properties connectionProps2 = new Properties();
            connectionProps2.put("user",USERNAME);
            connectionProps2.put("password", PASSWORD);
            con2 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps2);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con2);
            smt2 = con2.createStatement();
            smt2.executeUpdate(query);
            con2.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    public ResultSet getSystemAdministrators(String id)
    {
        String query= "SELECT * FROM system_admin where id='" + id+ "'";
        String loginchk = null;
        System.out.println(query);
        ResultSet rs = null;
        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con);
            smt = con.createStatement();
            rs = smt.executeQuery(query);
            con.close();

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return rs;
    }
        public ResultSet getFoodChainAdmins(String id)
    {
        String query= "SELECT * FROM fc_admin where admin_id='" + id+ "'";
        String loginchk = null;
        System.out.println(query);
        ResultSet rs = null;
        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            System.out.println(con);
            smt = con.createStatement();
            rs = smt.executeQuery(query);
            con.close();

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return rs;
    }
    public ResultSet getOrderLineItem(String id)
    {
        String query= "SELECT * FROM order_line_item where id='" + id+ "'";
        String loginchk = null;
        
        try 
        {
            con3 = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con3 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);
            //con = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName, connectionProps);
            smt3 = con.createStatement();
            rs12 = smt3.executeQuery(query);

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return rs12;
        
    }

    public ResultSet getOrders(String orders)
    {
        String query= "SELECT * from order_table where order_id = '" + orders+ " ';";
        String loginchk = null;
 
        try 
        {
            con2 = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con2 = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);

            smt2 = con2.createStatement();
            rs11 = smt2.executeQuery(query);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
 
        return rs11;
    }

    
    //A function to match user entered username and password
    public String Authentication(String uname, String pass) throws SQLException
    { 
        String query= "SELECT * FROM user where username='" + uname + "' and password='" + pass + "'";
        String loginchk = null;
        System.out.println(query);
  
        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);

            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(query);
            int count = 0;
            while (rs.next()) 
            {
                loginchk = rs.getString("usertype");
                if (loginchk.equals("Customer"))
                {
                    String temp = rs.getString("table_id");
                    rs11 = getCustomers(temp);
                    rs11.beforeFirst();
                    rs11.next();
                    Customer.getInstance().CustID = temp;
                    Customer.getInstance().firstname = rs11.getString("firstname");
                    Customer.getInstance().lastname = rs11.getString("lastname");
                    Customer.getInstance().address = rs11.getString("address");
                    Customer.getInstance().email = rs11.getString("email");
                    String temp2 = rs11.getString("order_hist");
                    Order orders = new Order();
                    StringTokenizer st1 = new StringTokenizer(temp2);
                    while(st1.hasMoreTokens())
                    {
                        String temp3 = st1.nextToken(";");
                        rs11 = getOrders(temp3);
                        rs11.beforeFirst();
                        rs11.next();
                        orders.address = rs11.getString("address");
                        orders.cust_id = rs11.getString("cust_id");
                        orders.order_date = rs11.getString("date");                  
                        orders.order_id = rs11.getString("order_id");
                        orders.totalPrice = rs11.getString("amount"); 
                        String temp5 = rs11.getString("status");
                        if (temp5.equals("Sent"))
                        {
                            orders.status.OrderStatusID = "1";
                            orders.status.description = "Sent";
                        }
                        else if(temp5.equals("Received"))
                        {
                            orders.status.OrderStatusID = "2";
                            orders.status.description = "Received";
                        }
                        else if(temp5.equals("Preparing"))
                        {
                            orders.status.OrderStatusID = "3";
                           orders.status.description = "Preparing";
                        }
                        else if(temp5.equals("Dispatched"))
                        {
                            orders.status.OrderStatusID  = "4";
                            orders.status.description = "Dispatched";
                        }
                        else if(temp5.equals("Delivered"))
                        {
                            orders.status.OrderStatusID  = "5";
                            orders.status.description = "Delivered";
                        }
                        
                        String temp_items = rs11.getString("item_no");
                        OrderLineItem obj = new OrderLineItem();
                        StringTokenizer st2 = new StringTokenizer(temp_items);
                        while(st2.hasMoreElements())
                        {
                            String temp4 = st2.nextToken(";");
                            rs12 = getOrderLineItem(temp4);
                            rs12.beforeFirst();
                            rs12.next();
                            obj.id = rs12.getString("id");
                            obj.foodID = rs12.getString("food_id");
                            obj.price = rs12.getString("price");        
                            obj.quantity = rs12.getString("quantity");
                            
                            orders.itemList.add(obj);
                        }
                        System.out.println("AT THE END");
                        Customer.getInstance().orderHistory.add(orders);
                        System.out.println(Customer.getInstance().orderHistory.size());
                    }
                }
                else if (loginchk.equals("System Administrator"))
                {
                    String temp = rs.getString("table_id");
                    ResultSet rs2 = getSystemAdministrators(temp);
                    SystemAdministrator.getInstance().ID = temp;
                    SystemAdministrator.getInstance().firstname = rs2.getString("firstname");
                    SystemAdministrator.getInstance().lastname = rs2.getString("lastname");
                    SystemAdministrator.getInstance().email = rs2.getString("email");                            
                }
                else if (loginchk.equals("Food Chain Administrator"))
                {
                    String temp = rs.getString("table_id");
                    ResultSet rs2 = getFoodChainAdmins(temp);
                    FoodChainAdmin.getInstance().ID = rs2.getString("admin_id");
                    FoodChainAdmin.getInstance().FirstName = rs2.getString("firstname");
                    FoodChainAdmin.getInstance().LastName = rs2.getString("lastname");
                    FoodChainAdmin.getInstance().email = rs2.getString("email");                            
                }
                   
                
                count++;
            }
            if(count == 0)
            {
                loginchk = "null";
            }
            con.close();

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return loginchk;
    }
  
    
    public ArrayList<FoodChainProfile> retrieveAllFoodChains(String city, String area) throws SQLException 
    { 
        ArrayList <FoodChainProfile> store = new ArrayList<>();


        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);        
            
            String SQL = "select * from fc_profile";
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(SQL);
               
            while(rs.next())
            {
                String temp = rs.getString("city");
                String temp2 = rs.getString("area");
                StringTokenizer st1 = new StringTokenizer(temp);
                StringTokenizer st2 = new StringTokenizer(temp2);
                while(st1.hasMoreTokens())
                {
                    String temp3 = st1.nextToken(";");
                    System.out.println(temp3);
                    if (temp3.equals(city))
                    {
                        while(st2.hasMoreTokens())
                        {
                            String temp5 = st2.nextToken(";");
                            if (temp5.equals(area))
                            { 
                                FoodChainProfile object = new FoodChainProfile();
                                object.area = rs.getString("area");
                                object.city = rs.getString("city");
                                object.delivery_time = rs.getString("delivery_time");
                                object.fc_id = rs.getString("fc_if");
                                object.logo = rs.getString("logo");
                                object.name = rs.getString("name");
                                Order orders = new Order();
                                String temp4 = rs.getString("order_hist");
                                
                                StringTokenizer st3 = new StringTokenizer(temp4, ";");
                                while(st3.hasMoreTokens())
                                {
                                    String temp6 = st3.nextToken(";");
                                    
                                    rs11  = getOrders(temp6);
                                    System.out.println(rs11.isClosed());
                                    rs11.beforeFirst();
                                    rs11.next();
                                    
                                    orders.address = rs11.getString("address");
                                    orders.cust_id = rs11.getString("cust_id");
                                    orders.order_date = rs11.getString("date"); 
                                    orders.order_id = rs11.getString("order_id");
                                    orders.totalPrice = rs11.getString("amount");
                                    String temp7 = rs11.getString("status");
                                    if (temp7.equals("Sent"))
                                    {
                                        orders.status.OrderStatusID = "1";
                                        orders.status.description = "Sent";
                                    }
                                    else if(temp7.equals("Received"))
                                    {
                                        orders.status.OrderStatusID = "2";
                                        orders.status.description = "Received";
                                    }
                                    else if(temp7.equals("Preparing"))
                                    {
                                        orders.status.OrderStatusID = "3";
                                        orders.status.description = "Preparing";
                                    }
                                    else if(temp7.equals("Dispatched"))
                                    {
                                        orders.status.OrderStatusID  = "4";
                                        orders.status.description = "Dispatched";
                                    }
                                    else if(temp7.equals("Delivered"))
                                    {   
                                        orders.status.OrderStatusID  = "5";
                                        orders.status.description = "Delivered";
                                    }
                                    
                                    String temp_items = rs11.getString("item_no");
                                    OrderLineItem obj = new OrderLineItem();
                                    StringTokenizer st4 = new StringTokenizer(temp_items, ";");
                                    while(st4.hasMoreElements())
                                    {
                                        
                                        String temp8 = st4.nextToken(";");
                                        rs12 = getOrderLineItem(temp8);
                                        rs12.beforeFirst();
                                        rs12.next();
                                    
                                        obj.id = rs12.getString("id");
                                        obj.foodID = rs12.getString("food_id");
                                        obj.price = rs12.getString("price");        
                                        obj.quantity = rs12.getString("quantity");
                            
                                        orders.itemList.add(obj);
                                    }
                                    object.order_hist.add(orders);
                                    System.out.println("Orders " + object.order_hist.size());
                                }
                                store.add(object);
                                System.out.println("FoodChain " + store.size());
                            }

                        }   
                        
                    }
    
                     
                }
               
            }    
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
            return store;
	
    }
    
    
    public ObservableList<String> retriveCities()
    {
        ObservableList<String> cities = FXCollections.observableArrayList();
        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);        

            String SQL = "select * from locations";
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(SQL);
            int counter = 0;
            String temp = null;     
            while(rs.next())
            {
                temp = rs.getString("cities");
                System.out.println(temp);
                cities.add(temp);
            }    
        }
        catch(SQLException se)
        {
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(smt!=null)
                {
                        con.close();
                }
            }
            catch(SQLException se)
            {
            }
            try
            {
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException se)
            {
                    se.printStackTrace();
            }
        }
        return cities;
    }
    
     public ObservableList<String> retriveAreas(String city)
    {
        ObservableList<String> areas = FXCollections.observableArrayList();
        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);        

            String SQL = "select * from locations where cities = " + "'" + city + "'";
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(SQL);
            int counter = 0;
            String temp = null;     
            while(rs.next())
            {
                temp = rs.getString("Areas");
                StringTokenizer st1 = new StringTokenizer(temp);
                while(st1.hasMoreTokens())
                {
                    String temp2 = st1.nextToken(";");
                    areas.add(temp2);
                     
                }
            }    
        }
        catch(SQLException se)
        {
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(smt!=null)
                {
                        con.close();
                }
            }
            catch(SQLException se)
            {
            }
            try
            {
                if(con!=null)
                {
                    con.close();
                }
            }
            catch(SQLException se)
            {
                    se.printStackTrace();
            }
        }
        return areas;
    }
    
    
        
        
    
  
    public static ArrayList<FoodItem> retrieveAllFoodItems() 
    { 
        ArrayList <FoodItem> store = new ArrayList<>();


        try 
        {
            con = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user",USERNAME);
            connectionProps.put("password", PASSWORD);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DB_NAME, connectionProps);        
            
            Field[] fields = FoodChainProfile.class.getDeclaredFields();
            String[] type = new String[fields.length];
                
            for (int i = 0; i<fields.length; i++)
            {
                Class class_type = fields[i].getType();
                type[i] = class_type.getName();
            }

                String SQL = "select * from food_item";
                smt = con.createStatement();
                ResultSet rs = smt.executeQuery(SQL);
                int counter = 0;
                
            while(rs.next())
            {
                //System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
                FoodItem obj = new FoodItem();
                Class class_var = obj.getClass();
                Field[] fields_new = class_var.getDeclaredFields();
                    
                    
                for (int i=0; i<fields_new.length; i++)
                {
                    fields_new[i].setAccessible(true);
                }
                    
                for(int j=0; j<fields_new.length; j++)
                {
                    if(type[j].equals("java.lang.String"))
                    {
                        String temp = rs.getString(j+1);
                        fields_new[j].set(obj, temp);
                    }  
                    
                }
                    
                store.add(obj);
            }    
        }
            catch(SQLException se)
            {
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if(smt!=null)
                    {
                        con.close();
                    }
                }
                catch(SQLException se)
                {
                }
                try
                {
                    if(con!=null)
                    {
                        con.close();
                    }
                }
                catch(SQLException se)
                {
                    se.printStackTrace();
                }
            }
            return store;
	
    }
    
}
