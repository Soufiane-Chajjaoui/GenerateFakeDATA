package com.DW.group.DWProject;

public class Match {
	int idHomeTeam ;
	int idAwayTeam ;
	
	
	public Match(int idHomeTeam, int idAwayTeam) {
		super();
		this.idHomeTeam = idHomeTeam;
		this.idAwayTeam = idAwayTeam;
	}


	public int getIdHomeTeam() {
		return idHomeTeam;
	}
	public void setIdHomeTeam(int idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
	}
	public int getIdAwayTeam() {
		return idAwayTeam;
	}
	public void setIdAwayTeam(int idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
	}
	
	
}
