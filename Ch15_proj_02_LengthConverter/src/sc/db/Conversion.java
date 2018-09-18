package sc.db;

public class Conversion {
	String fromUnit;
	double fromValue;
	String toUnit;
	double toValue;
	double conversionValue;
	
	public Conversion(String fromUnit, String toUnit, double conversionValue) {
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.conversionValue = conversionValue;
	}

	public String getFromUnit() {
		return fromUnit;
	}

	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}

	public double getFromValue() {
		return fromValue;
	}

	public void setFromValue(double fromValue) {
		this.fromValue = fromValue;
	}

	public String getToUnit() {
		return toUnit;
	}

	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}

	public double getToValue() {
		return toValue;
	}

	public void setToValue(double toValue) {
		this.toValue = toValue;
	}

	public double getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(double conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	public double convertValue(double n) {
		return n*this.conversionValue;
	}

}
