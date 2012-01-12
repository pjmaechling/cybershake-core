package mapping;

// Generated Aug 9, 2007 9:53:47 PM by Hibernate Tools 3.2.0.b9

/**
 * PeakAmplitudesId generated by hbm2java
 */
public class PeakAmplitudesId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3227675451911077358L;

	private int sourceId;

	private int ruptureId;

	private long rupVarId;

	private int runId;

	private String imType;

	public PeakAmplitudesId() {
	}

	public PeakAmplitudesId(int sourceId, int ruptureId,
			long rupVarId, int runId, String imType) {
		this.sourceId = sourceId;
		this.ruptureId = ruptureId;
		this.rupVarId = rupVarId;
		this.runId = runId;
		this.imType = imType;
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

	public long getRupVarId() {
		return this.rupVarId;
	}

	public void setRupVarId(long rupVarId) {
		this.rupVarId = rupVarId;
	}

	public int getRunId() {
		return this.runId;
	}

	public void setRunId(int runId) {
		this.runId = runId;
	}

	public String getImType() {
		return this.imType;
	}

	public void setImType(String imType) {
		this.imType = imType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PeakAmplitudesId))
			return false;
		PeakAmplitudesId castOther = (PeakAmplitudesId) other;

		return (this.getSourceId() == castOther.getSourceId())
				&& (this.getRuptureId() == castOther.getRuptureId())
				&& (this.getRupVarId() == castOther.getRupVarId())
				&& (this.getRunId() == castOther.getRunId())
				&& ((this.getImType() == castOther.getImType()) || (this
						.getImType() != null
						&& castOther.getImType() != null && this.getImType()
						.equals(castOther.getImType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSourceId();
		result = 37 * result + this.getRuptureId();
		result = 37 * result + (int) this.getRupVarId();
		result = 37 * result + this.getRunId();
		result = 37 * result
				+ (getImType() == null ? 0 : this.getImType().hashCode());
		return result;
	}

}