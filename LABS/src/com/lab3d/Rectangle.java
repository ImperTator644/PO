package com.lab3d;

import com.lab3a.Point;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(){
        this.bottomLeft = new Point(0, 0);
        this.topRight = new Point(1,1);
    }

    public Rectangle(Point bL, Point tR){
        this.bottomLeft = bL;
        this.topRight = tR;
    }

    public Rectangle(int bottom, int left, int top, int right){
        this.bottomLeft = new Point(left, bottom);
        this.topRight = new Point(right, top);
    }

    //getters and setters

    public Point getBottomLeft(){
        return this.bottomLeft;
    }
    public Point getTopRight(){
        return this.topRight;
    }
    public int getBottom(){
        return bottomLeft.getY();
    }
    public int getLeft(){
        return bottomLeft.getX();
    }
    public int getTop(){
        return topRight.getY();
    }
    public int getRight(){
        return topRight.getX();
    }
    public void setBottomLeft(Point bl){
        this.bottomLeft = bl;
    }
    public void setTopRight(Point tR){
        this.topRight = tR;
    }
    public void setBottom(int bottom){
        this.bottomLeft.setY(bottom);
    }
    public void setLeft(int left){
        this.bottomLeft.setX(left);
    }
    public void setTop(int top){
        this.topRight.setY(top);
    }
    public void setRight(int right){
        this.topRight.setX(right);
    }

    public int getArea(){
        return (Math.abs(bottomLeft.getX()-topRight.getX()) * Math.abs(bottomLeft.getY()-topRight.getY()));
    }

    @Override public String toString(){
        return ("[(" + getLeft() + "," + getBottom() + "),("
                + getRight() + "," + getTop() + ")]");
    }
}
