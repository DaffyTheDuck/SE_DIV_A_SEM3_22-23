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
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Submit_controller extends Application implements Initializable {

    FileChooser fileChooser = new FileChooser();

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button Submit_button_To_DB;
    public Button home_button;
    public ChoiceBox<String> p_level;

    @Override
    public void start(Stage stage) throws Exception {

    }

    public void toSubmitInDB(ActionEvent a_event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home-page.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) a_event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toHome(ActionEvent a_event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home-page.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) a_event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // code for file chooser
    @FXML
    public void fileChooser(ActionEvent a_event) throws IOException {
        fileChooser.setTitle("Select A File");
        fileChooser.showOpenDialog(stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        p_level.getItems().addAll("Low", "Medium" , "High");
        fileChooser.setInitialDirectory(new java.io.File("C:\\Users\\"));
    }
}
