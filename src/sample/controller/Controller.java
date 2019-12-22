package sample.controller;

import constants.FxmlPaths;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    // для нужного fxml окна
    void load(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void shake(Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(70), node);
        translateTransition.setFromX(0f);
        translateTransition.setFromY(0f);
        translateTransition.setByX(2f);
        translateTransition.setByY(2f);
        translateTransition.setCycleCount(3);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

        StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(70), (Shape) node);
        strokeTransition.setFromValue(Color.WHITE);
        strokeTransition.setToValue(Color.BLACK);

    }

//    void loadImage(ImageView imageView) {
////        imageView = new ImageView();
//        imageView.setPickOnBounds(true);
//        imageView.setOnMouseClicked((MouseEvent e) -> {
//            imageView.getScene().getWindow().hide();
//
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource(FxmlPaths.STARTGAMEPLAYER));
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));
//                stage.setScene(new Scene(new StackPane(imageView)));
//                stage.show();
//            } catch (IOException n) {
//                n.printStackTrace();
//            }
//        });

//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
//        // use existing window here, don't create a new one:
//        File file = fileChooser.showOpenDialog(imageView.getScene().getWindow());
//        if (file != null) {
//            imageView.setImage(new Image(file.toURI().toString()));
//        }

//    void makeStage(Parent root) {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.showAndWait();
//    }
}

