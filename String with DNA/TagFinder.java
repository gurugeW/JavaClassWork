
/**
 * Write a description of TagFinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TagFinder {
  public String findProtein(String dna) {  
     int start = dna.indexOf("atg");
     if(start == -1)   {  return "";
        }
     int  stop = dna.indexOf("tag",start + 3);
     if(  (stop - start) % 3 == 0 ) {
         return dna.substring(start,stop+3);
        }
        else { return"";       }
    } 
    
    
 public void testing()
 {
    // String a = "cccatggggtttaaataatxaatagxgtga";
      String a = "cccatggggtttaaataatag";
     String ap =" atggggtttaaataataatag";
     String result = findProtein(a);
     if(ap.equals(result)){
         System.out.println("successs for " +ap); 
        } 
        else {
             System.out.println("mistake for input: "+a);
             System.out.println("got: " + result);
             System.out.println("not: " + ap);
            } 
        }
    
    
    
    
    
    
    
    
}

