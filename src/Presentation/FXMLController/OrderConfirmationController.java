/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author daany
 */
public class OrderConfirmationController implements Initializable , ControlledScreenInterface
{
   BackController backctr;
    @FXML
    private JFXButton loginbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotoLogin(ActionEvent event) {
         backctr.setScreen(Controller.ordernow);
    }

    @Override
    public void setScreenParent(BackController screenPage) {

        backctr = screenPage;
    }

}
