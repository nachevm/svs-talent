import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class WordCounter {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		try {
			FileReader file = new FileReader("example.txt");
			BufferedReader buff = new BufferedReader(file);

			String line;
			while ((line = buff.readLine()) != null) {
				String[] words = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (map.containsKey(words[i])) {
						map.put(words[i], map.get(words[i]) + 1);
					} else {
						map.put(words[i], 1);
					}
				}
			}
			buff.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Iterator<String> keySetIterator = map.keySet().iterator();

		while (keySetIterator.hasNext()) {
			String key = keySetIterator.next();
			System.out.println(key + ": " + map.get(key));
		}

	}

}
