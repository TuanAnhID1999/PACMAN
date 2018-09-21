package model;


import manager.ImageStore;

import java.awt.*;

public class Pacmann extends BaseModel {

    private int direction;
    private int countStep = 0;
    private int beanWasEatten = 0;
    private int fruitWasEatten = 0;
    private int totalBean;

    private int nextOrientation = 0;           /// trc khi chay, chuyen huong, neu dc chuyen huong luon

    public static final int SIZE = MapItem.SIZE;
    public static final int TURN_RIGHT = 2;
    public static final int TURN_LEFT = 4;
    public static final int GO_UP = 1;
    public static final int GO_DOWN = 3;
    private boolean isPacmanDie = false;

    public Pacmann(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
        countStep = 1;
    }

    public void draw(Graphics2D graphics2D) {
        switch (direction) {
            case TURN_RIGHT:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_RIGHT_1, x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_RIGHT_2, x, y, SIZE, SIZE, null);
                } else if (countStep > 20 && countStep <= 30) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_RIGHT_3, x, y, SIZE, SIZE, null);
                } else if (countStep > 30 && countStep <= 40) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_0, x, y, SIZE, SIZE, null);
                }
                break;

            case TURN_LEFT:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_LEFT_1, x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_LEFT_2, x, y, SIZE, SIZE, null);
                } else if (countStep > 20 && countStep <= 30) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_LEFT_3, x, y, SIZE, SIZE, null);
                } else if (countStep > 30 && countStep <= 40) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_0, x, y, SIZE, SIZE, null);
                }
                break;

            case GO_UP:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_TOP_1, x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_TOP_2, x, y, SIZE, SIZE, null);
                } else if (countStep > 20 && countStep <= 30) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_TOP_3, x, y, SIZE, SIZE, null);
                } else if (countStep > 30 && countStep <= 40) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_0, x, y, SIZE, SIZE, null);
                }
                break;

            case GO_DOWN:
                if (countStep >= 1 && countStep <= 10) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_DOWN_1, x, y, SIZE, SIZE, null);
                } else if (countStep > 10 && countStep <= 20) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_DOWN_2, x, y, SIZE, SIZE, null);
                } else if (countStep > 20 && countStep <= 30) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_DOWN_3, x, y, SIZE, SIZE, null);
                } else if (countStep > 30 && countStep <= 40) {
                    graphics2D.drawImage(ImageStore.IMG_PACMAN_0, x, y, SIZE, SIZE, null);
                }
                break;

            default:
                break;
        }
    }

    public boolean isPacmanDie() {
        return isPacmanDie;
    }

    public void setPacmanDie(boolean pacmanDie) {
        isPacmanDie = pacmanDie;
    }

    public int getTotalBean() {
        return totalBean;
    }

    public void setTotalBean(int totalBean) {
        this.totalBean = this.totalBean + totalBean;
    }

    public int getNextOrientation() {
        return nextOrientation;
    }

    public void setNextOrientation(int nextOrientation) {
        this.nextOrientation = nextOrientation;
    }

    public void setCountStep(int countStep) {
        this.countStep = countStep;
    }

    public void setBeanWasEatten(int beanWasEatten) {
        this.beanWasEatten = beanWasEatten;
    }

    public int getBeanWasEatten() {
        return beanWasEatten;
    }

    public int getFruitWasEatten() {
        return fruitWasEatten;
    }

    public void setFruitWasEatten(int fruitWasEatten) {
        this.fruitWasEatten = fruitWasEatten;
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
        if (countStep > 40) {
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
