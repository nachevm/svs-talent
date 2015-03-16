package application;

import alarm.*;
import imageCapture.Console;
import motionDetector.*;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		ArrayList<Alarm> list = new ArrayList<Alarm>();
		list.add(new AlarmChannel());
		list.add(new AlarmChannel());
		ConsoleAdapter c = new ConsoleAdapter(new Console());
		MotionDetector m = new MotionDetectorImpl(c, list);
		m.run();
	}
}
