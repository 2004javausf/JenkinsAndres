package com.revature.beans;

public class VideoGame {
	
	//NEED TO MATCH HTML FORM NAMES
	
	private int vgID;
	private String vgName;
	private int vgMetascore;
	public VideoGame(int vgID, String vgName, int vgMetascore) {
		super();
		this.vgID = vgID;
		this.vgName = vgName;
		this.vgMetascore = vgMetascore;
	}
	
	public VideoGame() {
	super();
	}
	public int getVgID() {
		return vgID;
	}
	public void setVgID(int vgID) {
		this.vgID = vgID;
	}
	public String getVgName() {
		return vgName;
	}
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	public int getVgMetascore() {
		return vgMetascore;
	}
	public void setVgMetascore(int vgMetascore) {
		this.vgMetascore = vgMetascore;
	}
	@Override
	public String toString() {
		return "VideoGame [vgID=" + vgID + ", vgName=" + vgName + ", vgMetascore=" + vgMetascore + "]";
	}
	
	

}
