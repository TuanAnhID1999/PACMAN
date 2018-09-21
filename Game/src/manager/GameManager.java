package manager;
import model.Ghost;
import model.MapItem;
import model.Pacmann;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    private ArrayList<MapItem> beans;
    private ArrayList<MapItem> walls;
    private ArrayList<MapItem> fruits;
    private ArrayList<MapItem> readyTitle;

    private Ghost myGhost1;
    private Ghost myGhost2;
    private Ghost myGhost3;
    private Ghost myGhost4;
    private ArrayList<Ghost> ghosts;
    private Pacmann myPacman;
    private PlayerWav playerWavEatBean;
    private PlayerWav playerWavEatFruit;
    private final int MAX_COUNT_PLAYER_WAV_BEAN = 110;
    private final int MAX_COUNT_PLAYER_WAV_FRUIT = 110;
    private final int MAX_COUNT_READY_TITLE = 300;
    private int cyclePlayerWavBean = 0;
    private int cyclePlayerWavFruit = 0;
    private int cycleReadyTitle = 0;
    private final int ACTOR_GHOST_1 = 1;
    private final int ACTOR_GHOST_2 = 2;
    private final int ACTOR_GHOST_3 = 3;
    private final int ACTOR_GHOST_4 = 4;
    private final int ACTOR_PACMAN = 0;

    private static final int ROW = 24;
    private static final int INIT_POSITION_PACMAN_X = 10 * MapItem.SIZE;
    private static final int INIT_POSITION_PACMAN_Y = 18 * MapItem.SIZE;

    private static final int INIT_POSITION_GHOST_1_X = 11 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_1_Y = 10 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_2_X = 9 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_2_Y = 10 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_3_X = 8 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_3_Y = 14 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_4_X = 12 * MapItem.SIZE;
    private static final int INIT_POSITION_GHOST_4_Y = 14 * MapItem.SIZE;

    private final Image[] INIT_IMAGE_GHOST_1 = ImageStore.IMG_ARRAY_BLINKY;
    private final Image[] INIT_IMAGE_GHOST_2 = ImageStore.IMG_ARRAY_CLYDE;
    private final Image[] INIT_IMAGE_GHOST_3 = ImageStore.IMG_ARRAY_INKY;
    private final Image[] INIT_IMAGE_GHOST_4 = ImageStore.IMG_ARRAY_PINKY;

    private boolean isActorCollision = false;

    public GameManager() {
        beans = new ArrayList<MapItem>();
        walls = new ArrayList<MapItem>();
        fruits = new ArrayList<MapItem>();
        readyTitle = new ArrayList<MapItem>();
        myPacman = new Pacmann(INIT_POSITION_PACMAN_X, INIT_POSITION_PACMAN_Y, Pacmann.TURN_RIGHT);

        ghosts = new ArrayList<>();
        myGhost1 = new Ghost(INIT_POSITION_GHOST_1_X, INIT_POSITION_GHOST_1_Y, myPacman, Ghost.TURN_RIGHT, INIT_IMAGE_GHOST_1);
        ghosts.add(myGhost1);
        myGhost2 = new Ghost(INIT_POSITION_GHOST_2_X, INIT_POSITION_GHOST_2_Y, myPacman, Ghost.TURN_LEFT, INIT_IMAGE_GHOST_2);
        ghosts.add(myGhost2);
        myGhost3 = new Ghost(INIT_POSITION_GHOST_3_X, INIT_POSITION_GHOST_3_Y, myPacman, Ghost.TURN_LEFT, INIT_IMAGE_GHOST_3);
        ghosts.add(myGhost3);
        myGhost4 = new Ghost(INIT_POSITION_GHOST_4_X, INIT_POSITION_GHOST_4_Y, myPacman, Ghost.TURN_RIGHT, INIT_IMAGE_GHOST_4);
        ghosts.add(myGhost4);
    }

    public void generateMap() {
        try {
            String path = GameManager.class.getResource("/res/assets/map.txt").getPath();
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            for (int i = 0; i < ROW; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    int type = line.charAt(j) - 48;
                    if (type != 0) {
                        int x = j * MapItem.SIZE;
                        int y = i * MapItem.SIZE;
                        MapItem mapItem = new MapItem(x, y, type);
                        switch (type) {
                            case MapItem.TYPE_BEAN1:
                                beans.add(mapItem);
                                break;

                            case MapItem.TYPE_APPLE:
                            case MapItem.TYPE_PINEAPPLE:
                            case MapItem.TYPE_CHERRY:
                            case MapItem.TYPE_STRAWBERRY:
                                fruits.add(mapItem);
                                break;

                            case MapItem.TYPE_BRIGDE:
                            case MapItem.TYPE_WALL:
                                walls.add(mapItem);
                                break;

                            case MapItem.TYPE_READY:
                                readyTitle.add(mapItem);
                                break;

                            default:
                                break;
                        }
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBean(Graphics2D graphics2D) {
        if (beans.size() >= 1) {
            for (int i = 0; i < beans.size(); i++) {
                beans.get(i).draw(graphics2D);
            }
        }
    }

    public void drawFruit(Graphics2D graphics2D) {
        for (int i = 0; i < fruits.size(); i++) {
            fruits.get(i).draw(graphics2D);
        }
    }

    public void drawWalls(Graphics2D graphics2D) {
        for (int i = 0; i < walls.size(); i++) {
            walls.get(i).draw(graphics2D);
        }
    }

    public void drawReadyTitle(Graphics2D graphics2D) {
        if (readyTitle.size() >= 1) {
            readyTitle.get(0).draw((graphics2D));
        }
    }

    public void drawPacman(Graphics2D graphics2D) {
        myPacman.draw(graphics2D);
    }

    public void drawGhost(Graphics2D graphics2D) {
        for (int i = 0; i < ghosts.size(); i++) {
            ghosts.get(i).draw(graphics2D);
        }
    }

    public void moveMyGhost() {
        if (isMyActorCanMove(ACTOR_GHOST_1)) {
            myGhost1.move();
            int d = newDirectionForGhost(myGhost1, 0);
            if (d != 0) {
                myGhost1.setDirection(d);
            }
        }
        if (isMyActorCanMove(ACTOR_GHOST_2)) {
            myGhost2.move();
            int dd = newDirectionForGhost(myGhost2, 1);
            if (dd != 0) {
                myGhost2.setDirection(dd);
            }
        }
        if (isMyActorCanMove(ACTOR_GHOST_3)) {
            myGhost3.move();
            int ddd = newDirectionForGhost(myGhost3, 2);
            if (ddd != 0) {
                myGhost3.setDirection(ddd);
            }
        }
        if (isMyActorCanMove(ACTOR_GHOST_4)) {
            myGhost4.move();
            int dddd = newDirectionForGhost(myGhost4, 3);
            if (dddd != 0) {
                myGhost4.setDirection(dddd);
            }
        }
    }

    private int newDirectionForGhost(Ghost ghost, int indexGhostInListGhosts) {
        Rectangle rec = new Rectangle(ghost.getX(), ghost.getY(), ghost.SIZE, ghost.SIZE);
        int newDirection = 0;
        int direc1 = 0;
        int direc2 = 0;
        boolean isHasOtherDirection = true;
        if (ghost.getDirection() == ghost.TURN_RIGHT) {
            if (isCollisionWithAnotherGhost(rec, indexGhostInListGhosts)) {
                isHasOtherDirection = false;
                newDirection = ghost.TURN_LEFT;
            } else {
                rec.setLocation(ghost.getX(), ghost.getY() - 1);            // go_UP
                if (isCollisionForGhost(rec) == false) {
                    direc1 = ghost.GO_UP;
                }
                rec.setLocation(ghost.getX(), ghost.getY() + 1);            // go_DOWN
                if (isCollisionForGhost(rec) == false) {
                    direc2 = ghost.GO_DOWN;
                }
                isHasOtherDirection = true;
            }

        } else if (ghost.getDirection() == ghost.TURN_LEFT) {

            if (isCollisionWithAnotherGhost(rec, indexGhostInListGhosts)) {
                isHasOtherDirection = false;
                newDirection = ghost.TURN_RIGHT;
            } else {
                rec.setLocation(ghost.getX(), ghost.getY() - 1);            // go_UP
                if (isCollisionForGhost(rec) == false) {
                    direc1 = ghost.GO_UP;
                }
                rec.setLocation(ghost.getX(), ghost.getY() + 1);            // go_DOWN
                if (isCollisionForGhost(rec) == false) {
                    direc2 = ghost.GO_DOWN;
                }
                isHasOtherDirection = true;
            }


        } else if (ghost.getDirection() == ghost.GO_UP) {

            if (isCollisionWithAnotherGhost(rec, indexGhostInListGhosts)) {
                isHasOtherDirection = false;
                newDirection = ghost.GO_DOWN;
            } else {
                rec.setLocation(ghost.getX() - 1, ghost.getY());            // go_LEFT
                if (isCollisionForGhost(rec) == false) {
                    direc1 = ghost.TURN_LEFT;
                }
                rec.setLocation(ghost.getX() + 1, ghost.getY());            // go_RIGHT
                if (isCollisionForGhost(rec) == false) {
                    direc2 = ghost.TURN_RIGHT;
                }
                isHasOtherDirection = true;
            }

        } else if (ghost.getDirection() == ghost.GO_DOWN) {

            if (isCollisionWithAnotherGhost(rec, indexGhostInListGhosts)) {
                isHasOtherDirection = false;
                newDirection = ghost.GO_UP;
            } else {
                rec.setLocation(ghost.getX() - 1, ghost.getY());            // go_LEFT
                if (isCollisionForGhost(rec) == false) {
                    direc1 = ghost.TURN_LEFT;
                }
                rec.setLocation(ghost.getX() + 1, ghost.getY());            // go_RIGHT
                if (isCollisionForGhost(rec) == false) {
                    direc2 = ghost.TURN_RIGHT;
                }
                isHasOtherDirection = true;
            }

        }
        if (isHasOtherDirection == true) {
            if (direc1 != 0 && direc2 == 0) {
                newDirection = direc1;
            } else if (direc1 == 0 && direc2 != 0) {
                newDirection = direc2;
            } else if (direc1 != 0 && direc2 != 0) {
                Random random = new Random();
                int d = random.nextInt(2);
                if (d == 0) {
                    newDirection = direc1;
                } else if (d == 1) {
                    newDirection = direc2;
                }
            }
        }
        return newDirection;
    }

    private boolean isCollisionWithAnotherGhost(Rectangle rectangle, int indexGhost) {
        for (int i = 0; i < ghosts.size(); i++) {
            if (i != indexGhost) {
                if (rectangle.intersects(ghosts.get(i).getRectangle())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCollisionForGhost(Rectangle rectangle) {
        for (int i = 0; i < walls.size(); i++) {
            if (rectangle.intersects(walls.get(i).getRectangle())) {
                return true;
            }
        }
        return false;
    }


    public void moveMyPacman() {                                    // khi bam' => truyen vao Orien => gan' orien cho direc => ktra neu di duoc thi di, neu khong giu nguyen direc cu~
        if(isMyPacmanCollisionGhost()==true){
            return;
        }
        int tempDirection = myPacman.getDirection();
        myPacman.setDirection(myPacman.getNextOrientation());
        if (isMyActorCanMove(ACTOR_PACMAN)) {
            if (!isMyPacmanCollisionGhost()) {
                myPacman.move();
            }
        } else {
            myPacman.setDirection(tempDirection);
            if (isMyActorCanMove(ACTOR_PACMAN)) {
                if (!isMyPacmanCollisionGhost()) {
                    myPacman.move();
                }
            }
        }

        if (isMyPacmanCollisionFruits()) {
            if (myPacmanEatFruit()) {
                if (cyclePlayerWavFruit == 0) {
                    playerWavEatFruit = new PlayerWav("pacman_eatfruit");
                    playerWavEatFruit.loop(0);
                    playerWavEatFruit.play();
                    cyclePlayerWavFruit = MAX_COUNT_PLAYER_WAV_FRUIT;
                }
            }
        }

        if (isMyPacmanCollisionBeans()) {
            if (myPacmanEatBean()) {
                if (cyclePlayerWavBean == 0) {
                    playerWavEatBean = new PlayerWav("pacman_chomp");
                    playerWavEatBean.loop(0);
                    playerWavEatBean.play();
                    cyclePlayerWavBean = MAX_COUNT_PLAYER_WAV_BEAN;
                }
            }
        }
    }

    private boolean isMyPacmanCollisionGhost() {
        for (int i = 0; i < ghosts.size(); i++) {
            if (myPacman.getRectangle().intersects(ghosts.get(i).getRectangle())) {
                isActorCollision = true;
                myPacman.setPacmanDie(true);
                return true;
            }
        }
        return false;
    }

    public void countdownCycle() {                     // do thoi gian chay doan nhac EAT BEAN
        if (cyclePlayerWavBean > 0) {
            cyclePlayerWavBean = cyclePlayerWavBean - 1;               // tinh toan sao cho
        } else {
            cyclePlayerWavBean = 0;
        }
        if (cyclePlayerWavFruit > 0) {
            cyclePlayerWavFruit = cyclePlayerWavFruit - 1;               // tinh toan sao cho
        } else {
            cyclePlayerWavFruit = 0;
        }

        if (cycleReadyTitle >= 0) {
            cycleReadyTitle = cycleReadyTitle + 1;                   // thoi gian hien thi Ready title...
            if (cycleReadyTitle == MAX_COUNT_READY_TITLE) {
                readyTitle.remove(0);
                cycleReadyTitle = -1;
            }
        }
    }

    private boolean isMyActorCanMove(int actorType) {                   ///////////////////////////////////////////////////
        if (isMyPacmanCollisionGhost()) {
            isActorCollision = true;
            return false;
        }
        if (isMyActorCollisionWalls(actorType)) {
            return false;
        }
        return true;
    }

    private boolean isMyActorCollisionWalls(int actorType) {
        for (int i = 0; i < walls.size(); i++) {
            if (isMyActorCollision(walls.get(i), actorType)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMyActorCollision(MapItem mapItem, int actorType) {
        if (actorType == ACTOR_PACMAN) {
            if (myPacman.getRectangle().intersects(mapItem.getRectangle())) {
                myPacman.setCountStep(1);
                return true;
            }
        } else if (actorType == ACTOR_GHOST_1) {
            if (myGhost1.getRectangle().intersects(mapItem.getRectangle())) {
                myGhost1.setCountStep(1);
                return true;
            }
        } else if (actorType == ACTOR_GHOST_2) {
            if (myGhost2.getRectangle().intersects(mapItem.getRectangle())) {
                myGhost2.setCountStep(1);
                return true;
            }
        } else if (actorType == ACTOR_GHOST_3) {
            if (myGhost3.getRectangle().intersects(mapItem.getRectangle())) {
                myGhost3.setCountStep(1);
                return true;
            }
        } else if (actorType == ACTOR_GHOST_4) {
            if (myGhost4.getRectangle().intersects(mapItem.getRectangle())) {
                myGhost4.setCountStep(1);
                return true;
            }
        }
        return false;
    }

    private boolean isMyPacmanCollisionBeans() {
        for (int i = 0; i < beans.size(); i++) {
            if (myPacman.getRectangle().intersects(beans.get(i).getRectangle())) {
                myPacman.setBeanWasEatten(i);
                return true;
            }
        }
        return false;
    }

    private boolean myPacmanEatBean() {                     // return true = da an bean => moi bat nhac "an bean"
        Rectangle rectangle;
        int theBean = myPacman.getBeanWasEatten();
        rectangle = myPacman.getRectangle().intersection(beans.get(theBean).getRectangle());
        if (rectangle.getWidth() == 15 || rectangle.getHeight() == 15) {
            beans.remove(theBean);
            myPacman.setTotalBean(1);
            return true;
        }
        return false;
    }

    private boolean isMyPacmanCollisionFruits() {
        for (int i = 0; i < fruits.size(); i++) {
            if (myPacman.getRectangle().intersects(fruits.get(i).getRectangle())) {
                myPacman.setFruitWasEatten(i);
                return true;
            }
        }
        return false;
    }

    private boolean myPacmanEatFruit() {                     // return true = da an bean => moi bat nhac "an fruit"
        Rectangle rectangle;
        int theFruit = myPacman.getFruitWasEatten();
        rectangle = myPacman.getRectangle().intersection(fruits.get(theFruit).getRectangle());
        if (rectangle.getWidth() == 25 || rectangle.getHeight() == 25) {
            fruits.remove(theFruit);
            myPacman.setTotalBean(5);
            return true;
        }
        return false;
    }


    public void changeOrientationMyPacman(int orien) {
        myPacman.setNextOrientation(orien);
    }

    public int getScore() {
        return 100 * myPacman.getTotalBean();
    }

    public boolean isStatusPacmanDie() {
        return myPacman.isPacmanDie();
    }

    public boolean isWin() {
        if (fruits.size() == 0 && beans.size() == 0) {
            return true;
        }
        return false;
    }
}
