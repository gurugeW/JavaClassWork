
/**
 * Write a description of TagFinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TagFinder2 {
    
    
    
  public String findProtein(String dna)
  { 
     dna = dna.toUpperCase();
     int start = dna.indexOf("ATG");// find the start codon ATG of dna string
     
     if(start == -1)   {  return "";    }
     
          
     if(  (dna.indexOf("TAG",start + 3) - start) % 3 == 0 ) {
         return dna.substring(start, dna.indexOf("TAG",start + 3)  +3);
        }
       
     else if ( (dna.indexOf("TGA",start + 3) - start) % 3 == 0 ) {
          return dna.substring(start, dna.indexOf("TGA",start + 3) +3);}
          
     else if ( (dna.indexOf("TAA",start + 3) - start) % 3 == 0 ) {
          return dna.substring(start, dna.indexOf("TAA",start + 3)   +3);} 
          else return "";
    } 
 
//public String stopCodon(string proten     
    
    
    
    
    
 public void testing()
 {
    for (int i = 0; i < 50; ++i) System.out.println();
    // String a = "cccatggggtttaaataatxaatagxgtga";
     String a = "cccatggggtttaaatag";
     // a = "ccatgxxxyytagtgaxtaa";
      //a = "AATGCTAGTTTAAATCTGA”;
      //a = "AATGCTAGTTTAAATCTGA";
      a = "AAATGCCCTAACTAGATTGAAACC";
     System.out.println( stopCodon( a));
      //   ataaactatgttttaaatgt
      //a = "ataaactatgttttaaatgt";
        String ap ="atggggtttaaatag";
    //String ap =" atggggtttaaataataatag";
     String result = findProtein(a);
     if(result.length() > 3){
         System.out.println("result is  " +result);
         System.out.println("end tag is : " + result.substring(result.length() - 3));
       }
       else System.out.println("nothing to show ");
       
}

public String stopCodon(String dna) {
    String answer = findProtein(dna);
    int size = answer.length();
    if ( size > 6 ) {
    return answer.substring(size - 3, size);
}
else {
    return "";
}
}
}

