package com.bq.corbel.lib.queries.parser;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.Search;

import java.util.List;

/**
 * @author Rubén Carrasco
 *
 */
public interface SearchParser {
    Search parse(String searchString, boolean indexFieldsOnly) throws MalformedJsonQueryException;
}
