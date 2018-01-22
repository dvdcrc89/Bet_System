package base;

import java.util.Vector;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;

public class SQLSelect {

	private StringBuilder sb = new StringBuilder(1024);
	private Vector<Column> columns = new Vector<Column>();
	private Vector<Parameter> parameters = new Vector<Parameter>();
	int state = 0;

	public SQLSelect() {
		sb.append("SELECT ");
	}

	public SQLSelect addColumn(String expression, String alias, Type type) {

		if (state == 0) {
			state = 1;
		} else if (state == 1) {
			sb.append(", ");
		} else {
			throw new RuntimeException("Operation not allowed");
		}

		sb.append(expression).append(" ").append("\"" + alias + "\"");

		columns.add(new Column(alias, type));

		return this;
	}

	public SQLSelect addColumn(String expression, String alias) {
		return addColumn(expression, alias, null);
	}

	public SQLSelect addTable(String table) {

		if (state == 1) {
			state = 2;
			sb.append(" FROM ");
		} else if (state == 2) {
			sb.append(" ");
		} else {
			throw new RuntimeException("Operation not allowed");
		}

		sb.append(table);

		return this;
	}

	public SQLSelect addCondition(String condition) {

		if (state == 2) {
			state = 3;
			sb.append(" WHERE ");
		} else if (state == 3) {
			sb.append(" ");
		} else {
			throw new RuntimeException("Operation not allowed");
		}

		sb.append(condition);

		return this;
	}

	public SQLSelect addParameter(String name, Object value) {
		parameters.add(new Parameter(name, value));
		return this;
	}

	public <T> SQLQuery create(Session session, Class<T> target) {

		SQLQuery sql = session.createSQLQuery(sb.toString());

		for (Column column : columns) {
			if (column.type != null) {
				sql.addScalar(column.alias, column.type);
			} else {
				sql.addScalar(column.alias);
			}
		}

		for (Parameter parameter : parameters) {
			sql.setParameter(parameter.name, parameter.value);
		}

		if (target != null) {
			sql.setResultTransformer(Transformers.aliasToBean(target));
		} else {
			sql.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		}

		return sql;
	}

	public <T> SQLQuery create(Session session) {
		return create(session, null);
	}

}

class Column {

	String alias;
	Type type;

	public Column(String alias, Type type) {
		this.alias = alias;
		this.type = type;
	}

}

class Parameter {

	String name;
	Object value;

	public Parameter(String name, Object value) {
		this.name = name;
		this.value = value;
	}

}