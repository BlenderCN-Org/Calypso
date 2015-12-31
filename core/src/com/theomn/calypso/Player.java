package com.theomn.calypso;

import com.nilunder.bdx.GameObject;

/**
 * Created by photex on 31.12.15.
 */
public class Player extends GameObject {

  private float moveSpeed;

  @Override
  public void init() {
    this.moveSpeed = Registry.INSTANCE.get("player_moveSpeed", 4.0f);

    // Snap the scene camera to our position.
    this.scene.camera.position(this.position());
  }

  @Override
  public void main() {
    // TODO: Controls for hcanging the view
  }
}
