package com.practice.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank extends AbstractGameObject {
    public static final int SPEED = 3;
    public static int WIDTH = ResourceMgr.badTankU.getWidth();
    public static int HEIGHT = ResourceMgr.badTankU.getHeight();
    //    TankFrame tf;
    private static Random random = new Random();
    private Group grp = Group.BAD;
    private int x, y;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    private boolean moving = true;
    private boolean live = true;
    private int oldX, oldY;
    private Rectangle rect;

    public Tank(int x, int y, Dir dir, Group grp) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.grp = grp;
        oldX = x;
        oldY = y;
        rect = new Rectangle(x, y, WIDTH, HEIGHT);
//        this.tf = tf;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Group getGrp() {
        return grp;
    }

    public void setGrp(Group grp) {
        this.grp = grp;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

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

    public void paint(Graphics g) {
//        g.fillRect(x, y, 50, 50);
        if (!this.isLive()) return;
        switch (dir) {
            case L:
                g.drawImage(ResourceMgr.badTankL, x, y, null);
                break;
            case U:
                g.drawImage(ResourceMgr.badTankU, x, y, null);
                break;
            case R:
                g.drawImage(ResourceMgr.badTankR, x, y, null);
                break;
            case D:
                g.drawImage(ResourceMgr.badTankD, x, y, null);
                break;
        }
        move();
//        }

    }

    private void move() {
        if (!moving) return;
        oldX = x;
        oldY = y;

        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
//            case LU:
//                x -= SPEED;
//                y -= SPEED;
//                break;
//            case LD:
//                x -= SPEED;
//                y += SPEED;
//                break;
//            case RU:
//                x += SPEED;
//                y -= SPEED;
//                break;
//            case RD:
//                x += SPEED;
//                y += SPEED;
//                break;
        }
        boundsCheck();
        randomDir();
        if (random.nextInt(100) > 90) {
            fire();
        }
        rect.x = x;
        rect.y = y;
    }

    private void randomDir() {
        if (random.nextInt(100) > 90) {
            this.dir = Dir.randomDir();
        }
    }


    private void fire() {

        int bx = x + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int by = y + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        TankFrame.INSTANCE.add(new Bullet(bx, by, dir, grp));
    }

    private void boundsCheck() {
        if (x < 0 || y < 30 || x + WIDTH > TankFrame.GAME_WIDTH || y + HEIGHT > TankFrame.GAME_HEIGHT) {
//            live = false;
            this.back();
        }
    }

    public void back() {
        this.x = oldX;
        this.y = oldY;

    }

    public void die() {
        this.setLive(false);
        TankFrame.INSTANCE.add(new Explode(x, y));
    }

}
