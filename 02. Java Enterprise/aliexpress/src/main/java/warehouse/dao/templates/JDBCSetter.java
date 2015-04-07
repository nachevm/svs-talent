package warehouse.dao.templates;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCSetter {

	<T> T returnQuery(Connection connection) throws SQLException;
}
