package BusinessLogic.FoodChain;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import BusinessLogic.Controller.Controller;
import java.sql.SQLException;
import javafx.collections.ObservableList;

public class Location 
{
	public String Area;
	public String City;
	public ListofFoodChains retrievedFoodChains  = ListofFoodChains.getInstance();
        private static Location instance = new Location();
	private Location()
	{

	}
        public static Location getInstance()
        {
            return instance;
        }
	
        public ObservableList<String> ChooseCity(String city)
        {
            City =city;
            ObservableList<String> AREAS = FXCollections.observableArrayList();
            AREAS = Controller.DB_OR.retriveAreas(City);
            return AREAS;
        }
        public ListofFoodChains ChooseArea(String area) throws SQLException
        {
            Area = area;
            ArrayList<FoodChainProfile> retrieved = new ArrayList<>();
            retrievedFoodChains.FoodChainList  = Controller.DB_OR.retrieveAllFoodChains(City, Area); 
            return retrievedFoodChains;
        }
        public ArrayList<String> enterKeyword(String keyword)
        {
           ArrayList<String> temp2 = new ArrayList<>();
            for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
            {
                if (Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name.equals(keyword))
                {
                //temp.add(Location.getInstance().retrievedFoodChains.FoodChainList.get(i));
                    temp2.add(Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name);
                }
            }
            return temp2;
        }
}
