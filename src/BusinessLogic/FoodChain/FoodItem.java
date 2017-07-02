package BusinessLogic.FoodChain;

public class FoodItem 
{
        public String foodID;
	public String name;
        public String price;

        public String food_picture;
        public FoodItem()
        {
            
        }
        public FoodItem(FoodItem fd)//constructor
        {
            name = fd.name;
            price = fd.price;
            foodID = fd.foodID;
            food_picture = fd.food_picture;
        }
        public void modifyFood(String foodId, String name, String price)
        {
            /*Function that edits a fooditem entry from the fooditems table using its ID. */
        }
}
