package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
			// createInstructor(appDAO); //for creating

			//findInstructor(appDAO); //for finding
			
			//deleteInstructor(appDAO);//for deleting

			//findInstructorDetail(appDAO); // from detail to Instructor

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Deleting instructor details ID : " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("DONE!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		//get the Instructor detail object
		int theId =2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("tempInstructorDetail : " + tempInstructorDetail);

		//print the associated Instructor
		System.out.println("the associated instructor: " +tempInstructorDetail.getInstructor());

		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting the Instructor with ID : " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId =2;
		System.out.println("Finding the Instructor with ID : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only : " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		// create Instructor
		Instructor tempInstructor =
				new Instructor("Chad","Darby","darby@luv2code.com");

		// create Instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("I love to code",
						"http://www.youtubechannel.com/youyou");
		*/

		// create Instructor
		Instructor tempInstructor =
				new Instructor("Ace","Madrid","madrid@luv2code.com");

		// create Instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("LOVING Soccer",
						"http://www.youtubechannel.com/youyou");



		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
 		// NOTE: this will also save the details object
 		// because of the CascadeType.ALL
		System.out.println("saving instructor : " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("DONE");

	}
}
