/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Extends Binary tree and implements Iterable
 * @author ercan
 * @param E any type
 */
public class FamilyTree<E> extends BinaryTree<E> implements Iterable<E>{
   /**
    * For iterator pre order
    */
    private LinkedList<Node<E>> parent= null;
    private Queue<Node<E>> queue= null;
    /**
     * Default constructor
     */
    public FamilyTree() {
        super();
    }
    /**
     * Constructor for root
     * @param name name of root
     */
    public FamilyTree(E name) {
        // insert root. with name
        this.root = new Node<>(name);
        try {
             if(root == null)
                 throw new NullPointerException();
         } catch (NullPointerException e) {
             e.printStackTrace(System.err);
         }
        /**
         * To make Pre-order iterator family
         */
        this.parent = new LinkedList<>();
        this.queue = new LinkedList<>();
        
        
    }
    /**
     * Insert person to family tree
     * @param p person class type
     */
    public void insert(Person p){
        String addIt = p.getName();
        String parentname = p.getParents();
        String nickname = p.getNickname();
        
        Node<E> willAdd = new Node<>((E)addIt);
        Node<E> parentNode,currentNode;
       
        if(root== null){
            root = willAdd;
        }else if(parentname.equals("")){
           if(root.right == null){
               root.right = willAdd;
           }else{
               currentNode = root;
               while (currentNode.right != null) 
                    currentNode = currentNode.right;
               currentNode.right = willAdd;   
           }
        }else{
            parentNode = findParent(root, parentname);
            if(parentNode == null){
                //System.out.println("Parent is not exist!");
            }else if(parentNode.left == null){
                parentNode.left = willAdd;
            }else{
                currentNode = parentNode.left;
                if(parentNode.data.equals(parentname)){
                    while (currentNode.right != null) 
                        currentNode = currentNode.right;
                    currentNode.right = willAdd;
                }
                else if(currentNode.data.equals(parentname) && currentNode.data.equals(nickname.substring(4))){
                    while (currentNode.left != null) 
                        currentNode = currentNode.left;
                    currentNode.left = willAdd;
                }
            }
            
        }    
    }
    /**
     * Find parent to make processing
     * @param localRoot parent root
     * @param parentname parent name
     * @return return parent as make processing
     */
    private Node<E> findParent(Node<E> localRoot, String parentname){
        Node<E> current = localRoot;
        if(current.data.equals(parentname)){
            return current;
        }
        if(current.left != null){
            Node<E> found = findParent(current.left, parentname);
            if(found != null)
                return found;
        }
        if(current.right != null){
            return findParent(current.right, parentname);
        }
        return null;
    }

    /**
     * To string method
     * @return return information about this class
     */
    @Override
    public String toString() {
        return super.toString();
    }
    /**
     * Our iterator method
     * @return this iterator
     */
    @Override
    public Iterator<E> iterator() {
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            this.parent.add(node);
            
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            
            
        }
        return new myIter<>();
    }
    /**
     * Inner iterator class
     * @param <E> any type
     */
    private class myIter<E> implements Iterator<E>{

        /**
        * Iterator has next method
        * @return true if has next
        */
        @Override
        public boolean hasNext() { 
            return !parent.isEmpty();
        }
        /**
        * iterator next element method
        * @return next element pre ordering
        */
        @Override
        public E next() {
            Node<E> current = (Node<E>) parent.poll();
            return current.data;
        }
    } 
}
