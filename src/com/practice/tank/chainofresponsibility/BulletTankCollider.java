package com.practice.tank.chainofresponsibility;

import com.practice.tank.AbstractGameObject;
import com.practice.tank.Bullet;
import com.practice.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof Tank) {
            Bullet b = (Bullet) go1;
            Tank t = (Tank) go2;
//            b.collidesWithTank(t);
            if (!b.isLive() || !t.isLive()) return false;
            if (b.getGroup() == t.getGrp()) return true;

            if (b.getRect().intersects(t.getRect())) {
                b.die();
                t.die();
                return false;
            }
        } else if (go2 instanceof Bullet && go1 instanceof Tank) {
            return collide(go2, go1);
        }
        return true;
    }
}
