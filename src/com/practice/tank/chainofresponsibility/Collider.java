package com.practice.tank.chainofresponsibility;

import com.practice.tank.AbstractGameObject;

public interface Collider {
    boolean collide(AbstractGameObject go1, AbstractGameObject go2);

}
