package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import constants.FxmlPaths;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ChooseGameController extends Controller{

//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;

    @FXML
    private Button playWithFriend;

    @FXML
    private Button playWithBot;

    @FXML
    private Button backToMenu;

    @FXML
    void initialize() {
        playWithFriend.setOnAction(event -> {
            playWithFriend.getScene().getWindow().hide();
//            load(FxmlPaths.SELECTCHARACTER);
        });

        playWithFriend.setOnMouseEntered(event -> {
            shake(playWithFriend);
        });

        playWithBot.setOnAction(event -> {
            playWithBot.getScene().getWindow().hide();
//            load(FxmlPaths.SELECTCHARACTER);
        });

        playWithBot.setOnMouseEntered(event -> {
            shake(playWithBot);
        });

        backToMenu.setOnAction(event -> {
            backToMenu.getScene().getWindow().hide();
            load(FxmlPaths.MAIN);
        });
    }
}


