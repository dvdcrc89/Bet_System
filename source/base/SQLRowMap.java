package base;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class SQLRowMap {

	private Map<String, Object> map;
	private Object value;

	@SuppressWarnings("unchecked")
	public SQLRowMap(Object map) {
		if (map instanceof Map) {
			this.map = (Map<String, Object>) map;
		} else {
			this.value = map;
		}
	}

	public String getString(String key) {
		Object value = getValue(key);
		if (value instanceof Clob) {
			Clob clob = (Clob) value;
			try {
				return clob.getSubString(1, (int) clob.length());
			} catch (SQLException e) {
			}
		}
		return (String) value;
	}

	public Integer getInteger(String key) {
		Object value = getValue(key);
		if (value instanceof Number) {
			return ((Number) value).intValue();
		}
		return (Integer) value;
	}

	public Long getLong(String key) {
		Object value = getValue(key);
		if (value instanceof Number) {
			return ((Number) value).longValue();
		}
		return (Long) value;
	}

	public Float getFloat(String key) {
		Object value = getValue(key);
		if (value instanceof Number) {
			return ((Number) value).floatValue();
		}
		return (Float) value;
	}

	public Double getDouble(String key) {
		Object value = getValue(key);
		if (value instanceof Number) {
			return ((Number) value).doubleValue();
		}
		return (Double) value;
	}

	public Boolean getBoolean(String key) {
		Object value = getValue(key);
		if (value instanceof Number) {
			return ((Number) value).intValue() == 1;
		}
		return (Boolean) value;
	}

	public Date getDate(String key) {
		return (Date) getValue(key);
	}

	public boolean isEmpty() {
		return map == null;
	}

	private Object getValue(String key) {
		if (value != null) {
			return value;
		}
		if (map.containsKey(key)) {
			return map.get(key);
		}
		throw new IllegalArgumentException("Column name " + key + " not found.");
	}

}
