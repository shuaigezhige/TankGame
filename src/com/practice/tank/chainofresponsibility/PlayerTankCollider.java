package com.practice.tank.chainofresponsibility;

import com.practice.tank.AbstractGameObject;
import com.practice.tank.Player;
import com.practice.tank.Tank;

public class PlayerTankCollider implements Collider {
    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if (go1 != go2 && go1 instanceof Tank && go2 instanceof Player) {
            Tank t = (Tank) go1;
            Player p = (Player) go2;
            if (t.isLive()) {
                if (t.getRect().intersects(p.getRect())) {
                    t.back();
                }
            }
        } else if (go1 != go2 && go2 instanceof Tank && go1 instanceof Player) {
            return collide(go2, go1);
        }
        return true;
    }
}
