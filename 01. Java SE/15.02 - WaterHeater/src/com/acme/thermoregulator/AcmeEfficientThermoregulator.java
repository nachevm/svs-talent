package com.acme.thermoregulator;

import com.acme.devices.HeaterDevice;
import com.acme.devices.ThermometerDevice;

public class AcmeEfficientThermoregulator extends AcmeThermoregulator {

	public AcmeEfficientThermoregulator(HeaterDevice h, ThermometerDevice t) {
		super(h, t);
		sec = 1;
	}
}
