package com.bq.corbel.lib.queries.request;

import java.util.LinkedHashMap;

public class UpdateAddToSet extends LinkedHashMap<String, Object> {

    public UpdateAddToSet() {
        super();
    }

    public UpdateAddToSet(String key, Object value) {
        super();
        put(key, value);
    }

}
