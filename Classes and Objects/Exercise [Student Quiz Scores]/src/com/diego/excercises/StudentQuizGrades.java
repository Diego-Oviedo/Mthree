package com.diego.excercises;
import java.util.*;
import java.util.Map.Entry;

public class StudentQuizGrades extends UserIOImplementation {

	
	public HashMap<String, ArrayList <Integer>> createClass(){//create a school
		
		HashMap<String, ArrayList <Integer>> school = new HashMap<>();
		boolean stop_scores = false;
		boolean stop_students = false;
		UserIO userIO = new UserIOImplementation(); 
		
		userIO.print("*************\nCREATE A CLASS\n*************\n");
		
		do {
			
			String student = userIO.readString("Please provide the student's name");
			ArrayList <Integer> student_scores = new ArrayList <Integer>();
			
			
			do {
				
				int score = userIO.readInt("what is the score for "+ student);
				
				student_scores.add(score);
				
				String score_response = userIO.readString("Do you still want to add more scores?");
				
				if(score_response.equalsIgnoreCase("y")) {
					
					stop_scores = true;
				}else if(!score_response.equalsIgnoreCase("y") || score_response.equalsIgnoreCase("n")){
					stop_scores = false;
				}
				
			}while(stop_scores);
			
			

			school.put(student,student_scores);
			
			String student_response = userIO.readString("Do you still want to add more students?");
			
			if(student_response.equalsIgnoreCase("y")) {
				
				stop_students = true;
			}else if (!student_response.equalsIgnoreCase("y") || student_response.equalsIgnoreCase("n")){
				stop_students = false;
			}
			
			
		}while (stop_students);
		
		
		return school;
	}
	
	
	
	public void addStudent (HashMap<String, ArrayList <Integer>> school) {//Add a student to the system
		
		boolean stop_scores = false;
		boolean stop_students = false;
		UserIO userIO = new UserIOImplementation(); 
		
		userIO.print("*************\nADD STUDENT\n*************\n");
		
		do {
			
			String student = userIO.readString("Please provide the student's name");
			ArrayList <Integer> student_scores = new ArrayList <Integer>();
			
			
			do {
				
				int score = userIO.readInt("what is the score for "+ student);
				
				student_scores.add(score);
				
				String score_response = userIO.readString("Do you still want to add more scores?");
				
				if(score_response.equalsIgnoreCase("y")) {
					
					stop_scores = true;
					
				}else if(!score_response.equalsIgnoreCase("y") || score_response.equalsIgnoreCase("n")){
					stop_scores = false;
				}
				
			}while(stop_scores);
			
			

			school.put(student,student_scores);
			
			String student_response = userIO.readString("Do you still want to add more students?");
			
			if(student_response.equalsIgnoreCase("y")) {
				
				stop_students = true;
			}else if (!student_response.equalsIgnoreCase("y") || student_response.equalsIgnoreCase("n")){
				stop_students = false;
			}
			
			
		}while (stop_students);
		userIO.print("\n\n");
	}
	
	public void viewAllStudents(HashMap<String, ArrayList <Integer>> school) {//View a list of students in the system
		UserIO userIO = new UserIOImplementation();
		Set <String> students = school.keySet();
		
		
		userIO.print("\n************************\nLIST OF STUDENTS\n************************\n");
		
		for (String student : students) {
			
			userIO.print(student);
		}
		
		userIO.print("\n\n");
	}
	
	
	public void getScoresPerStudents (HashMap<String, ArrayList <Integer>> school) {//View a list of quiz scores for a given student
		UserIO userIO = new UserIOImplementation();
		String student = userIO.readString("What student do you need the record for?");
		
		ArrayList <Integer> scores =  school.get(student);
		
		userIO.print("The student: " + student + " have obtained the following grades:");
		for (int score : scores) {
			
			userIO.print(score + " ");
		}
		userIO.print("\n\n");
	}
	
	public void removeStudent (HashMap<String, ArrayList <Integer>> school) {//Remove a student from the system

		UserIO userIO = new UserIOImplementation();
		String student = userIO.readString("What student do you want to get the avarage from?");
		
		
		school.remove(student);
		
		userIO.print("Student sucessfully removed!");
		userIO.print("\n\n");
	}
	
	public void getAvrgScorePerStudent (HashMap<String, ArrayList <Integer>> school) {//View the average quiz score for a given student
		UserIO userIO = new UserIOImplementation();
		String student = userIO.readString("What student do you want to remove from?");
		
		ArrayList <Integer> scores =  school.get(student);
		
		int average = 0;
		
		for (int score : scores) {
			
			average = average + score;
		}
		
		int total_scores = (scores.size());
		
		average = (average / total_scores );
		
		userIO.print("The average score for " + student + " is : " + average);
		
		userIO.print("\n\n");
	}
	
	
	public void getAvrgScorePerClass(HashMap<String, ArrayList <Integer>> school) {//Calculate the average quiz score for the entire class.
		UserIO userIO = new UserIOImplementation();
		
		Set <String> students = school.keySet();
		
		int average_class = 0;
		int average_student = 0;
		
		
		for (String student : students) {//getting list of scores per student (looping students) 
			
			ArrayList <Integer> scores =  school.get(student);
			
			for(int score :scores) {// getting score per student (looping scores per student)
				
				average_student = average_student + score;
				
			}
			
			int total_courses = scores.size();
			
			average_student = average_student / total_courses;
			
			average_class = average_class + average_student;
		}
		
			
		int total_scores = (students.size());
		System.out.println(total_scores);
		
		
		average_class = (average_class / total_scores );
		
		userIO.print("The average score for the class is : " + average_class);
		
		userIO.print("\n\n");
	}
	
	/*
	public void getStudentHScore (HashMap<String, ArrayList <Integer>> school) {//Find and list the student(s) with the highest quiz score.
		UserIO userIO = new UserIOImplementation();
		HashMap<String,Integer> best_results = new HashMap<>();//A new HashMap will store the bsets results 
		Set <String> students = school.keySet();
		
		for (String student : students) {//getting list of scores per student (looping students) 
			
			ArrayList <Integer> scores =  school.get(student);
			
			Arrays.sort(scores.toArray());//Sorting the array
			
			best_results.put(student, scores.get(scores.size()));// putting into the new HashMap the student and its higher grade
		}	
		
		//Once all the scores have been obtained 
		
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer> > list =
	               new LinkedList<Map.Entry<String, Integer> >(best_results.entrySet());
		
		// Sorting the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,//comapre() is a method brought from the Comparator interface
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        // put data from sorted list to a new temp hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        
        //get the last element (highest element)
        int higherS = temp.size();
        userIO.print("The student: " + temp
		
	}
	
	
	public void getStudentLScore (HashMap<String, ArrayList <Integer>> school) {//Find and list the student(s) with the lowest quiz score.
		
	}
	*/
	
}
