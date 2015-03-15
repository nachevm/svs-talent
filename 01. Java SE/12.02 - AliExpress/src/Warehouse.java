import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Warehouse {

	private ArrayList<Product> list;

	public Warehouse() {
		list = new ArrayList<Product>();

		try {
			FileReader file = new FileReader("products.txt");
			BufferedReader buff = new BufferedReader(file);
			String line;

			while ((line = buff.readLine()) != null) {
				String[] w = line.split("\\|");
				list.add(new Product(w[0], w[1], Integer.parseInt(w[2]),
						Integer.parseInt(w[3])));
			}
			buff.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void print() {
		System.out.println("Key \tName \t\tPrice");
		for (Product p : list) {
			System.out.println(p.getKey() + "\t" + p.getName() + "\t"
					+ p.getPrice());
		}
	}

	public Product getProduct(String key, int qty) throws ProductKeyException,
			QtyException {
		for (Product p : list) {
			if (key.equals(p.getKey())) {
				if (p.getQty() >= qty) {
					return p;
				} else {
					throw new QtyException();
				}
			}
		}
		throw new ProductKeyException();
	}
}
