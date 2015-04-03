package application;

import warehouse.HibernateWarehouse;
import warehouse.InMemoryWarehouse;
import warehouse.JDBCWarehouse;
import warehouse.Warehouse;
import menu.ConsoleMenu;
import menu.Menu;

public class AliExpressApplication {

	private static int dao = 3; // 1 - InMemory, 2 - JDBC, 3 - Hibernate

	public static void main(String[] args) {
		Warehouse warehouse;
		switch (dao) {
		case 2:
			warehouse = new JDBCWarehouse();
			break;
		case 3:
			warehouse = new HibernateWarehouse();
			break;
		default:
			warehouse = new InMemoryWarehouse();
		}
		Menu menu = new ConsoleMenu(warehouse);
		menu.run();
	}
}
