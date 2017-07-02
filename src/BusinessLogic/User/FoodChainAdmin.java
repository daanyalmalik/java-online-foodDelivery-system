package BusinessLogic.User;

public class FoodChainAdmin extends User{

	public String email;
	public String FirstName;
	public String LastName;
	public String ID;
        private static FoodChainAdmin instance = new FoodChainAdmin();
	private FoodChainAdmin()
	{
		
	}
        public static FoodChainAdmin getInstance()
        {
            return instance;
        }
        public void addFoodChainAdmins()
        {
            
        }
}
