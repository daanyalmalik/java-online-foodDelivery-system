/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.FXMLController;

import BusinessLogic.Controller.BackController;
import BusinessLogic.Controller.ControlledScreenInterface;
import BusinessLogic.Controller.Controller;
import BusinessLogic.User.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Rija Fahim
 */
public class OrderNowScreenController implements Initializable, ControlledScreenInterface
{
   BackController backctr;

    ImageView[] slides1;
    SequentialTransition slideshow ;
    SequentialTransition sequentialTransition = new SequentialTransition();

    @FXML
    private TabPane tabs;

    int counter = 0;
    @FXML
    private JFXDrawer profile;

    @FXML
    private ImageView profile_pic;

    @FXML
    private JFXButton ordernow;

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton changeButton;
    @FXML
    private AnchorPane thepane;
    @FXML
    private ImageView slides;
    @FXML
    private Tab tab1;
    
    @FXML
    private Label welcome;
    @FXML
    void openDrawer(ActionEvent event) {

    }

    @FXML
    void OpenOrderHistory(ActionEvent event) 
    {

    }

    public FadeTransition getFadeTransition(ImageView imageView, double fromValue, double toValue, int durationInMilliseconds) 
    {

      FadeTransition ft = new FadeTransition(Duration.millis(durationInMilliseconds), imageView);
      ft.setFromValue(fromValue);
      ft.setToValue(toValue);
      return ft;

    }
    public void startShow(ImageView sl) 
    {
        counter++;
        
        
        FadeTransition fadeIn = getFadeTransition(sl, 0.0, 1.0, 2000);
        PauseTransition stayOn = new PauseTransition(Duration.millis(2000));
        FadeTransition fadeOut = getFadeTransition(sl, 1.0, 0.0, 2000);

        sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);
        sl.setOpacity(0);

        slideshow.getChildren().add(sequentialTransition); 
        if (counter == 6)
        {
            slideshow.play();
        }
        
    }

    @FXML
    void OrderNowpage(ActionEvent event) throws IOException 
    {
        /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/EnterLocation.fxml"));
        String temp = home_page.toString();
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/
        Controller.mainContainer.loadScreen(Controller.local, Controller.fxml_name6);
        backctr.setScreen(Controller.local);

    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       /* slideshow = new SequentialTransition();
        sequentialTransition = new SequentialTransition();
        String adverts[] = new String[6];
        adverts[0] = "/src/Presentation/images/slide1.png";
        adverts[1] = "/src/Presentation/images/slide2.jpeg";
        adverts[2] = "/src/Presentation/images/slide3.jpg";
        adverts[3] = "/src/Presentation/images/slide4.png";
        adverts[4] = "/src/Presentation/images/slide5.jpg";
        adverts[5] = "/src/Presentation/images/slide6.jpg";

        for (int a=0; a<6; a++)
        {
            BufferedImage BufferedImg2 = null;
            try {
                String file = System.getProperty("user.dir") +  System.getProperty ("file.separator") + adverts[a];
                System.out.println(file);
                BufferedImg2 = ImageIO.read(new File(file));
            } catch (IOException ex) {
                Logger.getLogger(PlaceOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }

            WritableImage wr2 = null;
            if (BufferedImg2!=null)
            {
                wr2 = new WritableImage(BufferedImg2.getWidth(),BufferedImg2.getHeight());
                PixelWriter px = wr2.getPixelWriter();
                for (int i=0; i<BufferedImg2.getWidth(); i++)
                {
                    for (int j=0; j<BufferedImg2.getHeight(); j++)
                    {
                        px.setArgb(i, j, BufferedImg2.getRGB(i,j));
                    }
                }
             
            }
            
            slides.setImage(wr2);
            startShow(slides);
        }   */
        welcome.setText("Welcome, "+ Customer.getInstance().firstname + "! :)");
        ordernow.setStyle("-fx-graphic: url(/Presentation/images/button.png);");
        try {
            tab1.setContent((Node) FXMLLoader.load(this.getClass().getResource("/Presentation/FXML/ViewOrderHistory.fxml")));////this
        } catch (IOException ex) {
            Logger.getLogger(OrderNowScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
           VBox box = FXMLLoader.load(getClass().getResource("/Presentation/FXML/CustomerProfile.fxml"));
           profile.setSidePane(box);
       } catch (IOException ex) {
           Logger.getLogger(OrderNowScreenController.class.getName()).log(Level.SEVERE, null, ex);
       }
        HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition (hamburger);
        burgerTask2.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            burgerTask2.setRate(burgerTask2.getRate()* -1);
            burgerTask2.play();
            
            if(profile.isShown())
            {
                profile.close();
            }
            else
            {
                profile.open();
            }
        });
        
        
       /* if (!Customer.getInstance().pic.equals(""))
        {
        
            BufferedImage BufferedImg = null;
            try {
                String file = System.getProperty("user.dir") +  System.getProperty ("file.separator") + Customer.getInstance().pic;
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
        }*/
    }    
  @Override
    public void setScreenParent(BackController screenPage) {
    backctr=screenPage;  
    }
    @FXML
    void ChangeOrder(ActionEvent event) throws IOException 
    {
        /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/ChangeOrder.fxml"));
        String temp = home_page.toString();
        System.out.println(temp);
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/
         backctr.setScreen(Controller.change);

    }

        @FXML
    void logout(ActionEvent event) throws IOException 
    {
        Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/LoginScreen.fxml"));
        String temp = home_page.toString();
        System.out.println(temp);
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();
    }
    
    @FXML
    void CancelOrder(ActionEvent event) throws IOException 
    {
        /*Parent home_page = FXMLLoader.load(getClass().getResource("/Presentation/FXML/CancelOrder.fxml"));
        String temp = home_page.toString();
        System.out.println(temp);
        Scene home_page_scene = new Scene(home_page);
        Stage S1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        S1.setScene(home_page_scene);
        S1.show();*/
        backctr.setScreen(Controller.cancel);
    }

  
}
