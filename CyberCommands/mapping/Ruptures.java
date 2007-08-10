package mapping;

// Generated Aug 9, 2007 9:53:47 PM by Hibernate Tools 3.2.0.b9

import java.util.HashSet;
import java.util.Set;

/**
 * Ruptures generated by hbm2java
 */
public class Ruptures implements java.io.Serializable {

	private RupturesId id;

	private ErfIds erfIds;

	private String sourceName;

	private String sourceType;

	private double mag;

	private double prob;

	private double gridSpacing;

	private int numRows;

	private int numColumns;

	private int numPoints;

	private double startLat;

	private double startLon;

	private double startDepth;

	private double endLat;

	private double endLon;

	private double endDepth;

	private Set<RuptureVariations> ruptureVariationses = new HashSet<RuptureVariations>(
			0);

	private Set<PeakAmplitudes> peakAmplitudeses = new HashSet<PeakAmplitudes>(
			0);

	private Set<Points> pointses = new HashSet<Points>(0);

	private Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses = new HashSet<CyberShakeSiteRuptures>(
			0);

	public Ruptures() {
	}

	public Ruptures(RupturesId id, ErfIds erfIds, String sourceName,
			double mag, double prob, double gridSpacing, int numRows,
			int numColumns, int numPoints, double startLat, double startLon,
			double startDepth, double endLat, double endLon, double endDepth) {
		this.id = id;
		this.erfIds = erfIds;
		this.sourceName = sourceName;
		this.mag = mag;
		this.prob = prob;
		this.gridSpacing = gridSpacing;
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.numPoints = numPoints;
		this.startLat = startLat;
		this.startLon = startLon;
		this.startDepth = startDepth;
		this.endLat = endLat;
		this.endLon = endLon;
		this.endDepth = endDepth;
	}

	public Ruptures(RupturesId id, ErfIds erfIds, String sourceName,
			String sourceType, double mag, double prob, double gridSpacing,
			int numRows, int numColumns, int numPoints, double startLat,
			double startLon, double startDepth, double endLat, double endLon,
			double endDepth, Set<RuptureVariations> ruptureVariationses,
			Set<PeakAmplitudes> peakAmplitudeses, Set<Points> pointses,
			Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses) {
		this.id = id;
		this.erfIds = erfIds;
		this.sourceName = sourceName;
		this.sourceType = sourceType;
		this.mag = mag;
		this.prob = prob;
		this.gridSpacing = gridSpacing;
		this.numRows = numRows;
		this.numColumns = numColumns;
		this.numPoints = numPoints;
		this.startLat = startLat;
		this.startLon = startLon;
		this.startDepth = startDepth;
		this.endLat = endLat;
		this.endLon = endLon;
		this.endDepth = endDepth;
		this.ruptureVariationses = ruptureVariationses;
		this.peakAmplitudeses = peakAmplitudeses;
		this.pointses = pointses;
		this.cyberShakeSiteRuptureses = cyberShakeSiteRuptureses;
	}

	public RupturesId getId() {
		return this.id;
	}

	public void setId(RupturesId id) {
		this.id = id;
	}

	public ErfIds getErfIds() {
		return this.erfIds;
	}

	public void setErfIds(ErfIds erfIds) {
		this.erfIds = erfIds;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public double getMag() {
		return this.mag;
	}

	public void setMag(double mag) {
		this.mag = mag;
	}

	public double getProb() {
		return this.prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

	public double getGridSpacing() {
		return this.gridSpacing;
	}

	public void setGridSpacing(double gridSpacing) {
		this.gridSpacing = gridSpacing;
	}

	public int getNumRows() {
		return this.numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumColumns() {
		return this.numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public int getNumPoints() {
		return this.numPoints;
	}

	public void setNumPoints(int numPoints) {
		this.numPoints = numPoints;
	}

	public double getStartLat() {
		return this.startLat;
	}

	public void setStartLat(double startLat) {
		this.startLat = startLat;
	}

	public double getStartLon() {
		return this.startLon;
	}

	public void setStartLon(double startLon) {
		this.startLon = startLon;
	}

	public double getStartDepth() {
		return this.startDepth;
	}

	public void setStartDepth(double startDepth) {
		this.startDepth = startDepth;
	}

	public double getEndLat() {
		return this.endLat;
	}

	public void setEndLat(double endLat) {
		this.endLat = endLat;
	}

	public double getEndLon() {
		return this.endLon;
	}

	public void setEndLon(double endLon) {
		this.endLon = endLon;
	}

	public double getEndDepth() {
		return this.endDepth;
	}

	public void setEndDepth(double endDepth) {
		this.endDepth = endDepth;
	}

	public Set<RuptureVariations> getRuptureVariationses() {
		return this.ruptureVariationses;
	}

	public void setRuptureVariationses(
			Set<RuptureVariations> ruptureVariationses) {
		this.ruptureVariationses = ruptureVariationses;
	}

	public Set<PeakAmplitudes> getPeakAmplitudeses() {
		return this.peakAmplitudeses;
	}

	public void setPeakAmplitudeses(Set<PeakAmplitudes> peakAmplitudeses) {
		this.peakAmplitudeses = peakAmplitudeses;
	}

	public Set<Points> getPointses() {
		return this.pointses;
	}

	public void setPointses(Set<Points> pointses) {
		this.pointses = pointses;
	}

	public Set<CyberShakeSiteRuptures> getCyberShakeSiteRuptureses() {
		return this.cyberShakeSiteRuptureses;
	}

	public void setCyberShakeSiteRuptureses(
			Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses) {
		this.cyberShakeSiteRuptureses = cyberShakeSiteRuptureses;
	}

}
