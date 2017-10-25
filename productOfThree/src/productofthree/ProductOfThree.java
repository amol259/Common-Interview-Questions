/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productofthree;

/**
 *
 * @author amolsidhu
 */
public class ProductOfThree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] inputArray= {1,2,3,4,5};
        System.out.print(highestProductOf3(inputArray));
        
        
    }
    
    
    
    public static int highestProductOf3(int[] arrayOfInts){
        //we must start at index 2 (3rd item)
        //so we prepopulate highest and lowest for first 2
        int highest=Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest=Math.min(arrayOfInts[0], arrayOfInts[1]);
        
        int highestProductOfTwo = arrayOfInts[0]*arrayOfInts[1];
        int lowestProductOfTwo = arrayOfInts[0]*arrayOfInts[1];
        
        //prepopulate the first highest product of 3
        int highestProductOfThree = arrayOfInts[0]*arrayOfInts[1]*arrayOfInts[2];
        
      //walk through array starting at index 2
      for(int i=2;i<arrayOfInts.length;i++){
          int currentValue= arrayOfInts[i];
          
        
        highestProductOfThree= 
                Math.max(Math.max( highestProductOfThree,currentValue*highestProductOfTwo)
                 ,currentValue*lowestProductOfTwo
                
        );
        
         lowestProductOfTwo = Math.min(Math.min(
            lowestProductOfTwo,
            currentValue * highest),
            currentValue * lowest);

        
        highestProductOfTwo= Math.max(Math.max(highestProductOfTwo, currentValue*lowest), 
                currentValue*highest);
        
        highest = Math.max(currentValue, highest);
        
        lowest=Math.min(currentValue, lowest);
          
          
      }
        
        
        return highestProductOfThree;
        
}
}
