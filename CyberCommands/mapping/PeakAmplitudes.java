package mapping;

public class PeakAmplitudes {
	private PeakAmplitudesPK paPK;
	private double IM_Value;
	private String Units;
	
	public double getIM_Value() {
		return IM_Value;
	}
	public void setIM_Value(double value) {
		IM_Value = value;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public PeakAmplitudesPK getPaPK() {
		return paPK;
	}
	public void setPaPK(PeakAmplitudesPK paPK) {
		this.paPK = paPK;
	}
	
}