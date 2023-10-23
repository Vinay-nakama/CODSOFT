package Mods;
import java.util.*;
public class STUDENT_GRADE_CALCULATOR {
	// #codsoft
	static  Scanner sc=new Scanner(System.in);
	static List<String> names = new ArrayList<>();
	static List<String> grade = new ArrayList<>();
	static List<Integer> roll = new ArrayList<>();
	static List<Integer> English = new ArrayList<>();
	static List<Integer> DSa = new ArrayList<>();
	static List<Integer> Python = new ArrayList<>();
	static List<Integer> PythonLab = new ArrayList<>();
	static List<Integer> OpenElective = new ArrayList<>();
	static List<Integer> Network = new ArrayList<>();
	static List<Integer> avg = new ArrayList<>();
	static List<Integer> total = new ArrayList<>();
	
	public static void main(String[] args) {
		choice();
	}
	static void choice() {
		System.out.println("Press 1 to enter details and marks of the student");
		System.out.println("Press 2 to view the student details");
		int user_choice=sc.nextInt();
		if(user_choice==1) {
			profile();
		}
		if(user_choice==2) {
			viewDetails();
		}
	}
	static void profile() {
		int sno=100;
		int Roll_Number=sno++;
		System.out.print("Enter the name of the Student : ");
		String name = sc.nextLine();
		roll.add(Roll_Number);
		names.add(name);
		Submarks();
	}
	static void Submarks() {
		sc.next();
		System.out.print("Enter English subject marks : ");
		int Eng=sc.nextInt();
		English.add(Eng);
		System.out.print("Enter DSA subject marks : ");
		int DSA=sc.nextInt();
		DSa.add(DSA);
		System.out.print("Enter Python subject marks : ");
		int Pyt=sc.nextInt();
		Python.add(Pyt);
		System.out.print("Enter Python lab marks : ");
		int PytL=sc.nextInt();
		PythonLab.add(PytL);
		System.out.print("Enter Open elective Subject marks : ");
		int opene=sc.nextInt();
		OpenElective.add(opene);
		System.out.print("Enter Networking Subject marks : ");
		int net=sc.nextInt();
		Network.add(net);
		int Total = Eng+DSA+Pyt+PytL+opene+net;
		int Average=Total/6;
		total.add(Total);
		avg.add(Average);
		gradeEvaluation();
		
	}
	static void viewDetails() {
		for(int i=0;i<roll.size();i++) {
		System.out.print("StudentId : "+roll.get(i)+" ");
		System.out.print("Name : "+names.get(i)+" ");
		System.out.print("Engish marks : "+English.get(i)+" ");
		System.out.print("DSA marks : "+DSa.get(i)+" ");
		System.out.print("Python marks : "+Python.get(i)+" ");
		System.out.print("Python Lab marks : "+PythonLab.get(i)+" ");
		System.out.print("Networking marks : "+Network.get(i)+" ");
		System.out.print("Open elective marks : "+OpenElective.get(i)+" ");
		System.out.println("Total : "+total.get(i)+" ");
		System.out.println("Average : "+avg.get(i)+" ");
		System.out.println("Grade Obtained : "+grade.get(i)+" ");
		}
		choice();
	}

	static void gradeEvaluation() {
		int fail=0;
		for(int i=0;i<avg.size();i++) {	
		String Grade="";
		
		int Average=avg.get(i);
		if(Average>=90) {
			Grade="O";
		}
		else if(Average>=81 && Average<90) {
			Grade="A+";
		}
		else if(Average>=71 && Average<=80) {
			Grade="A";
		}
		else if(Average>=61 && Average<=70) {
			Grade="B+";
		}
		else if(Average>=51 && Average<=60) {
			Grade="B";
		}
		else if(Average>=41 && Average<=50) {
			Grade="C";
		}
		else if(Average>=35 && Average<=40) {
			Grade="D";
		}
		else {
			Grade="F";
		}
		if(English.get(i)<35 || DSa.get(i)<35 || Python.get(i)<35 || PythonLab.get(i)<35 || Network.get(i)<35 || OpenElective.get(i)<35 ) {
			Grade="F";
		}
		grade.add(Grade);
		}
	choice();
	}
}
