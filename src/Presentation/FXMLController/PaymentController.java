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
import BusinessLogic.Order.Payment;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dani-Desktop
 */
public class PaymentController implements Initializable , ControlledScreenInterface
{
   BackController backctr;
    @FXML
    private JFXTextField addressS;
    @FXML
    private JFXTextField cc_no;
    @FXML
    private JFXTextField cc_exp;
    @FXML
    private JFXRadioButton rb1;

    @FXML
    private JFXRadioButton rb2;
    
    @FXML
    private JFXButton checkoutgo;
    
    String tempo;
    RadioButton chk;

    @FXML
    void enterAddress(ActionEvent event) 
    {
        Controller.the_Order.address = addressS.getText();
    }
    

    
    @FXML
    void Checkout(ActionEvent event) throws IOException 
    {
        //System.out.println("dani: " + addressS.getText());
          //mainContainer.loadScreen(Controller.comfirm, Controller.fxml_name10);
         backctr.setScreen(Controller.confirm);
       // Controller.the_Order.address = addressS.getText();
        /*Payment P1 = new Payment();
        System.out.println(tempo);
        P1.ChoosePaymentMethod(tempo);
        Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/OrderNowScreen.fxml"));
        String temp = home_page.toString();
        System.out.println(temp);
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/

    }
      @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        
 
        backctr.setScreen(Controller.placeord);
    }
    @FXML
    void cc_func(ActionEvent event) throws IOException 
    {
        cc_no.setEditable(true);
        cc_exp.setEditable(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        final ToggleGroup group = new ToggleGroup();
       
        rb1.setToggleGroup(group);
        //rb1.setSelected(true);
        

        rb2.setToggleGroup(group);
        cc_no.setEditable(false);
        cc_exp.setEditable(false);
        
        
       // rb1.selectedProperty().bind(Bindings.not(addressS.disabledProperty()));
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
            {
                RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                String c = chk.getText();
                
                tempo = c;
                if(tempo.equals("Credit/Debit"))
                {
                   cc_no.setEditable(true);
                    cc_exp.setEditable(true);
                }
                else if(tempo.equals("Cash"))
                {
                    
                     cc_no.setEditable(false);
                    cc_exp.setEditable(false);
                }
                //addressS.setText(c);
                System.out.println("Selected Radio Button - "+chk.getText());
                
                
        }
    });
 

    }    

    @Override
    public void setScreenParent(BackController screenPage) {
     
backctr=screenPage;}
    
}
