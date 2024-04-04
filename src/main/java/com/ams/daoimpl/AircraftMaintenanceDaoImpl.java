package com.ams.daoimpl;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.dao.AircraftMaintenanceDao;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.util.HibernateUtil;

public class AircraftMaintenanceDaoImpl implements AircraftMaintenanceDao{
	
	
	//AircraftMaintenance
	@Override
	public AircraftMaintenance createAircraftMaintenance(AircraftMaintenance aircraftMaintenance) {
	     
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			// Create Aircraft objects
			Aircraft a1 = new Aircraft();
			a1.setAircraftId(a1.getAircraftId()); 

			
			// Create AircraftMaintenance objects
			AircraftMaintenance am1 = new AircraftMaintenance();
			am1.setAircraftMaintenanceDateTime(aircraftMaintenance.getAircraftMaintenanceDateTime());
			am1.setCost(aircraftMaintenance.getCost());
			am1.setDescription(aircraftMaintenance.getDescription());
            am1.setAircraft(a1);
			
			AircraftMaintenance am2 = new AircraftMaintenance();
			am2.setAircraftMaintenanceDateTime(LocalDateTime.of(2024, 3, 25, 8, 0));
			am2.setCost(278000);
			am2.setDescription("New Software");
            am2.setAircraft(a1);

			
			// Create lists of AircraftMaintenance for each Aircraft
			List<AircraftMaintenance> maintenanceOfAircraft = new ArrayList<AircraftMaintenance>();
			maintenanceOfAircraft.add(am1);
			maintenanceOfAircraft.add(am2);

			// Set the maintenance lists for each Aircraft
			a1.setAircraftMaintenances(maintenanceOfAircraft);


            session.save(a1);
			
			session.getTransaction().commit();
			return aircraftMaintenance;
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return null;
	}
	
	
public AircraftMaintenance getAircraftMaintenanceById(String aircraftMaintenanceId) {
		
	    AircraftMaintenance aircraftMaintenance=null;
	    
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			aircraftMaintenance =session.get(AircraftMaintenance.class, aircraftMaintenanceId);
			
    	    System.out.println("AircraftMaintenance details:");
    	    System.out.println("AircraftMaintenance ID: " + aircraftMaintenance.getAircraftMaintenanceId());
    	    System.out.println("DateTime : " + aircraftMaintenance.getAircraftMaintenanceDateTime());
    	    System.out.println("Description: " + aircraftMaintenance.getDescription());
    	    System.out.println("Cost: " + aircraftMaintenance.getCost());
    	    System.out.println("-----------------------------------");
			
						
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return aircraftMaintenance;
		
	}
	
	
   public void updateAircraftMaintenance(AircraftMaintenance aircraftMaintenance) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(aircraftMaintenance);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
   
   @SuppressWarnings("unchecked")
public List<AircraftMaintenance> getAllAircraftMaintenances() {
		
		List<AircraftMaintenance> aircraftMaintenances=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			aircraftMaintenances =session.createQuery("FROM AircraftMaintenance").list();
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return aircraftMaintenances;
		
	}
   
   
   public void deleteAircraftMaintenance(String aircraftMaintenanceId) {
	   AircraftMaintenance aircraftMaintenance=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			aircraftMaintenance=session.get(AircraftMaintenance.class,aircraftMaintenanceId);
			
			session.delete(aircraftMaintenance);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
	



}