package com.practice.tank;

import java.awt.Graphics;

public class Explode {
    private int x, y;
    private int step = 0;
    private boolean exploded = false;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isExploded() {
        return exploded;
    }

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    public void paint(Graphics g) {
        if (this.exploded) return;
        g.drawImage(ResourceMgr.explodes[step], x, y, null);
        step++;
        if (step >= ResourceMgr.explodes.length) {
            this.setExploded(true);
        }
    }
}
