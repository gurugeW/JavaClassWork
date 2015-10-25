
/**
 * Write a description of FindStoreUrl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class FindStoreUrl {
    
    public StorageResource findURLs(String url) {
        StorageResource  store = new StorageResource();
        URLResource page = new URLResource(url);
        String source = page. asString();
        int start = 0;
        while (true) {
            int index = source.indexOf("href=",start);
            if(index == -1) { break; }
            //if 
            int firstQuote = index+6;
            int endQuote = source.indexOf("\"",firstQuote);
            String sub = source.substring(firstQuote, endQuote);
            if(sub.startsWith("http")){
                //System.out.println(sub);
                store.add(sub);
            }
            start = endQuote + 1;

    } 
   // System.out.println(store.size());
    return store;
}
public void testURL() {
    int https = 0, com = 0, endWcom = 0, dots = 0, i = 0;
  StorageResource  stor =  findURLs("http://www.dukelearntoprogram.com/course2/data/newyorktimes.html");
  System.out.println(" total is : " +stor.size());
  for( String link : stor.data()){
    dots = dots + dots(link);
   System.out.println(i + "  " + link);   
    if(link.contains("https")) { https++; }  
    if(link.contains(".com")) { com++; } 
    String temp1 =(link.substring(link.length() -4));
   // String temp2 =(link.substring(link.length() -5));
   // if (    temp1.equals(".com") || temp2.equals(".com/") ) { 
       if(temp1.contains("com")){
       endWcom++; 
        System.out.println(temp1);
}
        i++;
    }
     System.out.println(" total is : " +stor.size());
      System.out.println(" https is : " + https);
       System.out.println(" com is : " + com );
       System.out.println(" Endwithcom is : " + endWcom );
        System.out.println(" # of dots : " + dots);
}

 public int dots(String s ) {
     int start = 0, pos = 0, dots = 0 ;
    while(true){ 
      pos = s.indexOf("." ,start);   
      if(pos == -1) {break;  }
      else { dots++; }
      start = pos+1;  
    }
    return dots;
    }

}
