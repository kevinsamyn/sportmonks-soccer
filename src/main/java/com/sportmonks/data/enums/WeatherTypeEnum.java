package com.sportmonks.data.enums;

/**
 * Created by kevin on 21/05/2016.
 */
public enum WeatherTypeEnum {
	CLEAR_SKY("clear-sky"),

	FEW_CLOUDS("few-clouds"),

	SCATTERED_CLOUDS("scattered-clouds"),

	BROKEN_CLOUDS("broken-clouds"),

	SHOWER_RAIN("shower-rain"),

	RAIN("rain"),

	THUNDERSTORM("thunderstorm"),

	SNOW("snow"),

	MIST("mist");

	private final String code;

	WeatherTypeEnum(final String label) {
		this.code = label;
	}

	public String getCode() {
		return code;
	}
}
