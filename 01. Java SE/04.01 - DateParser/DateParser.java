import java.util.StringTokenizer;

public class DateParser {

	public static void main(String[] args) {
		StringTokenizer st;
		String data = "12/04/2007";
		st = new StringTokenizer(data, "/");
		System.out.println("MM: " + st.nextToken());
		System.out.println("DD: " + st.nextToken());
		System.out.println("YY: " + st.nextToken());
	}

}
