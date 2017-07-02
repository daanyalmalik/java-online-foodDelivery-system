
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import BusinessLogic.FoodChain.FoodChainProfile;
import BusinessLogic.FoodChain.ListofFoodChains;
import BusinessLogic.FoodChain.Location;
import BusinessLogic.FoodChain.Menu;
import BusinessLogic.Order.Order;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.EventType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author daany
 */
public class FoodChainListController implements Initializable , ControlledScreenInterface
{
   BackController backctr;
    @FXML
    private ListView<String> rest_list;
    ArrayList<Image> logos = new ArrayList<>();
    ObservableList<String> items = FXCollections.observableArrayList();
    String selectedString;     
    @FXML
    private VBox Browsefood;
      
    @FXML
    private Button bbq;

    @FXML
    private Button pizza;

    @FXML
    private Button bakery;

    @FXML
    private TextField serach;

    @FXML
    private Button coffee;

    @FXML
    private Button go;

    @FXML
    private Button fastfood;

    @FXML
    void getResteraunts(ActionEvent event) 
    {

    }


    public void setList()
    {
          rest_list.setCellFactory(param -> new ListCell<String>() 
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
                            setText("    " + items.get(i) + "\n    Delivers in " + Location.getInstance().retrievedFoodChains.FoodChainList.get(i).delivery_time + "minutes");
                        }
                    }
                    setGraphic(imageView);
                }
            }
        });
                
  
    }
     @FXML
    void goBack(ActionEvent event) throws IOException 
    {
        System.out.println("Presentation.FXMLController.RegisterationController.goBack()");
        
 
        backctr.setScreen(Controller.local);
    }

    @FXML
    void goButton(ActionEvent event) 
    {
        ArrayList<String> temp2 = new ArrayList<>();
        String keyword = serach.getText();
        temp2 = Location.getInstance().enterKeyword(keyword);
        System.out.println(keyword);
        /*ArrayList<FoodChainProfile> temp = new ArrayList<>();
        for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            if (Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name.equals(keyword))
            {
                //temp.add(Location.getInstance().retrievedFoodChains.FoodChainList.get(i));
                temp2.add(Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name);
            }
        }*/
        
        for(int i=0; i<temp2.size(); i++)
        {
            items = makeRestListArray(temp2.get(i));
            rest_list.setItems(items);
                   
            try {
                logos = makeImageArray(temp2.get(i));
            } catch (IOException ex) {
                Logger.getLogger(FoodChainListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        

        
  
        setList();
        //Location.getInstance().retrievedFoodChains.FoodChainList = new ArrayList<>();
        //Location.getInstance().retrievedFoodChains.FoodChainList = temp;
 
    }

    public WritableImage resterauntIcon(String path) throws IOException
    {
        System.out.println(path);
        BufferedImage BufferedImg = null;
      
        String new_path = System.getProperty("user.dir") +  System.getProperty ("file.separator") + path;
        BufferedImg = ImageIO.read(new File(new_path));
       

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
    public ArrayList<Image> makeImageArray() throws IOException
    {
        ArrayList<Image> logos = new ArrayList<>();
        for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            String rest_logo = Location.getInstance().retrievedFoodChains.FoodChainList.get(i).logo;
            System.out.println(rest_logo);
            WritableImage wr = resterauntIcon(rest_logo);
            logos.add(wr);
        }
        return logos;
    }
    public ObservableList<String> makeRestListArray()
    {
        ObservableList<String> rest_names = FXCollections.observableArrayList();
        for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            String foodchain = Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name;
            rest_names.add(foodchain);
        }
        return rest_names;
    }
    public ArrayList<Image> makeImageArray(String im) throws IOException
    {
        ArrayList<Image> logos = new ArrayList<>();
        for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            if (Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name.equals(im))
            {
                String rest_logo = Location.getInstance().retrievedFoodChains.FoodChainList.get(i).logo;
                System.out.println(rest_logo);
                WritableImage wr = resterauntIcon(rest_logo);
                logos.add(wr);
            }
        }
        return logos;
    }
    public ObservableList<String> makeRestListArray(String rest)
    {
        ObservableList<String> rest_names = FXCollections.observableArrayList();
        for (int i=0; i<Location.getInstance().retrievedFoodChains.FoodChainList.size(); i++)
        {
            if (Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name.equals(rest))
            {
                String foodchain = Location.getInstance().retrievedFoodChains.FoodChainList.get(i).name;
                rest_names.add(foodchain);
            }
        }
        return rest_names;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        items = makeRestListArray();
        rest_list.setItems(items);
        
        try {
            logos = makeImageArray();
        } catch (IOException ex) {
            Logger.getLogger(FoodChainListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  

     
        setList();
        
        rest_list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event)
            {
                selectedString = rest_list.getSelectionModel().getSelectedItem();
                Controller.the_Order = new Order();
                Controller.the_Order.placeOrder(selectedString);
                Menu.getMenu();
                System.out.println(Menu.getInstance().food_chain);
                
                System.out.println("Presentation.FXMLController.LoginScreenController.makelogin()");
                Controller.mainContainer.loadScreen(Controller.placeord, Controller.fxml_name8);
                backctr.setScreen(Controller.placeord);
            }
        });
    }    

    @Override
    public void setScreenParent(BackController screenPage) {
      backctr=screenPage;
    }
    
}
