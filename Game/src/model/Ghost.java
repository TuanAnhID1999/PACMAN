package model;



import java.awt.*;
import java.util.Map;

public class Ghost extends BaseModel {

    private int direction;
    private int countStep = 0;
    private Pacmann pacmann;

    public static final int SIZE = MapItem.SIZE;
    public static final int TURN_RIGHT = 2;
    public static final int TURN_LEFT = 4;
    public static final int GO_UP = 1;
    public static final int GO_DOWN = 3;

    private Image[] arrayImageGhost;

    public Ghost(int x, int y, Pacmann pacmann, int direction, Image[] arrayImageGhost) {
        this.pacmann = pacmann;
        this.x = x;
        this.y = y;
        this.direction = direction;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
        countStep = 1;
        this.arrayImageGhost = arrayImageGhost;
    }

    public void draw(Graphics2D graphics2D) {
        switch (direction) {
            case TURN_RIGHT:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(arrayImageGhost[2], x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(arrayImageGhost[3], x, y, SIZE, SIZE, null);
                }
                break;

            case TURN_LEFT:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(arrayImageGhost[6], x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(arrayImageGhost[7], x, y, SIZE, SIZE, null);
                }
                break;

            case GO_UP:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(arrayImageGhost[0], x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(arrayImageGhost[1], x, y, SIZE, SIZE, null);
                }
                break;

            case GO_DOWN:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(arrayImageGhost[4], x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(arrayImageGhost[5], x, y, SIZE, SIZE, null);
                }
                break;

            default:
                break;
        }
    }

    public void setCountStep(int countStep) {
        this.countStep = countStep;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (this.direction != direction) {
            this.direction = direction;
        }
        switch (this.direction) {
            case GO_UP:
                rectangle.setLocation(x, y - 1);
                break;

            case GO_DOWN:
                rectangle.setLocation(x, y + 1);
                break;

            case TURN_LEFT:
                rectangle.setLocation(x - 1, y);
                break;

            case TURN_RIGHT:
                rectangle.setLocation(x + 1, y);
                break;

            default:
                break;
        }
    }

    public void move() {
        countStep++;
        if (countStep > 20) {
            countStep = 0;
        }

        if (direction == TURN_RIGHT) {
            x++;
            if (x >= 21 * MapItem.SIZE - SIZE) {
                if (y == 12 * SIZE) {
                    x = 0;
                } else {
                    x = 21 * MapItem.SIZE - SIZE;
                }
            }
            rectangle.setLocation(x + 1, y);

        } else if (direction == TURN_LEFT) {
            x--;
            if (x <= 0) {
                if (y == 12 * SIZE) {
                    x = 21 * SIZE;
                } else {
                    x = 0;
                }
            }
            rectangle.setLocation(x - 1, y);
        } else if (direction == GO_UP) {
            y--;
            if (y <= 0) {
                y = 0;
            }
            rectangle.setLocation(x, y - 1);
        } else if (direction == GO_DOWN) {
            y++;
            if (y >= 24 * MapItem.SIZE - SIZE) {
                y = 24 * MapItem.SIZE - SIZE;
            }
            rectangle.setLocation(x, y + 1);
        }
    }



}
