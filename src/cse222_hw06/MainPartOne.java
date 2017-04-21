/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

/**
 *
 * @author ercan
 */
public class MainPartOne {
     public static void main(String[] args){
         
        BinaryHeap<Double> heap = new BinaryHeap();
        BinaryTree<Double> btree = new BinaryTree<>();

	//****************Test insert & deleteMin function*****************
	System.out.println("Test insert and deleteMin function: ");
	System.out.println("Insert: 10.0, 8.0, 20.0, 3.0, 6.0, 5.0, 12.0");
	double[] insertArray = {10.0, 8.0, 20.0, 3.0, 6.0, 5.0, 12.0};
	for (int i = 0; i < insertArray.length; i++)
            heap.insert(insertArray[i]);  
	
	String insertTest = heap.toString();
        for(int i=1; i < heap.size()+1; ++i)
            btree.insert(heap.get(i));
        
	System.out.println("Inserted output heap:" + insertTest);		
	System.out.println("Inserted output btree: \n" +btree.toString() );		
	System.out.print("Deleted order: \n");
	Comparable[] temp = new Comparable[heap.size()];
	boolean sorted = true;
	for (int i = 0; i< insertArray.length; i++)
            temp[i] =  heap.deleteMin();
           
	for (Comparable node : temp) {
		System.out.print(node+" ");
	}
	for (int i = 0; i < temp.length -1; i++) {
            if (temp[i].compareTo(temp[i+1])>1){
		sorted = false;
            }
	}
	
	if (sorted == true) 
            System.out.println("** Sorted Pass!**");
	System.out.println();
     }
    
}
