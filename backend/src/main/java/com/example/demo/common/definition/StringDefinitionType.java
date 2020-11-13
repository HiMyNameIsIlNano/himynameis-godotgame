package com.example.demo.common.definition;

import com.example.demo.domain.planet.definition.StringBasedDefinition;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class StringDefinitionType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[Types.VARCHAR];
    }

    @Override
    public Class returnedClass() {
        return StringBasedDefinition.class;
    }

    @Override
    public boolean equals(Object x, Object y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(
            ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws SQLException {
        if (rs.wasNull()) {
            return null;
        }

        String itemId = rs.getString(names[0]);
        return new StringBasedDefinition(itemId);
    }

    @Override
    public void nullSafeSet(
            PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws SQLException {
        if (Objects.isNull(value)) {
            st.setNull(index, Types.VARCHAR);
        } else {
            StringBasedDefinition stringBasedDefinition = (StringBasedDefinition) value;
            st.setString(index, stringBasedDefinition.getId());
        }
    }

    @Override
    public Object deepCopy(Object value) {
        if (value == null) {
            return null;
        }

        StringBasedDefinition stringBasedDefinition = (StringBasedDefinition) value;
        return new StringBasedDefinition(stringBasedDefinition.getId());
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return deepCopy(original);
    }
}
