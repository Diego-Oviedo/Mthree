package com.diego.excercises;
import java.io.*;
import java.util.*;

public class StateCapitals2 {

	public static void main(String[] args) {
	
		
		Map<String, String> data =importData("StateCapitals.txt");

		getStates(data);
		
		startTrivia(data);
	
	
	}
	
	
	
	
	
	public static Map<String, String> importData(String path){
		
		Map<String, String> data_states = new HashMap<>();
		UserIO userIO = new UserIOImplementation();
		int counter = 0;
		
		try {
		      File file = new File(path);
		      Scanner reader = new Scanner(file);
		      reader.useDelimiter("::");
		      
		      
		      while (reader.hasNextLine()) {
		    	
		    	  String state = reader.next();
		    	  String capital = reader.nextLine();
		    	  
		    	  capital = capital.substring(2,capital.length());
		       
		    	  data_states.put(state, capital);
		    	  
		    	  counter++;
		      }
		      
		      reader.close();
		      
		    } catch (FileNotFoundException e) {
		    	userIO.print("An error occurred.");
		      e.printStackTrace();
		    }
		
		userIO.print(counter + " STATES & CAPITALS WERE LOADED.");
		
		return data_states;
	}
	
	public static void getStates(Map<String, String> data) {

		Set <String> keys = data.keySet();
		UserIO userIO = new UserIOImplementation();
		
		userIO.print("\n************************\nSTATES\n************************\n");
		
		for (String state : keys) {
			
			System.out.print(state + ", ");
		}
		
		
	}	
	
	public static void startTrivia(Map<String, String> data) {
		UserIO userIO = new UserIOImplementation();
		userIO.print("\n************************\nTRIVIA\n************************\n");
		int counter = 0 ;
		Set <String> keys = data.keySet();
		String selected_state = null;
		
		int random_number = new Random().nextInt(50);
		
		for (String state : keys) {
			
			if(counter == random_number) {
			 selected_state = state;
			}
			counter ++;
			
			}
	

		String capital = data.get(selected_state);

		String user_response = userIO.readString("READY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF " + selected_state + " ?");
		
		if(user_response.equalsIgnoreCase(capital)) {
			
			userIO.print("NICE WORK! " + user_response + " IS CORRECT!");
		}else if (!user_response.equalsIgnoreCase(capital)) {
			
			userIO.print("Nice try, but " + user_response + " is not the capital of "+selected_state+ "!\nIt is: " + capital);
			
		}
		
	}
	
	
	
}
