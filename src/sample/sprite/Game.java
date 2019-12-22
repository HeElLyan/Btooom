package sample.sprite;

import javafx.animation.AnimationTimer;
import  javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Game extends Application {
    public static ArrayList<Block> platforms = new ArrayList<>();
    private HashMap<KeyCode,Boolean> keys = new HashMap<>();

    Image backgroundImg = new Image(getClass().getResourceAsStream("/assets/background.jpg"));
    public static final int BLOCK_SIZE = 50;
    public static final int PONY_SIZE = 48;

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();

    public Character player =  new Character();
    public int levelNumber = 0;
    public int levelWidth;

    private void initContent(){
        ImageView backgroundIV = new ImageView(backgroundImg);
        backgroundIV.setFitHeight(13*BLOCK_SIZE);
        backgroundIV.setFitWidth(13*BLOCK_SIZE);

        levelWidth = LevelData.levels[levelNumber][0].length()*BLOCK_SIZE;
        for(int i = 0; i < LevelData.levels[levelNumber].length; i++){
            String line = LevelData.levels[levelNumber][i];
            for(int j = 0; j < line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Block wall = new Block(Block.BlockType.WALL, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        Block flower = new Block(Block.BlockType.FLOWER,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                }
            }

        }
        gameRoot.getChildren().add(player);
        appRoot.getChildren().addAll(backgroundIV,gameRoot);
    }

    private void update(){
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(144);
            player.moveY(-2);
        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(48);
            player.moveX(-2);
        }
        else{
            player.animation.stop();
        }
    }
    private boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent();
        Scene scene = new Scene(appRoot,650,650);
        scene.setOnKeyPressed(event-> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
            player.animation.stop();
        });
        primaryStage.setTitle("Btooom!");
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        timer.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
