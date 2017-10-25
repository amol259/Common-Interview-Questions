/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquecharacters;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author amolsidhu
 */
public class UniqueCharacters {

    
    public static void main(String[] args) {
        // TODO code application logic here
        String input= "aasfg";
        
        System.out.println(optimizedSoln(input));
        
        
    }
    
    private static boolean checkIfStringIsUnique(String input){
        
        for(int i=0;i<=input.toCharArray().length;i++){
            for(int j=i+1;j<=input.toCharArray().length-1;j++)
                if(input.charAt(i) == input.charAt(j))
                    return false;       
    }
    return true;
    }
    
    
    private static boolean optimizedSoln(String input){
        //create a hashset
        Set<Character> unique= new HashSet<>();
        
       char[] Str = input.toCharArray();
       //iterate through char array and if the char has the same
       //element return false
       for(char i:Str){
           if(unique.contains(i)){
               return false;
           } else unique.add(i);
           
       }
       return true;
        
        
    }
    
    
}
