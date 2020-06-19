package com.example.demo.common.definition;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public class StringListType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.ARRAY};
    }

    @Override
    public Class<String[]> returnedClass() {
        return String[].class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        // As we are getting a value that is stored in a single column, we can just read the first column
        Array array = rs.getArray(names[0]);
        String[] javaArray = (String[]) array.getArray();
        return ArrayUtils.toPrimitive(javaArray);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Connection connection = st.getConnection();

        String[] castObject = (String[]) value;
        Array array = connection.createArrayOf("text", castObject);

        st.setArray(index, array);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value == null ? null : ((String[]) value).clone();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        Object deepCopy = deepCopy(value);
        if (!(deepCopy instanceof Serializable)) {
            return (Serializable) deepCopy;
        }
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
