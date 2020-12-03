package com.zwj.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Constans {
  public static final int pageSize = 10;

  public static final Map<String, String> assessType = new LinkedHashMap<>();


  static {
    initContantsMap();
  }


  private static void initContantsMap() {
    assessType.put("performance", "业绩");
  }
}
