package com.bq.corbel.lib.queries.request;

public interface QueryNode {

    QueryOperator getOperator();

    String getField();

    QueryLiteral<?> getValue();
}
