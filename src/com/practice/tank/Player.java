package com.practice.tank;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {
    public static final int SPEED = 5;
    private Group grp = Group.GOOD;
    private int x, y;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    private boolean moving = false;
    private boolean live = true;
//    TankFrame tf;


    public Player(int x, int y, Dir dir, Group grp) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.grp = grp;
//        this.tf = tf;
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
//        if(this.grp==Group.GOOD){
        switch (dir) {
            case L:
                g.drawImage(ResourceMgr.goodTankL, x, y, null);
                break;
            case U:
                g.drawImage(ResourceMgr.goodTankU, x, y, null);
                break;
            case R:
                g.drawImage(ResourceMgr.goodTankR, x, y, null);
                break;
            case D:
                g.drawImage(ResourceMgr.goodTankD, x, y, null);
                break;
        }
        move();
//        }
//        if(this.grp==Group.BAD){
//            switch (dir) {
//                case L:
//                    g.drawImage(ResourceMgr.badTankL, x, y, null);
//                    break;
//                case U:
//                    g.drawImage(ResourceMgr.badTankU, x, y, null);
//                    break;
//                case R:
//                    g.drawImage(ResourceMgr.badTankR, x, y, null);
//                    break;
//                case D:
//                    g.drawImage(ResourceMgr.badTankD, x, y, null);
//                    break;
//            }
//            move();
//        }

    }


    private void setDirection() {
        moving = bL || bU || bR || bD;
        if (bL && !bU && !bR && !bD) {
            dir = Dir.L;
        }
        if (!bL && bU && !bR && !bD) {
            dir = Dir.U;
        }
        if (!bL && !bU && bR && !bD) {
            dir = Dir.R;
        }
        if (!bL && !bU && !bR && bD) {
            dir = Dir.D;
        }

//        if (bL && bU && !bR && !bD) {
//            dir = Dir.LU;
//        }
//
////        if(!bL && !bU && bR && !bD){
////            dir=com.practice.tank.Dir.LR;
////        }
//
//        if (bL && !bU && !bR && bD) {
//            dir = Dir.LD;
//        }
//
//        if (!bL && !bU && bR && bD) {
//            dir = Dir.RD;
//        }
//        if (!bL && bU && bR && !bD) {
//            dir = Dir.RU;
//        }
    }

    private void move() {
        if (!moving) return;
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
    }

    public void KeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
//                x-=SPEED;
//                dir = com.practice.tank.Dir.L;
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
//                x+=SPEED;
//                dir = com.practice.tank.Dir.R;
                bR = true;
                break;
            case KeyEvent.VK_UP:
//                y-=SPEED;
//                dir = com.practice.tank.Dir.U;
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
//                y+=SPEED;
//                dir = com.practice.tank.Dir.D;
                bD = true;
                break;


        }
        setDirection();

    }


    public void KeyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
//                x-=SPEED;
//                dir = com.practice.tank.Dir.L;
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
//                x+=SPEED;
//                dir = com.practice.tank.Dir.R;
                bR = false;
                break;
            case KeyEvent.VK_UP:
//                y-=SPEED;
//                dir = com.practice.tank.Dir.U;
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
//                y+=SPEED;
//                dir = com.practice.tank.Dir.D;
                bD = false;
                break;
            case KeyEvent.VK_CONTROL:
                fire();
                break;
        }
        setDirection();
    }

    private void fire() {
        int bx = x + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int by = y + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        TankFrame.INSTANCE.addBullet(new Bullet(bx, by, dir, grp));
    }

    public void die() {
        this.setLive(false);
    }

}
