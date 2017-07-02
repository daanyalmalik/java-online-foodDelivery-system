package BusinessLogic.FoodChain;


import java.util.ArrayList;
import DataAccess.ORMapper;

public class ListofFoodChains 
{
    public static ListofFoodChains instance = new ListofFoodChains();
    public static String key;
    public static ArrayList<FoodChainProfile> FoodChainList = new ArrayList<>(); 
    private ListofFoodChains()
    {
        
    }
    public static ListofFoodChains getInstance()
    {
        return instance;
    }

    public void AddFoodChain()
    {
        /* invokes a function in the ORMapper that will add a new foodChain to the DB */
    }
    public void DeleteFoodChain()
    {
        /* invokes a function in the ORMapper that will delete a new foodChain to the DB */
    }
    public void viewFoodChain()
    {
        /*View*/
        
    }

}
