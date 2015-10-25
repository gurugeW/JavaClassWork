import edu.duke.*;
public class HelloPrinter
{
    public static void main(String[] args)
    { 
        
        System.out.println("Hello, World!");
    }

    public void runHello(){
        URLResource hello = new URLResource("http://www.dukelearntoprogram.com/java/hello_unicode.txt");
       //FileResource hello = new FileResource("Hello_unicode.txt");
        for(String line : hello.lines()){
            System.out.println(line);
        } 
     
    }
    
void Hello( ){
    System.out.println("Say hellow");
    String s ;
}

void URLprint(){
  URLResource webpage = new URLResource("http://www.dukelearntoprogram.com/java/somefile.txt");
  for (String w : webpage.words()){
    System.out.println(w);
    }
}
}
 