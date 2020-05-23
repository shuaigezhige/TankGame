package com.practice.tank.chainofresponsibility;

import com.practice.tank.AbstractGameObject;
import com.practice.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> colliders;

    public ColliderChain() {
        initColliders();
    }

    private void initColliders() {
        this.colliders = new ArrayList<Collider>();
        Collider colliderObj = null;
        String colliderStr = PropertyMgr.get("colliders");
        String[] liStrName = colliderStr.split(",");
        for (String name : liStrName) {
            try {
                Class cls = Class.forName("com.practice.tank.chainofresponsibility." + name);
                colliderObj = (Collider) cls.getConstructor().newInstance();
                colliders.add(colliderObj);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        for (Collider collider : colliders) {
            if (!collider.collide(go1, go2)) return false;
        }
        return true;
    }
}
