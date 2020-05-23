package com.practice.tank;

import com.practice.tank.chainofresponsibility.ColliderChain;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    //    private Bullet bullet;
    public static final int GAME_WIDTH = Integer.parseInt(PropertyMgr.get("gameWidth")), GAME_HEIGHT = Integer.parseInt(PropertyMgr.get("gameHeight"));
    public static final TankFrame INSTANCE = new TankFrame();
    ColliderChain colliderChain = new ColliderChain();
    Image offScreenImage = null;
    //    List<Collider> colliders = null;
//    public static final int SPEED=5;
    private Player myTank;
    //    private Tank enemy;
//    private List<Bullet> bullets;
//    private List<Tank> enemies;
//    private List<Explode> explodes;
    private List<AbstractGameObject> agoList;

    private TankFrame() {
        this.setTitle("tank war");
        this.setLocation(100, 100);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.addKeyListener(new TankKeyListener());
        initObjs();
//        initColliders();
//        this.colliderChain = new ColliderChain();
    }


    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        System.out.println("paint");
//        g.fillRect(x,y,50,50);
//        x+=2;
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("obj:" + agoList.size(), 10, 60);
//        g.drawString("enemies:" + enemies.size(), 10, 80);
//        g.drawString("exploded:" + explodes.size(), 10, 100);
//        g.drawString("tanks:" + tanks.size(), 10, 80);
//        g.drawString("explodes" + explodes.size(), 10, 100);
        g.setColor(c);


        for (int i = 0; i < agoList.size(); i++) {
            AbstractGameObject go1 = agoList.get(i);
            if (!go1.isLive()) {
                agoList.remove(i);
                continue;
            }

            for (int j = 0; j < agoList.size(); j++) {
                AbstractGameObject go2 = agoList.get(j);
                if (!colliderChain.collide(go1, go2)) continue;
//                if (!colliderChain.collide(go1, go2)) {
//                    agoList
//                }
            }

//            if (ago instanceof Bullet) {
//                for (int j = 0; j < agoList.size(); j++) {
//                    if (agoList.get(j) instanceof Tank) {
//                        ((Bullet) ago).collidesWithTank((Tank) agoList.get(j));
//                    }
//                }
//            }
            if (agoList.get(i).isLive()) {
                agoList.get(i).paint(g);
            }
        }
/*
        for (int i = 0; i < enemies.size(); i++) {
            if (!enemies.get(i).isLive()) {
                enemies.remove(i);
            } else {
                enemies.get(i).paint(g);
            }
        }

//        enemy.paint(g);
//        bullet.paint(g);

        for (int i = 0; i < explodes.size(); i++) {
            if (explodes.get(i).isExploded()) {
                explodes.remove(i);
            } else {
                explodes.get(i).paint(g);
            }
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                bullets.get(i).collidesWithTank(enemies.get(j));
            }
            if (!bullets.get(i).isLive()) {
                bullets.remove(i);
            } else {

                bullets.get(i).paint(g);
            }

        }*/
    }


    private void initObjs() {
        myTank = new Player(100, 100, Dir.R, Group.GOOD);
//        bullets = new ArrayList<Bullet>();
//        enemies = new ArrayList<Tank>();
//        explodes = new ArrayList<Explode>();
        agoList = new ArrayList<AbstractGameObject>();
        agoList.add(myTank);
        int enimiesCnt = Integer.parseInt(String.valueOf(PropertyMgr.get("initTankCount")));
        for (int i = 0; i < enimiesCnt; i++) {
            agoList.add(new Tank(100 + 80 * i, 100, Dir.D, Group.BAD));
        }
//        this.add(new Wall(300, 200, 200, 50));
    }

    public void add(AbstractGameObject ago) {
        this.agoList.add(ago);
    }

//    public void addBullet(Bullet bullet) {
//        this.bullets.add(bullet);
//    }

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

//    public void addExplode(Explode ex) {
//        this.explodes.add(ex);
//    }

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
}
