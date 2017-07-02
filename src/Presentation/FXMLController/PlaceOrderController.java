
package Presentation.FXMLController;


import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import BusinessLogic.FoodChain.Location;
import BusinessLogic.FoodChain.Menu;
import BusinessLogic.User.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class PlaceOrderController implements Initializable , ControlledScreenInterface
{
   BackController backctr;

    @FXML
    private ListView<String> menulist;
    public static String selectedString;
    
    @FXML
    private JFXListView<String> payment;
    @FXML
    private ImageView profile_pic;
    @FXML
    private JFXButton checkout;
    @FXML
    private Label error;
    @FXML
    private JFXListView<String> caculation1;
    @FXML
    private JFXListView<String> caculation;
    ArrayList<Image> logos = new ArrayList<>();
    ArrayList<String> temp_list = new ArrayList<>();
    ObservableList<String> items = FXCollections.observableArrayList();
    ObservableList<String> item_count = FXCollections.observableArrayList();
    ObservableList<String> order_items = FXCollections.observableArrayList();
    ObservableList<String> calculation = FXCollections.observableArrayList();
    ObservableList<String> calculation2 = FXCollections.observableArrayList();
    double totalamount = 0;
    public WritableImage resterauntIcon(String path)
    {
        System.out.println(path);
        BufferedImage BufferedImg = null;
        try {
            String new_path = System.getProperty("user.dir") +  System.getProperty ("file.separator") + path;
            BufferedImg = ImageIO.read(new File(new_path));
        } catch (IOException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        WritableImage wr = null;
        if (BufferedImg!=null)
        {
            wr = new WritableImage(BufferedImg.getWidth(),BufferedImg.getHeight());
            PixelWriter px = wr.getPixelWriter();
            for (int i=0; i<BufferedImg.getWidth(); i++)
            {
                for (int j=0; j<BufferedImg.getHeight(); j++)
                {
                    px.setArgb(i, j, BufferedImg.getRGB(i,j));
                }
            }
             
        }

        return wr;
    }
    public ArrayList<Image> makeImageArray()
    {
        ArrayList<Image> logos = new ArrayList<>();
        for (int i=0; i<Menu.getInstance().FoodItemList.size(); i++)
        {
            String rest_logo = Menu.getInstance().FoodItemList.get(i).food_picture;
            System.out.println(rest_logo);
            WritableImage wr = resterauntIcon(rest_logo);
            logos.add(wr);
        }
        return logos;
    }
    public ObservableList<String> makeMenuListArray()
    {
        ObservableList<String> food_names = FXCollections.observableArrayList();
        for (int i=0; i<Menu.getInstance().FoodItemList.size(); i++)
        {
            String foodname = Menu.getInstance().FoodItemList.get(i).name;
            System.out.println(foodname);
            food_names.add(foodname);
        }
        return food_names;
    }

    public String getQuantity(int index, String item)
    {
        int count = 0;
        for (int i=0; i<temp_list.size(); i++)
        {
            System.out.println(temp_list.get(i) + " is in temp list!");
            System.out.println("Sizesss: " + i + temp_list.size());
           if(temp_list.get(i).equals(item))
           {
               count++;
           }
           if (i  == (temp_list.size()-1))
           {
                String temp = Integer.toString(count);
                order_items.set(index, temp + "x "+ item);
                String var = Double.toString(totalamount);
                calculation2.remove(1);
                calculation2.add(var);
            }
           
        }
        System.out.println("Count " + count);
        
        return Integer.toString(count);
    }
    public String getQuantityList()
    {
        String var = null;
        for (int i =0; i<order_items.size(); i++)
        {
            String temp = order_items.get(i).substring(3);
            var = getQuantity(i, temp);
        }
        return var;
    }
    public boolean checkOccurance(String temp)
    {
        boolean ans =false;
        for (int i =0; i<order_items.size(); i++)
        {
            String var = order_items.get(i).substring(3);
            System.out.println(temp + " meee " + var);
            if (temp.equals(var))
            {
                ans =  true;
                break;
            } 
        }
        return ans;
    }
      @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        
      
        temp_list.clear();
    
    item_count.clear();
     order_items.clear();
     calculation.clear();
     calculation2.clear();
     
      items.clear();
     System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        backctr.setScreen(Controller.foodlist);
    }
    @FXML
    void proceedToCheckout(ActionEvent event) throws IOException 
    {
        
        if (order_items.isEmpty()) 
        {
            error.setText("Cart cannot be empty!");

        } else {
            Controller.the_Order.status.OrderStatusID = "1";
            Controller.the_Order.status.description = "Sent";
            Controller.the_Order.totalPrice = Double.toString(totalamount);

            /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/Payment.fxml"));
            String temp = home_page.toString();
            System.out.println(temp);
            Scene home_page_scene = new Scene(home_page);
            Stage S1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            S1.setScene(home_page_scene);
            S1.show();*/
             Controller.mainContainer.loadScreen(Controller.payment, Controller.fxml_name9);
                backctr.setScreen(Controller.payment);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        calculation.add("Delivery Fee: ");
        calculation.add("Total Price: ");
        caculation.setItems(calculation);
        calculation2.add("Rs. 70");
        calculation2.add("0.00");
        
        checkout.setStyle("-fx-graphic: url(/Presentation/images/button4.png);");
        
        
        String logo_name = null;
        for(int i= 0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            if (Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name.equals(Menu.getInstance().food_chain))
            {
                logo_name = Location.getInstance().retrievedFoodChains.FoodChainList.get(i).logo;
                break;
            }
        }   
        BufferedImage BufferedImg = null;
        try {
            String file = System.getProperty("user.dir") +  System.getProperty ("file.separator") + logo_name;
            System.out.println(file);
            BufferedImg = ImageIO.read(new File(file));
        } catch (IOException ex) {
            Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        WritableImage wr = null;
        if (BufferedImg!=null)
        {
            wr = new WritableImage(BufferedImg.getWidth(),BufferedImg.getHeight());
            PixelWriter px = wr.getPixelWriter();
            for (int i=0; i<BufferedImg.getWidth(); i++)
            {
                for (int j=0; j<BufferedImg.getHeight(); j++)
                {
                    px.setArgb(i, j, BufferedImg.getRGB(i,j));
                }
            }
             
        }

        profile_pic.setImage(wr);
        items = makeMenuListArray();
        menulist.setItems(items);
        logos = makeImageArray();

        menulist.setCellFactory(param -> new ListCell<String>() 
        {
            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty) 
            {
                super.updateItem(name, empty);
                if (empty) 
                {
                    setText(null);
                    setGraphic(null);
                } 
                else 
                {
                    for (int i=0; i<logos.size(); i++)
                    {
                        if (name.equals(items.get(i)))
                        {
                            imageView.setFitHeight(100);
                            imageView.setFitWidth(100);
                            imageView.setImage(logos.get(i));
                            setText("  " + items.get(i));
                        }
                    }
                    setGraphic(imageView);
                }
            }
        });
        
        menulist.setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent event)
            {
                String temp = menulist.getSelectionModel().getSelectedItem();
                String amt = Controller.the_Order.addFoodItems(temp);
                temp_list.add(temp);
                totalamount = totalamount + Integer.parseInt(amt);
                if (!checkOccurance(temp))
                {
                    order_items.add("1x " + temp);
                    String var = Double.toString(totalamount);
                    calculation2.remove(1);
                    calculation2.add(var);
                }
                else
                {
                    String temp2 = getQuantityList();
                }
                
                
            }
        });
        
        Platform.runLater(new Runnable() 
        {
            @Override
            public void run()
            {
                payment.setItems(order_items);
            }
        });
        
        Platform.runLater(new Runnable() 
        {
            @Override
            public void run()
            {
                caculation1.setItems(calculation2);
            }
        });
       
       
        
    }

    @Override
    public void setScreenParent(BackController screenPage) {
    backctr=screenPage;
    }
  
}
