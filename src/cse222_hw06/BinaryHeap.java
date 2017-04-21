/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

import java.util.Queue;

/**
 *
 * @author ercan
 */
public class BinaryHeap<E extends Comparable<E>> extends BinaryTree<E> implements Queue<E>{
    
    private static final int CAPACITY = 11;
    private int heapsize = 0;
    private int capacity = 0;
    private E[] heap; 

    public BinaryHeap() {
        this.capacity = CAPACITY;
        this.heap = (E[])new Comparable[capacity];
        this.heapsize = 0;
    }

    @Override
    public boolean isEmpty(){
       return (heapsize == 0);
    }
    
    @Override
    public int size(){
        return heapsize;
    }
    
    public Comparable findMin(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        return heap[1];
    }
    /**
     * insert data
     * @param data to insert 
     */
    @Override
    public void insert(E data) {
	// check if the array is full, if it is then we have to re-size
	if (heapsize == capacity){
            E[] newHeap = (E[])new Comparable[2*capacity+1];
	    for (int i = 0; i <= heapsize; i++) {
		newHeap[i] = heap[i];
	    }
	    heap = newHeap;
            capacity = 2*capacity;  
	}
	heapsize++;	
	//percolate up
	int index = percolateUp(heapsize,data); // pass in the last index and inserted value -> return the correct location
	heap[index] = data; 
    }
    
    public Comparable deleteMin(){
        if(isEmpty())
            throw new NullPointerException();
        int hole;
        Comparable minValue = heap[1];
        hole = percolateDown(1,heap[heapsize]);
        heap[hole] = heap[heapsize];
        heapsize--;
        
        return minValue;   
    }
    @Override
    public void clear(){
        heap = (E[])new Comparable[CAPACITY];
        heapsize = 0;
    }
    public E get(int i){
        return heap[i];
    }
    /**
    * This method reorders the heap by comparing the value of the child and its parent,
    * if the child has the higher priority, then swap them.
    * @param hole This is the index location of the last value
    * @param data This is the value that we want to insert into the array
    * @return integer This returns the index of the location where to insert the value
    */
    public int percolateUp(int hole, E data){
        while(hole > 1 && heap[hole/2].compareTo(data)==-1){
            // when the inserted data is not at the top of the tree,
            // and data has higher priority than its parents
            heap[hole] = heap[hole/2]; // DO: swap the child with parent
            hole = hole/2;             // update the index location
        }
        return hole;
    }
    /**
    * This method rearranges the order of the heap by taking in the index of the first priority 
    * and the element from the right bottom (the last element of the heap) and 
    * returns a new index location for the last element.
    * @param hole This is the index of the node which has the highest priority
    * @param data This is the last value of the heap
    * @return integer This returns the index of the location where to delete the value
     */
    public int percolateDown(int hole, E data){
        
        int target;
        while(2*hole <= heapsize){
            int left = 2*hole;
            int right = left + 1;
            
            if(right > heapsize || (heap[left].compareTo(heap[right])==1 || heap[left].compareTo(heap[right])==0)){
                target = left;
            }else{
                target = right;
            }
            if(heap[target].compareTo(data) == 1){
                heap[hole] = heap[target]; // swap
                hole = target;
            }
            else
                break;
        }
        return hole;
    }
    
    @Override
    public String toString(){
        String str= "";
        for(int i = 1; i < heapsize+1; ++i){
            str += heap[i] + " ";
        }
        return str;
    }
}
