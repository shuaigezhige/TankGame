package com.practice.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    //    private int x=100; int y=100;
//    public static final int SPEED=5;
    private Tank myTank;
    private Tank enemy;
    private Bullet bullet;
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;


    public TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.addKeyListener(new TankKeyListener());
        myTank = new Tank(100, 100, Dir.R,Group.GOOD,this);
        enemy = new Tank(200, 200, Dir.D,Group.BAD,this);
        bullet =new Bullet(100,100,Dir.D,Group.BAD);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        System.out.println("paint");
//        g.fillRect(x,y,50,50);
//        x+=2;
        myTank.paint(g);
        enemy.paint(g);
        bullet.paint(g);
    }

    public void addBullet(Bullet bullet){
        this.bullet = bullet;
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.KeyReleased(e);
        }
    }

    //    private class TankKeyListener implements KeyListener {
//        @Override
//        public void keyTyped(KeyEvent keyEvent) {
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent keyEvent) {
//
//        }
//
//        @Override
//        public void keyReleased(KeyEvent keyEvent) {
//
//        }
//    }
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
