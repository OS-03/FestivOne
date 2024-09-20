/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.LoginRegisterForgotPass to edit this template
 */
package festivone;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.sql.Statement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;



/**
 * FXML Controller class
 *
 * @author owaisshaikh
 */

public class FXMLController implements Initializable {

    /**
     * Initializes the controller class from set builder.
     * 
     */
    @FXML
    private Button changePass_backBtn;

    @FXML
    private PasswordField changePass_cPassword;

    @FXML
    private BorderPane changePass_form;

    @FXML
    private PasswordField changePass_password;

    @FXML
    private JFXButton changePass_proceedBtn;

    @FXML
    private TextField forgot_answer;

    @FXML
    private JFXButton forgot_backBtn;

    @FXML
    private BorderPane forgot_form;

    @FXML
    private JFXButton forgot_proceedBtn;

    @FXML
    private JFXComboBox<?> forgot_selectQuestion;

    @FXML
    private TextField forgot_username;
   
    @FXML
    private JFXButton login_btn;

    @FXML
    private JFXButton login_createAccount;

    @FXML
    private Hyperlink login_forgotPassword;

    @FXML
    private BorderPane login_form;

    @FXML
    private PasswordField login_password;

    @FXML
    private JFXCheckBox login_selectShowPassword;

    @FXML
    private TextField login_showPassword;

    @FXML
    private TextField login_username;

    @FXML
    private AnchorPane main_form;

   @FXML
    private TextField signup_answer;

    @FXML
    private JFXButton signup_btn;

    @FXML
    private PasswordField signup_cPassword;

    @FXML
    private TextField signup_email;

    @FXML
    private BorderPane signup_form;

    @FXML
    private JFXButton signup_loginAccount;

    @FXML
    private PasswordField signup_password;

    @FXML
    private JFXComboBox<?> signup_selectQuestion;

    @FXML
    private TextField signup_username;

  
     private Connection connect;//
     private PreparedStatement prepare;//
     private ResultSet result;
     private Statement statement;
     
    /**
     *
     * @return
     */
 public Connection MYSQL() {
        try {
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FestivOne","root","Root123@");
               System.out.println(connect);
            return conn;
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return null;
    }

    
  public void login() {

        alertMessage alert = new alertMessage();
      

             // CHECK IF ALL OR SOME OF THE FIELDS ARE EMPTY FOR EACH TEXTFIELD
        if (login_username.getText().isEmpty() || login_password.getText().isEmpty()) {
            alert.errorMessage("Incorrect Username/Password");
        } else { //USING DQL COMMAND
            String selectData = "SELECT * FROM users WHERE "
                    + "username = ? and password = ?"; // Users IS OUR TABLE NAME
              //String user = "Insert into customers(username) values"
              //+ "username=?" ;    
            connect = MYSQL();//CONNECTING THE DATABASE FOR CHECK
            
            if(login_selectShowPassword.isSelected())
            {
                login_password.setText(login_showPassword.getText());
            }
            else
            {
                login_showPassword.setText(login_password.getText());
            }
            
            try {
                prepare = connect.prepareStatement(selectData);
                //prepare = connect.prepareStatement(user);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    // ONCE ALL DATA THAT USERS INSERT ARE CORRECT, THEN WE WILL PROCEED TO OUR MAIN FORM

                    alert.successMessage("Successfully Login!");
                    // TO LINK THE MAIN FORM
                    Parent root = FXMLLoader.load(getClass().getResource("afterlogin.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                     stage.setResizable(false);
                    
                    stage.setScene(scene);
                    // TO SHOW OUR MAIN FORM
                    stage.show();
                    
                    // TO HIDE WINDOW OF LOGIN FORM
                    login_btn.getScene().getWindow().hide();
                    
                } else {
                    // ELSE, THEN ERROR MESSAGE WILL APPEAR
                    alert.errorMessage("Incorrect Username/Password");
                }
            }catch (Exception e) {
                e.printStackTrace();
        }
    }
    }

    public void showPassword() {
  
        if (login_selectShowPassword.isSelected()) {
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_password.setText(login_showPassword.getText());
            login_showPassword.setVisible(false);
            login_password.setVisible(true);
        }

    }

    public void forgotPassword() {

        alertMessage alert = new alertMessage();

        if (    forgot_username.getText().isEmpty()|| forgot_selectQuestion.getSelectionModel().getSelectedItem() == null
                || forgot_answer.getText().isEmpty()) 
        {
            alert.errorMessage("Please fill all blank fields");
        } else {

            String checkData = "SELECT username, question, answer FROM users "
                    + "WHERE username = ? AND question = ? AND answer = ?";

            connect = MYSQL();

            try {

                prepare = connect.prepareStatement(checkData);
                prepare.setString(1, forgot_username.getText());
                prepare.setString(2, (String) forgot_selectQuestion.getSelectionModel().getSelectedItem());
                prepare.setString(3, forgot_answer.getText());

                result = prepare.executeQuery();
                // IF CORRECT
                if (result.next()) {
                    // PROCEED TO CHANGE THE PASSWORD
                    signup_form.setVisible(false);
                    login_form.setVisible(false);
                    forgot_form.setVisible(false);
                    changePass_form.setVisible(true);
                } else {
                    alert.errorMessage("Incorrect information");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    
    public void forgotListQuestion(){
        
        List<String> listQ = new ArrayList<>();
        
        for(String data : questionList){
            listQ.add(data);
        }
        
       ObservableList listData = FXCollections.observableArrayList(listQ);
       forgot_selectQuestion.setItems(listData);
        
    }

    public void register() {

        alertMessage alert = new alertMessage();

        // CHECK IF WE HAVE EMPTY FIELDS
        if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
                || signup_password.getText().isEmpty() || signup_cPassword.getText().isEmpty()
                || signup_selectQuestion.getSelectionModel().getSelectedItem() == null
                || signup_answer.getText().isEmpty()) {
            alert.errorMessage("All fields are necessary to be filled");
        } else if (signup_password.getText() == signup_cPassword.getText()) {
            // CHECK IF THE VALUE OF PASSWORD FIELDS IS EQUAL TO CONFIRM PASSWORD
            alert.errorMessage("Password does not match");
        } else if (signup_password.getText().length() < 5) {
            // CHECK IF THE LENGTH OF PASSWORD VALUE IS LESS THAN TO 5
            //, WE WILL CHECK THE CHARACTERS OF PASSWORD 
            alert.errorMessage("Invalid Password, at least 5 characters needed");
        } else {
            // CHECK IF THE USERNAME IS ALREADY TAKEN
            String checkUsername = "SELECT * FROM users WHERE username = '"
                    + signup_username.getText() + "'";
            connect = MYSQL();
            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    alert.errorMessage(signup_username.getText() + " is already taken");
                } else {

                    String insertData = "INSERT INTO Users "
                            + "(email, username, password, question, answer, date) "
                            + "VALUES(?,?,?,?,?,?)"; // FIVE (?)

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, signup_email.getText());
                    prepare.setString(2, signup_username.getText());
                    prepare.setString(3, signup_password.getText());
                    prepare.setString(4,
                            (String) signup_selectQuestion.getSelectionModel().getSelectedItem());
                    prepare.setString(5, signup_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(6, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert.successMessage("Registered Successfully!");

                    registerClearFields();

                    signup_form.setVisible(false);
                    login_form.setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    

    // TO CLEAR ALL FIELDS OF REGISTRATION FORM
    public void registerClearFields() 
    {
        signup_email.setText("");
        signup_username.setText("");
        signup_password.setText("");
        signup_cPassword.setText("");
        signup_selectQuestion.getSelectionModel().clearSelection();
        signup_answer.setText("");
    }
    
    public void changePassword(){
        
        alertMessage alert = new alertMessage();
        // CHECK ALL FIELDS IF EMPTY OR NOT
        if(changePass_password.getText().isEmpty() || changePass_cPassword.getText().isEmpty()){
            alert.errorMessage("Please fill all blank fields");
        }else if(!changePass_password.getText().equals(changePass_cPassword.getText())){
            // CHECK IF THE PASSWORD AND CONFIRMATION ARE NOT MATCH
            alert.errorMessage("Password does not match");
        }else if(changePass_password.getText().length() < 5){
            // CHECK IF THE LENGTH OF PASSWORD IS LESS THAN TO 5
            alert.errorMessage("Invalid Password, at least 5 characters needed");
        }else{
            // USERNAME IS OUR REFERENCE TO UPDATE THE DATA OF THE USER
            String updateData = "UPDATE Users SET password = ?, update_date = ? "
                    + "WHERE username = '" + forgot_username.getText() + "'";//DL COMMANDS
            
            connect = MYSQL();
            
            try{
                
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, changePass_password.getText());
                
                Date date = new Date();
               java.sql.Date sqlDate;
                sqlDate = new java.sql.Date(date.getTime());
                
                prepare.setString(2, String.valueOf(sqlDate));
                
                prepare.executeUpdate();
                alert.successMessage("Succesfully changed Password");
                
                // LOGIN FORM WILL APPEAR
                signup_form.setVisible(false);
                login_form.setVisible(true);
                forgot_form.setVisible(false);
                changePass_form.setVisible(false);
                
                login_username.setText("");
                login_password.setVisible(true);
                login_password.setText("");
                login_showPassword.setVisible(false);
                login_selectShowPassword.setSelected(false);
                
                changePass_password.setText("");
                changePass_cPassword.setText("");
                
            }catch(Exception e){e.printStackTrace();}
            
        }
        
    }

    public void switchForm(ActionEvent event) {

        // THE REGISTRATION FORM WILL BE VISIBLE WITH RESPECT TO IVOKE BY USER 
        if (event.getSource() == signup_loginAccount || event.getSource() == forgot_backBtn) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);
        } else if (event.getSource() == login_createAccount)
        { // THE LOGIN FORM WILL BE VISIBLE
            signup_form.setVisible(true);
            login_form.setVisible(false);
            forgot_form.setVisible(false);
            changePass_form.setVisible(false);
        } else if (event.getSource() == login_forgotPassword) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forgot_form.setVisible(true);
            changePass_form.setVisible(false);
            // TO SHOW THE DATA TO OUR COMBOBOX
            forgotListQuestion();
        } else if (event.getSource() == changePass_backBtn) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forgot_form.setVisible(true);
            changePass_form.setVisible(false);
        }

    }

    private final String[] questionList = {"What is your favorite food?", "What is your favorite color?",
        "What is the name of your pet?", "What is your most favorite sport?"};

    public void questions() {
        List<String> listQ = new ArrayList<>();

        listQ.addAll(Arrays.asList(questionList));
        ObservableList listData = FXCollections.observableArrayList(listQ);
        signup_selectQuestion.setItems(listData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         questions();
           
        forgotListQuestion();
    }


}

