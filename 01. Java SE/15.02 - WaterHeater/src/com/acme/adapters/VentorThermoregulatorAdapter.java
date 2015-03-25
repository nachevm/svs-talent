package com.acme.adapters;

import com.acme.thermoregulator.AcmeThermoregulator;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentorThermoregulatorAdapter implements VentoThermoregulator {

	private AcmeThermoregulator thermometer;

	public VentorThermoregulatorAdapter(AcmeThermoregulator thermometer) {
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
	public void setTemperature(Integer temperature) {
		thermometer.setTemperature(temperature);
	}

}
