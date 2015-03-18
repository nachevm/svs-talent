import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	public static ArrayList<Product> getProducts() {

		ArrayList<Product> list = new ArrayList<Product>();

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

		return list;
	}

}
