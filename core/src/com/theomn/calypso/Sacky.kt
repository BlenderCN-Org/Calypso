package com.theomn.calypso

import com.nilunder.bdx.*

class Sacky : GameObject() {

    override fun main() {
        if (Bdx.keyboard.keyHit("space"))
            applyForce(0f, 0f, 300f)
    }

}