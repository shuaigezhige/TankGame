package com.practice.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
    private static final int SPEED = 6;
    private int x, y;
    private Dir dir;
    private Group group = Group.BAD;
    private boolean live = true;

    public Bullet(int x, int y, Dir dir, Group grp) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = grp;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void paint(Graphics g) {
        if (!this.isLive()) return;
        switch (dir) {
            case L:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case U:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case R:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case D:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();
    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case D:
                y += SPEED;
                break;
        }

        boundsCheck();
    }

    public void collidesWithTank(Tank tank) {
        if (!this.isLive() || !tank.isLive()) return;
        if (this.group == tank.getGrp()) return;

        Rectangle rectBullet = new Rectangle(x, y, ResourceMgr.bulletU.getWidth(), ResourceMgr.bulletU.getHeight());
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(),
                ResourceMgr.goodTankU.getWidth(), ResourceMgr.goodTankU.getHeight());
        if (rectBullet.intersects(rectTank)) {
            this.die();
            tank.die();
        }
    }

    private void boundsCheck() {
        if (x <= 0 || y <= 30 || x >= TankFrame.GAME_WIDTH || y >= TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public void die() {
        setLive(false);
    }
}
