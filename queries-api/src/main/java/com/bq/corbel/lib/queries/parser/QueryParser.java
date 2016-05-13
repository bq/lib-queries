package com.bq.corbel.lib.queries.parser;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.ResourceQuery;

public interface QueryParser {

    public ResourceQuery parse(String queryString) throws MalformedJsonQueryException;

}
