package com.example.demo.common.definition;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

public class EnumDefinitionType<T extends Enum<T>> extends EnumType<T> {

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws SQLException {
		st.setObject(index, value != null ? ((Enum<?>) value).name() : null, Types.OTHER);
	}
}
