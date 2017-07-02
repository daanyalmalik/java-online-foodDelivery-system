package BusinessLogic.User;

public class SystemAdministrator extends User
{
	public String email;
	public String firstname;
	public String ID;
	public String lastname;
	private static SystemAdministrator instance = new SystemAdministrator();
        private SystemAdministrator()
        {
            
        }
        public static SystemAdministrator getInstance()
        {
            return instance;
        }

}
