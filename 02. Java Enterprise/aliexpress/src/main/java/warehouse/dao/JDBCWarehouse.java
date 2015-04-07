package warehouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import warehouse.Product;
import warehouse.dao.templates.JDBCSetter;
import warehouse.dao.templates.JDBCTemplate;

public class JDBCWarehouse implements Warehouse {

	public List<Product> getProducts() {

		return new JDBCTemplate().returnQuery(new JDBCSetter() {

			@SuppressWarnings("unchecked")
			public List<Product> returnQuery(Connection connection)
					throws SQLException {
				ArrayList<Product> products = new ArrayList<Product>();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM product");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					products.add(new Product(resultSet.getString("key"),
							resultSet.getString("name"), resultSet
									.getInt("price"), resultSet
									.getInt("quantity")));
				}
				preparedStatement.close();
				return products;
			}

		});

	}

	public Product getProduct(final String key) {

		return new JDBCTemplate().returnQuery(new JDBCSetter() {

			@SuppressWarnings("unchecked")
			public Product returnQuery(Connection connection)
					throws SQLException {
				Product product = null;
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM product WHERE key=?");
				preparedStatement.setString(1, key);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					product = new Product(resultSet.getString("key"), resultSet
							.getString("name"), resultSet.getInt("price"),
							resultSet.getInt("quantity"));
				}
				preparedStatement.close();
				return product;
			}

		});

	}

}
