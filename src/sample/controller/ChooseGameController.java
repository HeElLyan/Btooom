package sample.controller;

import constants.FxmlPaths;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.sprite.Main;

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
//        playWithFriend.setOnMouseEntered(event -> {
//            shake(playWithFriend);
//        });

        playWithFriend.setOnAction(event -> {
//            playWithFriend.getScene().getWindow().hide();
//            Main.startGame();
        });

//        playWithBot.setOnMouseEntered(event -> {
//            shake(playWithBot);
//        });

        playWithBot.setOnAction(event -> {
//            playWithBot.getScene().getWindow().hide();
//            Main.startGame();
        });

        backToMenu.setOnAction(event -> {
            backToMenu.getScene().getWindow().hide();
            load(FxmlPaths.MAIN);
        });
    }
}


