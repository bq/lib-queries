package com.bq.corbel.lib.queries.parser;

import com.bq.corbel.lib.queries.request.Pagination;

/**
 * @author Francisco Sanchez
 */
public interface PaginationParser {

    Pagination parse(int page, int pageSize, int maxPageSize);

}
