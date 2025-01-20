package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// deleteInstructorDetail(appDAO);

			// ---One TO Many---
			// createInstructorWithCourse(appDAO);

			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);

			//findInstructorWithCoursesJoinFetch(appDAO);

			//updateInstructor(appDAO);

			//updateCourse(appDAO);

			//deleteInstructor(appDAO);

			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting the course id: " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		//finding the course
		System.out.println("Finding Course id : " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update the course
		System.out.println("Updating instructor id: " + theId);
		tempCourse.setTitle("Relaxing in the Forest");

		//change from the database
		appDAO.update(tempCourse);
		System.out.println("Done!");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;
		//find instructor
		System.out.println("Finding Instructor ID: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Public");

		//change from the database
		appDAO.update(tempInstructor);
		System.out.println("DONE");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		//find the instructor
		System.out.println("Finding Instructor ID: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("associated Courses : " +tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding Instructor ID" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor :" + tempInstructor);

		// find courses for instructor
		System.out.println("Finding Courses for instructor ID :" + theId);
		List<Course> courses =appDAO.findCoursesByInstructorId(theId);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor ID" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor :" + tempInstructor);
		System.out.println("The Associated Courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {

		// create Instructor
		Instructor tempInstructor =
				new Instructor("Susan","Public","public@luv2code.com");

		// create Instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("Video Game",
						"http://www.youtube.com");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball - The Master Class");

		// add course to Instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save instructor
		//
 		//This will ALSO save the courses
		//because of CascadeType.PERSIST
		//
		System.out.println("Saving Instructor : " + tempInstructor);
		System.out.println("The Courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("DONE");

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
		int theId = 1;
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
