package assignment2;

//Erjon Musa 20296816

import java.util.Scanner;
import java.util.Random;

public class GuessMaster {
	private int numberOfCandidateEntities;
	private Entity[] entities;
	private int totalPointsAwarded;
	private static boolean quit = false;
	
	//default constructor 
	public GuessMaster() {
		//initializing that there are 0 candidates
		numberOfCandidateEntities = 0;
		//setting max length of the entity to 100
		entities = new Entity[100];
		totalPointsAwarded = 0;
	}
	
	//function that adds an entity and increases the number of candidates by 1
	public void addEntity(Entity entity) {
		Entity entityClone = entity.clone();
		entities[numberOfCandidateEntities++] = entityClone;
		
	}
	
	public void playGame(Entity entity) {
		
		//setting up scanner 
		Scanner sc = new Scanner(System.in);
		//created variable for the name of the entity
		String name = entity.getName();
		
		//storing the last letter of the entities name
		char lastLetter = name.charAt(name.length() -1 );
		
		System.out.println("*********************************");
		System.out.println(entity.welcomeMessage() + "\n");
		//checks if the last letter is 's' to follow grammar rules
		if(lastLetter != 's') {
			System.out.println("Guess " +entity.getName() + "'s birthday \n(MM/DD/YYYY)");
		}
		else {
			System.out.println("Guess " +entity.getName() + "' birthday \n(MM/DD/YYYY)");
		}
		
		
		//creating a while loop for the game to keep playing after a guess from the user
		while(true){
			String input = sc.nextLine();
			
			String quitInput = "quit";
			if(quitInput.equalsIgnoreCase(input)) { 
				//setting quit variable to true when the user inputs quit
				quit = true;
				//breaking out of the loop when user types quit4
				break;
			}
			
			Date newDate = new Date(input);
		
			//print message if date guessed  correctly with all required information
			if(newDate.equals(entity.getBorn())) {
				//ticket information printing
				System.out.println("*************Bingo!**************");
				System.out.println("You won " + entity.getAwardedTicketNumber() + " tickets in this round.");
				//updating the total points then printing
				totalPointsAwarded += entity.getAwardedTicketNumber();
				System.out.println("The total number of your tickets is " + totalPointsAwarded + ".");
				System.out.println("*********************************");
				//Entity information prints
				System.out.println(entity.toString()); 
				//break out of loop after correct guess to go onto next part
				break;
			}
			
			//return message if user date is earlier than inputed date
			else if(newDate.precedes(entity.getBorn())) {
				System.out.println("Incorrect. Try a later date.");
			}
			
			//return message if later than inputed date
			else if(entity.getBorn().precedes(newDate)) {
				System.out.println("Incorrect. Try a earlier date.");
			}
		}
	}
	//plays the game with the entity at the random index 
	public void playGame(int entityInd) {
		playGame(entities[entityInd]);
	}
	
	//generates a random index to be used in the Entity array 
	public void playGame() {
		playGame(genRandomEntityInd());
	}
	
	//returns a random int
	int genRandomEntityInd() {
		Random randNumb = new Random();
		//will find a random numbers between 0 and numberOfCandidateEntities
		int rand = randNumb.nextInt(numberOfCandidateEntities);
		return rand;
		
	}

	public static void main(String[] args) {
		//only prints once per game
		System.out.println("========================\n");
		System.out.println("    GuessMaster 2.0\n");
		System.out.println("========================\n");
		
		//Creating entities to add to the game
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), 0.25, "Male", "Liberal");
		Singer dion =  new Singer("Celine Dion", new Date("March", 30, 1961), 0.5, "Female", "La voix du bon Dieu", new Date("November", 6, 1981));
		Student musa = new Student("Erjon Musa", new Date("August", 16, 2003), 1, "Male", "Computer Engineering", new Date("April", 29, 2025), "Queen's University");
		Country usa = new Country("United States", new Date("July", 4, 1776), 0.1, "Washington D.C.");
		Student ritchie = new Student("Thor Ritchie", new Date("June", 6, 2003), 0.7, "Male", "Political Science", new Date("April", 24,2027), "University of Toronto");
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), 1, "Female");
		Singer travis = new Singer("Travis Scott", new Date("April", 30, 1992), 0.6, "Male", "Days Before Rodeo", new Date("September", 4, 2015));
		Country albania = new Country("Albania", new Date("November", 28, 1912), 0.8, "Tirana");
		Student toivonen = new Student("Alyssa Toivonen", new Date("September", 30, 2003), 0.4, "Female", "Engineering Chemistry", new Date("April", 28, 2025), "Queen's University");
		Politician obama = new Politician("Barack Obama", new Date("August", 4, 1961), 0.75, "Male", "Democratic");
		Student jake = new Student("Jake Muller-Pett", new Date("July", 24, 2003), 0.8, "Male", "Life Science", new Date("April", 22, 2025), "McMaster University");
		Singer sergioKitchens = new Singer("Gunna", new Date("June", 14,1993), 0.75, "Male", "Drip or Drown 2", new Date("February", 22, 2019));
		Student connor = new Student("Connor Cheng-roy", new Date("April", 4, 2003), 0.6, "Male", "Mechanical Engineering", new Date("April", 27, 2031), "Toronto Metropolitan University");
		
		GuessMaster gm = new GuessMaster();
		
		//adding the declared entities to the game
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(musa);
		gm.addEntity(usa);
		gm.addEntity(ritchie);
		gm.addEntity(myCreator);
		gm.addEntity(travis);
		gm.addEntity(albania);
		gm.addEntity(toivonen);
		gm.addEntity(obama);
		gm.addEntity(jake);
		gm.addEntity(sergioKitchens);
		gm.addEntity(connor);
		
		
		//playing the game
		while (true) {
			gm.playGame();
			//checks if the variable quit is marked true to quit
			if(quit == true) {
				//exit message
				System.out.println("Thanks for playing!");
				break;
			}
		}
	}
}
	

