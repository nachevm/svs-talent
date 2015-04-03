package logging;

public class ConsoleLogger implements Logger {

	public void log(String s) {
		System.out.println(s);
	}
}
