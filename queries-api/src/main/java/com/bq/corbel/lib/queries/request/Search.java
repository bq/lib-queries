package com.bq.corbel.lib.queries.request;

import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @author Francisco Sanchez
 */
public class Search {
    private boolean indexFieldsOnly;
    private Optional<String> text;
    private Optional<List<String>> fields;
    private Optional<String> template;
    private Optional<Map<String, Object>> params;

    public Search(boolean binded, String text, List<String> fields, String template, Map<String, Object> params) {
        this.indexFieldsOnly = binded;
        this.text = Optional.ofNullable(text);
        this.fields = Optional.ofNullable(fields);
        this.template = Optional.ofNullable(template);
        this.params = Optional.ofNullable(params);
    }

    public Search(boolean indexFieldsOnly, String text) {
        this(indexFieldsOnly, text, null, null, null);
    }

    public Search(boolean indexFieldsOnly, String text, List<String> fields) {
        this(indexFieldsOnly, text, fields, null, null);
    }

    public Search(boolean indexFieldsOnly, String template, Map<String, Object> params) {
        this(indexFieldsOnly, null, null, template, params);
    }

    public boolean indexFieldsOnly() {
        return indexFieldsOnly;
    }

    public void setIndexFieldsOnly(boolean indexFieldsOnly) {
        this.indexFieldsOnly = indexFieldsOnly;
    }

    public Optional<String> getText() {
        return text;
    }

    public void setText(Optional<String> text) {
        this.text = text;
    }

    public Optional<List<String>> getFields() {return fields;}

    public void setFields(Optional<List<String>> fields) {this.fields = fields;}

    public Optional<String> getTemplate() {
        return template;
    }

    public void setTemplate(Optional<String> template) {
        this.template = template;
    }

    public Optional<Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(Optional<Map<String, Object>> params) {
        this.params = params;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (indexFieldsOnly ? 1231 : 1237);
        result = prime * result + ((params == null) ? 0 : params.hashCode());
        result = prime * result + ((template == null) ? 0 : template.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Search other = (Search) obj;
        if (indexFieldsOnly != other.indexFieldsOnly) {
            return false;
        }
        if (params == null) {
            if (other.params != null) {
                return false;
            }
        } else if (!params.equals(other.params)) {
            return false;
        }
        if (template == null) {
            if (other.template != null) {
                return false;
            }
        } else if (!template.equals(other.template)) {
            return false;
        }
        if (text == null) {
            if (other.text != null) {
                return false;
            }
        } else if (!text.equals(other.text)) {
            return false;
        }
        if (fields == null) {
            if (other.fields != null) {
                return false;
            }
        } else if (!fields.equals(other.fields)) {
            return false;
        }
        return true;
    }



}
