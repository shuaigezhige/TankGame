package com.practice.tank.strategy;

import com.practice.tank.Bullet;
import com.practice.tank.Dir;
import com.practice.tank.Player;
import com.practice.tank.ResourceMgr;
import com.practice.tank.TankFrame;

public class FourDirectionFireStrategy implements FireStrategy {
    @Override
    public void fire(Player p) {
        int bx = p.getX() + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2;
        int by = p.getY() + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2;
        Dir[] dirs = Dir.values();
        for (Dir d : dirs) {
            TankFrame.INSTANCE.add(new Bullet(bx, by, d, p.getGrp()));
        }
    }

}
