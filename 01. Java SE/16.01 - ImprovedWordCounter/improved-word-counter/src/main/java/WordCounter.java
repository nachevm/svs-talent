import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class WordCounter {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		try {
			FileReader file = new FileReader("example.txt");
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;

			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;
				} else {
					String[] words = line.split(" ");
					for (int i = 0; i < words.length; i++) {
						String s = StringUtils.lowerCase(words[i]);
						if (map.containsKey(s)) {
							map.put(s, map.get(s) + 1);
						} else {
							map.put(s, 1);
						}
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
