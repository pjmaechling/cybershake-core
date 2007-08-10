package mapping;

// Generated Aug 9, 2007 9:53:47 PM by Hibernate Tools 3.2.0.b9

/**
 * RuptureVariationsId generated by hbm2java
 */
public class RuptureVariationsId implements java.io.Serializable {

	private int erfId;

	private int sourceId;

	private int ruptureId;

	private long rupVarId;

	private int rupVarScenarioId;

	public RuptureVariationsId() {
	}

	public RuptureVariationsId(int erfId, int sourceId, int ruptureId,
			long rupVarId, int rupVarScenarioId) {
		this.erfId = erfId;
		this.sourceId = sourceId;
		this.ruptureId = ruptureId;
		this.rupVarId = rupVarId;
		this.rupVarScenarioId = rupVarScenarioId;
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

	public long getRupVarId() {
		return this.rupVarId;
	}

	public void setRupVarId(long rupVarId) {
		this.rupVarId = rupVarId;
	}

	public int getRupVarScenarioId() {
		return this.rupVarScenarioId;
	}

	public void setRupVarScenarioId(int rupVarScenarioId) {
		this.rupVarScenarioId = rupVarScenarioId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RuptureVariationsId))
			return false;
		RuptureVariationsId castOther = (RuptureVariationsId) other;

		return (this.getErfId() == castOther.getErfId())
				&& (this.getSourceId() == castOther.getSourceId())
				&& (this.getRuptureId() == castOther.getRuptureId())
				&& (this.getRupVarId() == castOther.getRupVarId())
				&& (this.getRupVarScenarioId() == castOther
						.getRupVarScenarioId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getErfId();
		result = 37 * result + this.getSourceId();
		result = 37 * result + this.getRuptureId();
		result = 37 * result + (int) this.getRupVarId();
		result = 37 * result + this.getRupVarScenarioId();
		return result;
	}

}
