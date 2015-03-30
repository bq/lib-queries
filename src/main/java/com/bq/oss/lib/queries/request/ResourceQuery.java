package com.bq.oss.lib.queries.request;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceQuery implements Iterable<QueryNode> {

	private final List<QueryNode> conjunctions;

	public ResourceQuery() {
		this.conjunctions = new ArrayList<>();
	}

	public void addQueryNode(QueryNode queryNode) {
		conjunctions.add(queryNode);
	}

	@Override
	public Iterator<QueryNode> iterator() {
		return conjunctions.iterator();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + conjunctions.hashCode();
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
		ResourceQuery other = (ResourceQuery) obj;
		return conjunctions.equals(other.conjunctions);
	}

	@Override
	public String toString() {
		return conjunctions.stream().map(this::parseQueryNode).collect(Collectors.joining(",", "[", "]"));
	}

	private String parseQueryNode(QueryNode query) {
		return "{\"" + query.getOperator().name().toLowerCase() + "\":{\"" + query.getField() + "\":"
				+ query.getValue() + "}}";
	}
}
