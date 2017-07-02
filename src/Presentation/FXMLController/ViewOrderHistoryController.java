/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.FoodChain.Location;
import BusinessLogic.User.Customer;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class ViewOrderHistoryController implements Initializable {

    @FXML
    private ListView<String> orderlist;
    ObservableList<String> items = FXCollections.observableArrayList();
    public ObservableList<String> makeOrderListArray()
    {
        ObservableList<String> orders = FXCollections.observableArrayList();
        
        for (int i=0; i<Customer.getInstance().orderHistory.size(); i++)
        {
            System.out.println(Customer.getInstance().orderHistory.get(i).order_date);
            String foodchain = " Date: " + Customer.getInstance().orderHistory.get(i).order_date + "\n" 
            + " Total Price: " + Customer.getInstance().orderHistory.get(i).totalPrice + "\n" 
            + " Delivered to: " + Customer.getInstance().orderHistory.get(i).address + "\n";
            orders.add(foodchain);
        }
        return orders;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        items = makeOrderListArray();
        orderlist.setItems(items);
        
    }    

}
