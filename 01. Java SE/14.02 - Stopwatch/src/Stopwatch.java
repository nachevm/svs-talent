import java.util.concurrent.TimeUnit;

public class Stopwatch {

	private int i = 1;
	private boolean stop = false;
	private boolean start = false;
	private boolean paused = false;
	private Runnable stopwatchRunnable = new Runnable() {

		@Override
		public void run() {
			while (!stop) {

				// PAUSE
				while (paused) {
					try {
						synchronized (this) {
							wait();
						}
					} catch (InterruptedException e) {
					}
				}

				// PRINT
				System.out.println(i++);

				// WAIT
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}

	};
	private Thread stopwatchThread = new Thread(stopwatchRunnable);

	public void start() {
		if (!start) {
			stopwatchThread.start();
		}
	}

	public void stop() {
		stop = true;
	}

	public void pause() throws InterruptedException {
		paused = true;
	}

	public void resume() {
		paused = false;
		synchronized (stopwatchRunnable) {
			stopwatchRunnable.notifyAll();
		}
	}

}