package manager;

import javax.swing.*;
import java.awt.*;

public class ImageStore {
    public static final Image IMG_BEAN1 = getImage("/res/drawable/item/bean_2.png");
    public static final Image IMG_PINEAPPLE = getImage("/res/drawable/item/pineapple.png");
    public static final Image IMG_APPLE = getImage("/res/drawable/item/apple.png");
    public static final Image IMG_CHERRY = getImage("/res/drawable/item/cherry.png");
    public static final Image IMG_STRAWBERRY = getImage("/res/drawable/item/strawberry.png");
    public static final Image IMG_WALL = getImage("/res/drawable/wall/wall.png");
    public static final Image IMG_BRIGDE = getImage("/res/drawable/wall/brigde.png");

    public static final Image IMG_PACMAN_0 = getImage("/res/drawable/pacman/pacman_0.png");

    public static final Image IMG_PACMAN_DIE_1 = getImage("/res/drawable/pacman/pacman_die_1.png");
    public static final Image IMG_PACMAN_DIE_2 = getImage("/res/drawable/pacman/pacman_die_2.png");
    public static final Image IMG_PACMAN_DIE_3 = getImage("/res/drawable/pacman/pacman_die_3.png");
    public static final Image IMG_PACMAN_DIE_4 = getImage("/res/drawable/pacman/pacman_die_4.png");

    public static final Image IMG_PACMAN_DOWN_1 = getImage("/res/drawable/pacman/pacman_down_1.png");
    public static final Image IMG_PACMAN_DOWN_2 = getImage("/res/drawable/pacman/pacman_down_2.png");
    public static final Image IMG_PACMAN_DOWN_3 = getImage("/res/drawable/pacman/pacman_down_3.png");

    public static final Image IMG_PACMAN_TOP_1 = getImage("/res/drawable/pacman/pacman_top_1.png");
    public static final Image IMG_PACMAN_TOP_2 = getImage("/res/drawable/pacman/pacman_top_2.png");
    public static final Image IMG_PACMAN_TOP_3 = getImage("/res/drawable/pacman/pacman_top_3.png");

    public static final Image IMG_PACMAN_RIGHT_1 = getImage("/res/drawable/pacman/pacman_right_1.png");
    public static final Image IMG_PACMAN_RIGHT_2 = getImage("/res/drawable/pacman/pacman_right_2.png");
    public static final Image IMG_PACMAN_RIGHT_3 = getImage("/res/drawable/pacman/pacman_right_3.png");

    public static final Image IMG_PACMAN_LEFT_1 = getImage("/res/drawable/pacman/pacman_left_1.png");
    public static final Image IMG_PACMAN_LEFT_2 = getImage("/res/drawable/pacman/pacman_left_2.png");
    public static final Image IMG_PACMAN_LEFT_3 = getImage("/res/drawable/pacman/pacman_left_3.png");

    public static final Image IMG_TITLE = getImage("/res/drawable/icon/title.png");
    public static final Image IMG_READY = getImage("/res/drawable/icon/ready.png");
    public static final Image IMG_GAMEOVER = getImage("/res/drawable/icon/gameover.png");

    private static final Image IMG_PINKY_1 = getImage("/res/drawable/ghost/pinky_1.png");
    private static final Image IMG_PINKY_2 = getImage("/res/drawable/ghost/pinky_2.png");
    private static final Image IMG_PINKY_3 = getImage("/res/drawable/ghost/pinky_3.png");
    private static final Image IMG_PINKY_4 = getImage("/res/drawable/ghost/pinky_4.png");
    private static final Image IMG_PINKY_5 = getImage("/res/drawable/ghost/pinky_5.png");
    private static final Image IMG_PINKY_6 = getImage("/res/drawable/ghost/pinky_6.png");
    private static final Image IMG_PINKY_7 = getImage("/res/drawable/ghost/pinky_7.png");
    private static final Image IMG_PINKY_8 = getImage("/res/drawable/ghost/pinky_8.png");

    private static final Image IMG_BLINKY_1 = getImage("/res/drawable/ghost/blinky_1.png");
    private static final Image IMG_BLINKY_2 = getImage("/res/drawable/ghost/blinky_2.png");
    private static final Image IMG_BLINKY_3 = getImage("/res/drawable/ghost/blinky_3.png");
    private static final Image IMG_BLINKY_4 = getImage("/res/drawable/ghost/blinky_4.png");
    private static final Image IMG_BLINKY_5 = getImage("/res/drawable/ghost/blinky_5.png");
    private static final Image IMG_BLINKY_6 = getImage("/res/drawable/ghost/blinky_6.png");
    private static final Image IMG_BLINKY_7 = getImage("/res/drawable/ghost/blinky_7.png");
    private static final Image IMG_BLINKY_8 = getImage("/res/drawable/ghost/blinky_8.png");

    private static final Image IMG_CLYDE_1 = getImage("/res/drawable/ghost/clyde_1.png");
    private static final Image IMG_CLYDE_2 = getImage("/res/drawable/ghost/clyde_2.png");
    private static final Image IMG_CLYDE_3 = getImage("/res/drawable/ghost/clyde_3.png");
    private static final Image IMG_CLYDE_4 = getImage("/res/drawable/ghost/clyde_4.png");
    private static final Image IMG_CLYDE_5 = getImage("/res/drawable/ghost/clyde_5.png");
    private static final Image IMG_CLYDE_6 = getImage("/res/drawable/ghost/clyde_6.png");
    private static final Image IMG_CLYDE_7 = getImage("/res/drawable/ghost/clyde_7.png");
    private static final Image IMG_CLYDE_8 = getImage("/res/drawable/ghost/clyde_8.png");

    private static final Image IMG_INKY_1 = getImage("/res/drawable/ghost/inky_1.png");
    private static final Image IMG_INKY_2 = getImage("/res/drawable/ghost/inky_2.png");
    private static final Image IMG_INKY_3 = getImage("/res/drawable/ghost/inky_3.png");
    private static final Image IMG_INKY_4 = getImage("/res/drawable/ghost/inky_4.png");
    private static final Image IMG_INKY_5 = getImage("/res/drawable/ghost/inky_5.png");
    private static final Image IMG_INKY_6 = getImage("/res/drawable/ghost/inky_6.png");
    private static final Image IMG_INKY_7 = getImage("/res/drawable/ghost/inky_7.png");
    private static final Image IMG_INKY_8 = getImage("/res/drawable/ghost/inky_8.png");

    public static final Image IMG_GHOST_DIE1 = getImage("/res/drawable/ghost/ghost_die_1.png");
    public static final Image IMG_GHOST_DIE2 = getImage("/res/drawable/ghost/ghost_die_2.png");

    public static final Image[] IMG_ARRAY_BLINKY = new Image[]{IMG_BLINKY_1,IMG_BLINKY_2,IMG_BLINKY_3,IMG_BLINKY_4,IMG_BLINKY_5,IMG_BLINKY_6,IMG_BLINKY_7,IMG_BLINKY_8};
    public static final Image[] IMG_ARRAY_CLYDE = new Image[]{IMG_CLYDE_1,IMG_CLYDE_2,IMG_CLYDE_3,IMG_CLYDE_4,IMG_CLYDE_5,IMG_CLYDE_6,IMG_CLYDE_7,IMG_CLYDE_8};
    public static final Image[] IMG_ARRAY_INKY = new Image[]{IMG_INKY_1,IMG_INKY_2,IMG_INKY_3,IMG_INKY_4,IMG_INKY_5,IMG_INKY_6,IMG_INKY_7,IMG_INKY_8};
    public static final Image[] IMG_ARRAY_PINKY = new Image[]{IMG_PINKY_1,IMG_PINKY_2,IMG_PINKY_3,IMG_PINKY_4,IMG_PINKY_5,IMG_PINKY_6,IMG_PINKY_7,IMG_PINKY_8};

    private static Image getImage(String path){     // da la static => phg thuc static <=> phai sd thuoc tinh static
        return new ImageIcon(ImageStore.class.getResource(path)).getImage();
    }
}
