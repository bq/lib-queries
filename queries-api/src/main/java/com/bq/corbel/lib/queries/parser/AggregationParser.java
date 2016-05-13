package com.bq.corbel.lib.queries.parser;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.Aggregation;

/**
 * @author Rubén Carrasco
 *
 */
public interface AggregationParser {

    Aggregation parse(String aggregation) throws MalformedJsonQueryException;

}
