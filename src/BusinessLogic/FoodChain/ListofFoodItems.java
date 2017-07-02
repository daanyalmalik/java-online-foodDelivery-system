package BusinessLogic.FoodChain;

import java.util.ArrayList;


public class ListofFoodItems 
{
    private static ListofFoodItems instance = new ListofFoodItems();
    public ArrayList<FoodItem> FoodItemList; 
    
    private ListofFoodItems()
    {
        
    }
    public static ListofFoodItems getInstance()
    {
        return instance;
    }
    public void UpdateFood()
    {
        
       FoodItemList = DataAccess.ORMapper.retrieveAllFoodItems();
    }
    public void AddItems(String item)
    {
        /*This function will invoke a method from the ORMapper class and send the item to 
        the method for it to add to the Database, whenever the FoodChain Admin wishes to add
        another food item to their menu. Will be called additionally after chnages have been made
        to the menu class. USE CASE # 10
        */
    }
    public void DeleteItems(String items)
    {
        /*This function will invoke a method from the ORMapper class and the item 
        sent as parameter is deleted off the Database. Will be called if the Food Chain admin wishes 
        to delete a food item off it menu and hence off the fooditems table in the database. USE CASE # 11
        */
    }
    public void ViewFooditems()
    {
        /* A function that is used to view all the current food items in the fooditems table. Used by both
        System Admin and Food Chain Admin
        */
    }
    
}
