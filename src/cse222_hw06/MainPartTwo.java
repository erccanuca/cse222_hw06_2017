/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse222_hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ercan
 */
public class MainPartTwo {
    
    
    public static void main(String[] args) throws FileNotFoundException{
        
       HuffmanTree Htree = new HuffmanTree();
       // Create symbol array
       HuffmanTree.HuffData[] symbols = new HuffmanTree.HuffData[27];

       try (Scanner scanner = new Scanner(new File("freq.txt"))) {
            int i=0;
            while(scanner.hasNextLine()){

                for(String line : scanner.nextLine().split("\n")){
                    Scanner s = new Scanner(line);
                    s.useDelimiter(",");
                    String character ="";
                    int freq = 0;
                    while(s.hasNext()){
                       
                        freq = s.nextInt();
                        character = s.next();
                    }
                    symbols[i++] = new HuffmanTree.HuffData(freq,character.charAt(0));
                }
            } 
            
            scanner.close();
        }
        // Build hufffman tree 
        Htree.buildTree(symbols);
        
        // Print huffman codes of the symbols
        String EncodedSymbolList = Htree.toString();
        
        // Decode huffman codes to symbols
        String code = "01000100000010100111111000010000010101111011101000000100110111010";
        String decodedCode = Htree.decode(code);
        System.out.println("Code to Message : \n"+code+" : \t"+decodedCode);
         // Build hufffman tree 
        
       BinaryTree<HuffmanTree.HuffData> tree =  new BinaryTree();
       String message = "ercan uca encode";
       String encodedMessage = Htree.encode(message, tree);
       System.out.println("\nMessage to code : \n"+message+" : \t"+encodedMessage);

    }

}
