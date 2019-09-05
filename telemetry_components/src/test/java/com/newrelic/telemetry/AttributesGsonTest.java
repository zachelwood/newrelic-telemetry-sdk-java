/*
 * ---------------------------------------------------------------------------------------------
 *   Copyright (c) 2019 New Relic Corporation. All rights reserved.
 *   Licensed under the Apache 2.0 License. See LICENSE in the project root directory for license information.
 *  --------------------------------------------------------------------------------------------
 */

package com.newrelic.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class AttributesGsonTest {

  @Test
  void testEmpty() throws Exception {
    Gson gson = new GsonBuilder().create();
    AttributesGson attributesJson = new AttributesGson(gson);
    assertEquals("{}", attributesJson.toJson(Collections.emptyMap()));
  }

  @Test
  void testSimpleCase() throws Exception {
    Gson gson = new GsonBuilder().create();
    AttributesGson attributesJson = new AttributesGson(gson);
    JSONAssert.assertEquals(
        "{\"foo\":\"bar\"}", attributesJson.toJson(Collections.singletonMap("foo", "bar")), false);
  }
}
