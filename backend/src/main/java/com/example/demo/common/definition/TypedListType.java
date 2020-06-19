package com.example.demo.common.definition;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class TypedListType<T extends BaseDefinition> implements UserType, DynamicParameterizedType {

    private String type;
    private Class<?> definitionClass;

    @Override
    public void setParameterValues(Properties parameters) {
        this.type = parameters.getProperty("type");
        try {
            this.definitionClass = Class.forName(parameters.getProperty("definitionClass"));
        } catch (ClassNotFoundException e) {
            this.definitionClass = null;
        }
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }

    @Override
    public Class returnedClass() {
        return this.getClass();
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
        if (definitionClass == null) {
            return null;
        }

        Array array = rs.getArray(names[0]);
        List<BaseDefinition> baseDefinitions = fromDbValues(array);
        //return ArrayUtils.toPrimitive(definitionArray);
        return null;
    }

    private List<BaseDefinition> fromDbValues(Array array) throws SQLException {
        String[] javaArray = (String[]) array.getArray();
        return Arrays.asList(javaArray).stream()
                .map(dbValue -> DefinitionLoaderScanner.getDefinitionByIdForType(dbValue, definitionClass))
                .collect(Collectors.toList());
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (!(value instanceof Collection)) {
            return;
        }

        Connection connection = st.getConnection();
        Array array = connection.createArrayOf(type, getDefinitionsArray((Collection<T>) value));
        st.setArray(index, array);
    }

    private Object[] getDefinitionsArray(Collection<T> value) {
        return toDbValues(value);
    }

    private Object[] toDbValues(Collection<T> data) {
        return data.stream()
                .map(this::toDbValue)
                .toArray();
    }

    private String toDbValue(BaseDefinition definition) {
        return definition.getId().toUpperCase();
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (!(value instanceof Collection)) {
            return null;
        }

        return new ArrayList<>((Collection<T>) value);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
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
