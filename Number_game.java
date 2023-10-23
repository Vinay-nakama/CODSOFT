package Mods;
import java.util.*;

public class Number_game {
// #codsoft
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int Random = guessvalue();
		int choice = 1;
		game(Random,choice);
	}

 static void game( int Random,int choice) {
	 System.out.println("Welcome to the game of guessing number");
		System.out.println("Rules are simple you are given a chances of 5, in those 5 chances you need to guess the number which is in between 1-100");
	 int Count=0;
	 int Chances=5;
	 int score=0;
	 if(choice==1) {
	 for(int i=0;i<Chances;i++) {
			System.out.println("Take a Guess: ");
			int Guess=sc.nextInt();
			
			if(Guess<Random) {
			System.out.println("The Guess is lower than the value");
			System.out.println("Chances Remaining: "+ (Chances-i-1));
		}
		else if(Guess>Random){
			System.out.println("The Guess is higher than value");
			System.out.println("Chances Remaining: "+ (Chances-i-1));
		}
		else if(Guess==Random) {
			Count++;
			System.out.println(Guess+" is the answer and you are magnificent!!");
			System.out.println("Score : "+Chances*20);
			System.out.println("Press 1 to play again");
			System.out.println("Press 2 to exit");	
			int choiced = sc.nextInt();
			if(choiced==1) {game(Random,choiced);}
			
		}
	}
		if(Count==0) {
			System.out.println("You are out of Chances");
			System.out.println("The answer is "+Random+" and you are so close to the answer, Better luck next time");
			System.out.println("Score : 0");
			System.out.println("Press 1 to play again");
			System.out.println("Press 2 to exit");	
			int choiced = sc.nextInt();
			if(choiced==1) {game(Random,choiced);}
			else {System.out.print("Game exited");}
		}
 }
	 else if(choice==2) {
		 	System.out.print("Game exited");
	 }
	 }

static int guessvalue() {
	double rand= Math.random();
	int Random = (int) (rand*(100));
	return Random;
}}
