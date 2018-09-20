package Model;

public class Document {
	
	
	public String SID;
	public byte[] PROPOSAL;
	public byte[] ANALYSIS;
	public byte[] DESIGN;
	public byte[] REPORT;
	public String Ptime;
	
	
	public String getPtime() {
		return Ptime;
	}
	public void setPtime(String ptime) {
		Ptime = ptime;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public byte[] getPROPOSAL() {
		return PROPOSAL;
	}
	public void setPROPOSAL(byte[] pROPOSAL) {
		PROPOSAL = pROPOSAL;
	}
	public byte[] getANALYSIS() {
		return ANALYSIS;
	}
	public void setANALYSIS(byte[] aNALYSIS) {
		ANALYSIS = aNALYSIS;
	}
	public byte[] getDESIGN() {
		return DESIGN;
	}
	public void setDESIGN(byte[] dESIGN) {
		DESIGN = dESIGN;
	}
	public byte[] getREPORT() {
		return REPORT;
	}
	public void setREPORT(byte[] rEPORT) {
		REPORT = rEPORT;
	}

}
