package com.theomn.calypso;

import java.util.*;

import com.badlogic.gdx.*;

import com.badlogic.gdx.files.FileHandle;
import com.nilunder.bdx.*;

import com.theomn.calypso.Registry;

public class BdxApp implements ApplicationListener {

  @Override
  public void create() {
    Registry.INSTANCE.load(
        Gdx.files.external(".calypso/registry.json")
    );

    Bdx.init();

    Scene.instantiators = new HashMap<String, Instantiator>();
		Scene.instantiators.put("Scene", new com.theomn.calypso.inst.iScene());
    Scene.instantiators.put("Scene", new com.theomn.calypso.inst.iScene());

		Bdx.scenes.add(new Scene("Scene"));

    Bdx.mouse.visible(false);
  }

  @Override
  public void dispose() {
    Registry.INSTANCE.save();

    Bdx.dispose();
  }

  @Override
  public void render() {
    Bdx.main();
    // NOTE: developer escape hatch
    if (Bdx.keyboard.keyHit("esc")) {
      Gdx.app.exit();
    }
  }

  @Override
  public void resize(int width, int height) {
    Bdx.resize(width, height);
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }
}
