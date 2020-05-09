package Controller;

import Model.User;
import Utilities.AppointmentUtilities;
import Utilities.Error;
import Utilities.SystemUtilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    @FXML
    private Button ExitButton;

    @FXML
    private Label UsernameLabel;

    @FXML
    private TextField UsernameTxt;

    @FXML
    private Label PasswordLabel;

    @FXML
    private PasswordField PasswordTxt;

    @FXML
    private Button LogInButton;

    Stage stage;
    Parent scene;

    @FXML
    void OnClickExit(MouseEvent event) {
        Error.exitConfirmation();
    }

    @FXML
    void OnClickLogIn(MouseEvent event) throws IOException, SQLException {
        String userName = UsernameTxt.getText();
        String password = PasswordTxt.getText();

        boolean logInSuccessful = SystemUtilities.validateLogIn(userName, password);

        if(logInSuccessful) {
            //Store which user is logged in to system
            User loggedInUser = new User(userName);

            //Log login attempt to log file
            SystemUtilities.log(userName, logInSuccessful);

            //Display Main Screen if login successful
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../View/MainScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

            //Display alert of all appointments within next 15 minutes upon successful login
            appointmentAlert(userName);

        } else {
            //Log login attempt to log file
            SystemUtilities.log(userName, logInSuccessful);

            //Error message for incorrect login credentials
            Error.logInFailed();

            //Error message for incorrect login credentials if user's System language set to Japanese
            if(SystemUtilities.getLanguage() == "ja") {
                Error.logInFailedJapanese();
            }
        }
    }

    //Display alert for appointments happening within 15 minutes of user's login
    private void appointmentAlert(String userName) throws SQLException {
        if(AppointmentUtilities.getAppointmentReminder()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointments Soon");
            alert.setContentText("You have an appointment happening in less than 15 minutes");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Adjust log in screen text to japanese if user System language set to jp
        if(SystemUtilities.getLanguage() == "ja") {
            //Yuzamei
            UsernameLabel.setText("\u3086 \u3056 \u3081 \u3044");

            //Pasuwado
            PasswordLabel.setText("\u3071 \u3059 \u308F \u3069");

            //Roguin
            LogInButton.setText("\u308D \u3050 \u3044 \u3093");

            //Deguchi
            ExitButton.setText("\u3067 \u3050 \u3061");
        }

    }

}
