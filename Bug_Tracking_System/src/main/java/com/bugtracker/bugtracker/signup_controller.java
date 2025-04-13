package com.bugtracker.bugtracker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class signup_controller extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public ImageView logo;
    public Text logo_text;
    public Text success_text;
    public Button home_button;
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
