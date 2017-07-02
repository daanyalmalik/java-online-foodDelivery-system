package BusinessLogic.FoodChain;

import java.util.ArrayList;


public class Menu 
{
    public String menu_id; //menu number 1,2,3
    public String food_chain;
    public ArrayList<FoodItem> FoodItemList = new ArrayList<>(); //list of foods
    public String description; //describing stuff on the menu overall
    private static Menu instance = new Menu();
    private Menu()
    {
        menu_id = "";
        food_chain = "";
        description = "";
    }
    public static Menu getInstance()
    {
        return instance;
    }
    void modifyMenu(String menu_id, String food_chain, String food_id, String desc)
    {
        //called to make chnages in a particular row of the row
    }
    public static Menu getMenu()
    {
        return instance;
    }
}
