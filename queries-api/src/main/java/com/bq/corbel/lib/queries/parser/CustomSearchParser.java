package com.bq.corbel.lib.queries.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.Search;

/**
 * @author Rubén Carrasco
 *
 */
public class CustomSearchParser implements SearchParser {

    private static final String INVALID_SEARCH_OBJECT = "Invalid Search Object";
    private static final String PARAMS = "params";
    private static final String FIELDS = "fields";
    private static final String TEXT = "text";
    private static final String TEMPLATE_NAME = "templateName";
    private final ObjectMapper mapper;

    public CustomSearchParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Search parse(String searchString, boolean indexFieldsOnly) throws MalformedJsonQueryException {
        try {
            Map<String, Object> map = mapper.readValue(searchString, HashMap.class);
            List<String> fields = (List<String>) map.get(FIELDS);
            String text = (String) map.get(TEXT);

            if(fields != null && text != null) {
                return new Search(indexFieldsOnly, text, fields);
            } else if (text != null) {
                return new Search(indexFieldsOnly, text);
            }
            else {
                return new Search(indexFieldsOnly, getTemplateName(map), getTemplateParams(map));
            }
        } catch (ClassCastException e) {
            throw new MalformedJsonQueryException(e);
        } catch (IOException e) {
            return new Search(indexFieldsOnly, searchString);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> getTemplateParams(Map<String, Object> map) throws MalformedJsonQueryException {
        Map<String, Object> params = (Map<String, Object>) map.get(PARAMS);
        if (params != null) {
            return params;
        } else {
            throw new MalformedJsonQueryException(INVALID_SEARCH_OBJECT);
        }
    }

    private String getTemplateName(Map<String, Object> map) throws MalformedJsonQueryException {
        String name = (String) map.get(TEMPLATE_NAME);
        if (name != null) {
            return name;
        } else {
            throw new MalformedJsonQueryException(INVALID_SEARCH_OBJECT);
        }
    }
}
