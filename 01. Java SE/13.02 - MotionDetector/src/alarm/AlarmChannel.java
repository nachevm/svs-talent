package alarm;

public class AlarmChannel implements Alarm {

	@Override
	public void alert() {
		System.out.println("Alarm!");
	}
}
