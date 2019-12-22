//package sample;
//
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import sample.sprite.Character;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Main extends Application {
//    private HashMap<KeyCode, Boolean> keys;
//    public static ArrayList<Rectangle> bonuses;
//    private Image image;
//    private ImageView imageView;
//    private Character player;
//    public static Pane root;
//
//    public Main() {
//        keys = new HashMap<>();
//        bonuses = new ArrayList<>();
//        image = new Image(getClass().getResourceAsStream("/assets/pony.png"));
//        imageView = new ImageView(image);
//        player = new Character(imageView);
//        root = new Pane();
//    }
//
//    public void bonus(){
//        int random = (int)Math.floor(Math.random()*100);
//        int x = (int)Math.floor(Math.random()*600);
//        int y = (int)Math.floor(Math.random()*600);
//        if(random == 5){
//            Rectangle rect = new Rectangle(20,20, Color.RED);
//            rect.setX(x);
//            rect.setY(y);
//            bonuses.add(rect);
//            root.getChildren().addAll(rect);
//        }
//    }
//    public void update() {
//        if (isPressed(KeyCode.UP)) {
//            player.animation.play();
//            player.animation.setOffsetY(144);
//            player.moveY(-2);
//        } else if (isPressed(KeyCode.DOWN)) {
//            player.animation.play();
//            player.animation.setOffsetY(0);
//            player.moveY(2);
//        } else if (isPressed(KeyCode.RIGHT)) {
//            player.animation.play();
//            player.animation.setOffsetY(96);
//            player.moveX(2);
//        } else if (isPressed(KeyCode.LEFT)) {
//            player.animation.play();
//            player.animation.setOffsetY(48);
//            player.moveX(-2);
//        }
//        else{
//            player.animation.stop();
//        }
//    }
//
//    public boolean isPressed(KeyCode key) {
//        return keys.getOrDefault(key, false);
//    }
//
//
//    //    @Override
////    public void start(Stage primaryStage) throws Exception{
//////        Main.primaryStage = primaryStage;
////        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
////        primaryStage.setTitle("Btooom!");
////        primaryStage.setScene(new Scene(root, 800, 400));
////        primaryStage.show();
////    }
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        root.setPrefSize(800,400);
//        root.getChildren().addAll(player);
//
//        Scene scene = new Scene(root);
//        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
//        scene.setOnKeyReleased(event-> {
//            keys.put(event.getCode(), false);
//        });
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                update();
//                bonus();
//            }
//        };
//        timer.start();
//        primaryStage.setTitle("Btooom!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
