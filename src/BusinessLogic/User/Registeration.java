
package BusinessLogic.User;

import BusinessLogic.Controller.Controller;
import DataAccess.ORMapper;

public class Registeration 
{
    public static String address;
    public static String dateofbirth;
    public static String email;
    public static String firstname;
    public static String isRegistered;
    public static String lastname;
    public static String password;
    public static String username;
    public static int ID = 0;
    public Registeration(){}
    
    public void FillInfo(String v1, String v2, String v3, String v4, String v5, String v6, String v7)
    {
        ID++;
        firstname = v1;
        lastname = v2;
        email = v3;
        dateofbirth = v4;
        username = v5;
        password = v6;
        address = v7;
        ORMapper.getInstance().setRegisteration(Integer.toString(ID),firstname, lastname, email, dateofbirth, username, password, address);
    }
}
