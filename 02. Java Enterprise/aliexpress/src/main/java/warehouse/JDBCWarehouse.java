package warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connections.JDBCConnection;

public class JDBCWarehouse implements Warehouse {

	public List<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM product");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				products.add(new Product(resultSet.getString("key"), resultSet
						.getString("name"), resultSet.getInt("price"),
						resultSet.getInt("quantity")));
			}

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new GenericDBException();
		}
		return products;
	}

	public Product getProduct(String key) throws NoSuchKeyException {
		Product product;
		try {
			Connection connection = JDBCConnection.getLibraryConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM product WHERE key=?");
			preparedStatement.setString(1, key);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product(resultSet.getString("key"),
						resultSet.getString("name"), resultSet.getInt("price"),
						resultSet.getInt("quantity"));
			} else {
				preparedStatement.close();
				connection.close();
				throw new NoSuchKeyException();
			}

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new GenericDBException();
		}
		return product;
	}

}
