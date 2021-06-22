package com.diego.assessments;
import java.util.*;

public class DogGenetics {

	public static void main(String[] args) {
		
		getGenetics();
		
	}
	

	public static void getGenetics() {
	
		System.out.println("************************\nDOG GENETICS\n************************\n");
		
		System.out.print("What is your dog's name?");
		String dog_name = new Scanner(System.in).next();
		int first_position = 0;
		int second_position = 0;
		int third_position = 0;
		int fourth_position = 0;
		int fifth_position = 0;
		
		
		System.out.println("Well then, I have this highly reliable report on " +dog_name+ "'s prestigious background right here.\n");
		
		System.out.println(dog_name + " is:\n");
		
		
		String [] breeds = {"Greyhound","Greater Swiss Mountain","Gordon Setter","Golden Retriever","German Spitz","German Shorthaired Pointer","Entlebucher Mountain","English Springer Spaniel","English Foxhound","English Cocker",
							"Dalmatian","Dandie Dinmont","Dogo Argentino","Deutscher Wachtelhund","Beagle","Basset Hound","Barbado da Terceira","Australian Kelpie","American Water Spaniel","American Hairless Terrier",
							"American Eskimo","Airedale Terrier","Affenpinscher","Afghan Hound","Croatian Sheepdog","Chihuahua","Chow Chow","Cirneco dell’Etna","Cocker Spaniel","Collie"};
		
		first_position = new Random().nextInt(50);
		
		System.out.println(first_position + "% " + breeds[new Random().nextInt(4)]);
		
		second_position = (100 - first_position) / 2;
		
		System.out.println(second_position + "% " + breeds[new Random().nextInt(10)]);
		
		third_position = second_position / 2 ;
		
		System.out.println(third_position + "% " + breeds[new Random().nextInt(15)]);
		
		fourth_position = third_position / 2;
		
		System.out.println(fourth_position + "% " + breeds[new Random().nextInt(20)]);
		
		fifth_position = 100 - (first_position + second_position + third_position + fourth_position);

		System.out.println(fifth_position + "% " + breeds[new Random().nextInt(29)]);
		
		System.out.println("\n\nWow, that's QUITE the dog!");
		
	}
	
	
}
