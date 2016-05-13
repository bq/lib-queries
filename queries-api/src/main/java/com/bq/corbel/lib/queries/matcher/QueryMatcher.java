package com.bq.corbel.lib.queries.matcher;

import com.bq.corbel.lib.queries.exception.QueryMatchingException;
import com.bq.corbel.lib.queries.request.ResourceQuery;

public interface QueryMatcher {

    boolean matchObject(ResourceQuery resourceQuery, Object object) throws QueryMatchingException;
}
