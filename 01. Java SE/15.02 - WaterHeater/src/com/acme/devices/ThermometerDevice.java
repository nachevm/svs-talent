package com.acme.devices;

public interface ThermometerDevice {

	public Integer getTemperature();

	public void enablePower();

	public void disablePower();
}
