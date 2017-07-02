/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;
import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import BusinessLogic.User.User;
import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import static com.jfoenix.validation.ValidationFacade.validate;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static sun.security.util.KeyUtil.validate;

/**
 *
 * @author daany
 */
public class LoginScreenController implements Initializable,ControlledScreenInterface {
      BackController backctr;
    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField username;
    
  
    @FXML
    private JFXButton signup;
    
    @FXML
    private Label error;
    
    @FXML
    void makelogin(ActionEvent event) throws SQLException, IOException 
    {
        String name = username.getText();
        String pas = password.getText();
        System.out.println("Presentati " + name);
        System.out.println("Presentati " + pas);

        if ("".equals(name) || "".equals(pas)) {
            error.setText("Username or Password fields cannot be empty!");
        } 
        else {
        
           String uname = username.getText();
        String pass =  password.getText();
        User U1 = new User();
        String authenticated = U1.ReadUserInfo(uname, pass);
        System.out.println(authenticated + "  DAentered!");
        
        if(authenticated=="null")
        {
              System.out.println( "DAnientered!");
              error.setText("Invalid Username/Password or Account doesnot exist!");
        }
        else
        {
            Controller.mainContainer.loadScreen(Controller.ordernow, Controller.fxml_name3);
            Controller.mainContainer.loadScreen(Controller.change, Controller.fxml_name4);
            Controller.mainContainer.loadScreen(Controller.cancel, Controller.fxml_name5);
            System.out.println("Presentation.FXMLController.LoginScreenController.makelogin()");
            backctr.setScreen(Controller.ordernow);
        }
        
        
      /*  Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/OrderNowScreen.fxml"));
        String temp = home_page.toString();
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setTitle("FoodExpress");
        S1.setScene(home_page_scene);*/
     
        //S1.show();
        
       
       
        
        }
        
    } 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        username.setStyle("-fx-text-inner-color: white;");
        password.setStyle("-fx-text-inner-color: white;");
    }    

       @Override
    public void setScreenParent(BackController screenPage) {
        backctr=screenPage;
       }
    @FXML
    void RegisterUser(ActionEvent event) throws IOException 
    {
        /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/Registeration.fxml"));
        String temp = home_page.toString();
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/
        //backctr.setScreen(Controller.fxml_name2);
        backctr.setScreen(Controller.fxmlID2);
    }
    
}
