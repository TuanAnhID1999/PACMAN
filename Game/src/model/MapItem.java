package model;


import manager.ImageStore;

import java.awt.*;

public class MapItem extends BaseModel {
    private int type;
    public static final int TYPE_BEAN1 = 2;
    public static final int TYPE_PINEAPPLE = 6;
    public static final int TYPE_APPLE = 7;
    public static final int TYPE_CHERRY = 8;
    public static final int TYPE_STRAWBERRY = 9;
    public static final int TYPE_WALL = 1;
    public static final int TYPE_BRIGDE = 5;
    public static final int TYPE_READY = 3;
    public static final int SIZE = 25;

    public int getType() {
        return type;
    }

    public MapItem() {
    }

    public MapItem(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics2D graphics2D) {
        switch (type) {
            case TYPE_BEAN1:
                graphics2D.drawImage(ImageStore.IMG_BEAN1, x, y, SIZE, SIZE, null);
                break;

            case TYPE_APPLE:
                graphics2D.drawImage(ImageStore.IMG_APPLE, x, y, SIZE, SIZE, null);
                break;

            case TYPE_CHERRY:
                graphics2D.drawImage(ImageStore.IMG_CHERRY, x, y, SIZE, SIZE, null);
                break;

            case TYPE_PINEAPPLE:
                graphics2D.drawImage(ImageStore.IMG_PINEAPPLE, x, y, SIZE, SIZE, null);
                break;

            case TYPE_STRAWBERRY:
                graphics2D.drawImage(ImageStore.IMG_STRAWBERRY, x, y, SIZE, SIZE, null);
                break;

            case TYPE_WALL:
                graphics2D.drawImage(ImageStore.IMG_WALL, x, y, SIZE, SIZE, null);
                break;

            case TYPE_BRIGDE:
                graphics2D.drawImage(ImageStore.IMG_BRIGDE, x, y, SIZE, SIZE, null);
                break;

            case TYPE_READY:
                graphics2D.drawImage(ImageStore.IMG_READY, x, y, 3 * SIZE, SIZE, null);
                break;

            default:
                break;
        }
    }


}
