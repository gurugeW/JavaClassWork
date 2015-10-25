import edu.duke.*;

public class FindStoreDnaData {

      
    public StorageResource storeAll(String dna) { 
        StorageResource  store = new StorageResource();
        int start = 0; 
        while (true) { 
            int tag = dna .indexOf("ATG", start);  // find the starting tag
          //  System.out.println("ATG at: " + tag);
            if (tag == - 1) {  // loop break if none found
                break;
            }
            int end  =  findStopIndex(dna, tag+3);     /* call the findStopIndex to passing dna string and 
            starting index location. will get back end pos of tags TGA, TAA or TAG        */
           // System.out.println( "end at : " + end);
            if(end != dna.length()){ // ignor if length of string is returned
                String s = dna.substring(tag, end + 3);  // creat a new substring of protein
                store.add(s);
                tag = end;
            }  // print the String
            start = tag + 3;
        }
        return store;
    }
     
     public int findStopIndex(String dna, int index){
        dna = dna.toUpperCase(); // conver to ALL CAPS
        int stop1 = dna.indexOf("TGA", index);  // find the loc of TGA after index pos
       
        if(stop1 == -1 || (stop1-index) % 3 != 0) { // check the text between ATG - TGA  is devisable by 3 
            stop1 = dna.length();    // it test fail set stop1 to dna.length();  
        }
        int stop2 = dna.indexOf("TAA", index);
        if(stop2 == -1 || (stop2 - index) % 3 != 0 ){ 
            stop2 = dna.length(); 
        }
        int stop3 = dna.indexOf("TAG", index);
        if(stop3 == -1 || (stop3 - index) % 3 != 0) { 
            stop3 = dna.length();
        } 
        
        int end =  Math.min(stop1, Math.min(stop2,stop3)); //return to smalles protein from 3
         
         return end;
    }
     
    
    
    
    public void printGenes(StorageResource sr) {
        int count = 0; int cg = 0; String longest = "";
        StorageResource cgRate = new StorageResource();
        for(String protein : sr.data()){
            //System.out.println(protein );
            if(protein.length() > longest.length() ) longest = protein;
            if(protein.length() > 60) {
                System.out.println(protein);
                count++;}
            if(cgRatio(protein)> 0.35 ){ 
                    System.out.println("CG ratio higher that .35 in : " + protein);
                    cg++;
                }
            
        }   
         System.out.println(sr.size());
        System.out.println("The protein greate than 60 is " + count);
        System.out.println("The CG count " + cg);
        System.out.println("longest length " +longest.length());

    }

         
  
    public void testStorageFinder(){
        FileResource file = new FileResource("GRch38dnapart.fa");
        String dna ="";//
        // dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
        for (String line : file.lines()) {
            line = line.toUpperCase();
            dna =line;
            //System.out.println(line);
            //System.out.println(line.length());
        }
        StorageResource s1 = storeAll(dna); 
        printGenes(s1);
        System.out.println(s1.size()); 
    }

    public float cgRatio(String dna) {
        //String dna = "abcgcd";
        dna = dna.toUpperCase();
        float cg = 0; 
        float cgRatio = 0 ;
        for (int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G' )  cg++;

        } 
        if(cg > 0 )  cgRatio = (cg/dna.length());
        return cgRatio;
    }

   
    
    public void testURL(){
        String dna ;
       //dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
       // dna = "ccatgccctaataaatgtctgtaatgtaga";
        dna = "ATGAAATGAAAA";
        dna = dna.toUpperCase();
        StorageResource s1 = storeAll(dna); 
        System.out.println(s1.size());  
        for(String protein : s1.data()){
            System.out.println(protein       );
        }

    }

    public void findCTG(){
        FileResource file = new FileResource("GRch38dnapart.fa");
        String s ="";//
        // dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
        for (String line : file.lines()) {
            line = line.toUpperCase();
            s =line;
            //System.out.println(line);
            //System.out.println(line.length());
        }
        int pos = 0; int ctg = 0;
        int start = 0;
      while(true){
          pos = s.indexOf("CTG",start); 
          if(pos == -1){ break;}
          else { ctg++; } 
          start = pos + 3; 
        }
        System.out.println( ctg);
    }
    
    
}
