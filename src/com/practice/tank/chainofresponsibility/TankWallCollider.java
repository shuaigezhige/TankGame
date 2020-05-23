package com.practice.tank.chainofresponsibility;

import com.practice.tank.AbstractGameObject;
import com.practice.tank.Tank;
import com.practice.tank.Wall;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Wall) {
            Tank t = (Tank) go1;
            Wall w = (Wall) go2;
            if (t.isLive()) {
                if (t.getRect().intersects(w.getRect())) {
                    t.back();
                }
            }
        } else if (go2 instanceof Tank && go1 instanceof Wall) {
            return collide(go2, go1);
        }
        return true;
    }
}
