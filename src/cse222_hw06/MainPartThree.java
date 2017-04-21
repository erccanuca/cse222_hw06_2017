/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ercan
 */
public class MainPartThree {
    
    
    public static void main(String[] args) throws FileNotFoundException{
        
        FamilyTree<String> familyTree;
        String name = null;
        String parentname = null;
        String nickname = null;

        try (Scanner scanner = new Scanner(new FileInputStream(new File("family.txt")))) {
            familyTree = new FamilyTree<>(scanner.nextLine()); // add root
            while(scanner.hasNextLine()){
                
                for(String line : scanner.nextLine().split("\n")){
                    Scanner s = new Scanner(line);
                    s.useDelimiter(",");
                    while(s.hasNext()){
                        name = s.next();
                        parentname = s.next();
                        nickname = s.next();
                    }
                    familyTree.insert(new Person(name, parentname, nickname));  
                } 
            }
            scanner.close();
        }
        System.out.println("********** Family.txt test toString ***************");
        System.out.println(familyTree.toString());
        
        
        System.out.println("********** Family.txt Test Level-order **************");
        Iterator familyIter = familyTree.iterator();
        while(familyIter.hasNext()){
            System.out.print(familyIter.next()+ " ");
        }
        System.out.println("");
    }   
}