/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class ChangeOrderController implements Initializable , ControlledScreenInterface
{
   BackController backctr;

     
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @Override
    public void setScreenParent(BackController screenPage) {
    backctr=screenPage;
 }
     @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        
 
        backctr.setScreen(Controller.ordernow);
    }

    
}
