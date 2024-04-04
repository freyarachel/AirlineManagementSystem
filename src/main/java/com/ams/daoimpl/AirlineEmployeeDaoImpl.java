package com.ams.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.dao.AirlineEmployeeDao;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Flight;
import com.ams.util.HibernateUtil;

public class AirlineEmployeeDaoImpl implements AirlineEmployeeDao{
	
	
	        //AirlineEmployee
			@Override
			public AirlineEmployee createAirlineEmployee(AirlineEmployee airlineEmployee) {
				try(Session session=HibernateUtil.getSession()){
					
					session.beginTransaction();
									
					//Create an employee
					AirlineEmployee ae1=new AirlineEmployee();
					ae1.setFirstName(ae1.getFirstName());
					ae1.setLastName(ae1.getLastName());
					ae1.setGender(ae1.getGender());
					ae1.setEmail(ae1.getEmail());
					ae1.setPosition(ae1.getPosition());
					
					//Create an employee 2
					AirlineEmployee ae2=new AirlineEmployee();
					ae2.setFirstName("Jane");
					ae2.setLastName("Smith");
					ae2.setGender("Female");
					ae2.setEmail("jane@gmail.com");
					ae2.setPosition("Airhostess");
					
					//Create an employee 3
					AirlineEmployee ae3=new AirlineEmployee();
					ae3.setFirstName("Parul");
					ae3.setLastName("M");
					ae3.setGender("Female");
					ae3.setEmail("parul@gmail.com");
					ae3.setPosition("Airhostess");
					
					//Create flight 1
					Flight flight1= new Flight();
					flight1.setFlightId("F_001");
					
					//Create flight 2
					Flight flight2= new Flight();
					flight2.setFlightId("F_002");
					
					List<AirlineEmployee> airlineEmpsOfFlights1= flight1.getAirlineEmployees();
					airlineEmpsOfFlights1.add(ae1);
					airlineEmpsOfFlights1.add(ae2);
					airlineEmpsOfFlights1.add(ae3);

					List<AirlineEmployee> airlineEmpsOfFlights2= flight2.getAirlineEmployees();
					airlineEmpsOfFlights2.add(ae1);
					airlineEmpsOfFlights2.add(ae2);

					session.save(flight1);
					session.save(flight2);

					
					session.getTransaction().commit();
					return airlineEmployee;
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

			public AirlineEmployee getAirlineEmployeeById(String airlineEmployeeId) {
				
				AirlineEmployee airlineEmployee=null;
				try(Session session=HibernateUtil.getSession()){
					
					session.beginTransaction();
					
					airlineEmployee =session.load(AirlineEmployee.class, airlineEmployeeId);
					System.out.println("AirlineEmployee details:");
            	    System.out.println("AirlineEmployee ID: " + airlineEmployee.getAirlineEmployeeId());
            	    System.out.println("First Name: " + airlineEmployee.getFirstName());
            	    System.out.println("Last Name: " + airlineEmployee.getLastName());
            	    System.out.println("Gender: " + airlineEmployee.getGender());
            	    System.out.println("Email : " + airlineEmployee.getEmail());
            	    System.out.println("Position : " + airlineEmployee.getPosition());

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
				return airlineEmployee;
				
			}
			
			
		   public void updateAirlineEmployee(AirlineEmployee airlineEmployee) {
				
				try(Session session=HibernateUtil.getSession()){
					
					session.beginTransaction();
					
					session.saveOrUpdate(airlineEmployee);
					
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
		public List<AirlineEmployee> getAllAirlineEmployees() {
				
				List<AirlineEmployee> airlineEmployees=null;
				
				try(Session session=HibernateUtil.getSession()){
					
					session.beginTransaction();
					
					airlineEmployees =session.createQuery("FROM AirlineEmployee").list();
					
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
				return airlineEmployees;
				
			}
		   
		   
		   public void deleteAirlineEmployee(String routeId) {
			   AirlineEmployee airlineEmployee=null;

				try(Session session=HibernateUtil.getSession()){
					
					session.beginTransaction();
					
					airlineEmployee=session.get(AirlineEmployee.class,routeId);
					
					session.delete(airlineEmployee);
					
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


        

