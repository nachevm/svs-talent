package motionDetector;

import imageCapture.ImageCaptureDevice;
import java.util.ArrayList;
import java.util.Arrays;
import alarm.Alarm;

public class MotionDetectorImpl implements MotionDetector {

	private ImageCaptureDevice imageCaptureDevice;
	private ArrayList<Alarm> list;

	public MotionDetectorImpl(ImageCaptureDevice i, ArrayList<Alarm> l) {
		this.imageCaptureDevice = i;
		this.list = l;
	}

	@Override
	public void run() {
		byte[] firstImg = imageCaptureDevice.read();
		while (firstImg != null) {
			byte[] secondImg = imageCaptureDevice.read();
			if (!Arrays.equals(firstImg, secondImg)) {
				for (Alarm a : list) {
					a.alert();
				}
			}
			firstImg = secondImg;
		}
	}

}
