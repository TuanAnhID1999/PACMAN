package model;

import java.awt.*;

public class BaseModel {
    protected int x;
    protected int y;
    protected Rectangle rectangle;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

//    public void setRectangle(Rectangle rectangle) {
//        this.rectangle = rectangle;
//    }
}
