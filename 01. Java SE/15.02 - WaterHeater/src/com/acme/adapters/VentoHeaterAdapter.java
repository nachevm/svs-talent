package com.acme.adapters;

import com.acme.devices.HeaterDevice;
import com.ventoelectrics.waterheater.VentoHeater;

public class VentoHeaterAdapter implements HeaterDevice {

	private VentoHeater heater;

	public VentoHeaterAdapter(VentoHeater heater) {
		this.heater = heater;
	}

	@Override
	public void enable() {
		heater.enable();
	}

	@Override
	public void disable() {
		heater.disable();
	}

}
