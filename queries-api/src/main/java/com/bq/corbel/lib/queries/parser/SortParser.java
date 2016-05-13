package com.bq.corbel.lib.queries.parser;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.Sort;

/**
 * @author Francisco Sanchez
 */
public interface SortParser {
    Sort parse(String queryString) throws MalformedJsonQueryException;
}
