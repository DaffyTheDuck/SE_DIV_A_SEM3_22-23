package com.bugtracker.bugtracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class login_controller extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Text success_text;
    public Button home_button;
    public ImageView logo;
    public Text logo_text;
    public Button logout_button;

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void toHome(ActionEvent a_event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node) a_event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toLoginPage(ActionEvent a_event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-page.fxml"));
        root = loader.load();
        stage = (Stage)((Node) a_event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}