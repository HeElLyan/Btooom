package sample.sprite;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Block extends Pane {
    Image blocksImg;
    ImageView block;
    public enum BlockType {
        WALL, FLOWER
    }
    public Block(BlockType blockType, int x, int y) {
        switch (blockType) {
            case WALL:
                setImg("/assets/flowers.png", x, y);
                block.setViewport(new Rectangle2D(0, 0, 30, 30));
                break;
            case FLOWER:
                setImg("/assets/flowers.png", x, y);
                block.setViewport(new Rectangle2D(30, 5, 30, 30));
                break;
        }
        getChildren().add(block);
        Game.platforms.add(this);
        Game.gameRoot.getChildren().add(this);
    }

    void setImg(String image, int x, int y) {
        blocksImg = new Image(getClass().getResourceAsStream(image));
        block = new ImageView(blocksImg);
        block.setFitWidth(Game.BLOCK_SIZE);
        block.setFitHeight(Game.BLOCK_SIZE);
        setTranslateX(x);
        setTranslateY(y);
    }
}
