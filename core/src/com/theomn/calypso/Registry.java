package com.theomn.calypso;

import com.google.gson.*;
import java.util.HashMap;

public enum Registry {
  INSTANCE;

  private final HashMap<String, Object> _data = new HashMap<String, Object>();

  public final void set(String key, Object value) {
    // TODO
  }
}
