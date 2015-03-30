package com.bq.oss.lib.queries;

import com.bq.oss.lib.queries.request.QueryLiteral;
import com.bq.oss.lib.queries.exception.QueryMatchingException;

public class BooleanQueryLiteral extends QueryLiteral<Boolean> {

	@Override
	protected boolean eq(Object object) throws QueryMatchingException {
		return literal.equals(object);
	};

	@Override
	protected boolean ne(Object object) throws QueryMatchingException {
		return !literal.equals(object);
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
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
		BooleanQueryLiteral other = (BooleanQueryLiteral) obj;
		if (literal == null) {
			if (other.literal != null) {
				return false;
			}
		} else if (!literal.equals(other.literal)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return Boolean.toString(getLiteral());
	}

}
