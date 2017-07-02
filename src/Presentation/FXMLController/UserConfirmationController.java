/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class UserConfirmationController implements Initializable , ControlledScreenInterface
{
   BackController backctr;

    @FXML
    private JFXButton loginbutton;

    @FXML
    void gotoLogin(ActionEvent event) throws IOException 
    {
        Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/LoginScreen.fxml"));
        String temp = home_page.toString();
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(BackController screenPage) {
       backctr = screenPage; }
    
}
