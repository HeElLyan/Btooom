package sample.sprite;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character extends Pane {

    private Image image;
    private ImageView imageView;
    int count = 3;
    int columns = 12;
    int offsetX = 288;
    int offsetY = 0;
    int width = 48;
    int height = 48;
    int score = 0;
    public SpriteAnimation animation;
    public Point2D playerVelocity;
    private boolean bomb = true;

    public Character(){
        this.playerVelocity = new Point2D(0,0);
        this.image = new Image(getClass().getResourceAsStream("/assets/pony.png"));
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(50);
        this.imageView.setFitWidth(50);
        this.imageView.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
        animation = new SpriteAnimation(this.imageView,Duration.millis(700),count,columns,offsetX,offsetY,width,height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int x) {
        boolean right = x > 0 ? true : false;
        for (int i = 0; i < Math.abs(x); i++) {
            for (Node platform : Game.platforms) {
                if (this.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (right) {
                        if (this.getTranslateX() + Game.PONY_SIZE == platform.getTranslateX()) {
                            this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == platform.getTranslateX() + Game.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (right ? 1 : -1));
        }
    }
    public void moveY(int y) {
        boolean down = y > 0 ? true : false;
        for (int i = 0; i < Math.abs(y); i++) {
            for (Node platform : Game.platforms) {
                if (getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (down) {
                        if (this.getTranslateY() + Game.PONY_SIZE == platform.getTranslateY()) {
                            this.setTranslateY(this.getTranslateY() - 1);
                            bomb = true;
                            return;
                        }
                    } else {
                        if (this.getTranslateY() == platform.getTranslateY() + Game.BLOCK_SIZE) {
                            this.setTranslateY(this.getTranslateY() + 1);
                            playerVelocity = new Point2D(0, 10);
                            return;
                        }
                    }
                }
                this.setTranslateY(this.getTranslateY() + (down ? 1 : -1));
                if (this.getTranslateY() > 640) {
                    this.setTranslateX(0);
                    this.setTranslateY(400);
                    Game.gameRoot.setLayoutX(0);
                }
            }
        }
    }

//    public void setBomb(){
//        if(bomb){
//            playerVelocity = playerVelocity.add(0,-30);
//            bomb = false;
//        }
//    }
}
