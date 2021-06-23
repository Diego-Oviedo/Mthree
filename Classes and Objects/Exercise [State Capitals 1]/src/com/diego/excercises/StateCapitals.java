package com.diego.excercises;
import java.util.*;

public class StateCapitals {

	public static void main(String[] args) {

		
		getStates();
		getCapitals();
		getData();
		
	}
	
	
	public static void getStates() {
	
		Map<String, String> states = generateData();
		
		Set <String> keys = states.keySet();
		
		
		System.out.println("\n************************\nSTATES\n************************\n");
		
		for (String state : keys) {
			
			System.out.println(state);
		}
		
		
	}
	
	public static void getCapitals() {
		
		Map<String, String> states = generateData();
		
		Set <String> keys = states.keySet();
		
		
		System.out.println("\n************************\nCAPITALS\n************************\n");
		
		for (String state : keys) {
			
			System.out.println(states.get(state));
		}
		
		
	}
	
	public static void getData() {
		
		Map<String, String> states = generateData();
		
		Set <String> keys = states.keySet();
		
		
		System.out.println("\n************************\nSTATES & CAPITALS\n************************\n");
		
		for (String state : keys) {
			
			System.out.println( state + " - " + states.get(state));
		}
		
		
	}
	
	
	public static Map<String, String> generateData(){
		
		Map<String, String> data_states = new HashMap<>();
		
		data_states.put("Alabama","Montgomery");
		data_states.put("Alaska","Juneau");
		data_states.put("Arizona","Phoenix");
		data_states.put("Arkansas","LittleRock");
		data_states.put("California","Sacramento");
		data_states.put("Colorado","Denver");
		data_states.put("Connecticut","Hartford");
		data_states.put("Delaware","Dover");
		data_states.put("Florida","Tallahassee");
		data_states.put("Georgia","Atlanta");
		data_states.put("Hawaii","Honolulu");
		data_states.put("Idaho","Boise");
		data_states.put("Illinois","Springfield");
		data_states.put("Indiana","Indianapolis");
		data_states.put("Iowa","DesMoines");
		data_states.put("Kansas","Topeka");
		data_states.put("Kentucky","Frankfort");
		data_states.put("Louisiana","BatonRouge");
		data_states.put("Maine","Augusta");
		data_states.put("Maryland","Annapolis");
		data_states.put("Massachusetts","Boston");
		data_states.put("Michigan","Lansing");
		data_states.put("Minnesota","SaintPaul");
		data_states.put("Mississippi","Jackson");
		data_states.put("Missouri","JeffersonCity");
		data_states.put("Montana","Helena");
		data_states.put("Nebraska","Lincoln");
		data_states.put("Nevada","CarsonCity");
		data_states.put("NewHampshire","Concord");
		data_states.put("NewJersey","Trenton");
		data_states.put("NewMexico","SantaFe");
		data_states.put("NewYork","Albany");
		data_states.put("NorthCarolina","Raleigh");
		data_states.put("NorthDakota","Bismarck");
		data_states.put("Ohio","Columbus");
		data_states.put("Oklahoma","OklahomaCity");
		data_states.put("Oregon","Salem");
		data_states.put("Pennsylvania","Harrisburg");
		data_states.put("RhodeIsland","Providence");
		data_states.put("SouthCarolina","Columbia");
		data_states.put("SouthDakota","Pierre");
		data_states.put("Tennessee","Nashville");
		data_states.put("Texas","Austin");
		data_states.put("Utah","SaltLakeCity");
		data_states.put("Vermont","Montpelier");
		data_states.put("Virginia","Richmond");
		data_states.put("Washington","Olympia");
		data_states.put("WestVirginia","Charleston");
		data_states.put("Wisconsin","Madison");
		data_states.put("Wyoming","Cheyenne");
		
		return data_states;
		
	}

}
