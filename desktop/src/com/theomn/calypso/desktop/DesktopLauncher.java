package com.theomn.calypso.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theomn.calypso.BdxApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Calypso";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new BdxApp(), config);
	}
}
