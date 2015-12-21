package com.theomn.calypso;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;

public class Sacky extends GameObject {

    public void main () {

        if(Bdx.keyboard.keyHit("space")) {
            applyForce(0, 0, 300);
        }

    }
}
