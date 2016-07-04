package com.bq.corbel.lib.queries.parser;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.bq.corbel.lib.queries.exception.MalformedJsonQueryException;
import com.bq.corbel.lib.queries.request.Search;

import java.util.List;
import java.util.Optional;

/**
 * @author Rubén Carrasco
 *
 */
public class CustomSearchParserTest {

    CustomSearchParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new CustomSearchParser(new ObjectMapper());
    }

    @Test
    public void testParseValidStringWithoutTextField() throws MalformedJsonQueryException {
        String searchString = "batman";
        Search search = parser.parse(searchString, false);

        assertThat(search.getText().get()).isEqualTo("batman");
        assertThat(search.getTemplate().isPresent()).isEqualTo(false);
        assertThat(search.getParams().isPresent()).isEqualTo(false);
        assertThat(search.getFields().isPresent()).isEqualTo(false);
        assertThat(search.indexFieldsOnly()).isFalse();
    }

    @Test
    public void testParseValidStringWithTextField() throws MalformedJsonQueryException {
        String searchString = "{\"text\": \"batman\"}";
        Search search = parser.parse(searchString, false);

        assertThat(search.getText().get()).isEqualTo("batman");
        assertThat(search.getTemplate().isPresent()).isEqualTo(false);
        assertThat(search.getParams().isPresent()).isEqualTo(false);
        assertThat(search.getFields().isPresent()).isEqualTo(false);
        assertThat(search.indexFieldsOnly()).isFalse();
    }

    @Test
    public void testParseValidStringWithFields() throws MalformedJsonQueryException {
        String searchString = "{\"text\": \"batman\", \"fields\": [\"title\", \"authors\"]}";
        Search search = parser.parse(searchString, false);

        assertThat(search.getText().get()).isEqualTo("batman");

        List<String> fields = search.getFields().get();
        assertThat(fields).isNotNull();
        assertThat(fields.get(0)).isEqualTo("title");
        assertThat(fields.get(1)).isEqualTo("authors");

        assertThat(search.getTemplate().isPresent()).isEqualTo(false);
        assertThat(search.getParams().isPresent()).isEqualTo(false);
        assertThat(search.indexFieldsOnly()).isFalse();
    }

    @Test
    public void testParseWrongFieldsNameWithTextReturnsFullTextSearch() throws MalformedJsonQueryException {
        // It should be fields, not field
        String searchString = "{\"text\": \"batman\", \"field\": [\"title\", \"authors\"]}";
        Search search = parser.parse(searchString, false);

        assertThat(search.getText().get()).isEqualTo("batman");
        assertThat(search.getTemplate().isPresent()).isEqualTo(false);
        assertThat(search.getParams().isPresent()).isEqualTo(false);
        assertThat(search.getFields().isPresent()).isEqualTo(false);
        assertThat(search.indexFieldsOnly()).isFalse();
    }

    @Test
    public void testParseWithValidTemplate() throws MalformedJsonQueryException {
        String searchString = "{\"templateName\": \"name\", \"params\": {}}";
        Search search = parser.parse(searchString, true);

        assertThat(search.getTemplate().get()).isEqualTo("name");
        assertThat(search.indexFieldsOnly()).isTrue();
        assertThat(search.getParams().get()).isEmpty();
        assertThat(search.getFields().isPresent()).isEqualTo(false);
        assertThat(search.getText().isPresent()).isEqualTo(false);
    }

    @Test(expected = MalformedJsonQueryException.class)
    public void testParseInvalidTemplateName() throws MalformedJsonQueryException {
        String searchString = "{\"templateName\": {}, \"params\": {}}";
        parser.parse(searchString, true);
    }

    @Test(expected = MalformedJsonQueryException.class)
    public void testParseInvalidTemplateParams() throws MalformedJsonQueryException {
        String searchString = "{\"templateName\": \"name\", \"params\": []}";
        parser.parse(searchString, true);
    }

    @Test(expected = MalformedJsonQueryException.class)
    public void testTemplateSearchWithoutName() throws MalformedJsonQueryException {
        String searchString = "{\"params\": {}}";
        parser.parse(searchString, false);
    }

    @Test(expected = MalformedJsonQueryException.class)
    public void testTemplateSearchWithoutParams() throws MalformedJsonQueryException {
        String searchString = "{\"templateName\": \"name\"}";
        parser.parse(searchString, false);
    }

    @Test(expected = MalformedJsonQueryException.class)
    public void testParseFieldsWithTextString() throws MalformedJsonQueryException {
        String searchString = "{\"fields\": [\"title\", \"authors\"]}";
        Search search = parser.parse(searchString, false);
    }

}
