package Mods;
import java.util.Scanner;
public class STUDENT_GRADE_CALCULATOR {
	// #codsoft
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no of Subjects: ");
		int n = sc.nextInt();
		int[] Subject=new int[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter Subject "+ (i+1) +" marks :");
			Subject[i]=sc.nextInt();
		}
		int fail=0;
		int Total=0,Average=0;
		for(int i=0;i<n;i++) {
			Total+=Subject[i];
			if(Subject[i]<35) fail++;
		}
		Average=Total/n;
		String Grade="";
		
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
		if(fail>0) { Grade="F"; System.out.println("Failed in "+fail+" subjects") ;}
		
		System.out.println("Total marks: "+Total);
		System.out.println("Average Percentage: "+Average);
		System.out.println("Obtained Grade:"+Grade);
	}

}
