package com.theomn.calypso.inst;

import com.badlogic.gdx.utils.JsonValue;
import com.nilunder.bdx.Instantiator;import com.nilunder.bdx.GameObject;
import com.theomn.calypso.*;
public class iScene extends Instantiator {

	public GameObject newObject(JsonValue gobj){
		String name = gobj.name;

		if (gobj.get("class").asString().equals("Player"))
			return new com.theomn.calypso.Player();
		if (gobj.get("class").asString().equals("Sacky"))
			return new com.theomn.calypso.Sacky();

		return super.newObject(gobj);
	}
	
}
