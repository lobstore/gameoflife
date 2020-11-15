package com.company;

public class Rect {
    //состояние клетки
    private int neighbour;
    private boolean isalive = false;
    //координаты
    private double xAxis;
    private double yAxis;
    //размер
    private double height;
    private double width;

    Rect(){
        xAxis = 0;
        yAxis = 0;
    }
    Rect(double xAxis, double yAxis, double width,double height){
    this.xAxis = xAxis;
    this.yAxis = yAxis;
    this.height = height;
    this.width = width;
    }
    //геттеры
    public double getxAxis(){
        return xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public boolean isAlive() {
        return isalive;
    }

    public int getNeighbour() {
        return neighbour;
    }

    //сеттеры
    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public void setNeighbour(int neighbour) {
        this.neighbour = neighbour;
    }

    //создание "пустой" клетки
    public void instantiate(){
        StdDraw.rectangle(xAxis,yAxis,width,height);
    }

    //создание живой клетки на тех же координатах
    public void Born(){
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(xAxis,yAxis,width,height);
        isalive = true;
    }
    //смэрть
    public void Death(){
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(xAxis,yAxis,width,height);
        isalive = false;
    }

    public void neighbourIncr(){
        this.neighbour++;
    }

}
