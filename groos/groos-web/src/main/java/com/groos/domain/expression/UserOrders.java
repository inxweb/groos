package com.groos.domain.expression;

import com.groos.domain.model.QUser;
import com.mysema.query.types.OrderSpecifier;

public class UserOrders {
	public static OrderSpecifier<String> orderByNameAsc() {
		return QUser.user.name.asc();
	}
}
