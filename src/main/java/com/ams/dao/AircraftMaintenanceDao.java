package com.ams.dao;

import java.util.List;

import com.ams.entity.AircraftMaintenance;
import com.ams.entity.Airport;

public interface AircraftMaintenanceDao {
	
	
	//AircraftMaintenance
	AircraftMaintenance createAircraftMaintenance(AircraftMaintenance aircraftMaintenance);

	AircraftMaintenance getAircraftMaintenanceById(String aircraftMaintenanceId);
    void updateAircraftMaintenance(AircraftMaintenance aircraftMaintenance);
    List<AircraftMaintenance> getAllAircraftMaintenances();
    void deleteAircraftMaintenance(String aircraftMaintenanceId);


}