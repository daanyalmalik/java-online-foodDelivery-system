/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import static BusinessLogic.Controller.Controller.mainContainer;
import BusinessLogic.User.Registeration;
import BusinessLogic.User.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class RegisterationController implements Initializable, ControlledScreenInterface
{
    BackController backctr;
     ArrayList mylist = new ArrayList();

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField repassword;

    @FXML
    private JFXButton submit;

    @FXML
    private JFXTextField address;

    @FXML
    private Label dob;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField username;
    
     @FXML
    private Label error;
     
      @FXML
    private Label error2;
    
    
    @FXML
    private JFXComboBox<String> month;

    @FXML
    private JFXComboBox<String> Year;
    
    @FXML
    private JFXComboBox<String> day;
    private ObservableList<String> days = FXCollections.observableArrayList();
    private ObservableList<String> months = FXCollections.observableArrayList();
    private ObservableList<String> years = FXCollections.observableArrayList();
    //private ObservableList<String> mylist = FXCollections.observableArrayList();
    
    @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        
      
       /* Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/LoginScreen.fxml"));
        String temp = home_page.toString();
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setTitle("FoodExpress");
        S1.setScene(home_page_scene);
        S1.show();*/
        backctr.setScreen(Controller.fxmlID);
    }
    
    @FXML
    void makeRegisteration(ActionEvent event) throws IOException 
    {
        
        mylist.add(day.getValue());
        mylist.add( month.getValue());
        mylist.add( Year.getValue());
        mylist.add(firstname.getText());
        mylist.add(lastname.getText());
        mylist.add(email.getText());
         mylist.add(username.getText());
          mylist.add(password.getText());
           mylist.add(address.getText());
          boolean chk=val_chk(mylist);
           boolean chk2=password_chk(password.getText(),repassword.getText());
           mylist.clear();
          //boolean chk=true;
          if(chk == true || chk2== false)
          {
              
              error.setText("One or more field is empty or password doesnot match");
          }
          else if (chk == false  && chk2 == true)
          {
              error.setText("");
           String temp2 = day.getValue() + " " + month.getValue() + " " + Year.getValue();
        Registeration R1 = new Registeration();
       R1.FillInfo(firstname.getText(), lastname.getText(), email.getText(), temp2, username.getText(), password.getText(), address.getText());
        /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentations/FXML/UserConfirmation.fxml"));
        String temp = home_page.toString();
        System.out.println(temp);
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/  
        Controller.mainContainer.loadScreen(Controller.cnf, Controller.fxml_namex);
         Controller.mainContainer.setScreen(Controller.cnf);
          }
    }
    
     boolean password_chk(String s1, String s2)
    {
         return s1.equals(s2);
        
    }
    
    boolean val_chk(ArrayList mylist)
    {
        int len= mylist.size();
        System.out.println("Presentation: " + len);
        int count=0;
        boolean ret=false;
        for(int i=0; i<len; i++)
        {
            String temp=  (String) mylist.get(i);
            System.out.println("Presentation: " + temp);
            if( temp == null)
            {
                count++;
            }
        }
        if(count > 0)
        {
            ret=true;
        }
        else if(count==0)
        {
            ret=false;
        }
        
        return ret;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        String temp = null;
        for (int i=1; i<=31; i++)
        {
            temp = Integer.toString(i);
            days.add(temp);
        }
        day.setItems(days);
        for (int i = 1900; i<=2016; i++)
        {
            temp = Integer.toString(i);
            years.add(temp);
        }
        Year.setItems(years);
        for (int i=1; i<=12; i++)
        {
            temp = Integer.toString(i);
            months.add(temp);
        }
        month.setItems(months);
        
        
    }    

    @Override
    public void setScreenParent(BackController screenPage) {
      backctr=screenPage;
    }
    
}
