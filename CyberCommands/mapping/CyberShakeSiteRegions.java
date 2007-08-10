package mapping;

// Generated Aug 9, 2007 9:53:47 PM by Hibernate Tools 3.2.0.b9

import java.util.HashSet;
import java.util.Set;

/**
 * CyberShakeSiteRegions generated by hbm2java
 */
public class CyberShakeSiteRegions implements java.io.Serializable {

	private CyberShakeSiteRegionsId id;

	private ErfIds erfIds;

	private CyberShakeSites cyberShakeSites;

	private double maxLat;

	private int maxLatSourceId;

	private int maxLatRuptureId;

	private double maxLon;

	private int maxLonSourceId;

	private int maxLonRuptureId;

	private double minLat;

	private int minLatSourceId;

	private int minLatRuptureId;

	private double minLon;

	private int minLonSourceId;

	private int minLonRuptureId;

	private Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses = new HashSet<CyberShakeSiteRuptures>(
			0);

	public CyberShakeSiteRegions() {
	}

	public CyberShakeSiteRegions(CyberShakeSiteRegionsId id, ErfIds erfIds,
			CyberShakeSites cyberShakeSites, double maxLat, int maxLatSourceId,
			int maxLatRuptureId, double maxLon, int maxLonSourceId,
			int maxLonRuptureId, double minLat, int minLatSourceId,
			int minLatRuptureId, double minLon, int minLonSourceId,
			int minLonRuptureId) {
		this.id = id;
		this.erfIds = erfIds;
		this.cyberShakeSites = cyberShakeSites;
		this.maxLat = maxLat;
		this.maxLatSourceId = maxLatSourceId;
		this.maxLatRuptureId = maxLatRuptureId;
		this.maxLon = maxLon;
		this.maxLonSourceId = maxLonSourceId;
		this.maxLonRuptureId = maxLonRuptureId;
		this.minLat = minLat;
		this.minLatSourceId = minLatSourceId;
		this.minLatRuptureId = minLatRuptureId;
		this.minLon = minLon;
		this.minLonSourceId = minLonSourceId;
		this.minLonRuptureId = minLonRuptureId;
	}

	public CyberShakeSiteRegions(CyberShakeSiteRegionsId id, ErfIds erfIds,
			CyberShakeSites cyberShakeSites, double maxLat, int maxLatSourceId,
			int maxLatRuptureId, double maxLon, int maxLonSourceId,
			int maxLonRuptureId, double minLat, int minLatSourceId,
			int minLatRuptureId, double minLon, int minLonSourceId,
			int minLonRuptureId,
			Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses) {
		this.id = id;
		this.erfIds = erfIds;
		this.cyberShakeSites = cyberShakeSites;
		this.maxLat = maxLat;
		this.maxLatSourceId = maxLatSourceId;
		this.maxLatRuptureId = maxLatRuptureId;
		this.maxLon = maxLon;
		this.maxLonSourceId = maxLonSourceId;
		this.maxLonRuptureId = maxLonRuptureId;
		this.minLat = minLat;
		this.minLatSourceId = minLatSourceId;
		this.minLatRuptureId = minLatRuptureId;
		this.minLon = minLon;
		this.minLonSourceId = minLonSourceId;
		this.minLonRuptureId = minLonRuptureId;
		this.cyberShakeSiteRuptureses = cyberShakeSiteRuptureses;
	}

	public CyberShakeSiteRegionsId getId() {
		return this.id;
	}

	public void setId(CyberShakeSiteRegionsId id) {
		this.id = id;
	}

	public ErfIds getErfIds() {
		return this.erfIds;
	}

	public void setErfIds(ErfIds erfIds) {
		this.erfIds = erfIds;
	}

	public CyberShakeSites getCyberShakeSites() {
		return this.cyberShakeSites;
	}

	public void setCyberShakeSites(CyberShakeSites cyberShakeSites) {
		this.cyberShakeSites = cyberShakeSites;
	}

	public double getMaxLat() {
		return this.maxLat;
	}

	public void setMaxLat(double maxLat) {
		this.maxLat = maxLat;
	}

	public int getMaxLatSourceId() {
		return this.maxLatSourceId;
	}

	public void setMaxLatSourceId(int maxLatSourceId) {
		this.maxLatSourceId = maxLatSourceId;
	}

	public int getMaxLatRuptureId() {
		return this.maxLatRuptureId;
	}

	public void setMaxLatRuptureId(int maxLatRuptureId) {
		this.maxLatRuptureId = maxLatRuptureId;
	}

	public double getMaxLon() {
		return this.maxLon;
	}

	public void setMaxLon(double maxLon) {
		this.maxLon = maxLon;
	}

	public int getMaxLonSourceId() {
		return this.maxLonSourceId;
	}

	public void setMaxLonSourceId(int maxLonSourceId) {
		this.maxLonSourceId = maxLonSourceId;
	}

	public int getMaxLonRuptureId() {
		return this.maxLonRuptureId;
	}

	public void setMaxLonRuptureId(int maxLonRuptureId) {
		this.maxLonRuptureId = maxLonRuptureId;
	}

	public double getMinLat() {
		return this.minLat;
	}

	public void setMinLat(double minLat) {
		this.minLat = minLat;
	}

	public int getMinLatSourceId() {
		return this.minLatSourceId;
	}

	public void setMinLatSourceId(int minLatSourceId) {
		this.minLatSourceId = minLatSourceId;
	}

	public int getMinLatRuptureId() {
		return this.minLatRuptureId;
	}

	public void setMinLatRuptureId(int minLatRuptureId) {
		this.minLatRuptureId = minLatRuptureId;
	}

	public double getMinLon() {
		return this.minLon;
	}

	public void setMinLon(double minLon) {
		this.minLon = minLon;
	}

	public int getMinLonSourceId() {
		return this.minLonSourceId;
	}

	public void setMinLonSourceId(int minLonSourceId) {
		this.minLonSourceId = minLonSourceId;
	}

	public int getMinLonRuptureId() {
		return this.minLonRuptureId;
	}

	public void setMinLonRuptureId(int minLonRuptureId) {
		this.minLonRuptureId = minLonRuptureId;
	}

	public Set<CyberShakeSiteRuptures> getCyberShakeSiteRuptureses() {
		return this.cyberShakeSiteRuptureses;
	}

	public void setCyberShakeSiteRuptureses(
			Set<CyberShakeSiteRuptures> cyberShakeSiteRuptureses) {
		this.cyberShakeSiteRuptureses = cyberShakeSiteRuptureses;
	}

}
