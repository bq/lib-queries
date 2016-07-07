package com.bq.corbel.lib.queries.request;

import java.util.LinkedHashMap;

public class UpdateInc extends LinkedHashMap<String, Number> {

    public UpdateInc() {
        super();
    }

    public UpdateInc(String key, Number value) {
        super();
        put(key, value);
    }

}
