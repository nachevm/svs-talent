package com.acme.thermoregulator;

import java.util.concurrent.TimeUnit;

import com.acme.devices.HeaterDevice;
import com.acme.devices.ThermometerDevice;

public class AcmeThermoregulator {

	private Integer temperature = 0;
	private HeaterDevice heater;
	private ThermometerDevice thermometer;
	private boolean stop = false;
	protected int sec = 3;

	private Thread thermoregulator = new Thread() {
		@Override
		public void run() {
			while (!stop) {
				try {
					TimeUnit.SECONDS.sleep(sec);

					Integer thermoTemp = thermometer.getTemperature();
					if (temperature > thermoTemp) {
						heater.enable();
					} else if (temperature < thermoTemp) {
						heater.disable();
					}

				} catch (Exception e) {
				}
			}
		}
	};

	public AcmeThermoregulator(HeaterDevice h, ThermometerDevice t) {
		heater = h;
		thermometer = t;
	}

	public void enablePower() {
		thermoregulator.start();
	}

	public void disablePower() {
		stop = true;
	}

	public void setTemperature(Integer t) {
		temperature = t;
	}

}
