package com.theomn.calypso;

import java.util.*;

import com.badlogic.gdx.*;

import com.badlogic.gdx.files.FileHandle;
import com.nilunder.bdx.*;

import com.theomn.calypso.Registry;

public class BdxApp implements ApplicationListener {

  private final FileHandle _registryFile = Gdx.files.external(".calypso/registry.json");

	@Override
	public void create(){
    Registry.INSTANCE.load(this._registryFile);

		Bdx.init();

		Scene.instantiators = new HashMap<String, Instantiator>();
		Scene.instantiators.put("Scene", new com.theomn.calypso.inst.iScene());

		Bdx.scenes.add(new Scene("Scene"));
	}

	@Override
	public void dispose(){
    Registry.INSTANCE.save(this._registryFile);

		Bdx.dispose();
	}

	@Override
	public void render(){
		Bdx.main();
	}

	@Override
	public void resize(int width, int height){
		Bdx.resize(width, height);
	}

	@Override
	public void pause(){
	}

	@Override
	public void resume(){
	}
}
