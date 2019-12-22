package sample.controller;

import constants.FxmlPaths;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller{
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private Button startGameButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button creditsButton;

    @FXML
    private Button quitButton;

    @FXML
    void initialize() {
        startGameButton.setOnAction(event -> {
            startGameButton.getScene().getWindow().hide();
            load(FxmlPaths.SELECTGAME);
        });

//        startGameButton.setOnMouseEntered(event -> {
//            shake(startGameButton);
//        });

        helpButton.setOnAction(event -> {
            helpButton.getScene().getWindow().hide();
            load(FxmlPaths.HELP);
        });

//        helpButton.setOnMouseEntered(event -> {
//            shake(helpButton);
//        });

        creditsButton.setOnAction(event -> {
            creditsButton.getScene().getWindow().hide();
            load(FxmlPaths.CREDITS);
        });

//        creditsButton.setOnMouseEntered(event -> {
//            shake(creditsButton);
//        });

        quitButton.setOnAction(event -> {
            //TODO:method stop: Main.stop()
            System.out.println("QUIT");
        });

//        quitButton.setOnMouseEntered(event -> {
//            shake(quitButton);
//        });
    }
}
