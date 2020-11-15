package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
public class Main {
   static double numCellX = 100;
   static double numCellY = 100;
   static double x = 129;
   static double y = 63;

    //подсчет соседей
    public static void next(Vector<Rect> Rct, double numCellX,double numCellY) {
        Random rnd = new Random();//дебагинг :)
        int count = 0;
        System.out.println(Rct.size());//тоже :)
        System.out.println(x + " " +y);
        for (int i = 0; i < Rct.size(); i++) {
                if(i>0){
                    if(i>numCellX-1){

                    }
                }
            }
        }
//Создание "вселенной" из "пустых" клеток
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
        Runnable r = ()->{
            while(true) {
                if(StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
                    x += 0.000001;
                    y += 0.0000005;
                }else if(StdDraw.isKeyPressed(KeyEvent.VK_X)) {
                    x -= 0.000001;
                    y -= 0.0000005;
                }
            }
        };
        Thread tr = new Thread(r);
        tr.start();
        double middlePointX = x/2.0-numCellX/2.0;
        double middlePointY = y/2.0-numCellY/2.0;
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
