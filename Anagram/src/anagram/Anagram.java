/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author amolsidhu
 */
public class Anagram {

   
    public static void main(String[] args) {

        String String1 = "anagram";
        String String2 = "managra";
        String dad="dadio";
        //System.out.print(hashmapCheckIfAnagram(String1, String2));
     //   System.out.println(checkIfPalindrome(dad));
       // System.out.println(hashsetPalindrome(dad));

         //System.out.println(checkIfUnique(dad));
         System.out.print(findMostUsedLetter("dad"));
    }
    
   private static char findMostUsedLetter(String s){
       char[] input =s.toCharArray();
       //make a hashmap
       Map<Character, Integer> mapLettersToCount = new HashMap<>();
        
       //now add the input string to the map with the count 
       for(char c: input){
           int count=1;
           if(mapLettersToCount.containsKey(c)){
               count = mapLettersToCount.get(c)+1;//update count by 1
           } else mapLettersToCount.put(c, count);
       }
       
       //Now search the map for the greatest counts
       int maxValueInMap= Collections.max(mapLettersToCount.values());

       for(Entry<Character,Integer>entry: mapLettersToCount.entrySet()){

           if(entry.getValue().equals(maxValueInMap)){
              System.out.println(entry.getKey());
           }
       }
       
       
       return 'c';
       
   }
    
    private static boolean checkIfUnique(String s1){
        char[] input= s1.toCharArray();
        //create hashset
        Set<Character> hashset = new HashSet<>();
       for(char c: input){
           if(hashset.contains(c)){
               return false;
           } else hashset.add(c);
       }
     
        
        return true;
            
        
    }
    
    
    
    public static boolean checkIfAnagram(String s1, String s2){
       char[] firstString= s1.toCharArray();
        char[] secondString= s2.toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);
       
        for(int i=0; i<firstString.length;i++){
            //check every character
            if(firstString[i]!=secondString[i]){
                return false;
            }
        }
        
        return true;
        
    }
    
    
    public static boolean hashsetPalindrome(String s1){
        char[] input= s1.toCharArray();
        //if you have a palindrome there should only be 1 or none characters that appear an odd # of times
        //so lets use a hashset to keep track by adding a character and removing it if we see it again
        //if at the end we have 0 or 1 in our set return true
        
        
        Set<Character> unpairedCharacters= new HashSet<>();
        
        for (char c:input){
            //if the char is in our set remove it else add it
            if(unpairedCharacters.contains(c)){
                unpairedCharacters.remove(c);
                
            }
            unpairedCharacters.add(c);
             }
        //if the size of our set is less than or equal to 1 we have a palindrome
        
        return unpairedCharacters.size()<=1;
        
    }
    //dad
    public static boolean checkIfPalindrome(String s1){
        char[] input= s1.toCharArray();
        String rev="";
        
        for(int i=input.length-1;i>=0;i--){
            rev= rev+ input[i];
        }
        if(rev.equals(s1)){
            return true;
        }
        return false;
    }
    
    public static boolean hashmapCheckIfAnagram(String s1, String s2){
        char[] word1= s1.toCharArray();
        char[] word2=s2.toCharArray();
        
        
        //create hashmap to 
        Map<Character, Integer> lettersinword1 = new HashMap<>();
        
        for(char c:word1){
            int count=1;
          //key
            if(lettersinword1.containsKey(c)){
                count=lettersinword1.get(c) +1;
            }
            lettersinword1.put(c, count);
        }
        
        for(char c:word2){
            //now we'll subtract the count from the hashmap
            //if it s a anagram the count should be 0 and the map is empty
            int count=-1;
            if(lettersinword1.containsKey(c)){
                count=lettersinword1.get(c)-1;
            }
            lettersinword1.put(c, count);
            
        }
        
        for(char c: lettersinword1.keySet()){
            if(lettersinword1.get(c)!=0){
                return false;
            }
        }
        
        
        
        
        
               
        return true;
        
    }
}
