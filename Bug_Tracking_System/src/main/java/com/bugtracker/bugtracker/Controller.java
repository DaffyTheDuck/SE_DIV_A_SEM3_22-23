package com.bugtracker.bugtracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.io.IOException;

public class Controller {
    public static DatabaseConnection databaseConnection = new DatabaseConnection();
    public static Connection connection = databaseConnection.getConnection();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label userNameLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Text orLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button loginWithGithubButton;
    @FXML
    public ImageView logoImageView;
    @FXML
    private Text logoLabel;
    @FXML
    private Text bugTrackerLabel;
    @FXML
    private Line divider;
    String uName;
    String pass;

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(pass.getBytes());
        BigInteger bigInt = new BigInteger(1, messageDigest);
        pass = bigInt.toString(8);
        return pass;
    }

    public void loginToDB(ActionEvent a_event) throws IOException, NoSuchAlgorithmException {

        // password encryption
        uName = userNameTextField.getText();
        pass = passwordTextField.getText();
        pass = encryptPassword(pass);

        try {
            String query = "SELECT * FROM user_auth WHERE userName = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uName);
            preparedStatement.setString(2, pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login-success.fxml"));
                root = loader.load();
                stage = (Stage)((Node) a_event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                System.out.println("Login Successful!");
            } else {
                failedLogin();
                System.out.println("Login Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
    private void failedLogin() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("oops!");
        alert.setHeaderText("Login Failed! username or password doesn't match!");
        alert.showAndWait();
    }

    public void signupToDB(ActionEvent a_event) throws IOException, SQLException, NoSuchAlgorithmException {
        uName = userNameTextField.getText();
        pass = passwordTextField.getText();
        pass = encryptPassword(pass);
        String query = "INSERT INTO user_auth (userName, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, uName);
        preparedStatement.setString(2, pass);
        if (uName.isEmpty() || pass.isEmpty()) {
            System.out.println("Username or password is empty!");
        } else {
            preparedStatement.executeUpdate();
            loadSignupPage(a_event);
        }
    }

    private void loadSignupPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-success.fxml"));
        root = loader.load();
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
