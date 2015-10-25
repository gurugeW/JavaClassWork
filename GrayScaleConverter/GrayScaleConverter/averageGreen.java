
/**
 * Write a description of averageGreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class averageGreen {

  //start with input image (inImage)
    public ImageResource makeGray(ImageResource inImage){
     // createing a blank image
     ImageResource outImage = new ImageResource (inImage.getWidth(), inImage.getHeight());
     //for each pixel outImage
     for (Pixel pixel: outImage.pixels()) {
     // loot at corresponding  pixel in inImage
     Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
     //compute the  inPixel's red + green + blue and devide by 3 (average)
     int average = (inPixel.getRed()  + inPixel.getBlue())/3 ;
       //set the pixel;s red green blue to average
       pixel.setRed(0);
       pixel.setGreen(average);
       pixel.setBlue(0);         
        }
       return outImage; 
    }
    
    public void selectAndConvert() {
     DirectoryResource dr = new DirectoryResource();   
     for (File f: dr.selectedFiles()) {
     ImageResource inImage = new ImageResource(f);
     String fname =inImage.getFileName();
      ImageResource gray = makeGray(inImage);
     // inImage = makeGray(inImage);
      gray.setFileName (f.getParent() + "\\gray-" + inImage.getFileName());
      System.out.println(gray.getFileName());
      gray.draw();
     // inImage.setFileName("gray-"+fname);
    //  gray.save();
      //inImage.draw();
    
    }
      
}
}
    
    