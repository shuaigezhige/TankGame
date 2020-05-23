package com.practice.tank;

import java.awt.Graphics;

public abstract class AbstractGameObject {
    public abstract void paint(Graphics g);

    public abstract boolean isLive();
}
