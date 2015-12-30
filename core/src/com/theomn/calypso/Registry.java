package com.theomn.calypso;

import com.badlogic.gdx.files.FileHandle;
import com.google.gson.*;
import java.util.HashMap;
import com.badlogic.gdx.Gdx;

public enum Registry {
  INSTANCE;



  private final HashMap<String, Object> _data = new HashMap<String, Object>();
  private final HashMap<String, Object> _persistentData = new HashMap<String, Object>();

  /**
   * Sets the thing you drop into this
   * @param key
   * @param value
   */
  public final void set(String key, Object value) {
    this._data.put(key, value);
  }
  
  /**
   * Sets the thing you drop into this into the persistent cache.
   * @param key
   * @param value
   */
  public final void setPersistent(String key, Object value) {
    this._persistentData.put(key, value);
  }

  /**
   * Returns the thing or null yo.
   * Checks the transient cache first, then the persistent cache.
   * @param key
   * @param <T>
   * @return
   */
  public final <T> T get(String key) {
    Object result = this._data.get(key);
    if (result == null) {
      result = this._persistentData.get(key);
    }
    return (T)result;
  }

  /**
   * Writes the persistent registry to disk
   */
  public final void save(FileHandle registryFile) {
    Gson gson = new Gson();
    String contents = gson.toJson(this._persistentData);
    registryFile.writeString(contents, false);
  }

  /**
   * Loads the persistent registry from disk
   */
  public final void load(FileHandle registryFile) {
    Gson gson = new Gson();
    if (registryFile.exists()) {
      String contents = registryFile.readString();
      this._persistentData.putAll(
          gson.fromJson(contents, this._persistentData.getClass())
      );
    }
  }
}
