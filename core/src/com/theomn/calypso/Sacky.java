package com.theomn.calypso;

import com.nilunder.bdx.Bdx;
import com.nilunder.bdx.GameObject;


public class Sacky extends GameObject {

  private float jumpVelocity;

  @Override
  public void init() {
    this.jumpVelocity = Registry.INSTANCE.get("sacky_jumpVelocity", 300.0).floatValue();
  }

  @Override
  public void main() {
    // removed the sacky jump thing.
  }
}
