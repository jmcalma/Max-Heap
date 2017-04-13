package edu.cpp.cs.cs241.Project2;
import java.util.*;

public class Project2{
	public static void main(String[] args){
		MaxHeap heap = new MaxHeap();
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers");
		System.out.println("(2) Fixed integer values 1-100");
		System.out.print("Enter choice: ");

		Scanner read = new Scanner(System.in);
		String input = read.next();
		System.out.println();
		if(input.equals("1")){
			heap.choice1();
		}
		else if(input.equals("2")){
			heap.choice2();
		}else{
			System.out.println("Invalid input. You must input 1 or 2.");
			main(args);
		}
		read.close();
	}
}
