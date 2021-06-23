package com.diego.excercises;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentQuizTest {

	public static void main(String[] args) {
		StudentQuizGrades test = new StudentQuizGrades();
		boolean ON = true;
		HashMap<String, ArrayList <Integer>> school = test.createClass();
		
		UserIO userIO = new UserIOImplementation();
		
		userIO.print("\n----------------------------------------\nMAIN MENU\n----------------------------------------\n");
		
		do {
		
		int choice = userIO.readInt("1)View a list of students		"
									+ "2)Add a student to the system"
									+ "\n3)Remove a student from the system		"
									+ "4)View a list of quiz scores per student"
									+ "\n5)View the average quiz score per student		"
									+ "6)Get average quiz score for the entire class\n"
									+ "\n7)EXIT?");
		
		switch (choice) {
			case 1:
				test.viewAllStudents(school);
				break;
			case 2:
				test.addStudent(school);
				break;
			case 3:
				test.removeStudent(school);
				break;
			case 4:
				test.getScoresPerStudents(school);
				break;
			case 5:
				test.getAvrgScorePerStudent(school);
				break;
			case 6:
				test.getAvrgScorePerClass(school);
				break;
			case 7:
				ON = false;
				break;	

		}
		
		
		}while (ON);

		userIO.print("Thansk for useing this system.");
		System.exit(0);
		
	}

}
