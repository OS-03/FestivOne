/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package festivone;

import com.jfoenix.controls.JFXButton;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;





/**
 * FXML Controller class
 *
 * @author owaisshaikh
 */
public class AfterloginController implements Initializable{

     @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private JFXButton logout;

    @FXML
    private AnchorPane slider;

    @FXML
    private DialogPane D1;

    @FXML
    private DialogPane D2;

    @FXML
    private DialogPane D3;

    @FXML
    private DialogPane D4;
    
    @FXML
    private JFXButton buytickets1;

    @FXML
    private JFXButton buytickets2;

    @FXML
    private JFXButton buytickets3;

    @FXML
    private JFXButton buytickets4;

    @FXML
    private JFXButton feedback;

    @FXML
    private JFXButton info;

    @FXML
    private BorderPane mainpage;

    @FXML
    private BorderPane page1;

    @FXML
    private BorderPane page2;

    @FXML
    private BorderPane page3;

    @FXML
    private BorderPane page4;

    @FXML
    private BorderPane page5;

    @FXML
    private JFXButton support;

    @FXML
    private JFXButton trackorders;
    
    @FXML
    private JFXButton mainmenu;
    
    @FXML
    private JFXButton mainmenu1;
    
    @FXML
    private JFXButton mainmenu2;
    
    @FXML
    private JFXButton mainmenu3;
    
    @FXML
    private JFXButton mainmenu4;



    @FXML
    private ComboBox<?> bookingTicket_EventId;

    @FXML
    private DatePicker bookingTicket_date;

    @FXML
    private TextField bookingTicket_firstName;

    @FXML
    private ComboBox<?> bookingTicket_gender;

    @FXML
    private TextField bookingTicket_lastName;

    @FXML
    private ComboBox<?> bookingTicket_location;

    @FXML
    private TextField bookingTicket_phoneNum;

    @FXML
    private Label bookingTicket_sci_EventID;

    @FXML
    private Label bookingTicket_sci_date;

    @FXML
    private Label bookingTicket_sci_firstName;

    @FXML
    private Label bookingTicket_sci_gender;

    @FXML
    private Label bookingTicket_sci_lastName;

    @FXML
    private Label bookingTicket_sci_location;

    @FXML
    private Label bookingTicket_sci_phoneNum;

    @FXML
    private Label bookingTicket_sci_ticketNum;

    @FXML
    private Label bookingTicket_sci_total;

    @FXML
    private Label bookingTicket_sci_type;
    
    @FXML
    private Button bookingTicket_sci_pay;

    @FXML
    private Button bookingTicket_sci_receipt;

    @FXML
    private JFXButton bookingTicket_selectBtn;

    @FXML
    private ComboBox<?> bookingTicket_ticketNum;

    @FXML
    private ComboBox<?> bookingTicket_type;
    
    @FXML
    private BorderPane payment_gateway;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private TableColumn<customerData, String> customers_customerNum;

    @FXML
    private TableColumn<customerData, String> customers_ticketNum;

    @FXML
    private TableColumn<customerData, String> customers_firstName;

    @FXML
    private TableColumn<customerData, String> customers_lastName;

    @FXML
    private TableColumn<customerData, String> customers_gender;

    @FXML
    private TableColumn<customerData, String> customers_phoneNum;

    @FXML
    private TableColumn<customerData, String> customers_EventID;

    @FXML
    private TableColumn<customerData, String> customers_location;

    @FXML
    private TableColumn<customerData, String> customers_type;

    @FXML
    private TableColumn<customerData, String> customers_date;


   
     private Connection connect;
     private PreparedStatement prepare;
     private ResultSet result;
     private Statement statement;
     
    /**
     **/
      public Connection MYSQL() {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn
                   = DriverManager.getConnection("jdbc:mysql://localhost:3306/FestivOne","root","Root123@");
               System.out.println(connect);
            return conn;
            
        } catch (Exception e) {e.printStackTrace();}
        
        return null;
    }
      
    public void handleButtonAction1() throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                     stage.setResizable(false);
                    
                    stage.setScene(scene);
                    // TO SHOW OUR MAIN FORM
                    stage.show();
                    
                    // TO HIDE WINDOW OF LOGIN FORM
                    logout.getScene().getWindow().hide();
    }      
    
    public void handleButtonAction() throws IOException{

       slider.setTranslateX(-196);
       Menu.setOnMouseClicked(event->{
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(slider);
        
         slide.setNode(slider);
         slide.setToX(0);
         slide.play();
         
        slider.setTranslateX(-196);
        
        slide.setOnFinished((ActionEvent e)-> {
        Menu.setVisible(false);
        MenuClose.setVisible(true);
       });
    });
       
       
       MenuClose.setOnMouseClicked(event ->{
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(slider);
        
        slide.setToX(-196);
        slide.play();
        slider.setTranslateX(0);
        
         slide.setOnFinished((ActionEvent e)-> {
        Menu.setVisible(true);
        MenuClose.setVisible(false);
       });
    });
    }
     private int val;
    public void changeForm(ActionEvent event)throws IOException {
               if (event.getSource() == mainpage 
                       || event.getSource() == mainmenu
                       || event.getSource() == mainmenu1
                       || event.getSource() == mainmenu2
                       || event.getSource() == mainmenu3
                       || event.getSource() == mainmenu4)
        {
            page1.setVisible(false);
            mainpage.setVisible(true);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(false);
        } else if (event.getSource() == buytickets1||event.getSource() ==buytickets2||event.getSource() ==buytickets3||event.getSource() ==buytickets4)
        { // THE LOGIN FORM WILL BE VISIBLE
             page1.setVisible(true);
            mainpage.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(false);
           
           if(event.getSource() == buytickets1)
    {
          D1.setVisible(true);
          D2.setVisible(false);
          D3.setVisible(false);
          D4.setVisible(false);
        
    }
            if(event.getSource() == buytickets2)
    {
          D1.setVisible(false);
          D2.setVisible(true);
          D3.setVisible(false);
          D4.setVisible(false);
         
    }
            if(event.getSource() == buytickets3)
    {
          D1.setVisible(false);
          D2.setVisible(false);
          D3.setVisible(true);
          D4.setVisible(false);
     
    }
            if(event.getSource() == buytickets4)
    {
          D1.setVisible(false);
          D2.setVisible(false);
          D3.setVisible(false);
          D4.setVisible(true);
      
    }
    } else if (event.getSource() == trackorders) {
            page1.setVisible(false);
            mainpage.setVisible(false);
            page2.setVisible(true);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(false);
        
          
        } else if (event.getSource() == info) {
          page1.setVisible(false);
            mainpage.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(true);
            page4.setVisible(false);
            page5.setVisible(false);
        }else if (event.getSource() == support) {
          page1.setVisible(false);
            mainpage.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(true);
            page5.setVisible(false);
        } else if (event.getSource() == feedback) {
          page1.setVisible(false);
            mainpage.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(true);
        } 
        
    }
    
    public void getdata()throws IOException{
         alertMessage alert = new alertMessage();
         
         
    }
      
    public void EventIdList(){
      
        String eventD = "SELECT * FROM Event WHERE status = 'Available'";   
        
        connect = MYSQL();
         try{
            prepare = connect.prepareStatement(eventD);
            result = prepare.executeQuery();
           
            
            ObservableList listB = FXCollections.observableArrayList();
            
            while(result.next()){
                
                listB.add(result.getString("Event_id"));
            }
            bookingTicket_EventId.setItems(listB);
            
            ticketNumList();
            
        }catch(Exception e)
        {e.printStackTrace();}
        
    }
    
    public void LocationList(){
        
        String locationL = "SELECT * FROM Event WHERE status = 'Available'";
        
        connect = MYSQL();
        
        try{
            
            prepare = connect.prepareStatement(locationL);
            result = prepare.executeQuery();
            
            ObservableList listL = FXCollections.observableArrayList();
            
            while(result.next()){
                
                listL.add(result.getString("location"));
            }
            
            bookingTicket_location.setItems(listL);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    private String[] listT = {"BASIC", "PREMIA"};
    
    public void typeList(){
        
        List<String> tList = new ArrayList<>();
        
        for(String data : listT){
            tList.add(data);
        }
        
        ObservableList listType = FXCollections.observableArrayList(tList);
        bookingTicket_type.setItems(listType);
        
    }
    
    public void ticketNumList(){
        List <String> listTicket = new ArrayList<>();
        for(int q = 1; q <= 10; q++){
            listTicket.add(String.valueOf(q));
        }


        String removeSeat = "SELECT seatNum FROM customer WHERE Event_id='"
                +bookingTicket_EventId.getSelectionModel().getSelectedItem()+"'";

        connect = MYSQL();
        
        try{
            prepare = connect.prepareStatement(removeSeat);
            result = prepare.executeQuery();
            
            while(result.next()){
                listTicket.remove(result.getString("seatNum"));
            }
            
            ObservableList listTi = FXCollections.observableArrayList(listTicket);
            
            bookingTicket_ticketNum.setItems(listTi);

        }catch(Exception e){e.printStackTrace();}
    }
    
    private double priceData = 0;
    private double totalP = 0;
    private int flag = 0;
    public void bookingTicketSelect(){
        
        String firstName = bookingTicket_firstName.getText();
        String lastName = bookingTicket_lastName.getText();
        String gender = (String)bookingTicket_gender.getSelectionModel().getSelectedItem();
        String phoneNumber = bookingTicket_phoneNum.getText();
        String date = String.valueOf(bookingTicket_date.getValue());
        String EventId = (String)bookingTicket_EventId.getSelectionModel().getSelectedItem();
        String location = (String)bookingTicket_location.getSelectionModel().getSelectedItem();
        String type = (String)bookingTicket_type.getSelectionModel().getSelectedItem();
        String ticketNum = (String)bookingTicket_ticketNum.getSelectionModel().getSelectedItem();
        
        Alert alert;
        
        if(firstName == null || lastName == null 
                || gender == null || phoneNumber == null || date == null
                || EventId == null || location == null
                || type == null || ticketNum == null){
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            flag=0;
            
        }else{
            
            String totalPrice = "SELECT price FROM Event WHERE location = '"
                    +location+"'";
            
            try{
                
                connect = MYSQL();
                
                prepare = connect.prepareStatement(totalPrice);
                result = prepare.executeQuery();
                
                if(result.next()){
                    priceData = result.getDouble("price");
                }
                
                if(type == "BASIC"){
                    totalP = (priceData);
                }else if(type == "PREMIA"){
                    totalP = priceData; 
                }
            }catch(Exception e){e.printStackTrace();}
            
            bookingTicket_sci_total.setText("$"+String.valueOf(totalP));
            bookingTicket_sci_firstName.setText(firstName);
            bookingTicket_sci_lastName.setText(lastName);
            bookingTicket_sci_gender.setText(gender);
            bookingTicket_sci_phoneNum.setText(phoneNumber);
            bookingTicket_sci_date.setText(date);
            
            bookingTicket_sci_EventID.setText(EventId);
            bookingTicket_sci_location.setText(location);
            bookingTicket_sci_type.setText(type);
            bookingTicket_sci_ticketNum.setText(ticketNum);
            
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Selected!");
            alert.showAndWait();
            flag = 1;
            
            bookingTicketReset();
            
        }
        
    if(flag==1){
             page1.setVisible(false);
            mainpage.setVisible(false);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(false);
            payment_gateway.setVisible(true);
}
    }
    
    public void bookingTicketReset(){
        
        bookingTicket_firstName.setText("");
        bookingTicket_lastName.setText("");
        bookingTicket_gender.getSelectionModel().clearSelection();
        bookingTicket_phoneNum.setText("");
        bookingTicket_date.setValue(null);
        
    }
    
    private String[] genderL = {"Male","Female","Others"};
    
    public void genderList(){
        
        List<String> listG = new ArrayList<>();
        
        for(String data : genderL){
            listG.add(data);
        }
        //Creating Dropdown and showing the arraylist
        ObservableList gList = FXCollections.observableArrayList(listG);
        bookingTicket_gender.setItems(gList);
        
    }
    
    private int countRow;
    private int pay=1;
    public void bookingTicketPay(){
        
        String firstName = bookingTicket_sci_firstName.getText();
        String lastName = bookingTicket_sci_lastName.getText();
        String gender = bookingTicket_sci_gender.getText();
        String phoneNumber = bookingTicket_sci_phoneNum.getText();
        String date = bookingTicket_sci_date.getText();
        String EventId = bookingTicket_sci_EventID.getText();
        String location = bookingTicket_sci_location.getText();
        String type = bookingTicket_sci_type.getText();
        String seatNum = bookingTicket_sci_ticketNum.getText();
        
        String payData = "INSERT INTO customer (customer_id,firstName,lastName,gender,phoneNumber,Event_id,location,type,seatNum,total,date)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        connect = MYSQL();
        
        try{
            
            Alert alert;
            
            String countNum = "SELECT COUNT(id) FROM customer";
            statement = connect.createStatement();
            result = statement.executeQuery(countNum);
            
            while(result.next()){
                countRow = result.getInt("COUNT(id)");
            }
            
//            CHECK IF EMPTY
            if(bookingTicket_sci_firstName.getText().isEmpty()
                    || bookingTicket_sci_lastName.getText().isEmpty()
                    || bookingTicket_sci_gender.getText().isEmpty()
                    || bookingTicket_sci_phoneNum.getText().isEmpty()
                    || bookingTicket_sci_date.getText().isEmpty()
                    || bookingTicket_sci_EventID.getText().isEmpty()
                    || bookingTicket_sci_location.getText().isEmpty()
                    || bookingTicket_sci_type.getText().isEmpty()
                    || bookingTicket_sci_ticketNum.getText().isEmpty()
                    || totalP == 0){
                
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the information first");
                alert.showAndWait();
                pay=0;
                
            }else{
            
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                alert.showAndWait();
 
                prepare = connect.prepareStatement(payData);
                prepare.setString(1, String.valueOf(countRow+1));
                prepare.setString(2, firstName);
                prepare.setString(3, lastName);
                prepare.setString(4, gender);
                prepare.setString(5, phoneNumber);
                prepare.setString(6, EventId);
                prepare.setString(7, location);
                prepare.setString(8, type);
                prepare.setString(9, seatNum);
                prepare.setString(10, String.valueOf(totalP));
                prepare.setString(11, date);
                
                prepare.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Payment Successful!");
                alert.showAndWait();
                bookingTicket_sci_firstName.setText("");
                bookingTicket_sci_lastName.setText("");
                bookingTicket_sci_gender.setText("");
                bookingTicket_sci_phoneNum.setText("");
                bookingTicket_sci_date.setText("");
                bookingTicket_sci_EventID.setText("");
                bookingTicket_sci_location.setText("");
                bookingTicket_sci_type.setText("");
                bookingTicket_sci_ticketNum.setText("");
                bookingTicket_sci_total.setText("$0.0");
                pay=1;
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("REDIRECTING.....!");
                alert.showAndWait();
            }
            if(pay==1)
            {
            page1.setVisible(false);
            mainpage.setVisible(true);
            page2.setVisible(false);
            page3.setVisible(false);
            page4.setVisible(false);
            page5.setVisible(false);
            payment_gateway.setVisible(false);
            }
        }catch(Exception e){e.printStackTrace();}
    }

public ObservableList<customerData> customersDataList(){
        
    //creating observable list
        ObservableList<customerData> customerList = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM customer";
        
        connect = MYSQL();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            customerData custD;
            // with result we get the data from database
            while(result.next()){
                
                custD = new customerData(result.getInt("customer_id")
                        , result.getString("firstName")
                        , result.getString("lastName")
                        , result.getString("gender")
                        , result.getString("phoneNumber")
                        , result.getInt("Event_id")
                        , result.getString("location")
                        , result.getString("type")
                        , result.getInt("seatNum")
                        , result.getDouble("total")
                        , result.getDate("date"));
                
                customerList.add(custD);
                
            }
            
        }catch(Exception e){e.printStackTrace();}
        return customerList;
    }
    
    private ObservableList<customerData> customersDataL;
    public void customersShowDataList(){
        
        customersDataL = customersDataList();
        
        customers_customerNum.setCellValueFactory(new PropertyValueFactory<>("customerNum"));
        customers_ticketNum.setCellValueFactory(new PropertyValueFactory<>("seatNum"));
        customers_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        customers_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        customers_phoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        customers_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        customers_EventID.setCellValueFactory(new PropertyValueFactory<>("EventId"));
        customers_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        customers_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        customers_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        customers_tableView.setItems(customersDataL);
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        LocationList();
        typeList();
        ticketNumList();
        genderList();
        EventIdList();
        
                
        customersShowDataList();
    }
}


    
    


    
    



    

