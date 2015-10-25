import edu.duke.*;
//import java.io.*;
public class UrlRes {
 public void findYoutube(){
   URLResource rl = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
   for (String line :rl.lines() ){
       String loLine=line.toLowerCase();
        //line = " http//www.youtube.com"; 
       String link = findLink(loLine,line);
       if(link.length()>1 ) {
         
       System.out.println(link);  
    
    }}
    }
     
    
    
    public String findLink(String low, String org ) {
       int tubeAt = (low.indexOf("youtube"));
       if(tubeAt > 1) {
           int start = 1 + org.lastIndexOf("\"", tubeAt);
         // int start = 1+ org.indexOf("\"");
          int end   = org.indexOf("\"",start );
         
        String link = org.substring(start,end);
       // System.out.println("=====" +link);
        if(link.startsWith("http")){       
       return link; }
       else {
             System.out.println(start + "          " + end);
           System.out.println(link);
           link = findLink(link,link);
           }
       }
     
     return "";
}
}