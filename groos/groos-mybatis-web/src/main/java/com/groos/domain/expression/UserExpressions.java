package com.groos.domain.expression;

import com.groos.domain.model.QUser;
import com.mysema.query.types.expr.BooleanExpression;

public class UserExpressions {
	public static BooleanExpression lastNameIsLike(final String searchTerm) {
		QUser user = QUser.user; 
		return user.name.like(searchTerm);
	}
}
