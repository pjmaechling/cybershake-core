package test.populatepeakamplitudes;

import java.util.ArrayList;

import data.SARuptureVariation;
import data.SARuptureFromFile;

import util.SABinary2Float;
import util.SwapBytes;

public class readOneFile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] byteArrayFromFile = SwapBytes.swapBinaryFileToArrayForFloats("safiles/PeakVals_allUSC_100_0.bsa");
		ArrayList<Float> floats = SABinary2Float.convertByteArrayToArrayOfFloats(byteArrayFromFile);
		SARuptureFromFile saRupture = new SARuptureFromFile(floats);
		printEastandNorthComponents(saRupture);
		saRupture.computeAllGeomAvgComponents();
		printGeomAvgComponents(saRupture);
		
	}

	private static void printGeomAvgComponents(SARuptureFromFile saRupture) {
		System.out.println("number of rupture variations: " + saRupture.rupVars.size());
		for (int rupVarIter=0;rupVarIter<saRupture.rupVars.size();rupVarIter++) {
			//System.out.println("rupVarIter: " + rupVarIter);
			SARuptureVariation currRupVar = saRupture.rupVars.get(rupVarIter);
			for (int periodIter=0;periodIter<currRupVar.geomAvgComp.periods.length;periodIter++) {
				System.out.println("SA for Rupture Variation " + currRupVar.variationNumber 
						+ ", Geometrically Averaged Component, Period " + (periodIter+1) + " : " 
						+ currRupVar.geomAvgComp.periods[periodIter] );
			}
			
		}
	}

	private static void printEastandNorthComponents(SARuptureFromFile saRupture) {
		System.out.println("number of rupture variations: " + saRupture.rupVars.size());
		for (int rupVarIter=0;rupVarIter<saRupture.rupVars.size();rupVarIter++) {
			//System.out.println("rupVarIter: " + rupVarIter);
			SARuptureVariation currRupVar = saRupture.rupVars.get(rupVarIter);
			for (int periodIter=0;periodIter<currRupVar.eastComp.periods.length;periodIter++) {
				System.out.println("SA for Rupture Variation " + currRupVar.variationNumber 
						+ ", East Component, Period " + (periodIter+1) + " : " 
						+ currRupVar.eastComp.periods[periodIter] );
			}
			for (int periodIter=0;periodIter<currRupVar.northComp.periods.length;periodIter++) {
				System.out.println("SA for Rupture Variation " + currRupVar.variationNumber 
						+ ", North Component, Period " + (periodIter+1) + " : " 
						+ currRupVar.northComp.periods[periodIter] );
			}
			
		}
	}
}
