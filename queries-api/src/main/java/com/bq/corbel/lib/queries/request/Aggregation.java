package com.bq.corbel.lib.queries.request;

import java.util.List;

/**
 * @author Rubén Carrasco
 *
 */
public interface Aggregation {

    public List<ResourceQuery> operate(List<ResourceQuery> resourceQueries);

    public AggregationOperator getOperator();
}
