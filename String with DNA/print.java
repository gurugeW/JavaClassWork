
/**
 * Write a description of print here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class print {

 public void printAll() { 
     String  dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
     int start = 0; 
     while (true) { 
         int tag = dna .indexOf("ATG", start);
         if (tag == - 1) {  
             break;
            }
            //System.out.println("starts at " + tag ) ; 
            int end  =  findStopIndex(dna, tag );
           // System.out.println("end at  " + end);
            if(end != dna.length()){
             String s = dna.substring(tag, end + 3);  
        System.out.println(s);}
             start = tag + 3;
        }
    }
    
 public int findStopIndex(String dna, int index){
    dna = dna.toUpperCase();
    int stop1 = dna.indexOf("TGA", index);
    if(stop1 == -1 || (stop1-index) % 3 != 0) {
        stop1 = dna.length();      
    }
    int stop2 = dna.indexOf("TAA", index);
    if(stop2 == -1 || (stop2 - index) % 3 != 0 ){ 
        stop2 = dna.length(); 
    }
    int stop3 = dna.indexOf("TAG", index);
    if(stop3 == -1 || (stop3 - index) % 3 != 0) { 
        stop3 = dna.length();
    } 
    return Math.min(stop1, Math.min(stop2,stop3));
    
    
    
  }
  public void test () {
      System.out.println(t());
    }
  public float t( ) {
   int cgcount = 4; String dna = "xcxxxx";   
   System.out.println(dna.indexOf("c"));
 return ((float) cgcount)/dna.length();
    }
} 