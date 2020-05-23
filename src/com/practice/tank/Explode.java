package com.practice.tank;

import java.awt.Graphics;

public class Explode extends AbstractGameObject {
    private int x, y;
    private int step = 0;

    private boolean live = true;

    @Override
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        if (!this.isLive()) return;
        g.drawImage(ResourceMgr.explodes[step], x, y, null);
        step++;
        if (step >= ResourceMgr.explodes.length) {
            this.setLive(false);
        }
    }
}
