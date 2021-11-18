package com.formation.parking.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.dao.ParkingAPI;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ReponseParkingApiEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	public ParkingAPI parkingAPI;
	
	@Override
	public List<Parking> getListeParkings(){
		ReponseParkingApiEntity reponse = parkingAPI.getListeParkings();
		return transformEntityToModel(reponse);
	}

	private List<Parking> transformEntityToModel(ReponseParkingApiEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		for(RecordEntity record : reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getName());
			parking.setStatus(getLibelleStatut(record));
			parking.setNbPlaceDispo(record.getFields().getGrpDisponible());
			parking.setNbPlaceTotal(record.getFields().getGrpExploitation());
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		return resultat;
	}

	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		return dateMaj.getHour() + "h" + dateMaj.getMinute();
	}

	private String getLibelleStatut(RecordEntity record) {
		switch(record.getFields().getGrpStatus()) {
			case "1" : {
				return "FERME";
			}
			case "2" : {
				return "RESERVE AUX ABONNES";
			}
			case "5" : {
				return "OUVERT";
			}
		}
		return "Données non disponibles" ;
	}

}
