package com.theomn.calypso;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;

import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;

/**
 * Player
 *
 * The player class is, at this point not much beyond a simple camera controller.
 *
 * There should only be 1 player object in the game. I don't know how to enforce that
 * in BDX at the moment so fuck it.
 *
 * Any other player related game mechanics probably live in here or a component attached
 * to this.
 *
 * NOTE: Maybe we want to name this something other than "Player".
 *
 */
public class Player extends GameObject {

  private Vector2f lastMousePos;
  private boolean invertMouseLook;
  private float moveSpeed;
  private float lookSpeed;

  @Override
  public void init() {
    invertMouseLook = Registry.INSTANCE.get("player_invertMouseLook", false);
    moveSpeed = Registry.INSTANCE.get("player_moveSpeed", 0.15f);
    lookSpeed = Registry.INSTANCE.get("player_lookSpeed", 0.75f);

    // Snap the scene camera to our position.
    scene.camera.position(this.position());
    // Make the camera a child of this gameobject.
    scene.camera.parent(this);

    Bdx.mouse.cursorLock(true);
    lastMousePos = Bdx.mouse.positionNormalized();
  }

  @Override
  public void main() {
    Vector3f movement = new Vector3f();
    float yaw;
    float pitch;

    ////////////////////////////////////////
    // Mouse input

    // Not sure if there is another way to get relative mouse positions
    Vector2f currentMousePosition = Bdx.mouse.positionNormalized();
    Vector2f deltaMousePosition = lastMousePos.minus(currentMousePosition);

    yaw = deltaMousePosition.getX() * lookSpeed;
    pitch = deltaMousePosition.getY() * lookSpeed;
    if (!invertMouseLook) {
      pitch = -pitch;
    }

    lastMousePos = currentMousePosition;

    ////////////////////////////////////////
    // Keyboard input

    if (Bdx.keyboard.keyDown("w")) {
      // Moving forward
      movement.setY(moveSpeed);
    } else if (Bdx.keyboard.keyDown("s")) {
      // Moving backward
      movement.setY(-moveSpeed);
    }

    if (Bdx.keyboard.keyDown("a")) {
      // Strafing left
      movement.setX(-moveSpeed);
    } else if (Bdx.keyboard.keyDown("d")) {
      // Strafing right
      movement.setX(moveSpeed);
    }


    ////////////////////////////////////////
    // Controller input

    // TODO!

    ////////////////////////////////////////
    // Apply the computed parameters

    // We separate yaw and pitch to prevent weird euler effects.
    scene.camera.rotateLocal(pitch, 0, 0);
    rotate(0, 0, yaw);

    moveLocal(movement);

    ///////////////////////////////////////////////////
    // Note: Determine what the game needs for reals.
    // At the moment this is just a constrained fps
    // style camera. We don't have a player collision
    // object or the ability to jump or fly etc etc.
    ///////////////////////////////////////////////////
  }
}
