package com.acme.adapters;

import com.acme.devices.ThermometerDevice;
import com.ventoelectrics.waterheater.VentoThermometer;

public class VentoThermometerAdapter implements ThermometerDevice {

	private VentoThermometer thermometer;

	public VentoThermometerAdapter(VentoThermometer thermometer) {
		this.thermometer = thermometer;
	}

	@Override
	public void enablePower() {
		thermometer.enablePower();
	}

	@Override
	public void disablePower() {
		thermometer.disablePower();
	}

	@Override
	public Integer getTemperature() {
		return thermometer.getTemperature();
	}

}
