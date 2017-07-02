package BusinessLogic.Controller;

import BusinessLogic.FoodChain.FoodChainProfile;
import BusinessLogic.FoodChain.ListofFoodItems;
import BusinessLogic.Order.Order;
import BusinessLogic.User.Customer;
import BusinessLogic.User.SystemAdministrator;
import DataAccess.ORMapper;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Rija Fahim
 * 
 * */
public class Controller extends Application
{
    /*Singleton objects */
    public static ListofFoodItems DB_FoodItems = ListofFoodItems.getInstance();
    public static ORMapper DB_OR = ORMapper.getInstance();
    public static Order the_Order;
    public static FoodChainProfile selected_FoodChain;
    public static String fxmlID="login";
    public static String fxml_name="/Presentation/FXML/LoginScreen.fxml";
    public static String fxmlID2="reg";
    public static String fxml_name2="/Presentation/FXML/Registeration.fxml";
    public static String ordernow="ordernow";
    public static String fxml_name3="/Presentation/FXML/OrderNowScreen.fxml";
    public static String change="change";
    public static String fxml_name4="/Presentation/FXML/ChangeOrder.fxml";
    public static String cancel="cancel";
    public static String fxml_name5="/Presentation/FXML/CancelOrder.fxml";
    public static String local="local";
    public static String fxml_name6="/Presentation/FXML/EnterLocation.fxml";
      public static String foodlist="foodlist";
    public static String fxml_name7="/Presentation/FXML/FoodChainList.fxml";
     public static String placeord="placeord";
    public static String fxml_name8="/Presentation/FXML/PlaceOrder.fxml";
      public static String payment="payment";
    public static String fxml_name9="/Presentation/FXML/Payment.fxml";
     public static String cnf="cnf";
    public static String fxml_namex="/Presentation/FXML/UserConfirmation.fxml";
      //public static String comfirm="comfirm";
   // public static String fxml_name10="/Presentation/FXML/OrderConfirmation.fxml";
    
     public static String confirm="confirm";
    
     public static String fxml_name11="/Presentation/FXML/confirm.fxml";
    public static BackController mainContainer = new BackController();
    

    
    @Override
    public void start(Stage stage) throws Exception 
    {
        /*Parent root = FXMLLoader.load(getClass().getResource("/Presentation/FXML/LoginScreen"+ ".fxml"));
        Scene scene = new Scene(root, 640,480);
        stage.setTitle("FoodExpress");
        stage.setScene(scene);
        stage.show();*/

       
        mainContainer.loadScreen(Controller.fxmlID, Controller.fxml_name);
        mainContainer.loadScreen(Controller.fxmlID2, Controller.fxml_name2);
        mainContainer.loadScreen(Controller.cnf, Controller.fxml_namex);
         //mainContainer.loadScreen(Controller.payment, Controller.fxml_name9);
        mainContainer.loadScreen(Controller.confirm, Controller.fxml_name11);
        mainContainer.setScreen(Controller.fxmlID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root, 650,500);
        stage.setTitle("FoodExpress");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}

