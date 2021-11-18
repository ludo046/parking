package com.formation.parking.models;

public class Parking {

	private String nom;
	private int nbPlaceDispo;
	private int nbPlaceTotal;
	private String status;
	private String heureMaj;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}
	public int getNbPlaceTotal() {
		return nbPlaceTotal;
	}
	public void setNbPlaceTotal(int nbPlaceTotal) {
		this.nbPlaceTotal = nbPlaceTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHeureMaj() {
		return heureMaj;
	}
	public void setHeureMaj(String heureMaj) {
		this.heureMaj = heureMaj;
	}
	
	
	
}
