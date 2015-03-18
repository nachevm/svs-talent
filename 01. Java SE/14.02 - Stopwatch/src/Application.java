import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		Stopwatch stopwatch = new Stopwatch();
		while (true) {
			String s = in.next();
			if (s.equals("start")) {
				stopwatch.start();
			}
			if (s.equals("pause")) {
				stopwatch.pause();
			}
			if (s.equals("resume")) {
				stopwatch.resume();
			}
			if (s.equals("stop")) {
				stopwatch.stop();
				break;
			}
		}
		in.close();
	}

}
