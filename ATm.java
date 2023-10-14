package Mods;
import java.util.*;
public class ATm {
	// #codsoft
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer,Integer> pincard = new HashMap<>();//created hashmap for cardnumbers and pin
	static HashMap<Integer,String> nameCard = new HashMap<>();//created hashmap for cardnumbers and names
	static HashMap<Integer,Integer> balcard = new HashMap<>();//created hashmap for balance and card
	static List<Integer> pins = new ArrayList<>();//created list for pin
	static List<String> names = new ArrayList<>();//created list for pin
	static List<Integer> cardNumbers = new ArrayList<>();//created list for cardnumbers
	static List<Integer> balance = new ArrayList<>();//created list for balance checking
	static String name;
	static int choice;
	public static void main(String[] args) {
		choice=welcome();
		choice(choice);	
	}
	static void userCreation(String name) {
		System.out.println("Hii "+name);
		System.out.println("We have created your card and use the card number for future transcations");
		System.out.println("Now, set up your pin");
		int pin =pinCreation(name);//creates pin 
		int cardNumber=cardNumberCreation(pin);//creates cardNumber 
		System.out.print("This is your unique card Number : ");
		System.out.println(cardNumber);
		pincard.put(cardNumber, pin);
		System.out.println("Now Deposit of minimum or more than 1000");
		System.out.println("Please enter the Deposit money : ");
		int firstDeposition=sc.nextInt();
		balcard.put(cardNumber, firstDeposition);
		balance.add(firstDeposition);
		names.add(name);
		nameCard.put(cardNumber,name);
	}
	static int pinCreation(String name) {
		System.out.println("Enter 4 digit private pin :");
		int pin = sc.nextInt();
		System.out.println("Confirm your pin :");
		int confirmPin = sc.nextInt();
		if(pin==confirmPin) {
			pins.add(pin);
			System.out.println("Successfully created");
		}
		else{
			System.out.println("pins doesn't match");
			pinCreation(name);
		}
		return pin;
	}
	static int cardNumberCreation(int pin) {
		int cardNumber=(int) (Math.random()*1000);
		cardNumber+=pin*5;
		cardNumbers.add(cardNumber);
		return cardNumber;
	}
	static int welcome() {
		System.out.println("Welcome to Bank of Code");
		System.out.println("Please choose one of the option of services mentioned below :");
		System.out.println("1 - ATM login");
		System.out.println("2 - Create user");
		System.out.println("3 - Staff only");
		System.out.println("4 - Exit");
		System.out.print("Select your choice :");
		choice=sc.nextInt();
		sc.nextLine();
		return choice;
	}
	static void choice(int choice) {
		if(choice==0) { choice=welcome();}
		if(choice==4) {
			System.out.println("Exited");
			System.out.println("All data is gone");
			System.out.println("Thank you for banking with us");
			
			return;
		}
		if(choice==1) {
			System.out.println("Please enter your card number to start for further processing :");
			int checkCardNumber=sc.nextInt();
			boolean checking=pincard.containsKey(checkCardNumber);
			if(checking) {
				System.out.println("You have successfully logged in, please select below option of services");
				System.out.println("1 - Withdraw");
				System.out.println("2 - Deposit");
				System.out.println("3 - Check Balance");
				int checkChoice=sc.nextInt();
				int answer =optionChoice(checkChoice,checkCardNumber);
				System.out.println(answer);
				choice(0);
			}
			else {
				System.out.println("You have entered wrong card number, please do check");
				choice(0);
			}
		}
		if(choice==2) {
			System.out.println("You have choosen to create an new account");
			System.out.println("Kindly fill in the required details to create an account");
			System.out.println("Please enter your name :");
			name=sc.nextLine();
			if(name!=null) {userCreation(name);}
			choice= 0;
			choice(choice);
		}
		if(choice==3) {
			System.out.println("Enter the staff pin :");
			int staffPin=sc.nextInt();
			int spin=8912;
			if(staffPin==spin) {
				System.out.println("All the card numbers in the database");
				for(int i=0;i<names.size();i++) {
					System.out.print("Card holder name :" + nameCard.get(cardNumbers.get(i))+" Balance :");
					System.out.println(balance.get(i));
				}
			choice(0);
			}
			else {
				System.out.println("Entered wrong pin");
				choice(0);
			}
		}
	}
	static int optionChoice(int checkChoice,int cardNumber) {
		int balanceIndex=cardNumbers.indexOf(cardNumber);
		if(checkChoice==3) {
			checkBalance(cardNumber,balanceIndex);
		}
		if(checkChoice==2) {
			deposit(cardNumber,balanceIndex);
		}
		if(checkChoice==1) {
			withdraw(balanceIndex,cardNumber);
		}
		return 1;
	}
	static void withdraw(int balanceIndex, int cardNumber) {
		System.out.println("Enter the amount you want to withdraw :");
		int withdraw=sc.nextInt();
		System.out.println("Enter your pin :");
		int checkpin=sc.nextInt();
		if(pincard.containsKey(cardNumber) && pincard.containsValue(checkpin)) {
			int presentBalance=balance.get(balanceIndex);
			int newBalance=presentBalance-withdraw;
			if(newBalance<500 || newBalance<0) {
				System.out.println("Sorry we are unable to process the request");
				System.out.println("You might have insufficient balance or minimum balance required would become less than 500 after transcation ");
			}
			else {
				balance.set(balanceIndex, newBalance);
				balcard.put(cardNumber, newBalance);
				System.out.println("With drawn an amount of "+withdraw);
			}
		}
	}
	static void deposit(int cardNumber,int balanceIndex) {
		System.out.println("Enter the amout you want to deposit : ");
		int depositMoney=sc.nextInt();
		System.out.println("Enter your pin :");
		int checkpin=sc.nextInt();
		if(pincard.containsKey(cardNumber) && pincard.containsValue(checkpin)) {
			int presentBalance=balance.get(balanceIndex);
			int newBalance=presentBalance+depositMoney;
			balance.set(balanceIndex, newBalance);
			balcard.put(cardNumber, newBalance);
			System.out.println("Deposition of "+depositMoney+" successfully completed");
			}
		else {
			System.out.println("Entered wrong pin");
			choice(0);
		}
	}
	static int checkBalance(int cardNumber,int balanceIndex) {
		balcard.get(cardNumber);
		System.out.println("Enter your pin : ");
		int choicePin=sc.nextInt();
		if(pins.get(balanceIndex)==choicePin) {
		System.out.print("Your balance is :");
		return balance.get(balanceIndex); }
		else {
			System.out.println("Entered wrong pin");
			choice(0);
		}
		return 1;
	}
}
