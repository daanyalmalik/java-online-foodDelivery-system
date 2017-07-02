/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;


import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import BusinessLogic.FoodChain.ListofFoodChains;
import BusinessLogic.FoodChain.Location;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class EnterLocationController implements Initializable , ControlledScreenInterface
{
   BackController backctr;
    
    private ObservableList<String> cities = FXCollections.observableArrayList();
    private ObservableList<String> areas = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> city;
    @FXML
    private Label label;
    @FXML
    private JFXComboBox<String> area;
    @FXML
    private JFXButton show_button;
    @FXML
    private Label error;
    @FXML
    void ChooseCity(ActionEvent event) 
    {
        Location.getInstance().City = city.getValue();
        areas = Location.getInstance().ChooseCity(Location.getInstance().City);
        area.setItems(areas);
    }
    @FXML
    void ChooseArea(ActionEvent event) throws SQLException 
    {
        Location.getInstance().Area = area.getValue();
        Location.getInstance().retrievedFoodChains = Location.getInstance().ChooseArea(Location.getInstance().Area);
    }
      @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        
 
        backctr.setScreen(Controller.ordernow);
    }
    @FXML
    void ShowRestaurants(ActionEvent event) throws IOException 
    {
        if( area.getValue()==null || city.getValue()==null)
        {
            error.setText("City and Area cannot be empty");
        }
        else
        {
            /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/FoodChainList.fxml"));
            String temp = home_page.toString();
            System.out.println(temp);
            Scene home_page_scene = new Scene(home_page);
            Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            S1.setScene(home_page_scene);
            S1.show();*/
            Controller.mainContainer.loadScreen(Controller.foodlist, Controller.fxml_name7);
            //System.out.println("Presentation.FXMLController.LoginScreenController.makelogin()");
       backctr.setScreen(Controller.foodlist);
        
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        show_button.setStyle("-fx-graphic: url(/Presentation/images/button2.png);");
        Location.getInstance();
        cities = Controller.DB_OR.retriveCities();
        city.setItems(cities);
    }    

    @Override
    public void setScreenParent(BackController screenPage) {
     backctr=screenPage;
    }

}
