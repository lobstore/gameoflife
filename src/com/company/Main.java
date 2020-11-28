package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
public class Main {
    //num boxes is void X Axis
   static double numCellX = 10;
   //num boxes is void Y Axis
   static double numCellY = 10;
   //num pixels X Axis
   static double x = 129;
    //num pixels Y Axis
   static double y = 63;

    static double middlePointX = 0;
    static double middlePointY = 0;
    //math next generation
    public static void next(Vector<Rect> Rct, double numCellX,double numCellY) {
        Random rnd = new Random();
        int count = 0;
        System.out.println(x + " " +y);
        for (int i = 0; i < Rct.size(); i++) {
                if(i>0){
                    if(i>numCellX-1){

                    }
                }
            }
        }
//Create "universe" with "void" boxes
    public static Vector<Rect> draw(double numCellX, double numCellY,double middlePointX,double middlePointY){
        Vector<Rect> Rct = new Vector<Rect>();
        int index = 0;//длина вестора(количество клеток)
        for (double i = 0; i < numCellX*2; i+=2) {
            for (double k = 0; k < numCellY*2; k+=2) {
                Rct.addElement(new Rect(i+middlePointX, k+middlePointY, 1, 1));
                Rct.get(index).instantiate();//создние "пустых" клеток
                index++;
                }
            }
        return Rct;
        }
    public static void main(String[] args) throws InterruptedException {
        //thread for listening click of keyboard
        Runnable r = ()->{
            while(true) {
                if(StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
                    x += 0.000001;
                    y += 0.0000005;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_X)) {
                    x -= 0.000001;
                    y -= 0.0000005;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_A)) {
                    middlePointX -= 0.000001;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_D)) {
                    middlePointX += 0.000001;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
                    middlePointY += 0.000001;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_S)) {
                    middlePointY -= 0.000001;
                }
            }
        };
        Thread tr = new Thread(r);
        tr.start();

        StdDraw.setCanvasSize(1300, 640);

        StdDraw.setPenRadius(0.0001);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();

        while (true)
        {
            StdDraw.setXscale(0, x);
            StdDraw.setYscale(0, y);
            next(draw(numCellX,numCellY,middlePointX,middlePointY), numCellX,numCellY);
            StdDraw.show();
            //ограничение по фпс 1:1
            try {
                TimeUnit.MILLISECONDS.sleep( 100 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            StdDraw.clear();

        }
   }
}
