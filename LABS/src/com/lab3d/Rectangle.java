package com.lab3d;

import com.lab3a.Punkt2D;

public class Rectangle {
    private Punkt2D bottomLeft;
    private Punkt2D topRight;

    public Rectangle(){
        this.bottomLeft = new Punkt2D(0, 0);
        this.topRight = new Punkt2D(1,1);
    }

    public Rectangle(Punkt2D bL, Punkt2D tR){
        this.bottomLeft = bL;
        this.topRight = tR;
    }

    public Rectangle(int bottom, int left, int top, int right){
        this.bottomLeft = new Punkt2D(left, bottom);
        this.topRight = new Punkt2D(right, top);
    }

    //getters and setters

    public Punkt2D getBottomLeft(){
        return this.bottomLeft;
    }
    public Punkt2D getTopRight(){
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
    public void setBottomLeft(Punkt2D bl){
        this.bottomLeft = bl;
    }
    public void setTopRight(Punkt2D tR){
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
