package edu.cpp.cs.cs241.Project2;

public class MaxHeap{
	private int[] heap;
	private int swaps;
	private int size;

	//creates an array for the max heap
	//sets the size variable to 100
	public MaxHeap(){
		heap = new int[100];
		size = 100;
	}

	//Performs sequential insertion for 20 random sets of 100 positive integers
	//then calculates the average amount of swaps performed.
	//Performs the optimal method for 20 random sets of 100 positive integers
	//then calculates the average amount of swaps performed.
	public void choice1(){
		swaps = 0;
		for(int i = 0; i < 20; i++){
			heap = randomList();
			sequentialInsertion();
		}
		System.out.println("Average swaps for series of insertions: " + swaps/20);

		swaps = 0;
		for(int i = 0; i < 20; i++){
			heap = randomList();
			optimalMethod();
		}
		System.out.println("Average swaps for optimal method: " + swaps/20);
	}

	//Outputs the first 10 integers in the max heaps created by the sequential insertion 
	//and optimal method. Outputs the number of swaps for sequential insertion and optimal method.
	//Then perform 10 removals on the heaps and outputs the the first 10 integers.
	public void choice2(){
		swaps = 0;
		heap = fixedList();
		sequentialInsertion();
		System.out.print("Heap built using series of insertions: ");
		for(int i = 0; i < 10; i++){
			System.out.print(heap[i] + ", ");
		}
		System.out.println("...");
		System.out.println("Number of swaps: " + swaps);
		for(int i = 0; i < 10; i++){
			remove();
		}
		System.out.print("Heap after 10 removals: ");
		for(int i = 0; i < 10; i++){
			System.out.print(heap[i] + ", ");
		}
		System.out.println("...");
		System.out.println();


		swaps = 0;
		heap = fixedList();
		optimalMethod();
		System.out.print("Heap built using optimal method: ");
		for(int i = 0; i < 10; i++){
			System.out.print(heap[i] + ", ");
		}
		System.out.println("...");
		System.out.println("Number of swaps: " + swaps);
		for(int i = 0; i < 10; i++){
			remove();
		}
		System.out.print("Heap after 10 removals: ");
		for(int i = 0; i < 10; i++){
			System.out.print(heap[i] + ", ");
		}
		System.out.print("...");
	}

	//Removes the largest value in the max heap, which is the first item by
	//replacing the largest value with the value at the end of the array and
	//then decreasing the size of the heap by one. Then perform a downward
	//reheapification.
	private void remove(){
		heap[0] = heap[size-1];
		size--;
		heapifyDown(0);
	}

	//Creates a heap and inserts a value from the set of 100 positive integers
	//one at a time and after each insert, perform upward reheapification.
	private void sequentialInsertion(){
		int[] newHeap = new int[size];
		for(int i = 0; i < size; i++){
			newHeap[i] = heap[i];
			int j = i;
			while(j > 0){
				if(newHeap[j] > newHeap[(j-1)/2]){
					int temp = newHeap[j];
					newHeap[j] = newHeap[(j-1)/2];
					newHeap[(j-1)/2] = temp;
					swaps++;
				}
				j = (j-1)/2;
			}
		}
		heap = newHeap;
	}

	//Performs reheapification for an unsorted complete binary tree.
	private void optimalMethod(){
		for(int i = size-1; i > 0; i--){
			heapifyUp(i);
		}
	}

	//Swaps the positions of the parent and the child if
	//the child is greater than the parent.
	private void heapifyUp(int index){
		if(index != 0){
			if(heap[(index-1)/2] < heap[index]){
				int temp = heap[(index-1)/2];
				heap[(index-1)/2] = heap[index];
				heap[index] = temp;
				swaps++;
				heapifyUp((index-1)/2);
			}
		}
	}

	//Swaps the positions of the parent and the child if
	//the parent is less than the child.
	private void heapifyDown(int index){
		int max;
		int left = (2*index)+1;
		int right = (2*index)+2;
		if(right >= size){
			if(left >= size){
				return;
			}else{
				max = left;
			}
		}else{
			if(heap[left] > heap[right]){
				max = left;
			}else{
				max = right;
			}
		}
		if(heap[index] < heap[max]){
			int temp = heap[max];
			heap[max] = heap[index];
			heap[index] = temp;
			heapifyDown(max);
		}
	}

	//Creates an array filled with values ordered from 1 to 100.
	private int[] fixedList(){
		int[] list = new int[100];
		size = 100;
		for(int i = 0; i < 100; i++){
			list[i] = i+1;
		}
		return list;
	}

	//Creates an array filled with 100 random positive integer values.
	private int[] randomList(){
		int[] list = new int[100];
		size = 100;
		for(int i = 0; i < 100; i++){
			list[i] = (int)(Math.random() * 100);
		}
		return list;
	}
}
