/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

/**
 * Our person class
 * @author ercan
 * @param E any type
 */
public class Person<E>{
    /**
     * name of person
     */
    private String name;
    /**
     * name of parent
     */
    private String parents;
    /**
     * name of family name
     */
    private String nickname;
    /**
     * Default constructor
     */
    public Person() {
        this.name = "";
        this.parents = "";
        this.nickname = "";
    }
   /**
    * 3 parameters constructor
    * @param name name  of person
    * @param parents name of parents
    * @param nickname name of family
    */
    public Person(String name, String parents, String nickname) {
        this.name = name;
        this.parents = parents;
        this.nickname = nickname;
    }
    /**
     * Getter method
     * @return name of person
     */
    public String getName() {
        return name;
    }
    /**
     * Setter method
     * @param name set a new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter method
     * @return name of parent
     */
    public String getParents() {
        return parents;
    }
    /**
     * Setter method
     * @param parents set a new parent name 
     */
    public void setParents(String parents) {
        this.parents = parents;
    }
    /**
     * Getter method
     * @return name of family
     */
    public String getNickname() {
        return nickname;
    }
    /**
     * Setter method
     * @param nickname set a new family name 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * To string method
     * @return information about this class
     */
    @Override
    public String toString(){
       return name + ", " +
              parents + ", " +
              nickname + "\n";
               
    }
    
}
