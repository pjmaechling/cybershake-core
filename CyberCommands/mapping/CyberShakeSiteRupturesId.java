package mapping;

// Generated Aug 9, 2007 9:53:47 PM by Hibernate Tools 3.2.0.b9

/**
 * CyberShakeSiteRupturesId generated by hbm2java
 */
public class CyberShakeSiteRupturesId implements java.io.Serializable {

	private int csSiteId;

	private int erfId;

	private int sourceId;

	private int ruptureId;

	private double cutoffDist;

	public CyberShakeSiteRupturesId() {
	}

	public CyberShakeSiteRupturesId(int csSiteId, int erfId, int sourceId,
			int ruptureId, double cutoffDist) {
		this.csSiteId = csSiteId;
		this.erfId = erfId;
		this.sourceId = sourceId;
		this.ruptureId = ruptureId;
		this.cutoffDist = cutoffDist;
	}

	public int getCsSiteId() {
		return this.csSiteId;
	}

	public void setCsSiteId(int csSiteId) {
		this.csSiteId = csSiteId;
	}

	public int getErfId() {
		return this.erfId;
	}

	public void setErfId(int erfId) {
		this.erfId = erfId;
	}

	public int getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getRuptureId() {
		return this.ruptureId;
	}

	public void setRuptureId(int ruptureId) {
		this.ruptureId = ruptureId;
	}

	public double getCutoffDist() {
		return this.cutoffDist;
	}

	public void setCutoffDist(double cutoffDist) {
		this.cutoffDist = cutoffDist;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CyberShakeSiteRupturesId))
			return false;
		CyberShakeSiteRupturesId castOther = (CyberShakeSiteRupturesId) other;

		return (this.getCsSiteId() == castOther.getCsSiteId())
				&& (this.getErfId() == castOther.getErfId())
				&& (this.getSourceId() == castOther.getSourceId())
				&& (this.getRuptureId() == castOther.getRuptureId())
				&& (this.getCutoffDist() == castOther.getCutoffDist());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCsSiteId();
		result = 37 * result + this.getErfId();
		result = 37 * result + this.getSourceId();
		result = 37 * result + this.getRuptureId();
		result = 37 * result + (int) this.getCutoffDist();
		return result;
	}

}
