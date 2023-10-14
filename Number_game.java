package Mods;
import java.util.*;
public class Number_game {
	// #codsoft
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double rand= Math.random();
		int Random = (int) (rand*(100));
		System.out.println("Welcome to the game of guessing number");
		System.out.println("Rules are simple you are given a chances of 5, in those 5 chances you need to guess the number which is in between 1-100");
		int Count=0;
		int Chances=5;
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
			
			break;
		}
	}
		if(Count==0) {
			System.out.println("You are out of Chances");
			System.out.println("The answer is "+Random+" and you are so close to the answer, Better luck next time");
		}
	}

}
